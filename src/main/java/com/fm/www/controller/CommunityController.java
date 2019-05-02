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
import com.fm.www.dto.Movie;
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
		
		model.addAttribute("word", word);
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
	
	// ------------------ 자유 free ----------------------
	
	/*
	 * FreeList GET 
	 * 자유 리스트 조회 폼 검색,페이징 동시
	 */
	@RequestMapping(value = "/community/freeList", method = RequestMethod.GET)
	public void freeGet(Board_tb board, @RequestParam(defaultValue = "1") int curPage, Model model, String search, String word) {
		// 자유 게시글 전체 수
		int totalCount = communityService.freeTotalCount(search, word);

		if (totalCount == 0) {
			model.addAttribute("totalCount", totalCount);
		}
		// 자유게시글 페이징 처리
		Paging paging = new Paging(totalCount, curPage);

		// 자유게시글 페이징 리스트 처리
		List<Board_tb> list = communityService.freeGetList(paging, search, word);

		// 자유 댓글 갯수 구하기
		for (int i = 0; i < list.size(); i++) {
			list.get(i).setBoard_reply_cnt(communityService.freeReplyCount(list.get(i).getBoard_no()));
		}

		// 자유 게시글 번호 생성
		int tableNum = totalCount - (curPage - 1) * 10;

		model.addAttribute("word", word);
		model.addAttribute("search", search);
		model.addAttribute("model", model);
		model.addAttribute("tableNum", tableNum);
		model.addAttribute("paging", paging);
		model.addAttribute("list", list);
	}
	/*
	 * FreeView GET
	 * 자유 상세페이지 조회 폼
	 * 댓글 목록 출력
	 * */
	@RequestMapping(value="/community/freeView", method = RequestMethod.GET)
	public void freeViewGet(User user, Board_tb board, int board_no, Model model, Photo photo, HttpSession session, Board_Reply board_reply) {

		// 자유 조회수 증가
		communityService.freeUpHit(board_no);
		// 자유 지정 게시글 정보 가져오기
		board = communityService.freeView(board_no);
		// 자유 사진 가져오기
		photo = communityService.freePhotoView(board_no);
		
		
		// 자유 댓글 리스트 가져오기
		List <Board_Reply> list = communityService.freeReplyList(board_reply);

		model.addAttribute("photo", photo);
		model.addAttribute("board", board);
		model.addAttribute("list", list);
	}
	/*
	 * FreeWrite GET 자유 글쓰기 폼
	 */
	@RequestMapping(value = "/community/freeWrite", method = RequestMethod.GET)
	public void freeWriteGet() {

	}

	/*
	 * FreeWrite POST 자유 글쓰기 처리 폼
	 */
	@RequestMapping(value = "/community/freeWrite", method = RequestMethod.POST)
	public String freeWritePost(Board_tb board_tb, MultipartFile file, HttpSession session, Photo photo) {

		if (!"".equals(file.getOriginalFilename()) && file.getOriginalFilename() != null) {
			// 고유식별자
			String uId = UUID.randomUUID().toString().split("-")[0];

			// 저장될 파일 이름
			String stored_name = null;
			stored_name = file.getOriginalFilename() + "_" + uId;
			// stored_name =file.getOriginalFilename();

			// 파일 저장 경로
			String path = context.getRealPath("uploadImg");

			// 저장될 파일
			File dest = new File(path, stored_name);

			// 파일업로드
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

			// 자유 글 번호 생성하기
			int board_no = communityService.freeGetBoard_no();

			// 자유 유저 번호 받아오기
			board_tb.setUser_no((int) session.getAttribute("user_no"));
			board_tb.setBoard_no(board_no);
			photo.setBoard_no(board_no);
			communityService.freeInsertWrite1(board_tb);
			communityService.freeInsertPhoto(photo);
		} else {
			// 자유 유저 번호 받아오기
			board_tb.setUser_no((int) session.getAttribute("user_no"));
			// 자유 이미지 파일 없이 글 작성
			communityService.freeInsertWrite2(board_tb);
		}
		System.out.println(board_tb);

		return "redirect:/community/freeList";
	}
	
	/*
	 * FreeUpdate GET
	 * 자유 수정 폼
	 * */
	@RequestMapping(value="/community/freeUpdate", method = RequestMethod.GET)
	public void freeUpdateGet(int board_no, Model model) {
		// 자유 수정전 글 가져오기
		Board_tb board = communityService.freeUpdateView(board_no);
		// 자유 수정전 파일첨부 가져오기
		Photo photo = communityService.freeUpdatePhoto(board_no);
		model.addAttribute("board", board);
		model.addAttribute("photo", photo);
		model.addAttribute("board_no", board_no);
	}

	/*
	 * FreeUpdate POST
	 * 자유 수정 처리 폼
	 * */
	@RequestMapping(value="/community/freeUpdate", method = RequestMethod.POST)
	public String freeUpdatePost(int board_no,Photo photo,Board_tb board_tb ,HttpSession session,HttpServletRequest request, MultipartFile file) {
		try {
			request.setCharacterEncoding("utf-8");
		} catch (UnsupportedEncodingException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		// 자유 파일첨부 존재 여부
		int photo_no = communityService.freeCntPhoto(board_no);
	
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

			// 자유 수정 글쓰기
			communityService.freeUpdate(board_tb);
		
			// 자유 이미지 존재 할 때 수정 파일첨부
			communityService.freePhotoUpdate(photo);
			
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
		
			// 자유 수정 글쓰기
			communityService.freeUpdate(board_tb);
			// 자유 이미지 없을 때 파일첨부
			communityService.freePhotoWrite(photo);
		}
		
		return "redirect:/community/freeList";
	}	
	
	/*
	 * FreeDelete GET
	 * 자유 삭제 처리 폼
	 * */
	@RequestMapping(value="/community/freeDelete", method = RequestMethod.GET)
	public String freeDeleteGet(int board_no) {
		// 자유 삭제
		communityService.freeDelete(board_no);
		
		return "redirect:/community/freeList";
	}	
	
	/*
	 * freeCommentInsert POST
	 * 자유 댓글 등록 처리 폼
	 * */
	@RequestMapping(value="/community/freeCommentInsert", method = RequestMethod.POST)
	public String freeCommentInsertPost(Board_Reply board_reply,int board_no, HttpSession session) {
		
		int user_no = (int) session.getAttribute("user_no");
		board_reply.setBoard_no(board_no);
		board_reply.setUser_no(user_no);
	
		// 자유 댓글 등록
		communityService.freeCommentInsert(board_reply);
		
		return "redirect:/community/freeView?board_no="+board_no;
	}	
	
	/*
	 * freeCommentDelete POST
	 * 자유 댓글 삭제 처리 폼
	 * */
	@RequestMapping(value="/community/freeCommentDelete", method = RequestMethod.GET)
	public String freeCommentDeleteGet(int reply_no , int board_no) {
		//자유 댓글 삭제
		communityService.freeCommentDelete(reply_no);
		
		return "redirect:/community/freeView?board_no="+board_no;
	}
	
//----------------------- 경기 후기 review -------------------------------------
	/*
	 * ReviewList GET 
	 * 경기 후기 리스트 조회 폼 검색,페이징 동시
	 */
	@RequestMapping(value = "/community/reviewList", method = RequestMethod.GET)
	public void reviewGet(Board_tb board, @RequestParam(defaultValue = "1") int curPage, Model model, String search, String word) {
		// 경기 후기 게시글 전체 수
		int totalCount = communityService.reviewTotalCount(search, word);

		if (totalCount == 0) {
			model.addAttribute("totalCount", totalCount);
		}
		// 경기 후기 게시글  페이징 처리
		Paging paging = new Paging(totalCount, curPage);

		// 경기 후기 게시글  페이징 리스트 처리
		List<Board_tb> list = communityService.reviewGetList(paging, search, word);

		// 경기 후기 댓글 갯수 구하기
		for (int i = 0; i < list.size(); i++) {
			list.get(i).setBoard_reply_cnt(communityService.reviewReplyCount(list.get(i).getBoard_no()));
		}

		// 자유 게시글 번호 생성
		int tableNum = totalCount - (curPage - 1) * 10;

		model.addAttribute("word", word);
		model.addAttribute("search", search);
		model.addAttribute("model", model);
		model.addAttribute("tableNum", tableNum);
		model.addAttribute("paging", paging);
		model.addAttribute("list", list);
	}
	/*
	 * ReviewView GET
	 * 경기 후기 상세페이지 조회 폼
	 * 댓글 목록 출력
	 * */
	@RequestMapping(value="/community/reviewView", method = RequestMethod.GET)
	public void reviewViewGet(User user, Board_tb board, int board_no, Model model, Photo photo, HttpSession session, Board_Reply board_reply) {

		// 자유 조회수 증가
		communityService.freeUpHit(board_no);
		// 자유 지정 게시글 정보 가져오기
		board = communityService.freeView(board_no);
		// 자유 사진 가져오기
		photo = communityService.freePhotoView(board_no);
		
		
		// 자유 댓글 리스트 가져오기
		List <Board_Reply> list = communityService.freeReplyList(board_reply);

		model.addAttribute("photo", photo);
		model.addAttribute("board", board);
		model.addAttribute("list", list);
	}
	
	/*
	 * ReviewWrite GET 자유 글쓰기 폼
	 */
	@RequestMapping(value = "/community/reviewWrite", method = RequestMethod.GET)
	public void reviewWriteGet() {

	}

	/*
	 * ReviewWrite POST 자유 글쓰기 처리 폼
	 */
	@RequestMapping(value = "/community/reviewWrite", method = RequestMethod.POST)
	public String reviewWritePost(Board_tb board_tb, MultipartFile file, HttpSession session, Photo photo) {

		if (!"".equals(file.getOriginalFilename()) && file.getOriginalFilename() != null) {
			// 고유식별자
			String uId = UUID.randomUUID().toString().split("-")[0];

			// 저장될 파일 이름
			String stored_name = null;
			stored_name = file.getOriginalFilename() + "_" + uId;
			// stored_name =file.getOriginalFilename();

			// 파일 저장 경로
			String path = context.getRealPath("uploadImg");

			// 저장될 파일
			File dest = new File(path, stored_name);

			// 파일업로드
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

			// 경기 후기 글 번호 생성하기
			int board_no = communityService.reviewGetBoard_no();

			// 경기 후기 유저 번호 받아오기
			board_tb.setUser_no((int) session.getAttribute("user_no"));
			board_tb.setBoard_no(board_no);
			photo.setBoard_no(board_no);
			communityService.reviewInsertWrite1(board_tb);
			communityService.reviewInsertPhoto(photo);
		} else {
			// 경기 후기 유저 번호 받아오기
			board_tb.setUser_no((int) session.getAttribute("user_no"));
			// 경기 후기 이미지 파일 없이 글 작성
			communityService.reviewInsertWrite2(board_tb);
		}
		System.out.println(board_tb);

		return "redirect:/community/reviewList";
	}
	
	/*
	 * ReviewUpdate GET
	 * 경기 후기 수정 폼
	 * */
	@RequestMapping(value="/community/reviewUpdate", method = RequestMethod.GET)
	public void reviewUpdateGet(int board_no, Model model) {
		// 경기 후기 수정전 글 가져오기
		Board_tb board = communityService.reviewUpdateView(board_no);
		// 경기 후기 수정전 파일첨부 가져오기
		Photo photo = communityService.reviewUpdatePhoto(board_no);
		model.addAttribute("board", board);
		model.addAttribute("photo", photo);
		model.addAttribute("board_no", board_no);
	}
	
	/*
	 * ReviewUpdate POST
	 * 경기 후기 처리 폼
	 * */
	@RequestMapping(value="/community/reviewUpdate", method = RequestMethod.POST)
	public String reviewUpdatePost(int board_no,Photo photo,Board_tb board_tb ,HttpSession session,HttpServletRequest request, MultipartFile file) {
		try {
			request.setCharacterEncoding("utf-8");
		} catch (UnsupportedEncodingException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		// 경기 후기 파일첨부 존재 여부
		int photo_no = communityService.reviewCntPhoto(board_no);
	
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

			// 경기 후기 수정 글쓰기
			communityService.reviewUpdate(board_tb);
		
			// 경기 후기 이미지 존재 할 때 수정 파일첨부
			communityService.reviewPhotoUpdate(photo);
			
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
		
			// 경기 후기 수정 글쓰기
			communityService.reviewUpdate(board_tb);
			// 경기 후기 이미지 없을 때 파일첨부
			communityService.reviewPhotoWrite(photo);
		}
		
		return "redirect:/community/reviewList";
	}	
	
	/*
	 * ReviewDelete GET
	 * 경기 후기 삭제 처리 폼
	 * */
	@RequestMapping(value="/community/reviewDelete", method = RequestMethod.GET)
	public String reviewDeleteGet(int board_no) {
		// 경기 후기 삭제
		communityService.freeDelete(board_no);
		
		return "redirect:/community/reviewList";
	}	
	
	/*
	 * ReviewCommentInsert POST
	 * 경기 후기 댓글 등록 처리 폼
	 * */
	@RequestMapping(value="/community/reviewCommentInsert", method = RequestMethod.POST)
	public String reviewCommentInsertPost(Board_Reply board_reply,int board_no, HttpSession session) {
		
		int user_no = (int) session.getAttribute("user_no");
		board_reply.setBoard_no(board_no);
		board_reply.setUser_no(user_no);
	
		// 자유 댓글 등록
		communityService.reviewCommentInsert(board_reply);
		
		return "redirect:/community/reviewView?board_no="+board_no;
	}	
	
	/*
	 * ReviewCommentDelete POST
	 * 자유 댓글 삭제 처리 폼
	 * */
	@RequestMapping(value="/community/reviewCommentDelete", method = RequestMethod.GET)
	public String reviewCommentDeleteGet(int reply_no , int board_no) {
		//자유 댓글 삭제
		communityService.freeCommentDelete(reply_no);
		
		return "redirect:/community/reviewView?board_no="+board_no;
	}
	
	// ------------------ 중고장터  market ----------------------
	
	/*
	 * UsedList GET 
	 * 중고장터 리스트 조회 폼 검색,페이징 동시
	 */
	@RequestMapping(value = "/community/usedList", method = RequestMethod.GET)
	public void usedGet(Board_tb board, @RequestParam(defaultValue = "1") int curPage, Model model, String search, String word) {
		// 중고장터 게시글 전체 수
		int totalCount = communityService.usedTotalCount(search, word);

		if (totalCount == 0) {
			model.addAttribute("totalCount", totalCount);
		}
		// 중고장터 게시글 페이징 처리
		Paging paging = new Paging(totalCount, curPage);

		// 중고장터 게시글 페이징 리스트 처리
		List<Board_tb> list = communityService.usedGetList(paging, search, word);

		// 중고장터 댓글 갯수 구하기
		for (int i = 0; i < list.size(); i++) {
			list.get(i).setBoard_reply_cnt(communityService.freeReplyCount(list.get(i).getBoard_no()));
		}

		// 중고장터 게시글 번호 생성
		int tableNum = totalCount - (curPage - 1) * 10;

		model.addAttribute("word", word);
		model.addAttribute("search", search);
		model.addAttribute("model", model);
		model.addAttribute("tableNum", tableNum);
		model.addAttribute("paging", paging);
		model.addAttribute("list", list);
	}	
	/*
	 * UsedView GET
	 * 중고장터 상세페이지 조회 폼
	 * 댓글 목록 출력
	 * */
	@RequestMapping(value="/community/usedView", method = RequestMethod.GET)
	public void usedViewGet(User user, Board_tb board, int board_no, Model model, Photo photo, HttpSession session, Board_Reply board_reply) {

		// 자유 조회수 증가
		communityService.freeUpHit(board_no);
		// 자유 지정 게시글 정보 가져오기
		board = communityService.freeView(board_no);
		// 자유 사진 가져오기
		photo = communityService.freePhotoView(board_no);
		
		
		// 자유 댓글 리스트 가져오기
		List <Board_Reply> list = communityService.freeReplyList(board_reply);

		model.addAttribute("photo", photo);
		model.addAttribute("board", board);
		model.addAttribute("list", list);
	}
	
	/*
	 * UsedWrite GET 중고장터 글쓰기 폼
	 */
	@RequestMapping(value = "/community/usedWrite", method = RequestMethod.GET)
	public void usedWriteGet() {

	}

	/*
	 * UsedWrite POST 중고장터 글쓰기 처리 폼
	 */
	@RequestMapping(value = "/community/usedWrite", method = RequestMethod.POST)
	public String usedWritePost(Board_tb board_tb, MultipartFile file, HttpSession session, Photo photo) {

		if (!"".equals(file.getOriginalFilename()) && file.getOriginalFilename() != null) {
			// 고유식별자
			String uId = UUID.randomUUID().toString().split("-")[0];

			// 저장될 파일 이름
			String stored_name = null;
			stored_name = file.getOriginalFilename() + "_" + uId;
			// stored_name =file.getOriginalFilename();

			// 파일 저장 경로
			String path = context.getRealPath("uploadImg");

			// 저장될 파일
			File dest = new File(path, stored_name);

			// 파일업로드
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

			// 중고장터 글 번호 생성하기
			int board_no = communityService.freeGetBoard_no();

			// 중고장터 유저 번호 받아오기
			board_tb.setUser_no((int) session.getAttribute("user_no"));
			board_tb.setBoard_no(board_no);
			photo.setBoard_no(board_no);
			communityService.usedInsertWrite1(board_tb);
			communityService.usedInsertPhoto(photo);
		} else {
			// 중고장터 유저 번호 받아오기
			board_tb.setUser_no((int) session.getAttribute("user_no"));
			// 중고장터 이미지 파일 없이 글 작성
			communityService.usedInsertWrite2(board_tb);
		}
		System.out.println(board_tb);

		return "redirect:/community/usedList";
	}
	
	/*
	 * UsedUpdate GET
	 * 중고장터 수정 폼
	 * */
	@RequestMapping(value="/community/usedUpdate", method = RequestMethod.GET)
	public void usedUpdateGet(int board_no, Model model) {
		// 중고장터 수정전 글 가져오기
		Board_tb board = communityService.freeUpdateView(board_no);
		// 중고장터 수정전 파일첨부 가져오기
		Photo photo = communityService.freeUpdatePhoto(board_no);
		model.addAttribute("board", board);
		model.addAttribute("photo", photo);
		model.addAttribute("board_no", board_no);
	}

	/*
	 * UsedUpdate POST
	 * 중고장터 수정 처리 폼
	 * */
	@RequestMapping(value="/community/usedUpdate", method = RequestMethod.POST)
	public String usedUpdatePost(int board_no,Photo photo,Board_tb board_tb ,HttpSession session,HttpServletRequest request, MultipartFile file) {
		try {
			request.setCharacterEncoding("utf-8");
		} catch (UnsupportedEncodingException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		// 중고장터 파일첨부 존재 여부
		int photo_no = communityService.freeCntPhoto(board_no);
	
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

			// 중고장터 수정 글쓰기
			communityService.freeUpdate(board_tb);
		
			// 중고장터 이미지 존재 할 때 수정 파일첨부
			communityService.freePhotoUpdate(photo);
			
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
		
			// 중고장터 수정 글쓰기
			communityService.freeUpdate(board_tb);
			// 중고장터 이미지 없을 때 파일첨부
			communityService.usedPhotoWrite(photo);
		}
		
		return "redirect:/community/usedList";
	}	
	
	/*
	 * UsedDelete GET
	 * 중고장터 삭제 처리 폼
	 * */
	@RequestMapping(value="/community/usedDelete", method = RequestMethod.GET)
	public String usedDeleteGet(int board_no) {
		// 자유 삭제
		communityService.freeDelete(board_no);
		
		return "redirect:/community/usedList";
	}	
	
	/*
	 * UsedCommentInsert POST
	 * 중고장터 댓글 등록 처리 폼
	 * */
	@RequestMapping(value="/community/usedCommentInsert", method = RequestMethod.POST)
	public String usedCommentInsertPost(Board_Reply board_reply,int board_no, HttpSession session) {
		
		int user_no = (int) session.getAttribute("user_no");
		board_reply.setBoard_no(board_no);
		board_reply.setUser_no(user_no);
	
		// 중고장터 댓글 등록
		communityService.usedCommentInsert(board_reply);
		
		return "redirect:/community/usedView?board_no="+board_no;
	}	
	
	/*
	 * UsedCommentDelete POST
	 * 중고장터 댓글 삭제 처리 폼
	 * */
	@RequestMapping(value="/community/usedCommentDelete", method = RequestMethod.GET)
	public String usedCommentDeleteGet(int reply_no , int board_no) {
		//중고장터 댓글 삭제
		communityService.freeCommentDelete(reply_no);
		
		return "redirect:/community/usedView?board_no="+board_no;
	}
	/*
	 * soccerVideoList GET
	 * 축구동영상 리스트 조회 폼
	 * 검색,페이징 동시
	 * */
	@RequestMapping(value="/community/soccerVideoList", method= RequestMethod.GET)
	public void soccerVideoList(@RequestParam(defaultValue="1") int curPage, Model model,String word, String search) {
		//축구동영상 리스트 총 개수
		int totalCount = communityService.soccerVideototalCount(search,word);
		if(totalCount==0) {
			model.addAttribute("totalCount", totalCount);
		}
		Paging paging = new Paging(totalCount, curPage);
		paging.setSearch(search);
		paging.setWord(word);
	    //축구 동영상 리스트 페이징 처리 및 출력
		List<Board_tb> list= communityService.soccerVideoListgetList(paging);
		
		for(int i = 0; i< list.size(); i++) {
			//축구 동영상 댓글 수
			int board_reply_cnt= communityService.soccerVideototalreplyCnt(list.get(i).getBoard_no());
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
	/*

	 * 축구 동영상 상세페이지 조회 폼
	 * 댓글 목록 출력 (아직)
	 * */
	@RequestMapping(value="/community/soccerVideoView", method = RequestMethod.GET)
	public void soccerVideoViewGet(int board_no, Model model, Board_tb board_tb,HttpSession session,Movie movie) {
		//축구 동영상 게시글 조회수 증가
		communityService.soccerVideouphit(board_no);
		
		//축구 동영상 view 정보 
		board_tb= communityService.soccerVideoView(board_no);
		//축구 동영상 upload 영상
		movie = communityService.soccerVideouplodView(board_no);
		
		model.addAttribute("movie", movie);
		model.addAttribute("board_tb", board_tb);
	
		
		//댓글 리스트 정보
		List<Board_Reply> replaylist= communityService.teamIntrogetreplylist(board_no);
		model.addAttribute("replaylist", replaylist);
		
	}
	/*

	 * 축구 동영상  글쓰기 폼
	 * */
	@RequestMapping(value="/community/soccerVideoWrite", method = RequestMethod.GET)
	public void soccerVideoWriteGet() {	}
	/*

	 * 축구 동영상 글쓰기 처리 폼
	 * */
	@RequestMapping(value="/community/soccerVideoWrite", method = RequestMethod.POST)
	public String soccerVideoWritePost(Board_tb board_tb ,HttpSession session ,HttpServletRequest request,Movie movie) {
		System.out.println(board_tb);
	
		try {
			request.setCharacterEncoding("utf-8");
		} catch (UnsupportedEncodingException e1) {
		
			e1.printStackTrace();
		}
		//다음글 번호 가져오기
		int board_no =communityService.teamIntrogetboard_no();
		int user_no = (int) session.getAttribute("user_no");
		board_tb.setUser_no(user_no);
		board_tb.setBoard_no(board_no);
		movie.setBoard_no(board_no);
	
		String movie_address=movie.getMovie_address();
		//실제 주소
		String movie_address1= movie_address.substring(17, 28);
		System.out.println("[movei]"+movie_address1);
		//다음글 글 작성
		communityService.soccerVideoWrite(board_tb);
		movie.setMovie_address(movie_address1);
		
		//다음글 동영상 업로드
		communityService.soccerVideoupload(movie);
	
		
		return "redirect:/community/soccerVideoList";
	}

	/*

	 * 축구 동영상 댓글 등록 처리 폼
	 * */
	@RequestMapping(value="/community/soccerVideoCommentInsert", method = RequestMethod.POST)
	public String soccerVideoCommentInsertPost(Board_Reply board_reply,int board_no, HttpSession session) {
		
		int user_no = (int) session.getAttribute("user_no");
		board_reply.setBoard_no(board_no);
		board_reply.setUser_no(user_no);
	
		//축구 동영상 댓글 등록
		communityService.soccerVideoCommentInsert(board_reply);
		
		return "redirect:/community/soccerVideoView?board_no="+board_no;
	}
	
	/*

	 * 축구 동영상 댓글 삭제 처리 폼
	 * */
	@RequestMapping(value="/community/soccerVideoCommentDelete", method = RequestMethod.GET)
	public String soccerVideoCommentDeleteGet(int reply_no , int board_no) {
		//축구 동영상 댓글 삭제
		communityService.teamIntroCommentDelete(reply_no);
		
		return "redirect:/community/soccerVideoView?board_no="+board_no;
		
	}
	
	/*

	 * 축구 동영상 삭제 처리 폼
	 * */
	@RequestMapping(value="/community/soccerVideoDelete", method = RequestMethod.GET)
	public String soccerVideoDeleteGet(int board_no) {
		//팀 가입 인사 삭제
		communityService.teamIntrodelete(board_no);
		
		return "redirect:/community/soccerVideoList";
	}

	
	
	
}
