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
import javax.websocket.Session;

import org.apache.ibatis.session.SqlSession;

import com.alibaba.fastjson.JSON;
import com.mialab.mybatis_first_demo.domain.Count;
import com.mialab.mybatis_first_demo.domain.Student;
import com.mialab.mybatis_first_demo.domain.shareText;
import com.mialab.mybatis_first_demo.mapper.TextMapper;
import com.mialab.mybatis_first_demo.sqlSession.DataConnection;

/**
 * Servlet implementation class queryAllStudentServlet
 */
@WebServlet("/queryAllTextServlet")
public class queryAllTextServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public queryAllTextServlet() {
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
		int begin=Integer.parseInt((String)request.getParameter("begin"));
		System.out.println(begin);
		
		int num=Integer.parseInt((String)request.getParameter("num"));
		System.out.println(num);
		int count=0;
//		Student count1=new Student(String.valueOf(count),"sex","num","kk","ss","99");
		
//		count1.setName(String.valueOf(count));
		SqlSession sqlSession=null;
		DataConnection connection=new DataConnection();
		try {
			sqlSession=connection.getSession();
			TextMapper mapper=connection.getMapper(sqlSession);
		//	count=mapper.getNumStudent();
			count=mapper.getNumText();
			
			Count count1=new Count(count);
			String jsonCount = JSON.toJSONString(count1); 
//			sqlSession.commit();
			int page=count/num;
			System.out.println(page);
			List<shareText>students=new ArrayList<shareText>();
			if(page<1) {
				//只有一页的时候，不能加载更多了
				if(begin==1) {
					students=mapper.queryAllText(0, count);
				}
					
					System.out.println(students);
					
					sqlSession.commit();
					System.out.println(students);
//					request.setAttribute("students", students);
//					List<Count>counts=new ArrayList<Count>();
//					counts.add(count1);
					String jsonString = JSON.toJSONString(students);  
//					String jsonString2 = JSON.toJSONString(counts);  
					response.setCharacterEncoding("UTF-8");  
					response.setContentType("application/json; charset=utf-8");  
					PrintWriter writer = response.getWriter();
					String jsonString3=jsonString.substring(1);
					String aString="["+jsonCount+","+jsonString3;
					writer.append(aString);
					writer.close();
				
				
				
			}else {
				
				if(begin==0) {
					
			
						students=mapper.queryAllText(begin, num);
						sqlSession.commit();
						System.out.println("hereeee");
						
						String jsonString = JSON.toJSONString(students);  
						response.setCharacterEncoding("UTF-8");  
						response.setContentType("application/json; charset=utf-8");  
						PrintWriter writer = response.getWriter();
						String jsonString3=jsonString.substring(1);
						String aString="["+jsonCount+","+jsonString3;
						System.out.println(aString);
						
						writer.append(aString);
	
						writer.close();
					
					

					
				}else {
					System.out.println("herebbbb");
						students=mapper.queryAllText(num*(begin-1),num);
						sqlSession.commit();
//						request.setAttribute("students", students);
	
						System.out.println(students);
						String jsonString = JSON.toJSONString(students);  
						response.setCharacterEncoding("UTF-8");  
						response.setContentType("application/json; charset=utf-8");  
						PrintWriter writer = response.getWriter();
						String jsonString3=jsonString.substring(1);
						String aString="["+jsonCount+","+jsonString3;
						writer.append(aString);
						writer.close();
					
				}
				
				
				
				
			}
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
		}catch (Exception e) {
			// TODO: handle exception
		}
		finally {
			if(sqlSession!=null) {
				sqlSession.close();
			}
		}
		
//		int page=count/num;
//		System.out.println(page);
//		if(page<1) {
//			try {
//				sqlSession=connection.getSession();
//				TextMapper mapper=connection.getMapper(sqlSession);
//				List<Student>students=mapper.queryAllStudent(1, count);
//				sqlSession.commit();
////				request.setAttribute("students", students);
//				
//				String jsonString = JSON.toJSONString(students);  
//				response.setCharacterEncoding("UTF-8");  
//				response.setContentType("application/json; charset=utf-8");  
//				PrintWriter writer = response.getWriter();
//				writer.append(jsonString);
//				writer.close();
//			}catch (Exception e) {
//				// TODO: handle exception
//			}
//			
//			finally {
//				if(sqlSession!=null) {
//					sqlSession.close();
//				}
//			}
//			
//			
//		}else {
//			
//			if(begin==1) {
//				
//				try {
//					sqlSession=connection.getSession();
//					TextMapper mapper=connection.getMapper(sqlSession);
//					List<Student>students=mapper.queryAllStudent(1, num);
//					sqlSession.commit();
////					request.setAttribute("students", students);
//					String jsonString = JSON.toJSONString(students);  
//					response.setCharacterEncoding("UTF-8");  
//					response.setContentType("application/json; charset=utf-8");  
//					PrintWriter writer = response.getWriter();
//					writer.append(jsonString);
//					writer.close();
//				}catch (Exception e) {
//					// TODO: handle exception
//				}
//				
//				finally {
//					if(sqlSession!=null) {
//						sqlSession.close();
//					}
//				}
//				
//				
//				
//			}else {
//				try {
//					sqlSession=connection.getSession();
//					TextMapper mapper=connection.getMapper(sqlSession);
//					List<Student>students=mapper.queryAllStudent(num*(begin-1),num);
//					sqlSession.commit();
////					request.setAttribute("students", students);
//					String jsonString = JSON.toJSONString(students);  
//					response.setCharacterEncoding("UTF-8");  
//					response.setContentType("application/json; charset=utf-8");  
//					PrintWriter writer = response.getWriter();
//					writer.append(jsonString);
//					writer.close();
//				}catch (Exception e) {
//					// TODO: handle exception
//				}
//				
//				finally {
//					if(sqlSession!=null) {
//						sqlSession.close();
//					}
//				}
//			}
//			
//			
//			
//			
//		}
//		
		
		
		
		
	}

}
