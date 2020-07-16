package com.vo;

public class Vet {
	private int id;
	private int price;
	private String name;
	
	public Vet() {}
	
	public Vet(int id, int price) {
		super();
		this.id = id;
		this.price = price;
	}
	
	public Vet(int id, int price, String name) {
		this.id = id;
		this.price = price;
		this.name = name;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
}
