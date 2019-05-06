package com.fm.www.controller;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.fm.www.dto.Admin;
import com.fm.www.dto.Board_tb;
import com.fm.www.dto.Photo;
import com.fm.www.service.face.AdminService;
import com.fm.www.util.Paging;

@Controller
public class AdminController {
	private static final Logger logger = LoggerFactory.getLogger(AdminController.class);
	
	@Autowired AdminService adminService;
	@Autowired ServletContext context;
	/*
	 * Admin 컨트롤러
	 * Admin 창 띄우기
	 * GET
	 * */
	@RequestMapping(value = "/admin/index", method = RequestMethod.GET)
	public void mainGet() {		
		
		
	}
	
	/*
	 * Admin login 컨트롤러
	 * Admin login 창 띄우기
	 * GET
	 * */
	@RequestMapping(value = "/admin/login", method = RequestMethod.GET)
	public void loginGet() {		
	
	}
	/*
	 * Admin login 하기
	 * Admin 창 띄우기
	 * POST
	 * */
	@RequestMapping(value = "/admin/login", method = RequestMethod.POST)
	public String loginPost(Model model, Admin admin, HttpSession session, HttpServletResponse resp) {		
		logger.info(""+admin);
		//로그인
		boolean admin_yn = adminService.loginYN(admin);
		
		if(admin_yn) {
			System.out.println("로그인성공");
			// 로그인 닉네임 가져오기
			int admin_no = adminService.getAdminNo(admin);
			session.setAttribute("AdminloginYN", true);
			session.setAttribute("admin_no", admin_no);
			System.out.println("asdasdasdAAAAAAAAAAa"+admin_no);
			return "redirect:/admin/index";
			
		}else{
			System.out.println("로그인실패");
			return "redirect:/admin/login";
		}
	}
	/*
	 * Admin logout 컨트롤러
	 * Admin login 창 띄우기
	 * GET
	 * */
	@RequestMapping(value = "/admin/logout", method = RequestMethod.GET)
	public String logoutGet(HttpSession session) {		
		session.invalidate();
		
		//로그아웃 후 main으로
		return"redirect:/admin/login";
	}
		
	/*
	 * Admin Board 컨트롤러
	 * Admin board 띄우기
	 * GET
	 * */
	@RequestMapping(value = "/admin/board", method = RequestMethod.GET)
	public String adminBoardGet(String board_div, Model model, String search, String word, Board_tb board, @RequestParam(defaultValue = "1")int curPage) {		
		
		// 게시글 전체 수 
		int totalCount = adminService.boardTotalCount(search, word, board_div);
		
		if(totalCount == 0) {
			model.addAttribute("totalCount", totalCount);
		}
		
		// 게시글 페이징 처리
		Paging paging = new Paging(totalCount, curPage);
		System.out.println("paging" + paging);
		// 게시판 페이징 리스트 처리
		List <Board_tb> list = adminService.boardGetList(paging, search, word, board_div);
		
		// 댓글 갯수 구하기
		for(int i=0; i<list.size(); i++) {
			list.get(i).setBoard_reply_cnt(adminService.boardreplyCount(list.get(i).getBoard_no()));
		}
		
		model.addAttribute("paging", paging);
		model.addAttribute("search", search);
		model.addAttribute("word", word);
		model.addAttribute("list", list);
		model.addAttribute("board_div", board_div);
		
		return "/admin/board/notice";
	}
	
	/*
	 * Admin BoardWrite 컨트롤러
	 * Admin boardWrite 띄우기
	 * GET
	 * */
	@RequestMapping(value = "/admin/board/write", method = RequestMethod.GET)
	public void noticeWriteGet(int board_div, Model model) {		
		model.addAttribute("board_div", board_div);
	}
	/*
	 * Admin BoardWrite 컨트롤러
	 * Admin boardWrite 띄우기
	 * POST
	 * */
	@RequestMapping(value = "/admin/board/write", method = RequestMethod.POST)
	public String noticeWritePost(Model model, Admin admin, MultipartFile file, HttpSession session, Board_tb board_tb, Photo photo, int board_div) {		
		model.addAttribute("board_div", board_div);
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

			// 관리자 게시판 글 번호 생성하기
			int board_no = adminService.adminGetBoard_no();

			// 관리자 게시판 관라지 번호 받아오기
			board_tb.setAdmin_no((int) session.getAttribute("admin_no"));
			board_tb.setBoard_no(board_no);
			photo.setBoard_no(board_no);
			adminService.adminInsertWrite1(board_tb, board_div);
			adminService.adminInsertPhoto(photo, board_div);
		} else {
			// 관리자 게시판 관리자 번호 받아오기
			board_tb.setAdmin_no((int) session.getAttribute("admin_no"));
			// 관리자 게시판 이미지 파일 없이 글 작성
			adminService.adminInsertWrite2(board_tb);
		}
		System.out.println(board_tb);

		return "redirect:/admin/board?board_div=" + board_div;
	}
	
	/*
	 * Admin BoardDelete 컨트롤러
	 * 관리자 게시글 삭제 처리
	 * GET
	 * */
	@RequestMapping(value = "/admin/boardDelete", method = RequestMethod.GET)
	public String adminBoardDeleteGet(int board_no, int board_div) {		
		
		// 게시글 삭제
		adminService.boardDelete(board_no);
		
		return "redirect:/admin/board?board_div=" + board_div;
	}
	
	/*
	 * Admin BoardCheckDelete 컨트롤러
	 * 관리자 게시글 선택 삭제 처리
	 * GET
	 * */
	@RequestMapping(value = "/admin/boardCheckDelete", method = RequestMethod.GET)
	public String adminBoarAlldDeleteGet(int board_no, int board_div) {		
		
		
		// 게시글 선택 삭제
		adminService.boardCheckDelete(board_no);
		
		return "redirect:/admin/board?board_div=" + board_div;
	}
}













