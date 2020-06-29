$(function() {
	//1. p태그가 몇개인지 alert창으로 확인 
	//alert($('p').length);
	
	//2. 2번쨰 p태그를 firstP 라는 변수에 할당ㅇ
	var firstP= $('p:eq(1)');
	//alert(firstP.html()); // text()
	
	//3. a태그를 클릭하면
	$('a.more').click(function() {
		if(firstP.is(':hidden')){ //안보인다면
			firstP.slideToggle('slow');
			$(this).html('read less');
		}else{ //보인다면
			firstP.slideToggle('slow');
			$(this).html('read more');
		}
	}); // click
	
	var speech = $('div.speech');
	var defaultSize= speech.css('fontSize');
	//alert(defaultSize) // 19.2px -> 현재 폰트 사이즈
	
	var num = parseInt(defaultSize, 10); // 10단위로 적용해줌
	//alert(num); // 19
	
	$('#switcher>button').click(function() {
		switch(this.id){
			case 'switcher-Large':
				num +=5;
				break;
			case 'switcher-small':
				num -=5;
				break;
			default:
				num = parseInt(defaultSize, 10);
		}//switch
		
		//반드시 animate() 적용해줘야한다. 
		speech.animate({fontSize: num+'px'})
	})
	
}); //function







