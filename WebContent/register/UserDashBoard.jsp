<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@page import="able.dbclass.TbUserDb"%>
<html xmlns="http://www.w3.org/1999/xhtml">

	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<title>User Dashboard</title>
		<link rel="Stylesheet" type="text/css" href="/ABLE/css/optimistic.css" />
		<link rel="stylesheet" href="/ABLE/css/register.css" type="text/css" />
        <!--script for login-->
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
        <!--script for login ends-->
        
        <!--script for photo gallery-->
		<script type="text/javascript" src="/js/jquery-1.3.2.min.js"></script>
		<script type="text/javascript" src="/js/jquery.lightbox.min.js"></script>
				<link type="text/css" rel="stylesheet" media="screen" href="/ABLE/css/index.css" />
        <!--script for photo gallery ends-->

		
		
		

    </head>
    
	<body>
		<div id="container">
		  <div id="header">
  			  <div id="login_container">
    	          <div id="topnav" class="topnav"><a href="/ABLE/index.jsp" style="color:#FFFFFF">Back to Home?</a><a class="signout" href="/ABLE/session/logout.jsp"><span>Sign out</span></a>
                  </div>
              </div>
		    <!-- TOP MENU -->
            <ul id="mainmenu" name="mainmenu">
              <li><a href="/ABLE/index.jsp"><span>Home</span></a></li>
              <li><a href="/ABLE/register/register.jsp"><span>Register</span></a></li>
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

<%TbUserDb tudb = (TbUserDb)session.getAttribute("tudb");%>
			<div id="bigcontent">
				<div id="content">
					<div>
				<!-- CONTENT START -->
                		<h2> Welcome <label class="profile" style="color:#FFFFFF"> Square0ne</label> !</h2>
				<!-- CONTENT END -->
					<!-- 	</h2>	 -->
						<div id="regform">
							<fieldset id="reg_menu">
								<form id="regform">
									<table width="500"> <tr><td width="300"><label for="firstname" style="font-size:17px">First Name : </label></td>
														   	<td width="200"><label style="color: #99CC33" for="firstname" style="font-size:17px">
<%out.print(tudb.getFirstname());%></label></td>
														</tr>
                                                        
														<tr><td><label  id="lastname" style="font-size:17px">Last Name : </label></td>
															<td><label style="color:#99CC33" for="lastname" style="font-size:17px">
<%out.print(tudb.getLastname());%></label></td>
														</tr>
                                                        
														<tr><td><label id="username" style="font-size:17px">Email ID: </label></td>
															<td><label style="color: #99CC33" for="username" style="font-size:17px">
<%out.println(tudb.getEmail());%></label></td>
														</tr>
                                                        
														<tr><td><label id="age" style="font-size:17px">Age : </label></td>
															<td><label style="color: #99CC33" for="age" style="font-size:17px">
<%out.println(tudb.getAge());%></label></td>
														</tr>
                                                        
                                                        <tr><td><label style="font-size:17px">Sex : </label></td>
                                                            <td><label style="color: #99CC33" for="sex" style="font-size:17px">
<%out.println(tudb.getSex());%></label></td>
                                                            <br />
                                                        </tr>
														<tr><td><label id="u_type" style="font-size:17px">Type of User: </label></td>
															<td><label style="color: #99CC33" for="type" style="font-size:17px">
<%out.println(tudb.getUsertype());%></label>
															</td><br>
														</tr>
                                                        
												<!--		<tr><td><label id="c_type" style="font-size:17px">Challenge faced: </label></td>
															<td><label style="color: #99CC33" for="c_type" style="font-size:17px">Highly unstable</ label></td>
														</tr> -->
									</table>
									
									                                                        
								</form>
                                
                               
							</fieldset>
	                		<h2>Dashboard of<label class="profile" style="color:#FFFFFF"> <%out.print(tudb.getFirstname());%></label></h2>
                                <blockquote style="width:650px">
                                  <table width="650">
                                    <tr>
                                      <td width="325"><a href="/ABLE/ViewPendingPost" style="font-size:17px">View Pending Posts</a></td>
                                      <td width="325"><a href="/ABLE/ViewAcceptedPost" style="font-size:17px">View Accepted Posts</a></td>
                                    </tr>
                                    <tr>
                                      <td><a href="/ABLE/ViewPendingReviews" style="font-size:17px">View Pending Site links</a> </td>
                                      <td><a href="/ABLE/ViewAcceptedReviews" style="font-size:17px">View Accepted Site Links</a></td>
                                    </tr>
                                  </table>
                                </blockquote>
                            <h2>Do you want to change your password?</h2>
                            <fieldset id="reg_menu">
                                <form action="/ABLE/ChangePassword" method="post">
    
                                      <table width="650">	<tr><td width="300"><label style="font-size:17px">Current password : </label></td>
                                                                <td width="200"><input value="" type="password" name="currentpassword"/></td>
                                                            </tr>
                                                            
                                                            <tr><td width="300"><label style="font-size:17px">New password : </label></td>
                                                                <td width="200"><input value="" type="password" name="newpassword_1"/></td>
                                                            </tr>
                                                            
                                                            <tr><td width="300"><label style="font-size:17px">Retype new password : </label></td>
                                                                <td width="200"><input value="" type="password" name="newpassword_2"/></td>
                                                            </tr>             
                                      </table>
                                                              <input id="reg_submit" type="submit" style="background-image:url(/ABLE/images/bg3.gif)" value="Change password"/>
                                                            <input id="reg_reset" type="reset" style="background-image:url(/ABLE/images/bg3.gif)" value="Reset"/>
    
                                </form>
                            </fieldset>
                            <h2>Photo Gallery</h2>
                        
                            <div class="section">
                    
                                <div class="desc">
                                    <p><span class="title">Gallery tour</span> <span class="code">Click the first image to begin the tour.</span>
                                    </p>
                                </div>
                                <ul style="width:650px">                                   
                                    <li>
                                        <a rel="lightbox-tour" href="/ABLE/disable images/gal_2.jpg" title="Picture 1"><img src="/ABLE/disable images/gal_2_thumb.jpg" alt="" /></a>                </li>
                                    <li>
                                        <a rel="lightbox-tour" href="/ABLE/disable images/gal_3.jpg" title="Picture 2"><img src="/ABLE/disable images/gal_3_thumb.jpg" alt="" /></a>                </li>
                                    <li>                    
                                        <a rel="lightbox-tour" href="/ABLE/disable images/gal_4.jpg" title="Picture 3"><img src="/ABLE/disable images/gal_4_thumb.jpg" alt="" /></a>                </li>
                                    <li>
                                        <a rel="lightbox-tour" href="/ABLE/disable images/gal_5.jpg" title="Picture 4"><img src="/ABLE/disable images/gal_5_thumb.jpg" alt="" /></a>                
                </li>
                                    <li>
                                        <a rel="lightbox-tour" href="/ABLE/disable images/gal_6.jpg" title="Picture 5"><img src="/ABLE/disable images/gal_6_thumb.jpg" alt="" /></a>                </li>
                                    <li>
                    
                                        <a rel="lightbox-tour" href="/ABLE/disable images/gal_7.jpg" title="Picture 6"><img src="/ABLE/disable images/gal_7_thumb.jpg" alt="" /></a>                </li>
                                    <li>
                    
                                        <a rel="lightbox-tour" href="/ABLE/disable images/gal_1.jpg" title="Picture 7"><img src="/ABLE/disable images/gal_1_thumb.jpg" alt="" /></a>                </li>
                                </ul>
            <div class="clear"></div>
        </div>
                          </div>
                                
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