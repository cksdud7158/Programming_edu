package fly;
//�Ϻ��� �߻�ȭ  --> �����Ȱ��� �ϳ��� ����� �������̽���. 
// �������̽� ���� ��� = �߻�޼ҵ� + ���
// �θ��� ������ Ÿ������ ��� ����
public interface Flyer {
	//������ �Ͱ� ���õ� ����� Template�� ���� 
	public static final int SIZE=100;
	void fly(); // ���� �Ʒ��� ����, public abstract �� �����Ǿ�����
	public abstract void land();
	public abstract void take_off();
	
}
