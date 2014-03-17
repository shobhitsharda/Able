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
if(check == "1")	//mod accept all pending post
{
	out.println("ERROR in Accepting all pending posts");
}
else if(check == "2") //mod delete all pending post
{
	out.println("ERROR in deleting all pending post");
}
else if(check == "3") //mod display all pending post
{
	out.println("ERROR in displaying all pending post");
}
else if(check == "4") //mod submiting post
{
	out.println("ERROR in submitting all post");
}
else if(check == "5") //mod delete all accepted post
{
	out.println("ERROR in deleting all accepted post");
}
else if(check == "6") //mod view all accepted post
{
	out.println("ERROR in Viewing all accepted post");
}
session.setAttribute("check",null);
%>
<a href="/ABLE/admin/user/Admin_Home.jsp">Admin Home Page</a><br>
<a href="/ABLE/index.jsp">Home Page</a>
</body>
</html>