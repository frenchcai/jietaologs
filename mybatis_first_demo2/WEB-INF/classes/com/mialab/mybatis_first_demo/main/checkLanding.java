package com.mialab.mybatis_first_demo.main;

import java.io.IOException;

import org.apache.ibatis.session.SqlSession;

import com.mialab.mybatis_first_demo.domain.Landing;
import com.mialab.mybatis_first_demo.mapper.StudentMapper;
import com.mialab.mybatis_first_demo.sqlSession.DataConnection;

public class checkLanding {
	
	public int checkLand(String username,String password) {
		SqlSession sqlsession=null;
		int count=0;
		try {
			sqlsession=new DataConnection().getSession();
			StudentMapper mapper=sqlsession.getMapper(StudentMapper.class);
			
		
			Landing landing=new Landing(username,password);
			count =mapper.checkLand(landing);
			sqlsession.commit();
		} catch (IOException e) {
			
			System.out.println("checkLanding has error"
					+ e.getMessage());
		}
		finally {
			if(sqlsession!=null) {
				sqlsession.close();
			}
			
			
		}
		
			return count;
		
	}
	

}
