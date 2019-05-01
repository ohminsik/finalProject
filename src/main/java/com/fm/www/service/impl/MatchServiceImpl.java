package com.fm.www.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fm.www.dao.face.MatchDao;
import com.fm.www.dao.face.MemberDao;
import com.fm.www.dto.Match;
import com.fm.www.dto.User;
import com.fm.www.service.face.MatchService;

@Service
public class MatchServiceImpl implements MatchService {

	// MatchDao객체
	@Autowired
	MatchDao matchDao;

	@Override
	public void enrollMatch(Match match) {
		matchDao.enrollMatch(match);
	}

	@Override
	public User selectUserByuserNo(int user_no) {
		return matchDao.selectUserByuserNo(user_no);
	}

	@Override
	public List<Match> selectMatchOnThisMonth() {
		return matchDao.selectMatchOnThisMonth();
	}

	// 등록여부 검사
	@Override
	public boolean isEnrolled(int user_no) {

		System.out.println("MatchServiceImple : " + user_no);

		int matchCnt = matchDao.selectCntMatch(user_no);

		if (matchCnt != 0 ) {// 매치 등록o
			return true;// true반환
		} else {
			return false;// 등록 안되있으면 false반환
		}
	}

}
