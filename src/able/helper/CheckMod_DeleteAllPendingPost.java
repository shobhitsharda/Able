package able.helper;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import able.dbclass.Connect;

public class CheckMod_DeleteAllPendingPost {
	public boolean deletemod_allpendingpost(int modpostid)
	{
		try
		{
			Connect con = new Connect();
			Connection cn = con.connectdb();
			
			String sql1 = "SELECT MOD_TAGID FROM DB2ADMIN.MODPOSTTAGDB WHERE MOD_POSTID=?";
			PreparedStatement ps1 = cn.prepareStatement(sql1);
			ps1.setInt(1, modpostid);
			ResultSet rs1 = ps1.executeQuery();
			while(rs1.next())
			{
				int mod_tagid = rs1.getInt("mod_tagid");
				String sql2 = "DELETE FROM DB2ADMIN.MODTAGDB WHERE MOD_TAGID=?";
				PreparedStatement ps2 = cn.prepareStatement(sql2);
				ps2.setInt(1, mod_tagid);
				ps2.executeUpdate();
				
				String sql3 = "DELETE FROM DB2ADMIN.MODPOSTTAGDB WHERE MOD_POSTID=?";
				PreparedStatement ps3 = cn.prepareStatement(sql3);
				ps3.setInt(1, modpostid);
				ps3.executeUpdate();
			}
		
			
			String sql = "DELETE FROM DB2ADMIN.MODPOSTDB where mod_postid=?";
			PreparedStatement ps = cn.prepareStatement(sql);
			ps.setInt(1, modpostid);
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
