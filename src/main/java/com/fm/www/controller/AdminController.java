package com.fm.www.controller;

import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.lang.ProcessBuilder.Redirect;
import java.util.List;
import java.util.UUID;

import javax.servlet.ServletContext;
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
import com.fm.www.dto.Photo;
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
	public void mainGet() {		
		
		
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
			
			return "redirect:/admin/index";
			
		}else{
			System.out.println("로그인실패");
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
	public String adminBoardGet(String board_div, Model model, String search, String word, Board_tb board, @RequestParam(defaultValue = "1")int curPage) {		
		
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
	public String noticeWritePost(Model model, Admin admin, MultipartFile file, HttpSession session, Board_tb board_tb, Photo photo, int board_div) {		
		
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
		System.out.println(board_tb);

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
   public void adminBoardUpdateGet(int board_no, Board_tb board, Model model, int board_div, Photo photo) {    
	   // 이전 글 가져오기
	   board = adminService.boardUpdate(board_no);
	   // 이전 파일 가져오기
	   photo = adminService.photoUpdate(photo);
	   
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
   public String adminBoardUpdatePOST(int board_div, int board_no, Board_tb board, MultipartFile file, Photo photo, HttpSession session) {    
	  
	  //파일첨부 존재 여부
      int photo_no = adminService.adminPhotoCheck(board_no);
      if(!"".equals(file.getOriginalFilename())&& file.getOriginalFilename()!=null) {
         if(photo_no!=0) {
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
            board.setBoard_no(board_no);
            //세션번호넣어주기
            int user_no = (int) session.getAttribute("user_no");
            board.setUser_no(user_no);
         
            //수정 글쓰기
            adminService.adminBoardWrite(board);
            //파일첨부
            adminService.adminPhotoWrite(photo);
         }
      }else {
            //수정 글쓰기
            adminService.adminBoardWrite(board);
      }
	   
	   return "redirect:/admin/board?board_div=" + board_div;
   }
}













