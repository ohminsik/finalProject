package com.fm.www.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.fm.www.service.face.TournamentService;
@Controller
public class TournamentController {
	private static final Logger logger = LoggerFactory.getLogger(TournamentController.class);
	
	@Autowired TournamentService tournamentService;
	
	/*
	 * 대회 일정 지역별  컨트롤러
	 * GET
	 * */
	@RequestMapping(value = "/tournament/tournamentRegion", method = RequestMethod.GET)
	public void tournamentRegionGet() {		
		
		
	}
	
	/*
	 * 대회 일정 월 별 컨트롤러
	 * GET
	 * */
	@RequestMapping(value = "/tournament/tournamentMonth", method = RequestMethod.GET)
	public void tournamentMonthGet() {		
		
		
	}
	
	/*
	 * Admin 컨트롤러
	 * Admin 창 띄우기
	 * GET
	 * */
	@RequestMapping(value = "/tournament/tournamentView", method = RequestMethod.GET)
	public void tournamentViewGet() {		
		
		
	}
	

	
}

