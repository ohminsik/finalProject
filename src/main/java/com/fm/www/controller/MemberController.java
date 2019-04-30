package com.fm.www.controller;

import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

import com.fm.www.dto.User;
import com.fm.www.service.face.MemberService;

@Controller
public class MemberController {
	private static final Logger logger = LoggerFactory.getLogger(MemberController.class);
	@Autowired ServletContext context;
	@Autowired MemberService MemberService;
	/*
	 * joinStep_1 컨트롤러
	 * 회원가입창 띄우기
	 * GET
	 * */
	@RequestMapping(value = "/member/joinStep_1", method = RequestMethod.GET)
	public void joinStep_1Get() {		
	
	}
	
	/*
	 * joinStep_2 컨트롤러
	 * 회원가입창 띄우기
	 * GET
	 * */
	@RequestMapping(value = "/member/joinStep_2", method = RequestMethod.GET)
	public void joinStep_2Get() {		
	
	}
	
	/*
	 * 
	 * */
	@RequestMapping(value = "/member/checkId", method = RequestMethod.POST)
	public String checkId(HttpServletRequest request, Model model) throws Exception{
        String member_id = request.getParameter("inpuid");
        //member_id와 같은 행의 갯수 조회
        int rowcount = MemberService.checkId(member_id);
        
        Map map = new HashMap();
		map.put("data",rowcount);			
		
		model.addAllAttributes(map);
        return "jsonView";
	}
	/*
	 * joinStep_2 컨트롤러
	 * 회원가입처리
	 * POST
	 * */
	@RequestMapping(value = "/member/joinStep_2", method = RequestMethod.POST)
	public String joinStep_2Post(User user, HttpServletRequest request, MultipartFile file, HttpSession session) {
		
		System.out.println(user);
		System.out.println(file.getOriginalFilename());
		
		
		
		try {
			request.setCharacterEncoding("utf-8");
		} catch (UnsupportedEncodingException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		
		String email1 = request.getParameter("user_email");
		String email2 = request.getParameter("user_email1");
		String email = email1 + "@" + email2;
		user.setUser_email(email);
		
		String phone1 = request.getParameter("user_phone1");
		String phone2 = request.getParameter("user_phone2");
		String phone3 = request.getParameter("user_phone3");
		String phone = phone1 + "-" + phone2 + "-" + phone3;
		user.setUser_phone(phone);
		
		String year = request.getParameter("year");
		String month = request.getParameter("month");
		String day = request.getParameter("day");
		String user_birth = year+"-"+month+"-"+day;
		user.setUser_birth(user_birth);
		
		//고유식별자
		String uId = UUID.randomUUID().toString().split("-")[0];

		//저장될 파일 이름
		String stored_name = null;
		//stored_name =file.getOriginalFilename()+"_"+uId;
		stored_name =file.getOriginalFilename();
						
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
		user.setUser_profile(stored_name);
		
		MemberService.insertMember(user);
		
		
		session.setAttribute("nick", user.getUser_nick());
		
		return "redirect:/member/joinStep_3";
	}
	
	/*
	 * joinStep_2 컨트롤러
	 * 회원가입처리
	 * POST
	 * */
	@RequestMapping(value = "/member/joinStep_3", method = RequestMethod.GET)
	public void joinStep_3Get() {			
		
	}
}
