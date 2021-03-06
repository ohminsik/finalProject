package com.fm.www.service.impl;


import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fm.www.dao.face.AdminDao;
import com.fm.www.dto.Admin;
import com.fm.www.dto.Board_tb;
import com.fm.www.dto.Ground;
import com.fm.www.dto.Photo;
import com.fm.www.dto.Team;
import com.fm.www.dto.Tournament;
import com.fm.www.dto.User;
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
	// 이전 글 가져오기
	@Override
	public Board_tb boardUpdate(int board_no) {
		return adminDao.boardUpdate(board_no);
	}
	// 이전 파일 가져오기
	@Override
	public Photo photoUpdate(Photo photo) {
		return adminDao.photoUpdate(photo);
	}
	//파일첨부 존재 여부
	@Override
	public int adminPhotoCheck(int board_no) {
		return adminDao.adminPhotoCheck(board_no);
	}
	//수정 글쓰기
	@Override
	public void adminBoardWrite(Board_tb board) {
		adminDao.adminBoardWrite(board);
	}
	@Override
	public void adminPhotoWrite(Photo photo) {
		adminDao.adminPhotoWrite(photo);
	}
	// 경기장 게시글 주소 등록
	@Override
	public void adminInsertGround(Ground ground, int board_div) {
		adminDao.adminInsertGround(ground, board_div);
	}
	// 유저 토탈 카운트 
	@Override
	public int memTotalCount(String search, String word, User user) {
		return adminDao.memTotalCounnt(search, word, user);
	}
	// 유저 페이징 처리
	@Override
	public List<User> userGetList(Paging paging, String search, String word) {
		return adminDao.userGetList(paging, search, word);
	}
	// 유저 삭제
	@Override
	public void userDelete(int parseInt) {
		adminDao.userDelete(parseInt);
	}
	// 팀 토탈 카운트
	@Override
	public int teamTotalCount(String search, String word, Team team) {
		return adminDao.teamTotalCount(search, word, team);
	}
	// 팀 페이징 처리
	@Override
	public List<Team> teamGetList(Paging paging, String search, String word) {
		return adminDao.teamGetList(paging, search, word);
	}
	// 팀 삭제
	@Override
	public void teamDelete(int parseInt) {
		adminDao.teamDelete(parseInt);
	}
	//대회 게시글 작성
	@Override
	public void tournamentInsert1(Tournament tournament) {
		adminDao.tournamentInsert1(tournament);
	}
	@Override
	public int todayJoinCnt(Date currentTime) {
		return adminDao.todayJoinCnt(currentTime);
	}
	@Override
	public int totalJoinCnt() {
		return adminDao.totalJoinCnt();
	}
	@Override
	public int todayMatchCnt() {
		return adminDao.todayMatchCnt();
	}
	@Override
	public int totalMatchCnt() {
		return adminDao.totalMatchCnt();
	}
	//이전 대회 가져오기
	@Override
	public Tournament tournamentUpdate(Tournament tournament) {
		return adminDao.tournamentUpdate(tournament);
	}
	//대회 수정
	@Override
	public void adminTournamentWrite(Tournament tournament) {
		adminDao.adminTournamentWrite(tournament);
	}
	
	

}
