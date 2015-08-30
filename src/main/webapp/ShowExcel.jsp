<%@page import="java.io.OutputStream"%>
<%@page import="java.io.FileInputStream"%>
<%@page import="java.io.InputStream"%>
<%@page import="org.xml.sax.InputSource"%>
<%@ page language="java" contentType="application/vnd.ms-excel" 
    pageEncoding="UTF-8"%>

<%

//JSP不能用来做字节流的操作，只能用来操作字符流


String path="resouces/q.xlsx";
String realPath= application.getRealPath(path);
InputStream is = new FileInputStream("E:\\code\\Java\\web\\src\\main\\resources\\q.xlsx");
byte [] res = new byte[is.available()];
is.read(res);

//response.getWritre会调用response.getOutputStream()
//java.lang.IllegalStateException: getOutputStream() has already been called for this response
OutputStream os = response.getOutputStream();
os.write(res);

is.close();
os.close();



//out.print("Hello\t");
//out.println("World\t");





%>


<%="hello" %> 
<%="world"%>
