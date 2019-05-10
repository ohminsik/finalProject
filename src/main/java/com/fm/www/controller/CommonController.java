package com.fm.www.controller;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.fm.www.dto.User;
import com.fm.www.service.face.MemberService;
import com.fm.www.util.MailUtil;

@Controller
public class CommonController {
	private static final Logger logger = LoggerFactory.getLogger(CommonController.class);
	
	@Autowired
	MemberService memberService;
	/*
	 * main 컨트롤러
	 * main 창 띄우기
	 * GET
	 * */
	@RequestMapping(value = "/main", method = RequestMethod.GET)
	public String mainGet() {		
		return "common/main";
	}
	
	/*
	 * login 컨트롤러
	 * login post처리
	 * POST
	 * */	
	@RequestMapping(value="/login", method=RequestMethod.POST)
	public String loginPost(User user, HttpSession session) {		
		//로그인 여부 받아오기
		boolean loginYn = memberService.getLoginYn(user);
		
		if(loginYn == false) {//로그인 안 되 있는 경우
			session.setAttribute("loginYn", loginYn);
			return "redirect:/main";
		}
		//로그인 되었을 경우 no랑 login 세션 넘겨줌
		
		//로그인한 유저 넘버값 가져오기
		int user_no = memberService.getUserNo(user);

		
		User user1 = new User();
		user1.setUser_no(user_no);
		
		// 로그인한 유저 닉네임 가져오기
		String user_nick = memberService.getuserNick(user);
		
		//team_no받아오기
		String team_no = memberService.getTeamNo(user);
		System.out.println("팀넘버:"+team_no);
		//team_no null값 여부
		if(team_no==null || team_no.equals("")  ) {
			session.setAttribute("teamYN", false);
		}else {
			session.setAttribute("teamYN", true);
		}
		
		
		session.setAttribute("loginYn", loginYn);
		session.setAttribute("login", true);
		session.setAttribute("user_no", user1.getUser_no());
		session.setAttribute("user_nick", user_nick);
		
		//로그인 했으면 메인 화면으로 이동
		return "redirect:/main";
	}
	
	/*
	 * logout 컨트롤러
	 * logout 세션 처리
	 * 
	 * */	
	@RequestMapping(value="/logout", method=RequestMethod.GET)
	public String logoutGet(HttpSession session) {

		session.invalidate();
		
		//로그아웃 후 main으로
		return"redirect:/main";
	}
	
	/*
	 * 아이디 찾기 AJAX로 처리
	 * */
	@RequestMapping(value="/idChk", method=RequestMethod.POST)
	public String FindId(HttpServletRequest request,Model model) throws Exception {
		String user_name = request.getParameter("name");
		String user_email = request.getParameter("email");
		logger.info(user_name);
		logger.info(user_email);
		// 아이디 확인 여부 받아오기
		boolean find_id = memberService.find_Id(user_name,user_email);
		//아이디 찾기
		String findid = memberService.findId(user_name,user_email); 
		
		Map map = new HashMap();
		if (find_id == false) {
			map.put("data", "N");
		}
		model.addAttribute("findid",findid);
		model.addAllAttributes(map);
		return "jsonView";
	}
	/*
	 * 비밀번호 찾기 AJAX로 처리
	 * */
	@RequestMapping(value="/pwChk", method=RequestMethod.POST)
	public String FindPw(User user,HttpServletRequest request,
			MailUtil mail,
			Model model) throws Exception{
		String user_id = request.getParameter("id");
		String user_email = request.getParameter("email");
		
		//비밀번호 확인 여부
		int find_pw = memberService.find_Pw(user_id,user_email);
		logger.info(""+find_pw);
		logger.info(""+user);
		//비밀번호 변경
		if(find_pw == 1) {
			user.setUser_id(user_id);
			user.setUser_email(user_email);
			String user_pw_New = UUID.randomUUID().toString().replaceAll("-","").substring(0,10);
			user.setUser_pw(user_pw_New);
			System.out.println(user.getUser_pw());
			memberService.up_pw(user);
			logger.info("qweqewadsadszxvcg12444444444444444444"+user);
			
			String subject = "지금까지 이런 매치는 없었다 [Final Match]에서 임시 비밀번호 발급 안내";
			String msg = "";
			msg += "<div align='center' style='border:1ps solid blue; font-family:verdana'>";
			msg += "<h4 style='coler: black;'><strong>" + user_id + " 님</Strong>의 임시 비밀번호 입니다. 로그인 후 비밀번호를 변경하세요.</h3>";
			msg += "<p>임시 비밀번호 : <strong>" + user_pw_New + "</strong></p></div>";
			
			mail.sendMail(user_email, subject, msg);
		}
		Map map = new HashMap();
		map.put("data", find_pw);
		model.addAllAttributes(map);
		
		
		return "jsonView";
	}
	
	// 카카오 로그인
	@RequestMapping(value="/kko", method=RequestMethod.GET)
	public String kkoo(HttpSession session, String userNickName, HttpServletRequest request) {

		return "redirect:/main";
	}
	@RequestMapping(value="/kko", method=RequestMethod.POST)
	public String kko(HttpSession session, String userNickName, String userID, HttpServletRequest request, User user) {
		user.setUser_nick(userNickName);
		user.setUser_id(userID);
//			System.out.println(userNickName);
//			System.out.println(userID);
		String user_nick = userNickName;
		
		// 카카오 가입 조회
		int kkoCheck = memberService.kkoCheck(user);
		
		if(kkoCheck == 1) {
			session.setAttribute("login", true);
			session.setAttribute("user_nick", user_nick);
		} else  {
			// 카카오톡 로그인 유저 넘버 생성
			memberService.kkoNo(user);
			session.setAttribute("login", true);
			session.setAttribute("user_nick", user_nick);
		}
		
		
		
		return"jsonView";
	}
	
}