package exam.test;
/*
 * final Ű���� �� ��κ� static Ű����� ���� ���� 
 * final Ű���� :: ���� �������̾� �̶� ���� ����
 * fianl + ���� : ����� �ǹ� 
 * final + Ŭ���� : ��ӱ���
 * final + �޼ҵ� : �������̵� ����
 */
// ��Ȯ���� public�� �ٿ����� ����� �����Ͽ� ���������� ����� �����ϰ� �ϱ����ؼ���
class A{
	public final static int BASE_SALARY =300;
	public final String test() {
		return "Overriding ����";
	}
}

final class B{// ��� ����
}
// class C extends B {} ->����� �ȵǴ� ���� Ȯ��

class D extends A{
	/*public final String test() {
		return "Overriding ����";
	}*/ // ������ �Ұ��� ���� �����Ϸ��� �θ�Ŭ������ ���� ��⿡ ���Ƶ� 
}


public class StaticExamTest4 {	
	
}
