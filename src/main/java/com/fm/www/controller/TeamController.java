package com.fm.www.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.fm.www.dto.Team;
import com.fm.www.service.face.TeamService;
import com.fm.www.util.Paging;

@Controller
public class TeamController {
	private static final Logger logger = LoggerFactory.getLogger(TeamController.class);
	@Autowired TeamService teamService;
	/*
	 * 전국팀정보
	 * 전국팀정보 창 띄우기
	 * GET
	 * */
	@RequestMapping(value = "/team/allTeamInformation", method = RequestMethod.GET)
	public void allTeamInformationGet(String cur, String word, Model model, HttpSession session) {
		int i = 1;
		String team_sport = (String)session.getAttribute("userInfo");
		System.out.println(team_sport);
		//현재페이지 수 가져오기
		int curPage = teamService.getCurPage(cur);
		// 공지사항 게시글 전체 수 
		int totalCount = teamService.teamTotalCount(word, i, team_sport);
		
		// 페이징 처리
		Paging paging = new Paging(totalCount, curPage);
		
		// 페이징 리스트 처리
		List<Team> list = teamService.teamGetList(paging, word, i, team_sport);
		
		
		// 게시글 번호 생성
		int tableNum = 0;
		if(curPage == 0 || curPage ==1) {
			tableNum = 1;
		}else {
			tableNum = ((curPage - 1) * 10)+1;
		}
		
		
		model.addAttribute("tableNum",tableNum);
		model.addAttribute("list",list);
		model.addAttribute("paging", paging);
		
	}
	
	@RequestMapping(value = "/team/allTeamInformationRegion", method = RequestMethod.GET)
	public String allTeamInformationRegionGet(String cur, String region, Model model, HttpSession session) {
		
		int i = 2;
		String team_sport = (String)session.getAttribute("userInfo");
		if(region.equals("충남") || region.equals("충북")) {
			region = "충청";
		}
		if(region.equals("전남") || region.equals("전북")) {
			region = "전라";
		}
		if(region.equals("경남") || region.equals("경북")) {
			region = "경상";
		}
		//현재페이지 수 가져오기
		int curPage = teamService.getCurPage(cur);
		// 공지사항 게시글 전체 수 
		int totalCount = teamService.teamTotalCount(region, i, team_sport);
		
		// 페이징 처리
		Paging paging = new Paging(totalCount, curPage);
		
		// 페이징 리스트 처리
		List<Team> list = teamService.teamGetList(paging, region, i, team_sport);
		
		
		// 게시글 번호 생성
		int tableNum = 0;
		if(curPage == 0 || curPage ==1) {
			tableNum = 1;
		}else {
			tableNum = ((curPage - 1) * 10)+1;
		}
		
		
		model.addAttribute("tableNum",tableNum);
		model.addAttribute("list",list);
		model.addAttribute("paging", paging);
		
		return "team/allTeamInformation";
	}
	
	@RequestMapping(value = "/team/allTeamInformationAge", method = RequestMethod.GET)
	public String allTeamInformationAgeGet(String cur, String age, Model model, HttpSession session) {		
		
		int i = 3;
		String team_sport = (String)session.getAttribute("userInfo");
		//현재페이지 수 가져오기
		int curPage = teamService.getCurPage(cur);
		// 공지사항 게시글 전체 수 
		int totalCount = teamService.teamTotalCount(age, i, team_sport);
		
		// 페이징 처리
		Paging paging = new Paging(totalCount, curPage);
		
		// 페이징 리스트 처리
		List<Team> list = teamService.teamGetList(paging, age, i, team_sport);
		
		
		// 게시글 번호 생성
		int tableNum = 0;
		if(curPage == 0 || curPage ==1) {
			tableNum = 1;
		}else {
			tableNum = ((curPage - 1) * 10)+1;
		}
		
		
		model.addAttribute("tableNum",tableNum);
		model.addAttribute("list",list);
		model.addAttribute("paging", paging);
		
		return "team/allTeamInformation";
		

	}
	
	@RequestMapping(value = "/team/allTeamInformationType", method = RequestMethod.GET)
	public String allTeamInformationTypeGet(String cur, String type, Model model, HttpSession session) {		
		
		int i = 4;
		String team_sport = (String)session.getAttribute("userInfo");
		//현재페이지 수 가져오기
		int curPage = teamService.getCurPage(cur);
		// 공지사항 게시글 전체 수 
		int totalCount = teamService.teamTotalCount(type, i, team_sport);
		
		// 페이징 처리
		Paging paging = new Paging(totalCount, curPage);
		
		// 페이징 리스트 처리
		List<Team> list = teamService.teamGetList(paging, type, i, team_sport);
		
		
		// 게시글 번호 생성
		int tableNum = 0;
		if(curPage == 0 || curPage ==1) {
			tableNum = 1;
		}else {
			tableNum = ((curPage - 1) * 10)+1;
		}
		
		
		model.addAttribute("tableNum",tableNum);
		model.addAttribute("list",list);
		model.addAttribute("paging", paging);
		
		return "team/allTeamInformation";
	}
}
