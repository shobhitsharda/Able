package able.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import able.helper.CheckMod_AcceptAllPendingReviews;
import able.helper.CheckMod_ViewAllPendingReviews;

/**
 * Servlet implementation class for Servlet: Mod_AcceptAllPendingReviews
 *
 */
 public class Mod_AcceptAllPendingReviews extends javax.servlet.http.HttpServlet implements javax.servlet.Servlet {
   static final long serialVersionUID = 1L;
   
    /* (non-Java-doc)
	 * @see javax.servlet.http.HttpServlet#HttpServlet()
	 */
	public Mod_AcceptAllPendingReviews() {
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
			int modlinkid = Integer.parseInt(linkid);  
			
			boolean return_value = false;
			
			CheckMod_AcceptAllPendingReviews cmau = new CheckMod_AcceptAllPendingReviews();
			return_value = cmau.acceptmod_allpendingreview(modlinkid);
					
			if(return_value == true)
			{
				CheckMod_ViewAllPendingReviews fetch_data = new CheckMod_ViewAllPendingReviews();
				sess.setAttribute("record",fetch_data.displaymod_review());
				getServletConfig().getServletContext().getRequestDispatcher("/admin/reviews/Mod_ViewAllPendingReviews.jsp").forward(request, response);
			}
			else
			{
				check="1"; //mod accept all pending reviews
				sess.setAttribute("check", check);
				getServletConfig().getServletContext().getRequestDispatcher("/admin/reviews/Mod_Error_ViewReviews.jsp").forward(request, response);
			}

		}
		catch(Exception e)
		{
			e.printStackTrace();
			check="1"; //mod accept all pending reviews
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