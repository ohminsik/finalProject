package com.fm.www.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fm.www.dao.face.MemberDao;
import com.fm.www.service.face.MemberService;

@Service
public class MemberServiceImpl implements MemberService{
	@Autowired MemberDao memberDao;
}
