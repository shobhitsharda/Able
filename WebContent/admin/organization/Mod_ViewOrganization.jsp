<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@page import="able.dbclass.TbOrganizationDb"%>
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
	TbOrganizationDb data = (TbOrganizationDb) alist.get(i);
%> <br/><br/><b><%
out.println("Organization ID :" + data.getOrgid() +
		"Name :" + data.getOrgname() +
		"Address :" + data.getOrgaddress() +
		"City :" + data.getOrgcity() +
		"Pincode :" + data.getOrgpincode() +
		"Phone No :" + data.getOrgphone() +
		"Website :" + data.getOrgwebsite());

	int mod_orgid = data.getOrgid();
	out.println("<a href=\"./Mod_DeleteOrganization?mod_orgid="+mod_orgid+"\">Delete</a>");
	i++;
	 
}
%>
</b>
<br>
<a href="./admin/Admin_Home.jsp">Home Page</a>
</form>
</body>
</html>