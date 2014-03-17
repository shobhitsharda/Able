package able.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import able.helper.CheckMod_ViewAllPendingReviews;

/**
 * Servlet implementation class for Servlet: Mod_ViewAllPendingReviews
 *
 */
 public class Mod_ViewAllPendingReviews extends javax.servlet.http.HttpServlet implements javax.servlet.Servlet {
   static final long serialVersionUID = 1L;
   
    /* (non-Java-doc)
	 * @see javax.servlet.http.HttpServlet#HttpServlet()
	 */
	public Mod_ViewAllPendingReviews() {
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
			CheckMod_ViewAllPendingReviews fetch_data = new CheckMod_ViewAllPendingReviews();
			sess.setAttribute("record",fetch_data.displaymod_review());
			getServletConfig().getServletContext().getRequestDispatcher("/admin/reviews/Mod_ViewAllPendingReviews.jsp").forward(request, response);
		}
		catch(Exception e)
		{
			e.printStackTrace();
			check = "3"; //mod view all pending reviews
			sess.setAttribute("check", check);
			getServletConfig().getServletContext().getRequestDispatcher("/admin/reviews/Mod_Error_ViewReviewss.jsp").forward(request, response);
		}
	
	}  	
	
	/* (non-Java-doc)
	 * @see javax.servlet.http.HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}   	  	    
}