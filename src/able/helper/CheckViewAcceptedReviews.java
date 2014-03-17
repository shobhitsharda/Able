package able.helper;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import able.dbclass.Connect;
import able.dbclass.TbReviewDb;

public class CheckViewAcceptedReviews {
	public ArrayList displaypost(String email)
	{
		try
		{
			Connect con = new Connect();
			Connection cn = con.connectdb();
	
			String sql = "SELECT email,link,link_type,description,linkdate FROM DB2ADMIN.REVIEWDB where email=?";
			PreparedStatement ps = cn.prepareStatement(sql);
			ps.setString(1, email);
			ResultSet rs = ps.executeQuery();
	
			ArrayList alist = new ArrayList();
			TbReviewDb data;
			while(rs.next())
			{
				data = new TbReviewDb();
				data.setEmail(rs.getString("email"));
				data.setLink(rs.getString("link"));
				data.setLink_type(rs.getString("link_type"));
				data.setDescription(rs.getString("description"));
				data.setLinkdate(rs.getString("linkdate"));
							
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
