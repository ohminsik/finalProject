package com.fm.www.service.face;

import com.fm.www.dto.User;

public interface MemberService {

	public boolean getLoginYn(User user);
	//회원가입
	public void insertMember(User user);
	//로그인한 유저 넘버값 받아오기
	public int getUserNo(User user);
	
	//아이디 체크
	public int checkId(String member_id);
	// 로그인한 유저 닉네임 받아오기
	public String getuserNick(User user);
	
	//팀넘버(매치등록시)
	public String getTeamNo(User user);
	
	//아이디 확인여부
	public boolean find_Id(String user_name, String user_email);
	//아이디 찾기
	public String findId(String user_name, String user_email);
	//비밀번호  확인 여부
	public int find_Pw(String user_id, String user_email);
	//비밀번호 변경
	public void up_pw(User user);
	
	// 카카오톡 로그인 유저 넘버 생성
	public void kkoNo(User user);
	// 카카오 가입 조회
	public int kkoCheck(User user);
	// 카카오 유저 넘버 가져오기
	public int getUserNokko(User user);
	
}
