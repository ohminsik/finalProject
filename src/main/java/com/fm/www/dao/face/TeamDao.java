package com.fm.www.dao.face;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.fm.www.dto.Team;
import com.fm.www.util.Paging;

public interface TeamDao {
	
	//팀 총 갯수 가져오기
	public int teamTotalCount(@Param("w")String word, @Param("i") int i,@Param("ts") String team_sport);

	public List<Team> teamGetList(@Param("p")Paging paging, @Param("w") String word, @Param("i") int i,@Param("ts") String team_sport);

}
