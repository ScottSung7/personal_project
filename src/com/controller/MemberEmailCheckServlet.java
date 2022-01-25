package com.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.service.MemberService;

/**
 * Servlet implementation class MemberEmailCheckServlet
 */
@WebServlet("/member/MemberEmailCheckServlet")
public class MemberEmailCheckServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MemberEmailCheckServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String email1 = request.getParameter("email1");
		String email2 = request.getParameter("email2");
		
		HashMap<String, String> map = new HashMap<String, String>(); //map에 email1과 email2를 넣는다.
		map.put("email1", email1);
		map.put("email2", email2);
		MemberService service = new MemberService();
        
		// 이메일 중복검사 실행. 중복이면 1 반환.
        int result = service.duplicateEmailCheck(map);
        
        response.setContentType("text/html;charset=euc-kr");
        PrintWriter out = response.getWriter();
 
        if(result == 1)    out.println("1"); // 이메일 중복
        else        out.println("0");
        
        out.close();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
