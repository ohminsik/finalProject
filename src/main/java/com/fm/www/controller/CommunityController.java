package com.fm.www.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.fm.www.service.face.CommunityService;

@Controller
public class CommunityController {
	private static final Logger logger = LoggerFactory.getLogger(CommunityController.class);
	@Autowired CommunityService communityService;
	/*
	 * NoticeList GET
	 * 공지사항 리스트 조회 폼
	 * 검색,페이징 동시
	 * */
	@RequestMapping(value="/community/noticeList", method = RequestMethod.GET)
	public void noticeGet() {
		
	}
	
	/*
	 * NoticeView GET
	 * 공지사항 상세페이지 조회 폼
	 * 댓글 목록 출력
	 * */
	@RequestMapping(value="/community/noticeView", method = RequestMethod.GET)
	public void noticeViewGet() {
		
	}
	
	/*
	 * NoticeWrite GET
	 * 공지사항 글쓰기 폼
	 * */
	@RequestMapping(value="/community/noticeWrite", method = RequestMethod.GET)
	public void noticeWriteGet() {
		
	}
	
	/*
	 * NoticeWrite POST
	 * 공지사항 글쓰기 처리 폼
	 * */
	@RequestMapping(value="/community/noticeWrite", method = RequestMethod.POST)
	public void noticeWritePost() {
		
	}
	
	/*
	 * NoticeUpdate GET
	 * 공지사항 수정 폼
	 * */
	@RequestMapping(value="/community/noticeUpdate", method = RequestMethod.GET)
	public void noticeUpdateGet() {
		
	}
	
	/*
	 * NoticeUpdate POST
	 * 공지사항 수정 처리 폼
	 * */
	@RequestMapping(value="/community/noticeUpdate", method = RequestMethod.POST)
	public void noticeUpdatePost() {
		
	}
	
	/*
	 * NoticeDelete GET
	 * 공지사항 삭제 처리 폼
	 * */
	@RequestMapping(value="/community/noticeDelete", method = RequestMethod.GET)
	public void noticeDeleteGet() {
		
	}
	
	/*
	 * noticeCommentInsert POST
	 * 공지사항 댓글 등록 처리 폼
	 * */
	@RequestMapping(value="/community/noticeCommentInsert", method = RequestMethod.POST)
	public void noticeCommentInsertPost() {
		
	}
	
	/*
	 * noticeCommentDelete POST
	 * 공지사항 댓글 삭제 처리 폼
	 * */
	@RequestMapping(value="/community/noticeCommentDelete", method = RequestMethod.GET)
	public void noticeCommentDeleteGet() {
		
	}
	
}
