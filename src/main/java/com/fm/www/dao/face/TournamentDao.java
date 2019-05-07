package com.fm.www.dao.face;

import java.util.List;

import com.fm.www.dto.Tournament;
import com.fm.www.util.Paging2;

public interface TournamentDao {

	//대회 게시글 전체 수
	public int tournamentTotalCount(String region);
	// 대회 페이징 리스트 처리
	public List<Tournament> tournamentRegionGetList(Paging2 paging2);

}
