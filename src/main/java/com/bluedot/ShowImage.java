package com.bluedot;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Properties;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * Servlet implementation class ShowImage
 */
public class ShowImage extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		response.setContentType("image");
		
		//ServletContext不要放业务数据，1.线程不安全、共享、昂贵
		ServletContext  context = getServletContext();
		Properties prop = (Properties)context.getAttribute("conf");
		
		String path = prop.getProperty("filePath");
		System.out.println(path);
	
		InputStream is = new FileInputStream(path+"/1.png");
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
	}

}
