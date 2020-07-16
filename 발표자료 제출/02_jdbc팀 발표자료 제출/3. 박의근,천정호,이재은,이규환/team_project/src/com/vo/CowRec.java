package com.vo;

import java.io.Serializable;

public class CowRec implements Serializable {
	private int id;
	private int weight;
	private int age;
	private String state;
	private String sex;
	private int manager;
	private int vet_id;
	private int marbling;

	private int price;
	private String grade;

	public CowRec() {
	}

	public CowRec(int weight, int age, String state, String sex, int manager, int vet_id, int marbling) {
		super();
		this.id = -1;
		this.weight = weight;
		this.age = age;
		this.state = state;
		this.sex = sex;
		this.manager = manager;
		this.vet_id = vet_id;
		this.marbling = marbling;
		this.price = 0;
		this.grade = "";
	}

	public CowRec(int id, int weight, int age, String state, String sex, int manager, int vet_id, int marbling,
			int price) {
		this(weight, age, state, sex, manager, vet_id, marbling);
		this.id = id;
		this.price = price;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getWeight() {
		return weight;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public int getManager() {
		return manager;
	}

	public void setManager(int manager) {
		this.manager = manager;
	}

	public int getVet_id() {
		return vet_id;
	}

	public void setVet_id(int vet_id) {
		this.vet_id = vet_id;
	}

	public int getMarbling() {
		return marbling;
	}

	public void setMarbling(int marbling) {
		this.marbling = marbling;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}

	@Override
	public String toString() {
		return getId() + "\t" + getWeight() + "\t" + getAge() + "\t" + getState() + "\t" + getSex() + "\t"
				+ getManager() + "\t" + getVet_id() + "\t" + getMarbling();
	}
}
