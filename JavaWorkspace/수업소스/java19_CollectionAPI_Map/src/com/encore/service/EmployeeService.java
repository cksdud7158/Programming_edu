package com.encore.service;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import com.encore.vo.Employee;
import com.encore.vo.Engineer;
import com.encore.vo.Manager;
// Manager[ ]�� ArrayList<Employee> ���
public class EmployeeService {
	
	//�߰�...
	private Map<Integer, Employee> map;
	
	//�̱���
	private static EmployeeService service = new EmployeeService();	
	private EmployeeService(){
		map = new HashMap<Integer, Employee>();
	}
	public static EmployeeService getInstance() {
		return service;
	}
	
	
	//�߰�
	public void getEmployee() {
		Set<Integer> set=map.keySet();
		Iterator<Integer> it=set.iterator();
		while(it.hasNext()) {
			Integer key = it.next();
			System.out.println(key+" : Employee  Info :: "+map.get(key));
		}
	}	
	public void addEmployee(Employee e) {	
		if(map.containsKey(e.getSsn())) {
			System.out.println(e.getName()+" ���� �̹� ȸ���̽ʴϴ�");
			return;
		}else {
			map.put(e.getSsn(), e);
			System.out.println(e.getName()+" ���� ȸ������ ���ԵǼ̽��ϴ�.");
		}
	}	
	public void deleteEmployee(int ssn) {	
		Object emp=map.remove(ssn);
		if(emp==null) {//������ ����� �������� �ʴ´�.
			System.out.println("������ ����� �������� �ʽ��ϴ�.");
			return;
		}else {
			System.out.println("�����Ǽ̽��ϴ�.");
		}			
	}	
	public void updateEmployee(Employee e, int ssn) {	
		if(map.containsKey(ssn)) {
			map.put(ssn, e);
			System.out.println(e.getName()+" ���� ������ �����Ǿ����ϴ�.");
		}else {
			System.out.println("������ ����� �������� �ʽ��ϴ�.");
			return;
		}
	}	
	public Employee findEmployee(int ssn) {		
		return map.get(ssn);
	}	
	
	public ArrayList<Employee> findEmployee(double sal) {
		ArrayList<Employee> temp = new ArrayList<>();
		Set<Integer> set=map.keySet();
		Iterator<Integer> it=set.iterator();
		while(it.hasNext()) {
			int key = it.next();
			Employee e = map.get(key);
			if(e.getSalary()==sal) temp.add(e);
		}
		return temp;
	}		
}







