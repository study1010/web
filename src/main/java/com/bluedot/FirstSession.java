package com.bluedot;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class FirstSession
 */
public class FirstSession extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		//session的默认失效时间为30分钟
		//浏览器关闭了，session就找不回来了，因为对应的sessionid丢失了
		//每个浏览器对应一个session
		
		
		/*
		 比较Cookie和Session有那些区别？
		1.数据存储的位置不同，一个在客户端浏览器中，一个在服务器端容器中。
		2.生命周期不同。Cookie（状态，浏览器关闭，持久化，设置的时间）。Session默认30分钟（在Tomcat容器），可以认为修改web.xml文件更改Session的失效时间。
		3.Cookie只能是字符串名值对（只能英文数字），Session存储Java对象。
		4.同一个浏览器接受Cookie是有数目上限的，应为30个左右。理论上Session存放数据没有上限。
		5.安全性。
		*/
		
		
		HttpSession session = request.getSession(false);
		String banner = "";
		
		if(session == null){
			banner = "欢迎你第一次光临!";
			session = request.getSession(true);//创建session
			
		}else {
			banner ="欢迎你再次回来";
		}
		response.setContentType("text/html;charset=utf-8");
    	PrintWriter out = response.getWriter();
    	
    	out.print("<html><body>");
    	out.print("<h1>"+banner+"</h1>");
    	out.print("</body></html>");

	}


}
