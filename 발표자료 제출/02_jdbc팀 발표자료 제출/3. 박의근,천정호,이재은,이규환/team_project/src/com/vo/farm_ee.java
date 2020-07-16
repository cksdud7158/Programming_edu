package com.vo;

public class farm_ee {
	private int id;
	private String name;
	private String hiredate;
	private String job;

	public farm_ee() {
	}

	public farm_ee(int id, String name, String hiredate, String job) {
		super();
		this.id = id;
		this.name = name;
		this.hiredate = hiredate;
		this.job = job;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getHiredate() {
		return hiredate;
	}

	public void setHiredate(String hiredate) {
		this.hiredate = hiredate;
	}

	public String getJob() {
		return job;
	}

	public void setJob(String job) {
		this.job = job;
	}

}
