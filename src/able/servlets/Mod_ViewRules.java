package able.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import able.helper.CheckMod_ViewRules;

/**
 * Servlet implementation class for Servlet: Mod_ViewRules
 *
 */
 public class Mod_ViewRules extends javax.servlet.http.HttpServlet implements javax.servlet.Servlet {
   static final long serialVersionUID = 1L;
   
    /* (non-Java-doc)
	 * @see javax.servlet.http.HttpServlet#HttpServlet()
	 */
	public Mod_ViewRules() {
		super();
	}   	
	
	/* (non-Java-doc)
	 * @see javax.servlet.http.HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try
		{
			HttpSession sess = request.getSession(true);
			CheckMod_ViewRules fetch_data = new CheckMod_ViewRules();
			sess.setAttribute("record",fetch_data.displaymod_rules());
			getServletConfig().getServletContext().getRequestDispatcher("/admin/rules/Mod_ViewRules.jsp").forward(request, response);
		}
		catch(Exception e)
		{
			e.printStackTrace();
			getServletConfig().getServletContext().getRequestDispatcher("/admin/rules/Mod_Error_ViewRules.jsp").forward(request, response);
		}
	

	}  	
	
	/* (non-Java-doc)
	 * @see javax.servlet.http.HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}   	  	    
}