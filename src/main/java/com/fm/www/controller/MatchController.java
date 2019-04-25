package com.fm.www.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.fm.www.dao.face.CommunityDao;

@Controller
public class MatchController {
	private static final Logger logger = LoggerFactory.getLogger(MatchController.class);
	
	/*
	 * 매치정보
	 * 매치정보 창 띄우기
	 * GET
	 * */
	@RequestMapping(value = "/match/matchBoard", method = RequestMethod.GET)
	public void matchBoardGet() {		
		
	}
	
	/*
	 * 매치신청
	 * 매치신청 창 띄우기
	 * GET
	 * */
	@RequestMapping(value = "/match/matchApply", method = RequestMethod.GET)
	public void matchApplyGet() {		
		
	}
	
	/*
	 * 매치등록
	 * 매치등록 창 띄우기
	 * GET
	 * */
	@RequestMapping(value = "/match/matchRegister", method = RequestMethod.GET)
	public void matchRegisterGet() {		
		
	}
	
	/*
	 * 매치등록
	 * 매치등록 처리 띄우기
	 * GET
	 * */
	@RequestMapping(value = "/match/matchRegister", method = RequestMethod.POST)
	public void matchRegisterPost() {		
		
	}
}
