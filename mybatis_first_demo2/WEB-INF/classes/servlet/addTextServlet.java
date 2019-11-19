package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;

import com.mialab.mybatis_first_demo.mapper.StudentMapper;
import com.mialab.mybatis_first_demo.mapper.TextMapper;
import com.alibaba.fastjson.JSON;
import com.mialab.mybatis_first_demo.domain.shareText;
import com.mialab.mybatis_first_demo.sqlSession.DataConnection;

/**
 * Servlet implementation class addTextServlet
 */
@WebServlet("/addTextServlet")
public class addTextServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public addTextServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		
		
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//String a=(String)request.getParameter("userID")+(String)request.getParameter("textID");
		int  userID=Integer.parseInt(request.getParameter("userID"));
		BigInteger textID=new BigInteger((String)request.getParameter("textID"));
		String title=request.getParameter("title");
		String rewrite=request.getParameter("rewrite");
		String text=(String)request.getParameter("text");
		String picpath1=request.getParameter("picpath1");
		String picpath2=request.getParameter("picpath2");
		String username=request.getParameter("username");
		SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy年MM月dd日");
		String date=sdf2.format(new Date()); 
		System.out.println("here 1");
		int num_like=0;
		int num_message=0;
		shareText text2=new shareText(userID, textID, title, text, picpath1, picpath2, username, date, num_like,num_message);
		DataConnection connection=new DataConnection();
		SqlSession sqlSession=null;
		if(rewrite==null) {
			System.out.println("here 2");
			
			try {
				
				sqlSession=connection.getSession();
				StudentMapper mapper=connection.getStudentMapper(sqlSession);
//				int a=mapper.updateText(title, text, username, date);
//				mapper.addText(userID, textID, title, text, picpath1, picpath2, username, date, num_like, message);
				mapper.addShareText(text2);
				System.out.println("here 3");
				sqlSession.commit();
				
				System.out.println("here 4");
				Map<String, String> b=new HashMap<String, String>();
				b.put("ok", "ok");
				String jsonString = JSON.toJSONString(b);  
				response.setCharacterEncoding("UTF-8");  
				response.setContentType("application/json; charset=utf-8");  
				PrintWriter writer = response.getWriter();
				System.out.println(jsonString);
				writer.append(jsonString);
				writer.close();
				
			}catch (Exception e) {
				System.out.println("inserttext has error");
			}
			
			finally {
				if(sqlSession!=null) {
					sqlSession.close();
				}
				
			}
			
			
		}else if(rewrite.equals("1")){
			
			try {
			sqlSession=connection.getSession();
			TextMapper mapper=connection.getMapper(sqlSession);
			int a=mapper.reWriteText(text2);
			System.out.println("update");
			sqlSession.commit();
			if(a!=0) {
				Map<String, String> b=new HashMap<String, String>();
				b.put("ok", "ok");
				String jsonString = JSON.toJSONString(b);  
				response.setCharacterEncoding("UTF-8");  
				response.setContentType("application/json; charset=utf-8");  
				PrintWriter writer = response.getWriter();
				System.out.println(jsonString);
				writer.append(jsonString);
				writer.close();
			}else {
				//更新失败
			}
			}catch (Exception e) {
				e.printStackTrace();
			}
			finally {
				if(sqlSession!=null) {
					sqlSession.close();
				}
			}
			
		}
		
		
		
	}

}
