package com.fm.www.dao.face;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.fm.www.dto.Admin;
import com.fm.www.dto.Board_tb;
import com.fm.www.dto.Photo;
import com.fm.www.util.Paging;

public interface AdminDao {

	public int loginYN(Admin admin);
	// 게시글 전체 수
	public int boardTotalCount(@Param("search")String search, @Param("word")String word, @Param("board_div")String board_div);
	// 게시판 페이징 리스트 처리
	public List<Board_tb> boardGetList(@Param("paging")Paging paging, @Param("search")String search, @Param("word")String word, @Param("board_div")String board_div);
	// 댓글 갯수 구하기
	public int boardReplyCount(int board_no);
	// 게시글 삭제
	public void boardDelete(int board_no);
	// 게시글 작성 시퀀스 번호 생성
	public int adminGetBoard_no();
	// 생성된 시퀀스 번호에 게시글 작성
	public void adminInsertWrite1(@Param("board_tb")Board_tb board_tb, @Param("board_div")int board_div);
	public void adminInsertPhoto(@Param("photo")Photo photo, @Param("board_div")int board_div);
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


	
}
