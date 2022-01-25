package com.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dto.MemberDTO;
import com.dto.RestaurantDTO;
import com.service.MemberService;
import com.service.RestaurantService;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//메인에 뿌려질 레스토랑 정보 가져오기
		HttpSession session = request.getSession();
		RestaurantService service2 = new RestaurantService();
		List<RestaurantDTO> list = service2.resList();
		
		session.setAttribute("resList", list);
		System.out.println("loginServlet@@@:::"+list);
	
		
		
		
		String userid = (String) request.getParameter("userid");
		String passwd = (String) request.getParameter("passwd");
		System.out.println(userid+"\t"+passwd);
		HashMap<String, String> map = new HashMap<String, String>(); //map에 넣어 userid와 passwd 검사
		map.put("userid", userid);
		map.put("passwd", passwd);
		
		MemberService service = new MemberService();
		MemberDTO dto = service.loginCheck(map);
		System.out.println("로그인여부:"+dto);
		String nextPage = "";//로그인 정보에 따라 이동할페이지		
		
		
//		if(dto.getUserid().equals("admin")) { //관리자 계정인지 검사
//			nextPage = "mainAdmin.jsp";
//			session.setAttribute("login", dto);
		//admin 처리 부분 끝.
		 if (dto != null) { //dto정보 있을 때 
			 
			if (userid.equals("admin")) {//userid가 관리자 계정인 경우
				nextPage = "mainAdmin.jsp";
				session.setAttribute("login", dto);
			} else {
				session.setAttribute("login", dto);//dto로 로그인정보 세션저장
				nextPage="main.jsp";
				
				System.out.println("login 성공");			
			}
			 
		} else { //dto정보 없을 때 
			nextPage="loginForm.jsp";
			request.setAttribute("mesg", "로그인 정보가 틀렸습니다.");
			
		}
		 
		RequestDispatcher dis = request.getRequestDispatcher(nextPage);//로그인 정보가 없을 경우 login.jsp로 이동시켜 다시 로그인시키게 만듦
		dis.forward(request, response);//forward를 통해 메세지 전달//if-else end

		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
