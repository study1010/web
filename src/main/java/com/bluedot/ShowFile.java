package com.bluedot;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ShowFile
 */
public class ShowFile extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ShowFile() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		response.setContentType("text/html;charset=utf-8");
		ServletContext context = getServletContext();

		String path = context.getInitParameter("file");
		File file = new File(path);
		File[] fs = file.listFiles();

		PrintWriter out = response.getWriter();

		for (File f : fs) {
			out.print("<li><a href=\"download.action?name="+f.getName()+"\">" + f.getName() + "</a></li>");

		}
	}



}
