package com.fm.www.service.face;

import com.fm.www.dto.User;

public interface MemberService {

	public boolean getLoginYn(User user);
	//회원가입
	public void insertMember(User user);
}
