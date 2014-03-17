package able.helper;
import java.sql.*;

import able.dbclass.Connect;


public class CheckLogin 
{
	public String Check(String email, String password)
	{
		try
		{
		Connect con = new Connect();
		Connection cn = con.connectdb();
		
		Statement ss = cn.createStatement( );
		ResultSet rs = ss.executeQuery("SELECT email, password FROM DB2ADMIN.USERDB");
		String dbemail, dbpassword;
		String usertype = null;
		boolean check = false;
		while(rs.next())
		{
			dbemail = rs.getString("email");
			dbpassword = rs.getString("password");
			if(dbemail.equals(email) && dbpassword.equals(password))
			{
				String sql1="SELECT USERTYPE FROM DB2ADMIN.USERDB WHERE EMAIL=?";
				PreparedStatement ps1 = cn.prepareStatement(sql1);
				ps1.setString(1, email);
				ResultSet rs1 = ps1.executeQuery();
				rs1.next();
				usertype = rs1.getString("usertype");
			}
		}
		cn.commit();
		ss.close();
		cn.close();
		return usertype;
		}
	catch(Exception e)
	{
		e.printStackTrace();
	}
	return null;
	}
}