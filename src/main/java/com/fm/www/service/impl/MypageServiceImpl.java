package com.fm.www.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fm.www.dao.face.MypageDao;
import com.fm.www.dto.Board_tb;
import com.fm.www.dto.Team;
import com.fm.www.dto.User;
import com.fm.www.service.face.MypageService;
import com.fm.www.util.Paging;

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
	//유저번호로 유저조회
	@Override
	public User selectUserInformation(int user_no) {
		return mypageDao.selectUserInformation(user_no);
	}
	
	//유저번호와 유저비밀번호로 비밀번호가 맞는지 조회
	@Override
	public int checkPw(User user) {
		return mypageDao.checkPw(user);
	}
	//유저비밀번호 업데이트
	@Override
	public void pwChange(User user) {
		mypageDao.pwChange(user);
		
	}
	//유저정보 업데이트
	@Override
	public void updateMemberInfo(User user) {
		mypageDao.updateMemberInfo(user);
	}
	//내가 쓴 게시글 현재페이지번호 얻기
	@Override
	public int getCurPage(String cur) {
		// 요청파라미터 curPage 받기
		String param = cur;

		// null이나 ""이 아니면 int로 리턴
		if (param != null && !"".equals(param)) {
			int curPage = Integer.parseInt(param);
			return curPage;
		}

		// null이나 ""면 0으로 반환하기
		return 1;
	}
	//내가 쓴 게시글 총 게시글수 얻기
	@Override
	public int getTotalCountSearch(User user, String search_div, String search_word) {
		return mypageDao.getTotalCountSearch(user,search_div, search_word);
	}
	//내가 쓴 게시글 리스트 가져오기
	@Override
	public List<Board_tb> getPagingListSearch(User user, Paging paging, String search_div, String search_word) {
		return mypageDao.getPagingListSearch(user, paging, search_div, search_word);
	}
	
	//게시글 댓글수 조회하기
	@Override
	public int getBoardReplyCnt(int board_no) {
		return mypageDao.getBoardReplyCnt(board_no);
	}
	
	


	
	

}
