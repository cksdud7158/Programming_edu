<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>

</head>
<body>
	<h2 align="center">Fruit Total List 1.</h2>
	<table align="center">
	<tr>
	<c:forEach items="${list}" var="fruit">
		<td>
			<a href=itemView.do?itemNumber=${fruit.itemNumber}><img src=${fruit.url} width="150" height="200" border="1px solid black"></a><br/>
			상품명: ${fruit.name}<br/>
			가  격 :${fruit.price} 원
		</td>
	</c:forEach>
	</tr>
	</table>
	
	<!-- 오늘 본 상품 정보를 이곳에다가 출력  -->
	<c:if test="${!empty fruits}">
	<h2 align="center"><font color="purple">오늘 본 상품들</font></h2>
	<table align="center" bgcolor="lightgray">
		<tr>
			<c:forEach items="${fruits}" var="fruits">
			<td>
				<img src=${fruits} width="150" height="200" border="1px solid black">
			</td>	
			</c:forEach>
		</tr>
	</table>
	</c:if>
</body>
</html>