package com.fm.www.service.impl;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fm.www.dao.face.AdminDao;
import com.fm.www.dto.Admin;
import com.fm.www.dto.Board_tb;
import com.fm.www.dto.Photo;
import com.fm.www.service.face.AdminService;
import com.fm.www.util.Paging;

@Service
public class AdminServiceImpl implements AdminService{
	@Autowired AdminDao adminDao;

	@Override
	public boolean loginYN(Admin admin) {
		if(adminDao.loginYN(admin) == 1) {
			return true;
		}else {
			return false;
		}
		
	}
	// 게시글 전체 수
	@Override
	public int boardTotalCount(String search, String word, String board_div) {
		return adminDao.boardTotalCount(search, word, board_div);
	}
	// 게시판 페이징 리스트 처리
	@Override
	public List<Board_tb> boardGetList(Paging paging, String search, String word, String board_div) {
		return adminDao.boardGetList(paging, search, word, board_div);
	}
	// 댓글 갯수 구하기
	@Override
	public int boardreplyCount(int board_no) {
		return adminDao.boardReplyCount(board_no);
	}
	// 게시글 삭제
	@Override
	public void boardDelete(int board_no) {
		adminDao.boardDelete(board_no);
	}
	// 게시글 선택 삭제
	@Override
	public void boardCheckDelete(int board_no) {
		adminDao.boardCheckDelete(board_no);
	}
	// 게시글 작성 시퀀스 번호 생성
	@Override
	public int adminGetBoard_no() {
		return adminDao.adminGetBoard_no();
	}
	// 생성된 시퀀스 번호에 게시글 작성
	@Override
	public void adminInsertWrite1(Board_tb board_tb, int board_div) {
		adminDao.adminInsertWrite1(board_tb, board_div);
	}
	@Override
	public void adminInsertPhoto(Photo photo, int board_div) {
		adminDao.adminInsertPhoto(photo, board_div);
	}
	// 로그인 닉네임 가져오기
	@Override
	public int getAdminNo(Admin admin) {
		return adminDao.getAdminNo(admin);
	}
	// 관리자 게시판 이미지 파일 없이 글 작성
	@Override
	public void adminInsertWrite2(Board_tb board_tb) {
		adminDao.adminInsertWrite2(board_tb);
	}
	

}
