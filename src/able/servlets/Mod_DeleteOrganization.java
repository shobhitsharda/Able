package able.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import able.helper.CheckMod_DeleteOrganization;
import able.helper.CheckMod_ViewOrganization;

/**
 * Servlet implementation class for Servlet: Mod_DeleteOrganization
 *
 */
 public class Mod_DeleteOrganization extends javax.servlet.http.HttpServlet implements javax.servlet.Servlet {
   static final long serialVersionUID = 1L;
   
    /* (non-Java-doc)
	 * @see javax.servlet.http.HttpServlet#HttpServlet()
	 */
	public Mod_DeleteOrganization() {
		super();
	}   	
	
	/* (non-Java-doc)
	 * @see javax.servlet.http.HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		HttpSession sess = request.getSession(true);
		String check;
		String orgid = request.getParameter("mod_orgid");
		int mod_orgid = Integer.parseInt(orgid);
	
		boolean return_value = false;
		
		CheckMod_DeleteOrganization cmdr = new CheckMod_DeleteOrganization();
		return_value = cmdr.deletemod_organization(mod_orgid);
	
		if(return_value == true)
		{
	
			
			CheckMod_ViewOrganization fetch_data = new CheckMod_ViewOrganization();
			sess.setAttribute("record",fetch_data.displaymod_organization());
			getServletConfig().getServletContext().getRequestDispatcher("/admin/organization/Mod_ViewOrganization.jsp").forward(request, response);
		}
		else
		{
			check = "1"; //view organization
			sess.setAttribute("check", check);
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