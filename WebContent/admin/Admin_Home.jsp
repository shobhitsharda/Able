<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@page import="able.dbclass.TbUserDb"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%out.println("Profile Details are.....!");%><br>
<%TbUserDb tudb = (TbUserDb)session.getAttribute("tudb");%><br>
<%out.println("First Name : " + tudb.getFirstname());%><br>
<%out.println("Last Name : " + tudb.getLastname());%><br>
<%out.println("Age : " + tudb.getAge());%><br>
<%out.println("Sex : " + tudb.getSex());%><br>
<%out.println("User Type : " + tudb.getUsertype());%><br>


<a href="/ABLE/admin/stdinfo/Mod_Std_SubmitInfo.jsp">Submit the Standard Information</a><br>

<a href="/ABLE/Mod_ViewUsers">Moderate the User</a><br><br>

<a href="/ABLE/admin/post/Mod_SubmitPost.jsp">Submit Posts</a><br>
<a href="/ABLE/Mod_ViewAllPendingPost">Moderate the Pending Posts</a><br>
<a href="/ABLE/Mod_ViewAllAcceptedPost">Moderate the Accepted Posts</a><br><br>

<a href="/ABLE/admin/reviews/Mod_SubmitReview.jsp">Submit Reviews</a><br>
<a href="/ABLE/Mod_ViewAllPendingReviews">Moderate the Pending Reviews</a><br>
<a href="/ABLE/Mod_ViewAllAcceptedReviews">Moderate the Accepted Reviews</a><br><br>

<a href="/ABLE/admin/rules/Mod_Submit_Rules.jsp">Submit Rules and Regulations</a><br>
<a href="/ABLE/Mod_ViewRules">Moderate the Rules and Regulations</a><br><br>

<a href="/ABLE/admin/organization/Mod_Submit_Organization.jsp">Submit Oraganizations</a><br>
<a href="/ABLE/Mod_ViewOrganization">Moderate the Organization</a><br><br>

<a href="/ABLE/admin/updates/Mod_Submit_Updates.jsp">Submit Updates</a><br>
<a href="/ABLE/Mod_ViewUpdates">Moderate the Recent Updates</a><br><br>


<form action="/ABLE/ChangePassword" method=POST>
Current Password :<input type="password" name="currentpassword"/><br>
New-Password :<input type="password" name="newpassword_1"/><br>
Retype New-Password :<input type="password" name="newpassword_2"/><br>
<input type="submit" name=submit/>
</form>

<a href = "/ABLE/index.jsp">Home Page</a>
</body>
</html>