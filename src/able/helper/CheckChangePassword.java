package able.helper;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import able.dbclass.Connect;



public class CheckChangePassword {
	public boolean changepassword(String email, String currentpass, String newpass)
	{
		try
		{
			Connect con = new Connect();
			Connection cn = con.connectdb();
			
			String sql1 = "SELECT PASSWORD FROM DB2ADMIN.USERDB WHERE EMAIL=?";
			PreparedStatement ps1 = cn.prepareStatement(sql1);
			ps1.setString(1, email);
			ResultSet rs1 = ps1.executeQuery();
			rs1.next();
			
			String currentpassworddb = rs1.getString("password");

			if(currentpassworddb.equals(currentpass))
			{
				String sql2 = "UPDATE DB2ADMIN.USERDB SET PASSWORD=? WHERE EMAIL=?";
				PreparedStatement ps2 = cn.prepareStatement(sql2);
				ps2.setString(1, newpass);
				ps2.setString(2, email);
				ps2.executeUpdate();
				cn.commit();
				ps2.close();
				cn.close();
				return true;
			}
			return false;
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return false;
		
	}

}
