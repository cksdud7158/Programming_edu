
<%@page import="servlet.model.UserVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%
 	UserVO vo =(UserVO)session.getAttribute("loginVO");
  if(vo==null){
 %>
 <h3>로그인 부터 시작하세요...</h3>
 <a href="index.html">login.html</a>
 <%
 }
 %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
	body{
		width: 900px;
		height: 300px;
		margin: 0 auto;
		margin-top: 200px;
		text-align: center;
		border: 1px solid black;
	}
	a{
		display: block;
	}
</style>
</head>
<body>
	<h2><%= request.getParameter("id") %>님이 로그인되었습니다.</h2>
	<a href="registerBook.html">도서 등록</a>
	<a href="logout.jsp">로그아웃</a>
	<a href="BookListServlet">도서 목록</a>
</body>
</html>