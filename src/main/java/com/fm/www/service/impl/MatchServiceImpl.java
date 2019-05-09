package com.fm.www.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fm.www.dao.face.MatchDao;
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

//	@Override
//	public List<Match> selectMatchOnThisMonth() {
//		return matchDao.selectMatchOnThisMonth();
//	}

	// 매치 등록여부 검사
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

	//매치정보가져오기(조건검색 & 전체검색)
	@Override
	public List<Match> selectMatchOnThisMonth(String selectRegion) {
		return matchDao.selectMatchOnThisMonth(selectRegion);
	}

	//신청할 매치정보
	@Override
	public Match selectMatchByMatchNo(int match_no) {
		return matchDao.selectMatchByMatchNo(match_no);
	}

	//매치신청 클릭시 db업뎃
	@Override
	public void applyMatch(User user, int match_no) {
		matchDao.applyMatch(user, match_no);
	}

	@Override
	public Date selectCurDate() {
		return matchDao.selectCurDate();
	}

//	@Override
//	public boolean pickYn(Match match) {
//		
//		int cnt = matchDao.cntPickedMatch(match);
//		
//		
//		if(cnt==1) {//신청한 팀이 있을 경우
//			return true;
//		}else {//없을 경우
//			return false;
//		}
//	}

	

}
