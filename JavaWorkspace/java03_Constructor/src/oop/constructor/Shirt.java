package oop.constructor;
/*
 * Default Constructor
 * 1. ���ڰ��� ���� ������
 * 2. �����ο��� �ƹ��� �ϵ� �����ʴ� ������ 
 * 3. field�� �ƹ� ���� �Ҵ����� ���� 
 */
public class Shirt {
	public String maker;
	public boolean longSleeved; 
	
	
	public char color;
	
	
	public Shirt(){// Default Constructor(�⺻ ������)/ �ϳ��� Ŭ�������� �ݵ�� �ϳ� �̻��� �����ڰ� �����Ѵ�. 
		
	}
	public Shirt(String m , boolean longs, char c){ 
		// �ʵ� �ʱ�ȭ 
		maker = m;
		longSleeved = longs;
		color = c;
	}
	public String getDetails() { //worker method = �����ΰ� �ִ� �޼ҵ�
		return maker+","+longSleeved+","+color;
	}
}
