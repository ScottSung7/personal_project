package com.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dto.MenuDTO;
import com.dto.RestaurantDTO;
import com.service.MenuService;
import com.service.RestaurantService;

/**
 * Servlet implementation class aaa
 */
@WebServlet("/SearchServlet1")
public class SearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String search = request.getParameter("search");
	      System.out.println(search);
	      
	      //menu검색
	      MenuService mServie = new MenuService();
	      List<MenuDTO> mList = mServie.menuSearch(search);
	      for (MenuDTO menuDTO : mList) {
	         System.out.println(menuDTO);
	      }
	      String mMesg = null;
	      if (mList.size()==0) {
	         mMesg = "검색결과가 없습니다. 다시 검색하시려면 버튼을 클릭해주세요.";
	      } else {
	         mMesg = "이런 메뉴를 찾으시나요?";
	      }
	      request.setAttribute("mList", mList);
	      request.setAttribute("mMesg", mMesg);
	      System.out.println("\n");
	      
	      //restaurant검색
	      RestaurantService rServie = new RestaurantService();
	      List<RestaurantDTO> rList = rServie.resSearch(search);
	      for (RestaurantDTO rDTO : rList) {
	         System.out.println(rDTO);
	      }
	      String rMesg = null;
	      if (rList.size()==0) {
	         rMesg = "검색결과가 없습니다. 다시 검색하시려면 버튼을 클릭해주세요.";
	      } else {
	         rMesg = "이런 맛집을  찾으시나요?";
	      }
	      request.setAttribute("rList", rList);
	      request.setAttribute("rMesg", rMesg);
	      
	      //data forward
	      RequestDispatcher dis = request.getRequestDispatcher("searchResult.jsp");
	      dis.forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
