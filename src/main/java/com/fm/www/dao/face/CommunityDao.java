package com.fm.www.dao.face;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.fm.www.dto.Board_Reply;
import com.fm.www.dto.Board_tb;
import com.fm.www.dto.Movie;
import com.fm.www.dto.Photo;
import com.fm.www.util.Paging;

public interface CommunityDao {


	// 공지사항 게시글 전체 수 
	public int noticeTotalCount(@Param("search")String search, @Param("word")String word);
	// 공지사항 페이징 처리
	public List<Board_tb> noticeGetList(@Param("paging")Paging paging, @Param("search")String search, @Param("word")String word);
	// 지정 게시글 정보 가져오기
	public Board_tb noticeView(int board_no);
	// 조회수 증가
	public void noticeUphit(int board_no);
	// 글 번호 생성하기
	public int noticeGetBoard_no();
	// 글 번호찾아 글 작성
	public void noticeInsertWrite1(Board_tb board);
	// 글 번호찾아 사진 등록
	public void noticeInsertPhoto(Photo photo);
	// 이미지 파일 없이 글 작성
	public void noticeInsertWrite2(Board_tb board);
	// 사진 정보 가져오기
	public Photo noticePhotoView(int board_no);
	// 게시글 삭제
	public void noticeDelete(int board_no);
	// 댓글 등록
	public void noticeCommentInsert(Board_Reply board_reply);
	// 댓글 리스트
	public List<Board_Reply> noticeReplyList(Board_Reply board_reply);
	// 댓글 삭제
	public void noticeReplyDelete(int reply_no);
	// 댓글 수 가져오기
	public int replyCount(int board_no);
	//팀 가입 인사 리스트 총 개수
	public int teamIntrototalCount(@Param("search")String search,@Param("word")String word);
	//팀 가입 인사 리스트 페이징 처리 및 출력
	public List<Board_tb> teamIntrogetList(Paging paging);
	//팀 가입 인사 view 정보 
	public Board_tb teamIntroView(int board_no);
	//팀 가입 인사 게시글 조회수 증가
	public void teamIntrouphit(int board_no);
	//다음글 번호 가져오기
	public int teamIntrogetboard_no();
	//글쓰기
	public void teamIntrowrite(Board_tb board_tb);
	//파일첨부
	public void teamIntrophotowrite(Photo photo);
	//팀 가입 인사 photo view 정보
	public Photo teamIntrophotoView(int board_no);
	//팀 가입 인사 검색 리스트  개수
	public int teamIntrosearchtotalCount(@Param("search")String search, @Param("word")String word);
	//팀 가입 인사 검색리스트 페이징 처리 및 출력
	public List<Board_tb> teamIntroserachgetList(Paging paging);
	//팀 가입 인사 삭제
	public void teamIntrodelete(int board_no);
	// 수정전 글 가져오기
	public Board_tb teamIntrogetupdateview(int board_no);
	// 수정전 파일첨부 가져오기
	public Photo teamIntrogetUpdatePhoto(int board_no);
	// 수정 글 쓰기
	public void teamIntroupdate(Board_tb board_tb);
	// 수정 파일 첨부
	public void teamIntrophotoupdate(Photo photo);
	//파일첨부 존재 여부
	public int teamIntrocntphoto(int board_no);
	//팀 가입 인사 댓글 등록
	public void teamIntroCommentInsert(Board_Reply board_reply);
	//댓글 리스트 정보
	public List<Board_Reply> teamIntrogetreplylist(int board_no);
	//팀 가입 인사 댓글 삭제
	public void teamIntroCommentDelete(int reply_no);
	//댓글 리스트 개수 가져오기
	public int teamIntrototalreplyCnt(int i);
	
	//-----------------------자유 free---------------------------------------
	// 자유 게시글 전체 수 
	public int freeTotalCount(@Param("search")String search, @Param("word")String word);
	// 자유게시글 페이징 리스트 처리
	public List<Board_tb> freeGetList(@Param("paging")Paging paging, @Param("search")String search, @Param("word")String word);
	// 자유 게시글 번호 생성하기
	public int freeGetBoard_no();
	// 자유 글 번호 찾아 글 작성
	public void freeInserWrite1(Board_tb board_tb);
	public void freeInsertPhoto(Photo photo);
	// 자유 이미지 파일 없이 글 작성
	public void freeInsertWrite2(Board_tb board_tb);
	// 자유 조회수 증가
	public void freeUpHit(int board_no);
	// 자유 지정 게시글 정보 가져오기
	public Board_tb freeView(int board_no);
	// 자유 사진 가져오기
	public Photo freePhotoView(int board_no);
	// 자유 댓글 리스트 가져오기
	public List<Board_Reply> freeReplyList(Board_Reply board_reply);
	// 자유 수정 전 글 가져오기
	public Board_tb freeUpdateView(int board_no);
	// 자유 수정전 파일첨부 가져오기
	public Photo freeUpdatePhoto(int board_no);
	// 자유 파일첨부 존재 여부
	public int freeCntPhoto(int board_no);
	// 자유 수정 글쓰기
	public void freeUpdate(Board_tb board_tb);
	// 자유 이미지 존재 할 때 수정 파일첨부
	public void freePhotoUpdate(Photo photo);
	// 자유 이미지 없을 때 파일첨부
	public void freePhotoWrite(Photo photo);
	// 자유 삭제
	public void freeDelete(int board_no);
	// 자유 댓글 등록
	public void freeCommentInsert(Board_Reply board_reply);
	// 자유 댓글 삭제
	public void freeCommentDelete(int reply_no);
	// 자유 댓글 갯수 구하기
	public int freeReplyCount(int board_no);
	
	//-----------------------경기 후기 review---------------------------------------
	// 경기 후기 게시글 전체 수
	public int reviewTotalCount(@Param("search")String search, @Param("word")String word);
	// 경기 후기 게시글  페이징 리스트 처리
	public List<Board_tb> reviewGetList(@Param("paging")Paging paging, @Param("search")String search, @Param("word")String word);
	// 경기 후기 댓글 갯수 구하기
	public int reviewReplyCount(int board_no);
	// 경기 후기 글 번호 생성하기
	public int reviewGetBoard_no();
	// 경기 후기 글 번호 찾아 글 작성
	public void reviewInsertWrite1(Board_tb board_tb);
	public void reviewInsertPhoto(Photo photo);
	// 경기 후기 이미지 파일 없이 글 작성
	public void reviewInsertWrite2(Board_tb board_tb);
	// 경기 후기 수정전 글 가져오기
	public Board_tb reviewUpdateView(int board_no);
	// 경기 후기 수정전 파일첨부 가져오기
	public Photo reviewUpdatePhoto(int board_no);
	// 경기 후기 파일첨부 존재 여부
	public int reviewCntPhoto(int board_no);
	// 경기 후기 이미지 없을 때 파일첨부
	public void reviewPhotoWrite(Photo photo);
	// 경기 후기 수정 글쓰기
	public void reviewUpdate(Board_tb board_tb);
	// 경기 후기 이미지 존재 할 때 수정 파일첨부
	public void reviewPhotoUpdate(Photo photo);
	// 자유 댓글 등록
	public void reviewCommentInsert(Board_Reply board_reply);
	
	// ------------------ 중고장터  market ----------------------
	// 중고장터 게시글 전체 수
	public int usedTotalCount(@Param("search")String search, @Param("word")String word);
	// 중고장터 게시글 페이징 리스트 처리
	public List<Board_tb> usedGetList(@Param("paging")Paging paging, @Param("search")String search, @Param("word")String word);
	// 중고장터 후기 글 번호 찾아 글 작성
	public void usedInsertWrite1(Board_tb board_tb);
	public void usedInsertPhoto(Photo photo);
	// 중고장터 이미지 파일 없이 글 작성
	public void usedInsertWrite2(Board_tb board_tb);
	// 중고장터 이미지 없을 때 파일첨부
	public void usedPhotoWrite(Photo photo);
	// 중고장터 댓글 등록
	public void usedCommentInsert(Board_Reply board_reply);
	
	//-- 축구 동영상
	//축구동영상 리스트 총 개수
	public int soccerVideototalCount(@Param("search")String search, @Param("word")String word);
	//축구 동영상 리스트 페이징 처리 및 출력
	public List<Board_tb> soccerVideoListgetList(Paging paging);
	//축구 동영상 댓글 수
	public int soccerVideototalreplyCnt(int board_no);
	//축구 동영상 게시글 조회수 증가
	public void soccerVideouphit(int board_no);
	//축구 동영상 view 정보
	public Board_tb soccerVideoView(int board_no);
	//축구 동영상 upload 영상
	public Movie soccerVideouplodView(int board_no);
	//다음글 글 작성
	public void soccerVideoWrite(Board_tb board_tb);
	//다음글 동영상 업로드
	public void soccerVideoupload(Movie movie);
	//축구 동영상 댓글 등록
	public void soccerVideoCommentInsert(Board_Reply board_reply);
	
	
	//팀 모집 게시판
	
	//총 게시글 얻기(검색후포함)
	public int getteamAddListtotalCnt(@Param("search")String search,@Param("word") String word);
	//조회된 게시글 리스트
	public List<Board_tb> teamAddList(@Param("paging")Paging paging,@Param("search")String search,@Param("word") String word);
	//board_no로 게시글 조회
	public Board_tb teamAddView(int board_no);
	//게시글 등록
	public void teamAddWrite1(Board_tb board_tb);
	//게시글 등록
	public void teamAddWrite2(Board_tb board_tb);
	//게시글 수정
	public void teamAddUpdate(Board_tb board_tb);
	//게시글 삭제
	public void teamAddDelete(int board_no);
	//board_no로 조회된 팀 모집 게시판 댓글 입력 
	public void teamAddCommentInsert(Board_Reply board_reply);
	//팀 모집 게시판 댓글 조회
	public List<Board_Reply> teamAddReplyList(Board_Reply board_reply);
	//팀 모집 게시판 댓글 삭제
	public void teamAddCommentDelete(int reply_no);
	//팀 모집 게시판 게시글 조회수 증가
	public void teamAdduphit(int board_no);
	//다음글 번호 가져오기
	public int teamAddgetboard_no();
	//파일첨부
	public void teamAddphotoWrite(Photo photo);
	//팀 모집 게시글 파일 존재 여부
	public int teamAddcntphoto(int board_no);
	//게시글 파일 수정 
	public void teamAddphotoUpdate(Photo photo);
	//수정전 파일첨부 가져오기
	public Photo teamAddUpdatephoto(int board_no);
	//수정전 글 가져오기
	public Board_tb teamAddUpdateView(int board_no);
	// 조회수 감소
	public void DownHit(int board_no);

}