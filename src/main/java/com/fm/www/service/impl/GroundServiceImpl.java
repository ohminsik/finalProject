package com.fm.www.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fm.www.dao.face.GroundDao;
import com.fm.www.dto.Ground;
import com.fm.www.service.face.GroundService;
import com.fm.www.util.Paging;

@Service
public class GroundServiceImpl implements GroundService{
	@Autowired GroundDao groundDao;

	@Override
	public int getcurPage(String curPage) {
		// 요청 파라미터 받기
		String param = curPage;
		// null이거나 ""이 아니면 int로 리턴
		if (param != null && !"".equals(param)) {
			int cur= Integer.parseInt(param);
			return cur;
		}
		
		//null이나 ""면 0으로 반환하기
		return 1;
	}

	@Override
	public int groundTotalCount(String region) {
		return groundDao.groundTotalCount(region);
	}
	
	@Override
	public int groundTotalCountWord(String word) {
		return groundDao.groundTotalCountWord(word);
	}

	@Override
	public List<Ground> groundGetList(Paging paging, String region) {
		return groundDao.groundGetList(paging,region);
	}
	@Override
	public List<Ground> groundGetList() {
		return groundDao.groundGetList1();
	}
	@Override
	public List<Ground> groundGetListWord(Paging paging, String word) {
		return groundDao.groundGetListWord(paging,word);
	}


	@Override
	public String getPhotoStored(int board_no) {
		return groundDao.getPhotoStored(board_no);
	}

	

	

	
	

	

}
