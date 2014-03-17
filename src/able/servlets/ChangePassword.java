package able.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import able.helper.CheckChangePassword;

/**
 * Servlet implementation class for Servlet: ChangePassword
 *
 */
 public class ChangePassword extends javax.servlet.http.HttpServlet implements javax.servlet.Servlet {
   static final long serialVersionUID = 1L;
   
    /* (non-Java-doc)
	 * @see javax.servlet.http.HttpServlet#HttpServlet()
	 */
	public ChangePassword() {
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
		String currentpass = request.getParameter("currentpassword");
		String newpass_1 = request.getParameter("newpassword_1");
		String newpass_2 = request.getParameter("newpassword_2");
		
		if(newpass_1.equals(newpass_2))
		{
			String email = (String) sess.getAttribute("email");
			
			CheckChangePassword changepass = new CheckChangePassword();
			boolean return_value = changepass.changepassword(email, currentpass, newpass_1);
			if(return_value == true)
			{
				check = "1";
				sess.setAttribute("check", check);
				getServletConfig().getServletContext().getRequestDispatcher("/session/ConfirmChangedPassword.jsp").forward(request, response);
			}
			else
			{
				check = "2";
				sess.setAttribute("check", check);
				getServletConfig().getServletContext().getRequestDispatcher("/session/ConfirmChangedPassword.jsp").forward(request, response);
			}
			
		}
		else
		{
			check = "3";
			sess.setAttribute("check", check);
			getServletConfig().getServletContext().getRequestDispatcher("/session/ConfirmChangedPassword.jsp").forward(request, response);
		}
		
	}   	  	    
}