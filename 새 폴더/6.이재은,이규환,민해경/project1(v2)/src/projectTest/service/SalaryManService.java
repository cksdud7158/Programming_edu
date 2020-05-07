package projectTest.service;

import projectTest.vo.SalaryMan;

public interface SalaryManService {
	
	public void addSalaryMan(String name, int i);
	void deleteSalaryMan(int empNo);
	void updateSalaryMan(SalaryMan s);
	
	public void getSalaryMan(int empNo);
	public void searchHP();
	public void searchSalary();
	
	public void work(SalaryMan s);
	public void vacation(SalaryMan s);
	public void nightwork(SalaryMan s);
	
	public int calRandom();
}
