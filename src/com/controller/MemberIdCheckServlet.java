package com.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.MemberDAO;
import com.service.MemberService;

/**
 * Servlet implementation class MemberIdCheckServlet
 */
@WebServlet("/member/MemberIdCheckServlet")
public class MemberIdCheckServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MemberIdCheckServlet() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		String id = request.getParameter("id");
		MemberService service = new MemberService();
        
		// 아이디 중복검사 실행. 중복이면 1 반환.
        int result = service.duplicateIdCheck(id);
        
        response.setContentType("text/html;charset=euc-kr");
        PrintWriter out = response.getWriter();
 
        if(result == 1)    out.println("1"); // 아이디 중복
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
