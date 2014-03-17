package able.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import able.helper.CheckMod_DeleteAllPendingPost;
import able.helper.CheckMod_ViewAllPendingPost;


/**
 * Servlet implementation class for Servlet: Mod_DeleteAllPendingPost
 *
 */
 public class Mod_DeleteAllPendingPost extends javax.servlet.http.HttpServlet implements javax.servlet.Servlet {
   static final long serialVersionUID = 1L;
   
    /* (non-Java-doc)
	 * @see javax.servlet.http.HttpServlet#HttpServlet()
	 */
	public Mod_DeleteAllPendingPost() {
		super();
	}   	
	
	/* (non-Java-doc)
	 * @see javax.servlet.http.HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		HttpSession sess = request.getSession(true);
		String check;
		String postid = request.getParameter("mod_postid");
		int mod_postid = Integer.parseInt(postid);  

		boolean return_value = false;
		
		CheckMod_DeleteAllPendingPost cmdu = new CheckMod_DeleteAllPendingPost();
		return_value = cmdu.deletemod_allpendingpost(mod_postid);
	
		if(return_value == true)
		{
			CheckMod_ViewAllPendingPost fetch_data = new CheckMod_ViewAllPendingPost();
			sess.setAttribute("record",fetch_data.displaymod_post());
			getServletConfig().getServletContext().getRequestDispatcher("/admin/post/Mod_ViewAllPendingPost.jsp").forward(request, response);
		}
		else
		{
			check = "2"; // mod delete all pending post
			sess.setAttribute("check", check);
			getServletConfig().getServletContext().getRequestDispatcher("/admin/post/Mod_Error_ViewPost.jsp").forward(request, response);
		}
	}  	
	
	/* (non-Java-doc)
	 * @see javax.servlet.http.HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}   	  	    
}