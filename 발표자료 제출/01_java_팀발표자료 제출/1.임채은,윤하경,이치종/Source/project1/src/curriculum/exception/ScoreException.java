package curriculum.exception;

public class ScoreException extends Exception {
	public ScoreException() {
		this("������ �ʰ� �Է��߽��ϴ�.\n");
	}
	
	public ScoreException(String message) {
		super(message);
	}
}