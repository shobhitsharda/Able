<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">

	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<title>Register</title>
		<link rel="Stylesheet" type="text/css" href="/ABLE/css/optimistic.css" />
		<link rel="stylesheet" href="/ABLE/css/register.css" type="text/css" />
		<link rel="stylesheet" href="/ABLE/css/front.css" type="text/css" />
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
        <link type="text/css" rel="stylesheet" href="/ABLE/css/jquery.modaldialog.css" />
		<script type="text/javascript" language="JavaScript" src="/ABLE/javascripts/prettify.js"> </script>

        <link type="text/css" rel="stylesheet" href="/ABLE/css/prettify.css" />
        <script type="text/javascript" language="JavaScript" src="jquery-latest.js"> </script>
        <script type="text/javascript" language="JavaScript" src="jquery modal.js"> </script>
        
        <script type="text/javascript" language="JavaScript" src="jquery.modaldialog.js"> </script>
        <head>
        <script type="text/javascript" language="JavaScript">
                $().ready(function(){
                    prettyPrint();
                });
            </script>
        <script type="text/javascript">
		function validate()
			{
				valid = true;
					if(document.reg_menu.firstname.value=="")
					{
						alert("Please enter first name!");
						return false;
					}
					else if(document.reg_menu.lastname.value=="")
					{
						alert("Please enter last name!");
						return false;
					}
					else if(document.reg_menu.email.value=="")
					{
						alert("Please enter user name!");
						return false;
					}
					else if(document.reg_menu.password1.value=="")
					{
						alert("Please enter password!");
						return false;
					}
					else if(document.reg_menu.password2.value != document.reg_menu.password1.value)
					{
						alert("Passwords don`t match. Please re-enter");
						return false;
					}
					else if(document.reg_menu.age.value=="")
					{
						alert("Please enter age!");
						return false;
					}
				else
				{
				return true;
				}
			}
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
                                <p><label for="username">Email</label><input id="email" name="email" value="" title="email"	tabindex="4" type="text"/></p>
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
              <li class="active"><a href="/ABLE/register/register.jsp"><span>Register</span></a></li>
              <li><a href="/ABLE/post/submitpost.jsp"><span>Submit Info</span></a></li>
              <li><a href="/ABLE/static/contact.jsp"><span>Contact</span></a></li>
              <li><a href="/ABLE/static/about_us.jsp"><span>About Us</span></a></li>
            </ul>
		    <!-- TOP MENU END -->
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
				if(session.getAttribute("email") == null)
				{
			%>
				<!-- CONTENT START -->
						<h2>Registration Form
				<!-- CONTENT END -->
						</h2>
						<div id="regform">
							<fieldset id="reg_menu">
								<form name="reg_menu" method="post" onsubmit="return validate();" action="/ABLE/Register">
									<table width="600"> <tr><td width="300"><label for="firstname" style="font-size:17px">First Name : </label></td>
														   	<td width="200"><input id="firstname" name="firstname" value="" title="firstname"  type="text" /></td>
														</tr>
                                                        
														<tr><td><label  id="lastname" style="font-size:17px">Last Name : </label></td>
															<td><input id="lastname" name="lastname" value="" title="lastname"  type="text" /></td>
														</tr>
                                                        
														<tr><td><label id="email" style="font-size:17px">Email ID: </label></td>
															<td><input id="email" name="email" value="" title="email"  type="text" /></td>
														</tr>
                                                        
														<tr><td><label id="password" style="font-size:17px">Password : </label></td>
															<td><input id="password1" name="password1" value="" title="password" type="password" /></td>
														</tr>
                                                        
														<tr><td><label id="password" style="font-size:17px">Retype Password : </label></td>
															<td><input id="password2" name="password2" value="" title="password2"  type="password" /></td>
														</tr>
                                                        
														<tr><td><label id="age" style="font-size:17px">Age : </label></td>
															<td><input id="age" name="age" value="" title="age" type="text" /></td>
														</tr>
                                                        
                                                        <tr><td><label style="font-size:17px">Sex : </label></td>
                                                            <td><input type="radio" id="sex" name="sex" value="M" title="sex"  /> Male
                                                                <input type="radio" id="sex" name="sex" value="F" title="sex" />Female</td>
                                                            <br />
                                                        </tr>
														<tr><td><label id="type" style="font-size:17px">Type of User: </label></td>
															<td><select name="usertype" id="usertype">
																	<option selected>(please choose one)</option>
																	<option>General User</option>
																	<option>Specialist</option>
																	<option>NGO/other organization</option>
																</select>
															</td><br>
														</tr>
                                                        
														<tr><td><label id="type" style="font-size:17px">Do you face a challenge? If yes, please do specify : </label></td>
															<td><input id="type" name="type" value="" title="type" type="text" /></td>
														</tr>
									</table>
									<p></p>
									<input type="checkbox" name="sendInfo" style="font-size:17px" />
									<label id="type" style="font-size:17px">&nbsp;Please send me notifications regarding important events.</label><br />
									<p></p>
									<input id="reg_submit" type="submit" style="background-image:url(/ABLE/images/bg3.gif)" value="Create An account"/>
									<input id="reg_reset" type="reset" style="background-image:url(/ABLE/images/bg3.gif)" value="Reset"/>
								</form>
							</fieldset>
						</div>
						<% }
							else
							{
								out.println("You are logged in. Please logout to register an account.");
							}
						%>
						
					</div>
				</div>
			</div>
			<h1><!-- YOUR WEBSITE NAME --></h1>
	        <div id="footer">
				<p><!-- COPYRIGHT INOFRMATION -->Content &copy; 2010 squareOne.<!-- COPYRIGHT INOFRMATION END -->Design &copy; squareOne Amrita School Of Engg.</p>
			</div>
		</div>
</body>
</html>