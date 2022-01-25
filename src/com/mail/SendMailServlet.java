package com.mail;

import java.io.IOException;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeUtility;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class SendMailServlet
 */
@WebServlet("/SendMailServlet")
public class SendMailServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String mailTo= (String)request.getAttribute("mailTo");
		String userid = (String)request.getAttribute("userid");
		String passwd = (String)request.getAttribute("passwd");
		
		String host = null;
		String subject = null;  //제목
		String from = null; //보내는 사람의 메일
		String fromName = null;//보내는 사람이름 
		String to = null; //받는 사람의 메일 
		String content = null;//메일 내용
		
	System.out.println("SendMailServlet:::"+mailTo+"\t"+userid);
	if (userid!=null) {
	   	host = "smtp.naver.com";
	   	subject = "[...] 고객님의 ID입니다.";  //제목
		 from = "dnflwlq133@naver.com"; //보내는 사람의 메일
		 fromName = "Test";//보내는 사람이름 
		 to = mailTo; //받는 사람의 메일 
		 content = "아이디:" + userid;//메일 내용
		
	}else if (passwd!=null) {
		
		 host = "smtp.naver.com";
		 subject = "[...] 고객님의 PW입니다.";  //제목
		 from = "dnflwlq133@naver.com"; //보내는 사람의 메일
		 fromName = "Test";//보내는 사람이름 
		 to = mailTo; //받는 사람의 메일 
		 content = "비밀번호:" + passwd;//메일 내용
	}

	 try{
	     //프로퍼티 값 인스턴스 생성과 기본세션(SMTP 서버 호스트 지정)
	     Properties props = new Properties();
	     //네이버 SMTP 사용시
	    props.put("mail.smtp.starttls.enable","true");
	     props.put("mail.transport.protocol","smtp");
	     props.put("mail.smtp.host", host);
	     
	     props.put("mail.smtp.port","465");  // 보내는 메일 포트 설정
	    props.put("mail.smtp.user", from);
	     props.put("mail.smtp.auth","true");
	     props.put("mail.smtp.debug", "true");
	     props.put("mail.smtp.socketFactory.port", "465");
	     props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
	     props.put("mail.smtp.socketFactory.fallback", "false");


	     Authenticator auth = new SendMail();
	     Session mailSession = Session.getDefaultInstance(props,auth);
	   
	     Message msg = new MimeMessage(mailSession);
	     msg.setFrom(new InternetAddress(from, MimeUtility.encodeText(fromName,"UTF-8","B"))); //보내는 사람 설정
	    InternetAddress[] address = {new InternetAddress(to)};
	    
	     msg.setRecipients(Message.RecipientType.TO, address); //받는 사람설정
	   
	     msg.setSubject(subject); //제목설정
	    msg.setSentDate(new java.util.Date()); //보내는 날짜 설정
	    msg.setContent(content,"text/html; charset=UTF-8"); //내용 설정(MIME 지정-HTML 형식)
	    
	     Transport.send(msg); //메일 보내기

	     }catch(MessagingException ex){
	      System.out.println("mail send error : "+ex.getMessage());
	       ex.printStackTrace();
	     }catch(Exception e){
	      System.out.println("error : "+e.getMessage());
	       e.printStackTrace();
	     }
	   	
	   	 request.setAttribute("mesg2", "메일 발송을 완료했습니다.");
	     RequestDispatcher dis = request.getRequestDispatcher("loginForm.jsp");
	     dis.forward(request, response);
	   
	}//end doGet

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
