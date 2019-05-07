package com.fm.www.service.face;

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
}
