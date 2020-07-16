package com.vo;

import java.util.ArrayList;

public class Teacher extends Member{
	private ArrayList<String> languages;
	
	public Teacher(int ssn, String name, ArrayList<String> languages) {
		super(ssn, name);
		this.languages = languages;
	}


	public ArrayList<String> getLanguages() {
		return languages;
	}

	public void setLanguages(ArrayList<String> languages) {
		this.languages = languages;
	}
	
	@Override
	public String toString() {
		return super.toString() + languages;
	}
}
