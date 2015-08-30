package com.bluedot;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ClientCount
 */
public class ClientCount extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		request.setCharacterEncoding("utf-8");
		boolean flag = false;
		//是否含有cookie，只会获得本域名对应的cookie,因为浏览器请求的时候只会将本网站的cookie封装并传递
		
		Cookie []cookies = request.getCookies();
		Cookie client = null ;
		
		if(cookies != null)
		{
			for(Cookie cookie:cookies)
			{
				if("num".equals(cookie.getName())){
					client=cookie;
					flag = true;
					break;
				}
			}
		}
		int num = 1;

		if(flag)
		{
		
			String value=client.getValue();
			num= Integer.parseInt(value);
		}		
			
		
		Cookie newCookie= new Cookie("num",(num+1)+"");//key和value，只能是英文和数字
		newCookie.setMaxAge(60*60*24); //设置cookie的保持时间
		response.addCookie(newCookie);
		
		
		
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out= response.getWriter();
		
		out.print("<h1>你是第"+num+"次访问本网站</h1>");
		
		
	}


}
