package able.helper;

import java.sql.Connection;
import java.sql.PreparedStatement;

import able.dbclass.Connect;

public class CheckMod_DeleteUpdates {
	public boolean deletemod_updates(int updateid)
	{
		try
		{
			Connect con = new Connect();
			Connection cn = con.connectdb();
			
			String sql = "DELETE FROM DB2ADMIN.RECENTUPDATESDB where updateid=?";
			PreparedStatement ps = cn.prepareStatement(sql);
			ps.setInt(1, updateid);
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
