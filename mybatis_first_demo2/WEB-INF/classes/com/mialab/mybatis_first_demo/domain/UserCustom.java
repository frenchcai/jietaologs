package com.mialab.mybatis_first_demo.domain;

public class UserCustom extends User{
	//一定要有一个构造方法，否则在mapper 中，生产sqlsession 会报错
	public UserCustom() {
		
	}

}
