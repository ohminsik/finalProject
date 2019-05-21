package com.fm.www.controller;

import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.UUID;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
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
import com.fm.www.dto.Ground;
import com.fm.www.dto.Photo;
import com.fm.www.dto.Team;
import com.fm.www.dto.Tournament;
import com.fm.www.dto.User;
import com.fm.www.service.face.AdminService;
import com.fm.www.util.Paging;


@Controller
public class ErrorController {
	private static final Logger logger = LoggerFactory.getLogger(ErrorController.class);
	
	
	
	@RequestMapping(value = "/error/error", method = RequestMethod.GET)
	public void error() {		
	
	}
	
	@RequestMapping(value = "/error/error307", method = RequestMethod.GET)
	public void error307() {		
	
	}
	
	@RequestMapping(value = "/error/error400", method = RequestMethod.GET)
	public void error400() {		
	
	}
	
	@RequestMapping(value = "/error/error401", method = RequestMethod.GET)
	public void error401() {		
	
	}
	
	@RequestMapping(value = "/error/error404", method = RequestMethod.GET)
	public void error404() {		
	
	}
	
	@RequestMapping(value = "/error/error405", method = RequestMethod.GET)
	public void error405() {		
	
	}
	
	@RequestMapping(value = "/error/error500", method = RequestMethod.GET)
	public void error500() {		
	
	}
	
	@RequestMapping(value = "/error/error503", method = RequestMethod.GET)
	public void error503() {		
	
	}
	
   
   
   
}













