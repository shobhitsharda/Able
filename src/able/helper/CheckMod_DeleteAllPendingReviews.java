package able.helper;

import java.sql.Connection;
import java.sql.PreparedStatement;

import able.dbclass.Connect;

public class CheckMod_DeleteAllPendingReviews {
	public boolean deletemod_allpendingreviews(int modlinkid)
	{
		try
		{
			Connect con = new Connect();
			Connection cn = con.connectdb();
			
			String sql = "DELETE FROM DB2ADMIN.MODREVIEWDB where mod_linkid=?";
			PreparedStatement ps = cn.prepareStatement(sql);
			ps.setInt(1, modlinkid);
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
