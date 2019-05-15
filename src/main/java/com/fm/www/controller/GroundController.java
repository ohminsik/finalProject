package com.fm.www.controller;


import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.fm.www.dto.Ground;
import com.fm.www.service.face.GroundService;
import com.fm.www.util.Paging;


@Controller
public class GroundController {
	private static final Logger logger = LoggerFactory.getLogger(GroundController.class);
	
	@Autowired GroundService groundService;
	
	 @RequestMapping(value = "/ground/groundList", method = RequestMethod.GET)
	 public void groundListGet(String curPage, Model model, String region) {
		//현제 페이지 번호 받기
		int curPage1 = groundService.getcurPage(curPage);
		// 대회 게시글 전체 수
		int totalCount = groundService.groundTotalCount(region);
		
		//페이징
		Paging paging = new Paging(totalCount,curPage1,8);
		
		
		// 대회 페이징 리스트 처리
		List<Ground> list = groundService.groundGetList(paging, region);
		
		for(int i=0; i<list.size(); i++) {
			list.get(i).setPhoto_stored(groundService.getPhotoStored(list.get(i).getBoard_no()));
		}
		
		model.addAttribute("region",region);
		model.addAttribute("paging",paging);
		model.addAttribute("list", list);
 }
	 
	 @RequestMapping(value = "/ground/groundSearch", method = RequestMethod.GET)
	 public void groundListGet(Model model, String word, String curPage) {
		//현제 페이지 번호 받기
		int curPage1 = groundService.getcurPage(curPage);
		// 대회 게시글 전체 수
		int totalCount = groundService.groundTotalCountWord(word);
		
		//페이징
		Paging paging = new Paging(totalCount,curPage1);
		
		
		// 대회 페이징 리스트 처리
		List<Ground> list = groundService.groundGetListWord(paging, word);
			
			
		model.addAttribute("word",word);
		model.addAttribute("paging",paging);
		model.addAttribute("list", list);
		
	 }
	 
	 @RequestMapping(value = "/ground/groundSearch", method = RequestMethod.POST)
	 public void groundListPost(Model model, HttpServletRequest request, HttpServletResponse response) {
		 try {
			request.setCharacterEncoding("utf-8");
			String ground_name = request.getParameter("ground_name");
			
			System.out.println(ground_name);
			response.setCharacterEncoding("UTF-8");   
			response.getWriter().print("<html><head><meta charset=\"UTF-8\"></head><script type='text/javascript'>alert(123);"
					
					+ "window.onload = function() "
					+ "{opener.sendData('"+ground_name+"');  window.close();}</script></html>");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}				
	}
	
 }
   
   
   
   














