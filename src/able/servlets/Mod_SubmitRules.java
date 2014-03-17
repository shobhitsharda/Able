package able.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import able.helper.CheckMod_SubmitRules;

/**
 * Servlet implementation class for Servlet: Mod_SubmitRules
 *
 */
 public class Mod_SubmitRules extends javax.servlet.http.HttpServlet implements javax.servlet.Servlet {
   static final long serialVersionUID = 1L;
   
    /* (non-Java-doc)
	 * @see javax.servlet.http.HttpServlet#HttpServlet()
	 */
	public Mod_SubmitRules() {
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
			String rulestitle = request.getParameter("rulestitle");
			String rulescontent = request.getParameter("rulescontent");
			
			
			String new_title = "<rulestitle>" + rulestitle + "</rulestitle>";
			String new_content = "<rulescontent>" + rulescontent + "</rulescontent>";
			CheckMod_SubmitRules cbp = new CheckMod_SubmitRules();
			boolean return_value = cbp.control(new_title, new_content);
			if (return_value == true)
			{
				getServletConfig().getServletContext().getRequestDispatcher("/admin/Admin_Home.jsp").forward(request, response);
			}
			else
			{
				check = "2"; 	//unable to submit the rules
				sess.setAttribute("check", check);
				getServletConfig().getServletContext().getRequestDispatcher("/admin/rules/Mod_Error_ViewRules.jsp").forward(request, response);
			}

		}
		catch(Exception e)
		{
			e.printStackTrace();
			check = "2"; 	//unable to submit the rules
			sess.setAttribute("check", check);
			getServletConfig().getServletContext().getRequestDispatcher("/admin/rules/Mod_Error_ViewRules.jsp").forward(request, response);
		}
			

	}   	  	    
}