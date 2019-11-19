package servlet;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSON;
import com.sun.org.apache.xml.internal.serializer.utils.StringToIntTable;

/**
 * Servlet implementation class deletePicServlet
 */
@WebServlet("/deletePicServlet")
public class deletePicServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public deletePicServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String picpath=request.getParameter("picpath");
		
		String username=request.getParameter("username");
		System.out.println(picpath);
		String picpath1=picpath.substring(picpath.lastIndexOf("\\")+1);
		
		String picpath2=request.getParameter("picpath2");
		
		ServletContext sctx = getServletContext(); 
		String path = sctx.getRealPath("/images"); 
		if(picpath1!=null&&picpath2==null) {
			//测试
			System.out.println("yizi");
			System.out.println(picpath1);
			
			File file = new File(path+"\\"+username+"\\"+picpath1);
			file.delete();
			System.out.println("success delete");
			Map<String, String> a=new HashMap<String, String>();
			a.put("ok", picpath);
			String jsonString = JSON.toJSONString(a);  
			response.setCharacterEncoding("UTF-8");  
			response.setContentType("application/json; charset=utf-8");  
			PrintWriter writer = response.getWriter();
			
			System.out.println(jsonString);
			writer.append(jsonString);
			writer.close();
			
			
		}else if(picpath1!=null&picpath2!=null) {
			System.out.println(picpath1+picpath2);
			File file1 = new File(path+"\\"+username+"\\"+picpath1);
		
			file1.delete();
			
			File file2 = new File(path+"\\"+username+"\\"+picpath2);
			file2.delete();
			System.out.println("success delete2pic");
			Map<String, String> a=new HashMap<String, String>();
			a.put("ok", picpath);
			String jsonString = JSON.toJSONString(a);  
			response.setCharacterEncoding("UTF-8");  
			response.setContentType("application/json; charset=utf-8");  
			PrintWriter writer = response.getWriter();
			
			System.out.println(jsonString);
			writer.append(jsonString);
			writer.close();
		}
		

	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		
	}

}
