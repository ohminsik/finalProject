package com.fm.www.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fm.www.dao.face.MemberDao;
import com.fm.www.dto.User;
import com.fm.www.service.face.MemberService;

@Service
public class MemberServiceImpl implements MemberService{
	@Autowired MemberDao memberDao;
	
	//로그인 여부
	@Override
	public boolean getLoginYn(User user) {
		
		//로그인된 id, pw 개수 반환
		int cnt = memberDao.selectCntIdAndPass(user);
		
		if(cnt ==1) {
			return true;
		}
		return false;
	}

	@Override
	public void insertMember(User user) {
		memberDao.insertMember(user);
		
	}

	@Override
	public int getUserNo(User user) {
		return memberDao.getUserNo(user);
	}
	
	//아이디체크
	@Override
	public int checkId(String member_id) {
		return memberDao.checkId(member_id);
	}

}
