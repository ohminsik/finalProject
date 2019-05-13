package com.fm.www.service.face;


import java.util.List;

import com.fm.www.dto.Admin;
import com.fm.www.dto.Board_tb;
import com.fm.www.dto.Ground;
import com.fm.www.dto.Photo;
import com.fm.www.dto.Team;
import com.fm.www.dto.User;
import com.fm.www.util.Paging;

public interface AdminService {

	public boolean loginYN(Admin admin);
	// 게시글 전체 수
	public int boardTotalCount(String search, String word, String board_div);
	// 게시판 페이징 리스트 처리
	public List<Board_tb> boardGetList(Paging paging, String search, String word, String board_div);
	// 댓글 갯수 구하기
	public int boardreplyCount(int board_no);
	// 게시글 삭제
	public void boardDelete(int board_no);

	// 게시글 작성 시퀀스 번호 생성
	public int adminGetBoard_no();
	// 생성된 시퀀스 번호에 게시글 작성
	public void adminInsertWrite1(Board_tb board_tb, int board_div);
	public void adminInsertPhoto(Photo photo, int board_div);
	// 로그인 닉네임 가져오기
	public int getAdminNo(Admin admin);
	// 관리자 게시판 이미지 파일 없이 글 작성
	public void adminInsertWrite2(Board_tb board_tb);
	// 이전 글 가져오기 
	public Board_tb boardUpdate(int board_no);
	// 이전 파일 가져오기
	public Photo photoUpdate(Photo photo);
	//파일첨부 존재 여부
	public int adminPhotoCheck(int board_no);
	//수정 글쓰기
	public void adminBoardWrite(Board_tb board);
	//수정 파일첨부
	public void adminPhotoWrite(Photo photo);
	// 경기장 게시글 주소 등록
	public void adminInsertGround(Ground ground, int board_div);
	// 유저  토탈 카운트 
	public int memTotalCount(String search, String word, User user);
	// 유저 페이징 처리
	public List<User> userGetList(Paging paging, String search, String word);
	// 유저 삭제
	public void userDelete(int parseInt);
	// 팀 토탈 카운트
	public int teamTotalCount(String search, String word, Team team);
	// 팀 페이징 처리
	public List<Team> teamGetList(Paging paging, String search, String word);
	// 팀 삭제
	public void teamDelete(int parseInt);

	
}
