package able.helper;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import able.dbclass.Connect;

public class CheckMod_SubmitUpdates {
	public boolean control(String title, String content)
	{
			
			Connect con = new Connect();
			Connection cn = con.connectdb();
	
			
			int updateId = getmod_updateId(cn);
			boolean return_value = submitUpdates(cn, updateId, title, content);
			return return_value;
			
	}

	boolean submitUpdates(Connection cn, int updateId, String title, String content)
	{
		try
		{
			String sql = "INSERT INTO DB2ADMIN.RECENTUPDATESDB VALUES(?,?,?)";
			PreparedStatement ps = cn.prepareStatement(sql);
			ps.setInt(1, updateId);
			ps.setString(2, title);
			ps.setString(3, content);
			ps.executeUpdate();
			
			cn.commit();
			ps.close();
			cn.close();
			
			return true;
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return false;
		}
	}
	int getmod_updateId(Connection cn)
	{
		int updateid = 0;
		try
		{
			String sql = "SELECT MAX(UPDATEID) FROM DB2ADMIN.RECENTUPDATESDB";
			PreparedStatement ps = cn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			
			rs.next();
			updateid = rs.getInt(1);
			return  updateid + 1;
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return updateid;
	}


}
