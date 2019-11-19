package com.mialab.mybatis_first_demo.main;

import java.math.BigInteger;

import org.apache.ibatis.session.SqlSession;

import com.mialab.mybatis_first_demo.domain.shareText;
import com.mialab.mybatis_first_demo.mapper.StudentMapper;
import com.mialab.mybatis_first_demo.mapper.TextMapper;
import com.mialab.mybatis_first_demo.sqlSession.DataConnection;

public class test3 {
	public static void main(String args[]) {
		BigInteger a=new BigInteger("201725412225559");
		shareText text2=new shareText(2017254142,a,"title", "text", "picpath1", "picpath2", "username", "date",2);
	
		
			System.out.println("here 2");
			SqlSession sqlSession=null;
			
			try {
				DataConnection connection=new DataConnection();
				sqlSession=connection.getSession();
				StudentMapper mapper=connection.getStudentMapper(sqlSession);
//				int a=mapper.updateText(title, text, username, date);
				mapper.addShareText(text2);
				System.out.println("here 3");
				sqlSession.commit();
				System.out.println("here 4");
				
			}catch (Exception e) {
				System.out.println("inserttext has error");
			}
			
			finally {
				if(sqlSession!=null) {
					sqlSession.close();
				}
				
			}
	}
}

