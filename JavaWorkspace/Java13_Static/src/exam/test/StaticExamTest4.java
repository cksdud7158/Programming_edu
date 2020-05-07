package exam.test;
/*
 * final 키워드 는 대부분 static 키워드와 같이 쓰임 
 * final 키워드 :: 내가 마지막이야 이란 뜻을 가짐
 * fianl + 변수 : 상수를 의미 
 * final + 클래스 : 상속금지
 * final + 메소드 : 오버라이딩 금지
 */
// 정확히는 public을 붙여야함 상수로 선언하여 공통적으로 사용이 가능하게 하기위해서임
class A{
	public final static int BASE_SALARY =300;
	public final String test() {
		return "Overriding 금지";
	}
}

final class B{// 상속 금지
}
// class C extends B {} ->상속이 안되는 에러 확인

class D extends A{
	/*public final String test() {
		return "Overriding 금지";
	}*/ // 수정이 불가한 것을 수정하려고 부모클래스의 것을 썼기에 막아둠 
}


public class StaticExamTest4 {	
	
}
