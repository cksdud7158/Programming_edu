package oop.greet;
// EncoreGreet Ŭ������ �뵵...
/*
 * EncoreGreet�� 
 * Encore �������� �������鿡�� ���ϴ� �λ縻�� �����ϰ� �ִ� Ŭ���� 
 */
public class EncoreGreet {// Ŭ������ ���� ��Ҵ� �ΰ��� : Field, Method
	//Variable : ���� ����Ǵ� ����, Field(Member Variavle)
	// �ӽ��� �����ʿ��� �������� �ڵ带 �м�, James(value)�� �а� name(variable)�� ���� �Ҵ�
	public String name; //Initialization(�ʱ�ȭ)-> ���ο� ������ ���� �Ҵ��ϴ� ���� '�ʱ�ȭ'�� �Ѵ�. 
	public String message; 
	// �ʵ� �߰�
	public int classRoom;
	public String subject;
	
	//Method(���) 
	public void sayHello() {
		System.out.println(name+","+ message);
	}
	public String getEncore() {
		return name+"\t"+message+"\t"+classRoom+"\t"+ subject;
	}
	//�Լ� �߰�, �������� ���� �ѹ��� �ʵ忡 �����ϴ� ����� ����
	//�޼ҵ� ����  = �޼��� ����� + �޼ҵ� ������ 
	public void setEncore(String n, String m, int c, String s) {
		name = n; //Field �ʱ�ȭ 
		message = m;
		classRoom = c;
		subject = s;
		
	}
}
