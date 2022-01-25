package com.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.dto.MenuDTO;
import com.dto.RestaurantDTO;

public class RestaurantDAO {

	public List<RestaurantDTO> resSearch(SqlSession session, String search) {
		List<RestaurantDTO> list = session.selectList("RestaurantMapper.resSearch",search);
		return list;
	}
	
	public List<RestaurantDTO> resList(SqlSession session) {
		   List<RestaurantDTO> list = 
				   session.selectList("RestaurantMapper.resList");
		   return list;
	   }


}
