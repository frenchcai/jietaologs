package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;

import com.alibaba.fastjson.JSON;
import com.mialab.mybatis_first_demo.domain.shareText;
import com.mialab.mybatis_first_demo.mapper.TextMapper;
import com.mialab.mybatis_first_demo.sqlSession.DataConnection;

/**
 * Servlet implementation class searchTextServlet
 */
@WebServlet("/searchTextServlet")
public class searchTextServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public searchTextServlet() {
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
		String condition=request.getParameter("condition");
		String searchfactor=request.getParameter("searchfactor");
		
		DataConnection connection=new DataConnection();
		SqlSession sqlSession=null;
		List<shareText>texts=new ArrayList<shareText>();
		
		try {
			sqlSession=connection.getSession();
			TextMapper mapper=connection.getMapper(sqlSession);
			
			 switch(condition){
	            case "1":
	               shareText text=new shareText();
	               text.setText(searchfactor);
	               texts =mapper.searchText(text);
	               sqlSession.commit();
	               
	                break;
	            case "2":
	                System.out.println('b');
	                
	                shareText text3=new shareText();
		               text3.setUsername(searchfactor);
		               texts =mapper.searchText(text3);
		               sqlSession.commit();
	                	
	                break;
	            case "3":
	                System.out.println('c');
	                
	                shareText text2=new shareText();
		            text2.setTitle(searchfactor);
		            texts =mapper.searchText(text2);
		            sqlSession.commit();
	                
	                
	                break;
	            case "4":
	                System.out.println("d");
	                
	                shareText text4=new shareText();
		               text4.setDate(searchfactor);
		               texts =mapper.searchText(text4);
		               sqlSession.commit();
	                break;
			
			
			
		}
			
			 	String jsonString = JSON.toJSONString(texts);  
				response.setCharacterEncoding("UTF-8");  
				response.setContentType("application/json; charset=utf-8");  
				PrintWriter writer = response.getWriter();
				System.out.println(jsonString);
				writer.append(jsonString);
				writer.close();
			
			
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		finally {
			if(sqlSession!=null) {
				sqlSession.close();
			}
		}
		
		       //char类型字符
	} 

}
