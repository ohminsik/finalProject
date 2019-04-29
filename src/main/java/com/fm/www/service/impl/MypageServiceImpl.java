package com.fm.www.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fm.www.dao.face.MypageDao;
import com.fm.www.dto.Team;
import com.fm.www.dto.User;
import com.fm.www.service.face.MypageService;

@Service
public class MypageServiceImpl implements MypageService{
	@Autowired MypageDao mypageDao;

	//유저넘버로 팀넘버 있는지 없는지 검사
	@Override
	public boolean getUserTeamNo(User user) {
		System.out.println(user);
		String userTeamNo = mypageDao.getUserTeamNo(user);	
		
		if(userTeamNo==null) {
			return false;
		}else {
			return true;
		}
	}

	//팀생성
	@Override
	public void insertTeam(Team team) {
		mypageDao.insertTeam(team);
		
	}
	//팀번호 가져오기
	@Override
	public int selectTeamNo(Team team) {
		return mypageDao.selectTeamNo(team);
	}
	
	//유저번호에 팀 가입날짜 넣어주기
	@Override
	public void updateTeamDate(User user) {
		mypageDao.updateTeamDate(user);
		
	}		
		
	//유저번호에 팀번호 넣어주기
	@Override
	public void updateTeamNo(User user) {
		mypageDao.updateTeamNo(user);
		
	}

	//유저번호로 팀번호 가져오기
	@Override
	public int selectTeamNoUserNo(User user) {
		return mypageDao.selectTeamNoUserNo(user);
	}

	//유저가 가진 팀번호의 팀정보 조회
	@Override
	public Team selectTeamInfoMation(User user) {
		return mypageDao.selectTeamInfoMation(user);
	}
	//팀번호로 유저 조회
	@Override
	public List<User> selectTeamUserList(int team_no) {
		return mypageDao.selectTeamUserList(team_no);
	}
	


	
	

}
