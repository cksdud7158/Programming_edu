<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2> vo정보를 출력</h2>
	<%-- ID: ${vo.id}
	pass: ${vo.password}
	name: ${vo.name}
	addr: ${vo.addr} --%>
	<hr>
	VO1_ID : ${list[0].id}
	<hr>
	VO2_ID : ${list[1].id}
	

</body>
</html>