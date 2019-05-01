package com.fm.www.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.fm.www.dto.Admin;
import com.fm.www.service.face.AdminService;

@Controller
public class AdminController {
	private static final Logger logger = LoggerFactory.getLogger(AdminController.class);
	
	@Autowired AdminService adminService;
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
			session.setAttribute("AdminloginYN", true);
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
	 * Admin noticeBoard 컨트롤러
	 * Admin notice 띄우기
	 * GET
	 * */
	@RequestMapping(value = "/admin/board/notice", method = RequestMethod.GET)
	public void noticeGet() {		
		
	}
	
	/*
	 * Admin noticeBoard 컨트롤러
	 * Admin notice 띄우기
	 * GET
	 * */
	@RequestMapping(value = "/admin/board/noticeWrite", method = RequestMethod.GET)
	public void noticeWriteGet() {		
		
	}
	
	
}













