<%@page import="servlet.model.BookVO"%>
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
	<h2> 도서 목록 출력</h2>
	<%
		ArrayList<BookVO> list = (ArrayList<BookVO>)request.getAttribute("list");
		for(int i=0; i<list.size();i++){
	%>
	isbn : <%= list.get(i).getIsbn() %><p>
	Title : <%= list.get(i).getTitle() %><p>
	Catalogue : <%= list.get(i).getCatalogue() %><p>
	Author : <%= list.get(i).getAuthor() %><p>
	<hr>
	
	<%
	} 
	%>
	<a href="registerBook.html">도서 등록</a>

</body>
</html>