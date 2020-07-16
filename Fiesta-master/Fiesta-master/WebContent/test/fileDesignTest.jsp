<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<style>
		.filebox input[type="file"] { 
			position: absolute; 
			width: 1px; 
			height: 1px; 
			padding: 0; 
			margin: -1px; 
			overflow: hidden; 
			clip:rect(0,0,0,0); 
			border: 0; 
		} 
		.filebox label { 
			display: inline-block; 
			padding: .5em .75em; 
			color: #999; 
			font-size: inherit; 
			line-height: normal; 
			vertical-align: middle; 
			background-color: #fdfdfd; 
			cursor: pointer; 
			border: 1px solid #ebebeb; 
			border-bottom-color: #e2e2e2; 
			border-radius: .25em; 
		} /* named upload */ 
		.filebox .upload-name { 
			display: inline-block; 
			padding: .5em .75em; /* label의 패딩값과 일치 */ 
			font-size: inherit; 
			font-family: inherit; 
			line-height: normal; 
			vertical-align: middle; 
			background-color: #f5f5f5; 
			border: 1px solid #ebebeb; 
			border-bottom-color: #e2e2e2; 
			border-radius: .25em; 
			-webkit-appearance: none; /* 네이티브 외형 감추기 */ 
			-moz-appearance: none; 
			appearance: none; 
		}
	</style>
	<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
	<script>
		$(document).ready(function(){ 
			var fileTarget = $('.filebox .upload-hidden'); 
			fileTarget.on('change', function(){ 
				// 값이 변경되면 
				if(window.FileReader){ 
					// modern browser 
					var filename = $(this)[0].files[0].name; 
				} else { // old IE 
					var filename = $(this).val().split('/').pop().split('\\').pop(); // 파일명만 추출 
				} // 추출한 파일명 삽입 
				$(this).siblings('.upload-name').val(filename); 
			}); 
		});
	</script>
</head>
<body>
	<div class="filebox"> 
		<input class="upload-name" value="파일선택" disabled="disabled"> 
		<label for="ex_filename">업로드</label> 
		<input type="file" id="ex_filename" class="upload-hidden"> 
	</div>
</body>
</html>