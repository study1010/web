<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
<%@ page contentType="text/html;" pageEncoding="utf-8" language="java" import="java.sql.*" errorPage="error.jsp"  isErrorPage="true" session="false" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />

<!-- pageEncoding=utf-8的作用: 转换JSP为servlet的时候用什么编码 ,设置response的编码为utf-8 -->

<title>主页</title>
</head>

<body>

<%!
	int i =100;    //成员变量,谨慎使用，因为线程不安全
	String str ="abcd";
	public int add(int x,int y){ //成员方法，一般定义标签里面定义的都是定义方法
		return x +y;
	}  
%>

<% String str2="abcd";  //放在service方法中,必须放在赋值标签的前面 
	if(true)
	{
		//out.write("<h2>Hello world</h2>") //这样也是可以用的
		%> <h2>Hello world</h2><% 
	}

%> 


<%
 for(int j =1;j<=10;j++){
	 %> <a href="<%=j %>.jsp">图片<%=j %></a><%  } %> 
<!-- 脚本标签和声明标签里面一定要写分号 -->
<%SimpleDateFormat format = new SimpleDateFormat("yy-MM-dd HH:mm:ss");
int i = 1/0;
%>
<h1>Hello World! <%= format.format(new Date()) %>  </h1>

<!-- 赋值标签是放在out.write中的 -->
<h1> <%= str %>,<%=add(22,33) %>,<%=str2 %></h1>
</body>
</html>
