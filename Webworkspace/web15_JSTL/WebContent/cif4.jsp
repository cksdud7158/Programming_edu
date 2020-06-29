<%--
	1. 라이브러리 추가 standard.jar, jstl.jar
	2. tagLib 속성을 지정
 --%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
	
	<c:set var="CODE" value="1004" scope="request"/> <%-- scope="request" 를 써주지 않으면 현재 페이지에만 바인딩 hla --%>
 	<c:set var="NAME" value="encore" scope="session"/> 
 	<c:set var="PRICE" value="220000" scope="application"/>
 	
 	<jsp:forward page ="cset2_view.jsp"/> 
 	
 	
 	<c:set var="multiple" value="${num1* num2}"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	상품 코드 : ${CODE }
</body>
</html>