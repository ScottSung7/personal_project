package com.controller.menu;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dto.MenuDTO;
import com.service.MenuService;

/**
 * Servlet implementation class menuAdd
 */
@WebServlet("/MenuAddServlet")
public class MenuAddServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MenuAddServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1. menuAdd.jsp에서 받아온 정보를 
		// 	 menuDTO에 담아 food유저의 menu테이블에 추가합니다. 
		//2. 추가후 menuAdd.jsp로 돌아갑니다.
		String restaurant = request.getParameter("restaurant");
		String menu = request.getParameter("menu");
		String genre = request.getParameter("genre");
		String estyle = request.getParameter("estyle");
		String texture = request.getParameter("texture");
		String taste = request.getParameter("taste");
		String sauce = request.getParameter("sauce");
		String spice = request.getParameter("spice");
		String carbo = request.getParameter("carbo");
		String meat = request.getParameter("meat");
		String fat = request.getParameter("fat");
		String vegi = request.getParameter("vegi");
		String image = request.getParameter("image");
		
		MenuDTO dto = new MenuDTO (restaurant, menu, genre, estyle, texture, taste,
				 sauce, spice, carbo, meat, fat, vegi, image);
		
		MenuService service = new MenuService();
		
		int n = service.menuAdd(dto);
		System.out.println(n);
		
		response.sendRedirect("menuAdd.jsp");
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
