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
import org.eclipse.jdt.internal.compiler.ast.BinaryExpression;

import com.alibaba.fastjson.JSON;
import com.mialab.mybatis_first_demo.domain.StudentCustom;
import com.mialab.mybatis_first_demo.mapper.StudentMapper;
import com.mialab.mybatis_first_demo.sqlSession.DataConnection;

/**
 * Servlet implementation class addToMineServlet
 */
@WebServlet("/addToMineServlet")
public class addToMineServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public addToMineServlet() {
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
				
				BigInteger textID=new BigInteger(request.getParameter("textID"));
				int myID=Integer.parseInt(request.getParameter("myID"));
				int userID=Integer.parseInt(request.getParameter("userID"));
				SqlSession session=null;
				
				if(textID!=null&&userID!=0) {
					try {
						DataConnection connection=new DataConnection();
						session=connection.getSession();
						StudentMapper mapper=connection.getStudentMapper(session);
						int count =mapper.addToMine(myID,userID,textID);
						session.commit();
						if(count!=0) {
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
						
						
						
					}catch (Exception e) {
						System.out.println("addToMine has error"+e.getMessage());
					}
					finally {
						if(session!=null) {
							session.close();
						}
					}
					
				}
				
				
				
	}

}
