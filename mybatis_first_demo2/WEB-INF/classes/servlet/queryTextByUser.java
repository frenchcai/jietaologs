package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;

import com.alibaba.fastjson.JSON;
import com.mialab.mybatis_first_demo.domain.Count;
import com.mialab.mybatis_first_demo.domain.User;
import com.mialab.mybatis_first_demo.domain.shareText;
import com.mialab.mybatis_first_demo.mapper.TextMapper;
import com.mialab.mybatis_first_demo.sqlSession.DataConnection;

/**
 * Servlet implementation class queryTextByUser
 */
@WebServlet("/queryTextByUser")
public class queryTextByUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public queryTextByUser() {
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
		int userID=0;
		if(request.getParameter("userID")!=null) {
			userID=Integer.parseInt(request.getParameter("userID"));
		}
		String phone=request.getParameter("phone");
		String sex=request.getParameter("sex");
		User user =new User(userID,username,null,phone,sex);
		
		
		SqlSession sqlSession=null;
		
		try {
			DataConnection connection=new DataConnection();
			sqlSession=connection.getSession();
			TextMapper mapper=connection.getMapper(sqlSession);
			int count=mapper.getNumTextByUsername(username);
			if(count>0) {
				Count count1=new Count(count);
				String jsonCount = JSON.toJSONString(count1); 
				List<shareText>texts=mapper.queryText(user);
				sqlSession.commit();
				String jsonString = JSON.toJSONString(texts);  
//				String jsonString2 = JSON.toJSONString(counts);  
				response.setCharacterEncoding("UTF-8");  
				response.setContentType("application/json; charset=utf-8");  
				PrintWriter writer = response.getWriter();
				String jsonString3=jsonString.substring(1);
				String aString="["+jsonCount+","+jsonString3;
				writer.append(aString);
				writer.close();
				
			}else {
				
				
			}
			
			
			
			
				
			
				
			
			
			
			
		}catch (Exception e) {
			// TODO: handle exception
			
			e.printStackTrace();
		}
		finally {
			if(sqlSession!=null) {
				sqlSession.close();
			}
		}
		
		
		
		
		
	}

}
