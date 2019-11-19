package com.mialab.mybatis_first_demo.domain;

public class Student {
	private String name;
	private String sex;
	private String password;
	private String school;
	private String major;
	private String phone;
	
	
	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Student(String name, String sex, String password, String school, String major, String phone) {
		super();
		this.name = name;
		this.sex = sex;
		this.password = password;
		this.school = school;
		this.major = major;
		this.phone = phone;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getSex() {
		return sex;
	}


	public void setSex(String sex) {
		this.sex = sex;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public String getSchool() {
		return school;
	}


	public void setSchool(String shool) {
		this.school = shool;
	}


	public String getMajor() {
		return major;
	}


	public void setMajor(String major) {
		this.major = major;
	}


	public String getPhone() {
		return phone;
	}


	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	
}
