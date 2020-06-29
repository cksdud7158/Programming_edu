<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!doctype html>
<html lang="en">
<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <title>jQuery UI Accordion - Default functionality</title>
  <link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/Dark-Hive/jquery-ui.css">
  <link rel="stylesheet" href="/resources/demos/style.css">
  <script src="https://code.jquery.com/jquery-1.12.4.js"></script>
  <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
  <!-- 부트 스트랩 라이브러리가 가장 나중에 나와야함   -->
  <script>
  $( function() {
    $( "#accordion" ).accordion({
    	// 컨텐트의 사이즈에 맞게 어코디언의 폭을 조절 
    	heightStyle: "content",
    	active: false, 
    	collapsible: true
    });
    
    //h3를 클릭하면 
    $('#accordion h3').click(function() {
		var text= $(this).text(); // html()
		//alert(text);
		//1. 비동기 통신 시작 
		if(text=="IT Education Subject"){
			$.ajax({
				type:'post',
				url:'front.do',
				data:'command=subject',
				
				success:function(data){
					$('#subject').html(data);
				} //callback
			})//ajax
		}else if(text=="Association company"){
			$.ajax({
				type:'post',
				url:'front.do',
				data:'command=company',
				
				success:function(data){
					$('#itom').html(data);
				} //callback
				
			})//ajax
		} //else if
	});//click
	
	$('#creatSection').click(function() {
		var footercontent= "<h3>Addiction</h3><div>서울 서초동 549</div>";
		
		$('#accordion').append(footercontent).accordion('destroy').accordion({
			heightStyle: "content",
	    	active: false, 
	    	collapsible: true
		});
		$(this).remove();
	})//click
  }); // ready
  </script>
</head>
<body>
 
<div id="accordion">
  <h3>Encore Academy Introduction</h3>
  <div>
	㈜엔코아는 데이터 중심 시대를 맞아 기업의 핵심 가치로 더욱 주목받고 있는 데이터의 설계에서부터 구축, 운영, 이행, 거버넌스, 성능개선, 가공, 정제, 분석에 이르기까지 데이터 산업 전 분야에 걸쳐 100여명의 전문가를 보유하고 있는 데이터 전문가 그룹입니다.

1997년 창업 이래 한국, 중국, 일본의 공공, 금융, 통신, 제조, 물류, 유통, 서비스 등 다양한 산업군의 700여 프로젝트 경험을 기반으로 데이터 전문 컨설팅, 솔루션, 출판, 교육, 포털(dator.co.kr) 서비스를 제공하고 있습니다. 특히, 빅데이터에 대한 시장의 요구사항 확대로 소셜, 공공 오픈 데이터 및 기업 내·외부 데이터의 수집-정제-가공을 통한 분석 컨설팅과 데이터 유통 및 데이터 플랫폼 서비스까지 사업 영역을 확장하였습니다.

또한, 2012년 1월 중국 북경 법인을 설립하며 차이나 모바일, 해관(관세청), 수발(도로공사) 등 중국 내 로컬 기관 및 기업의 데이터 컨설팅 사업을 수주하며 아시아 최대 종합 데이터 서비스 기업 (Total Data Service Provider)으로 도약하고 있습니다.
  </div>
  <h3>IT Education Subject</h3>
  <div id="subject">

  </div>
  <h3>Association company</h3>
  <div id="itom">
	
  </div>
</div>


<hr>

<input type="button" value="Create Section Addiction" id="creatSection">
</body>
</html>