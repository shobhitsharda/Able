package able.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import able.helper.CheckRegister;
/**
 * Servlet implementation class for Servlet: Register
 *
 */
 public class Register extends javax.servlet.http.HttpServlet implements javax.servlet.Servlet {
   static final long serialVersionUID = 1L;
   
    /* (non-Java-doc)
	 * @see javax.servlet.http.HttpServlet#HttpServlet()
	 */
	public Register() {
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
		
		String firstname = request.getParameter("firstname");
		String lastname = request.getParameter("lastname");
		String email = request.getParameter("email");
		String password1 = request.getParameter("password1");
		String password2 = request.getParameter("password2");
		if(password1.equals(password2))
		{
			String age = request.getParameter("age");
			String sex = request.getParameter("sex");
			String usertype = request.getParameter("usertype");
			CheckRegister cr = new CheckRegister();
			boolean return_value = cr.create(firstname, lastname, email, age, sex, usertype, password1);
			if(return_value == true)
			{
				getServletConfig().getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);
			}
			else
			{
				check = "2";	//internal problem with the database
				sess.setAttribute("check", check);
				getServletConfig().getServletContext().getRequestDispatcher("/register/register_error.jsp").forward(request, response);
			}

		}
		else
		{
			check = "3";		//entered passwords are not same
			sess.setAttribute("check", check);
			getServletConfig().getServletContext().getRequestDispatcher("/register/register_error.jsp").forward(request, response);
		}
	}   	  	    
}