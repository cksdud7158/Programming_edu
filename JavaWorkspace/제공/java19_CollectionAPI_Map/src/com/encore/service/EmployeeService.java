package com.encore.service;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

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
		
	}	
	public void addEmployee(Employee e) {	
		
	}	
	public void deleteEmployee(int ssn) {	
		
	}	
	public void updateEmployee(Employee e, int ssn) {	
		
	}	
	public Employee findEmployee(int ssn) {
		
		return null;
	}	
	
	public ArrayList<Employee> findEmployee(double sal) {
		
		return null;
	}	
	
}







