package able.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import able.helper.CheckProfile;
import able.dbclass.TbUserDb;
/**
 * Servlet implementation class for Servlet: Profile
 *
 */
 public class Profile extends javax.servlet.http.HttpServlet implements javax.servlet.Servlet {
   static final long serialVersionUID = 1L;
   
    /* (non-Java-doc)
	 * @see javax.servlet.http.HttpServlet#HttpServlet()
	 */
	public Profile() {
		super();
	}   	
	
	/* (non-Java-doc)
	 * @see javax.servlet.http.HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		HttpSession sess = request.getSession(true);				//Get the Status of session
		String check;
		try
		{							
			String email = (String) sess.getAttribute("email");			//Session Variable will be email(which serves as username
			if(sess != null)											//Check if already logged in
			{		
					CheckProfile cp = new CheckProfile();
					TbUserDb tudb = new TbUserDb();
					tudb = cp.display(email);								//Invoke the function display() in able.helper.CheckLogin
					sess.setAttribute("tudb", tudb);
					getServletConfig().getServletContext().getRequestDispatcher("/register/UserDashBoard.jsp").forward(request, response);				
			}
			else
			{
				check = "1";	//view profile
				sess.setAttribute("check", check);
				getServletConfig().getServletContext().getRequestDispatcher("/register/register_error.jsp").forward(request, response);
			}
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
			check = "1";	//view profile
			sess.setAttribute("check", check);
			getServletConfig().getServletContext().getRequestDispatcher("/register/register_error.jsp").forward(request, response);
		}

	}  	
	
	/* (non-Java-doc)
	 * @see javax.servlet.http.HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		// TODO Auto-generated method stub
	
	}
	
	public void init() throws ServletException {
		// TODO Auto-generated method stub
		super.init();
	}   
}