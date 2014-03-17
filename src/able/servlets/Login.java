package able.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import able.helper.CheckLogin;

/**
 * Servlet implementation class for Servlet: Login
 *
 */
 public class Login extends javax.servlet.http.HttpServlet implements javax.servlet.Servlet {
   static final long serialVersionUID = 1L;
   
    /* (non-Java-doc)
	 * @see javax.servlet.http.HttpServlet#HttpServlet()
	 */
	public Login() {
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
		
		String check;
		HttpSession sess = request.getSession(true);
		try
		{
			String email = request.getParameter("email");
			String password = request.getParameter("password");
			CheckLogin cl = new CheckLogin();
			String return_value = cl.Check(email, password);
					
			if(return_value != null)
			{
				sess.setAttribute("email",email);
				sess.setAttribute("usertype", return_value);
				getServletConfig().getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);
			}
			else
			{
				check = "1";
				sess.setAttribute("check", check);
				getServletConfig().getServletContext().getRequestDispatcher("/session/error.jsp").forward(request, response);
			}

		}
		catch(Exception e)
		{
			e.printStackTrace();
			check = "1";
			sess.setAttribute("check", check);
			getServletConfig().getServletContext().getRequestDispatcher("/session/error.jsp").forward(request, response);

		}
		
	}   	  	    
}