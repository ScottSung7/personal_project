package com.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.config.MySqlSessionFactory;
import com.dao.MenuDAO;
import com.dto.MenuDTO;

public class MenuService {

	public int menuAdd(MenuDTO dto) {
		SqlSession session = MySqlSessionFactory.getSession();
		  int n = 0;
		  try {
			  MenuDAO dao = new MenuDAO();
			  n = dao.menuAdd(session, dto);
			  session.commit();
		  }finally {
			session.close();
		}
		  return n;
	}

	public List<String> menuList(String image) {
		SqlSession session = MySqlSessionFactory.getSession();
		  List<String> list = null;
		  try {
			  MenuDAO dao = new MenuDAO();
			  list = dao.menuList(session, image);
			  session.commit();
		  }finally {
			session.close();
		}
		  return list;
	}

	public MenuDTO selectedMenu(String menu) {
		SqlSession session = MySqlSessionFactory.getSession();
		  MenuDTO selection = null;
		  try {
			  MenuDAO dao = new MenuDAO();
			  selection = dao.selectedMenu(session, menu);
			  session.commit();
		  }finally {
			session.close();
		}
		  return selection;
	}

	public List<MenuDTO> menuSearch(String search) {
		SqlSession session = MySqlSessionFactory.getSession();
		List<MenuDTO> list = null;
		try {
			MenuDAO dao = new MenuDAO();
			list = dao.menuSearch(session, search);
		} catch (Exception e) {
			session.close();
		}
		return list;
	}

	public String getMenuImage(String menuFinal) {
		SqlSession session = MySqlSessionFactory.getSession();
		String menuImage = null;
		try {
			MenuDAO dao = new MenuDAO();
			menuImage = dao.getMenuImage(session, menuFinal);
		} catch (Exception e) {
			session.close();
		}
		return menuImage;
	}
	
}
