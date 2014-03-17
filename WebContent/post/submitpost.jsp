<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en" lang="en">
<head>
<title>Submit Info </title>
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
		String email = (String)session.getAttribute("email");
		String usertype = (String)session.getAttribute("usertype");
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
<!-- TOP MENU -->
            <ul id="mainmenu" name="mainmenu">
				<li><a href="/ABLE/index.jsp"><span>Home</span></a></li>
				<li><a href="/ABLE/register/register.jsp"><span>Register</span></a></li>
				<li class="active"><a href="/ABLE/post/submitpost.jsp"><span>Submit Info</span></a></li>
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
				<div id="content">
					<div>
					<%
					if(session.getAttribute("email")!=null)
					{
					%>
						<!-- CONTENT START -->
						<h2>Submit Post</h2>
						<form method="post" action="/ABLE/Post">
							<table>	
                              <tr><td><label for="title" style="font-size:17px"> Title </label></td>
                                    <td><input id="title" name="title" value="" title="title" tabindex="4" type="text" /></td>
                                </tr>
                              <tr><td><label id="postcontent" style="font-size:17px">Content</label></td>
                                  <td><textarea class="text" style="font-size:17px" id="postcontent" name="postcontent" rows="10" cols="50"></textarea></td>
                                </tr>
                              <tr><td><label id="category" style="font-size:17px">Category of Post</label></td>
                                    <td><select name="category">
                                      <option selected>(please choose one)</option>
                                      <option>Physical Challenges</option>
                                      <option>Mental Challenges</option>
                                      <option>Legal Information</option>
                                            <option>Organizations</option>
                                        </select>
                                </td><br>
                              </tr>
                              <tr><td><label id="tags" style="font: 17px">Enter tags</label></td>
                                  <td><input id="tag" name="tag" value="" title="tag" type="text" /></td>
							</table>
						  <p></p>
							<input id="reg_submit" type="submit" style="background-image:url(images/bg3.gif)" value="Submit"/>
							<input id="reg_reset" type="reset" style="background-image:url(images/bg3.gif)" value="Reset"/>
						</form>
                        <blockquote>
                            <a href="#"><p>Return to Top</p></a>
                        </blockquote>                        
					</div>

				</div>
				<div id="content">
					<div>
						<!-- CONTENT START -->
						<h2>Submit Site Review</h2>
						<form method="post" action="/ABLE/Reviews">
							<table width="500">
								<tr><td><label for="title" style="font-size:17px">Site Link</label></td>
									<td><textarea "style="font-size:17px" id="link" name="link" rows="1" cols="50"></textarea></td>
								</tr>
								<tr><td><label id="description" style="font-size:17px">Description</label></td>
                                  <td><textarea class="text" style="font-size:17px" id="description" name="description" rows="10" cols="50"></textarea></td>
                                </tr>
								<tr><td width="60"><label for="link_t" style="font-size:17px">Type of disability</label></td>
									<td width="401"><input id="link_type" name="link_type" value="" title="link_type" tabindex="4" type="text" /></td>
								</tr>
							</table>
							<p></p>
							<input id="reg_submit" type="submit" style="background-image:url(images/bg3.gif)" value="Submit"/>
							<input id="reg_reset" type="reset" style="background-image:url(images/bg3.gif)" value="Reset"/>
						</form>
                        <blockquote>
                            <a href="#"><p>Return to Top</p></a>
                        </blockquote>
         <% } 
			else
			{
				out.println("You need to Login to Submit any Info. Please Login");
			%>

		<% } %>				
                                                
					</div>
				</div>
			</div>

	        <div id="footer">
				<p><!-- COPYRIGHT INOFRMATION -->Content &copy; 2010 squareOne.<!-- COPYRIGHT INOFRMATION END -->Design &copy; squareOne Amrita School Of Engg.</p>
			</div>
		</div>
	</body>
</html>