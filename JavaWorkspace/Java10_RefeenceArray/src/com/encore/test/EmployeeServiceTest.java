package com.encore.test;

import com.encore.service.EmployeeService;
import com.encore.util.MyDate;
import com.encore.vo.Manager;

public class EmployeeServiceTest {

	public static void main(String[] args) {
		//1. Service 객체를  생성 
		EmployeeService service = new EmployeeService(5);
		
		//method 각각 호출
		System.out.println("=============1. addManager===========");
		service.addManager(new Manager("이수근", new MyDate(1978, 1, 1), 20000.0, "개발부", 10));
		service.addManager(new Manager("강호동", new MyDate(1975, 2, 1), 30000.0, "기획부", 20));
		
		service.printManagers();
	}

}
