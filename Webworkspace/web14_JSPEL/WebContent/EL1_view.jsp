<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%-- 
	EL ::
	Attribute 에 바인딩된 값을 찾아오는 로직을 태그로 바꾼 기술
	변수명이 아니라 객체를 바인딩한 이름이 사용된다. 
 --%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2> Attribute에 바인딩된 값을 받아오겠습니다.. </h2>
	<b> 1~50 까지의 합산 결과값 :::</b>
	<%= request.getAttribute("RESULT") %><p>
	
	<b> 1~50 까지의 합산 결과값(EL로 받기) ::: </b>
	${requestScope.RESULT}<p>
	${sessionScope.RESULT}<p>
	${RESULT}<p>
	${RESULT+2222}<p>
	${name} <%-- request and sessiond and application 을 찾아도 값이 없으면 그냥 출력 안함 --%>
</body>
</html>