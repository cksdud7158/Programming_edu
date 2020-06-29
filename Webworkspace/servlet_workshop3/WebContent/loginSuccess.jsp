<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
	<a href="http://localhost:8888/servlet_workshop1/index.html">로그아웃</a>
</body>
</html>