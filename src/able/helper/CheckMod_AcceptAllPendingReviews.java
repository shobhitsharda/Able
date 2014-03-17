package able.helper;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import able.dbclass.Connect;

public class CheckMod_AcceptAllPendingReviews {
	public boolean acceptmod_allpendingreview(int modlinkid)
	{
		try
		{
			
			Connect con = new Connect();
			Connection cn = con.connectdb();

			String sql1 = "SELECT mod_email, mod_link_type, mod_linkdate, mod_description, mod_link FROM DB2ADMIN.MODREVIEWDB where mod_linkid = ?";
			PreparedStatement ps = cn.prepareStatement(sql1);
			ps.setInt(1, modlinkid);
			ResultSet rs = ps.executeQuery();
			
				rs.next();
				String dbmodemail = rs.getString("mod_email");
				String dbmodlinktype = rs.getString("mod_link_type");
				String dbmodlinkdate = rs.getString("mod_linkdate");
				String dbmoddescription = rs.getString("mod_description");
				String dbmodlink = rs.getString("mod_link");
		
			String sql2 = "SELECT MAX(LINKID) FROM DB2ADMIN.REVIEWDB";
			ps = cn.prepareStatement(sql2);
			rs = ps.executeQuery();
			
				rs.next();
				int mod_linkId = rs.getInt(1);
				int modid = mod_linkId + 1;
				
			String sql3 = "INSERT INTO DB2ADMIN.REVIEWDB VALUES(?,?,?,?,?,?)";
			ps = cn.prepareStatement(sql3);
			ps.setInt(1, modid);
			ps.setString(2, dbmodemail);
			ps.setString(3, dbmodlink);
			ps.setString(4, dbmodlinktype);
			ps.setString(5, dbmoddescription);
			ps.setString(6, dbmodlinkdate);
			ps.executeUpdate();
			cn.commit();
			
			String sql4 = "DELETE FROM DB2ADMIN.MODREVIEWDB where mod_linkid=?";
			ps = cn.prepareStatement(sql4);
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
