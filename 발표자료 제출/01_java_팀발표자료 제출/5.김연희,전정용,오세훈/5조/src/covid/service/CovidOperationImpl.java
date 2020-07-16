package covid.service;

import java.util.ArrayList;

import covid.util.Fever;
import covid.vo.parent.Visitor;

public class CovidOperationImpl implements CovidOperation {
	ArrayList<Visitor> visitors = new ArrayList<>();
	
	private int index = 0;
	
	@Override
	public boolean checkVisitor(String name) {
		for(int i = 0; i<index; i++) {
			if(visitors.get(i).getName().equals(name)) {
				System.out.println("\n		System Message");
				System.out.println("*********************************************");
				System.out.println(name + "님은 이미 방문자 명단에 존재합니다.");
				System.out.println("*********************************************\n");
				return true;
			}
		}
		return false;
	}

	@Override
	public void addVisitor(Visitor v) {	
		System.out.println("\n		System Message");
		System.out.println("*********************************************");
		visitors.add(v);
		System.out.println(v.getName() +"님이 회원으로 추가되었습니다. ");
		index++;
		System.out.println("*********************************************\n");
	}

	@Override
	public ArrayList<Visitor> getAllVisitors() {
		return visitors;
	}

	@Override
	public void deleteVistor(String name) {
		int i;
		System.out.println("\n		System Message");
		System.out.println("*********************************************");
		for(i = 0; i<index; i++) {
			if(visitors.get(i).getName().equals(name)) {
				System.out.println(visitors.get(i).getName() + "님이 제거되었습니다.");
				for(int j = i; j<index-1; j++) {
					visitors.set(j, visitors.get(j+1));
				}
				index--;
				break;
			}
		}
		if(i == index) {
			System.out.println(name + "님은 존재하지 않습니다.");
		}
		System.out.println("*********************************************\n");
	}

	@Override
	public void checkMask(String name) {
		boolean maskCheck = false;
		boolean nameCheck = false;
		System.out.println("\n		System Message");
		System.out.println("*********************************************");
		for(int i = 0; i<index; i++) {
			if(visitors.get(i).getName().equals(name)){
				nameCheck = true;
				if(visitors.get(i).isMask()) {
					System.out.println(name + "님은 마스크를 착용하고 계십니다. ");
					maskCheck = true;
					break;
				}
				else
					continue;
			}
		}
		if(nameCheck) {
			if(!maskCheck) 
				System.out.println(name + "님은 마스크를 착용하고 계시지 않습니다.");
		}
		else 
			System.out.println(name + "님은 방문자 명단에 존재하지 않습니다.");
		System.out.println("*********************************************\n");
	}

	@Override
	public void overTemperature(double temperature)  {
		System.out.println("\n		System Message");
		System.out.println("*********************************************");
		for(int i = 0; i<index; i++) {
			if(visitors.get(i).getFever().getTemperature1() >= temperature) {
				System.out.println(visitors.get(i).getName() + "님은 격리 대상입니다.");
			}
			else {
				if(visitors.get(i).getFever().getTemperature2() >= temperature) {
					System.out.println(visitors.get(i).getName() + "님은 격리 대상입니다.");
				}
				else {
					System.out.println(visitors.get(i).getName() + "님은 격리 대상이 아닙니다.");
				}
			}
		}
		System.out.println("*********************************************\n");
	}

	@Override
	public void updateCondition(String name, Fever fever) {
		int i;
		System.out.println("\n		System Message");
		System.out.println("*********************************************");
		for(i = 0; i<index; i++) {
			if(visitors.get(i).getName().equals(name)) {
				System.out.println(visitors.get(i).getName() + "님의 변경전 오전 온도 : " + visitors.get(i).getFever().getTemperature1());
				System.out.println(visitors.get(i).getName() + "님의 변경전 오후 온도 : " + visitors.get(i).getFever().getTemperature2());
				
				visitors.get(i).setFever(fever);
				
				System.out.println(visitors.get(i).getName() + "님의 변경후 오전 온도 : " + visitors.get(i).getFever().getTemperature1());
				System.out.println(visitors.get(i).getName() + "님의 변경후 오후 온도 : " + visitors.get(i).getFever().getTemperature2());	
				
				break;
			}
		}
		if(i == index) {
			System.out.println(name + "님은 존재하지 않습니다.");
		}
		System.out.println("*********************************************\n");
	}

	@Override
	public void updateCondition(String name, String symptom) {
		int i;
		System.out.println("\n		System Message");
		System.out.println("*********************************************");
		for(i = 0; i<index; i++) {
			if(visitors.get(i).getName().equals(name)) {
				System.out.println(visitors.get(i).getName() + "님의 변경전 증상 : "  + visitors.get(i).getSymptom());
				
				visitors.get(i).setSymptom(symptom);
				
				System.out.println(visitors.get(i).getName() + "님의 변경후 증상 : "  + visitors.get(i).getSymptom());
				
				break;
			}
		}
		if(i == index) {
			System.out.println(name + "님은 존재하지 않습니다.");
		}
		System.out.println("*********************************************\n");
	}
	
	@Override
	public void printVisitors() {
		System.out.println("\n		System Message");
		System.out.println("*********************************************");
		for(int i = 0; i<index; i++) {
			System.out.println("\n[" + (i+1) + "번 방문자]");
			System.out.println("이름 : " + visitors.get(i).getName());
			System.out.println("체온)");
			System.out.println("오전 체온 : " + visitors.get(i).getFever().getTemperature1());
			System.out.println("오후 체온 : " + visitors.get(i).getFever().getTemperature2());
			System.out.print("증상 : ");
						
			if(visitors.get(i).getSymptom() == null && (visitors.get(i).getFever().getTemperature1() < 37.5 && visitors.get(i).getFever().getTemperature2() < 37.5)) 
				System.out.println("없음\n상태 : 정상");
			else {
				if(visitors.get(i).getSymptom() != null) {
					System.out.println(visitors.get(i).getSymptom());
					System.out.println("상태 : 주의 ");
				}
				else {
					System.out.println("없음\n상태 : 주의 ");
				}
			}
		}
		System.out.println("\n*********************************************\n");
	}

	@Override
	public void printVistiors(ArrayList<Visitor> v) {
		System.out.println("\n		System Message");
		System.out.println("*********************************************");
		for(int i = 0; i<index; i++) {
			System.out.println("\n[" + (i+1) + "번 방문자]");
			System.out.println(v.get(i) + "\n");
		}
		System.out.println("*********************************************\n");
	}
}
