package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;

import com.alibaba.fastjson.JSON;
import com.mialab.mybatis_first_demo.domain.Message;
import com.mialab.mybatis_first_demo.mapper.TextMapper;
import com.mialab.mybatis_first_demo.sqlSession.DataConnection;

/**
 * Servlet implementation class queryMessageServlet
 */
@WebServlet("/queryMessageServlet")
public class queryMessageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public queryMessageServlet() {
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
		int userID=Integer.parseInt(request.getParameter("userID"));
		BigInteger textID=new BigInteger(request.getParameter("textID"));
		SqlSession sqlSession=null;
		
		try {
			DataConnection connection=new DataConnection();
			sqlSession=connection.getSession();
			TextMapper mapper=connection.getMapper(sqlSession);
			List<Message>messages=mapper.queryMessage(userID, textID);
			sqlSession.commit();
			
			if(messages.size()>0){
				String jsonString = JSON.toJSONString(messages);  
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

}
