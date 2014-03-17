package able.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import able.helper.CheckMod_SubmitReviews;

/**
 * Servlet implementation class for Servlet: Mod_SubmitSiteReviews
 *
 */
 public class Mod_SubmitSiteReviews extends javax.servlet.http.HttpServlet implements javax.servlet.Servlet {
   static final long serialVersionUID = 1L;
   
    /* (non-Java-doc)
	 * @see javax.servlet.http.HttpServlet#HttpServlet()
	 */
	public Mod_SubmitSiteReviews() {
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
			String link = request.getParameter("link");
			String link_type = request.getParameter("link_type");
			String description = request.getParameter("description");
			String _desc = "<description>" + description + "</description>";
			String email = (String) sess.getAttribute("email");
		
			CheckMod_SubmitReviews csr = new CheckMod_SubmitReviews();
			boolean return_value = csr.control(link, link_type, _desc, email);
		
			if (return_value == true)
			{
				getServletConfig().getServletContext().getRequestDispatcher("/admin/Admin_Home.jsp").forward(request, response);
			}
			else
			{
				check = "4"; //submit reviews
				sess.setAttribute("check", check);
				getServletConfig().getServletContext().getRequestDispatcher("/admin/reviews/Mod_Error_ViewReviews.jsp").forward(request, response);
			}

		}
		catch(Exception e)
		{
			e.printStackTrace();
			check = "4"; //submit reviews
			sess.setAttribute("check", check);
			getServletConfig().getServletContext().getRequestDispatcher("/admin/reviews/Mod_Error_ViewReviews.jsp").forward(request, response);
		
		}
		
	}   	  	    
}