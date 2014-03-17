package able.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import able.helper.CheckMod_DeleteUpdates;
import able.helper.CheckMod_ViewUpdates;

/**
 * Servlet implementation class for Servlet: Mod_DeleteUpdates
 *
 */
 public class Mod_DeleteUpdates extends javax.servlet.http.HttpServlet implements javax.servlet.Servlet {
   static final long serialVersionUID = 1L;
   
    /* (non-Java-doc)
	 * @see javax.servlet.http.HttpServlet#HttpServlet()
	 */
	public Mod_DeleteUpdates() {
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
			String updateid = request.getParameter("mod_updateid");
			int mod_updateid = Integer.parseInt(updateid);
		
			boolean return_value = false;
			
			CheckMod_DeleteUpdates cmdr = new CheckMod_DeleteUpdates();
			return_value = cmdr.deletemod_updates(mod_updateid);
		
			if(return_value == true)
			{
	
				CheckMod_ViewUpdates fetch_data = new CheckMod_ViewUpdates();
				sess.setAttribute("record",fetch_data.displaymod_updates());
				getServletConfig().getServletContext().getRequestDispatcher("/admin/updates/Mod_ViewUpdates.jsp").forward(request, response);
			}
			else
			{
				check = "1"; 	//view updates
				sess.setAttribute("check", check);
				getServletConfig().getServletContext().getRequestDispatcher("/admin/updates/Mod_Error_ViewUpdates.jsp").forward(request, response);
			}

		}
		catch(Exception e)
		{
			e.printStackTrace();
			check = "1";	//view updates
			sess.setAttribute("check", check);
			getServletConfig().getServletContext().getRequestDispatcher("/admin/updates/Mod_Error_ViewUpdates.jsp").forward(request, response);
		}
			

	}  	
	
	/* (non-Java-doc)
	 * @see javax.servlet.http.HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}   	  	    
}