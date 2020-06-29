<%@page import="servlet.model.MemberVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<% MemberVO vo = (MemberVO)request.getAttribute("vo"); %>
	<h2>검색한 회원 정보</h2>
	id : <%= vo.getId() %>
	password: <%= vo.getPassword() %>
	name : <%= vo.getName() %>
	addr : <%= vo.getAddr() %>

</body>
</html>