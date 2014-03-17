<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@page import="able.dbclass.TbModPostDb"%>
<%@page import="java.util.ArrayList"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<% out.println("Pending post"); %>

<form>
<%

ArrayList alist = (ArrayList) session.getAttribute("record");
int i = 0;
while(i < alist.size())
{
	TbModPostDb data = (TbModPostDb) alist.get(i);
%> <br/><br/><b><%
	out.println("Post Id :" + data.getMod_postid() +
	"Title :" + data.getMod_title() +
	"Posted On :" + data.getMod_postdate() +
	"Post By :" + data.getMod_email() + 
	"Content :" + data.getMod_content() +
	"Tag :" + data.getMod_tags());
	int mod_postid = data.getMod_postid();
	out.println("<a href=\"./Mod_DeleteAllPendingPost?mod_postid="+mod_postid+"\">Delete</a>");
	out.println("<a href=\"./Mod_AcceptAllPendingPost?mod_postid="+mod_postid+"\">Accept</a>");
	i++;
	 
}
%>
</b>
<br>
<a href="/ABLE/admin/Admin_Home.jsp">Home Page</a>
</form>
</body>
</html>