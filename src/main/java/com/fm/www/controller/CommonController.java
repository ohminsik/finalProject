package com.fm.www.controller;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.fm.www.dto.User;
import com.fm.www.service.face.MemberService;

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
			
			return "redirect:/main";
		}
		//로그인 되었을 경우 no랑 login 세션 넘겨줌
		
		//로그인한 유저 넘버값 가져오기
		int user_no = memberService.getUserNo(user);
		User user1 = new User();
		user1.setUser_no(user_no);
		// 로그인한 유저 닉네임 가져오기
		String user_nick = memberService.getuserNick(user);

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
	
}













