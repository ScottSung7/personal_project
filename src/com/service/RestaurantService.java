package com.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.config.MySqlSessionFactory;
import com.dao.MenuDAO;
import com.dao.RestaurantDAO;
import com.dto.MenuDTO;
import com.dto.RestaurantDTO;

public class RestaurantService {

	public List<RestaurantDTO> resSearch(String search) {
		SqlSession session = MySqlSessionFactory.getSession();
		List<RestaurantDTO> list = null;
		try {
			RestaurantDAO dao = new RestaurantDAO();
			list = dao.resSearch(session, search);
		} catch (Exception e) {
			session.close();
		}
		return list;
	}
	
	public List<RestaurantDTO> resList() {
		SqlSession session = MySqlSessionFactory.getSession();
		List<RestaurantDTO> list = null;
		try {
			 RestaurantDAO dao = new RestaurantDAO();
			 list = dao.resList(session);
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			session.close();
		}
		return list;
	}	 
	


}
