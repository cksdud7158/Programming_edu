package com.encore.test;

import com.encore.service.EmployeeService;
import com.encore.util.MyDate;
import com.encore.vo.Manager;

public class EmployeeServiceTest {

	public static void main(String[] args) {
		//1. Service ��ü��  ���� 
		EmployeeService service = new EmployeeService(5);
		
		//method ���� ȣ��
		System.out.println("=============1. addManager===========");
		service.addManager(new Manager("�̼���", new MyDate(1978, 1, 1), 20000.0, "���ߺ�", 10));
		service.addManager(new Manager("��ȣ��", new MyDate(1975, 2, 1), 30000.0, "��ȹ��", 20));
		
		service.printManagers();
	}

}
