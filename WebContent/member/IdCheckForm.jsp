<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
    <title>아이디 중복 체크</title>
    
    <style type="text/css">
        #wrap {
            width: 490px;
            text-align :center;
            margin: 0 auto 0 auto;
        }
        
        #chk{
            text-align :center;
        }
        
        #cancelBtn{
            visibility:visible;
        }
        
         #useBtn{
             visibility:hidden;
        } 
 		/*  사용가는시 보이게할거 */
 		
 		<script src=""></script>
 		
   </style>
    
    <script type="text/javascript">
    
    
    var httpRequest = null;
    
    // httpRequest 객체 생성
    function getXMLHttpRequest(){
        var httpRequest = null;
    
        if(window.ActiveXObject){
            try{
                httpRequest = new ActiveXObject("Msxml2.XMLHTTP");    
            } catch(e) {
                try{
                    httpRequest = new ActiveXObject("Microsoft.XMLHTTP");
                } catch (e2) { httpRequest = null; }
            }
        }
        else if(window.XMLHttpRequest){
            httpRequest = new window.XMLHttpRequest();
        }
        return httpRequest;    
    }

        // 아이디 입력란의 값을 가져온다.
        // #수정. 변수명이 잘못입력되어 있어서 수정(id -> userid)
        function pValue(){
            document.getElementById("userId").value = opener.document.userInfo.userid.value;
        }
        
        // 아이디 중복체크
        function idCheck(){
 			
        	console.log('ID중복검사');
            var id = document.getElementById("userId").value;
 
            if (!id) {
                alert("아이디를 입력하지 않았습니다.");
                return false;
            } 
            else if((id < "0" || id > "9") && (id < "A" || id > "Z") && (id < "a" || id > "z")){ 
                alert("한글 및 특수문자는 아이디로 사용하실 수 없습니다.");
                return false;
            } 
            else {
                var param = "id="+id;
                httpRequest = getXMLHttpRequest();
                httpRequest.onreadystatechange = callback;
                httpRequest.open("POST", "MemberIdCheckServlet", true);    
                httpRequest.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded'); 
                httpRequest.send(param);
            }

        }
        
        function callback(){
            if(httpRequest.readyState == 4){
                // 결과값을 가져온다.
                var resultText = httpRequest.responseText;
                if(resultText == 1){
                    alert("사용할수없는 아이디입니다.");
                    document.getElementById("cancelBtn").style.visibility='visible';
                    document.getElementById("useBtn").style.visibility='hidden';
                    document.getElementById("msg").innerHTML ="";
                } 
                else if(resultText == 0){ 
                    document.getElementById("cancelBtn").style.visibility='hidden';
                    document.getElementById("useBtn").style.visibility='visible';
                    document.getElementById("msg").innerHTML = "사용 가능한 아이디입니다.";
                }
            }
        }

        /* 입력 가능시 보이게, 불가능시 안보이게 (사용하기) */
           
        // 사용하기 클릭 시 부모창으로 값 전달 
        function sendCheckValue(){
            // 중복체크 결과인 idCheck 값을 전달한다.
            opener.document.userInfo.idDuplication.value ="idCheck";
            // 회원가입 화면의 ID입력란에 값을 전달
            opener.document.userInfo.userid.value = document.getElementById("userId").value;
            
            if (opener != null) {
                opener.chkForm = null;
                self.close();
            }    
        } 
   
   </script>
    
</head>
<body onload="pValue()">		<!-- 중복체크 누르면 보이는 값 -->
<div id="wrap">
    <br>
    <b><font size="4" color="gray">아이디 중복체크</font></b>
    <hr size="1" width="460">
    <br>
    <div id="chk">
        <form id="checkForm">
            <input type="text" name="idinput" id="userId">
            <input type="button" value="중복확인" onclick="idCheck()">
        </form>
        <div id="msg"></div>
        <br>
        <input id="useBtn" type="button" value="사용하기" onclick="sendCheckValue()">
        <input id="cancelBtn" type="button" value="취소" onclick="window.close()">
        
    </div>
</div>    
</body>
</html>
