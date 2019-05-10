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
	
	// 로그인한 유저 닉네임 가져오기
	@Override
	public String getuserNick(User user) {
		return memberDao.getUserNick(user);
	}

	@Override
	public String getTeamNo(User user) {
		return memberDao.getTeamNo(user);
	}

	//아이디 확인여부
	@Override
	public boolean find_Id(String user_name, String user_email) {
		//이름과 이메일로 찾은 아이디 개수 반환
		int cnt = memberDao.find_Id(user_name,user_email);
		
		if(cnt ==1) {
			return true;
		}
		return false;
	}

	//아이디 찾기
	@Override
	public String findId(String user_name, String user_email) {
		return memberDao.findId(user_name,user_email);
	}

	//비밀번호 확인 여부
	@Override
	public int find_Pw(String user_id, String user_email) {
		return memberDao.find_Pw(user_id,user_email);
	}

	//비밀번호 변경

	@Override
	public void up_pw(User user) {
		memberDao.up_pw(user);
	}
	
	// 카카오톡 로그인 유저 넘버 생성
	@Override
	public void kkoNo(User user) {
		memberDao.kkoNo(user);
	}
	// 카카오 가입 조회
	@Override
	public int kkoCheck(User user) {
		return memberDao.kkoCheck(user);
	}
	// 카카오 유저 넘버 가져오기
	@Override
	public int getUserNokko(User user) {
		return memberDao.getUserNokko(user);
	}

	

	

}
