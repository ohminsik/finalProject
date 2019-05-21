package com.fm.www.dao.face;

import org.apache.ibatis.annotations.Param;

import com.fm.www.dto.User;

public interface MemberDao {

	//로그인된 id, pw 개수 반환
	public int selectCntIdAndPass(User user);
	
	//회원가입
	public void insertMember(User user);
	
	//로그인한 유저 넘버값 가져오기
	public int getUserNo(User user);
	
	//아이디체크
	public int checkId(String member_id);

	//로그인한 유저 닉네임 가져오기
	public String getUserNick(User user);

	//팀넘버(매치등록)
	public String getTeamNo(User user);
	
	//아이디 확인여부
	public int find_Id(@Param("p1") String user_name, @Param("p2")String user_email);
	//아이디 찾기
	public String findId(@Param("p1") String user_name, @Param("p2")String user_email);
	//비밀번호  확인여부
	public int find_Pw(@Param("p1") String user_id, @Param("p2")String user_email);
	//비밀번호 변경
	public void up_pw(User user);
	
	// 카카오톡 로그인 유저 넘버 생성
	public void kkoNo(User user);
	// 카카오 가입 조회
	public int kkoCheck(User user);
	// 카카오 유저 넘버 가져오기
	public int getUserNokko(User user);

	//유저정보가져오기
	public User getUserInfo(User user);
}
