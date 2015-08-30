package com.bluedot;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/*
Http数据包：
Get /xxx.do?xxx=xxxx&xxx=xxx HTTP/1.1
Accept:zh-CN
Accpet-Language:
key:value
*/





public class RegisterUser extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		doPost(req,resp);
	}

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
    		throws ServletException, IOException {
    	// TODO Auto-generated method stub
    	
    	//只能改变body的编码
    	req.setCharacterEncoding("utf-8");//tomcat容器默认从body取数据用:iso-8859-1
    	String userName = req.getParameter("userName");
    	String  userBrith = req.getParameter("userBirth");
    	Map map = req.getParameterMap();
    	
    
        String qurey = req.getQueryString();
    	
    	System.out.println(userName);
    	
    	String [] likes = req.getParameterValues("like");
    	
    	System.out.println("request对象的hashcode为："+req.hashCode());
    	
    	req.setAttribute("a","object");
    	
       //RequestDispatcher rd= req.getRequestDispatcher("B.atction");
    
       /*1、重定向跳转是2次请求，而转发只有一次请求
         2、转发的地址客户端不会变化，重定向地址栏有变化
         3、转发可以利用request对象传递参数，重定向不可以 
         4、转发只能跳转到自己的服务器，重定向可以通过URL地址跳转到其他的资源
         5、sendRedirect 只能调用一次,sendRedirect并不是马上就跳，还会执行下面的代码
       */
       //rd.forward(req,resp);
       
       //resp.sendRedirect("B.atction");
       //resp.sendRedirect("www.baidu.com");
    	
       //resp.addHeader("Location","http://www.google.com.hk");
       resp.addHeader("Refresh","5;url=http://www.google.com.hk");
    	
    	
    	
    	
    }

}
