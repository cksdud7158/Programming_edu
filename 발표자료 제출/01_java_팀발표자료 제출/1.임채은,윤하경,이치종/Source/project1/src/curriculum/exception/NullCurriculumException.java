package curriculum.exception;

public class NullCurriculumException extends Exception{
	public NullCurriculumException() {
		this("없는 과정입니다.\n");
	}
	public NullCurriculumException(String message) {
		super(message);
	}
}
