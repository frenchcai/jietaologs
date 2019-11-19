package com.mialab.mybatis_first_demo.main;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.junit.Test;
import org.apache.ibatis.session.SqlSession;

import com.mialab.mybatis_first_demo.domain.LandingCustom;
import com.mialab.mybatis_first_demo.domain.User;
import com.mialab.mybatis_first_demo.sqlSession.DataConnection;

public class test2 {
	
	List<User>gamers=new ArrayList<User>();
	DataConnection com=new DataConnection();
	@Test
	public void testSelect() throws IOException {
		SqlSession sqlSession=com.getSession();
		
		gamers=sqlSession.selectList("findAll");
		System.out.println(gamers.size());
		for(int i=0;i<gamers.size();i++) {
			
			System.out.println(gamers.get(i).getName());
			System.out.println(i);
		}
		
		sqlSession.close();
	}
	
	

}
