package able.helper;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.Date;

import able.dbclass.Connect;

public class CheckMod_SubmitReviews {
	public boolean control(String link, String link_type, String description, String email)
	{
			
			Connect con = new Connect();
			Connection cn = con.connectdb();
			String linkdate = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
			
			int linkId = getmod_LinkId(cn);
			boolean return_value = submitReviews(cn, linkId, email, link, link_type, description, linkdate);
			return return_value;
			
	}

	boolean submitReviews(Connection cn, int linkId, String email, String link, String link_type, String description, String linkdate)
	{
		try
		{
			String sql = "INSERT INTO DB2ADMIN.REVIEWDB VALUES(?,?,?,?,?,?)";
			PreparedStatement ps = cn.prepareStatement(sql);
			ps.setInt(1, linkId);
			ps.setString(2, email);
			ps.setString(3, link);
			ps.setString(4, link_type);
			ps.setString(5, description);
			ps.setString(6, linkdate);
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
	int getmod_LinkId(Connection cn)
	{
		int linkid = 0;
		try
		{
			String sql = "SELECT MAX(LINKID) FROM DB2ADMIN.REVIEWDB";
			PreparedStatement ps = cn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			
			rs.next();
			linkid = rs.getInt(1);
			return  linkid + 1;
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return linkid;
	}

}
