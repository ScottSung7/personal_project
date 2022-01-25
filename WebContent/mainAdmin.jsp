<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
header {
    width: 100%;
    height: 100px;
    background-color: #bf7d7d;
}

footer {
    width: 100%;
    height: 100px;
    background-color: #2c0808;
}

#main {
    width: 100%;
    height: 700px;
    background-color: white;
}

#sidebar {
    float: left;
    width: 150px;
    height: 700px;
    background-color: #716a6a;
}


}
     
    </style>
   <jsp:include page="common/top.jsp" flush="false"></jsp:include>
   
</head>
<body>

    <header>상단</header>
    <div id="main">main
    <jsp:include page="admin/mainAdmin.jsp" flush="false"></jsp:include>
        
        
    </div>
    <div id="sidebar">사이드</div>
    <footer>하단</footer>
</body>
</html>