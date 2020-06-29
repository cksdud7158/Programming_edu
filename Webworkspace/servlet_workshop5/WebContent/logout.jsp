<%@page import="servlet.model.UserVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	UserVO vo =(UserVO)session.getAttribute("loginVO");
	if(vo==null){
%>
	<b><a href="index.html">로그인 하러가기</a></b>
<%
	}else{
		session.invalidate();
	}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script type="text/javascript">
	function logoutpopup() {
		alert("Log Out!!");
	}

</script>
</head>
<body onload="return logoutpopup()">
	<b>로그아웃 되셨습니다. </b><br/>
	<a href="index.html">홈으로 가기</a>

</body>
</html>