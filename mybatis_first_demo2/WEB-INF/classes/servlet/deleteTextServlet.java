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
import com.mialab.mybatis_first_demo.mapper.TextMapper;
import com.mialab.mybatis_first_demo.sqlSession.DataConnection;

/**
 * Servlet implementation class deleteTextServlet
 */
@WebServlet("/deleteTextServlet")
public class deleteTextServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public deleteTextServlet() {
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
		DataConnection connection=new DataConnection();
		try {
			sqlSession=connection.getSession();
			TextMapper mapper=connection.getMapper(sqlSession);
			int a=mapper.deleteText(userID,textID);
			sqlSession.commit();
			if(a!=0) {
				System.out.println("success delete");
				Map<String, String> b=new HashMap<String, String>();
				b.put("ok","ok");
				String jsonString = JSON.toJSONString(a);  
				response.setCharacterEncoding("UTF-8");  
				response.setContentType("application/json; charset=utf-8");  
				PrintWriter writer = response.getWriter();
				
				System.out.println(jsonString);
				writer.append(jsonString);
				writer.close();
			}
			
		}catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}finally {
			if(sqlSession!=null) {
				sqlSession.close();
			}
		}
		
		
	}

}
