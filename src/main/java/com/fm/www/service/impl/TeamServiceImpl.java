package com.fm.www.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fm.www.dao.face.AdminDao;
import com.fm.www.dao.face.TeamDao;
import com.fm.www.dto.Team;
import com.fm.www.service.face.TeamService;
import com.fm.www.util.Paging;

@Service
public class TeamServiceImpl implements TeamService {
	@Autowired TeamDao teamDao;
	
	//현재페이지수
	@Override
	public int getCurPage(String cur) {
		String param = cur;
		// null이나 ""이 아니면 int로 리턴
		if (param != null && !"".equals(param)) {
			int curPage = Integer.parseInt(param);
			return curPage;
		}
		// null이나 ""면 0으로 반환하기
		return 1;
	}
	
	
	//팀 전체 갯수 가져오기
	@Override
	public int teamTotalCount(String word, int i, String team_sport) {
		return teamDao.teamTotalCount(word, i, team_sport);
	}
	
	//팀 전체 긁어오기
	@Override
	public List<Team> teamGetList(Paging paging, String word, int i, String team_sport) {
		return teamDao.teamGetList(paging,word, i, team_sport);
	}


}
