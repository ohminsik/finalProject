package com.fm.www.service.face;

import java.util.List;

import com.fm.www.dto.Team;
import com.fm.www.util.Paging;

public interface TeamService {

	//현재페이지수 가져오기
	public int getCurPage(String cur);
	
	//전체 갯수 가져오기
	public int teamTotalCount(String word, int i);

	//팀리스트 가져오기
	public List<Team> teamGetList(Paging paging, String word, int i);

}

