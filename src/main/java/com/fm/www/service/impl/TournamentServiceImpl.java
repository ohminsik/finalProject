package com.fm.www.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fm.www.dao.face.TournamentDao;
import com.fm.www.dto.Tournament;
import com.fm.www.service.face.TournamentService;
import com.fm.www.util.Paging2;

@Service
public class TournamentServiceImpl implements TournamentService{
	@Autowired TournamentDao tournamentDao;

	//대회 게시글 전체 수
	@Override
	public int tournamentTotalCount(String region) {
		return tournamentDao.tournamentTotalCount(region);
	}
	// 대회 페이징 리스트 처리
	@Override
	public List<Tournament> tournamentRegionGetList(Paging2 paging2) {
		return tournamentDao.tournamentRegionGetList(paging2);
	}
	//현제 페이지 번호 받기
	@Override
	public int getcurPage(String curPage) {
		// 요청 파라미터 받기
		String param = curPage;
		// null이거나 ""이 아니면 int로 리턴
		if (param != null && !"".equals(param)) {
			int cur= Integer.parseInt(param);
			return cur;
		}
		
		//null이나 ""면 0으로 반환하기
		return 1;
	}
	// 지정 게시글 정보 가져오기
	@Override
	public Tournament tournamentView(int board_no) {
		return tournamentDao.tournamentView(board_no);
	}
}
