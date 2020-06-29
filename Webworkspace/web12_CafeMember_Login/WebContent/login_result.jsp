<%@page import="servlet.model.MemberVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%
 	MemberVO vo =(MemberVO)session.getAttribute("loginVo");
 if(vo==null){
 %>
 <h3>로그인 부터 시작하세요...</h3>
 <a href="login.html">login.html</a>
 <%
 }
 %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2> 로그인 정보</h2>
	ID : <%= vo.getId()  %><p>
	Password <%= vo.getPassword() %><p>
	JSESSION ID -- <%= session.getId() %>
	<hr>
	<a href="logout.jsp">Log OUT</a><br/>
	<a href="index.html">index</a>
</body>
</html>