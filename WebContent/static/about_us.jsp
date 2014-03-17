<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en" lang="en"><head>
<title>Home</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<link rel="Stylesheet" type="text/css" href="/ABLE/css/optimistic.css" />
<!--[if lte IE 6]>
	<script type="text/javascript" language="javascript" src="iehover.js"></script>
<![endif]-->
<link rel="stylesheet" href="/ABLE/css/register.css" type="text/css" />
<!-- script for the login--> 
<link href="/ABLE/css/front.css" media="screen, projection" rel="stylesheet" type="text/css"/>
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
                                <p class="forgot"> <a href="#" id="resend_password_link">Forgot your password?</a> </p>
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
			<!-- TOP MENU -->
            <ul id="mainmenu" name="mainmenu">
				<li><a href="/ABLE/index.jsp"><span>Home</span></a></li>
				<li><a href="/ABLE/register/register.jsp"><span>Register</span></a></li>
				<li><a href="/ABLE/post/submitpost.jsp"><span>Submit Info</span></a></li>
				<li><a href="/ABLE/static/contact.jsp"><span>Contact</span></a></li>
				<li class="active"><a href="/ABLE/static/about_us.jsp"><span>About Us</span></a></li>
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
					<li><a href="orgs.html">Organizations</a></li>
      
			  </ul>      
				<!-- NAVIGATION END -->
			</div>
		</div>
		<div id="bigcontent">

			<div id="content">
				<div>
					<!-- CONTENT START -->
					<p>
					<h2>you are able</h2>
					<p><strong>Join hands in our endeavor to make information accessible to ALL.</strong></p>
					<p><strong>If you are an Organization:</strong>  Your organization is displayed in the  database, immediately. And in the process you also have the opportunity  of displaying all relevant information on a webpage - FREE of any  charge or obligation. If and when you have additional information or  correction to be made just write in to the webmaster and the correction  will be carried out from the ABLE office.<br>
                       <strong>As an individual: </strong>   you have the choice of reading the  full text of the various Acts legislated by the parliament; about the  national organizations and the work they do; up-to-date news on  scientific developments around the world and events happening in India;  about an ever growing list of litigations for your reference and  information; interesting articles on Issues in Inclusion and much more. <br>
							   Explore the site! Send in your suggestions for inclusion of more information, and criticism for improvement. </p>
                    <blockquote>
                        <a href="#"><p>Return to Top</p></a>
                    </blockquote>
				</div>
			</div>
		</div>
		<div id="footer">
			<p><!-- COPYRIGHT INOFRMATION -->Content &copy; 2010 squareOne.<!-- COPYRIGHT INOFRMATION END -->Design &copy; squareOne Amrita School Of Engg.</p>
		</div>

	</div>

</body>
</html>
