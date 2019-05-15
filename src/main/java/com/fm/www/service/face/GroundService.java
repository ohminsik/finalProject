package com.fm.www.service.face;

import java.util.List;

import com.fm.www.dto.Ground;
import com.fm.www.util.Paging;

public interface GroundService {
	//현재페이지 번 호얻기
	public int getcurPage(String curPage);
	
	//경기장 리스트 총 갯수
	public int groundTotalCount(String region);
	public int groundTotalCountWord(String word);
	
	//경기장 리스트 가져오기
	public List<Ground> groundGetList(Paging paging, String region);
	public List<Ground> groundGetList();
	public List<Ground> groundGetListWord(Paging paging, String word);
	//포토 가져오기
	public String getPhotoStored(int board_no);

	

	

	

	

	
}
