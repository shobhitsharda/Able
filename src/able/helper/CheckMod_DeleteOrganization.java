package able.helper;

import java.sql.Connection;
import java.sql.PreparedStatement;

import able.dbclass.Connect;

public class CheckMod_DeleteOrganization {
	public boolean deletemod_organization(int mod_orgid)
	{
		try
		{
			Connect con = new Connect();
			Connection cn = con.connectdb();
			
			String sql = "DELETE FROM DB2ADMIN.ORGANIZATIONDB where orgid=?";
			PreparedStatement ps = cn.prepareStatement(sql);
			ps.setInt(1, mod_orgid);
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
