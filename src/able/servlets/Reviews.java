package able.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import able.helper.CheckSubmitReviews;

/**
 * Servlet implementation class for Servlet: Reviews
 *
 */
 public class Reviews extends javax.servlet.http.HttpServlet implements javax.servlet.Servlet {
   static final long serialVersionUID = 1L;
   
    /* (non-Java-doc)
	 * @see javax.servlet.http.HttpServlet#HttpServlet()
	 */
	public Reviews() {
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
			String mod_link = request.getParameter("link");
			String mod_link_type = request.getParameter("link_type");
			String mod_description = request.getParameter("description");
			String _desc = "<description>" + mod_description + "</description>";
			String email = (String) sess.getAttribute("email");
		
			CheckSubmitReviews csr = new CheckSubmitReviews();
			boolean return_value = csr.control(mod_link, mod_link_type, _desc, email);
		
			if (return_value == true)
			{
				getServletConfig().getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);
			}
			else
			{
				check = "1";	//submit site reviews
				sess.setAttribute(check, check);
				getServletConfig().getServletContext().getRequestDispatcher("/reviews/review_error.jsp").forward(request, response);
			}

		}
		catch(Exception e)
		{
			e.printStackTrace();
			check = "1";	//submit site reviews
			sess.setAttribute(check, check);
			getServletConfig().getServletContext().getRequestDispatcher("/reviews/review_error.jsp").forward(request, response);
		}
	}   	  	    
}