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
if(check == "1")	//mod accept all pending reviews
{
	out.println("ERROR in displaying all pending reviews");
}
else if(check == "2")// mod deleting all pending reviews
{
	out.println("ERROR in deleting all pending reviews");
}
else if(check == "3")// mod view all pending reviews
{
	out.println("ERROR in Viewing all pending reviews");
}
else if(check == "4")// mod submitting reviews
{
	out.println("ERROR in submitting reviews");
}
else if(check == "5")// mod delete all accepted reviews
{
	out.println("ERROR in deleting all accepted reviews");
}
else if(check == "6")// mod viewing all accepted reviews
{
	out.println("ERROR in viewing all accepted reviews");
}
session.setAttribute("check",null);
%>
<a href="/ABLE/admin/user/Admin_Home.jsp">Admin Home Page</a><br>
<a href="/ABLE/index.jsp">Home Page</a>
</body>
</html>