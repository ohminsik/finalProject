package com.fm.www.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.fm.www.dao.face.CommunityDao;

@Controller
public class TeamController {
	private static final Logger logger = LoggerFactory.getLogger(TeamController.class);
	
	/*
	 * 전국팀정보
	 * 전국팀정보 창 띄우기
	 * GET
	 * */
	@RequestMapping(value = "/team/allTeamInformation", method = RequestMethod.GET)
	public void allTeamInformationGet() {		
		
	}
}
