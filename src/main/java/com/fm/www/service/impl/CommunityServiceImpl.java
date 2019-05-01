package com.fm.www.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fm.www.dao.face.CommunityDao;
import com.fm.www.dto.Board_Reply;
import com.fm.www.dto.Board_tb;
import com.fm.www.dto.Photo;
import com.fm.www.service.face.CommunityService;
import com.fm.www.util.Paging;

@Service
public class CommunityServiceImpl implements CommunityService{
	@Autowired CommunityDao communityDao;

	// 공지사항 게시글 전체 수 
	@Override
	public int noticeTotalCount(String search, String word) {
		return communityDao.noticeTotalCount(search, word);
	}
	// 공지사항 페이징 처리
	@Override
	public List<Board_tb> noticeGetList(Paging paging, String search, String word) {
		return communityDao.noticeGetList(paging, search, word);
	}
	// 지정 게시글 정보 가져오기
	@Override
	public Board_tb noticeView(int board_no) {
		return communityDao.noticeView(board_no);
	}
	// 조회수 증가
	@Override
	public void noticeUpHit(int board_no) {
		communityDao.noticeUphit(board_no);
	}
	// 글 번호 생성하기
	@Override
	public int noticeGetBoard_no() {
		return communityDao.noticeGetBoard_no();
	}
	// 글 번호찾아 글 작성
	@Override
	public void noticeInsertWrite1(Board_tb board) {
		communityDao.noticeInsertWrite1(board);
	}
	// 글 번호 찾아 사진 등록
	@Override
	public void noticeInsertPhoto(Photo photo) {
		communityDao.noticeInsertPhoto(photo);
	}
	// 이미지 파일 없이 글 작성
	@Override
	public void noticeInsertWrite2(Board_tb board) {
		communityDao.noticeInsertWrite2(board);
	}
	// 사진 정보 가져오기
	@Override
	public Photo noticePhotoView(int board_no) {
		return communityDao.noticePhotoView(board_no);
	}
	// 게시글 삭제
	@Override
	public void noticeDelete(int board_no) {
		communityDao.noticeDelete(board_no);
	}
	// 댓글 작성
	@Override
	public void noticeCommentInsert(Board_Reply board_reply) {
		communityDao.noticeCommentInsert(board_reply);
	}
	// 댓글 리스트
	@Override
	public List<Board_Reply> ReplyList(Board_Reply board_reply) {
		return communityDao.noticeReplyList(board_reply);
	}
	// 댓글 삭제
	@Override
	public void noticeReplyDelete(int reply_no) {
		communityDao.noticeReplyDelete(reply_no);
	}
	// 댓글 수 가져오기
	@Override
	public int replyCount(int board_no) {
		
		return communityDao.replyCount(board_no);
	}
	

		

	


}
