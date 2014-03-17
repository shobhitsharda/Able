package able.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import able.helper.CheckViewAcceptedReviews;


/**
 * Servlet implementation class for Servlet: ViewAcceptedReviews
 *
 */
 public class ViewAcceptedReviews extends javax.servlet.http.HttpServlet implements javax.servlet.Servlet {
   static final long serialVersionUID = 1L;
   
    /* (non-Java-doc)
	 * @see javax.servlet.http.HttpServlet#HttpServlet()
	 */
	public ViewAcceptedReviews() {
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
				CheckViewAcceptedReviews fetch_data = new CheckViewAcceptedReviews();
				sess.setAttribute("record",fetch_data.displaypost(email));
			
				//Forwarding 
				getServletConfig().getServletContext().getRequestDispatcher("/reviews/ViewAcceptedReviews.jsp").forward(request, response);
			}
			else
			{
				check = "2"; 	//view accepted reviews
				sess.setAttribute("check", check);
				getServletConfig().getServletContext().getRequestDispatcher("/reviews/review_error.jsp").forward(request, response);
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
			check = "2"; 	//view accepted reviews
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