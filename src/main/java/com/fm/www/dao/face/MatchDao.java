package com.fm.www.dao.face;

import java.util.List;

import com.fm.www.dto.Match;
import com.fm.www.dto.User;

public interface MatchDao {

	//매치등록
	public void enrollMatch(Match match);
	//user정보 조회
	public User selectUserByuserNo(int user_no);
	//이달의 매치
	public List<Match> selectMatchOnThisMonth();
	
	//매치 등록여부 검사
	public int selectCntMatch(int user_no);
}
