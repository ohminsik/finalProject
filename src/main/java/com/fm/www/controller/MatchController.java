package com.fm.www.controller;

import java.io.UnsupportedEncodingException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.fm.www.dto.Match;
import com.fm.www.dto.User;
import com.fm.www.service.face.MatchService;
import com.fm.www.service.face.MemberService;

@Controller
public class MatchController {
	private static final Logger logger = LoggerFactory.getLogger(MatchController.class);

	@Autowired
	MemberService memberService;

	@Autowired
	MatchService matchService;

	/*
	 * 매치정보 매치정보 창 띄우기 GET
	 */
	@RequestMapping(value = "/match/matchBoard", method = RequestMethod.GET)
	public void matchBoardGet(Model model, HttpSession session) {
		
		
		List<Match> matchList = matchService.selectMatchOnThisMonth();
		model.addAttribute("matchList", matchList);
		

	}

	/*
	 * 2019 04 26 추가 매치정보 매치정보 창 띄우기 Post
	 */
	@RequestMapping(value = "/match/matchBoard", method = RequestMethod.POST)
	public void matchBoardPost() {

//		//1.세션으로 받을 user_no 초기값 -1로 설정
//		int sessionUser_no = -1;
//		
//		//2. team번호 있을 경우, 없을 경우
//		if(session.getAttribute("user_no") != null) {//팀이 있을 경우
//			sessionUser_no=(int)session.getAttribute("user_no");
//			
//			
//			model.addAttribute("user_no", sessionUser_no);
//			System.out.println("팀이 있을 경우: "+sessionUser_no);
//			
//			return"redirect:/match/matchRegister";
//			
//		}else if(session.getAttribute("user_no")==null) {//로그인 안되있을 경우 main화면으로 이동
//			System.out.println("팀 없을 경우:"+session.getAttribute("user_no"));
//			return"redirect:/main";
//		}else {
//			return null;
//		}
//		
	}

	/*
	 * 매치신청 매치신청 창 띄우기 GET
	 */
	@RequestMapping(value = "/match/matchApply", method = RequestMethod.GET)
	public void matchApplyGet() {

	}

	/*
	 * 매치등록 매치등록 창 띄우기 GET
	 */
	@RequestMapping(value = "/match/matchRegister", method = RequestMethod.GET)
	public void matchRegisterGet() {

	}

	/*
	 * 매치등록 매치등록 처리 띄우기 POST
	 */
	@RequestMapping(value = "/match/matchRegister", method = RequestMethod.POST)
	public String matchRegisterPost(Match match, HttpServletRequest request, HttpSession session, Model model) {
		User user = new User();
		user.setUser_no((int) session.getAttribute("user_no"));

		// user_no로 user정보 가져오기
		user = matchService.selectUserByuserNo(user.getUser_no());

		logger.info("유저 넘버 조회 : " + user.getUser_no());
		logger.info("User조회:" + user);

		try {
			request.setCharacterEncoding("utf-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}

		// DateFormate 함수 선언
		SimpleDateFormat fmt = new SimpleDateFormat("yyyy/MM/dd hh:mm");
		Date fight_date = new Date();
		// parameter 값 받기

		// 날짜, 시간, 분 각각 따로 받기
		String selDate = request.getParameter("selDate");
		String hours = request.getParameter("hours");
		String minute = request.getParameter("minute");

		logger.info("selDate:" + selDate);
		logger.info("hours:" + hours);
		logger.info("minute:" + minute);

		// 각각 따로 받은거 합침
		String colDate = selDate + " " + hours + ":" + minute;

		logger.info("colDate:" + colDate);
		try {
			// date로 변환
			fight_date = fmt.parse(colDate);

			logger.info("fight_date" + fight_date);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		// match dto의 값으로 바꿔주기

		// 입력받은 값 변수에 담기
		String match_ground = request.getParameter("match_ground");
		String paramMatch_money = request.getParameter("match_money");
		String match_uniform = request.getParameter("match_uniform");
		String match_region = request.getParameter("match_region");
		String match_content = request.getParameter("match_content");

		// match_money 값 int형으로 변환
		int match_money = Integer.parseInt(paramMatch_money);

//		System.out.println("매치날짜:"+fight_date);
//		System.out.println("매치날짜:"+colDate);
//		System.out.println("경기구장:"+match_ground);
//		System.out.println("parameter로넘어온 구장비"+paramMatch_money);
//		System.out.println("유니폼:"+match_uniform);
//		System.out.println("경기지역:"+match_region);
//		System.out.println("int형으로 바꾼 구장비"+match_money);
//		System.out.println("남기는 한마디:"+match_content);
//		
		// match dto의 값으로 바꿔주기
		match.setFight_date(fight_date);
		match.setMatch_ground(match_ground);
		match.setMatch_money(match_money);
		match.setMatch_uniform(match_uniform);
		match.setMatch_region(match_region);
		match.setMatch_content(match_content);
		match.setBlueteam_no(user.getTeam_no());
		match.setUser_no(user.getUser_no());

		// 등록하면 Match 테이블에 넣기
		matchService.enrollMatch(match);

		return "redirect:/match/matchBoard";

	}
}
