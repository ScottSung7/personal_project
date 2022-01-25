package com.controller.menu;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dto.LikeDTO;
import com.dto.MemberDTO;
import com.dto.MenuDTO;
import com.service.LikeService;
import com.service.MenuService;

/**
 * Servlet implementation class likeAddServlet
 */
@WebServlet("/likeAddServlet")
public class likeAddServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public likeAddServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1. 로그인처리 부분입니다.
		HttpSession session = request.getSession();
		MemberDTO dto = (MemberDTO)session.getAttribute("login");
		String nextPage = null;
		if(dto!=null) {
		//2. food1이라는 radio의 name으로 radio의 value를 가져옵니다.
		// menu라는 String에 radio의 value를 저장하고
		// 가져온 value는 menuGame.jsp에서 말씀드렸듯 menu의 이미지이름입니다.
		String menu = request.getParameter("food1");
		System.out.println("selected"+menu);
		
		//3. 이미지이름을 통해 선택된 menu의 정보를 food유저의 menu테이블에서 가져옵니다.
		//menuDTO는 menu테이블의 컬럼들과 동일한 변수들을 가지고 있습니다. 
		//selectedMenu 함수를 통해 menu테이블에서 정보를 가져옵니다.
		MenuService service = new MenuService();
		MenuDTO selection = service.selectedMenu(menu);
		System.out.println("서블릿"+selection);
		
		//4. 이제 가져온 정보를 LikeDTO에 저장할 것입니다.
		//	 LikeDTO는 likes유저에 생성되는 고객아이디를 딴 테이블의 컬럼들과 
		//	 동일한 변수를 가지고 있습니다. (즉,LikeDTO = 고객취향 테이블과 같습니다.)
		//5. MenuDTO객체에 가져온 정보들을 각각의 변수에 넣습니다. 
		//   userid는 food유저의 menu테이블에 없으므로 login 세션에서 가져옵니다. 
		String userid = dto.getUserid(); //Userid 파싱		
		String genre = selection.getGenre();
		String estyle = selection.getEstyle();
		String texture = selection.getTexture();
		String taste = selection.getTaste();
		String sauce = selection.getSauce();
		String spice = selection.getSpice();
		String carbo = selection.getCarbo();
		String meat = selection.getMeat();
		String fat = selection.getFat();
		String vegi = selection.getVegi();
		
		//6. 각변수를 likeDTO에 저장합니다. 	
		LikeDTO like = new LikeDTO(userid, genre, estyle, texture,
				taste, sauce, spice, carbo, meat, fat, vegi);
		LikeService service2 = new LikeService();
		System.out.println(like);
		int n = service2.insertSelect(like);
		//7. LikeService를 통해 inserSel함수를 이용하여 고객취향테이블에 값을 넣습니다.
		// 	 LikeService를 만든이유는 LikeService에서 likes유저 관련 함수들을 사용합니다.
		//   유저가 2개이기 때문에 db에 접근하는 config종류가 2가지 있습니다.
		//	 likes유저관련 config: jdbc2.properties	Configuration2.xml
		//						MysqlSessionFactory2 LikeMapper
				
		//8. 성공여부는 n값으로 알 수 있고 성공시 다시 menuGameServlet을 통해
		//   menuGame.jsp로 이동하여 선택을 계속 할 수 있습니다. 
				
		
		nextPage = "menuGameServlet";
		
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
