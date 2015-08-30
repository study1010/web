package com.bluedot;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Firstcookie
 */
public class Firstcookie extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		request.setCharacterEncoding("utf-8");
		boolean flag = false;
		//是否含有cookie，只会获得本域名对应的cookie,因为浏览器请求的时候只会将本网站的cookie封装并传递
		
		Cookie []cookies = request.getCookies();
		
		String str = "欢迎你第一次光临！";
		if(cookies != null)
		{
			for(Cookie c:cookies)
			{
				if("visited".equals(c.getName())){
					flag = true;
					break;
				}
			}
		}
		
		
		if(flag)
		{
			
			str="欢迎再次回来！";
		}else {
			Cookie c= new Cookie("visited","true");//key和value，只能是英文和数字
			c.setMaxAge(60*60*24); //设置cookie的保持时间
			response.addCookie(c);
		}
		
		
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out= response.getWriter();
		
		out.print("<h1>"+str+"</h1>");
	}



}
