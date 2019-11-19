package servlet;

import java.io.IOException;
import java.io.PrintWriter;
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
import com.mialab.mybatis_first_demo.domain.User;
import com.mialab.mybatis_first_demo.domain.shareText;
import com.mialab.mybatis_first_demo.mapper.StudentMapper;
import com.mialab.mybatis_first_demo.mapper.TextMapper;
import com.mialab.mybatis_first_demo.sqlSession.DataConnection;

/**
 * Servlet implementation class queryMyLikeServlet
 */
@WebServlet("/queryMyLikeServlet")
public class queryMyLikeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public queryMyLikeServlet() {
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
	//	data:"username="+user.user.username,
		int userID=Integer.parseInt(request.getParameter("userID"));
		SqlSession sqlSession=null;
		User user=new User();
		user.setUserID(userID);
		try {
			DataConnection connection=new DataConnection();
			sqlSession=connection.getSession();
			TextMapper mapper=connection.getMapper(sqlSession);
			List<shareText>text=mapper.queryMyLikeText(user);
			sqlSession.commit();	
			if(text.size()!=0) {
				String jsonString = JSON.toJSONString(text);  
				response.setCharacterEncoding("UTF-8");  
				response.setContentType("application/json; charset=utf-8");  
				PrintWriter writer = response.getWriter();
				System.out.println(jsonString);
				writer.append(jsonString);
				writer.close();
			}
	
	}catch (Exception e) {
		
		e.printStackTrace();
	}
		finally{
			if(sqlSession!=null) {
				sqlSession.close();
			}
		}
		
		// TODO: handle exception
	}

}
