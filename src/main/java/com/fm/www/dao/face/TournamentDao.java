package com.fm.www.dao.face;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.fm.www.dto.Tournament;
import com.fm.www.util.Paging2;

public interface TournamentDao {

	//대회 게시글 전체 수
	public int tournamentTotalCount(String region);
	// 대회 페이징 리스트 처리
	public List<Tournament> tournamentRegionGetList(@Param("p1")Paging2 paging2);
	// 지정 게시글 정보 가져오기
	public Tournament tournamentView(int board_no);

}