package com.fm.www.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fm.www.dao.face.CommunityDao;
import com.fm.www.service.face.CommunityService;

@Service
public class CommunityServiceImpl implements CommunityService{
	@Autowired CommunityDao communityDao; 
}
