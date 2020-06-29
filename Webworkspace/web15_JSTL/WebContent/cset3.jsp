<%--
	1. 라이브러리 추가 standard.jar, jstl.jar
	2. tagLib 속성을 지정
 --%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
	
	
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="cIf3_view.jsp">
		NUM1 : <input type="text" name="num1"><p>
		NUM2 : <input type="text" name="num2"><p>		
		<input type="submit" value="send">
	
	</form>
</body>
</html>

