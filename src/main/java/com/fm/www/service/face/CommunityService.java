package com.fm.www.service.face;

import java.util.List;

import com.fm.www.dto.Board_Reply;
import com.fm.www.dto.Board_tb;
import com.fm.www.dto.Photo;
import com.fm.www.util.Paging;

public interface CommunityService {

	// 공지사항 게시글 전체 수 
	int noticeTotalCount(String search, String word);
	// 공지사항 페이징 처리
	List<Board_tb> noticeGetList(Paging paging, String search, String word);
	// 지정 게시글 정보 가져오기
	Board_tb noticeView(int board_no);
	// 조회수 증가
	void noticeUpHit(int board_no);
	// 글번호 생성하기
	int noticeGetBoard_no();
	// 글 번호 찾아 글 작성
	void noticeInsertWrite1(Board_tb board);
	// 글 번호 찾아 사진 등록
	void noticeInsertPhoto(Photo photo);
	// 이미지 파일 없이 글 작성
	void noticeInsertWrite2(Board_tb board);
	// 사진 정보 가져오기
	Photo noticePhotoView(int board_no);
	// 게시글 삭제
	void noticeDelete(int board_no);
	// 댓글 등록
	void noticeCommentInsert(Board_Reply board_reply);
	// 댓글 리스트
	List<Board_Reply> ReplyList(Board_Reply board_reply);
	// 댓글 삭제
	void noticeReplyDelete(int reply_no);
	// 댓글 수 가져오기
	int replyCount(int board_no);
	
	



	

}
