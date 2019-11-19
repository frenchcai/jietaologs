package com.mialab.mybatis_first_demo.main;

import java.io.InputStream;


import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.mialab.mybatis_first_demo.domain.Landing;
import com.mialab.mybatis_first_demo.domain.Student;
import com.mialab.mybatis_first_demo.mapper.StudentMapper;


public class addStudent {
	
	private static SqlSessionFactory sqlSessionFactory;
	public void addStudent(Landing landing) {
		SqlSession session=null;
		try {
				InputStream inputStream=Resources.getResourceAsStream("mybatis-config.xml");
				
				sqlSessionFactory =new SqlSessionFactoryBuilder().build(inputStream);
				
				session=sqlSessionFactory.openSession();
				
				StudentMapper mapper=session.getMapper(StudentMapper.class);
				
				
				mapper.addStudent(landing);
			
				session.commit();
				
				
		}catch(Exception e) {
			e.getMessage();
		}
		finally {
			if(session!=null) {
				session.close();
			}
		}
		
		
	}
	
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
//				
//				StudentMapper mapper=session.getMapper(StudentMapper.class);
//				
////				Student student=new Student();
////				
////				student.setSno("2017254144");
////				student.setName("小谭");
//				
////			mapper.addStudent(student);
//				
////				System.out.println(student);
//				
//				List<Student> student= mapper.getStudentAll("2017254143");
//				for(Student students:student) {
//					System.out.println(students);
//					
//				}
//				session.commit();
//				
//				
//		}catch(Exception e) {
//			e.printStackTrace();
//		}
//		finally {
//			if(session!=null) {
//				session.close();
//			}
//		}
	
	

}
