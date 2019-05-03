package com.fm.www.controller;

import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

import com.fm.www.dto.Board_Reply;
import com.fm.www.dto.Board_tb;
import com.fm.www.dto.Message;
import com.fm.www.dto.Photo;
import com.fm.www.dto.Team;
import com.fm.www.dto.User;
import com.fm.www.service.face.MypageService;
import com.fm.www.util.Paging;

@Controller
public class MypageController {
	private static final Logger logger = LoggerFactory.getLogger(MypageController.class);
	@Autowired ServletContext context;
	@Autowired MypageService mypageService;
	/*----------------------------------------------Mypage mypage Start----------------------------------------------*/
	
	/*
	 * 내정보
	 * 내정보 창 띄우기
	 * GET
	 * */
	@RequestMapping(value = "/mypage/mypageInformation", method = RequestMethod.GET)
	public void mypageInformationGet(HttpSession session, Model model) {		
		//세션에서 유저 넘버 받아오기
		User user = new User();
		user.setUser_no((int)(session.getAttribute("user_no")));
		
		user = mypageService.selectUserInformation(user.getUser_no());
		
		model.addAttribute("userinfo",user);
	}
	
	/*
	 * 비밀번호 변경 AJAX로 PW맞는지 체크
	 * */
	@RequestMapping(value = "/mypage/checkPw", method = RequestMethod.POST)
	public String checkId(HttpServletRequest request, HttpSession session, Model model) throws Exception{
		//세션에서 유저 넘버 받아오기
		User user = new User();
		user.setUser_no((int)(session.getAttribute("user_no")));
		user.setUser_pw(request.getParameter("inputpw"));
		
        //user_no과 user_pw으로 패스워드가 현재꺼와 맞는지 조회
        int rowcount = mypageService.checkPw(user);
        
        Map map = new HashMap();
		map.put("data",rowcount);			
		
		model.addAllAttributes(map);
        return "jsonView";
	}
	
	/*
	 * 비밀번호 변경 처리
	 * */
	@RequestMapping(value = "/mypage/pwChange", method = RequestMethod.POST)
	public String pwChange(User user, HttpSession session, Model model) {
		//세션에서 유저 넘버 받아오기
		user.setUser_no((int)(session.getAttribute("user_no")));
		
		//비밀번호 업데이트
		mypageService.pwChange(user);
		
		Map map = new HashMap();
		map.put("url","/mypage/mypageInformation");			
		
		model.addAllAttributes(map);
        return "jsonView";
		
	}
	
	/*
	 * 내정보
	 * 내정보 수정 창 띄우기
	 * GET
	 * */
	@RequestMapping(value = "/mypage/mypageInformationUpdate", method = RequestMethod.GET)
	public void mypageInformationUpdateGet(HttpSession session, Model model) {		
		//세션에서 유저 넘버 받아오기
		User user = new User();
		user.setUser_no((int)(session.getAttribute("user_no")));
		
		user = mypageService.selectUserInformation(user.getUser_no());
		
		String email = user.getUser_email();
		String[] emailArray = email.split("@");
		String email1 = emailArray[0];
		String email2 = emailArray[1];
		
		String phone = user.getUser_phone();
		String[] phoneArray = phone.split("-");
		String phone0 = phoneArray[0];
		String phone1 = phoneArray[1];
		String phone2 = phoneArray[2];
		
		String region = user.getUser_region();
		
		
		model.addAttribute("region", region);
		
		model.addAttribute("phone0", phone0);		
		model.addAttribute("phone1", phone1);		
		model.addAttribute("phone2", phone2);
		
		model.addAttribute("email1", email1);		
		model.addAttribute("email2", email2);
				
		model.addAttribute("userinfo",user);
	}
	
	/*
	 * 내정보
	 * 내정보 처리
	 * POST
	 * */
	@RequestMapping(value = "/mypage/mypageInformationUpdate", method = RequestMethod.POST)
	public String mypageInformationUpdatePost(User user, HttpServletRequest request, HttpSession session) {
		
		user.setUser_no((int)(session.getAttribute("user_no")));
		
		try {
			request.setCharacterEncoding("utf-8");
		} catch (UnsupportedEncodingException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		
		String email1 = request.getParameter("user_email");
		String email2 = request.getParameter("user_email1");
		String email = email1 + "@" + email2;
		user.setUser_email(email);
		
		String phone1 = request.getParameter("user_phone1");
		String phone2 = request.getParameter("user_phone2");
		String phone3 = request.getParameter("user_phone3");
		String phone = phone1 + "-" + phone2 + "-" + phone3;
		user.setUser_phone(phone);
		
		mypageService.updateMemberInfo(user);
		
		return "redirect:/mypage/mypageInformationUpdate";
		
	}
	
	/*
	 * 개인메세지
	 * 게인매세지 창 띄우기
	 * GET
	 * */
	@RequestMapping(value = "/mypage/mypagepersonalMessage", method = RequestMethod.GET)
	public void mypagepersonalMessageGet(HttpSession session, Model model) {	
		User user = new User();
		
		//유저번호 세션에서 얻어와서 넣어주기
		user.setUser_no((int)(session.getAttribute("user_no")));
		
		//내게 온 메세지 리스트 조회
		List<Message> messageList = mypageService.selectMessage(user);
		
		//내게 온 메세지 보낸사람 정보 조회
		for(int i=0; i<messageList.size(); i++) {
			messageList.get(i).setSenduser_id((mypageService.getSendUserId(messageList.get(i).getSenduser_no())));
			messageList.get(i).setSenduser_name((mypageService.getSendUserName(messageList.get(i).getSenduser_no())));
		}
		
		model.addAttribute("user",user);
		model.addAttribute("messageList", messageList);	
		
	}
	
	/*
	 * 개인메세지
	 * 게인매세지 확인으로 바꾸기 
	 * POST
	 * */
	@RequestMapping(value = "/mypage/MessageYN", method = RequestMethod.POST)
	public String MessageYNPost(HttpServletRequest request, Model model) {	
		int messageno = Integer.parseInt(request.getParameter("messageno"));
		
		mypageService.updateMessageYn(messageno);
		
		return "jsonView";
		
	}
	/*
	 * 개인메세지
	 * 게인매세지 삭제 
	 * POST
	 * */
	@RequestMapping(value = "/mypage/MessageDelete", method = RequestMethod.POST)
	public String MessageDeletePost(HttpServletRequest request, Model model) {	
		int messageno = Integer.parseInt(request.getParameter("messageno"));
		
		mypageService.deleteMessage(messageno);
		
		return "jsonView";
		
	}
	
	/*
	 * 개인메세지
	 * 게인매세지 답장보내기 
	 * POST
	 * */
	@RequestMapping(value = "/mypage/replyMessage", method = RequestMethod.POST)
	public String replyMessagePost(Message message) {	
		
		//개인메세지 답장
		mypageService.replyMessage(message);
		
		return "redirect:/mypage/mypagepersonalMessage";
	}
	
	
	
	
	
	/*
	 * 내가쓴 게시글 리스트
	 * 내가쓴 게시글 창 띄우기
	 * GET
	 * */
	@RequestMapping(value = "/mypage/mypageBoardList", method = RequestMethod.GET)
	public void mypageBoardListGet(Model model, String cur, String search_div, String search_word, HttpSession session) {
		User user = new User();
		user.setUser_no((int)(session.getAttribute("user_no")));
		
		//현재 페이지 번호 얻기
		int curPage = mypageService.getCurPage(cur);
		
		//총 게시글 수 얻기
		int totalCount = mypageService.getTotalCountSearch(user,search_div,search_word);

		//페이지 객체 생성
		Paging paging = new Paging(totalCount, curPage);
		
		
		//게시글목록 MODEL로 추가
		List<Board_tb> mypageboardList = mypageService.getPagingListSearch(user,paging, search_div, search_word);
		
		for(int i=0; i<mypageboardList.size(); i++) {
			mypageboardList.get(i).setBoard_reply_cnt(mypageService.getBoardReplyCnt(mypageboardList.get(i).getBoard_no()));
		}
		
		int tableNum = totalCount - (curPage - 1) * 10;		
		
		model.addAttribute("search_div", search_div);
		model.addAttribute("search_word", search_word);
		model.addAttribute("tableNum", tableNum);
		model.addAttribute("paging",paging);
		model.addAttribute("mypageboardList",mypageboardList);
		
	}
	
	
	/*
	 * 내가쓴 매치글 리스트
	 * 내가쓴 매치글 창 띄우기
	 * GET
	 * */
	@RequestMapping(value = "/mypage/mypageMatchList", method = RequestMethod.GET)
	public void mypageMatchListGet() {		
		
	}
	
	
	/*----------------------------------------------Mypage mypage End----------------------------------------------*/
	
	
	/*----------------------------------------------Mypage team Start----------------------------------------------*/
	
	/*
	 * 팀정보
	 * 팀정보 창 띄우기
	 * GET
	 * */
	@RequestMapping(value = "/mypage/teamInformation", method = RequestMethod.GET)
	public void teamInformationGet(HttpSession session, Model model) {
		//세션에서 유저 넘버 받아오기
		User user = new User();
		user.setUser_no((int)(session.getAttribute("user_no")));
		
		//유저넘버로 팀넘버 있는지 없는지 검사
		boolean teamYN = mypageService.getUserTeamNo(user);
		
		if(teamYN) {
			//유저넘버로 팀번호 알아오기
			user.setTeam_no(mypageService.selectTeamNoUserNo(user));	
			//유저가 가진 팀번호로 팀정보 조회
			Team team = new Team();
			team = mypageService.selectTeamInfoMation(user);
			List<User> userList = mypageService.selectTeamUserList(team.getTeam_no());
			
			model.addAttribute("userList",userList);
			model.addAttribute("team",team);
			session.setAttribute("teamYN", teamYN);
		}else {
			session.setAttribute("teamYN", teamYN);			
		}
	}
	
	/*
	 * 팀생성
	 * 팀생성 창 띄우기
	 * GET
	 * */
	@RequestMapping(value = "/mypage/teamCreate", method = RequestMethod.GET)
	public void teamCreateGet() {		
		
	}
	
	/*
	 * 팀생성
	 * 팀생성 처리 띄우기
	 * POST
	 * */
	@RequestMapping(value = "/mypage/teamCreate", method = RequestMethod.POST)
	public String teamCreatePost(Team team, HttpSession session, HttpServletRequest request, MultipartFile file) {	
		try {
			request.setCharacterEncoding("utf-8");
		} catch (UnsupportedEncodingException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		String team_region1 = request.getParameter("team_region1");
		String team_region2 = request.getParameter("team_region2");
		String team_region = team_region1 + "-" + team_region2;
		team.setTeam_region(team_region);
		
		//고유식별자
		String uId = UUID.randomUUID().toString().split("-")[0];

		//저장될 파일 이름
		String stored_name = null;
		//stored_name =file.getOriginalFilename()+"_"+uId;
		stored_name =file.getOriginalFilename();
						
		//파일 저장 경로		
		String path = context.getRealPath("uploadImg");
		
		//저장될 파일
		File dest = new File(path, stored_name);
		
		//파일업로드
		try {
			file.transferTo(dest);
		} catch (IllegalStateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		team.setTeam_mark(stored_name);
		//세션에서 유저 넘버 받아오기
		User user = new User();
		user.setUser_no((int)(session.getAttribute("user_no")));
		//팀생성
		mypageService.insertTeam(team);
		
		//팀번호 가져오기
		int team_no = mypageService.selectTeamNo(team);		
		
		
		user.setTeam_no(team_no);
		//팀에 가입한 시간 넣기
		mypageService.updateTeamDate(user);
		//팀번호를 유저번호에 업데이트		
		mypageService.updateTeamNo(user);
		System.out.println("완료");
		
		return "redirect:/mypage/teamInformation";
		
		
	}
	
	/*
	 * 팀수정
	 * 팀수정 창 띄우기
	 * GET
	 * */
	@RequestMapping(value = "/mypage/teamUpdate", method = RequestMethod.GET)
	public void teamUpdateGet() {		
		
	}
	
	/*
	 * 팀수정
	 * 팀수정 처리 띄우기
	 * POST
	 * */
	@RequestMapping(value = "/mypage/teamUpdate", method = RequestMethod.POST)
	public void teamUpdatePost() {		
		
	}
	
	/*
	 * 팀삭제처리
	 * 팀삭제 처리 띄우기
	 * POST
	 * */
	@RequestMapping(value = "/mypage/teamDelete", method = RequestMethod.POST)
	public String teamDeletePost(HttpSession session) {		
		//세션에서 유저 넘버 받아오기
		User user = new User();
		user.setUser_no((int)(session.getAttribute("user_no")));
		
		
		return "redirect:/mypage/teamInformation";
	}
	
	/*
	 * 팀매치정보
	 * 팀매치정보 창 띄우기
	 * GET
	 * */
	@RequestMapping(value = "/mypage/teamMatchInfo", method = RequestMethod.GET)
	public void teamMatchInfoGet() {		
		
	}
	
	/*
	 * 매치결과입력
	 * 매치결과입력 창 띄우기
	 * GET
	 * */
	@RequestMapping(value = "/mypage/teamScoreInsert", method = RequestMethod.GET)
	public void teamScoreInsertGet() {		
		
	}
	
	/*
	 * 매치결과입력
	 * 매치결과입력 처리 띄우기
	 * POST
	 * */
	@RequestMapping(value = "/mypage/teamScoreInsert", method = RequestMethod.POST)
	public void teamScoreInsertPost() {		
		
	}
	
	/*
	 * 팀게시판
	 * 팀게시판 폼 띄우기
	 * GET
	 * */
	@RequestMapping(value = "/mypage/teamBoard", method = RequestMethod.GET)
	public void teamBoardGet(HttpSession session, String cur, String search_div, String search_word, Model model) {		
		User user = new User();
		user.setUser_no((int)(session.getAttribute("user_no")));
		//팀번호 얻기
		int team_no = mypageService.selectTeamNoUserNo(user);
		
		//현재 페이지 번호 얻기
		int curPage = mypageService.getCurPage(cur);
		
		//총 게시글 수 얻기
		int totalCount = mypageService.getTotalCountSearchTeam(team_no,search_div,search_word);

		//페이지 객체 생성
		Paging paging = new Paging(totalCount, curPage);
		
		
		//게시글목록 MODEL로 추가
		List<Board_tb> mypageboardList = mypageService.getPagingListSearchTeam(team_no, paging, search_div, search_word);
		
		for(int i=0; i<mypageboardList.size(); i++) {
			mypageboardList.get(i).setBoard_reply_cnt(mypageService.getBoardReplyCnt(mypageboardList.get(i).getBoard_no()));
		}
		
		int tableNum = totalCount - (curPage - 1) * 10;		
		
		model.addAttribute("search_div", search_div);
		model.addAttribute("search_word", search_word);
		model.addAttribute("tableNum", tableNum);
		model.addAttribute("paging",paging);
		model.addAttribute("mypageboardList",mypageboardList);
		
	}
	
	/*
	 * 팀게시판View페이지
	 * 팀게시판 폼 띄우기
	 * 댓글 목록 출력
	 * GET
	 * */
	@RequestMapping(value = "/mypage/teamBoardView", method = RequestMethod.GET)
	public void teamBoardViewGet(User user, Board_tb board, int board_no, Model model, Photo photo, HttpSession session, Board_Reply board_reply) {		
		// 조회수 증가
		mypageService.teamBoardUpHit(board_no);
		// 지정 게시글 정보 가져오기
		board = mypageService.teamBoardView(board_no);
		// 사진 가져오기
		photo = mypageService.teamBoardPhotoView(board_no);
		
		
		// 댓글 리스트 가져오기
		List <Board_Reply> list = mypageService.ReplyList(board_reply);

		model.addAttribute("photo", photo);
		model.addAttribute("board", board);
		model.addAttribute("list", list);
	}
	
	/*
	 * 팀게시판 글쓰기폼
	 * 팀게시판 글쓰기폼 폼 띄우기
	 * GET
	 * */
	@RequestMapping(value = "/mypage/teamBoardWrite", method = RequestMethod.GET)
	public void teamBoardWriteGet() {}
	
	/*
	 * 팀게시판 글쓰기폼
	 * 팀게시판 글쓰기폼 처리
	 * POST
	 * */
	@RequestMapping(value = "/mypage/teamBoardWrite", method = RequestMethod.POST)
	public String teamBoardWritePost(Board_tb board_tb, MultipartFile file, HttpSession session, Photo photo) {	
		
		// 유저 번호 & 팀번호 받아오기
		User user = new User();
		user.setUser_no((int)(session.getAttribute("user_no")));
		int team_no = mypageService.selectTeamNoUserNo(user);
		user.setTeam_no(team_no);
		
		int board_no = mypageService.teamBoardGetBoard_no();		
					
		if(!"".equals(file.getOriginalFilename())&& file.getOriginalFilename()!=null) {
			//고유식별자
			String uId = UUID.randomUUID().toString().split("-")[0];
	
			//저장될 파일 이름
			String stored_name = null;
			stored_name =file.getOriginalFilename()+"_"+uId;
			
			//파일 저장 경로		
			String path = context.getRealPath("uploadImg");
			
			//저장될 파일
			File dest = new File(path, stored_name);
			
			//파일업로드
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
			
			// 글 번호 생성하기
			
			
			board_tb.setUser_no(user.getUser_no());
			board_tb.setBoard_no(board_no);
			photo.setBoard_no(board_no);
			mypageService.teamBoardInsertWrite(board_tb);
			mypageService.teamBoardInsertPhoto(photo);
			
		} else {	
			// 유저 번호 받아오기
			board_tb.setUser_no((int)session.getAttribute("user_no"));
			// 이미지 파일 없이 글 작성
			mypageService.teamBoardInsertWrite2(board_tb);
		}	
		mypageService.teamBoardInsertTeamBoard(board_tb,user);
		
		return "redirect:/mypage/teamBoard";
	}
	
	/*
	 * 팀게시판 수정 폼
	 * 팀게시판 수정 폼 띄우기
	 * GET
	 * */
	@RequestMapping(value = "/mypage/teamBoardUpdate", method = RequestMethod.GET)
	public void teamBoardUpdateGet() {		
		
	}
	
	/*
	 * 팀게시판 수정폼
	 * 팀게시판 수정 처리
	 * POST
	 * */
	@RequestMapping(value = "/mypage/teamBoardUpdate", method = RequestMethod.POST)
	public void teamBoardUpdatePost() {		
		
	}
	
	/*
	 * 팀게시판 삭제폼
	 * 팀게시판 삭제 처리
	 * POST
	 * */
	@RequestMapping(value = "/mypage/teamBoardDelete", method = RequestMethod.GET)
	public void teamBoardDeleteGet() {		
		
	}
	
	/*
	 * teamBoardCommentInsert POST
	 * 팀게시판 댓글 등록 처리 폼
	 * */
	@RequestMapping(value="/mypage/teamBoardCommentInsert", method = RequestMethod.POST)
	public void teamBoardCommentInsertPost() {
		
	}
	
	/*
	 * teamBoardCommentDelete GET
	 * 팀게시판 댓글 삭제 처리 폼
	 * */
	@RequestMapping(value="/mypage/teamBoardCommentDelete", method = RequestMethod.GET)
	public void teamBoardCommentDeleteGet() {
		
	}
	
	
	
	/*----------------------------------------------Mypage team End----------------------------------------------*/
	
	
	
}
