<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	var xhr;
	var uid;
	function startRequest() { // 요청관련된 로직
		uid = document.getElementById("list").value;
		xhr= new XMLHttpRequest();
	
		xhr.onreadystatechange = callback;
		xhr.open("get","find.do?id="+uid);
		xhr.send(null);
	}
	
	function callback() { // 응답 관련된 로직이 담긴다. 서버에서 응담이 돌아오는곳
		if(xhr.readyState==4){
			if(xhr.status==200){ 
				document.getElementById("memberIDView").innerHTML =
					"<font color= green size=4>"+xhr.responseText+"</font>";
					
				document.frm.userid.value="";
				document.frm.userid.focus();
			}
		}else{ 
			document.getElementById("memberIDView").innerHTML =
				"실패"
				
		}
	}

</script>
</head>
<body>
	<h2 align="center">ID LIST INFORMATION</h2>
	<p>List에서 특정 아이디를 선택해주세요</p>
	
	<select id="list" onchange="startRequest()">
	<c:forEach items="${list}" var="id">
		<option>${id.id}</option>
	</c:forEach>
			
	</select>
	
	<span id="memberIDView"></span>
</body>
</html>