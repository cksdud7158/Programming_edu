package servlet.model;

public class MemberVO {
	private String id;
	private String passowrd;
	
	public MemberVO(String id, String passowrd) {
		super();
		this.id = id;
		this.passowrd = passowrd;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPassowrd() {
		return passowrd;
	}

	public void setPassowrd(String passowrd) {
		this.passowrd = passowrd;
	}

	@Override
	public String toString() {
		return "MemberVo [id=" + id + ", passowrd=" + passowrd + "]";
	}
	
	
	
}
