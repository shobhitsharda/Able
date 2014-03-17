package able.helper;

import java.sql.Connection;
import java.sql.PreparedStatement;

import able.dbclass.Connect;


public class CheckMod_DeleteUsers {
	public boolean deletemod_users(String email)
	{
		try
		{
			Connect con = new Connect();
			Connection cn = con.connectdb();
			
			String sql = "DELETE FROM DB2ADMIN.MODPOSTDB where mod_email=?";
			PreparedStatement ps = cn.prepareStatement(sql);
			ps.setString(1, email);
			ps.executeUpdate();
			
			sql = "DELETE FROM DB2ADMIN.MODREVIEWDB where mod_email=?";
			ps = cn.prepareStatement(sql);
			ps.setString(1, email);
			ps.executeUpdate();
			
			sql = "DELETE FROM DB2ADMIN.POSTDB where email=?";
			ps = cn.prepareStatement(sql);
			ps.setString(1, email);
			ps.executeUpdate();
			
			sql = "DELETE FROM DB2ADMIN.REVIEWDB where email=?";
			ps = cn.prepareStatement(sql);
			ps.setString(1, email);
			ps.executeUpdate();
			
			sql = "DELETE FROM DB2ADMIN.USERDB where email=?";
			ps = cn.prepareStatement(sql);
			ps.setString(1, email);
			ps.executeUpdate();

			cn.commit();
			ps.close();
			cn.close();
			return true;
		}
		catch(Exception e)		
		{
			e.printStackTrace();
		}
		return false;
	}
}
