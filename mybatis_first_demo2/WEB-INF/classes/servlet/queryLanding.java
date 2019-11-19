package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.websocket.Session;

import org.apache.ibatis.session.SqlSession;
import org.apache.tomcat.util.http.mapper.Mapper;

import com.alibaba.fastjson.JSON;
import com.mialab.mybatis_first_demo.domain.Landing;
import com.mialab.mybatis_first_demo.domain.Student;
import com.mialab.mybatis_first_demo.domain.User;
import com.mialab.mybatis_first_demo.main.checkLanding;
import com.mialab.mybatis_first_demo.mapper.StudentMapper;
import com.mialab.mybatis_first_demo.sqlSession.DataConnection;

/**
 * Servlet implementation class queryLanding
 */
@WebServlet("/queryLanding")
public class queryLanding extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public queryLanding() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		if(username!=null && password!=null) {
			User user=new User();
			user.setUsername(username);
			user.setPassword(password);
			SqlSession sqlsession=null;
			try {
				DataConnection connection=new DataConnection();
				sqlsession=connection.getSession();
				StudentMapper mapper=connection.getStudentMapper(sqlsession);
				user=mapper.checkLand(user);
				sqlsession.commit();
				if(user.getUsername()!=null) {
					Map<String, User> a=new HashMap<String, User>();
					a.put("user", user);
					String jsonString = JSON.toJSONString(a);  
					response.setCharacterEncoding("UTF-8");  
					response.setContentType("application/json; charset=utf-8");  
					PrintWriter writer = response.getWriter();
					System.out.println(jsonString);
					writer.append(jsonString);
					writer.close();
				}
				
				
				
				
			}catch(Exception e){
				
				e.printStackTrace();
				
				
				
			}finally {
				if(sqlsession!=null) {
					sqlsession.close();
				}
			}
			
			
			
		}
		
		
		
	}

}
