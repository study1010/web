package com.bluedot;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * Servlet implementation class Download
 */
public class Download extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		ServletContext context = getServletContext();

		String path = context.getInitParameter("file");
		
		request.setCharacterEncoding("utf-8");
		String fileName = request.getParameter("name");
		
		//文件下载
		response.setContentType("bin");
		response.addHeader("Content-Disposition","filename="+fileName+"");
		
		
		//两种方式(字节响应，字符响应)来显示Excel表格
		InputStream is = new FileInputStream(path+"/"+fileName);
		
		byte[] res = new byte[is.available()];
		
		is.read();
		
		OutputStream out = response.getOutputStream();
		out.write(res);
		
		is.close();
		out.close();
		
		
		
		
	}


}
