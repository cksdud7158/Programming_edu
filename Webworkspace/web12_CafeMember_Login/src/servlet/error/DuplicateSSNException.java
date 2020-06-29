package servlet.error;

public class DuplicateSSNException extends Exception {
	public DuplicateSSNException() {
		this("this is DuplicateSSNException");
	}
	
	public DuplicateSSNException(String message) {
		super(message);
	}
}
