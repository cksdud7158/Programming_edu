package project1.service;

import java.util.ArrayList;
import project1.vo.SalaryMan;

public interface SalaryManService {
	
	public void work(SalaryMan s);
	public void vacation(SalaryMan s);
	public void nightwork(SalaryMan s);
	public void addSalaryMan(SalaryMan s);
	public void updateSalaryMan(int ssn, String position);
	public void deleteSalaryMan(int ssn);
	public SalaryMan getSalaryMan(int ssn);
	public ArrayList<SalaryMan> searchHP(int hp);
	public ArrayList<SalaryMan> searchSalary(int salary);
	public int calRandom();
	
}
