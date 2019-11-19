package com.mialab.mybatis_first_demo.domain;

public class User {
	private int userID;
	
	private String username;
	private String password;
	private String phone;
	private String sex;
	public User() {
		
	};
	
	public User(int userID, String username, String password, String phone, String sex) {
		super();
		this.userID = userID;
		this.username = username;
		this.password = password;
		this.phone = phone;
		this.sex = sex;
	}





	public int getUserID() {
		return userID;
	}
	public void setUserID(int userID) {
		this.userID = userID;
	}
	@Override
	public String toString() {
		return "gamer [name=" + username + ", className="  + ", school=" + ", password=" + password
				+ ", phone=" + phone + ", sex=" + sex + "]";
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
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	

}
