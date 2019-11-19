package servlet;

import java.io.File;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;

import com.alibaba.fastjson.JSON;
import com.mialab.mybatis_first_demo.mapper.StudentMapper;
import com.mialab.mybatis_first_demo.sqlSession.DataConnection;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
/**
 * Servlet implementation class addTextServlet
 */
@WebServlet("/insertPicPathServlet")
public class insertPicPathServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public insertPicPathServlet() {
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
//		SqlSession session=null;
//		String text=request.getParameter("text");
//		String title=request.getParameter("title");
//		String username=request.getParameter("username");
//		Integer userID=Integer.parseInt(request.getParameter("userID"));
//		Integer date=Integer.parseInt((String)request.getAttribute("date"));
//		Integer userID=Integer.parseInt((String)request.getAttribute("userID"));
		String picpath1=null;
		String picpath2=null;
		String username=request.getParameter("username");
		//为解析类提供配置信息 
		List<String>picpath=new ArrayList<String>();
		int num=0;
		DiskFileItemFactory factory = new DiskFileItemFactory();
		//创建解析类的实例 
		ServletFileUpload sfu = new ServletFileUpload(factory); 
		//开始解析 
		sfu.setFileSizeMax(10485760); 
		//10M
		//每个表单域中数据会封装到一个对应的FileItem对象上 
		try { 
		List<FileItem> items = sfu.parseRequest(request); 
		//区分表单域 
		for (int i = 0; i <items.size(); i++) { 
		FileItem item = items.get(i); 
		//isFormField为true，表示这不是文件上传表单域 
		if(!item.isFormField()){ 
		ServletContext sctx = getServletContext(); 
		if(sctx!=null) {
			//获得存放文件的物理路径 
			//upload下的某个文件夹 得到当前在线的用户 找到对应的文件夹 
			String path = sctx.getRealPath("/images"); 
			System.out.println(path); 
			//获得文件名 
			String fileName = item.getName(); 
			System.out.println(fileName); 
			//该方法在某些平台(操作系统),会返回路径+文件名 
			fileName = fileName.substring(fileName.lastIndexOf("\\")+1); 
			File file = new File(path+"\\"+username+"\\"+fileName); 
			item.write(file); 
			//将上传图片的名字记录到数据库中 
			System.out.println("okwrite");
			System.out.println(file.getPath());
			request.setAttribute("picpath"+(i+1),fileName);
			System.out.println("picpath"+(i+1));
			picpath.add(fileName);
			num=i+1;
//			DataConnection conn=new DataConnection();
//			SqlSession sessionConnection=conn.getSession();
//			StudentMapper mapper=sessionConnection.getMapper(StudentMapper.class);
//			mapper.addPic(userID, picpath1, picpath2)

			
			
			
		}
		
		
		} 
		} 
		
		String jsonString = JSON.toJSONString(picpath);  
		response.setCharacterEncoding("UTF-8");  
		response.setContentType("application/json; charset=utf-8");  
		PrintWriter writer = response.getWriter();
		writer.append(jsonString);
		writer.close();
		
		
		//request.getRequestDispatcher("/successLanding.jsp?num="+num).forward(request, response);
		} catch (Exception e) { 
		e.printStackTrace(); 
		} 

		
	}

}
