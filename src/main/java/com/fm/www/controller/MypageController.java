package com.fm.www.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.fm.www.dao.face.CommunityDao;

@Controller
public class MypageController {
	private static final Logger logger = LoggerFactory.getLogger(MypageController.class);
	
	/*
	 * 팀정보
	 * 팀정보 창 띄우기
	 * GET
	 * */
	@RequestMapping(value = "/mypage/teamInformation", method = RequestMethod.GET)
	public void teamInformationGet() {		
		
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
	public void teamCreatePost() {		
		
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
	public void teamBoardGet() {		
		
	}
	
	
	
	
}
