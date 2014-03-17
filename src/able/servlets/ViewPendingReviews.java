package able.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import able.helper.CheckViewPendingReviews;

/**
 * Servlet implementation class for Servlet: ViewPendingReviews
 *
 */
 public class ViewPendingReviews extends javax.servlet.http.HttpServlet implements javax.servlet.Servlet {
   static final long serialVersionUID = 1L;
   
    /* (non-Java-doc)
	 * @see javax.servlet.http.HttpServlet#HttpServlet()
	 */
	public ViewPendingReviews() {
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
			String email = (String) sess.getAttribute("email");
			
			if(sess != null)
			{
				CheckViewPendingReviews fetch_data = new CheckViewPendingReviews();
				sess.setAttribute("record",fetch_data.displaypost(email));
			
				//Forwarding 
				getServletConfig().getServletContext().getRequestDispatcher("/reviews/ViewPendingReviews.jsp").forward(request, response);
			}
			else
			{
				check = "3";	//view pending reviews
				sess.setAttribute("check", check);
				getServletConfig().getServletContext().getRequestDispatcher("/reviews/review_error.jsp").forward(request, response);
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
			check = "3";	//view pending reviews
			sess.setAttribute("check", check);
			getServletConfig().getServletContext().getRequestDispatcher("/reviews/review_error.jsp").forward(request, response);
		}

	}  	
	
	/* (non-Java-doc)
	 * @see javax.servlet.http.HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
	}   	  	    
}