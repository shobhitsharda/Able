package able.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import able.helper.CheckMod_DeleteAllAcceptedReviews;
import able.helper.CheckMod_ViewAllAcceptedReviews;

/**
 * Servlet implementation class for Servlet: Mod_DeleteAllAcceptedReviews
 *
 */
 public class Mod_DeleteAllAcceptedReviews extends javax.servlet.http.HttpServlet implements javax.servlet.Servlet {
   static final long serialVersionUID = 1L;
   
    /* (non-Java-doc)
	 * @see javax.servlet.http.HttpServlet#HttpServlet()
	 */
	public Mod_DeleteAllAcceptedReviews() {
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
			String linkid = request.getParameter("mod_linkid");
			int mod_linkid = Integer.parseInt(linkid);  

			boolean return_value = false;
			
			CheckMod_DeleteAllAcceptedReviews cmdu = new CheckMod_DeleteAllAcceptedReviews();
			return_value = cmdu.deletemod_allacceptedreviews(mod_linkid);
		
			if(return_value == true)
			{
		
				
				CheckMod_ViewAllAcceptedReviews fetch_data = new CheckMod_ViewAllAcceptedReviews();
				sess.setAttribute("record",fetch_data.displayreviews());
				getServletConfig().getServletContext().getRequestDispatcher("/admin/reviews/Mod_ViewAllAcceptedReviews.jsp").forward(request, response);
			}
			else
			{
				check = "5"; //mod delete all accepted reviews
				sess.setAttribute("check", check);
				getServletConfig().getServletContext().getRequestDispatcher("/admin/reviews/Mod_Error_ViewReviews.jsp").forward(request, response);
			}

		}
		catch(Exception e)
		{
			e.printStackTrace();
			check = "5"; //mod delete all accepted reviews
			sess.setAttribute("check", check);
			getServletConfig().getServletContext().getRequestDispatcher("/admin/reviews/Mod_Error_ViewReviews.jsp").forward(request, response);

		}
				
	}  	
	
	/* (non-Java-doc)
	 * @see javax.servlet.http.HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}   	  	    
}