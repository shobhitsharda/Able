<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@page import="able.dbclass.TbPostDb"%>
<%@page import="java.util.ArrayList"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<% out.println("Accepted post"); %>

<form>
<%

ArrayList alist = (ArrayList) session.getAttribute("record");
int i = 0;
while(i < alist.size())
{
	TbPostDb data = (TbPostDb) alist.get(i);
%> <br/><br/><b><%
	out.println("Post Id :" + data.getPostid() +
	"Title :" + data.getTitle() +
	"Posted On :" + data.getPostdate() +
	"Post By :" + data.getEmail() + 
	"Content :" + data.getContent() +
	"Tag :" + data.getTags());
	int mod_postid = data.getPostid();
	out.println("<a href=\"./Mod_DeleteAllAcceptedPost?mod_postid="+mod_postid+"\">Delete</a>");
	i++;
	 
}
%>
</b>
<br>
<a href="./admin/Admin_Home.jsp">Home Page</a>
</form>

</body>
</html>