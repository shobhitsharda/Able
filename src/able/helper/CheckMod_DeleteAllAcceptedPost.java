package able.helper;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import able.dbclass.Connect;

public class CheckMod_DeleteAllAcceptedPost {
	public boolean deletemod_allacceptedpost(int modpostid)
	{
		try
		{
			Connect con = new Connect();
			Connection cn = con.connectdb();
			
			String sql1 = "SELECT TAGID FROM DB2ADMIN.POSTTAGDB WHERE POSTID=?";
			PreparedStatement ps1 = cn.prepareStatement(sql1);
			ps1.setInt(1, modpostid);
			ResultSet rs1 = ps1.executeQuery();
			while(rs1.next())
			{
				int tagid = rs1.getInt("tagid");
				String sql2 = "DELETE FROM DB2ADMIN.TAGDB WHERE TAGID=?";
				PreparedStatement ps2 = cn.prepareStatement(sql2);
				ps2.setInt(1, tagid);
				ps2.executeUpdate();
				
				String sql3 = "DELETE FROM DB2ADMIN.POSTTAGDB WHERE POSTID=?";
				PreparedStatement ps3 = cn.prepareStatement(sql3);
				ps3.setInt(1, modpostid);
				ps3.executeUpdate();
			}
		
	
			String sql = "DELETE FROM DB2ADMIN.POSTDB where postid=?";
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
