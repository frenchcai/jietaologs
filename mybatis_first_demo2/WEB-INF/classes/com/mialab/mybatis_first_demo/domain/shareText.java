package com.mialab.mybatis_first_demo.domain;

import java.math.BigInteger;
public class shareText{
//   private static SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy年M月d日");
//   private static String date=sdf2.format(new Date());
	private int userID;	
	private BigInteger textID;
	private String title;
	private String text;
	private String picpath1;
	private String picpath2;
	private String username;
	private String date;
	private int num_like;
	private int num_message;
	
	
	public shareText() {
		
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
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	
	public String getPicpath1() {
		return picpath1;
	}
	public void setPicpath1(String picpath1) {
		this.picpath1 = picpath1;
	}
	public String getPicpath2() {
		return picpath2;
	}
	public void setPicpath2(String picpath2) {
		this.picpath2 = picpath2;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	
	public int getNum_message() {
		return num_message;
	}
	public void setNum_message(int num_message) {
		this.num_message = num_message;
	}
	
    
	
	
	
	
	public int getNum_like() {
		return num_like;
	}
	public void setNum_like(int num_like) {
		this.num_like = num_like;
	}
	
	public shareText(int userID,BigInteger textID, String title, String text,String picpath1,String picpath2,String username, String date,int num_like,int num_message) {
		super();
		this.userID = userID;
	
		this.textID = textID;
		this.title = title;
		this.text = text;
		this.picpath1=picpath1;
		this.picpath2=picpath2;
		this.username = username;
		this.date = date;
		this.num_like = num_like;
		this.num_message=num_message;
	}

	
	

}

