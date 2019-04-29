package com.fm.www.service.face;

import java.util.List;

import com.fm.www.dto.Team;
import com.fm.www.dto.User;

public interface MypageService {
	
	//유저넘버로 팀넘버 있는지 없는지 검사
	public boolean getUserTeamNo(User user);
	
	//팀 생성
	public void insertTeam(Team team);

	//팀번호 가져오기
	public int selectTeamNo(Team team);

	//유저번호에 팀 가입날짜 넣어주기
	public void updateTeamDate(User user);
	
	//유저번호에 팀번호 넣어주기
	public void updateTeamNo(User user);
	
	//유저번호로 팀번호 가져오기
	public int selectTeamNoUserNo(User user);
	
	//유저가 가진 팀번호의 팀정보 조회
	public Team selectTeamInfoMation(User user);
	
	//팀번호로 유저 조회
	public List<User> selectTeamUserList(int team_no);
	
	


	

}
