package able.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import able.dbclass.TbUserDb;
import able.helper.CheckProfile;

/**
 * Servlet implementation class for Servlet: Mod_Admin_Profile
 *
 */
 public class Mod_Admin_Profile extends javax.servlet.http.HttpServlet implements javax.servlet.Servlet {
   static final long serialVersionUID = 1L;
   
    /* (non-Java-doc)
	 * @see javax.servlet.http.HttpServlet#HttpServlet()
	 */
	public Mod_Admin_Profile() {
		super();
	}   	
	
	/* (non-Java-doc)
	 * @see javax.servlet.http.HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		try
		{								

			HttpSession sess = request.getSession(true);				//Get the Status of session
			String email = (String) sess.getAttribute("email");			//Session Variable will be email(which serves as username
			if(sess != null)											//Check if already logged in
			{		
					CheckProfile cp = new CheckProfile();
					TbUserDb tudb = new TbUserDb();
					tudb = cp.display(email);								//Invoke the function display() in able.helper.CheckLogin
					sess.setAttribute("tudb", tudb);
					getServletConfig().getServletContext().getRequestDispatcher("/admin/Admin_Home.jsp").forward(request, response);				
			}
			else
			{
				getServletConfig().getServletContext().getRequestDispatcher("/register/register_error.jsp").forward(request, response);
			}
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
			getServletConfig().getServletContext().getRequestDispatcher("/register/register_error.jsp").forward(request, response);
		}

	}  	
	
	/* (non-Java-doc)
	 * @see javax.servlet.http.HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}   	  	    
}