package able.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import able.helper.CheckMod_DeleteAllAcceptedPost;
import able.helper.CheckMod_ViewAllAcceptedPost;

/**
 * Servlet implementation class for Servlet: Mod_DeleteAllAcceptedPost
 *
 */
 public class Mod_DeleteAllAcceptedPost extends javax.servlet.http.HttpServlet implements javax.servlet.Servlet {
   static final long serialVersionUID = 1L;
   
    /* (non-Java-doc)
	 * @see javax.servlet.http.HttpServlet#HttpServlet()
	 */
	public Mod_DeleteAllAcceptedPost() {
		super();
	}   	
	
	/* (non-Java-doc)
	 * @see javax.servlet.http.HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String check;
		HttpSession sess = request.getSession(true);
		String postid = request.getParameter("mod_postid");
		int mod_postid = Integer.parseInt(postid);  

		boolean return_value = false;
		
		CheckMod_DeleteAllAcceptedPost cmdu = new CheckMod_DeleteAllAcceptedPost();
		return_value = cmdu.deletemod_allacceptedpost(mod_postid);
	
		if(return_value == true)
		{
			CheckMod_ViewAllAcceptedPost fetch_data = new CheckMod_ViewAllAcceptedPost();
			sess.setAttribute("record",fetch_data.displaypost());
			getServletConfig().getServletContext().getRequestDispatcher("/admin/post/Mod_ViewAllAcceptedPost.jsp").forward(request, response);
		}
		else
		{
			check = "5"; // mod delete all accepted post
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