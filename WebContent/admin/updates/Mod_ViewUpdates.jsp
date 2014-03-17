<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@page import="able.dbclass.TbRecentUpdatesDb"%>
<%@page import="java.util.ArrayList"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<% out.println("View list of all organization"); %>

<form>
<%

ArrayList alist = (ArrayList) session.getAttribute("record");
int i = 0;
while(i < alist.size())
{
	TbRecentUpdatesDb data = (TbRecentUpdatesDb) alist.get(i);
%> <br/><br/><b><%
out.println("Update ID :" + data.getUpdateid() +
		"Title :" + data.getUpdatetitle() +
		"Content :" + data.getUpdatecontent());

	int mod_updateid = data.getUpdateid();
	out.println("<a href=\"./Mod_DeleteUpdates?mod_updateid="+mod_updateid+"\">Delete</a>");
	i++;
	 
}
%>
</b>
<br>
<a href="./admin/Admin_Home.jsp">Home Page</a>
</form>

</body>
</html>