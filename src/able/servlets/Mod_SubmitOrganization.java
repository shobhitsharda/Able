package able.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import able.helper.CheckMod_SubmitOrganization;

/**
 * Servlet implementation class for Servlet: Mod_SubmitOrganization
 *
 */
 public class Mod_SubmitOrganization extends javax.servlet.http.HttpServlet implements javax.servlet.Servlet {
   static final long serialVersionUID = 1L;
   
    /* (non-Java-doc)
	 * @see javax.servlet.http.HttpServlet#HttpServlet()
	 */
	public Mod_SubmitOrganization() {
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
			String name = request.getParameter("orgname");
			String address = request.getParameter("orgaddress");
			String city = request.getParameter("orgcity");
			String pincode = request.getParameter("orgpincode");
		//	String phone = request.getParameter("orgphone");
			String website = request.getParameter("orgwebsite");
			
		//	double new_pincode = Double.parseDouble(pincode);
		//	double new_phone = Double.parseDouble(phone);
			int new_pincode = Integer.parseInt(pincode);
		//	int new_phone = Integer.parseInt(phone);
			CheckMod_SubmitOrganization cbp = new CheckMod_SubmitOrganization();
			boolean return_value = cbp.control(name, address, city, new_pincode, website);
			if (return_value == true)
			{
				getServletConfig().getServletContext().getRequestDispatcher("/admin/Admin_Home.jsp").forward(request, response);
			}
			else
			{
				check = "2"; //view organization
				sess.setAttribute("check", check);
				getServletConfig().getServletContext().getRequestDispatcher("/admin/organization/Mod_Error_ViewOrganization.jsp").forward(request, response);
			}

		}
		catch(Exception e)
		{
			e.printStackTrace();
			check = "2"; //view organization
			sess.setAttribute("check", check);
			getServletConfig().getServletContext().getRequestDispatcher("/admin/organization/Mod_Error_ViewOrganization.jsp").forward(request, response);

		}
				
	}   	  	    
}