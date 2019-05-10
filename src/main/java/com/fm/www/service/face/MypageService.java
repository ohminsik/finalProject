package com.fm.www.service.face;

import java.util.List;

import com.fm.www.dto.Board_Reply;
import com.fm.www.dto.Board_tb;
import com.fm.www.dto.Match;
import com.fm.www.dto.Message;
import com.fm.www.dto.Photo;
import com.fm.www.dto.Team;
import com.fm.www.dto.User;
import com.fm.www.util.Paging;

public interface MypageService {
	
	//유저넘버로 팀넘버 있는지 없는지 검사
	public boolean getUserTeamNo(User user);
	
	//팀 생성
	public void insertTeam(Team team);

	//팀번호 가져오기
	public int selectTeamNo(Team team);

	//유저번호에 팀 가입날짜 넣어주기
	public void updateTeamDate(User user);
	
	//유저번호에 팀번호 넣어주기
	public void updateTeamNo(User user);
	
	//유저번호로 팀번호 가져오기
	public int selectTeamNoUserNo(User user);
	
	//유저가 가진 팀번호의 팀정보 조회
	public Team selectTeamInfoMation(User user);
	
	//팀번호로 유저 조회
	public List<User> selectTeamUserList(int team_no);
	
	//유저번호로 유저조회
	public User selectUserInformation(int user_no);

	//유저번호와 유저비밀번호로 비밀번호가 맞는지 조회
	public int checkPw(User user);
	
	//유저 비밀번호 업데이트
	public void pwChange(User user);
	
	//유저 정보 업데이트
	public void updateMemberInfo(User user);
	
	//내가 쓴 게시글 현재페이지번호 얻기
	public int getCurPage(String cur);
	
	//내가 쓴 게시글 총 게시글수 얻기
	public int getTotalCountSearch(User user, String search_div, String search_word);
	
	//내가 쓴 게시글 리스트 가져오기
	public List<Board_tb> getPagingListSearch(User user, Paging paging, String search_div, String search_word);
	
	//게시글 댓글갯수 조회하기
	public int getBoardReplyCnt(int board_no);
	
	//내게 온 메세지 리스트 조회
	public List<Message> selectMessage(User user);

	//내게 온 메세지 보낸사람 정보 조회
	public String getSendUserId(int senduser_no);
	public String getSendUserName(int senduser_no);
	
	//메세지 확인으로 변경
	public void updateMessageYn(int messageno);
	//메세지 삭제
	public void deleteMessage(int messageno);

	//개인메세지 답장
	public void replyMessage(Message message);
	
	//팀 게시판 총 게시글 수 얻어오기
	public int getTotalCountSearchTeam(int team_no, String search_div, String search_word);
	
	//팀 게시판 글 가져오기
	public List<Board_tb> getPagingListSearchTeam(int team_no, Paging paging, String search_div, String search_word);

	//팀 글번호 생성하기
	public int teamBoardGetBoard_no();

	//팀 게시판 인써트
	public void teamBoardInsertWrite(Board_tb board_tb);
	public void teamBoardInsertPhoto(Photo photo);
	public void teamBoardInsertWrite2(Board_tb board_tb);
	
	//team_board 삽입
	public void teamBoardInsertTeamBoard(Board_tb board_tb, User user);

	//조회수증가
	public void teamBoardUpHit(int board_no);
	//게시글 정보 가져오기
	public Board_tb teamBoardView(int board_no);
	//사진 가져오기
	public Photo teamBoardPhotoView(int board_no);
	//댓글리스트 가졍오기
	public List<Board_Reply> ReplyList(Board_Reply board_reply);
	
	//파일첨부 존재 여부
	public int teamBoardcntphoto(int board_no);
	//수정 글쓰기
	public void teamBoardupdate(Board_tb board_tb);
	//수정 파일첨부
	public void teamBoardphotoupdate(Photo photo);
	//팀게시글 삭제
	public void teamBoardDelete(int board_no);
	
	//팀 게시판 댓글 등록
	public void teamBoardCommentInsert(Board_Reply board_reply);
	//팀 게시판 조회수 내리기
	public void DownHit(int board_no);
	//댓글삭제
	public void teamBoardReplyDelete(int reply_no);
	
	//팀넘버로 매치리스트 조회
	public List<Match> selectMatchList(int team_no);
	//매치넘버로 경기 조회
	public Match selectMatch(int match_no);
	
	//총전적수 추가
	public void updateEtire(int team_no);
	
	//승수 증가
	public void updateWin(int team_no);
	
	//패수 증가
	public void updateLose(int team_no);
	
	//무승부 증가
	public void updateTie(int team_no);

	//레이팅 업데이트
	public void updateRating(int team_no, int rating);
	
	
	
	


	

}
