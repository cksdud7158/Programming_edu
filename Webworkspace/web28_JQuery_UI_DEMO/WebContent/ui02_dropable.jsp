<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!doctype html>
<html lang="en">
<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <title>jQuery UI Droppable - Default functionality</title>
  <link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/Dark-Hive/jquery-ui.css">
  <link rel="stylesheet" href="/resources/demos/style.css">
  <style>
 		
 		
 		
  </style>
  <script src="https://code.jquery.com/jquery-1.12.4.js"></script>
  <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
  <script>
  $( function() {
	  $( "#catalog" ).accordion({
	    	// 컨텐트의 사이즈에 맞게 어코디언의 폭을 조절 
	    	heightStyle: "content",
	    	active: false, 
	    	collapsible: true
	    });
	  // draggble 사용
	  $( "#catalog li" ).draggable({
		  helper: "clone",
		  appendTo:'#cart'
	  }); //draggable
	  
	  $( "#cart ol" ).droppable({
	      drop: function( event, ui ) {
	       	$(this).find('.placeholder').remove();
	       	var uidrag= ui.draggable.text();
	       	
	       	$(this).append('<li>'+uidrag+'<li>')
	      }
	    }); //droppable
  })//ready
 
  </script>
</head>
<body>
 	
	<div id ="clothing">
		<h2>카 달 로 그 </h2>
		<!-- 드래그 하는 대상들 -->
		<div id="catalog">
			<h2 class="ui-widget-header"><a href='#'>상의류</a></h2>
			<div>
			<ul>
				<li>블라우스</li>
				<li>셔츠</li>
				<li>반팔티</li>
				<li>가디건</li>
			</ul>
			</div>
			
			<h2><a href='#'>하의류</a></h2>
			<div>
			<ul>
				<li>반바지</li>
				<li>긴바지</li>
				<li>카고바지</li>
				<li>청바지</li>
			</ul>
			</div>
			
			<h2><a href='#'>액세서리</a></h2>
			<div>
			<ul>
				<li>렌즈</li>
				<li>안경</li>
				<li>귀걸이</li>
				<li>목걸이</li>
			</ul>
			</div>
			
			<h2><a href='#'>신발</a></h2>
			<div>
			<ul>
				<li>1</li>
				<li>22츠</li>
				<li>3</li>
				<li>4</li>
			</ul>
			</div>
		</div>	
	</div>
	
	<div id="cart" class="ui-widget-content">
		<h2 class="ui-widget-header">Clothing Cart</h2>
		<div>
			<ol>
				<li class="placeholder">Dropping Here</li>
			</ol>
		</div>
	
	</div>
 
</body>
</html>