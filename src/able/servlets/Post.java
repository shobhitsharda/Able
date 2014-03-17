package able.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import able.helper.CheckSubmitPost;

/**
 * Servlet implementation class for Servlet: Post
 *
 */
 public class Post extends javax.servlet.http.HttpServlet implements javax.servlet.Servlet {
   static final long serialVersionUID = 1L;
   
    /* (non-Java-doc)
	 * @see javax.servlet.http.HttpServlet#HttpServlet()
	 */
	public Post() {
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
			String content = request.getParameter("postcontent");
			String tag = request.getParameter("tag");
			String email = (String) sess.getAttribute("email");
			
			CheckSubmitPost cbp = new CheckSubmitPost();
			String _content = "<content>" + content + "</content>" ;
			boolean return_value = cbp.control(title, _content, email, tag);
			if (return_value == true)
			{
				getServletConfig().getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);
			}
			else
			{
				check = "1";	//submit post by user
				sess.setAttribute("check", check);
				getServletConfig().getServletContext().getRequestDispatcher("/post/post_error.jsp").forward(request, response);
			}

		}
		catch(Exception e)
		{
			e.printStackTrace();
			check = "1";	//submit post by user
			sess.setAttribute("check", check);
			getServletConfig().getServletContext().getRequestDispatcher("post_error.jsp").forward(request, response);
	
		}
	}   	  	    
}