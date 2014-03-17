package able.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import able.helper.CheckMod_ViewOrganization;

/**
 * Servlet implementation class for Servlet: Mod_ViewOrganization
 *
 */
 public class Mod_ViewOrganization extends javax.servlet.http.HttpServlet implements javax.servlet.Servlet {
   static final long serialVersionUID = 1L;
   
    /* (non-Java-doc)
	 * @see javax.servlet.http.HttpServlet#HttpServlet()
	 */
	public Mod_ViewOrganization() {
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
			CheckMod_ViewOrganization fetch_data = new CheckMod_ViewOrganization();
			sess.setAttribute("record",fetch_data.displaymod_organization());
			getServletConfig().getServletContext().getRequestDispatcher("/admin/organization/Mod_ViewOrganization.jsp").forward(request, response);
		}
		catch(Exception e)
		{
			check = "1"; //view organization
			sess.setAttribute("check", check);
			e.printStackTrace();
			getServletConfig().getServletContext().getRequestDispatcher("/admin/organization/Mod_Error_ViewOrganization.jsp").forward(request, response);
		}
	
	}  	
	
	/* (non-Java-doc)
	 * @see javax.servlet.http.HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}   	  	    
}