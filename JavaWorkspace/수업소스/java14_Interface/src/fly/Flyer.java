package fly;
//�Ϻ��� �߻�ȭ...�����Ȱ��� �ϳ��� ����� �������̽��̴�.
//�������̽� ������� = �߻�޼ҵ� + ���
public interface Flyer {
	public static final int SIZE=100;
	//������ �Ͱ� ���õ� ����� Template�� ����...
	public abstract void fly();
	void land(); //������ �տ� public abstract �� �����ȴ�.
	void take_off();
}
