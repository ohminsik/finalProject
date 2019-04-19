package com.fm.www.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class MemberController {
	private static final Logger logger = LoggerFactory.getLogger(MemberController.class);
	
	/*
	 * joinStep_1 컨트롤러
	 * 회원가입창 띄우기
	 * GET
	 * */
	@RequestMapping(value = "/member/joinStep_1", method = RequestMethod.GET)
	public void joinStep_1Get() {		
	
	}
	
	/*
	 * joinStep_2 컨트롤러
	 * 회원가입창 띄우기
	 * GET
	 * */
	@RequestMapping(value = "/member/joinStep_2", method = RequestMethod.GET)
	public void joinStep_2Get() {		
	
	}
	
	/*
	 * joinStep_2 컨트롤러
	 * 회원가입처리
	 * POST
	 * */
	@RequestMapping(value = "/member/joinStep_2", method = RequestMethod.POST)
	public String joinStep_2Post() {		
		
		return "redirect:/member/joinStep_3";
	}
	
	/*
	 * joinStep_2 컨트롤러
	 * 회원가입처리
	 * POST
	 * */
	@RequestMapping(value = "/member/joinStep_3", method = RequestMethod.GET)
	public void joinStep_3Get() {			
		
	}
}
