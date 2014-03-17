package able.helper;

import java.sql.Connection;
import java.sql.PreparedStatement;

import able.dbclass.Connect;

public class CheckMod_DeleteRules {
	public boolean deletemod_rules(int ruleid)
	{
		try
		{
			Connect con = new Connect();
			Connection cn = con.connectdb();
			
			String sql = "DELETE FROM DB2ADMIN.RULESDB where ruleid=?";
			PreparedStatement ps = cn.prepareStatement(sql);
			ps.setInt(1, ruleid);
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
