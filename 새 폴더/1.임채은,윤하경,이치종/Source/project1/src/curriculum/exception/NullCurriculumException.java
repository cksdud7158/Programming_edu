package curriculum.exception;

public class NullCurriculumException extends Exception{
	public NullCurriculumException() {
		this("���� �����Դϴ�.\n");
	}
	public NullCurriculumException(String message) {
		super(message);
	}
}
