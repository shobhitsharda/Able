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
if(check == "1")	//delete the user
{
	out.println("ERROR in deleting the user. Try Again");
}
else if(check == "2")	//view user
{
	out.println("ERROR in Viewing the user. Try Again");
}
%>
<br><a href ="/ABLE/admin/Admin_Home.jsp">Admin Home Page</a><br>
<a href ="/ABLE/index.jsp">Home Page</a><br>
</body>
</html>