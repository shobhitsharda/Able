package able.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import able.helper.CheckMod_Std_SubmitPost;
/**
 * Servlet implementation class for Servlet: Std_SubmitPost
 *
 */
 public class Std_SubmitPost extends javax.servlet.http.HttpServlet implements javax.servlet.Servlet {
   static final long serialVersionUID = 1L;
   
    /* (non-Java-doc)
	 * @see javax.servlet.http.HttpServlet#HttpServlet()
	 */
	public Std_SubmitPost() {
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
			String type = request.getParameter("type");

			CheckMod_Std_SubmitPost fetch_data = new CheckMod_Std_SubmitPost();
			String _content = "<content>" + content + "</content>" ;
			boolean return_value = fetch_data.control(title, _content, type);
			if (return_value == true)
			{
				getServletConfig().getServletContext().getRequestDispatcher("/admin/Admin_Home.jsp").forward(request, response);
			}
			else
			{
				check = "2";	//unable to submit
				sess.setAttribute("check", check);
				getServletConfig().getServletContext().getRequestDispatcher("/admin/stdinfot/Mod_Std_Error_SubmitPost.jsp").forward(request, response);
			}


		}
		catch(Exception e)
		{
			e.printStackTrace();
			check = "2";		//unable to submit
			sess.setAttribute("check", check);
			getServletConfig().getServletContext().getRequestDispatcher("/admin/stdinfot/Mod_Std_Error_SubmitPost.jsp").forward(request, response);
		}
				
	}   	  	    
}