package com.fm.www.dao.face;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.fm.www.dto.Board_tb;
import com.fm.www.dto.Team;
import com.fm.www.dto.User;
import com.fm.www.util.Paging;

public interface MypageDao {
	//유저넘버로 팀넘버 있는지 없는지 검사
	public String getUserTeamNo(User user);
	
	//팀생성
	public void insertTeam(Team team);
	
	//팀번호 가져오기
	public int selectTeamNo(Team team);
	
	//유저번호에 팀가입날짜 넣어주기
	public void updateTeamDate(User user);
	
	//유저번호에 팀번호 넣어주기
	public void updateTeamNo(User user);
	
	//유저번호로 팀번호 가져오기
	public int selectTeamNoUserNo(User user);
	
	//유저가 가진 팀번호의 팀정보 조회
	public Team selectTeamInfoMation(User user);

	//팀번호로 유저들 조회
	public List<User> selectTeamUserList(int team_no);
	
	//유저번호로 유저정보 조회
	public User selectUserInformation(int user_no);
	
	//유저번호와 유저비밀번호로 비밀번호가 맞는지 조회
	public int checkPw(User user);
	
	//유저비밀번호 변경
	public void pwChange(User user);
	
	//유저정보 업데이트
	public void updateMemberInfo(User user);

	//내가 쓴 게시글 총 게시글수 얻기
	public int getTotalCountSearch(@Param("p1") User user, @Param("p2")String search_div, @Param("p3")String search_word);

	//내가 쓴 게시글 리스트 가져오기
	public List<Board_tb> getPagingListSearch( @Param("p1")User user, @Param("p2")Paging paging, @Param("p3")String search_div, @Param("p4")String search_word);

	//게시글 댓글수 가져오기
	public int getBoardReplyCnt(int board_no);

	
	
	

}
