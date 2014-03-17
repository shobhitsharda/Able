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


  <!--script for the login-->
 
   <!--news ticker-->
   
<script type="text/javascript" src="/ABLE/javascripts/jquery-1.js"></script>
<script type="text/javascript">
$(document).ready(function(){
	
	var first = 0;
	var speed = 700;
	var pause = 3500;
	
		function removeFirst(){
			first = $('ul#listticker li:first').html();
			$('ul#listticker li:first')
			.animate({opacity: 0}, speed)
			.fadeOut('slow', function() {$(this).remove();});
			addLast(first);
		}
		
		function addLast(first){
			last = '<li style="display:none">'+first+'</li>';
			$('ul#listticker').append(last)
			$('ul#listticker li:last')
			.animate({opacity: 1}, speed)
			.fadeIn('slow')
		}
	
	interval = setInterval(removeFirst, pause);
});
</script>
<link href="/ABLE/css/newsticker.css" media="screen, projection" rel="stylesheet" type="text/css"/>

  <!--news ticker ends-->

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
				<li class="active"><a href="/ABLE/index.jsp"><span>Home</span></a></li>
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
        <ul id="listticker">
            <li>
                <img src="/ABLE/img/1.png" />
                <a href="" class="news-title">Health care reform</a>
                <span class="news-text">President Obama has announced three bedrock requirements for real health care reform...</span>
            </li>
            <li>
                <img src="/ABLE/img/logo_watermark.gif" />
                <a href="" class="news-title">Concessions in Air travel</a>
                <span class="news-text">Domestic Air travel rates have been significantly reduced for persons with disabilities...</span>
            </li>
            <li>
                <img src="/ABLE/img/5.png" />
                <a href="" class="news-title">Happy New Year!!</a>
                <span class="news-text">The ABLE team wishes all the challengers a very Happy New Year...!</span>
            </li>
            <li>
                <img src="/ABLE/img/6.png" />
                <a href="" class="news-title">Central Govt benefits</a>
                <span class="news-text">The Central Govt has offered benefits to all deaf Govt servants..</span>
            </li>
        </ul>

			<div id="mcontent">
				<div>
					<!-- CONTENT START -->
					<h2>Welcome !!!</h2>
					<p>&nbsp; &nbsp; &nbsp; &nbsp;In an age when equality is celebrated and individual borders are being blurred, the need to bring people closer than ever has increased manyfold. People with disabilities, or CHALLENGES as we like to think of it, are in dire need of bridging the information gap, and a one-stop portal wherein they can meet, discuss, obtain comprehensive information , the <b><font size="+2">ABLE</font></b> website has been formed exclusively for them.<br><br>
					   &nbsp; &nbsp; &nbsp; &nbsp; <b><font size="+2">ABLE</font></b> is a meeting ground for parents, specialists and like-minded challenged people to think together, seek answers, and discover common ground.</p>
					<p><br>The Network is managed by the Society for Child Development, a registered non-governmental national level organization. The   Network has a dynamic<strong> Register of Services</strong> that is free for the use of all - Nationally and internationally. Thus,   organizations have the benefit of being accessible to those who require their services within the country, and additionally,   have the advantage of being visible to the world outside. Organizations already on the web, with their web sites,   have the supplementary convenience of a link, enhancing their site visibility. <strong>More than 3000 organizations</strong> are already   part of this growing database.<br>
							An interactive <strong>Discussion Board</strong> provides a platform for debates on topical issues.<br></p>
					<h2>YOU are ABLE</h2>
					<p><strong><em>Join hands in our endeavor to make information accessible to ALL.</em></strong></p>
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
