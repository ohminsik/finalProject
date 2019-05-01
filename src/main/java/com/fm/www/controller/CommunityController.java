package com.fm.www.controller;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.server.ServletServerHttpAsyncRequestControl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.fm.www.dto.Board_Reply;
import com.fm.www.dto.Board_tb;
import com.fm.www.dto.Photo;
import com.fm.www.dto.User;
import com.fm.www.service.face.CommunityService;
import com.fm.www.util.Paging;

@Controller
public class CommunityController {
	private static final Logger logger = LoggerFactory.getLogger(CommunityController.class);
	@Autowired CommunityService communityService;
	@Autowired ServletContext context;
	/*
	 * NoticeList GET
	 * 공지사항 리스트 조회 폼
	 * 검색,페이징 동시
	 * */
	@RequestMapping(value="/community/noticeList", method = RequestMethod.GET)
	public void noticeGet(Board_tb board, @RequestParam(defaultValue = "1") int curPage, Model model, String search, String word) {
		
		// 공지사항 게시글 전체 수 
		int totalCount = communityService.noticeTotalCount(search, word);
		
		if(totalCount == 0) {
			model.addAttribute("totalCount", totalCount);
		}
		// 공지사항 페이징 처리
		Paging paging = new Paging(totalCount, curPage);
		
		// 공지사항 페이징 리스트 처리
		List <Board_tb> list = communityService.noticeGetList(paging, search, word);
		
		// 댓글 갯수 구하기
		for(int i=0; i<list.size(); i++) {
			list.get(i).setBoard_reply_cnt(communityService.replyCount(list.get(i).getBoard_no()));
		}
		
		// 게시글 번호 생성
		int tableNum = totalCount - (curPage - 1) * 10;
		
		model.addAttribute("search", search);
		model.addAttribute("model", model);
		model.addAttribute("tableNum", tableNum);
		model.addAttribute("paging", paging);
		model.addAttribute("list", list);
		
	}
	
	/*
	 * NoticeView GET
	 * 공지사항 상세페이지 조회 폼
	 * 댓글 목록 출력
	 * */
	@RequestMapping(value="/community/noticeView", method = RequestMethod.GET)
	public void noticeViewGet(User user, Board_tb board, int board_no, Model model, Photo photo, HttpSession session, Board_Reply board_reply) {

		// 조회수 증가
		communityService.noticeUpHit(board_no);
		// 지정 게시글 정보 가져오기
		board = communityService.noticeView(board_no);
		// 사진 가져오기
		photo = communityService.noticePhotoView(board_no);
		
		
		// 댓글 리스트 가져오기
		List <Board_Reply> list = communityService.ReplyList(board_reply);

		model.addAttribute("photo", photo);
		model.addAttribute("board", board);
		model.addAttribute("list", list);
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
	public String noticeWritePost(Board_tb board_tb, MultipartFile file, HttpSession session, Photo photo) {
		
		if(!"".equals(file.getOriginalFilename())&& file.getOriginalFilename()!=null) {
			//고유식별자
			String uId = UUID.randomUUID().toString().split("-")[0];
	
			//저장될 파일 이름
			String stored_name = null;
			stored_name =file.getOriginalFilename()+"_"+uId;
	//		stored_name =file.getOriginalFilename();
							
			//파일 저장 경로		
			String path = context.getRealPath("uploadImg");
			
			//저장될 파일
			File dest = new File(path, stored_name);
			
			//파일업로드
			try {
				file.transferTo(dest);
			} catch (IllegalStateException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			photo.setPhoto_origin(file.getOriginalFilename());
			photo.setPhoto_stored(stored_name);
			
			// 글 번호 생성하기
			int board_no = communityService.noticeGetBoard_no();
			
			// 유저 번호 받아오기
			board_tb.setUser_no((int)session.getAttribute("user_no"));
			board_tb.setBoard_no(board_no);
			photo.setBoard_no(board_no);
			communityService.noticeInsertWrite1(board_tb);
			communityService.noticeInsertPhoto(photo);
		} else {	
			// 유저 번호 받아오기
			board_tb.setUser_no((int)session.getAttribute("user_no"));
			// 이미지 파일 없이 글 작성
			communityService.noticeInsertWrite2(board_tb);
		}	
		System.out.println(board_tb);
		
		return "redirect:/community/noticeList";
	}
	
	/*
	 * NoticeUpdate GET
	 * 공지사항 수정 폼
	 * */
	@RequestMapping(value="/community/noticeUpdate", method = RequestMethod.GET)
	public void noticeUpdateGet(int board_no, Model model) {

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
	public String noticeDeleteGet(int board_no) {
		
		// 게시글 삭제하기 
		communityService.noticeDelete(board_no);
		
		return "redirect:/community/noticeList";
	}
	
	/*
	 * noticeCommentInsert POST
	 * 공지사항 댓글 등록 처리 폼
	 * */
	@RequestMapping(value="/community/noticeCommentInsert", method = RequestMethod.POST)
	public String noticeCommentInsertPost(Board_Reply board_reply, int board_no, HttpSession session) {
		
		board_reply.setBoard_no(board_no);
		board_reply.setUser_no((int)session.getAttribute("user_no"));
		// 댓글 등록
		communityService.noticeCommentInsert(board_reply);
		
		
		
		return "redirect:/community/noticeView?board_no="+board_no;
	}
	/*
	 * noticeCommentDelete POST
	 * 공지사항 댓글 삭제 처리 폼
	 * */
	@RequestMapping(value="/community/noticeCommentDelete", method = RequestMethod.GET)
	public String noticeCommentDeleteGet(int reply_no, int board_no) {
		communityService.noticeReplyDelete(reply_no);
		
		return "redirect:/community/noticeView?board_no="+board_no;
	}
	
}
