<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en" lang="en">
	<head>
		<title>Password Confirmation</title>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
		<link rel="Stylesheet" type="text/css" href="/ABLE/css/optimistic.css" />
		<!-- script for the login-->
		<link rel="stylesheet" type="text/css" href="/ABLE/css/front.css" media="screen, projection"/>
		<script src="/ABLE/javascripts/jquery.js" type="text/javascript"></script>
		<script type="text/javascript">
			$(document).ready(function() {
				$(".signin").click(function(e) {          
					e.preventDefault();
					$("fieldset#signin_menu").toggle();
					$(".signin").toggleClass("menu-open");
				});
			
				$("fieldset#signin_menu").mouseup(function() {
				return false
				});
				$(document).mouseup(function(e) {
					if($(e.target).parent("a.signin").length==0) {
						$(".signin").removeClass("menu-open");
						$("fieldset#signin_menu").hide();
					}
				});			
			
			});
		</script>
		</head>
		<body>
			<% 
String usertype = (String)session.getAttribute("usertype");
String email = (String)session.getAttribute("email");
%>

    <div id="container">
        <div id="header">
      <% if(email == null && usertype == null)
		{
		%> 

		<div id="login_container">
                      <div id="topnav" class="topnav">Are You An Abler? <a class="signin"><span>Sign in</span></a>
                      </div>
                      <fieldset id="signin_menu">
                            <form method="post" id="signin" action="/ABLE/Login">
                                <p><label for="username">Email</label><input id="email" name="email" value="" title="email" tabindex="4" type="text"/></p>
                                <p><label for="password">Password</label>	      <input id="password" name="password" value="" title="password" tabindex="5" type="password"/></p>
                                <p class="remember">					          <input id="signin_submit" value="Sign in" tabindex="6" type="submit"/>
                                                                                  <input id="remember" name="remember_me" value="1" tabindex="7" type="checkbox"/><label for="remember">Remember me</label>
                                </p>
                                <p class="forgot"> <a href="/ABLE/session/ForgotPass.jsp" id="resend_password_link">Forgot your password?</a> </p>
                            </form>
                      </fieldset>
            </div>
		<%
		}
      
      else if(email != null && usertype.equals("admin"))	
		{
		%>
		<div id="login_container">
                      <div id="topnav" class="topnav"><a href="/ABLE/Mod_Admin_Profile" style="color:#FFFFFF"> Admin Dashboard</a><a class="signout" href="/ABLE/session/logout.jsp"><span>Sign out</span></a>
                      </div>
            </div>
		
		<%
		}
      else if((usertype != "admin") && (email!= ""))
      {%>
		
		<div id="login_container">
                      <div id="topnav" class="topnav"><a href="/ABLE/Profile" style="color:#FFFFFF"> User Dashboard</a><a class="signout" href="/ABLE/session/logout.jsp"><span>Sign out</span></a>
                      </div>
            </div>

	<% }
		%>
				<h1><!-- YOUR WEBSITE NAME --></h1>
					<!-- TOP MENU -->
				<ul id="mainmenu" name="mainmenu">
					<li><a href="/ABLE/index.jsp"><span>Home</span></a></li>
					<li><a href="/ABLE/register/register.jsp"><span>Register</span></a></li>
					<li><a href="/ABLE/post/submitpost.jsp"><span>Submit Info</span></a></li>
					<li><a href="/ABLE/static/contact.jsp"><span>Contact</span></a></li>
					<li><a href="/ABLE/static/about_us.jsp"><span>About Us</span></a></li>
				</ul>
				<p><!-- TOP MENU END --></p>
			</div>
			<div id="column">
				<div>
					<ul class="menu">
					<li><a href="/ABLE/anonymous/physicaldisability/Std_PhysicalDisabilityCloud.jsp">Physical &nbsp;Challenges</a></li>
					<li><a href="/ABLE/anonymous/mentaldisability/Std_MentalDisabilityCloud.jsp">Mental &nbsp;Challenges</a></li>      
					<li><a href="/ABLE/Std_DisplayAllSiteReviews">Site Links</a></li>    
					<li><a href="/ABLE/ViewRules">Legal Info</a></li>
					<li><a href="/ABLE/ViewOrganization">Organizations</a></li>
  
					</ul>      
				    <!-- NAVIGATION END -->
				</div>
			</div>
			<div id="bigcontent">
				<div id="post">
					<!-- CONTENT START -->
					
					<p>
<form action="/ABLE/ForgotPassword" method="post">
<input type = "text" name="email"/>
<input type = "submit" value="Submit" name ="submit"/>
</form>
					<!-- CONTENT END -->
				</div>
     
			</div>
			<div id="footer">
				<p><!-- COPYRIGHT INOFRMATION -->Content &copy; 2010 squareOne.<!-- COPYRIGHT INOFRMATION END -->Design &copy; squareOne Amrita School Of Engg.</p>
			</div>
		</div>
	</body>
</html>
