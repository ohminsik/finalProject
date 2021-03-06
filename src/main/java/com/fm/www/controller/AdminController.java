
package com.fm.www.controller;

import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.UUID;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.fm.www.dto.Admin;
import com.fm.www.dto.Board_tb;
import com.fm.www.dto.Ground;
import com.fm.www.dto.Photo;
import com.fm.www.dto.Team;
import com.fm.www.dto.Tournament;
import com.fm.www.dto.User;
import com.fm.www.service.face.AdminService;
import com.fm.www.util.Paging;


@Controller
public class AdminController {
   private static final Logger logger = LoggerFactory.getLogger(AdminController.class);
   
   @Autowired AdminService adminService;
   @Autowired ServletContext context;
   /*
    * Admin 컨트롤러
    * Admin 창 띄우기
    * GET
    * */
   @RequestMapping(value = "/admin/index", method = RequestMethod.GET)
   public void mainGet(Model model) {      
   
      SimpleDateFormat mSimpleDateFormat = new SimpleDateFormat ( "yyyy.MM.dd HH:mm:ss", Locale.KOREA );
      Date currentTime = new Date ();
      String mTime = mSimpleDateFormat.format ( currentTime );

      //오늘 가입 인원
      int todayJoinCnt = adminService.todayJoinCnt(currentTime);
      //전체 가입 인원
      int totalJoinCnt = adminService.totalJoinCnt();
      //오늘 매치 등 록 수
      int todayMatchCnt = adminService.todayMatchCnt();
      //오늘 매칭 된 수
      int totalMatchCnt = adminService.totalMatchCnt();
      
      model.addAttribute("todayJoinCnt",todayJoinCnt);
      model.addAttribute("totalJoinCnt",totalJoinCnt);
      model.addAttribute("todayMatchCnt",todayMatchCnt);
      model.addAttribute("totalMatchCnt",totalMatchCnt);
      
   }
   
   /*
    * Admin login 컨트롤러
    * Admin login 창 띄우기
    * GET
    * */
   @RequestMapping(value = "/admin/login", method = RequestMethod.GET)
   public void loginGet() {      
   
   }
   /*
    * Admin login 하기
    * Admin 창 띄우기
    * POST
    * */
   @RequestMapping(value = "/admin/login", method = RequestMethod.POST)
   public String loginPost(Model model, Admin admin, HttpSession session, HttpServletResponse resp) {      
      logger.info(""+admin);
      //로그인
      boolean admin_yn = adminService.loginYN(admin);
      
      if(admin_yn) {
         System.out.println("로그인성공");
         // 로그인 닉네임 가져오기
         int admin_no = adminService.getAdminNo(admin);
         session.setAttribute("AdminloginYN", true);
         session.setAttribute("admin_no", admin_no);
         session.setAttribute("admin_id", admin.getAdmin_id());
         return "redirect:/admin/index";
         
      }else{
         System.out.println("로그인실패");
         session.setAttribute("AdminloginYN", false);
         return "redirect:/admin/login";
      }
   }
   /*
    * Admin logout 컨트롤러
    * Admin login 창 띄우기
    * GET
    * */
   @RequestMapping(value = "/admin/logout", method = RequestMethod.GET)
   public String logoutGet(HttpSession session) {      
      session.invalidate();
      
      //로그아웃 후 main으로
      return"redirect:/admin/login";
   }
      
   /*
    * Admin Board 컨트롤러
    * Admin board 띄우기
    * GET
    * */
   @RequestMapping(value = "/admin/board", method = RequestMethod.GET)
   public String adminBoardGet(String board_div, Model model, String search, String word, Board_tb board, @RequestParam(defaultValue = "1")int curPage, HttpSession session) {      
      System.out.println("board_div" + board_div);
      // 게시글 전체 수 
      int totalCount = adminService.boardTotalCount(search, word, board_div);
      System.out.println(totalCount);
      if(totalCount == 0) {
         model.addAttribute("totalCount", totalCount);
      }
      
      // 게시글 페이징 처리
      Paging paging = new Paging(totalCount, curPage);
      System.out.println("paging" + paging);
      // 게시판 페이징 리스트 처리
      List <Board_tb> list = adminService.boardGetList(paging, search, word, board_div);
      
      // 댓글 갯수 구하기
      for(int i=0; i<list.size(); i++) {
         list.get(i).setBoard_reply_cnt(adminService.boardreplyCount(list.get(i).getBoard_no()));
      }
      int admin_no = (int) session.getAttribute("admin_no");
      
      model.addAttribute("admin_no", admin_no);
      model.addAttribute("paging", paging);
      model.addAttribute("search", search);
      model.addAttribute("word", word);
      model.addAttribute("list", list);
      model.addAttribute("board_div", board_div);
      
      return "/admin/board/notice";
   }
   
   /*
    * Admin BoardWrite 컨트롤러
    * Admin boardWrite 띄우기
    * GET
    * */
   @RequestMapping(value = "/admin/board/write", method = RequestMethod.GET)
   public void noticeWriteGet(int board_div, Model model) {      
      model.addAttribute("board_div", board_div);
   }
   /*
    * Admin BoardWrite 컨트롤러
    * Admin boardWrite 띄우기
    * POST
    * */
   @RequestMapping(value = "/admin/board/write", method = RequestMethod.POST)
   public String noticeWritePost(Model model, Admin admin, MultipartFile file, HttpSession session, Board_tb board_tb, Photo photo, int board_div, HttpServletRequest request, Ground ground,Tournament tournament) {      
      
      if(board_div != 10 && board_div != 9 ){
         if (!"".equals(file.getOriginalFilename()) && file.getOriginalFilename() != null) {
            // 고유식별자
            String uId = UUID.randomUUID().toString().split("-")[0];

            // 저장될 파일 이름
            String stored_name = null;
            stored_name = file.getOriginalFilename() + "_" + uId;
            // stored_name =file.getOriginalFilename();

            // 파일 저장 경로
            String path = context.getRealPath("uploadImg");

            // 저장될 파일
            File dest = new File(path, stored_name);

            // 파일업로드
            try {
               file.transferTo(dest);
            } catch (IllegalStateException e) {
               // TODO Auto-generated catch block
               e.printStackTrace();
            } catch (IOException e) {
               // TODO Auto-generated catch block
               e.printStackTrace();
            }
            photo.setPhoto_origin(file.getOriginalFilename());
            photo.setPhoto_stored(stored_name);

            // 관리자 게시판 글 번호 생성하기
            int board_no = adminService.adminGetBoard_no();
            
            // 관리자 게시판 관라지 번호 받아오기
            board_tb.setAdmin_no((int) session.getAttribute("admin_no"));
            board_tb.setBoard_no(board_no);
            photo.setBoard_no(board_no);
            adminService.adminInsertWrite1(board_tb, board_div);
            adminService.adminInsertPhoto(photo, board_div);
         } else {
            // 관리자 게시판 관리자 번호 받아오기
            board_tb.setAdmin_no((int) session.getAttribute("admin_no"));
            // 관리자 게시판 이미지 파일 없이 글 작성
            adminService.adminInsertWrite2(board_tb);
         }
      
      // 경기장 리스트 작성할 때    
      } else if(board_div == 10) {
         if (!"".equals(file.getOriginalFilename()) && file.getOriginalFilename() != null) {
            // 고유식별자
            String uId = UUID.randomUUID().toString().split("-")[0];

            // 저장될 파일 이름
            String stored_name = null;
            stored_name = file.getOriginalFilename() + "_" + uId;
            // stored_name =file.getOriginalFilename();

            // 파일 저장 경로
            String path = context.getRealPath("uploadImg");

            // 저장될 파일
            File dest = new File(path, stored_name);

            // 파일업로드
            try {
               file.transferTo(dest);
            } catch (IllegalStateException e) {
               // TODO Auto-generated catch block
               e.printStackTrace();
            } catch (IOException e) {
               // TODO Auto-generated catch block
               e.printStackTrace();
            }
            photo.setPhoto_origin(file.getOriginalFilename());
            photo.setPhoto_stored(stored_name);

            // 관리자 게시판 글 번호 생성하기
            int board_no = adminService.adminGetBoard_no();
            
            // 관리자 게시판 관리자 번호 받아오기
            board_tb.setAdmin_no((int) session.getAttribute("admin_no"));
            board_tb.setBoard_no(board_no);
            photo.setBoard_no(board_no);
            ground.setBoard_no(board_no);
            // 경기장 주소 받아오기
            String address1 = request.getParameter("user_address1");
            String address2 = request.getParameter("user_address2");
            String address =  address2 + " " + address1;
            String groundName = request.getParameter("user_address3");
            System.out.println(address + groundName);
            ground.setGround_addr(address);
            ground.setGround_name(groundName);
            adminService.adminInsertWrite1(board_tb, board_div);
            adminService.adminInsertPhoto(photo, board_div);
            adminService.adminInsertGround(ground, board_div);
         } else {
            // 관리자 게시판 관리자 번호 받아오기
            board_tb.setAdmin_no((int) session.getAttribute("admin_no"));
            
            // 관리자 게시판 글 번호 생성하기
            int board_no = adminService.adminGetBoard_no();
            board_tb.setBoard_no(board_no);
            ground.setBoard_no(board_no);
            // 관리자 게시판 이미지 파일 없이 글 작성
            // 경기장 주소 받아오기
            String address1 = request.getParameter("user_address1");
            String address2 = request.getParameter("user_address2");
            String address = address2 + " " + address1;
            String groundName = request.getParameter("user_address3");
            System.out.println(address + groundName);
            ground.setGround_addr(address);
            ground.setGround_name(groundName);
            
            adminService.adminInsertWrite1(board_tb, board_div);
            adminService.adminInsertGround(ground, board_div);
            
         }
      }else if(board_div == 9) {
         if (!"".equals(file.getOriginalFilename()) && file.getOriginalFilename() != null) {
            // 고유식별자
            String uId = UUID.randomUUID().toString().split("-")[0];

            // 저장될 파일 이름
            String stored_name = null;
            stored_name = file.getOriginalFilename() + "_" + uId;

            // 파일 저장 경로
            String path = context.getRealPath("uploadImg");

            // 저장될 파일
            File dest = new File(path, stored_name);

            // 파일업로드
            try {
               file.transferTo(dest);
            } catch (IllegalStateException e) {
               e.printStackTrace();
            } catch (IOException e) {
               e.printStackTrace();
            }
            photo.setPhoto_origin(file.getOriginalFilename());
            photo.setPhoto_stored(stored_name);

            // 관리자 게시판 글 번호 생성하기
            int board_no = adminService.adminGetBoard_no();
            
            // 관리자 게시판 관라지 번호 받아오기
            board_tb.setAdmin_no((int) session.getAttribute("admin_no"));
            board_tb.setBoard_no(board_no);
            photo.setBoard_no(board_no);
            tournament.setBoard_no(board_no);
            // DateFormate 함수 선언
             SimpleDateFormat fmt = new SimpleDateFormat("yyyy/MM/dd");
             Date con_reg_dates = new Date();
             Date con_reg_datee = new Date();
             Date con_con_dates = new Date();
             Date con_con_datee = new Date();
            // parameter 값 받기
            String selDate1 = request.getParameter("con_reg_dates");
            String selDate2 = request.getParameter("con_reg_datee");
            String selDate3 = request.getParameter("con_con_dates");
            String selDate4 = request.getParameter("con_con_datee");
            // date로 변환
            try {
               con_reg_dates = fmt.parse(selDate1);
               con_reg_datee = fmt.parse(selDate2);
               con_con_dates = fmt.parse(selDate3);
               con_con_datee = fmt.parse(selDate4);
            } catch (ParseException e) {
               e.printStackTrace();
            }
            //대회 일정 내용 등록
            tournament.setCon_reg_dates(con_reg_dates);
            tournament.setCon_reg_datee(con_reg_datee);
            tournament.setCon_con_dates(con_con_dates);
            tournament.setCon_con_datee(con_con_datee);
            
            adminService.adminInsertWrite1(board_tb, board_div);
            adminService.adminInsertPhoto(photo, board_div);
            adminService.tournamentInsert1(tournament);
            
         } else {
            // 관리자 게시판 관리자 번호 받아오기
            board_tb.setAdmin_no((int) session.getAttribute("admin_no"));
            int board_no = adminService.adminGetBoard_no();
            board_tb.setBoard_no(board_no);
            tournament.setBoard_no(board_no);
            
            // DateFormate 함수 선언
             SimpleDateFormat fmt = new SimpleDateFormat("yyyy/MM/dd");
             Date con_reg_dates = new Date();
             Date con_reg_datee = new Date();
             Date con_con_dates = new Date();
             Date con_con_datee = new Date();
            // parameter 값 받기
            String selDate1 = request.getParameter("con_reg_dates");
            String selDate2 = request.getParameter("con_reg_datee");
            String selDate3 = request.getParameter("con_con_dates");
            String selDate4 = request.getParameter("con_con_datee");
            logger.info(selDate1);
            // date로 변환
            try {
               con_reg_dates = fmt.parse(selDate1);
               con_reg_datee = fmt.parse(selDate2);
               con_con_dates = fmt.parse(selDate3);
               con_con_datee = fmt.parse(selDate4);
            } catch (ParseException e) {
               e.printStackTrace();
            }
            //대회 일정 내용 등록
            tournament.setCon_reg_dates(con_reg_dates);
            tournament.setCon_reg_datee(con_reg_datee);
            tournament.setCon_con_dates(con_con_dates);
            tournament.setCon_con_datee(con_con_datee);
            
            // 관리자 게시판 이미지 파일 없이 글 작성
            adminService.adminInsertWrite1(board_tb,board_div);
            adminService.tournamentInsert1(tournament);
      
         }

   }
      return "redirect:/admin/board?board_div=" + board_div;
}   

      /*
      * Admin BoardDelete 컨트롤러
      * 관리자 게시글 삭제 처리
      * GET
      * */
      @RequestMapping(value = "/admin/boardDelete", method = RequestMethod.GET)
      public String adminBoardDeleteGet(String board_no, int board_div) {      
         
            String[] board_no1 = board_no.toString().split(",");
             for (int i = 0; i < board_no1.length; i++) {
                 
                   adminService.boardDelete(Integer.parseInt(board_no1[i]));
             }
      
         
         return "redirect:/admin/board?board_div=" + board_div;
      }
   
   /*
    * Admin BoardUpdate 컨트롤러
    * 관리자 게시글 수정 처리
    * GET
    * */
   @RequestMapping(value = "/admin/board/update", method = RequestMethod.GET)
   public void adminBoardUpdateGet(int board_no, Board_tb board, Model model, int board_div, Photo photo,Tournament tournament) {    
      // 이전 글 가져오기
      board = adminService.boardUpdate(board_no);
      // 이전 파일 가져오기
      photo = adminService.photoUpdate(photo);
      if(board_div == 9) {
         // 이전 대회 가져오기
         tournament = adminService.tournamentUpdate(tournament);
         model.addAttribute("tournament", tournament);
         model.addAttribute("photo", photo);
         model.addAttribute("board_div", board_div);
         model.addAttribute("board", board);
      }
      model.addAttribute("photo", photo);
      model.addAttribute("board_div", board_div);
      model.addAttribute("board", board);
   }
   
   /*
    * Admin BoardUpdate 컨트롤러
    * 관리자 게시글 수정 처리
    * GET
    * */
   @RequestMapping(value = "/admin/board/update", method = RequestMethod.POST)
   public String adminBoardUpdatePOST(int board_div, int board_no, Board_tb board, MultipartFile file,HttpServletRequest request, Photo photo, HttpSession session,Tournament tournament) {    
     
     //파일첨부 존재 여부
      int photo_no = adminService.adminPhotoCheck(board_no);
      if(!"".equals(file.getOriginalFilename())&& file.getOriginalFilename()!=null) {
         if(photo_no==1) {
            //고유식별자
            String uId = UUID.randomUUID().toString().split("-")[0];
      
            //저장될 파일 이름
            String stored_name = null;
            stored_name =file.getOriginalFilename()+"_"+uId;
            
                        
            //파일 저장 경로      
            String path = context.getRealPath("uploadImg");
            
            //저장될 파일
            File dest = new File(path, stored_name);
            System.out.println("파일경로"+dest);
            //파일업로드
            try {
               file.transferTo(dest);
            } catch (IllegalStateException e) {
               // TODO Auto-generated catch block
               e.printStackTrace();
            } catch (IOException e) {
               
               e.printStackTrace();
            }
            photo.setPhoto_origin(file.getOriginalFilename());
            photo.setPhoto_stored(stored_name);
         
            board.setBoard_no(board_no);
            photo.setBoard_no(board_no);
            
            if(board_div == 9 ) {
               //대회일정 불러오기
               // DateFormate 함수 선언
             SimpleDateFormat fmt = new SimpleDateFormat("yyyy/MM/dd");
             Date con_reg_dates = new Date();
             Date con_reg_datee = new Date();
             Date con_con_dates = new Date();
             Date con_con_datee = new Date();
            // parameter 값 받기
            String selDate1 = request.getParameter("con_reg_dates");
            String selDate2 = request.getParameter("con_reg_datee");
            String selDate3 = request.getParameter("con_con_dates");
            String selDate4 = request.getParameter("con_con_datee");
            logger.info(selDate1);
            // date로 변환
            try {
               con_reg_dates = fmt.parse(selDate1);
               con_reg_datee = fmt.parse(selDate2);
               con_con_dates = fmt.parse(selDate3);
               con_con_datee = fmt.parse(selDate4);
            } catch (ParseException e) {
               e.printStackTrace();
            }
            //대회 일정 내용 등록
            tournament.setCon_reg_dates(con_reg_dates);
            tournament.setCon_reg_datee(con_reg_datee);
            tournament.setCon_con_dates(con_con_dates);
            tournament.setCon_con_datee(con_con_datee);
            logger.info(selDate1);
            logger.info(selDate2);
            logger.info(selDate3);
            logger.info(selDate4);
            
            board.setBoard_no(board_no);
               photo.setBoard_no(board_no);
               tournament.setBoard_no(board_no);
               //대회 수정
               adminService.adminTournamentWrite(tournament);   
               
               //수정 글쓰기
               adminService.adminBoardWrite(board);
               
               //수정 파일첨부
               adminService.adminPhotoWrite(photo);
            }
            //수정 글쓰기
            adminService.adminBoardWrite(board);
            //수정 파일첨부
            adminService.adminPhotoWrite(photo);
            
         }else if(photo_no==0){
            //고유식별자
            String uId = UUID.randomUUID().toString().split("-")[0];
      
            //저장될 파일 이름
            String stored_name = null;
            stored_name =file.getOriginalFilename()+"_"+uId;
            
                        
            //파일 저장 경로      
            String path = context.getRealPath("uploadImg");
            
            //저장될 파일
            File dest = new File(path, stored_name);
            System.out.println("파일경로"+dest);
            //파일업로드
            try {
               file.transferTo(dest);
            } catch (IllegalStateException e) {
               // TODO Auto-generated catch block
               e.printStackTrace();
            } catch (IOException e) {
               
               e.printStackTrace();
            }
            photo.setPhoto_origin(file.getOriginalFilename());
            photo.setPhoto_stored(stored_name);
         
            board.setBoard_no(board_no);
            photo.setBoard_no(board_no);
            if(board_div == 9 ) {
               
               // DateFormate 함수 선언
               SimpleDateFormat fmt = new SimpleDateFormat("yyyy/MM/dd");
               Date con_reg_dates = new Date();
               Date con_reg_datee = new Date();
               Date con_con_dates = new Date();
               Date con_con_datee = new Date();
               // parameter 값 받기
               String selDate1 = request.getParameter("con_reg_dates");
               String selDate2 = request.getParameter("con_reg_datee");
               String selDate3 = request.getParameter("con_con_dates");
               String selDate4 = request.getParameter("con_con_datee");
               logger.info(selDate1);
               // date로 변환
               try {
                  con_reg_dates = fmt.parse(selDate1);
                  con_reg_datee = fmt.parse(selDate2);
                  con_con_dates = fmt.parse(selDate3);
                  con_con_datee = fmt.parse(selDate4);
               } catch (ParseException e) {
                  e.printStackTrace();
               }
               //대회 일정 내용 등록
               tournament.setCon_reg_dates(con_reg_dates);
               tournament.setCon_reg_datee(con_reg_datee);
               tournament.setCon_con_dates(con_con_dates);
               tournament.setCon_con_datee(con_con_datee);   
               
               board.setBoard_no(board_no);
               photo.setBoard_no(board_no);
               tournament.setBoard_no(board_no);
               //대회 수정
               adminService.adminTournamentWrite(tournament);   
               
               //수정 글쓰기
               adminService.adminBoardWrite(board);
               
               //수정 파일첨부
               adminService.adminPhotoWrite(photo);
            }            
            //수정 글쓰기
            adminService.adminBoardWrite(board);
            //파일첨부
            adminService.adminInsertPhoto(photo, board_div);
         }
      }else {
    	  if(board_div==9) {
    		  // DateFormate 함수 선언
              SimpleDateFormat fmt = new SimpleDateFormat("yyyy/MM/dd");
              Date con_reg_dates = new Date();
              Date con_reg_datee = new Date();
              Date con_con_dates = new Date();
              Date con_con_datee = new Date();
              // parameter 값 받기
              String selDate1 = request.getParameter("con_reg_dates");
              String selDate2 = request.getParameter("con_reg_datee");
              String selDate3 = request.getParameter("con_con_dates");
              String selDate4 = request.getParameter("con_con_datee");
              logger.info(selDate1);
              // date로 변환
              try {
                 con_reg_dates = fmt.parse(selDate1);
                 con_reg_datee = fmt.parse(selDate2);
                 con_con_dates = fmt.parse(selDate3);
                 con_con_datee = fmt.parse(selDate4);
              } catch (ParseException e) {
                 e.printStackTrace();
              }
              //대회 일정 내용 등록
              tournament.setCon_reg_dates(con_reg_dates);
              tournament.setCon_reg_datee(con_reg_datee);
              tournament.setCon_con_dates(con_con_dates);
              tournament.setCon_con_datee(con_con_datee);   
              
              board.setBoard_no(board_no);
              photo.setBoard_no(board_no);
              tournament.setBoard_no(board_no);
              //대회 수정
              adminService.adminTournamentWrite(tournament);  
              
              //수정 글쓰기
              adminService.adminBoardWrite(board);
              
    	  }
          //수정 글쓰기
          adminService.adminBoardWrite(board);
    }
      return "redirect:/admin/board?board_div=" + board_div;
   }
   /*
    * Admin adminMemManagement 컨트롤러
    * 관리자 유저 관리
    * GET
    * */
   @RequestMapping(value = "/admin/memManagement", method = RequestMethod.GET)
   public void adminManagementGET(User user, String search, String word, Model model, @RequestParam(defaultValue = "1")int curPage) {
   
      // 유저 토탈 카운트
      int totalCount = adminService.memTotalCount(search, word, user);
      if(totalCount == 0) {
         model.addAttribute("totalCount", totalCount);
      }
      //게시글 페이징 처리
      Paging paging = new Paging(totalCount, curPage);

      // 게시판 페이징 리스트 처리
      List <User> list = adminService.userGetList(paging, search, word);
      
      model.addAttribute("list", list);
      model.addAttribute("search", search);
      model.addAttribute("word", word);
      model.addAttribute("paging", paging);
   }

   /*
   * Admin memTManagement Delete 컨트롤러
   * 관리자 유저 삭제 처리
   * GET
   * */
   @RequestMapping(value = "/admin/memManagement/delete", method = RequestMethod.GET)
   public String adminManagementDeleteGET(String user_no) {
      String[] user_no1 = user_no.toString().split(",");
       for (int i = 0; i < user_no1.length; i++) {
           
             adminService.userDelete(Integer.parseInt(user_no1[i]));
       }
       return "redirect:/admin/memManagement";
   }
   
   
   /*
    * Admin adminTeamManagement 컨트롤러
    * 관리자 유저 관리
    * GET
    * */
   @RequestMapping(value = "/admin/teamManagement", method = RequestMethod.GET)
   public void adminTeamManagementGET(Team team, String search, String word, Model model, @RequestParam(defaultValue = "1")int curPage) {
   
      // 유저 토탈 카운트
      int totalCount = adminService.teamTotalCount(search, word, team);
      if(totalCount == 0) {
         model.addAttribute("totalCount", totalCount);
      }
      //게시글 페이징 처리
      Paging paging = new Paging(totalCount, curPage);

      // 게시판 페이징 리스트 처리
      List <Team> list = adminService.teamGetList(paging, search, word);
      
      model.addAttribute("list", list);
      model.addAttribute("search", search);
      model.addAttribute("word", word);
      model.addAttribute("paging", paging);
   }
   
   /*
     * Admin teamTManagement Delete 컨트롤러
     * 관리자 유저 삭제 처리
     * GET
     * */
     @RequestMapping(value = "/admin/teamManagement/delete", method = RequestMethod.GET)
     public String adminTeamManagementDeleteGET(String team_no) {
        String[] team_no1 = team_no.toString().split(",");
       
         for (int i = 0; i < team_no1.length; i++) {
             
               adminService.teamDelete(Integer.parseInt(team_no1[i]));
         }
         return "redirect:/admin/teamManagement";
     }
   
   
   
   
}












