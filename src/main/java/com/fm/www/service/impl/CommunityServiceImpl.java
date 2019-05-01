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
    //팀 가입 인사 리스트 총 개수
	@Override
	public int teamIntrototalCount(String search, String word) {
		
		return communityDao.teamIntrototalCount(search,word);
	}
	//팀 가입 인사 리스트 페이징 처리 및 출력
	@Override
	public List<Board_tb> teamIntrogetList(Paging paging) {
	
		return communityDao.teamIntrogetList(paging);
	}
	//팀 가입 인사 view 정보 
	@Override
	public Board_tb teamIntroView(int board_no) {
		
		return communityDao.teamIntroView(board_no);
	}
	//팀 가입 인사 게시글 조회수 증가
	@Override
	public void teamIntrouphit(int board_no) {
		communityDao.teamIntrouphit(board_no);
		
	}
	//다음글 번호 가져오기
	@Override
	public int teamIntrogetboard_no() {
		
		return communityDao.teamIntrogetboard_no();
	}
	//글쓰기
	@Override
	public void teamIntrowrite(Board_tb board_tb) {
		communityDao.teamIntrowrite(board_tb);
		
	}
	//파일첨부
	@Override
	public void teamIntrophotowrite(Photo photo) {
		communityDao.teamIntrophotowrite(photo);
		
	}
	//팀 가입 인사 photo view 정보
	@Override
	public Photo teamIntrophotoView(int board_no) {
		return communityDao.teamIntrophotoView(board_no);
	}
	//팀 가입 인사 검색 리스트  개수
	@Override
	public int teamIntrosearchtotalCount(String search, String word) {
		
		return communityDao.teamIntrosearchtotalCount(search,word);
	}

	//팀 가입 인사 검색리스트 페이징 처리 및 출력
	@Override
	public List<Board_tb> teamIntroserachgetList(Paging paging) {
		
		return communityDao.teamIntroserachgetList(paging);
	}
	//팀 가입 인사 삭제
	@Override
	public void teamIntrodelete(int board_no) {
		communityDao.teamIntrodelete(board_no);
		
	}
	// 수정전 글 가져오기
	@Override
	public Board_tb teamIntrogetupdateview(int board_no) {
		
		return communityDao.teamIntrogetupdateview(board_no);
	}
	// 수정전 파일첨부 가져오기
	@Override
	public Photo teamIntrogetUpdatePhoto(int board_no) {
		
		return communityDao.teamIntrogetUpdatePhoto(board_no);
	} 
	//수정 글 쓰기
	@Override
	public void teamIntroupdate(Board_tb board_tb) {
		communityDao.teamIntroupdate(board_tb);
		
	}
	//수정 파일 첨부
	@Override
	public void teamIntrophotoupdate(Photo photo) {
		communityDao.teamIntrophotoupdate(photo);
		
	}
	//파일첨부 존재 여부
	@Override
	public int teamIntrocntphoto(int board_no) {
		// TODO Auto-generated method stub
		return communityDao.teamIntrocntphoto(board_no);
	}
	//팀 가입 인사 댓글 등록
	@Override
	public void teamIntroCommentInsert(Board_Reply board_reply) {
		communityDao.teamIntroCommentInsert(board_reply);
		
	}
	//댓글 리스트 정보
	@Override
	public List<Board_Reply> teamIntrogetreplylist(int board_no) {
		
		return communityDao.teamIntrogetreplylist(board_no);
	}
	//팀 가입 인사 댓글 삭제
	@Override
	public void teamIntroCommentDelete(int reply_no) {
		communityDao.teamIntroCommentDelete(reply_no);
		
	}
	//댓글 리스트 개수 가져오기
	@Override
	public int teamIntrototalreplyCnt(int i) {
		
		return communityDao.teamIntrototalreplyCnt(i);
	}

		

	


}
