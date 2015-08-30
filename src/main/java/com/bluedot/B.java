package com.bluedot;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class B
 */
public class B extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		 
	  	req.setCharacterEncoding("utf-8");//tomcat容器默认从body取数据用:iso-8859-1
    	String userName = req.getParameter("userName");
    	String  userBrith = req.getParameter("userBirth");
    	
    	String attr =(String) req.getAttribute("a");
    	
    	System.out.println("设置的属性："+attr);
    
        String qurey = req.getQueryString();
    	
    	System.out.println(userName);
    	
    	String [] likes = req.getParameterValues("like");
    	
    	System.out.println("request对象的hashcode为："+req.hashCode());
		resp.setContentType("text/html;charset=utf-8");
    	PrintWriter out = resp.getWriter();
    	
    	out.print("<html><body>");
    	out.print("你注册的信息是：<br />");
    	out.print("你的名字是："+userName+"<br />");
    	out.print("你的生日是："+userBrith+"<br />");
    	
    	out.print("你的爱好是：");
    	
    	if(likes != null)
    	{
	    	for(String like:likes)
	    	{
	    		out.print("<li>"+like+"</li>");
	    		
    	}
    	}
    	out.print("你好");
    	out.print(qurey);
    	out.print("</body></html>");
    	out.flush();
    	out.close();
    	
    	System.out.println("你好！");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
