<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@page import="able.dbclass.TbRulesDb"%>
<%@page import="java.util.ArrayList"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<form>
<%
ArrayList alist = (ArrayList) session.getAttribute("record");
int i = 0;
while(i < alist.size())
{
	TbRulesDb data = (TbRulesDb) alist.get(i);
%> <br/><br/><b><%
	out.println("Rule Id :" + data.getRuleid() +
	"Rule Title :" + data.getRuletitle() +
	"Rule Content :" + data.getRulecontent());
	
	int rule_id = data.getRuleid();
	out.println("<a href=\"./Mod_DeleteRules?rule_id="+rule_id+"\">Delete</a>");
	i++; 
}
%>
</b>
<br>
<a href="./admin/Admin_Home.jsp">Home Page</a>
</form>

</body>
</html>