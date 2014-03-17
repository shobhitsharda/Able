package able.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import able.helper.CheckViewRules;

/**
 * Servlet implementation class for Servlet: ViewRules
 *
 */
 public class ViewRules extends javax.servlet.http.HttpServlet implements javax.servlet.Servlet {
   static final long serialVersionUID = 1L;
   
    /* (non-Java-doc)
	 * @see javax.servlet.http.HttpServlet#HttpServlet()
	 */
	public ViewRules() {
		super();
	}   	
	
	/* (non-Java-doc)
	 * @see javax.servlet.http.HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try
		{
			HttpSession sess = request.getSession(true);
			CheckViewRules fetch_data = new CheckViewRules();
			sess.setAttribute("record",fetch_data.displayrules());
			getServletConfig().getServletContext().getRequestDispatcher("/rules/ViewRules.jsp").forward(request, response);
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
			getServletConfig().getServletContext().getRequestDispatcher("/rules/rule_error.jsp").forward(request, response);
		}
	
	}  	
	
	/* (non-Java-doc)
	 * @see javax.servlet.http.HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}   	  	    
}