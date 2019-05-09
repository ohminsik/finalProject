package com.fm.www.service.face;

import java.util.Date;
import java.util.List;

import com.fm.www.dto.Match;
import com.fm.www.dto.User;

public interface MatchService {

	//매치 등록
	public void enrollMatch(Match match);
	
	//user_no로 User정보 조회하기
	public User selectUserByuserNo(int user_no);
	
	//매치 정보 리스트
//	public List<Match> selectMatchOnThisMonth();
	
	//매치있는지 여부검사
	public boolean isEnrolled(int user_no);

	public List<Match> selectMatchOnThisMonth(String selectRegion);
	
	//신청할 매치 조회
	public Match selectMatchByMatchNo(int match_no);
	
	//매치 신청 DB update
	public void applyMatch(User user, int match_no);
	
	//현재 날짜 조회
	public Date selectCurDate();
	
//	//이미 신청한 매치인지 검사
//	public boolean pickYn(Match match);

	
}
