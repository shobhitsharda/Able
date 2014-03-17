<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%
String check = (String) session.getAttribute("check");
if(check == "2")	//submit the standard info
{
	out.println("Unable to submit the standard info. Try Again");
}
session.setAttribute("check",null);
%>
<br><a href ="/ABLE/admin/Admin_Home.jsp">Admin Home Page</a><br>
<a href ="/ABLE/index.jsp">Home Page</a><br>
</body>
</html>