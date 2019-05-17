package com.fm.www.dao.face;

import java.util.Date;
import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.fm.www.dto.Match;
import com.fm.www.dto.Team;
import com.fm.www.dto.User;

public interface MatchDao {

	//매치등록
	public void enrollMatch(Match match);
	//user정보 조회
	public User selectUserByuserNo(int user_no);
	//이달의 매치
//	public List<Match> selectMatchOnThisMonth();
	
	//매치 등록여부 검사
	public int selectCntMatch(int user_no);
	
	//조건검사 및 전체검사
	public List<Match> selectMatchOnThisMonth(HashMap param);
//	public List<Match> selectMatchOnThisMonth(@Param ("selectRegion")String selectRegion);
	
	//신청할 매치정보 조회
	public Match selectMatchByMatchNo(int match_no);
	
	//매치신청 클릭시 db업뎃
	public void applyMatch(@Param("user")User user, @Param("mno")int match_no);
	
	//현재날짜 조회
	public Date selectCurDate();
	
	//랜덤 매칭 팀 조회
	public List<Team> selectRandomMatchList(Team team);
	
//	public int selectMatchCnt(Match match);
	public List<HashMap<String, Integer>> selectMatchCnt(Match match);
//	//이미 신청한 팀이 있는지 개수 조회
//	public int cntPickedMatch(Match match);

	
}
