package able.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

//import able.helper.CheckStd_DisplayAllSiteReviews;
import able.helper.CheckMod_ViewAllAcceptedReviews;

/**
 * Servlet implementation class for Servlet: Std_DisplayAllSiteReviews
 *
 */
 public class Std_DisplayAllSiteReviews extends javax.servlet.http.HttpServlet implements javax.servlet.Servlet {
   static final long serialVersionUID = 1L;
   
    /* (non-Java-doc)
	 * @see javax.servlet.http.HttpServlet#HttpServlet()
	 */
	public Std_DisplayAllSiteReviews() {
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
			CheckMod_ViewAllAcceptedReviews fetch_data = new CheckMod_ViewAllAcceptedReviews();
			sess.setAttribute("record",fetch_data.displayreviews());
			getServletConfig().getServletContext().getRequestDispatcher("/anonymous/sitereviews/Std_DisplayAllSiteReviews.jsp").forward(request, response);
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
			check = "3";
			sess.setAttribute("check", check);
			getServletConfig().getServletContext().getRequestDispatcher("/rules/rule_error.jsp").forward(request, response);
		}
	}  	
	
	/* (non-Java-doc)
	 * @see javax.servlet.http.HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}   	  	    
}