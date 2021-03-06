package com.fm.www.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fm.www.dao.face.MypageDao;
import com.fm.www.dto.Board_Reply;
import com.fm.www.dto.Board_tb;
import com.fm.www.dto.Match;
import com.fm.www.dto.Message;
import com.fm.www.dto.Photo;
import com.fm.www.dto.Team;
import com.fm.www.dto.TeamApply;
import com.fm.www.dto.User;
import com.fm.www.service.face.MypageService;
import com.fm.www.util.Paging;

@Service
public class MypageServiceImpl implements MypageService{
	@Autowired MypageDao mypageDao;

	//유저넘버로 팀넘버 있는지 없는지 검사
	@Override
	public boolean getUserTeamNo(User user) {
		System.out.println(user);
		String userTeamNo = mypageDao.getUserTeamNo(user);	
		
		if(userTeamNo==null) {
			return false;
		}else {
			return true;
		}
	}

	//팀생성
	@Override
	public void insertTeam(Team team) {
		mypageDao.insertTeam(team);
		
	}
	//팀번호 가져오기
	@Override
	public int selectTeamNo(Team team) {
		return mypageDao.selectTeamNo(team);
	}
	
	//유저번호에 팀 가입날짜 넣어주기
	@Override
	public void updateTeamDate(User user) {
		mypageDao.updateTeamDate(user);
		
	}		
		
	//유저번호에 팀번호 넣어주기
	@Override
	public void updateTeamNo(User user) {
		mypageDao.updateTeamNo(user);
		
	}

	//유저번호로 팀번호 가져오기
	@Override
	public int selectTeamNoUserNo(User user) {
		return mypageDao.selectTeamNoUserNo(user);
	}

	//유저가 가진 팀번호의 팀정보 조회
	@Override
	public Team selectTeamInfoMation(User user) {
		return mypageDao.selectTeamInfoMation(user);
	}
	//팀번호로 유저 조회
	@Override
	public List<User> selectTeamUserList(int team_no) {
		return mypageDao.selectTeamUserList(team_no);
	}
	//유저번호로 유저조회
	@Override
	public User selectUserInformation(int user_no) {
		return mypageDao.selectUserInformation(user_no);
	}
	
	//유저번호와 유저비밀번호로 비밀번호가 맞는지 조회
	@Override
	public int checkPw(User user) {
		return mypageDao.checkPw(user);
	}
	//유저비밀번호 업데이트
	@Override
	public void pwChange(User user) {
		mypageDao.pwChange(user);
		
	}
	//유저정보 업데이트
	@Override
	public void updateMemberInfo(User user) {
		mypageDao.updateMemberInfo(user);
	}
	//내가 쓴 게시글 현재페이지번호 얻기
	@Override
	public int getCurPage(String cur) {
		// 요청파라미터 curPage 받기
		String param = cur;

		// null이나 ""이 아니면 int로 리턴
		if (param != null && !"".equals(param)) {
			int curPage = Integer.parseInt(param);
			return curPage;
		}

		// null이나 ""면 0으로 반환하기
		return 1;
	}
	//내가 쓴 게시글 총 게시글수 얻기
	@Override
	public int getTotalCountSearch(User user, String search_div, String search_word) {
		return mypageDao.getTotalCountSearch(user,search_div, search_word);
	}
	//내가 쓴 게시글 리스트 가져오기
	@Override
	public List<Board_tb> getPagingListSearch(User user, Paging paging, String search_div, String search_word) {
		return mypageDao.getPagingListSearch(user, paging, search_div, search_word);
	}
	
	//게시글 댓글수 조회하기
	@Override
	public int getBoardReplyCnt(int board_no) {
		return mypageDao.getBoardReplyCnt(board_no);
	}
	
	//내게 온 메세지 리스트 조회
	@Override
	public List<Message> selectMessage(User user) {
		return mypageDao.selectMessage(user);
	}

	//내게 온 메세지 보낸사람 정보 조회
	@Override
	public String getSendUserId(int senduser_no) {
		return mypageDao.getSendUserId(senduser_no);
	}
	@Override
	public String getSendUserName(int senduser_no) {
		return mypageDao.getSendUserName(senduser_no);
	}
	
	//메세지 확인으로 변경
	@Override
	public void updateMessageYn(int messageno) {
		mypageDao.updateMessageYn(messageno);
		
	}
	//메세지삭제
	@Override
	public void deleteMessage(int messageno) {
		mypageDao.deleteMessage(messageno);
		
	}

	//개인메세지 답장
	@Override
	public void replyMessage(Message message) {
		mypageDao.replyMessage(message);
		
	}

	//팀 게시판 총 게시글 수 얻어오기
	@Override
	public int getTotalCountSearchTeam(int team_no, String search_div, String search_word) {
		return mypageDao.getTotalCountSearchTeam(team_no, search_div, search_word);
	}
	
	//팀게시판 글 가져오기
	@Override
	public List<Board_tb> getPagingListSearchTeam(int team_no, Paging paging, String search_div, String search_word) {
		return mypageDao.getPagingListSearchTeam(team_no, paging, search_div, search_word);
	}

	//팀 글번호 생성하기
	@Override
	public int teamBoardGetBoard_no() {
		return mypageDao.teamBoardGetBoard_no();
	}

	//팀 게시판  글 인써트
	@Override
	public void teamBoardInsertWrite(Board_tb board_tb) {
		mypageDao.teamBoardInsertWrite(board_tb);
		
	}
	//팀 게시판  사진 인써트
	@Override
	public void teamBoardInsertPhoto(Photo photo) {
		mypageDao.teamBoardInsertPhoto(photo);
		
	}
	//팀 게시판  글 (사진없을때) 인써트
	@Override
	public void teamBoardInsertWrite2(Board_tb board_tb) {
		mypageDao.teamBoardInsertWrite2(board_tb);
		
	}
	//팀 게시판  team_Board 인써트
	@Override
	public void teamBoardInsertTeamBoard(Board_tb board_tb, User user) {
		mypageDao.teamBoardInsertTeamBoard(board_tb, user);
		
	}

	@Override
	public void teamBoardUpHit(int board_no) {
		mypageDao.teamBoardUpHit(board_no);
		
	}

	@Override
	public Board_tb teamBoardView(int board_no) {
		return mypageDao.teamBoardView(board_no);
	}

	@Override
	public Photo teamBoardPhotoView(int board_no) {
		return mypageDao.teamBoardPhotoView(board_no);
	}

	@Override
	public List<Board_Reply> ReplyList(Board_Reply board_reply) {
		return mypageDao.ReplyList(board_reply);
	}

	//파일첨부 존재 여부
	@Override
	public int teamBoardcntphoto(int board_no) {
		return mypageDao.teamBoardcntphoto(board_no);
	}
	
	//수정글쓰기
	@Override
	public void teamBoardupdate(Board_tb board_tb) {
		mypageDao.teamBoardupdate(board_tb);
		
	}
	//수정 파일첨부
	@Override
	public void teamBoardphotoupdate(Photo photo) {
		mypageDao.teamBoardphotoupdate(photo);
		
	}
	//팀게시글삭제
	@Override
	public void teamBoardDelete(int board_no) {
		mypageDao.teamBoardDelete(board_no);
		
	}
	
	//팀게시판 댓글 등록
	@Override
	public void teamBoardCommentInsert(Board_Reply board_reply) {
		mypageDao.teamBoardCommentInsert(board_reply);
		
	}
	//팀 게시글 조회수 감소
	@Override
	public void DownHit(int board_no) {
		mypageDao.DownHit(board_no);
	}
	//댓글삭제
	@Override
	public void teamBoardReplyDelete(int reply_no) {
		mypageDao.teamBoardReplyDelete(reply_no);
		
	}
	
	//팀넘버로 매치리스트 조회
	@Override
	public List<Match> selectMatchList(int team_no) {		
		return mypageDao.selectMatchList(team_no);
	}
	@Override
	public List<Match> selectMatchList1(int team_no) {
		return mypageDao.selectMatchList1(team_no);
	}
	

	//매치넘버로 경기 조회
	@Override
	public Match selectMatch(int match_no) {
		return mypageDao.selectMatch(match_no);
	}
	
	//총 전적수 추가
	@Override
	public void updateEtire(int team_no) {
		mypageDao.updateEtire(team_no);
		
	}

	//승수 증가
	@Override
	public void updateWin(int team_no) {
		mypageDao.updateWin(team_no);
		
	}

	//패수 증가
	@Override
	public void updateLose(int team_no) {
		mypageDao.updateLose(team_no);
		
	}
	//무승부증가
	@Override
	public void updateTie(int team_no) {
		mypageDao.updateTie(team_no);
		
	}
	//레이팅 업데이트
	@Override
	public void updateRating(int team_no, int rating) {
		mypageDao.updateRating(team_no, rating);
	}
	//스코어 업데이트
	@Override
	public void updateScore(Match match) {
		mypageDao.updateScore(match);
		
	}
	//팀 가입신청
	@Override
	public void teamApplyInsert(TeamApply teamApply) {
		mypageDao.teamApplyInsert(teamApply);
	}
	//팀 가입신청 했는지 구분
	@Override
	public boolean teamApplyYN(TeamApply teamApply) {
		if(mypageDao.teamApplyYN(teamApply) == 1) {
			return false;
		}else {
			return true;
		}
		
	}
	
	//팀 번호로 팀 가입리스트 조회
	@Override
	public List<TeamApply> selectTeamApplyList(int team_no) {
		return mypageDao.selectTeamApplyList(team_no);
	}

	//팀 신청 내역 삭제
	@Override
	public void deleteTeamApply(TeamApply teamApply) {
		mypageDao.deleteTeamApply(teamApply);
		
	}
	
	//팀 신청내역 전체 삭제
	@Override
	public void deleteAllTeamApply(TeamApply teamApply) {
		mypageDao.deleteAllTeamApply(teamApply);
		
	}

	@Override
	public List<Match> mypageMatchList(User user) {
		return mypageDao.mypageMatchList(user);
	}

	@Override
	public void updateMatch(int match_no) {
		mypageDao.updateMatch(match_no);
		
	}

	
	


	
	

}
