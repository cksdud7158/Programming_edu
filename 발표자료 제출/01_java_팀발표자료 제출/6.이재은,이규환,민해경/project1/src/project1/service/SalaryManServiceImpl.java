package project1.service;

import java.util.ArrayList;

import project1.vo.Major;
import project1.vo.SalaryMan;
import project1.vo.Small;

public class SalaryManServiceImpl implements SalaryManService {
	ArrayList<SalaryMan> sms = null; 
	
	private static SalaryManServiceImpl service = new SalaryManServiceImpl();
	private SalaryManServiceImpl() {//최대 10명만 추가 가능
		sms = new ArrayList<>();
	}
	public static SalaryManServiceImpl getInstance() {
		return service;
	}
	
	public void getInfo() {
		for(SalaryMan sm : sms) {
			System.out.println(sm);
		}
	}
	
	@Override
	public void work(SalaryMan s) {
		for(SalaryMan sm : sms) {
			if(sm.getSsn() == s.getSsn()) {
				s.setHP(s.getHP() - 10); 
				
				if(s instanceof Major) {
					int majorSalary = s.getSalary() - calRandom();
					s.setAccount(majorSalary);
					System.out.println("대기업 사원인 " + s.getName() + "님의 이번 달 월급은  " + majorSalary + "입니다.");
				} else {
					int smallSalary = s.getSalary() + calRandom();
					s.setAccount(smallSalary);
					System.out.println("중소기업 사원인 " + s.getName() + "님의 이번 달 월급은  " + smallSalary + "입니다.");
				}
			}
		}
		getInfo();
	}
	
	
	public void getNames() {lkkkk'/;i;lliii
		for(int i = 0; i < sms.size(); i++) {
			int number = i + 1;
			System.out.println(number + "번: " + sms.get(i).getName());
		}
	}

	@Override
	public void vacation(SalaryMan s) {
		// TODO Auto-generated method stub
		for(SalaryMan sm : sms) {
			if(sm.getName().equals(s.getName())){
				int Hp = s.getHP()+10;
				sm.setHP(s.getHP()+10);
				
				if(sm instanceof Major) {
					int salary = (((Major) s).getSalary() - ((Major) s).getTax());
					((Major) sm).setAccount(salary);
			}
				if(sm instanceof Small) {
					int salary = ((Small) s).getSalary()-((Small) s).getSubsidy();
					((Small) sm).setAccount(salary);
				}
			}
		}
	}

	@Override
	public void nightwork(SalaryMan s) {
		int minusHP = 30;
		int plusSalary = calRandom() + 50;
		
		if(sms.contains(s)) {
			for(SalaryMan sm : sms) {
				if(sm.getSsn() == s.getSsn()) {
					sm.setHP(s.getHP()-minusHP);
					sm.setSalary(s.getSalary()+plusSalary);
				}
			}
			System.out.println(s.getName()+"님의 체력이"+minusHP+"하락하고, 월급이 "+plusSalary+"원 상승하였습니다.");
			}
		else System.out.println(s.getName()+"님은 존재하지 않습니다.");
	}


	@Override
	public void addSalaryMan(SalaryMan s) {//this.one
		sms.add(s);
	}

	@Override
	public void updateSalaryMan(int ssn, String position) {
		// TODO Auto-generated method stub
		for(SalaryMan emp : sms) {
			if(emp.getSsn()==ssn){
				emp.setPosition(position);
			}
		}	
	}

	@Override
	public void deleteSalaryMan(int ssn) {
		SalaryMan s = null;
		
		for(SalaryMan sm : sms) {
			if(sm.getSsn() == ssn) s = sm;
		}
		if(sms.contains(s)) sms.remove(s);
		else System.out.println(ssn+"은 존재하지 않는 번호입니다.");
	}

	@Override
	public SalaryMan getSalaryMan(int ssn) {
		SalaryMan sm = null;
		for(SalaryMan s : sms) {
			if(s.getSsn()==ssn) {
				sm = s; 
			}
		}
		return sm;
	}

	@Override
	public ArrayList<SalaryMan> searchHP(int hp) {
		// TODO Auto-generated method stub
		ArrayList<SalaryMan> ArrayHp = null;
		for(SalaryMan sm : sms) {
			if(sm.getHP()<=hp){
				ArrayHp.add(sm);
			}
		}	
		
		return ArrayHp;
	}

	@Override
	public ArrayList<SalaryMan> searchSalary(int salary) {
		ArrayList<SalaryMan> s = new ArrayList<>();
		
		for(SalaryMan sm : sms) {
			if(sm.getSalary() == salary) s.add(sm);
		}
		
		return s;
	}

	@Override
	public int calRandom() {
		int rd = (int) (Math.random()*10);
		return rd;
	}

}
