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
	
}
