<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script type="text/javascript">
$(function() {
	$('[name=cartinsert]').click(function() {
		localStorage.setItem($(this).attr('id'), $(this).val());
		alert("장바구니에 담겨졌습니다");
	});
});

</script>
</head>
<body>
	<h1 align="center">${item.name} 의 정보</h1>
	<table align="center" width="600">
		<tr>
			<td align="right"> 조회수 : ${item.count} &nbsp; &nbsp; &nbsp;
				<button name="cartinsert" id="${item.itemNumber}" value="${item.url}, ${item.name}, ${item.price}">장바구니 담기</button>
				>&nbsp; &nbsp;<a href="cartList.jsp">장바구니 보기 </a>
			</td>
		</tr>
	</table>
	<table align="center" width="600">
		<tr>
			<td rowsapn="3"><img src=${item.url}></td><td>종  류: ${item.name}</td>
		</tr>
		<tr>
			<td>가  격 :${item.price} 원</td>
		</tr>
		<tr>
			<td>설  명 : ${item.description}</td>
		</tr>
		<tr>
			<td colspan="2" ><a href="itemList.do" align="left">상품 목록 보기 </a></td>
		</tr>
	</table>
</body>
</html>