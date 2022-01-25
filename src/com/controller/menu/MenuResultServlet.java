package com.controller.menu;

import java.io.IOException;
import java.util.Collections;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dto.LikeDTO;
import com.dto.MemberDTO;
import com.service.LikeService;
import com.service.MemberService;

/**
 * Servlet implementation class MenuSelect
 */
@WebServlet("/MenuResultServlet")
public class MenuResultServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MenuResultServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("\n\n\n\n\nMenuResultServletMenuResultServlet\n\n\n\n");
		//1. 세션을 통한 로그인 처리
		HttpSession session = request.getSession();
		MemberDTO dto = (MemberDTO)session.getAttribute("login");
		String nextPage = null;
	    if(dto!=null) {
		//2.Userid를 세션에서 가져옵니다. 
		String userid = dto.getUserid();
		
		//3. Userid를 이용해 통해 유저의 고객취향테이블에 접속하여 
		// 각각의 값의 최빈값을 가져옵니다.
		LikeService service = new LikeService();
		//int result = service.createResultTable(userid);
		String genre = service.getGenre(userid);
		String estyle = service.getestyle(userid);
		String texture = service.gettexture(userid);
		String taste = service.gettaste(userid);
		String sauce = service.getsauce(userid);
		String spice = service.getspice(userid);
		String carbo = service.getcarbo(userid);
		String meat = service.getmeat(userid);
		String fat = service.getfat(userid);
		String vegi = service.getvegi(userid);
		
		//4. 뽑아온 데이터를 LikeDTO에 저장합니다.
		// 	 총 55가지종류의 데이터를 저장하는 LikeDTO와 함수가 있을 예정입니다.
		//  컬럼이 10개라 가지수가 55개 입니다.
		//  (10+9+8+7+6+5+4+3+2+1) = 55
		
		//5. 컬럼 10개중 10개 일치, 9개일치 순으로 뽑아옵니다.
		// 일단 테스트용으로 3개를 만들었는데 총 55개의 함수를 제작 예정입니다. 
		// menuR1: 10개 모두 일치
		// menuR9AG: 2개 일치 (genre, carbo)
		// menu10A: 1개일치 (genre)
		LikeDTO none = new LikeDTO();
		LikeDTO menuR1 = new LikeDTO(genre, estyle, texture, taste, sauce, spice, carbo, meat, fat, vegi);
		LikeDTO menuR9AG = new LikeDTO(genre, carbo);
		System.out.println(menuR9AG);
		
		//뒤에 Z자를 붙여서 값을 받아올 list를 생성했습니다.
		//일치하는 메뉴가 여러종류가 있을 수 있기에 List<String>으로 결과를 받습니다.
		if(genre==null) {
			System.out.println("if");
			request.setAttribute("menuR", null);
			RequestDispatcher dis =
					request.getRequestDispatcher("menuResult.jsp");
					dis.forward(request, response);}
		
		if(genre!=null) {
		List<String> menuR1Z = service.getMenuR1(menuR1);
		List<String> menuR9AGZ = service.getMenuR9AG(menuR9AG);
		List<String> menuR10AZ = service.menuR10A(genre);
		
		//일단 10개일치 부터 확인합니다.
		 if(menuR1Z.size()!=0) {			
			System.out.println("R1F"+menuR1Z);
			Collections.shuffle(menuR1Z);
			request.setAttribute("menuR", menuR1Z);
			RequestDispatcher dis =
					request.getRequestDispatcher("menuResult.jsp");
		    	dis.forward(request, response);
		//10개 일치하는 메뉴가 없으면 2개일치하는 값이 있는지 확인합니다.    	
		}else if (menuR1Z.size()==0&&menuR9AGZ.size()!=0) {
			System.out.println("menuR9AG서블릿"+menuR9AGZ);
			Collections.shuffle(menuR9AGZ);
			request.setAttribute("menuR", menuR9AGZ);
			RequestDispatcher dis =
				    request.getRequestDispatcher("menuResult.jsp");
				    dis.forward(request, response);	
		//2개 일치하는 값이 없으면 1개 일치하는 값이 있는지 확인합니다.
		//일치하는 값이 있는순간 forward해서 main.jsp로 값을 보내줍니다.
		//보내기 전에 Coolections.shuffle을 이용해 배열을 랜덤하게 생성합니다.
		}else if(menuR9AGZ.size()==0){	
			System.out.println("menuR10A"+menuR10AZ);
			Collections.shuffle(menuR10AZ);
			request.setAttribute("menuR", menuR10AZ);
			RequestDispatcher dis =
				    request.getRequestDispatcher("menuResult.jsp");
				    dis.forward(request, response);
		}
		}
	    }else {
	    	RequestDispatcher dis =
					request.getRequestDispatcher("first.jsp");
	    	
	    }//end 로그인처리
		
		//ResDTO res = service.getRes(genre);
		//System.out.println(menuR);
		//System.out.println(res);
		//session.setAttribute("menu", menu);
		//session.setMaxInactiveInterval(60*60);;
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
