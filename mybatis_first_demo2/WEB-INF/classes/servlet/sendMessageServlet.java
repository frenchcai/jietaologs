package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;

import com.alibaba.fastjson.JSON;
import com.mialab.mybatis_first_demo.domain.Count;
import com.mialab.mybatis_first_demo.domain.Message;
import com.mialab.mybatis_first_demo.mapper.TextMapper;
import com.mialab.mybatis_first_demo.sqlSession.DataConnection;

/**
 * Servlet implementation class sendMessageServlet
 */
@WebServlet("/sendMessageServlet")
public class sendMessageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public sendMessageServlet() {
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
		String myName=request.getParameter("myName");
		
		
		BigInteger textID=new BigInteger((String)request.getParameter("textID"));
		int userID=Integer.parseInt((String)request.getParameter("userID"));
		String message=request.getParameter("message");
		
		Message message2=new Message(myName,userID,textID,message);
		if(message.length()!=0) {
			SqlSession sqlSession=null;
		try {
			DataConnection connection=new DataConnection();
			sqlSession=connection.getSession();
			TextMapper mapper=connection.getMapper(sqlSession);
		
			mapper.sendMessage(message2);
			
			mapper.updateNumMessage(userID, textID);
			
			sqlSession.commit();
			Count count=new Count(1);
//			String jsonString=JSON.toJSONString(count);
//			response.setCharacterEncoding("UTF-8");  
//			response.setContentType("application/json; charset=utf-8");  
//			PrintWriter writer = response.getWriter();
//			writer.append(jsonString);
//			System.out.println(jsonString);
			Map<String, String> a=new HashMap<String, String>();
			a.put("ok", "ok");
		
			String jsonString = JSON.toJSONString(a);  
			response.setCharacterEncoding("UTF-8");  
			response.setContentType("application/json; charset=utf-8");  
			PrintWriter writer = response.getWriter();
			System.out.println(jsonString);
			writer.append(jsonString);
			writer.close();
			
			
			
	
			
			
			
		
			
		
			
			
		}catch (Exception e) {
			
			System.out.println("insert message has error" +e.getMessage());
			// TODO: handle exception
		}finally {
			if(sqlSession!=null) {
				sqlSession.close();
			}
		}
		
		}else {
			
		}
		
	}

}
