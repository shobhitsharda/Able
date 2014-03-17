package able.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import able.helper.CheckMod_DeleteRules;
import able.helper.CheckMod_ViewRules;

/**
 * Servlet implementation class for Servlet: Mod_DeleteRules
 *
 */
 public class Mod_DeleteRules extends javax.servlet.http.HttpServlet implements javax.servlet.Servlet {
   static final long serialVersionUID = 1L;
   
    /* (non-Java-doc)
	 * @see javax.servlet.http.HttpServlet#HttpServlet()
	 */
	public Mod_DeleteRules() {
		super();
	}   	
	
	/* (non-Java-doc)
	 * @see javax.servlet.http.HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	
		HttpSession sess = request.getSession(true);
		String check;
		String ruleid = request.getParameter("rule_id");
		int mod_ruleid = Integer.parseInt(ruleid);
	
		boolean return_value = false;
		
		CheckMod_DeleteRules cmdr = new CheckMod_DeleteRules();
		return_value = cmdr.deletemod_rules(mod_ruleid);
	
		if(return_value == true)
		{
	
			CheckMod_ViewRules fetch_data = new CheckMod_ViewRules();
			sess.setAttribute("record",fetch_data.displaymod_rules());
			getServletConfig().getServletContext().getRequestDispatcher("/admin/rules/Mod_ViewRules.jsp").forward(request, response);
		}
		else
		{
			check = "1"; 	//unable to view the rules
			sess.setAttribute("check", check);
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