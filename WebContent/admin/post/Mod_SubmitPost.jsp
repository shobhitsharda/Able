<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="/ABLE/Mod_SubmitPost" method=POST>
Post Title:<input type="text" name="title"/><br>
Content :<textarea class="text" name="content"></textarea><br>
Enter tag(separate using comma(,)) :<input type="text" name="tag"/><br>
<input type="submit" name="submit"/>
</form>
</body>
</html>