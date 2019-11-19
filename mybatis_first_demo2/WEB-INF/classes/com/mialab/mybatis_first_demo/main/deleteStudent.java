package com.mialab.mybatis_first_demo.main;

import java.io.InputStream;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.log4j.Logger;

import com.mialab.mybatis_first_demo.domain.Student;
import com.mialab.mybatis_first_demo.mapper.StudentMapper;


public class deleteStudent {
	private static SqlSessionFactory sqlSessionFactory;
	static Logger logger=Logger.getLogger(deleteStudent.class.getName());
	private static deleteStudent delete;
	private deleteStudent() {
		
		try {
			
				InputStream inputStream=Resources.getResourceAsStream("mybatis-config.xml");
				
				sqlSessionFactory =new SqlSessionFactoryBuilder().build(inputStream);
				
		}catch(Exception e) {
			logger.error(e.toString());
		}
		
	}
		
	public static deleteStudent getInstance() {
		if(delete==null) {
			delete=new deleteStudent();
		}
		return delete;
	}
	
	public SqlSessionFactory getSqlSessionFactort() {
		return sqlSessionFactory;
	}
	
	
	

}
