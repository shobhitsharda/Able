package able.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import able.helper.CheckMod_DeleteUsers;
import able.helper.CheckMod_ViewUsers;

/**
 * Servlet implementation class for Servlet: Mod_DeleteUsers
 *
 */
 public class Mod_DeleteUsers extends javax.servlet.http.HttpServlet implements javax.servlet.Servlet {
   static final long serialVersionUID = 1L;
   
    /* (non-Java-doc)
	 * @see javax.servlet.http.HttpServlet#HttpServlet()
	 */
	public Mod_DeleteUsers() {
		super();
	}   	
	
	/* (non-Java-doc)
	 * @see javax.servlet.http.HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		HttpSession sess = request.getSession(true);
		String check;
		try
		{
			String email= (String) request.getParameter("email");
			boolean return_value = false;
			
			CheckMod_DeleteUsers cmdu = new CheckMod_DeleteUsers();
			return_value = cmdu.deletemod_users(email);
			if(return_value == true)
			{
				
				CheckMod_ViewUsers fetch_data = new CheckMod_ViewUsers();
				sess.setAttribute("record",fetch_data.displaymod_users());
				getServletConfig().getServletContext().getRequestDispatcher("/admin/user/Mod_ViewUsers.jsp").forward(request, response);
			}
			else
			{
				check = "1";	//delete user
				sess.setAttribute("check", check);
				getServletConfig().getServletContext().getRequestDispatcher("/admin/user/Mod_Error_ViewUsers.jsp").forward(request, response);
			}
		
		}
		catch(Exception e)
		{
			e.printStackTrace();
			check = "1";	//delete user
			sess.setAttribute("check", check);
			getServletConfig().getServletContext().getRequestDispatcher("/admin/user/Mod_Error_ViewUsers.jsp").forward(request, response);
	
		}
			
	}  	
	
	/* (non-Java-doc)
	 * @see javax.servlet.http.HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//HttpSession sess = request.getSession(true);
		
	}   	  	    
}