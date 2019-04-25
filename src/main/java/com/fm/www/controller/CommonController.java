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
		
		System.out.println(user);
		//로그인 여부 받아오기
		boolean loginYn = memberService.getLoginYn(user);
		
		if(loginYn == false) {//로그인 안 되 있는 경우
			
			return "redirect:/main";
		}
		session.setAttribute("login", true);
		session.setAttribute("id", user.getUser_id());
		logger.info(user.toString());
		
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













