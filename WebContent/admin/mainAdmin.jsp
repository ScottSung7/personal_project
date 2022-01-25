<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="com.dto.MemberDTO"%>
<%@page import="com.dto.MenuDTO"%>
<%@page import="java.util.List"%>

<%
	MemberDTO dto = (MemberDTO)session.getAttribute("login");

	if(dto != null){
		String username = dto.getUsername();		
		List <String> menuR = (List<String>)request.getAttribute("menuR");
		System.out.println("selected: "+menuR);
		String menuFinal = "준비중";
		 if(menuR!=null){
			String menu = menuR.get(0);
			menuFinal = menu;
		}
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>나의 맛슐랭. 틀린 입맛은 없어</title>
</head>
<body>
Admin Page
<h1><%= username %>페이지입니다.</h1>
<h2><%= username %>님께 추천드리는 메뉴는 <%= menuFinal %>입니다</h2><br>
<button type="button" onclick="location.href='menuGameServlet'">추천</button>
<%} %>
<button type="button" onclick="location.href='MenuSelect'">결과</button>
<button type="button" onclick="location.href='menuAdd.jsp'">메뉴추가</button>
</body>
</html>