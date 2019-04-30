package com.fm.www.dao.face;

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
	
}
