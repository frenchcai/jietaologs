package com.mialab.mybatis_first_demo.main;

import java.io.InputStream;



import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.mialab.mybatis_first_demo.domain.Student;
import com.mialab.mybatis_first_demo.mapper.StudentMapper;


public class FirstMain {
//	private static SqlSessionFactory sqlSessionFactory;
//	
//	public static  void main (String args[]) {
//		
//		SqlSession session=null;
//		
//		try {
//				InputStream inputStream=Resources.getResourceAsStream("mybatis-config.xml");
//				
//				sqlSessionFactory =new SqlSessionFactoryBuilder().build(inputStream);
//				
//				session=sqlSessionFactory.openSession();
//				StudentMapper mapper=session.getMapper(StudentMapper.class);
//				Student student=mapper.getStudent("2017254142");
//				
//				System.out.println(student);
//				
//				session.commit();
//				
//		}catch(Exception e) {
//			e.printStackTrace();
//		}
//		finally {
//			if(session!=null) {
//				session.close();
//			}
//		}
//	}
//	

}
