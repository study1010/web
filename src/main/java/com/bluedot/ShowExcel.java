package com.bluedot;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ShowExcel
 */
public class ShowExcel extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	@Override
	public void init() throws ServletException {
		// TODO Auto-generated method stub
		
		ServletConfig config = getServletConfig();
		
		config.getInitParameter("fileName");
		
		ServletContext context = getServletContext();
		context.setAttribute("num",new Integer(1));
		
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		response.setContentType("application/vnd.ms-excel");
		
	
		/*ServletContext 是servlet的上下文对象 ，生命周期，单例Singleton
		1、全局的容器 setAttribute("key",Object obj) getAttribute(key),相当于list
		2、相对路径转绝对路径
		3、获取容器的附加信息，容器的名字
		4、获取初始化参数
		*/
		
	
		ServletContext context = getServletContext();
		String path = "resource/q1.xlsx";
		//返回容器的目录+项目的目录+相对路径
		String realPath = context.getRealPath(path);
		
		System.out.println(realPath);
		
		
		InputStream is = new FileInputStream(realPath);
		
		//tomcat  ..../webapps/web/resource/aa.jpg
		byte [] res = new byte[is.available()];
		is.read(res);
		
		OutputStream os = response.getOutputStream();
		os.write(res);
		
		is.close();
		os.close();

		
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
	    PrintWriter out = response.getWriter();
		
		 synchronized (this) {
			int i = ((Integer)getServletContext().getAttribute("num")).intValue();

			out.print("你是第"+(i++)+"访问网页的用户");
			getServletContext().setAttribute("num",i);
		}
		
		out.flush();
		out.close();
	}

}
