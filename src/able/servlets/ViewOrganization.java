package able.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import able.helper.CheckViewOrganization;

/**
 * Servlet implementation class for Servlet: ViewOrganization
 *
 */
 public class ViewOrganization extends javax.servlet.http.HttpServlet implements javax.servlet.Servlet {
   static final long serialVersionUID = 1L;
   
    /* (non-Java-doc)
	 * @see javax.servlet.http.HttpServlet#HttpServlet()
	 */
	public ViewOrganization() {
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
			CheckViewOrganization fetch_data = new CheckViewOrganization();
			sess.setAttribute("record",fetch_data.displayorganization());
			getServletConfig().getServletContext().getRequestDispatcher("/organization/ViewOrganization.jsp").forward(request, response);
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
			getServletConfig().getServletContext().getRequestDispatcher("/organization/organization_error.jsp").forward(request, response);
		}

	}  	
	
	/* (non-Java-doc)
	 * @see javax.servlet.http.HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}   	  	    
}