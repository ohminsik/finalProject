package com.fm.www.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fm.www.dao.face.CommunityDao;
import com.fm.www.dto.Board_Reply;
import com.fm.www.dto.Board_tb;
import com.fm.www.dto.Movie;
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

	//-----------------------자유 free---------------------------------------
	// 자유 게시글 전체 수 
	@Override
	public int freeTotalCount(String search, String word) {
		return communityDao.freeTotalCount(search, word);
	}
	// 자유게시글 페이징 리스트 처리
	@Override
	public List<Board_tb> freeGetList(Paging paging, String search, String word) {
		return communityDao.freeGetList(paging, search, word);
	}
	// 자유 게시글 번호 생성하기
	@Override
	public int freeGetBoard_no() {
		return communityDao.freeGetBoard_no();
	}
	// 자유 글 번호 찾아 글 작성
	@Override
	public void freeInsertWrite1(Board_tb board_tb) {
		communityDao.freeInserWrite1(board_tb);
	}
	@Override
	public void freeInsertPhoto(Photo photo) {
		communityDao.freeInsertPhoto(photo);
	}
	// 자유 이미지 파일 없이 글 작성
	@Override
	public void freeInsertWrite2(Board_tb board_tb) {
		communityDao.freeInsertWrite2(board_tb);
	}
	// 자유 조회수 증가
	@Override
	public void freeUpHit(int board_no) {
		communityDao.freeUpHit(board_no);
	}
	// 자유 지정 게시글 정보 가져오기
	@Override
	public Board_tb freeView(int board_no) {
		return communityDao.freeView(board_no);
	}
	// 자유 사진 가져오기
	@Override
	public Photo freePhotoView(int board_no) {
		return communityDao.freePhotoView(board_no);
	}
	// 자유 댓글 리스트 가져오기
	@Override
	public List<Board_Reply> freeReplyList(Board_Reply board_reply) {
		return communityDao.freeReplyList(board_reply);
	}
	// 자유 수정 전 글 가져오기
	@Override
	public Board_tb freeUpdateView(int board_no) {
		return communityDao.freeUpdateView(board_no);
	}
	// 자유 수정전 파일첨부 가져오기
	@Override
	public Photo freeUpdatePhoto(int board_no) {
		return communityDao.freeUpdatePhoto(board_no);
	}
	// 자유 파일첨부 존재 여부
	@Override
	public int freeCntPhoto(int board_no) {
		return communityDao.freeCntPhoto(board_no);
	}
	// 자유 수정 글쓰기
	@Override
	public void freeUpdate(Board_tb board_tb) {
		communityDao.freeUpdate(board_tb);
	}
	// 자유 이미지 존재 할 때 수정 파일첨부
	@Override
	public void freePhotoUpdate(Photo photo) {
		communityDao.freePhotoUpdate(photo);
	}
	// 자유 이미지 없을 때 파일첨부
	@Override
	public void freePhotoWrite(Photo photo) {
		communityDao.freePhotoWrite(photo);
	}
	// 자유 삭제
	@Override
	public void freeDelete(int board_no) {
		communityDao.freeDelete(board_no);
	}
	// 자유 댓글 등록
	@Override
	public void freeCommentInsert(Board_Reply board_reply) {
		communityDao.freeCommentInsert(board_reply);
	}
	// 자유 댓글 삭제
	@Override
	public void freeCommentDelete(int reply_no) {
		communityDao.freeCommentDelete(reply_no);
	}
	// 자유 댓글 갯수 구하기
	@Override
	public int freeReplyCount(int board_no) {
		return communityDao.freeReplyCount(board_no);
	}
	
	//-----------------------경기 후기 review---------------------------------------
	// 경기 후기 게시글 전체 수
	@Override
	public int reviewTotalCount(String search, String word) {
		return communityDao.reviewTotalCount(search, word);
	}
	// 경기 후기 게시글  페이징 리스트 처리
	@Override
	public List<Board_tb> reviewGetList(Paging paging, String search, String word) {
		return communityDao.reviewGetList(paging, search, word);
	}
	// 경기 후기 댓글 갯수 구하기
	@Override
	public int reviewReplyCount(int board_no) {
		return communityDao.reviewReplyCount(board_no);
	}
	// 경기 후기 글 번호 생성하기
	@Override
	public int reviewGetBoard_no() {
		return communityDao.reviewGetBoard_no();
	}
	// 경기 후기 글 번호 찾아 글 작성
	@Override
	public void reviewInsertWrite1(Board_tb board_tb) {
		communityDao.reviewInsertWrite1(board_tb);
	}
	@Override
	public void reviewInsertPhoto(Photo photo) {
		communityDao.reviewInsertPhoto(photo);
	}
	// 경기 후기 이미지 파일 없이 글 작성
	@Override
	public void reviewInsertWrite2(Board_tb board_tb) {
		communityDao.reviewInsertWrite2(board_tb);
	}
	// 경기 후기 수정전 글 가져오기
	@Override
	public Board_tb reviewUpdateView(int board_no) {
		return communityDao.reviewUpdateView(board_no);
	}
	// 경기 후기 수정전 파일첨부 가져오기
	@Override
	public Photo reviewUpdatePhoto(int board_no) {
		return communityDao.reviewUpdatePhoto(board_no);
	}
	// 경기 후기 파일첨부 존재 여부
	@Override
	public int reviewCntPhoto(int board_no) {
		return communityDao.reviewCntPhoto(board_no);
	}
	// 경기 후기 이미지 없을 때 파일첨부
	@Override
	public void reviewPhotoWrite(Photo photo) {
		communityDao.reviewPhotoWrite(photo);
	}
	// 경기 후기 수정 글쓰기
	@Override
	public void reviewUpdate(Board_tb board_tb) {
		communityDao.reviewUpdate(board_tb);
	}
	// 경기 후기 이미지 존재 할 때 수정 파일첨부
	@Override
	public void reviewPhotoUpdate(Photo photo) {
		communityDao.reviewPhotoUpdate(photo);
	}
	// 자유 댓글 등록
	@Override
	public void reviewCommentInsert(Board_Reply board_reply) {
		communityDao.reviewCommentInsert(board_reply);
	}
	
	// ------------------ 중고장터  market ----------------------
	// 중고장터 게시글 전체 수
	@Override
	public int usedTotalCount(String search, String word) {
		return communityDao.usedTotalCount(search, word);
	}
	// 중고장터 게시글 페이징 리스트 처리
	@Override
	public List<Board_tb> usedGetList(Paging paging, String search, String word) {
		return communityDao.usedGetList(paging, search, word);
	}
	// 중고장터 후기 글 번호 찾아 글 작성
	@Override
	public void usedInsertWrite1(Board_tb board_tb) {
		communityDao.usedInsertWrite1(board_tb);
	}
	@Override
	public void usedInsertPhoto(Photo photo) {
		communityDao.usedInsertPhoto(photo);
	}
	// 중고장터 이미지 파일 없이 글 작성
	@Override
	public void usedInsertWrite2(Board_tb board_tb) {
		communityDao.usedInsertWrite2(board_tb);
	}
	// 중고장터 이미지 없을 때 파일첨부
	@Override
	public void usedPhotoWrite(Photo photo) {
		communityDao.usedPhotoWrite(photo);
	}
	// 중고장터 댓글 등록
	@Override
	public void usedCommentInsert(Board_Reply board_reply) {
		communityDao.usedCommentInsert(board_reply);	
	}
	
	//-- 축구 동영상
	//축구동영상 리스트 총 개수
	@Override
	public int soccerVideototalCount(String search, String word) {
		
		return communityDao.soccerVideototalCount(search, word);
	}
	//축구 동영상 리스트 페이징 처리 및 출력
	@Override
	public List<Board_tb> soccerVideoListgetList(Paging paging) {
	
		return communityDao.soccerVideoListgetList(paging);
	}
	//축구 동영상 댓글 수
	@Override
	public int soccerVideototalreplyCnt(int board_no) {
		
		return communityDao.soccerVideototalreplyCnt(board_no);
	}
	//축구 동영상 게시글 조회수 증가
	@Override
	public void soccerVideouphit(int board_no) {
		communityDao.soccerVideouphit(board_no);
		
	}
	//축구 동영상 view 정보
	@Override
	public Board_tb soccerVideoView(int board_no) {
		
		return communityDao.soccerVideoView(board_no);
	}
	//축구 동영상 upload 영상
	@Override
	public Movie soccerVideouplodView(int board_no) {
		
		return communityDao.soccerVideouplodView(board_no);
	}
	//다음글 글 작성
	@Override
	public void soccerVideoWrite(Board_tb board_tb) {
		communityDao.soccerVideoWrite(board_tb);
		
	}
	//다음글 동영상 업로드
	@Override
	public void soccerVideoupload(Movie movie) {
		communityDao.soccerVideoupload(movie);
		
	}
	//축구 동영상 댓글 등록
	@Override
	public void soccerVideoCommentInsert(Board_Reply board_reply) {
		communityDao.soccerVideoCommentInsert(board_reply);
		
	}

	// 팀 모집 게시판
	//총 게시글 얻기(검색후포함)
	@Override
	public int getteamAddListtotalCnt(String search, String word) {
		return communityDao.getteamAddListtotalCnt(search, word);
	}
	//조회된 게시글 리스트
	@Override
	public List<Board_tb> teamAddList(Paging p, String search, String word) {
		return communityDao.teamAddList(p,search, word);
	}
	//board_no로 게시글 조회
	@Override
	public Board_tb teamAddView(int board_no) {
		return communityDao.teamAddView(board_no);
	}
	//게시글 등록
	@Override
	public void teamAddWrite1(Board_tb board_tb) {
		communityDao.teamAddWrite1(board_tb);
	}
	//게시글 등록
	@Override
	public void teamAddWrite2(Board_tb board_tb) {
		communityDao.teamAddWrite2(board_tb);
	}
	//게시글 수정
	@Override
	public void teamAddUpdate(Board_tb board_tb) {
		communityDao.teamAddUpdate(board_tb);
	}
	//게시글 삭제
	@Override
	public void teamAddDelete(int board_no) {
		communityDao.teamAddDelete(board_no);
		
	}
	//board_no로 조회된 팀 모집 게시판 댓글 입력 
	@Override
	public void teamAddCommentInsert(Board_Reply board_reply) {
		communityDao.teamAddCommentInsert(board_reply);
	}
	//팀 모집 게시판 댓글 조회
	@Override
	public List<Board_Reply> teamAddReplyList(Board_Reply board_reply) {
		return communityDao.teamAddReplyList(board_reply);
	}
	//팀 모집 게시판 댓글 삭제
	@Override
	public void teamAddCommentDelete(int reply_no) {
		communityDao.teamAddCommentDelete(reply_no);
	}
	//팀 모집 게시판 게시글 조회수 증가
	@Override
	public void teamAdduphit(int board_no) {
		communityDao.teamAdduphit(board_no);
	}
	//다음글 번호 가져오기
	@Override
	public int teamAddgetboard_no() {
		return communityDao.teamAddgetboard_no();
	}
	//파일첨부
	@Override
	public void teamAddphotoWrite(Photo photo) {
		communityDao.teamAddphotoWrite(photo);
	}
	//팀 모집 게시글 파일 존재 여부
	@Override
	public int teamAddcntphoto(int board_no) {
		return communityDao.teamAddcntphoto(board_no);
	}
	//게시글 파일 수정 
	@Override
	public void teamAddphotoUpdate(Photo photo) {
		communityDao.teamAddphotoUpdate(photo);
	}
	//수정전 파일첨부 가져오기
	@Override
	public Photo teamAddUpdatephoto(int board_no) {
		return communityDao.teamAddUpdatephoto(board_no);
	}
	//수정전 글 가져오기
	@Override
	public Board_tb teamAddUpdateView(int board_no) {
		return communityDao.teamAddUpdateView(board_no);
	}
	// 조회수 감소
	@Override
	public void DownHit(int board_no) {
		communityDao.DownHit(board_no);
	}
	//board_no로 게시글 사진 조회
	@Override
	public String photoStoredName(int board_no) {
		return communityDao.photoStoredName(board_no);
	}
	//다음글 확인 여부
	@Override
	public boolean NextArticle(Board_tb board_tb) {
		
		int cnt = communityDao.selectCntNextArticle(board_tb);
		
		if(cnt == 1) {
			return true;
		}
		return false;
	}
	//이전글 확인 여부
	@Override
	public boolean PreviousArticle(Board_tb board_tb) {
		
		int cnt = communityDao.selectCntPreviousArticle(board_tb);
		
		if(cnt == 1) {
			return true;
		}
		return false;
	}
	//다음글 번호 가져오기
	@Override
	public int ViewNext(Board_tb board_tb) {
		return communityDao.ViewNext(board_tb);
	}
	//이전글 번호 가져오기
	@Override
	public int ViewPrevious(Board_tb board_tb) {
		return communityDao.ViewPrevious(board_tb);
	}
		
	

}