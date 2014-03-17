package able.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import able.helper.CheckMod_SubmitUpdates;

/**
 * Servlet implementation class for Servlet: Mod_Submit_Updates
 *
 */
 public class Mod_Submit_Updates extends javax.servlet.http.HttpServlet implements javax.servlet.Servlet {
   static final long serialVersionUID = 1L;
   
    /* (non-Java-doc)
	 * @see javax.servlet.http.HttpServlet#HttpServlet()
	 */
	public Mod_Submit_Updates() {
		super();
	}   	
	
	/* (non-Java-doc)
	 * @see javax.servlet.http.HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}  	
	
	/* (non-Java-doc)
	 * @see javax.servlet.http.HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		HttpSession sess = request.getSession(true);
		String check;
		try
		{
			String title = request.getParameter("title");
			String content = request.getParameter("content");

			String new_title = "<title>" + title + "</title>";
			String new_content = "<content>" + content + "</content>";
			CheckMod_SubmitUpdates cbp = new CheckMod_SubmitUpdates();
			boolean return_value = cbp.control(new_title, new_content);
			if (return_value == true)
			{
				getServletConfig().getServletContext().getRequestDispatcher("/admin/Admin_Home.jsp").forward(request, response);
			}
			else
			{
				check = "2";	//submit updates
				sess.setAttribute("check", check);
				getServletConfig().getServletContext().getRequestDispatcher("/admin/organization/Mod_Error_ViewOrganization.jsp").forward(request, response);
			}

		}
		catch(Exception e)
		{
			e.printStackTrace();
			check = "2";	//submit updates
			sess.setAttribute("check", check);
			getServletConfig().getServletContext().getRequestDispatcher("/admin/organization/Mod_Error_ViewOrganization.jsp").forward(request, response);
		}
	}   	  	    
}