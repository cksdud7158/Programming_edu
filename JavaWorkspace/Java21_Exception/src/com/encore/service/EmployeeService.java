package com.encore.service;
import java.util.ArrayList;

import com.encore.vo.Employee;
import com.encore.vo.Engineer;
import com.encore.vo.Manager;
// Manager[] �� ArrartList<���ʸ�> ���
//�̱��� �߰�
public class EmployeeService {
	
	private ArrayList<Employee> list;
	//�̱���
	private static EmployeeService service = new EmployeeService();
	
	private EmployeeService(){
		list =new ArrayList<>();
	}
	
	public static EmployeeService getInstance() {
		return service;
	}//������� �̱���
	
	public void addEmployee(Employee e) {	//DuplicateNameException �߻�
		boolean find = false;
		for(Employee emp : list) {
			if(e.getName().equals(emp.getName())) { // e.getName() = �Էµ� �̸� emp.getName() = ���� list�� �ִ� �̸�
				find = true;
				System.out.println(e.getName()+"���� �̹� ȸ���̽ʴϴ�.");
				return;
			}
		}
		if(find==false) { //���� ������ ����.
			list.add(e);
			System.out.println(e.getName()+"���� ȸ������ ��ϵǼ̽��ϴ�.");
		}
	}
	
	public void deleteEmployee(String name) { //RecordNotFoundException �߻�
		boolean find = false;
		for(Employee e : list) {
			if(e.getName().equals(name)) {
				find =true;
				System.out.println(e.getName()+"���� �����մϴ�."); //�����ϸ� e.getName()�� �� ã��
				list.remove(e);
				break;
			}
		}
		if(find ==false) System.out.println("������ ����� ���������ʽ��ϴ�.");
	}
	
	public void updateEmployee(Employee e) {	 //RecordNotFoundException
		for(Employee emp : list) {
			if(e.getName()==emp.getName()) {
				emp.setName(e.getName());	
				emp.setBirthDate(e.getBirthDate());
				emp.setSalary(e.getSalary());
				if(emp instanceof Manager) {
					((Manager) emp).setDept(((Manager) e).getDept());
					((Manager) emp).setDeptno(((Manager) e).getDeptno());				
				}
				if(emp instanceof Engineer) {
					((Engineer) emp).setTech(((Engineer) e).getTech());
					((Engineer) emp).setBonus(((Engineer) e).getBonus());				
				}
			}
		}
	}	

	public ArrayList<Employee> findEmployee(double sal) {
		ArrayList<Employee> temp = new ArrayList<>();
		for(Employee e : list) {
			if(e.getSalary()==sal) {
				temp.add(e);
			}
		}
		return temp;
	}	
	
	//�߰�
	public void getEmployee() {
		for(Employee e :list) System.out.println(e);
			
	}
	
}







