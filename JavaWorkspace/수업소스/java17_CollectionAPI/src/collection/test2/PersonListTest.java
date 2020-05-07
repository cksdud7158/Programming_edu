package collection.test2;

import java.util.ArrayList;

public class PersonListTest {
	public static void main(String[] args) {
		//List�ȿ� �������� Person���� ����...�������..
		ArrayList<Person> list = new ArrayList<Person>();
		
		list.add(new Person("�̼���", "���ǵ�", 67));
		list.add(new Person("������", "��õ", 45));
		list.add(new Person("��������", "����", 27));
		list.add(new Person("�̼���1", "���ǵ�", 37));
		list.add(new Person("������1", "��õ1", 45));
		list.add(new Person("��������1", "���ǵ�", 17));
		
		System.out.println(list);
		
		//1. �ι�° �屺�� ã�Ƽ� ������ ���
		System.out.println(list.get(1));
		
		//2. ����Ʈ�� ����ִ� �屺���� ���ڸ� ���
		System.out.println(list.size());
		
		//3. ����Ʈ�� ����� �屺���� ��� ������ ���
		int total = 0;
		for(Person p : list) total += p.getAge();
		System.out.println(total/list.size());
		
		//4. ����� �屺���� �̸��� ���
		for(Person p : list) System.out.println(p.getName());
		
		//5.
		for(Person p : list) {
			if(p.getAddr().equals("���ǵ�")) 
				System.out.println(p);			
		}		
	}
}









