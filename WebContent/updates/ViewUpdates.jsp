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
<%
ArrayList alist = (ArrayList) session.getAttribute("record");
int i = 0;
while(i < alist.size())
{
	TbRecentUpdatesDb data = (TbRecentUpdatesDb) alist.get(i);
%> <br/><br/><b><%
	out.println("Titile :" + data.getUpdatetitle() +
	"Content :" + data.getUpdatecontent());
	i++;
}
%></b>
<a href = "./index.jsp">Home Page</a>
</body>
</html>