package able.helper;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import able.dbclass.Connect;
import able.dbclass.TbModReviewDb;

public class CheckViewPendingReviews {
	public ArrayList displaypost(String email)
	{
		try
		{
			Connect con = new Connect();
			Connection cn = con.connectdb();
			
			String sql = "SELECT mod_email,mod_link_type,mod_linkdate,mod_description,mod_link FROM DB2ADMIN.MODREVIEWDB where mod_email=?";
			PreparedStatement ps = cn.prepareStatement(sql);
			ps.setString(1, email);
			ResultSet rs = ps.executeQuery();
			ArrayList alist = new ArrayList();
			TbModReviewDb data;
			while(rs.next())
			{
				data = new TbModReviewDb();
				data.setMod_email(rs.getString("mod_email"));
				data.setMod_link_type(rs.getString("mod_link_type"));
				data.setMod_linkdate(rs.getString("mod_linkdate"));
				data.setMod_description(rs.getString("mod_description"));
				data.setMod_link(rs.getString("mod_link"));
				alist.add(data);
			}
			
			cn.commit();
			ps.close();
			cn.close();
			return alist;
		}
		catch(Exception e)		
		{
			e.printStackTrace();
		}
		return null;
	}
}
