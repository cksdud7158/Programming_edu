<%--
	JSP 에서 jsp 주석은 웹에서 소스 확인시 보이지 않지만
	html 주석은 보인다. 

 --%>

<%--
	JSP Element
	1) 지시어 %@ % : container 에게 알려줄 내용을 지정 ex)import 의 위치를 알려주는거 같은 것 
	2) 스클릿틀릿 % %: 자바 코드는 이 안에 집어넣는다. 
	3) 출력문 %= % : 출력할려는 내용을 지정 
 --%>
<%@page import="servlet.model.MemberVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
 <!-- % % -> ScriptElement :: 자바 코드는 다 이안에 집어 넣는다.   -->
<%
	MemberVO vo =(MemberVO)application.getAttribute("vo");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>회원님의 정보를 출력합니다. </h2>
	<!-- 
		%= % -> 출력문(Expression Element 	)	
	 -->
	<li>당신의 이름은<%= vo.getName() %></li>
	<li>당신의 나이는<%= vo.getAge() %></li>
	<li>당신의 주소는<%= vo.getAddr() %></li>
</body>
</html>