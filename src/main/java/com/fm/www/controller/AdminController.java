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
	public String mainGet() {		
		
		return "redirect:/admin/login";
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
		Admin adminlogin = adminService.login(admin);
		
		logger.info("adminlogin"+adminlogin);
		
//		boolean a = true;
		
		if((admin.getAdmin_id() == adminlogin.getAdmin_id())&&(admin.getAdmin_pw() == adminlogin.getAdmin_pw())) {
			
			model.addAttribute("check", adminlogin);
			
			
			try {
				session.setAttribute("admin_id", adminlogin.getAdmin_id());
				session.setAttribute("admin_pw", adminlogin.getAdmin_pw());
				logger.info(""+admin);	
				session.setAttribute("adminlogin", adminlogin);
			} catch(Exception e) {
				logger.info("로그인실패");
				
				return "redirect:/admin/login";
			}
			
		}else {
          PrintWriter out;
          resp.setContentType("text/html; charset=utf-8");
          
          try {
			out = resp.getWriter();
			out.println("<scipt> alert('로그인 실패')</script>");
		} catch (IOException e) {
			e.printStackTrace();
		}
          return "redirect:/admin/login";
          
		}
		
		return "/admin/index";
		
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
		return"redirect:/admin/index";
	}
	
	
}













