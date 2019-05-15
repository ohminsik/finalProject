package com.fm.www.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.fm.www.dto.Board_tb;
import com.fm.www.dto.Photo;
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
		int totalCount = tournamentService.tournamentTotalCount1(region);
		
		if(totalCount ==0 ) {
			model.addAttribute("totalCount", totalCount);
		}
		//페이징
		Paging2 paging2 = new Paging2(totalCount,curPage1);
		paging2.setWord(region);
		// 대회 페이징 리스트 처리
		List <Tournament> list = tournamentService.tournamentRegionGetList(paging2);
		
			
			for(int i=0; i<list.size(); i++) {
				list.get(i).setPhoto_stored(tournamentService.photoStoredName(list.get(i).getBoard_no()));
		}
			
		
		
		
		model.addAttribute("region",region);
		model.addAttribute("paging2",paging2);
		model.addAttribute("list", list);
	}
	
	/*
	 * 대회 일정 월 별 컨트롤러
	 * GET
	 * */
	@RequestMapping(value = "/tournament/tournamentMonth", method = RequestMethod.GET)
	public void tournamentMonthGet(String curPage,String year,String month, Model model, HttpServletRequest request) {		
		//현제 페이지 번호 받기
		int curPage1 = tournamentService.getcurPage(curPage);
		if(year != null && month != null) {
			logger.info(year);
			logger.info(month);
			String y_m= year+"/"+month;
			logger.info(y_m);
			Date y_m2 = null;
			try {
				y_m2 = new SimpleDateFormat("yy/MM").parse(y_m);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			SimpleDateFormat ym = new SimpleDateFormat("yy/MM");
				String con_dates = null;
				con_dates = ym.format(y_m2);
				logger.info("con_dates"+con_dates);
			//date 변수 대회시작날짜 초기화
			Date curDate = tournamentService.selectcon_con_dates(con_dates);
			logger.info(""+curDate);
			//simpleDateFormat으로 형식지정
			SimpleDateFormat yymm = new SimpleDateFormat("yy/MM");
			String condates = yymm.format(curDate);
			logger.info(condates);
			// 대회 게시글 전체 수
			int totalCount = tournamentService.tournamentTotalCount2(condates);
			
			if(totalCount ==0 ) {
				model.addAttribute("totalCount", totalCount);
			}
			//페이징
			Paging2 paging2 = new Paging2(totalCount,curPage1);
			paging2.setWord(condates);
			// 대회 페이징 리스트 처리
			List <Tournament> list = tournamentService.tournamentMonthGetList(paging2);
			
				for(int i=0; i<list.size(); i++) {
					list.get(i).setPhoto_stored(tournamentService.photoStoredName(list.get(i).getBoard_no()));
			}
			
			model.addAttribute("paging2",paging2);
			model.addAttribute("list", list);
		}else {
		//date 변수 현제날짜 초기화
		Date curDate = tournamentService.selectDate();
		logger.info(""+curDate);
		//simpleDateFormat으로 형식지정
		SimpleDateFormat yymm = new SimpleDateFormat("yy/MM");
		String condates = yymm.format(curDate);
		logger.info(condates);
		// 대회 게시글 전체 수
		int totalCount = tournamentService.tournamentTotalCount2(condates);
		
		if(totalCount ==0 ) {
			model.addAttribute("totalCount", totalCount);
		}
		//페이징
		Paging2 paging2 = new Paging2(totalCount,curPage1);
		paging2.setWord(condates);
		// 대회 페이징 리스트 처리
		List <Tournament> list = tournamentService.tournamentMonthGetList(paging2);
		
			
			for(int i=0; i<list.size(); i++) {
				list.get(i).setPhoto_stored(tournamentService.photoStoredName(list.get(i).getBoard_no()));
		}
			
		
		
		
		model.addAttribute("paging2",paging2);
		model.addAttribute("list", list);
		}
}
	
	/*
	 * 대회일정 뷰 컨트롤러
	 * 대회일정 상세페이지 창 띄우기
	 * GET
	 * */
	@RequestMapping(value = "/tournament/tournamentView", method = RequestMethod.GET)
	public void tournamentViewGet(Tournament tournment,int board_no,Model model,Photo photo) {
		
		//지정 게시글 가져오기
		tournment = tournamentService.tournamentView(board_no);
		//사진 가져오기
		photo = tournamentService.PhotoView(board_no);
		
		model.addAttribute("tournment" ,tournment);
		model.addAttribute("photo" ,photo);
		
	}
	

	
}

