package com.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dto.MemberDTO;
import com.service.LikeService;
import com.service.MemberService;

/**
 * Servlet implementation class MemberUIServlet
 */
@WebServlet("/MemberAddServlet")
public class MemberAddServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String userid = request.getParameter("userid");
		String passwd = request.getParameter("passwd");
		String username = request.getParameter("username");
		String post = request.getParameter("post");
		String addr1 = request.getParameter("addr1");
		String addr2 = request.getParameter("addr2");
		String phone = request.getParameter("phone");
		String email1 = request.getParameter("email1");
		String email2 = request.getParameter("email2");
		
		System.out.println(userid+"\t"+passwd+"\t"+username+"\t"+post+"\t"+addr1+"\t"+addr2+"\t"+phone+"\t"+email1+"\t"+email2);
		MemberDTO dto = 
				new MemberDTO(userid, passwd, username, post, addr1, addr2, phone, email1, email2);
		
		MemberService service = new MemberService();
		int n = service.insert(dto);
		System.out.println(n);			
		
		
		
		HttpSession session = request.getSession();
		if(n>0) {request.setAttribute("mesg", "회원가입성공");};
		RequestDispatcher dis = request.getRequestDispatcher("loginForm.jsp");
		dis.forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
