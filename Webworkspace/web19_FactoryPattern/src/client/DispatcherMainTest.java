package client;

import pattern.action.Action;
import pattern.factory.ActionFactory;

/*
 * Factory Method Pattern
 * 
 * 추상화된 클래스(Action)의 객체 (구상객체, 실체 클래스)를 생성하고 반환받는 방법
 * 
 * 1)
 * 구상객체를 실질적으로 생성하는 곳은 싱글톤 패턴으로 작성된 Factory 에서 진행된다.
 * 이때 인자값으로 넘겨져오는 command 값에 따라서 서로 다른 구상 객체가 만들어진다. 
 * 하지만 정작 사용자(Server side에서의 Client)에게는 구상객체명이 hiding 되어서 넘겨진다. 
 * -> 추상화된 클래스(Action)로 날아간다. 
 * 
 *  --> 결국 클라이언트는 Factory로 하여금 구상 객체를 만들도록 요청하는 것
 * 		Factory는 요청에 해당하는 제품을 만들고 인터페이스로 전달한다. 
 * 	2)  인터페이스의 메소드를 호출하면 실질적으로 생선된 구상 객체가 드디어 핵심적일 일(비즈니스 로직 호출)을 진행
 * 		최종적으로 뷰의 화면 경로를 리턴 받는다. 
 * 
 * --> forward or sendRedirect로 응답 
 */
public class DispatcherMainTest {

	public static void main(String[] args) {
		String command = "INSERT";
		
		//1.
		ActionFactory factory= ActionFactory.getInstance();
		//2.
		Action action = factory.createAction(command);
		//3.
		action.excute();
		

	}

}
