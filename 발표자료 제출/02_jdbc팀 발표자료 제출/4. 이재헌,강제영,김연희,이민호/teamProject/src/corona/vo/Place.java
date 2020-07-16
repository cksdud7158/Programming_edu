package corona.vo;

public class Place {
	private String address;
	private String name;
	
	public Place() {
		
	}

	public Place(String address, String name) {
		super();
		this.address = address;
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Place [address=" + address + ", name=" + name + "]";
	}

}
