package com.fm.www.controller;

import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Arrays;
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
import com.fm.www.dto.Match;
import com.fm.www.dto.Message;
import com.fm.www.dto.Photo;
import com.fm.www.dto.Team;
import com.fm.www.dto.TeamApply;
import com.fm.www.dto.User;
import com.fm.www.service.face.CommunityService;
import com.fm.www.service.face.MypageService;
import com.fm.www.util.Paging;

@Controller
public class MypageController {
	private static final Logger logger = LoggerFactory.getLogger(MypageController.class);
	@Autowired ServletContext context;
	@Autowired MypageService mypageService;
	@Autowired CommunityService communityService;
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
			
			//팀넘버로 팀가입신청 테이블 조회
			List<TeamApply> teamApplyList = mypageService.selectTeamApplyList(team.getTeam_no());
			
			model.addAttribute("userList",userList);
			model.addAttribute("team",team);
			model.addAttribute("teamApplyList", teamApplyList);
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
		String team_region = team_region1;
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
		
		Board_tb board_tb = new Board_tb();
		int board_no =communityService.teamIntrogetboard_no();
		int user_no = (int) session.getAttribute("user_no");
		board_tb.setUser_no(user_no);
		board_tb.setBoard_no(board_no);
		board_tb.setBoard_title(team.getTeam_name());
		board_tb.setBoard_content(team.getTeam_hello());
		
		communityService.teamIntrowrite(board_tb);
		
		
		
		
		
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
	public void teamMatchInfoGet(HttpSession session, Model model) {		
		User user = new User();
		user.setUser_no((int)(session.getAttribute("user_no")));
		
		//유저넘버로 팀넘버 가져오기
		int team_no = mypageService.selectTeamNoUserNo(user);
		
		//팀 넘버로 매치보드 조회
		List<Match> matchList = mypageService.selectMatchList(team_no);
		List<Match> matchList1 = mypageService.selectMatchList1(team_no);
		
		model.addAttribute("matchList", matchList);
		model.addAttribute("matchList1", matchList1);
	}
	
	/*
	 * 매치결과입력
	 * 매치결과입력 창 띄우기
	 * GET
	 * */
	@RequestMapping(value = "/mypage/teamScoreInsert", method = RequestMethod.GET)
	public void teamScoreInsertGet(int match_no, HttpSession session, Model model) {		
		//매치넘버로 경기 조회
		Match match = mypageService.selectMatch(match_no);
		
		model.addAttribute("match", match);
	}
	
	/*
	 * 매치결과입력
	 * 매치결과입력 처리 띄우기
	 * POST
	 * */
	@RequestMapping(value = "/mypage/teamScoreInsert", method = RequestMethod.POST)
	public void teamScoreInsertPost(Match match, Board_tb board_tb, HttpSession session, HttpServletRequest request, MultipartFile file) {		
		System.out.println(match.getBlueteam_score());
		System.out.println(match.getPurpleteam_score());
		
		//-------------------------------점수에 따른 승,패,무, 총전적수 추가.-------------------------------
		
		//매치넘버로 경기 조회
		Match matchInfo = mypageService.selectMatch(match.getMatch_no());
		int b_rating = matchInfo.getBlue_rating();
		int p_rating = matchInfo.getPurple_rating();
		
		int[] rating_sort = new int[] {b_rating, p_rating};
		
		Arrays.sort(rating_sort);
		System.out.println(rating_sort[0]);
		System.out.println(rating_sort[1]);
		
		
		int rating_gab = rating_sort[1] - rating_sort[0];	//레이팅 차이
		int standard_score = 0;//기준 점수
		Double Exception_shift_High = 0.0;//기대 승률
		Double Exception_shift_Low = 0.0;//기대 승률
		
		//매치 등록팀이 더 잘할 때
		if(b_rating >= p_rating || b_rating == p_rating) {
			//레이팅 차이가 0 일때
			if(rating_gab == 0) {
				standard_score = 10;
				Exception_shift_High = 0.5;
				Exception_shift_Low = 0.5;
			}
			//레이팅 차이가 50 이하 일 때
			else if(rating_gab > 0 && rating_gab <= 50) {
				standard_score = 15;
				Exception_shift_High = 0.45;
				Exception_shift_Low = 0.55;
			}
			//레이팅 차이가 50~100이하일때
			else if(rating_gab > 50 && rating_gab <= 100) {
				standard_score = 20;
				Exception_shift_High = 0.4;
				Exception_shift_Low = 0.6;
			}
			//레이팅 차이가 100~200이하 일 때 
			else if(rating_gab > 100 && rating_gab <= 200) {
				standard_score = 25;
				Exception_shift_High = 0.35;
				Exception_shift_Low = 0.65;
			}
			//레이팅 차이가 200보다 높을때
			else if(rating_gab > 200 ) {
				standard_score = 30;
				Exception_shift_High = 0.3;
				Exception_shift_Low = 0.7;
			}
			//매치 등록팀이 더 잘하는데 매치등록팀이 이길경우 (standard_score)x(1-Exception_shift_Low)
			//매치 등록팀이 더 잘하는데 매치등록팀이 질경우 (standard_score)x(1-Exception_shift_High)
		}
		//매치 신청팀이 더 잘할 때
		else if(b_rating < p_rating) {
			//레이팅 차이가 0 일때
			if(rating_gab == 0) {
				standard_score = 10;
				Exception_shift_High = 0.5;
				Exception_shift_Low = 0.5;
			}
			//레이팅 차이가 50 이하 일 때
			else if(rating_gab > 0 && rating_gab <= 50) {
				standard_score = 15;
				Exception_shift_High = 0.45;
				Exception_shift_Low = 0.55;
			}
			//레이팅 차이가 50~100이하일때
			else if(rating_gab > 50 && rating_gab <= 100) {
				standard_score = 20;
				Exception_shift_High = 0.4;
				Exception_shift_Low = 0.6;
			}
			//레이팅 차이가 100~200이하 일 때 
			else if(rating_gab > 100 && rating_gab <= 200) {
				standard_score = 25;
				Exception_shift_High = 0.35;
				Exception_shift_Low = 0.65;
			}
			//레이팅 차이가 200보다 높을때
			else if(rating_gab > 200 ) {
				standard_score = 30;
				Exception_shift_High = 0.3;
				Exception_shift_Low = 0.7;
			}
			//매치 신청팀이 더 잘하는데 매치신청팀이 이길경우 (standard_score)x(1-Exception_shift_Low)
			//매치 신청팀이 더 잘하는데 매치신청팀이 질경우 (standard_score)x(1-Exception_shift_High)
		}
		
		System.out.println("레이팅 갭 " +rating_gab);
		System.out.println("Exception_shift_High 갭 " +Exception_shift_High);
		System.out.println("Exception_shift_Low 갭 " +Exception_shift_Low);

		//스코어 업데이트
		mypageService.updateScore(match);
		
		//총전적수 +1
		mypageService.updateEtire(matchInfo.getBlueteam_no());
		mypageService.updateEtire(matchInfo.getPurpleteam_no());
		
		//블루팀이 이겼을때
		if(match.getBlueteam_score() > match.getPurpleteam_score()) {
			//승 패 수 증가
			mypageService.updateWin(matchInfo.getBlueteam_no());
			mypageService.updateLose(matchInfo.getPurpleteam_no());
			//블루팀이 더 잘하는데 이겼을때
			if(b_rating >= p_rating) {
				b_rating += (int) ((standard_score)*(1-Exception_shift_Low));
				p_rating -= (int) ((standard_score)*(1-Exception_shift_Low));
			}
			//블루팀이 더 못하는데 이겼을때
			else {
				b_rating += (int) ((standard_score)*(1-Exception_shift_High));
				p_rating -= (int) ((standard_score)*(1-Exception_shift_High));
			}
			mypageService.updateRating(matchInfo.getBlueteam_no(), b_rating);
			mypageService.updateRating(matchInfo.getPurpleteam_no(), p_rating);
		}
		//블루팀 퍼플팀 비겻을때
		else if(match.getBlueteam_score() == match.getPurpleteam_score()) {
			mypageService.updateTie(matchInfo.getBlueteam_no());
			mypageService.updateTie(matchInfo.getPurpleteam_no());
		}
		//퍼플팀이 이겼을때
		else if(match.getBlueteam_score() < match.getPurpleteam_score()) {
			mypageService.updateWin(matchInfo.getPurpleteam_no());
			mypageService.updateLose(matchInfo.getBlueteam_no());
			
			//퍼플팀이 더 잘하는데 이겼을때
			if(b_rating <= p_rating) {
				p_rating += (int) ((standard_score)*(1-Exception_shift_Low));
				b_rating -= (int) ((standard_score)*(1-Exception_shift_Low));
			}
			//퍼플팀이 더 못하는데 이겼을때
			else {
				p_rating += (int) ((standard_score)*(1-Exception_shift_High));
				b_rating -= (int) ((standard_score)*(1-Exception_shift_High));
			}
			mypageService.updateRating(matchInfo.getBlueteam_no(), b_rating);
			mypageService.updateRating(matchInfo.getPurpleteam_no(), p_rating);
		}
		
		System.out.println("블루팀 레이팅" + b_rating);
		System.out.println("퍼플팀 레이팅" + p_rating);
		System.out.println(matchInfo.getBlueteam_no());
		System.out.println(matchInfo.getPurpleteam_no());
	}
	
	/*
	 * 
	 * 매치 결과 페이지
	 * GET
	 * teamMatchResult
	 * */
	
	@RequestMapping(value = "/mypage/teamMatchResult", method = RequestMethod.GET)
	public void teamMatchResultGet(HttpSession session, Model model) {		
		User user = new User();
		user.setUser_no((int)(session.getAttribute("user_no")));
		
		//유저넘버로 팀넘버 가져오기
		int team_no = mypageService.selectTeamNoUserNo(user);
		
		//팀 넘버로 매치보드 조회
		List<Match> matchList = mypageService.selectMatchList(team_no);
		
		model.addAttribute("matchList", matchList);
		
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
			board_tb.setBoard_no(board_no);
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
	public void teamBoardUpdateGet(Board_tb board, int board_no, Model model, Photo photo) {		
		// 지정 게시글 정보 가져오기
		board = mypageService.teamBoardView(board_no);
		// 사진 가져오기
		photo = mypageService.teamBoardPhotoView(board_no);

		model.addAttribute("photo", photo);
		model.addAttribute("board", board);

	}
	
	/*
	 * 팀게시판 수정폼
	 * 팀게시판 수정 처리
	 * POST
	 * */
	@RequestMapping(value = "/mypage/teamBoardUpdate", method = RequestMethod.POST)
	public String teamBoardUpdatePost(int board_no,Photo photo,Board_tb board_tb ,HttpSession session,HttpServletRequest request, MultipartFile file) {		
		try {
			request.setCharacterEncoding("utf-8");
		} catch (UnsupportedEncodingException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		//파일첨부 존재 여부
		int photo_no = mypageService.teamBoardcntphoto(board_no);
		
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
			
				board_tb.setBoard_no(board_no);
				photo.setBoard_no(board_no);
				//세션번호넣어주기
				int user_no = (int) session.getAttribute("user_no");
				board_tb.setUser_no(user_no);
			
			
				//수정 글쓰기
				//mypageService.teamIntroupdate(board_tb);
				mypageService.teamBoardupdate(board_tb);
			
				//수정 파일첨부
				//mypageService.teamIntrophotoupdate(photo);
				mypageService.teamBoardphotoupdate(photo);
				
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
			
				board_tb.setBoard_no(board_no);
				photo.setBoard_no(board_no);
				board_tb.setBoard_no(board_no);
				//세션번호넣어주기
				int user_no = (int) session.getAttribute("user_no");
				board_tb.setUser_no(user_no);
			
				//수정 글쓰기
				mypageService.teamBoardupdate(board_tb);
				//파일첨부
				mypageService.teamBoardInsertPhoto(photo);
			}
		}else {
			board_tb.setBoard_no(board_no);
			mypageService.teamBoardupdate(board_tb);			
		}
		
		
		return "redirect:/mypage/teamBoard";
	}
	
	/*
	 * 팀게시판 삭제폼
	 * 팀게시판 삭제 처리
	 * GET
	 * */
	@RequestMapping(value = "/mypage/teamBoardDelete", method = RequestMethod.GET)
	public String teamBoardDeleteGet(int board_no) {		
		mypageService.teamBoardDelete(board_no);		
		return "redirect:/mypage/teamBoard";
	}
	
	/*
	 * teamBoardCommentInsert POST
	 * 팀게시판 댓글 등록 처리 폼
	 * */
	@RequestMapping(value="/mypage/teamBoardCommentInsert", method = RequestMethod.POST)
	public String teamBoardCommentInsertPost(Board_Reply board_reply, int board_no, HttpSession session) {
		board_reply.setBoard_no(board_no);
		board_reply.setUser_no((int)session.getAttribute("user_no"));
		// 댓글 등록
		mypageService.teamBoardCommentInsert(board_reply);
		mypageService.DownHit(board_no);
		
		return "redirect:/mypage/teamBoardView?board_no="+board_no;
	}
	
	/*
	 * teamBoardCommentDelete GET
	 * 팀게시판 댓글 삭제 처리 폼
	 * */
	@RequestMapping(value="/mypage/teamBoardCommentDelete", method = RequestMethod.GET)
	public String teamBoardCommentDeleteGet(int reply_no, int board_no) {
		mypageService.teamBoardReplyDelete(reply_no);
		mypageService.DownHit(board_no);
		return "redirect:/mypage/teamBoardView?board_no="+board_no;		
	}
	
	
	@RequestMapping(value="/mypage/teamApplyInsert", method = RequestMethod.POST)
	public String teamApplyInsertPost(TeamApply teamApply, HttpSession session, Model model) {
		teamApply.setUser_no((int)session.getAttribute("user_no"));		
		User user = new User();
		Team team = new Team();
		user.setTeam_no(teamApply.getTeam_no());
		Map map = new HashMap();
		
		boolean applyYN = mypageService.teamApplyYN(teamApply);
		team = mypageService.selectTeamInfoMation(user);
		
		//신청 안한 팀일때 신청
		if(applyYN) {
			mypageService.teamApplyInsert(teamApply);
			map.put("teamName",team.getTeam_name()+"팀에 가입신청이 되었습니다.");
		}else {
			map.put("teamName",team.getTeam_name()+"팀에 이미 신청하셨습니다.");
		}		
					
		
		model.addAllAttributes(map);
		
		return "jsonView";
	}
	
	@RequestMapping(value="/mypage/teamApplyOk", method = RequestMethod.POST)
	public String teamApplyOkPost(TeamApply teamApply) {
		User user = new User();
		user.setUser_no(teamApply.getUser_no());
		user.setTeam_no(teamApply.getTeam_no());
		
		mypageService.updateTeamDate(user);
		mypageService.updateTeamNo(user);
		
		//신청내역 삭제
		mypageService.deleteAllTeamApply(teamApply);
		return "redirect:/mypage/teamInformation";
	}
	
	@RequestMapping(value="/mypage/teamApplyNo", method = RequestMethod.POST)
	public String teamApplyNoPost(TeamApply teamApply) {
		
		mypageService.deleteTeamApply(teamApply);
		return "redirect:/mypage/teamInformation";
	}
	
	
}
	
	
	
	/*----------------------------------------------Mypage team End----------------------------------------------*/