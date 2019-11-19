package com.mialab.mybatis_first_demo.mapper;
import java.math.BigInteger;
import java.util.List;

import org.apache.catalina.startup.UserConfig;
import org.apache.ibatis.annotations.Param;

import com.mialab.mybatis_first_demo.domain.Landing;
import com.mialab.mybatis_first_demo.domain.Student;
import com.mialab.mybatis_first_demo.domain.StudentCustom;
import com.mialab.mybatis_first_demo.domain.User;
import com.mialab.mybatis_first_demo.domain.UserCustom;
import com.mialab.mybatis_first_demo.domain.shareText;;
public interface StudentMapper {
	public void addStudent(Landing landing);
	public int deleteStudent(String sno);
	public User queryUser(User user);
	public int addUser(User user);
//	public void addText(@Param("userID")int userID,@Param("textID") BigInteger textID,@Param("title") String title, @Param("text") String text,@Param("picpath1") String picpath1,String picpath2,@Param("picpath2") String username, @Param("date") String date,@Param("num_like") int num_like,@Param("message") String message);
	public User checkLand(User user);
	public void addShareText(shareText text);
	public int isLike(@Param("userID") int userID,@Param("textID") BigInteger textID);
	public int addToMine(@Param("myID") int myID,@Param("userID") int userID,@Param("textID")BigInteger textID);
	
	public int addPic(@Param("userID")Integer userID,@Param("textID") Integer textID,@Param("picpath1") Integer picpath1,@Param("picpath2") Integer picpath2);
	public int updateText(@Param("title")String title,@Param("text")String text,@Param("username")String username,@Param("date")String date);
}
