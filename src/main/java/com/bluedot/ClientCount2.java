package com.bluedot;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class ClientCount2 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		//sessionid是又request自己管理的，浏览器每次访问的sessionid都不同，不同的浏览器的sessionid也不同
		//换句话说，session是和某一次的浏览器对应的
		HttpSession session = request.getSession();
		Integer num = (Integer) session.getAttribute("num");
		if (num == null) {
			num = 0;  //if ...esle有重复的代码一定要提取出来
		}

		session.setAttribute("num", ++num);
		
		response.setContentType("text/html;charset=utf-8");
    	PrintWriter out = response.getWriter();
    	
    	out.print("<html><body>");
    	out.print("<h1>你是第"+num+"此访问本网站</h1>");//关闭浏览器时第一次访问
    	out.print("</body></html>");
    	
    	/*
    	request:作用域为一次的请求
    	session:作用域为浏览器的生命周期，
    	ServletContext:共用一份，作用于容器生命周期

        */
	}

}
