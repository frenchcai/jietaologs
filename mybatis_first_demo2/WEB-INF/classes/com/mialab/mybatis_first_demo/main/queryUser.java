package com.mialab.mybatis_first_demo.main;

import java.util.List;


import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.mialab.mybatis_first_demo.domain.LandingCustom;
import com.mialab.mybatis_first_demo.domain.StudentCustom;
import com.mialab.mybatis_first_demo.domain.UserCustom;
import com.mialab.mybatis_first_demo.mapper.StudentMapper;
import com.mialab.mybatis_first_demo.sqlSession.DataConnection;

public class queryUser {
	public void queryStudent(UserCustom userCustom) {
		SqlSession sqlSession=null;
		
		try {
			sqlSession=new DataConnection().getSession();
			StudentMapper mapper=sqlSession.getMapper(StudentMapper.class);
			//实例化mapper类，才能使用方法
			List<UserCustom> users=mapper.queryUser(null);	
		}catch (Exception e) {
			// TODO: handle exception
			System.out.println("queryUser has error"+e.getMessage());
		}
	
		
		
		
		
	}
	

}
