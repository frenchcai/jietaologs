package com.mialab.mybatis_first_demo.domain;

public class Landing {
	private String username;
	private String password;
	public Landing() {
		
	}
	public Landing(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
}
