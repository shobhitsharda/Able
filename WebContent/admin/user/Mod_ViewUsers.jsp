<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@page import="able.dbclass.TbUserDb"%>
<%@page import="java.util.ArrayList"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<form>
<%
ArrayList alist = (ArrayList) session.getAttribute("record");
int i = 0;
while(i < alist.size())
{
	TbUserDb data = (TbUserDb) alist.get(i);
%> <br/><br/><b><%
	out.println("First Name :" + data.getFirstname() +
	"Last Name :" + data.getLastname() +
	"Email :" + data.getEmail() +
	"Age :" + data.getAge() + 
	"Sex :" + data.getSex() +
	"User Type :" + data.getUsertype() +
	"Password :" + data.getPassword());
	out.println("<a href=\"./Mod_DeleteUsers?email="+data.getEmail()+"\">Delete</a>");
	i++; 
}
%>
</b>
<br>
<a href="./admin/Admin_Home.jsp">Home Page</a>
</form>
</body>
</html>