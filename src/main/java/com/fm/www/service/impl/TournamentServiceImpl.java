package com.fm.www.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fm.www.dao.face.TournamentDao;
import com.fm.www.service.face.TournamentService;

@Service
public class TournamentServiceImpl implements TournamentService{
	@Autowired TournamentDao tournamentDao;
}
