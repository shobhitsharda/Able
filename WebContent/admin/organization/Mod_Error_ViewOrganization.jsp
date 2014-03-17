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
if(check == "1")
{
	out.println("Unable to display the list of organization. Try Again");
}
else if(check == "2")
{
	out.println("Unable to submit the organization details.Try again");
}
session.setAttribute("check",null);
%>
<a href="/ABLE/admin/Admin_Home.jsp">Admin Home Page</a><br>
<a href="/ABLE/index.jsp">Home Page</a><br>
</body>
</html>