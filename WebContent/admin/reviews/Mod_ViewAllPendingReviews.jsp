<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@page import="able.dbclass.TbModReviewDb"%>
<%@page import="java.util.ArrayList"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<% out.println("Pending Reviews"); %>

<form>
<%

ArrayList alist = (ArrayList) session.getAttribute("record");
int i = 0;
while(i < alist.size())
{
	TbModReviewDb data = (TbModReviewDb) alist.get(i);
%> <br/><br/><b><%
	out.println("Review Link Id :" + data.getMod_linkid() +
	"Link :" + data.getMod_link() +
	"Type Of Disability :" + data.getMod_link_type() +
	"Post Date :" + data.getMod_linkdate() + 
	"Posted By :" + data.getMod_email() +
	"Description :" + data.getMod_description());
	int mod_linkid = data.getMod_linkid();
	out.println("<a href=\"./Mod_DeleteAllPendingReviews?mod_linkid="+mod_linkid+"\">Delete</a>");
	out.println("<a href=\"./Mod_AcceptAllPendingReviews?mod_linkid="+mod_linkid+"\">Accept</a>");
	i++;
	 
}
%>
</b>
<br>
<a href="./admin/Admin_Home.jsp">Home Page</a>
</form>
</body>
</html>