package com.fm.www.dao.face;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.fm.www.dto.Ground;
import com.fm.www.util.Paging;

public interface GroundDao {

	public int groundTotalCount(String region);
	public int groundTotalCountWord(String word);

	public List<Ground> groundGetList(@Param("p1")Paging paging, @Param("p2")String region);

	public String getPhotoStored(int board_no);

	public List<Ground> groundGetList1();
	public List<Ground> groundGetListWord(@Param("p1")Paging paging, @Param("p2")String word);

	

	
	
}
