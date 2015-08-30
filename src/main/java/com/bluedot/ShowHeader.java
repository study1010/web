package com.bluedot;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ShowHeader
 */
public class ShowHeader extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShowHeader() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");//tomcat容器默认从body取数据用:iso-8859-1

		@SuppressWarnings("unchecked")
		Enumeration<String>  list=request.getHeaderNames();
		
		response.setContentType("text/html;charset=utf-8");

		PrintWriter out = response.getWriter();
    	out.print("<html><body>");

		out.print("<table border=\"1\" width=\"50%\"  align=\"center\">");
		out.print("<tr><th>Key</th><th>Value</th></tr>");
		
		//学习一个类的方法，没有必要知道所有类的API，但是要知道这个类提供了什么功能，哪些API是干什么的，都有过一遍
		//学习的方法，先学原理，后学应用，先了解servlet的原理，在学各个类的使用
		String method = request.getMethod();
		String uri = request.getRequestURI();
		String query = request.getQueryString();
		String protocal = request.getProtocol();
		out.print("<tr><td colspan=\"2\" >"+method+" "+uri+" "+query+" "+protocal+"</td></tr>");
		while(list.hasMoreElements())
		{
			String key = list.nextElement();
			String value=request.getHeader(key);
			//死去活来法

			out.print("<tr><td>"+key+"</td><td>"+value+"</td></tr>");
			
		}
		
		out.print("</table>");
		out.print("</body></html>");
    	out.flush();
    	out.close();
    	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
