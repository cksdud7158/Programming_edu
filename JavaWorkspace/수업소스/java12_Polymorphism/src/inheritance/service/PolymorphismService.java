package inheritance.service;

import inheritance.child.Engineer;
import inheritance.child.Manager;
import inheritance.child.Secretary;
import inheritance.parent.Employee;

//��ɸ��� ��Ƴ��� ���� Ŭ����...
public class PolymorphismService {
	//1. step	
	/*public void handleManager(Manager m) {}
	public void manageEngineer(Engineer eg) {}
	public void getSecretary(Secretary se) {}*/
	
	//2. step	
	/*public void handleEmployee(Manager m) {}
	public void handleEmployee(Engineer eg) {}
	public void handleEmployee(Secretary se) {}*/
	
	//3. step
	public void handleEmployee(Employee[ ] earr) {
		for(Employee e : earr) {
			if(e instanceof Manager) {//e��� ��ü�� Manager���
				if(e.getName().equals("��ȣ��2")) ((Manager) e).changeDept("�ѹ���");						
			}
			if(e instanceof Engineer) {//e��� ��ü�� Engineer���
				
			}
			if(e instanceof Secretary) {//e��� ��ü�� Secretary���
				
			}
		}		
	}
}











