package corona.vo;

public class Hospital {
	private int code;
	private String name;
	
	public Hospital() {
		
	}
	public Hospital(int code, String name) {
		super();
		this.code = code;
		this.name = name;
	}
	
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	@Override
	public String toString() {
		return "Hospital [code=" + code + ", name=" + name + ", getCode()=" + getCode() + ", getName()=" + getName()
				+ ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString()
				+ "]";
	}
	
	
}
