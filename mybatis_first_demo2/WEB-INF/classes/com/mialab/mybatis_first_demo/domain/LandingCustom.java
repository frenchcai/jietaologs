package com.mialab.mybatis_first_demo.domain;

public class LandingCustom extends Landing{
	private String phone;

	
	public LandingCustom() {
		super();
		// TODO Auto-generated constructor stub
	}

	public LandingCustom(String username, String password) {
		super(username, password);
		// TODO Auto-generated constructor stub
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	

}
