<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>ServletConfig</h2>
	<b>Count :: <b>
	<%= request.getParameter("cnt")%>
	<b>userName :: <b>
	<%= request.getParameter("userName")%>
</body>
</html>