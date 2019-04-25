package com.fm.www.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

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
	
	
	
}













