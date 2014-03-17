package able.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import able.helper.CheckMod_SubmitPost;

/**
 * Servlet implementation class for Servlet: Mod_SubmitPost
 *
 */
 public class Mod_SubmitPost extends javax.servlet.http.HttpServlet implements javax.servlet.Servlet {
   static final long serialVersionUID = 1L;
   
    /* (non-Java-doc)
	 * @see javax.servlet.http.HttpServlet#HttpServlet()
	 */
	public Mod_SubmitPost() {
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
			String title = request.getParameter("title");
			String content = request.getParameter("content");
			String email = (String) sess.getAttribute("email");
			String tag = request.getParameter("tag");
			
			CheckMod_SubmitPost cbp = new CheckMod_SubmitPost();
			String _content = "<content>" + content + "</content>" ;
			boolean return_value = cbp.control(title, _content, email, tag);
			if (return_value == true)
			{
				getServletConfig().getServletContext().getRequestDispatcher("/admin/Admin_Home.jsp").forward(request, response);
			}
			else
			{
				check = "4"; 	//mod submit post
				sess.setAttribute("check", check);
				getServletConfig().getServletContext().getRequestDispatcher("/admin/post/Mod_Error_ViewPost.jsp").forward(request, response);
			}

		}
		catch(Exception e)
		{
			check = "4"; 	//mod submit post
			sess.setAttribute("check", check);
			getServletConfig().getServletContext().getRequestDispatcher("/admin/post/Mod_Error_ViewPost.jsp").forward(request, response);
			e.printStackTrace();
		}
		
	}   	  	    
}