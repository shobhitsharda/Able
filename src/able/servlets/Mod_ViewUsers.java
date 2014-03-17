package able.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import able.helper.CheckMod_ViewUsers;

/**
 * Servlet implementation class for Servlet: Mod_ViewUsers
 *
 */
 public class Mod_ViewUsers extends javax.servlet.http.HttpServlet implements javax.servlet.Servlet {
   static final long serialVersionUID = 1L;
   
    /* (non-Java-doc)
	 * @see javax.servlet.http.HttpServlet#HttpServlet()
	 */
	public Mod_ViewUsers() {
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
			CheckMod_ViewUsers fetch_data = new CheckMod_ViewUsers();
			sess.setAttribute("record",fetch_data.displaymod_users());
			getServletConfig().getServletContext().getRequestDispatcher("/admin/user/Mod_ViewUsers.jsp").forward(request, response);
		}
		catch(Exception e)
		{
			e.printStackTrace();
			check = "2";
			sess.setAttribute("check", check);
			getServletConfig().getServletContext().getRequestDispatcher("/admin/user/Mod_Error_ViewUsers.jsp").forward(request, response);
		}
	
	}  	
	
	/* (non-Java-doc)
	 * @see javax.servlet.http.HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		
	}   	  	    
}