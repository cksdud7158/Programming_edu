package projectTest.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import projectTest.vo.Major;
import projectTest.vo.SalaryMan;
import projectTest.vo.Small;

public class SalaryManServiceImpl implements SalaryManService {
	ArrayList<SalaryMan> sms = null;
	
	private SalaryManServiceImpl() {
		sms = new ArrayList<>();
	}
	private static SalaryManServiceImpl mgr = new SalaryManServiceImpl(); 
	public static SalaryManServiceImpl getInstance() {
		return mgr;
	}
	
	public int getSize() {
		return sms.size();
	}
	
	public void getInfo() {
		for(SalaryMan sm : sms) {
			System.out.println(sm);
		}
	}
	
	public ArrayList<SalaryMan> getList(){
		return sms;
	}
	
	public void workAfterInfo(SalaryMan s) {
		System.out.printf("%s %s의 현재 상태\r-현재 체력: %d\r-현재 계좌 잔액: %d\r",
				s.getCompany(), s.getName(), s.getHp(), s.getAccount());
	}
	
	
	public void addSalaryMan(String name, int i) {
		for(SalaryMan sm : sms) {
			if(sm.getName().equals(name)) {
				System.out.println("이미 등록된 사원입니다.");
				return;
			}
		}
		switch(i) {
		case 1: 
			sms.add(new Major(sms.size()+1, name)); 
			System.out.println(name+"님이 등록되었습니다.");
			break;
		case 2:
			sms.add(new Small(sms.size()+1, name));
			System.out.println(name+"님이 등록되었습니다.");
			break;
			}
	}
	
	public void workInfo() {
		System.out.println("어떤 회사원을 선택하시겠습니까? 번호를 선택해주세요.");
		for(int i = 1; i <= sms.size(); i++) {
			System.out.printf("(%d): %s %s\r", i, sms.get(i-1).getCompany(), sms.get(i-1).getName());
		}
	}

	public void work(SalaryMan s) {
		int realSalary = 0;
		if(isFinished(s) == false) {
			System.out.printf("%s %s은(는) 정시 퇴근을 목표로 일합니다.", s.getCompany(), s.getName());
			for(int i = 0; i < 3; i++) {
				try{
					Thread.sleep(1000);
				} catch(InterruptedException e) {}
				System.out.print(".");
			}
			System.out.println();
			if(s instanceof Major) {
				((Major) s).setTax(calRandom());
				s.setHp(s.getHp()-10);
				realSalary = s.getSalary() - ((Major) s).getTax(); //deposit 삭제
				s.setAccount(s.getAccount() + realSalary);
				System.out.printf("%s %s의 이번달 월급은 세금 %d만원을 제외한 %d만원입니다.", s.getCompany(), s.getName(), ((Major) s).getTax(), realSalary);
			}
			else if(s instanceof Small){
				((Small) s).setSubsidy(calRandom());
				s.setHp(s.getHp()-10);
				realSalary = s.getSalary() + ((Small) s).getSubsidy();
				s.setAccount(s.getAccount() + realSalary);
				System.out.printf("%s %s의 이번달 월급은 지원금 %d만원을 포함한 %d만원입니다.", s.getCompany(), s.getName(), ((Small) s).getSubsidy(), realSalary);
			}
			System.out.println();
			s.setTurn(true);
			workAfterInfo(s);
			System.out.println();
			try {
				Thread.sleep(1500);
			} catch(InterruptedException e) {}
		}
		else System.out.println(s.getName()+"님은 이미 업무/휴가/협상을 진행하였습니다.");
	}
	
	public void nightwork(SalaryMan s) {
		int realSalary = 0;
		if(isFinished(s) == false) {
			System.out.printf("%s %s은(는) 잔업수당을 위해 매일 야근합니다.", s.getCompany(), s.getName());
			for(int i = 0; i < 3; i++) {
				try{
					Thread.sleep(1000);
				} catch(InterruptedException e) {}
				System.out.print(".");
			}
			System.out.println();
			if(s instanceof Major) {
				((Major) s).setTax(calRandom());
				s.setHp(s.getHp()-20);
				realSalary = (s.getSalary()*2) - ((Major) s).getTax();
				s.setAccount(s.getAccount() + realSalary);
				System.out.printf("%s %s의 이번달 월급은 세금 %d만원을 제외한 %d만원입니다.", s.getCompany(), s.getName(), ((Major) s).getTax(), realSalary);
			}
			else if(s instanceof Small){
				((Small) s).setSubsidy(calRandom());
				s.setHp(s.getHp()-20);
				realSalary = (s.getSalary()*2) + ((Small) s).getSubsidy();
				s.setAccount(s.getAccount() + realSalary);
				System.out.printf("%s %s의 이번달 월급은 지원금 %d만원을 포함한 %d만원입니다.", s.getCompany(), s.getName(), ((Small) s).getSubsidy(), realSalary);
			}
			System.out.println();
			s.setTurn(true);
			workAfterInfo(s);
			System.out.println();
			try {
				Thread.sleep(1500);
			} catch(InterruptedException e) {}
		}
		else System.out.println(s.getName()+"님은 이미 업무/휴가/협상을 진행하였습니다.");
	}

	public void vacation(SalaryMan s) {
		int vctCost = 0;
		if(isFinished(s) == false) {
			System.out.printf("%s %s은(는) 휴가를 떠났습니다!", s.getCompany(), s.getName());
			for(int i = 0; i < 3; i++) {
				try{
					Thread.sleep(1000);
				} catch(InterruptedException e) {}
				System.out.print("!");
			}
			System.out.println();
			if(s instanceof Major) {
				vctCost = calRandom()*2;
				s.setHp(s.getHp()+40);
				s.setAccount(s.getAccount() - vctCost);
				System.out.printf("%s %s의 이번달 휴가비용은 %d만원입니다.", s.getCompany(), s.getName(), vctCost);
			}
			else if(s instanceof Small){
				vctCost = calRandom()*2;
				s.setHp(s.getHp()+40);
				s.setAccount(s.getAccount() + calRandom()*2);
				System.out.printf("%s %s의 이번달 휴가비용은 %d만원입니다.", s.getCompany(), s.getName(), vctCost);
			}
			System.out.println();
			s.setTurn(true);
			workAfterInfo(s);
			System.out.println();
			try {
				Thread.sleep(1500);
			} catch(InterruptedException e) {}
		}
		else System.out.println(s.getName()+"님은 이미 업무/휴가/협상을 진행하였습니다.");
	}
	
	public void getSalaryMan(int empNo) { //필드명 변경(ssn -> empNo)
		SalaryMan s = null;
		if(empNo>=sms.size()||empNo<=sms.size()){
			 s=sms.get(empNo-1);
			 System.out.println(s);
		}else{
			System.out.println("검색 결과가 없습니다.");
		}
	}
	
	@Override //HP로 회사원 검색
	public void searchHP() {
		ArrayList<SalaryMan> ArrayHp = new ArrayList<SalaryMan>();
		for(SalaryMan s : sms) {
			ArrayHp.add(s);
		}
		Collections.sort(ArrayHp, new HpComparator());	
		for(SalaryMan s : ArrayHp){
			System.out.println("성명 : "+s.getName()+"  HP : "+s.getHp());
		}
		System.out.println("가장 위험한 사람! : " + ArrayHp.get(0).getName());
	}
	
	@Override //월급으로 회사원 검색
	public void searchSalary() {
		ArrayList<SalaryMan> ArraySal = new ArrayList<SalaryMan>();
		for(SalaryMan s : sms) {
			ArraySal.add(s);
		}
		Collections.sort(ArraySal, new SalComparator());
		for(SalaryMan s : ArraySal){
			System.out.println("성명 : "+s.getName()+"  월급여 : "+s.getSalary()+" 계좌총액 : "+s.getAccount());
		}
		System.out.println(" " + ArraySal.get(0).getName()+"님이  승리에 제일 가깝습니다.\n");
	}

	@Override //월급협상
	public void updateSalaryMan(SalaryMan s) {
		// TODO Auto-generated method stub
		for(SalaryMan emp : sms) {
			if(emp.getEmpNo() == s.getEmpNo()) {
				if(isFinished(emp) == false) {
					s.setSalary(calRandom() +  s.getSalary());
					System.out.println(emp.getName()+"님의 월급여가 "+emp.getSalary()+"로 변경되었습니다.\n");
					s.setTurn(true);// 월급 변경된 회사원 턴 종료로 변경// 급여 변경된 사람만 화면에 출력
				
				} else {
					System.out.println(emp.getName()+"님은 이미 업무/휴가/협상을 진행하였습니다.\n");
				}
			}
		}
	}
	
	@Override //회사원 제거하기
	public void deleteSalaryMan(int empNo) {
		SalaryMan s = null;
		
		for(SalaryMan sm : sms) {
			if(sm.getEmpNo() == empNo) s = sm;
		}
		if(sms.contains(s)) {
			System.out.printf("사원번호 %d번 회사원인 %s를 삭제하였습니다.\n\n", s.getEmpNo(), s.getName());
			sms.remove(s);
		}
		else System.out.println(empNo+"은 존재하지 않는 번호입니다.\n");
		
		for(int index=0; index<sms.size(); index++){
			sms.get(index).setEmpNo(index+1);
		}
		
	}
	
	public int calRandom() {
		return (int)(Math.random()*100) + 1;
	}

	//check whole turn
	public boolean isFinished(ArrayList<SalaryMan> s) {
		boolean rt = false;
		int p = 0;
		
		for(SalaryMan sm : s) {
			if(sm.isTurn()) p+=1;
		}
		if (p==s.size()) rt = true;
		return rt;
	}
	
	//check personal turn 
	public boolean isFinished(SalaryMan s) {
		return s.isTurn();
	}
	
	//cheange f to t
	public void setFalse(ArrayList<SalaryMan>s) {
		for(SalaryMan sm: s) sm.setTurn(false);
	}
	
	//return people who have over 100000000
	public ArrayList<SalaryMan> getVic(ArrayList<SalaryMan>s){
		ArrayList<SalaryMan> sms = new ArrayList<SalaryMan>();
		for(SalaryMan sm: s) {
			if(sm.getAccount()>=10000) sms.add(sm);	
		}
		return sms;
	}
	
	//return people who are sick
		public ArrayList<SalaryMan> getSick(ArrayList<SalaryMan>s){
			ArrayList<SalaryMan> sms = new ArrayList<SalaryMan>();
			for(SalaryMan sm: s) {
				if(sm.getHp()<=0) sms.add(sm);	
			}
			return sms;
			}
}

//HP 값을 오름차순으로 정렬(ASC)
class HpComparator implements Comparator<Object> {
			
	@Override
		public int compare(Object o1, Object o2) {
		int hp1 = ((SalaryMan) o1).getHp();
		int hp2 = ((SalaryMan) o2).getHp();
		if(hp1 > hp2){
		    return 1;
		 }else if(hp1 < hp2){
		    return -1;
		 }else{
		    return 0;
		 }
	}
}
		
//account 값을 내림차순으로 정렬(DESC)
class SalComparator implements Comparator<Object> {

	@Override
		public int compare(Object o1, Object o2) {
		int account1 = ((SalaryMan) o1).getAccount();
		int account2 = ((SalaryMan) o2).getAccount();
		if(account1 < account2){
		    return 1;
		 }else if(account1 > account2){
		    return -1;
		 }else{
		    return 0;
		 }
	}
}
