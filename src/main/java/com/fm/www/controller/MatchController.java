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

import com.fm.www.dao.face.MypageDao;
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
	
	@Autowired
	MypageDao mypageDao;

	/*2019.05.01추가
	 * 매치정보 매치정보 창 띄우기 GET
	 */
	@RequestMapping(value = "/match/matchBoard", method = RequestMethod.GET)
	public void matchBoardGet(Model model, HttpServletRequest req, String selectRegion, Match match, User user, HttpSession session) {
		System.out.println("match/matchBoard:"+selectRegion);
		
		//0일 때 & 빈칸일 때 >> 전체 조회
		if(selectRegion.equals("0") || selectRegion.equals("")) {
			selectRegion = "";
			
		}
		
		//2019.05.01 조건 부분 여기서 처리
		//이달의 매치정보 가져오기(matchBoard.jsp)
		List<Match> matchList = matchService.selectMatchOnThisMonth(selectRegion);
	
		//2019/05/08 날짜 비교
		boolean curDateYn = false;
		String dateComment="";
		
		//1.date 변수 초기화
		Date curDate = matchService.selectCurDate();
		
		//2.simpleDateFormat으로 형식지정
		SimpleDateFormat translate1 = new SimpleDateFormat("yyyyMMdd");
		
		String compareDate="";//현재날짜 담을 STR변수
		//3. date를 String 변환(현재 시간)
		if(compareDate.equals("")) {//빈값일 때 예외처리
			 compareDate="";
		}
		compareDate=translate1.format(curDate);
		
		//4. int형으로(현재시간) 
		int IntegerCompareDate = Integer.parseInt(compareDate);
		
		//MatchList 반복하면서 값 비교
		for(int i = 0; i<matchList.size(); i++) {
			
			//5. 경기날짜 date 변수로 담기
			Date match_date = matchList.get(i).getFight_date();
			
			//6. simpleDateFormat으로 형식지정
			SimpleDateFormat translate2 = new SimpleDateFormat("yyyyMMdd");
			
			//7. fight_date에 담기
			String fight_Date = "";
			if(fight_Date.equals("")) {//빈값일 때 예외처리
				fight_Date = "";
			}
			
			fight_Date=translate2.format(match_date);
			
			//8. int형으로 변환(경기날짜)
			int integerFight_date = Integer.parseInt(fight_Date);
			
			if(integerFight_date <= IntegerCompareDate) {//현재날짜가 더 크거나 같으면( 경기날짜보다 오래됨 )
				curDateYn = false;
				
				try {
					//date형으로 다시 변환
					match_date = translate2.parse(fight_Date);
					curDate = translate1.parse(compareDate);
				} catch (ParseException e) {
					e.printStackTrace();
				}
				dateComment = "기간만료";
//				System.out.println("match/matchBoard dateComment : "+dateComment);
				matchList.get(i).setCurDateYn(curDateYn);
				
			}else {
				curDateYn = true;
				
				try {
					//date형으로 다시 변환
					match_date = translate2.parse(fight_Date);
					curDate = translate1.parse(compareDate);
				} catch (ParseException e) {
					e.printStackTrace();
				}
				
				dateComment = "매치신청";

				//불린값 리스트에 넣어주기
				matchList.get(i).setCurDateYn(curDateYn);
			}
		}
		//2019.05.09 신청한 팀 이미 있는지 여부검사
		//이미 신청한 매치인지 여부 판단
//		boolean pickYn = false;
//		pickYn= matchService.pickYn(match);
//				
//		System.out.println("매치여부 판단 user넘버  : "+match);
//		System.out.println("pickedMatch : "+pickYn);
//		if(pickYn==true) {
//			match.setPickYn(pickYn);
//			model.addAttribute("pickYn", pickYn);
//		}else {
//			match.setPickYn(pickYn);
//			model.addAttribute("pickYn", pickYn);
//				}
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
	public void matchApplyGet(Model model, Match match, HttpSession session, int match_no) {

		System.out.println("==매치신청 get 컨트롤러==");
		
		User user = new User();	
		user.setUser_no((int)session.getAttribute("user_no"));
		
		//팀번호 가져오기
		String team_no = mypageDao.getUserTeamNo(user);
		int team_No = Integer.parseInt(team_no);
		user.setTeam_no(team_No);
		
//		//2019/05/07 매치신청 버튼 클릭시 db에 저장 및 신청한 리스트에 띄우기
		match = matchService.selectMatchByMatchNo(match_no);
		System.out.println("매치:"+match.toString());
//		System.out.println("matchApply 매치번호로 매치정보 조회 (match):"+match);
			
		//model 지정
		model.addAttribute("match", match);
	}

	/*
	 * 2019.05.09
	 * 매치신청 매치신청 창 띄우기 POST
	 */
	@RequestMapping(value = "/match/matchApply", method = RequestMethod.POST)
	public String matchApplyPost(Model model, Match match, HttpSession session, int match_no) {
		
		System.out.println("==매치신청 post 컨트롤러==");
		//user dto 를 파라미터로 담아줘야 user_no에 해당하는 team_no도 들어가서 업데이트가 됨
//		//매치 신청자 정보 세션에서 user_no값 얻어오기
		User user = new User();	
		user.setUser_no((int)session.getAttribute("user_no"));
		
		//팀번호 가져오기
		String team_no = mypageDao.getUserTeamNo(user);
		int team_No = Integer.parseInt(team_no);
		user.setTeam_no(team_No);
		
		System.out.println("유저:"+user.toString());
		
		//==============================================================================================
		//매치정보 가져오기(match_no로)
		//2019/05/07 매치신청 버튼 클릭시 db에 저장 및 신청한 리스트에 띄우기
		match = matchService.selectMatchByMatchNo(match_no);
		System.out.println("matchApply 매치번호로 매치정보 조회 (match):"+match);
		
		//DB 업뎃(매개변수 신청한 사람 session에서 얻어온 값으로 업뎃)
		matchService.applyMatch(user, match_no);
		//리다이렉트
		return "redirect:/mypage/teamMatchInfo";
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
		
		// 파라미터 받기
		String paramMatch_money = request.getParameter("match_money");
		String match_uniform = request.getParameter("match_uniform");
		String match_region = request.getParameter("match_region");
		String match_content = request.getParameter("match_content");
		String match_ground = request.getParameter("match_ground");
		
		//2019/05/07 수정 ::구장 있는지 여부
		String match_ground_yn="";

		// 구장, 구장비 입력 안했을 경우
		if(match_ground.equals("")) {
			
			//구장 선택안했을 때 ::미정 출력::
			match_ground_yn = "N";
			match.setMatch_ground_yn(match_ground_yn);
			match_ground="미정";
			match.setFight_date(fight_date);
			
			match.setMatch_ground(match_ground);
			match.setMatch_uniform(match_uniform);
			match.setMatch_region(match_region);
			match.setMatch_content(match_content);
			match.setBlueteam_no(user.getTeam_no());
			match.setUser_no(user.getUser_no());
			// 등록하면 Match 테이블에 넣기
			matchService.enrollMatch(match);
		}else{
			// match_money 값 int형으로 변환
			 int match_money = Integer.parseInt(paramMatch_money);
			
			match_ground_yn = "Y";
			
			//세팅 ::기간만료 부분은 match/matchBoard부분에서 처리::
			match.setMatch_ground_yn(match_ground_yn);
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
		}
		return "redirect:/match/matchBoard?selectRegion=0";

	}
}
