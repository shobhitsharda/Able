<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
Organization Details
<form action = "/ABLE/Mod_SubmitOrganization" method=POST>
Name :<input type="text" name="orgname"><br>
Address : <input type="text" name="orgaddress"><br>
City :<input type="text" name="orgcity"><br>
Pincode :<input type="text" name="orgpincode"><br>
Phone :<input type="text" name="orgphone"><br>
Website :<input type="text" name="orgwebsite">
<input type="submit" name="submit"/>
</form>
</body>
</html>