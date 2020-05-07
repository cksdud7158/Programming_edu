package inheritance.service;

import inheritance.child.Enginner;
import inheritance.child.Manager;
import inheritance.child.Secretary;
import inheritance.parent.Employ;

/*
 * ��ɸ��� ��Ƴ��� ���� Ŭ����
 * VO ������ ���� ��� �޼��尡 ����Ͽ� �þ��. ���� �̸� ������ �ϰ� �ϱ����� ����� ����Ѵ�.
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
		//1. ���࿡ earr�� ����ִ� ������ ��ȣ���̶��...��ȣ���� �μ��� �ѹ��� �ٲٰ� ���� ���
		//2. instanceof - ���ϰ��� ���°� �������� ��� �ڽ� ��ü�� ���� ���� �����Ҷ� ���
		for(Employ e : earr) {
			if(e instanceof Manager) {// e ��� ��ü�� Manager���
				if(e.getName().equals("��ȣ��2")) {
					((Manager) e).changeDept("�ѹ���");
				}
			}
			if(e instanceof Enginner) {
				
			}
			if(e instanceof Secretary) {
				
			}
		}
	}
}
