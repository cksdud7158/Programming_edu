<%@page import="servlet.model.MemberVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	MemberVO vo =(MemberVO)session.getAttribute("loginVo");
	if(vo==null){
%>
	<b><a href="login.html">로그인 하러가기</a></b>
<%
	}else{
		session.invalidate();
	}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	function logoutpopup()() {
		alert("Log Out!!")
	}

</script>
</head>
<body onload="return logoutpopup()">
	<b>로그아웃 되셨습니다. </b><br/>
	<a href="index.html">홈으로 가기</a>

</body>
</html>