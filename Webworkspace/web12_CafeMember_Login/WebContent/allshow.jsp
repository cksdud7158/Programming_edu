<%@page import="servlet.model.MemberVO"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<p>
<p>
<h2> 모든 회원 정보 출력</h2>
	<%
		ArrayList<MemberVO> list = (ArrayList<MemberVO>)request.getAttribute("list");
		for(int i=0; i<list.size();i++){
	%>
	id : <%= list.get(i).getName() %><p>
	password : <%= list.get(i).getPassword() %><p>
	name : <%= list.get(i).getName() %><p>
	address : <%= list.get(i).getAddr() %><p>

	<hr>
	
	<%
	} 
	%>
	
</body>
</html>