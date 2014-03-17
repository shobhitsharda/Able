package able.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import able.helper.CheckStd_ViewCloudPost;

/**
 * Servlet implementation class for Servlet: Std_ViewCloudPost
 *
 */
 public class Std_ViewCloudPost extends javax.servlet.http.HttpServlet implements javax.servlet.Servlet {
   static final long serialVersionUID = 1L;
   
    /* (non-Java-doc)
	 * @see javax.servlet.http.HttpServlet#HttpServlet()
	 */
	public Std_ViewCloudPost() {
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
			String tag = request.getParameter("type");
			CheckStd_ViewCloudPost fetch_data = new CheckStd_ViewCloudPost();
			sess.setAttribute("record_allpost", fetch_data.displayallpost(tag));
			getServletConfig().getServletContext().getRequestDispatcher("/anonymous/Std_DisplayAllPost.jsp").forward(request, response);
		
		}
		catch(Exception e)
		{
			check = "1"; //view cloud
			sess.setAttribute("check", check);
			getServletConfig().getServletContext().getRequestDispatcher("/anonymous/Std_Error_AllDisabilityPost.jsp").forward(request, response);
		}
	}  	
	
	/* (non-Java-doc)
	 * @see javax.servlet.http.HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}   	  	    
}