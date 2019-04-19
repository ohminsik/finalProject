package com.fm.www.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class CommunityController {
	private static final Logger logger = LoggerFactory.getLogger(CommunityController.class);
	
	/*
	 * Notice View GET
	 * 공지사항 리스트 조회 폼
	 * 검색,페이징 동시
	 * */
	@RequestMapping(value="/community/notice", method = RequestMethod.GET)
	public void noticeGet() {
		
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
}
