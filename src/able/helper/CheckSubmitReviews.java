package able.helper;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.Date;

import able.dbclass.Connect;

public class CheckSubmitReviews {
	public boolean control(String mod_link, String mod_link_type, String mod_description, String mod_email)
	{
			
			Connect con = new Connect();
			Connection cn = con.connectdb();
			String mod_linkdate = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
			
			double mod_linkId = getmod_LinkId(cn);
			boolean return_value = submitPost(cn, mod_linkId, mod_email, mod_link_type, mod_linkdate, mod_description, mod_link);
			return return_value;
			
	}

	boolean submitPost(Connection cn, double mod_linkId, String mod_email, String mod_link_type, String mod_linkdate, String mod_description, String mod_link)
	{
		try
		{
			String sql = "INSERT INTO DB2ADMIN.MODREVIEWDB VALUES(?,?,?,?,?,?)";
			PreparedStatement ps = cn.prepareStatement(sql);
			ps.setDouble(1, mod_linkId);
			ps.setString(2, mod_email);
			ps.setString(3, mod_link_type);
			ps.setString(4, mod_linkdate);
			ps.setString(5, mod_description);
			ps.setString(6, mod_link);
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
	double getmod_LinkId(Connection cn)
	{
		double mod_linkId = 0;
		try
		{
			String sql = "SELECT MAX(MOD_LINKID) FROM DB2ADMIN.MODREVIEWDB";
			PreparedStatement ps = cn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			
			rs.next();
			mod_linkId = rs.getDouble(1);
			return mod_linkId + 1;
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return mod_linkId;
	}
}
