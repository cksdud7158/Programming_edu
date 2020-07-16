package com.vo;

import java.io.Serializable;

public class CustomerRec implements Serializable{
	private int id;
	private String limit_grade;
	private int limit_price;
	private int total;
	private String name;
	
	public CustomerRec() {}
	
	public CustomerRec(int id, String limit_grade, int limit_price, int total) {
		super();
		this.id = id;
		this.limit_grade = limit_grade;
		this.limit_price = limit_price;
		this.total = total;
	}
	
	public CustomerRec(int id,String name, String limit_grade, int limit_price, int total) {
		super();
		this.id = id;
		this.name = name;
		this.limit_grade = limit_grade;
		this.limit_price = limit_price;
		this.total = total;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getLimit_grade() {
		return limit_grade;
	}

	public void setLimit_grade(String limit_grade) {
		this.limit_grade = limit_grade;
	}

	public int getLimit_price() {
		return limit_price;
	}

	public void setLimit_price(int limit_price) {
		this.limit_price = limit_price;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
}
