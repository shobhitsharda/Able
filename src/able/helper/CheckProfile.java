package able.helper;
import java.sql.*;

import able.dbclass.Connect;
import able.dbclass.TbUserDb;
public class CheckProfile {
	public TbUserDb display(String email) //Get the parameter email from able.servlet.Profile.java
	{
		
		try
		{
		//Connect to Database	
			Connect con = new Connect();
			Connection cn = con.connectdb();
	
		//Execute the query, based on email find other details of the user from USERDB 	
			
			String sql = "SELECT firstname,lastname,email,age,sex,usertype FROM DB2ADMIN.USERDB WHERE email=?";
			PreparedStatement ps = cn.prepareStatement(sql);
			ps.setString(1, email);
			ResultSet rs = ps.executeQuery();
	
			rs.next();
	
		//Retrieve and store data in respective variables
			
			String dbfirstname = rs.getString("firstname");
			String dblastname = rs.getString("lastname");
			String dbemail = rs.getString("email");
			String dbage = rs.getString("age");
			String dbsex = rs.getString("sex");
			String dbusertype = rs.getString("usertype");
	
		//Invokes class invokes able.dbclass.TbUserDb to set the fields

			TbUserDb data = new TbUserDb();
			data.setFirstname(dbfirstname);
			data.setLastname(dblastname);
			data.setEmail(dbemail);
			data.setAge(dbage);
			data.setSex(dbsex);
			data.setUsertype(dbusertype);
			
			cn.commit();
			ps.close();
			cn.close();
			
			return data;
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	return null;	
	}
}
