package com.mialab.mybatis_first_demo.main;



import java.util.List;


import org.apache.ibatis.session.SqlSession;

import com.mialab.mybatis_first_demo.domain.Student;
import com.mialab.mybatis_first_demo.mapper.StudentMapper;

public class test {
	public static void main(String args[]) {
		SqlSession session=null;
		
		
		
		try {
		session=deleteStudent.getInstance().getSqlSessionFactort().openSession();
		
		StudentMapper student=session.getMapper(StudentMapper.class);
//		Student stu=new Student();
//		stu.setSno("2017254146");
//		stu.setName("城仓");
//		student.addStudent(stu);
//		List<Student>stu=student.getStudentAll("2017254143");
//		for(Student students:stu) {
//			System.out.print(students);
//		}
		
		session.commit();
		}catch(Exception e) {
			session.rollback();
			e.printStackTrace();
		}
		finally{
			if(session != null) {
				session.close();
			}
			
		}
		
	}

}
