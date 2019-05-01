package com.fm.www.controller;

import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.UUID;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
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
	/*
	 * teamIntroList GET
	 * 팀 가입 인사 리스트 조회 폼
	 * */
	@RequestMapping(value="/community/teamIntroList", method = RequestMethod.GET)
	public void teamIntroGet(@RequestParam(defaultValue="1") int curPage, Model model,String word, String search) {
		//팀 가입 인사 리스트 총 개수
		int totalCount = communityService.teamIntrototalCount(search,word);
		if(totalCount==0) {
			model.addAttribute("totalCount", totalCount);
		}
		Paging paging = new Paging(totalCount, curPage);
		paging.setSearch(search);
		paging.setWord(word);
	
        //팀 가입 인사 리스트 페이징 처리 및 출력
		List<Board_tb> list= communityService.teamIntrogetList(paging);
		
		for(int i = 0; i< list.size(); i++) {
			int board_reply_cnt= communityService.teamIntrototalreplyCnt(list.get(i).getBoard_no());
			list.get(i).setBoard_reply_cnt(board_reply_cnt);
		}	
		// 게시글 번호 생성
	    int tableNum = totalCount -((curPage-1)*10);
	    model.addAttribute("search", search);
	    model.addAttribute("word", word);
	    model.addAttribute("tableNum", tableNum);
		model.addAttribute("list", list);
		model.addAttribute("paging", paging);

	}

	private int teamIntrototalreplyCnt(int i) {
		// TODO Auto-generated method stub
		return 0;
	}

	/*
	 * teamIntroView GET
	 * 팀 가입 인사 상세페이지 조회 폼
	 * 댓글 목록 출력 (아직)
	 * */
	@RequestMapping(value="/community/teamIntroView", method = RequestMethod.GET)
	public void teamIntroViewGet(int board_no, Model model, Board_tb board_tb,Photo photo,HttpSession session) {
		//팀 가입 인사 게시글 조회수 증가
		communityService.teamIntrouphit(board_no);
		
		//팀 가입 인사 view 정보 
		board_tb= communityService.teamIntroView(board_no);
		//팀 가입 인사 photo view 정보
		photo= communityService.teamIntrophotoView(board_no);
		
		model.addAttribute("board_tb", board_tb);
		model.addAttribute("photo", photo);
		
		//댓글 리스트 정보
		List<Board_Reply> replaylist= communityService.teamIntrogetreplylist(board_no);
		model.addAttribute("replaylist", replaylist);
		
	}
	
	/*
	 * teamIntroWrite GET
	 * 팀 가입 인사 글쓰기 폼
	 * */
	@RequestMapping(value="/community/teamIntroWrite", method = RequestMethod.GET)
	public void teamIntroWriteGet() {	}
	/*
	 * teamIntroWrite POST
	 * 팀 가입 인사 글쓰기 처리 폼
	 * */
	@RequestMapping(value="/community/teamIntroWrite", method = RequestMethod.POST)
	public String teamIntroWritePost(Photo photo,Board_tb board_tb ,HttpSession session,HttpServletRequest request, MultipartFile file) {
		System.out.println(board_tb);
		System.out.println(file.getOriginalFilename());
		try {
			request.setCharacterEncoding("utf-8");
		} catch (UnsupportedEncodingException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		if(!"".equals(file.getOriginalFilename())&& file.getOriginalFilename()!=null) {
			//고유식별자
			String uId = UUID.randomUUID().toString().split("-")[0];
	
			//저장될 파일 이름
			String stored_name = null;
			stored_name =file.getOriginalFilename()+"_"+uId;
			
							
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
				
				e.printStackTrace();
			}
			photo.setPhoto_origin(file.getOriginalFilename());
			photo.setPhoto_stored(stored_name);
			//다음글 번호 가져오기
			int board_no =communityService.teamIntrogetboard_no();
			board_tb.setBoard_no(board_no);
			photo.setBoard_no(board_no);
			//세션번호넣어주기
			int user_no = (int) session.getAttribute("user_no");
			board_tb.setUser_no(user_no);
		
		
			//글쓰기
			communityService.teamIntrowrite(board_tb);
			//파일첨부
			communityService.teamIntrophotowrite(photo);
		}else {
			//다음글 번호 가져오기
			int board_no =communityService.teamIntrogetboard_no();
			board_tb.setBoard_no(board_no);
			//세션번호넣어주기
			int user_no = (int) session.getAttribute("user_no");
			board_tb.setUser_no(user_no);
		
			//글쓰기
			communityService.teamIntrowrite(board_tb);
		}
		
		return "redirect:/community/teamIntroList";
	}
	
	/*
	 * teamIntroUpdate GET
	 * 팀 가입 인사 수정 폼
	 * */
	@RequestMapping(value="/community/teamIntroUpdate", method = RequestMethod.GET)
	public void teamIntroUpdateGet(int board_no, Model model) {
		// 수정전 글 가져오기
		Board_tb board_tb = communityService.teamIntrogetupdateview(board_no);
		// 수정전 파일첨부 가져오기
		Photo photo = communityService.teamIntrogetUpdatePhoto(board_no);
		model.addAttribute("board_tb", board_tb);
		model.addAttribute("photo", photo);
		model.addAttribute("board_no", board_no);
	}

	/*
	 * teamIntroUpdate POST
	 * 팀 가입 인사 수정 처리 폼
	 * */
	@RequestMapping(value="/community/teamIntroUpdate", method = RequestMethod.POST)
	public String teamIntroUpdatePost(int board_no,Photo photo,Board_tb board_tb ,HttpSession session,HttpServletRequest request, MultipartFile file) {
		try {
			request.setCharacterEncoding("utf-8");
		} catch (UnsupportedEncodingException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		//파일첨부 존재 여부
		int photo_no = communityService.teamIntrocntphoto(board_no);
	
		if(photo_no!=0) {
			//고유식별자
			String uId = UUID.randomUUID().toString().split("-")[0];
	
			//저장될 파일 이름
			String stored_name = null;
			stored_name =file.getOriginalFilename()+"_"+uId;
			
							
			//파일 저장 경로		
			String path = context.getRealPath("uploadImg");
			
			//저장될 파일
			File dest = new File(path, stored_name);
			System.out.println("파일경로"+dest);
			//파일업로드
			try {
				file.transferTo(dest);
			} catch (IllegalStateException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				
				e.printStackTrace();
			}
			photo.setPhoto_origin(file.getOriginalFilename());
			photo.setPhoto_stored(stored_name);
		
			board_tb.setBoard_no(board_no);
			photo.setBoard_no(board_no);
			//세션번호넣어주기
			int user_no = (int) session.getAttribute("user_no");
			board_tb.setUser_no(user_no);
		
		
			//수정 글쓰기
			communityService.teamIntroupdate(board_tb);
		
			//수정 파일첨부
			communityService.teamIntrophotoupdate(photo);
			
		}else if(photo_no==0){
			//고유식별자
			String uId = UUID.randomUUID().toString().split("-")[0];
	
			//저장될 파일 이름
			String stored_name = null;
			stored_name =file.getOriginalFilename()+"_"+uId;
			
							
			//파일 저장 경로		
			String path = context.getRealPath("uploadImg");
			
			//저장될 파일
			File dest = new File(path, stored_name);
			System.out.println("파일경로"+dest);
			//파일업로드
			try {
				file.transferTo(dest);
			} catch (IllegalStateException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				
				e.printStackTrace();
			}
			photo.setPhoto_origin(file.getOriginalFilename());
			photo.setPhoto_stored(stored_name);
		
			board_tb.setBoard_no(board_no);
			photo.setBoard_no(board_no);
			board_tb.setBoard_no(board_no);
			//세션번호넣어주기
			int user_no = (int) session.getAttribute("user_no");
			board_tb.setUser_no(user_no);
		
			//수정 글쓰기
			communityService.teamIntroupdate(board_tb);
			//파일첨부
			communityService.teamIntrophotowrite(photo);
		}
		
		return "redirect:/community/teamIntroList";
	}
	
	/*
	 * teamIntroDelete GET
	 * 팀 가입 인사 삭제 처리 폼
	 * */
	@RequestMapping(value="/community/teamIntroDelete", method = RequestMethod.GET)
	public String teamIntroDeleteGet(int board_no) {
		//팀 가입 인사 삭제
		communityService.teamIntrodelete(board_no);
		
		return "redirect:/community/teamIntroList";
	}
	
	/*
	 * teamIntroCommentInsert POST
	 * 팀 가입 인사 댓글 등록 처리 폼
	 * */
	@RequestMapping(value="/community/teamIntroCommentInsert", method = RequestMethod.POST)
	public String teamIntroCommentInsertPost(Board_Reply board_reply,int board_no, HttpSession session) {
		
		int user_no = (int) session.getAttribute("user_no");
		board_reply.setBoard_no(board_no);
		board_reply.setUser_no(user_no);
	
		//팀 가입 인사 댓글 등록
		communityService.teamIntroCommentInsert(board_reply);
		
		return "redirect:/community/teamIntroView?board_no="+board_no;
	}
	
	/*
	 * teamIntroCommentDelete POST
	 * 팀 가입 인사 댓글 삭제 처리 폼
	 * */
	@RequestMapping(value="/community/teamIntroCommentDelete", method = RequestMethod.GET)
	public String teamIntroCommentDeleteGet(int reply_no , int board_no) {
		//팀 가입 인사 댓글 삭제
		communityService.teamIntroCommentDelete(reply_no);
		
		return "redirect:/community/teamIntroView?board_no="+board_no;
		
	}
}
