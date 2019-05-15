package com.fm.www.dao.face;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.fm.www.dto.Photo;
import com.fm.www.dto.Tournament;
import com.fm.www.util.Paging2;

public interface TournamentDao {

	//대회 게시글 전체 수 region조회
	public int tournamentTotalCount1(String region);
	// 대회 페이징 리스트 처리
	public List<Tournament> tournamentRegionGetList(@Param("p1")Paging2 paging2);
	// 지정 게시글 정보 가져오기
	public Tournament tournamentView(int board_no);
	//사진 가져오기
	public Photo PhotoView(int board_no);
	//board_no로 게시글 사진 조회
	public String photoStoredName(int board_no);
	//대회 게시글 전체 수 condates 조회
	public int tournamentTotalCount2(String condates);
	// 대회 페이징 리스트 처리
	public List<Tournament> tournamentMonthGetList(@Param("p1")Paging2 paging2);
	//현제날짜 받기
	public Date selectDate();
	//대회시작날짜 받기
	public Date selectcon_con_dates(String con_dates);

}
