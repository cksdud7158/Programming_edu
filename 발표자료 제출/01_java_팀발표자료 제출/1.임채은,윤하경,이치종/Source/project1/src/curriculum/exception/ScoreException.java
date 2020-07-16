package curriculum.exception;

public class ScoreException extends Exception {
	public ScoreException() {
		this("점수를 초과 입력했습니다.\n");
	}
	
	public ScoreException(String message) {
		super(message);
	}
}