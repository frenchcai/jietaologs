package com.mialab.mybatis_first_demo.sqlSession;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.mialab.mybatis_first_demo.mapper.StudentMapper;
import com.mialab.mybatis_first_demo.mapper.TextMapper;
public class DataConnection {
	private  static SqlSessionFactory sqlSessionFactory;
	public  SqlSession getSession() throws IOException {
		InputStream in=Resources.getResourceAsStream("mybatis-config.xml");
		sqlSessionFactory =new SqlSessionFactoryBuilder().build(in);
		SqlSession sqlSession=sqlSessionFactory.openSession();
		return sqlSession;
	}
	
	public TextMapper getMapper(SqlSession sqlSession)throws IOException{
		TextMapper mapper =sqlSession.getMapper(TextMapper.class);
		return mapper;
		
	}
	
	public StudentMapper getStudentMapper(SqlSession sqlSession)throws IOException{
		StudentMapper mapper =sqlSession.getMapper(StudentMapper.class);
		return mapper;
		
	}

}
