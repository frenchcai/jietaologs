package servlet;


import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.io.Reader;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;


import java.io.IOException;
import java.net.URL;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.ibatis.session.SqlSession;

import com.alibaba.fastjson.JSON;
import com.mialab.mybatis_first_demo.domain.Landing;
import com.mialab.mybatis_first_demo.domain.User;
import com.mialab.mybatis_first_demo.main.addStudent;
import com.mialab.mybatis_first_demo.mapper.StudentMapper;
import com.mialab.mybatis_first_demo.sqlSession.DataConnection;

 /* Servlet implementation class addStudent
 */
@WebServlet("/addUserServlet")
public class addUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public addUserServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		String phone=request.getParameter("phone");
		String sex=request.getParameter("sex");
		SqlSession sqlSession=null;
		try {
			if(username!=null&&password!=null) {
				
				User user=new User(0, username, password, phone, sex);
				
				DataConnection connection=new DataConnection();
					sqlSession=connection.getSession();
					StudentMapper mapper=connection.getStudentMapper(sqlSession);	
						mapper.addUser(user);
					
						sqlSession.commit();
						Map<String, String> a=new HashMap<String, String>();
						a.put("ok", "ok");
						String jsonString = JSON.toJSONString(a);  
						response.setCharacterEncoding("UTF-8");  
						response.setContentType("application/json; charset=utf-8");  
						PrintWriter writer = response.getWriter();
						System.out.println(jsonString);
						writer.append(jsonString);
						writer.close();
						
						
			}		
						
				}catch(Exception e) {
					e.printStackTrace();
				}
				finally {
					if(sqlSession!=null) {
						sqlSession.close();
					}
					
						
					
				}
				
				
		
	}	
		
		
		
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
