package com.fm.www.service.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fm.www.dao.face.AdminDao;
import com.fm.www.dto.Admin;
import com.fm.www.service.face.AdminService;

@Service
public class AdminServiceImpl implements AdminService{
	@Autowired AdminDao adminDao;

	@Override
	public Admin login(Admin admin) {
		return adminDao.login(admin);
	}

	

}
