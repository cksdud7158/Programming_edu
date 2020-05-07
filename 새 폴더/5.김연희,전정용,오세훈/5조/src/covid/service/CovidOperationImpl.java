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
				System.out.println(name + "���� �̹� �湮�� ��ܿ� �����մϴ�.");
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
		System.out.println(v.getName() +"���� ȸ������ �߰��Ǿ����ϴ�. ");
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
				System.out.println(visitors.get(i).getName() + "���� ���ŵǾ����ϴ�.");
				for(int j = i; j<index-1; j++) {
					visitors.set(j, visitors.get(j+1));
				}
				index--;
				break;
			}
		}
		if(i == index) {
			System.out.println(name + "���� �������� �ʽ��ϴ�.");
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
					System.out.println(name + "���� ����ũ�� �����ϰ� ��ʴϴ�. ");
					maskCheck = true;
					break;
				}
				else
					continue;
			}
		}
		if(nameCheck) {
			if(!maskCheck) 
				System.out.println(name + "���� ����ũ�� �����ϰ� ����� �ʽ��ϴ�.");
		}
		else 
			System.out.println(name + "���� �湮�� ��ܿ� �������� �ʽ��ϴ�.");
		System.out.println("*********************************************\n");
	}

	@Override
	public void overTemperature(double temperature)  {
		System.out.println("\n		System Message");
		System.out.println("*********************************************");
		for(int i = 0; i<index; i++) {
			if(visitors.get(i).getFever().getTemperature1() >= temperature) {
				System.out.println(visitors.get(i).getName() + "���� �ݸ� ����Դϴ�.");
			}
			else {
				if(visitors.get(i).getFever().getTemperature2() >= temperature) {
					System.out.println(visitors.get(i).getName() + "���� �ݸ� ����Դϴ�.");
				}
				else {
					System.out.println(visitors.get(i).getName() + "���� �ݸ� ����� �ƴմϴ�.");
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
				System.out.println(visitors.get(i).getName() + "���� ������ ���� �µ� : " + visitors.get(i).getFever().getTemperature1());
				System.out.println(visitors.get(i).getName() + "���� ������ ���� �µ� : " + visitors.get(i).getFever().getTemperature2());
				
				visitors.get(i).setFever(fever);
				
				System.out.println(visitors.get(i).getName() + "���� ������ ���� �µ� : " + visitors.get(i).getFever().getTemperature1());
				System.out.println(visitors.get(i).getName() + "���� ������ ���� �µ� : " + visitors.get(i).getFever().getTemperature2());	
				
				break;
			}
		}
		if(i == index) {
			System.out.println(name + "���� �������� �ʽ��ϴ�.");
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
				System.out.println(visitors.get(i).getName() + "���� ������ ���� : "  + visitors.get(i).getSymptom());
				
				visitors.get(i).setSymptom(symptom);
				
				System.out.println(visitors.get(i).getName() + "���� ������ ���� : "  + visitors.get(i).getSymptom());
				
				break;
			}
		}
		if(i == index) {
			System.out.println(name + "���� �������� �ʽ��ϴ�.");
		}
		System.out.println("*********************************************\n");
	}
	
	@Override
	public void printVisitors() {
		System.out.println("\n		System Message");
		System.out.println("*********************************************");
		for(int i = 0; i<index; i++) {
			System.out.println("\n[" + (i+1) + "�� �湮��]");
			System.out.println("�̸� : " + visitors.get(i).getName());
			System.out.println("ü��)");
			System.out.println("���� ü�� : " + visitors.get(i).getFever().getTemperature1());
			System.out.println("���� ü�� : " + visitors.get(i).getFever().getTemperature2());
			System.out.print("���� : ");
						
			if(visitors.get(i).getSymptom() == null && (visitors.get(i).getFever().getTemperature1() < 37.5 && visitors.get(i).getFever().getTemperature2() < 37.5)) 
				System.out.println("����\n���� : ����");
			else {
				if(visitors.get(i).getSymptom() != null) {
					System.out.println(visitors.get(i).getSymptom());
					System.out.println("���� : ���� ");
				}
				else {
					System.out.println("����\n���� : ���� ");
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
			System.out.println("\n[" + (i+1) + "�� �湮��]");
			System.out.println(v.get(i) + "\n");
		}
		System.out.println("*********************************************\n");
	}
}
