package able.helper;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import able.dbclass.Connect;
import able.dbclass.TbModReviewDb;

public class CheckMod_ViewAllPendingReviews {
	public ArrayList displaymod_review()
	{
		try
		{
			Connect con = new Connect();
			Connection cn = con.connectdb();
			
			String sql = "SELECT * FROM DB2ADMIN.MODREVIEWDB";
			Statement stmt = cn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			ArrayList alist = new ArrayList();
			TbModReviewDb data;
			
			while(rs.next())
			{
				data = new TbModReviewDb();
				
				data.setMod_linkid(rs.getInt("mod_linkid"));
				data.setMod_link(rs.getString("mod_link"));
				data.setMod_link_type(rs.getString("mod_link_type"));
				data.setMod_linkdate(rs.getString("mod_linkdate"));
				data.setMod_email(rs.getString("mod_email"));
				data.setMod_description(rs.getString("mod_description"));
				
				alist.add(data);
			}
			cn.commit();
			stmt.close();
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
