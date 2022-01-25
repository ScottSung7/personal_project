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

import com.dto.MemberDTO;
import com.service.MenuService;

/**
 * Servlet implementation class menuGameServlet
 */
@WebServlet("/menuGameServlet")
public class menuGameServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public menuGameServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//1. 세션을 통한 로그인 처리입니다.
		HttpSession session = request.getSession();
	    MemberDTO dto = (MemberDTO)session.getAttribute("login");
		String nextPage = null;
	    if(dto!=null) {
	    //2. 로그인이 된 경우 image라는 String을 하나 생성합니다. 	
		String image = "image";
		
		//3. image는 컬럼이름입니다. 
		// -1. image 컬럼은 food유저의 menu테이블의 컬럼이름중 하나이고
		// menu테이블에는 레스토랑이름, 메뉴이름등등의 컬럼이 존재하고
		// 그중에서 image 컬럼은 이미지의 이름들을 가지고 있습니다. 
		// -2. image라는 컬럼 이름을 통해 menuList라는 함수를 호출합니다.
		// menuList 함수는 List<String>에 menu테이블에서
		// 모든 image이름들을 가지고 옵니다. 
		MenuService service = new MenuService();		
		List<String> list = service.menuList(image);
		List<String> list2 = service.menuList(image);
		
		//4. 두가지 이미지를 띄우기 위해 같은 배열을 가지는 두개의 list를 생성합니다.
		// list 와 list2는 이름만 다르지 같은 내용의 배열을 가지고 있습니다.
	
		Collections.shuffle(list);
		Collections.shuffle(list2);
		//5. Collections.shuffle 함수를 이용하여 배열을 램덤으로 생성되게 합니다. 
		//이제 list와 list2는 다른 배열을 가지고 있습니다. 
		
		System.out.println("Game서블릿"+list);
		System.out.println(list2);
		for (int i = 0; i < list.size(); i++) {
			System.out.println("list"+list.get(i));
		}
		for (int i = 0; i < list2.size(); i++) {
			System.out.println("list2"+list2.get(i));
		}
		//다른 배열을 가지고 있음을 list와 for문을 통해 체크합니다. 
		
		String a = list.get(0);
		String b = list2.get(0);
		System.out.println("선택"+a);
		System.out.println(b);
		while (a.equals(b)) {
			Collections.shuffle(list);
			Collections.shuffle(list2);
		}
		
		//6. 이 두개의 리스트를 request하여 menuGame.jsp로 포워드하여 넘길것 입니다. 
		//else부분은 비로그인시 로그인을 요청하여 cover.jsp로 다시 되돌아가게 합니다.
		request.setAttribute("list", list);
		request.setAttribute("list2", list2);
		
		nextPage = "menuGame.jsp";
	     }else {
			  nextPage = "cover.jsp";
			  request.setAttribute("mesg", "로그인이 필요한 작업입니다.");
		  }
	      RequestDispatcher dis =
	    		  request.getRequestDispatcher(nextPage);
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
