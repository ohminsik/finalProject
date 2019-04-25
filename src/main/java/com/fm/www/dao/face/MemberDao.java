package com.fm.www.dao.face;

import com.fm.www.dto.User;

public interface MemberDao {

	//로그인된 id, pw 개수 반환
	public int selectCntIdAndPass(User user);
	
	//회원가입
	public void insertMember(User user);
	
}
