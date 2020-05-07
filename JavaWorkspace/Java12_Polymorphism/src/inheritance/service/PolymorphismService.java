package inheritance.service;

import inheritance.child.Enginner;
import inheritance.child.Manager;
import inheritance.child.Secretary;
import inheritance.parent.Employ;

/*
 * 기능만을 모아놓은 서비스 클래스
 * VO 갯수에 따라 기능 메서드가 비례하여 늘어난다. 따라서 이를 간단히 하게 하기위해 상속을 사용한다.
 */
public class PolymorphismService {
	//1.
/*	public void handleManager(Manager m) {}
	public void handleEnginner(Enginner e) {}
	public void handleSecretary(Secretary s) {}*/
	//2.
	/*public void handleEmploy(Manager m) {}
	public void handleEmploy(Enginner e) {}
	public void handleEmploy(Secretary s) {}
	*/
	//3.
	public void handleEmpoly(Employ[] earr) {
		//1. 만약에 earr에 들어있는 직원이 강호동이라면...강호동의 부서를 총무로 바꾸고 정보 출력
		//2. instanceof - 리턴값의 형태가 여러개일 경우 자식 객체의 변수 값을 수정할때 사용
		for(Employ e : earr) {
			if(e instanceof Manager) {// e 라는 객체가 Manager라면
				if(e.getName().equals("강호동2")) {
					((Manager) e).changeDept("총무부");
				}
			}
			if(e instanceof Enginner) {
				
			}
			if(e instanceof Secretary) {
				
			}
		}
	}
}
