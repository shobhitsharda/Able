<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@page import="able.dbclass.TbReviewDb"%>
<%@page import="java.util.ArrayList"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<% out.println("Accepted Reviews"); %>

<form>
<%

ArrayList alist = (ArrayList) session.getAttribute("record");
int i = 0;
while(i < alist.size())
{
	TbReviewDb data = (TbReviewDb) alist.get(i);
%> <br/><br/><b><%
	out.println("Review Link Id :" + data.getLinkid() +
	"Link :" + data.getLink() +
	"Type Of Disability :" + data.getLink_type() +
	"Post Date :" + data.getLinkdate() + 
	"Posted By :" + data.getEmail() +
	"Description :" + data.getDescription());
	int mod_linkid = data.getLinkid();
	out.println("<a href=\"./Mod_DeleteAllAcceptedReviews?mod_linkid="+mod_linkid+"\">Delete</a>");

	i++; 
}
%>
</b>
<br>
<a href="./admin/Admin_Home.jsp">Home Page</a>
</form>
</body>
</html>