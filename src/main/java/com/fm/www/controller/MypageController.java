package com.fm.www.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.fm.www.dao.face.CommunityDao;

@Controller
public class MypageController {
	private static final Logger logger = LoggerFactory.getLogger(MypageController.class);
	
	/*----------------------------------------------Mypage mypage Start----------------------------------------------*/
	
	/*
	 * 내정보
	 * 내정보 창 띄우기
	 * GET
	 * */
	@RequestMapping(value = "/mypage/mypageInformation", method = RequestMethod.GET)
	public void mypageInformationGet() {		
		
	}
	
	/*
	 * 내정보
	 * 내정보 수정 창 띄우기
	 * GET
	 * */
	@RequestMapping(value = "/mypage/mypageInformationUpdate", method = RequestMethod.GET)
	public void mypageInformationUpdateGet() {		
		
	}
	
	/*
	 * 내정보
	 * 내정보 처리
	 * POST
	 * */
	@RequestMapping(value = "/mypage/mypageInformationUpdate", method = RequestMethod.POST)
	public void mypageInformationUpdatePost() {		
		
	}
	
	/*
	 * 개인메세지
	 * 게인매세지 창 띄우기
	 * GET
	 * */
	@RequestMapping(value = "/mypage/mypagepersonalMessage", method = RequestMethod.GET)
	public void mypagepersonalMessageGet() {		
		
	}
	
	
	
	/*----------------------------------------------Mypage mypage End----------------------------------------------*/
	
	
	/*----------------------------------------------Mypage team Start----------------------------------------------*/
	
	/*
	 * 팀정보
	 * 팀정보 창 띄우기
	 * GET
	 * */
	@RequestMapping(value = "/mypage/teamInformation", method = RequestMethod.GET)
	public void teamInformationGet() {		
		
	}
	
	/*
	 * 팀생성
	 * 팀생성 창 띄우기
	 * GET
	 * */
	@RequestMapping(value = "/mypage/teamCreate", method = RequestMethod.GET)
	public void teamCreateGet() {		
		
	}
	
	/*
	 * 팀생성
	 * 팀생성 처리 띄우기
	 * POST
	 * */
	@RequestMapping(value = "/mypage/teamCreate", method = RequestMethod.POST)
	public void teamCreatePost() {		
		
	}
	
	/*
	 * 팀수정
	 * 팀수정 창 띄우기
	 * GET
	 * */
	@RequestMapping(value = "/mypage/teamUpdate", method = RequestMethod.GET)
	public void teamUpdateGet() {		
		
	}
	
	/*
	 * 팀수정
	 * 팀수정 처리 띄우기
	 * POST
	 * */
	@RequestMapping(value = "/mypage/teamUpdate", method = RequestMethod.POST)
	public void teamUpdatePost() {		
		
	}
	
	/*
	 * 팀매치정보
	 * 팀매치정보 창 띄우기
	 * GET
	 * */
	@RequestMapping(value = "/mypage/teamMatchInfo", method = RequestMethod.GET)
	public void teamMatchInfoGet() {		
		
	}
	
	/*
	 * 매치결과입력
	 * 매치결과입력 창 띄우기
	 * GET
	 * */
	@RequestMapping(value = "/mypage/teamScoreInsert", method = RequestMethod.GET)
	public void teamScoreInsertGet() {		
		
	}
	
	/*
	 * 매치결과입력
	 * 매치결과입력 처리 띄우기
	 * POST
	 * */
	@RequestMapping(value = "/mypage/teamScoreInsert", method = RequestMethod.POST)
	public void teamScoreInsertPost() {		
		
	}
	
	/*
	 * 팀게시판
	 * 팀게시판 폼 띄우기
	 * GET
	 * */
	@RequestMapping(value = "/mypage/teamBoard", method = RequestMethod.GET)
	public void teamBoardGet() {		
		
	}
	
	/*
	 * 팀게시판View페이지
	 * 팀게시판 폼 띄우기
	 * 댓글 목록 출력
	 * GET
	 * */
	@RequestMapping(value = "/mypage/teamBoardView", method = RequestMethod.GET)
	public void teamBoardViewGet() {		
		
	}
	
	/*
	 * 팀게시판 글쓰기폼
	 * 팀게시판 글쓰기폼 폼 띄우기
	 * GET
	 * */
	@RequestMapping(value = "/mypage/teamBoardWrite", method = RequestMethod.GET)
	public void teamBoardWriteGet() {		
		
	}
	
	/*
	 * 팀게시판 글쓰기폼
	 * 팀게시판 글쓰기폼 처리
	 * POST
	 * */
	@RequestMapping(value = "/mypage/teamBoardWrite", method = RequestMethod.POST)
	public void teamBoardWritePost() {		
		
	}
	
	/*
	 * 팀게시판 수정 폼
	 * 팀게시판 수정 폼 띄우기
	 * GET
	 * */
	@RequestMapping(value = "/mypage/teamBoardUpdate", method = RequestMethod.GET)
	public void teamBoardUpdateGet() {		
		
	}
	
	/*
	 * 팀게시판 수정폼
	 * 팀게시판 수정 처리
	 * POST
	 * */
	@RequestMapping(value = "/mypage/teamBoardUpdate", method = RequestMethod.POST)
	public void teamBoardUpdatePost() {		
		
	}
	
	/*
	 * 팀게시판 삭제폼
	 * 팀게시판 삭제 처리
	 * POST
	 * */
	@RequestMapping(value = "/mypage/teamBoardDelete", method = RequestMethod.GET)
	public void teamBoardDeleteGet() {		
		
	}
	
	/*
	 * teamBoardCommentInsert POST
	 * 팀게시판 댓글 등록 처리 폼
	 * */
	@RequestMapping(value="/mypage/teamBoardCommentInsert", method = RequestMethod.POST)
	public void teamBoardCommentInsertPost() {
		
	}
	
	/*
	 * teamBoardCommentDelete GET
	 * 팀게시판 댓글 삭제 처리 폼
	 * */
	@RequestMapping(value="/mypage/teamBoardCommentDelete", method = RequestMethod.GET)
	public void teamBoardCommentDeleteGet() {
		
	}
	
	/*----------------------------------------------Mypage team End----------------------------------------------*/
	
	
	
}
