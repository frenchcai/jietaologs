package com.mialab.mybatis_first_demo.mapper;


import java.math.BigInteger;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.alibaba.fastjson.JSON;
import com.mialab.mybatis_first_demo.domain.Message;
import com.mialab.mybatis_first_demo.domain.Student;
import com.mialab.mybatis_first_demo.domain.User;
import com.mialab.mybatis_first_demo.domain.shareText;
import com.sun.istack.internal.Interned;
import com.sun.org.glassfish.gmbal.ParameterNames;

public interface TextMapper {
	//public List<Student>queryAllStudent(@Param("begin") int begin,@Param("num") int num) ;
	public List<shareText>queryAllText(@Param("begin") int begin,@Param("num") int num) ;
	public List<shareText>searchText(shareText text);
	
	//public int getNumStudent();
	
	public List<shareText>queryText(User user);
	public List<shareText>queryMyLikeText(User user);
	public int getNumText();
	public int getNumTextByUsername(@Param("username")String username);
	public void sendMessage(Message message);
	public List<Message>queryMessage(@Param("userID")int userID,@Param("textID")BigInteger textID);
	public int notLike(@Param("userID") int userID,@Param("textID") BigInteger textID);
	public int reWriteText(shareText text);
	public int deleteText(@Param("userID") int userID,@Param("textID") BigInteger textID);
	public int updateNumMessage(@Param("userID")int userID,@Param("textID") BigInteger textID);
	public int cancelLike(@Param("myID") int myID,@Param("userID") int userID,@Param("textID") BigInteger textID);
}