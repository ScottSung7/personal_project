package com.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.dto.LikeDTO;


public class LikeDAO {

	
	public int insertSelect(SqlSession session, LikeDTO like) {
		 int n = session.insert("LikeMapper.insertSelect", like);
		   return n;
	}
	public int createResultTable(SqlSession session, String userid) {
		 int n = session.update("LikeMapper.createResultTable", userid);
		 return n;
	
	}


	// 최빈값들을 가져오는 함수들입니다
	
	public String getGenre(SqlSession session, String userid) {
		String a = session.selectOne("LikeMapper.getGenre", userid);
		return a;
	}


	public String getestyle(SqlSession session, String userid) {
		String a = session.selectOne("LikeMapper.getestyle", userid);
		return a;
	}


	public String gettexture(SqlSession session, String userid) {
		String a = session.selectOne("LikeMapper.gettexture", userid);
		return a;
	}


	public String gettaste(SqlSession session, String userid) {
		String a = session.selectOne("LikeMapper.gettaste", userid);
		return a;
	}


	public String getsauce(SqlSession session, String userid) {
		String a = session.selectOne("LikeMapper.getsauce", userid);
		return a;
	}


	public String getspice(SqlSession session, String userid) {
		String a = session.selectOne("LikeMapper.getspice", userid);
		return a;
	}


	public String getcarbo(SqlSession session, String userid) {
		String a = session.selectOne("LikeMapper.getcarbo", userid);
		return a;
	}


	public String getmeat(SqlSession session, String userid) {
		String a = session.selectOne("LikeMapper.getmeat", userid);
		return a;
	}


	public String getfat(SqlSession session, String userid) {
		String a = session.selectOne("LikeMapper.getfat", userid);
		return a;
	}


	public String getvegi(SqlSession session, String userid) {
		String a = session.selectOne("LikeMapper.getvegi", userid);
		return a;
	}




	//메뉴를 추천하는 함수들입니다
	
	public List<String> getMenuR1(SqlSession session, LikeDTO menuR1) {
		List<String> a = session.selectList("LikeMapper.getMenuR1", menuR1);
		return a;
	}

	public List<String> getMenuR9AG(SqlSession session, LikeDTO menuR9AG) {
		List<String> a = session.selectList("LikeMapper.getMenuR9AG", menuR9AG);
		return a;
	}

	public List<String> menuR10A(SqlSession session, String genre) {
		List<String> a = session.selectList("LikeMapper.menuR10A", genre);
		return a;
	}

}
