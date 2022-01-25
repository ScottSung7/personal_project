package com.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dto.MemberDTO;
import com.service.MemberService;

/**
 * Servlet implementation class IdSearchServlet
 */
@WebServlet("/IdSearchServlet")
public class IdSearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public IdSearchServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//idSearch에서 데이터를 파싱해옴 
		String username = request.getParameter("username");
		String phone = request.getParameter("phone");
		String email1 = request.getParameter("email1");
		String email2 = request.getParameter("email2");
		System.out.println(username+"\t"+phone+"\t"+email1+"\t"+email2);
		
		//username과 phone1,2,3를 memberDTO에 담아 검사
		MemberDTO dto = new MemberDTO();
		dto.setUsername(username);
		dto.setPhone(phone);
		
		MemberService service = new MemberService();
		String userid = service.idSearch(dto);
		System.out.println(userid);
		String nextPage = null;
		if (userid == null) {//userid가 없는 경우
			nextPage  =  "idSearch.jsp";
			request.setAttribute("mesg", "이름 또는 핸드폰을 확인해 주세요");
		} else {//userid가 있는 경우
			nextPage = "SendMailServlet";
			request.setAttribute("mailTo", email1+"@"+email2);
			request.setAttribute("userid", userid);			
		}
		RequestDispatcher dis = request.getRequestDispatcher(nextPage);
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
