package com.fm.www.dao.face;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.fm.www.dto.Board_Reply;
import com.fm.www.dto.Board_tb;
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

}
