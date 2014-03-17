package able.helper;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import able.dbclass.Connect;
import able.dbclass.TbReviewDb;

public class CheckMod_ViewAllAcceptedReviews {
	public ArrayList displayreviews()
	{
		try
		{
			Connect con = new Connect();
			Connection cn = con.connectdb();
			
			String sql = "SELECT * FROM DB2ADMIN.REVIEWDB";
			Statement stmt = cn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			ArrayList alist = new ArrayList();
			TbReviewDb data;
			
			while(rs.next())
			{
				data = new TbReviewDb();
				
				data.setLinkid(rs.getInt("linkid"));
				data.setLink(rs.getString("link"));
				data.setLink_type(rs.getString("link_type"));
				data.setLinkdate(rs.getString("linkdate"));
				data.setEmail(rs.getString("email"));
				data.setDescription(rs.getString("description"));
				
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
