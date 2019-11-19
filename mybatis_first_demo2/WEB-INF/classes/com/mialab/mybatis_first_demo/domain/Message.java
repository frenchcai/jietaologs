package com.mialab.mybatis_first_demo.domain;

import java.math.BigInteger;

public class Message {
	private String myName;
	private int userID;
	private BigInteger textID;
	private String message;
	
	
	
	
	public Message() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Message(String myName, int userID, BigInteger textID, String message) {
		super();
		this.myName = myName;
		this.userID = userID;
		this.textID = textID;
		this.message = message;
	}
	
	public String getMyName() {
		return myName;
	}
	public void setMyName(String myName) {
		this.myName = myName;
	}
	public int getUserID() {
		return userID;
	}
	public void setUserID(int userID) {
		this.userID = userID;
	}
	public BigInteger getTextID() {
		return textID;
	}
	public void setTextID(BigInteger textID) {
		this.textID = textID;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
}
