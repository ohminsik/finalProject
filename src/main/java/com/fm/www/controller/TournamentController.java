package com.fm.www.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.fm.www.dto.Tournament;
import com.fm.www.service.face.TournamentService;
import com.fm.www.util.Paging2;
@Controller
public class TournamentController {
	private static final Logger logger = LoggerFactory.getLogger(TournamentController.class);
	
	@Autowired TournamentService tournamentService;
	
	/*
	 * 대회 일정 지역별  컨트롤러
	 * GET
	 * */
	@RequestMapping(value = "/tournament/tournamentRegion", method = RequestMethod.GET)
	public void tournamentRegionGet(String curPage, Model model, String region) {		
		
		//현제 페이지 번호 받기
		int curPage1 = tournamentService.getcurPage(curPage);
		// 대회 게시글 전체 수
		int totalCount = tournamentService.tournamentTotalCount(region);
		
		if(totalCount ==0 ) {
			model.addAttribute("totalCount", totalCount);
		}
		//페이징
		Paging2 paging2 = new Paging2(totalCount,curPage1);
		paging2.setWord(region);
		// 대회 페이징 리스트 처리
		List <Tournament> list = tournamentService.tournamentRegionGetList(paging2);
		
	
		model.addAttribute("paging2",paging2);
		model.addAttribute("list", list);
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

