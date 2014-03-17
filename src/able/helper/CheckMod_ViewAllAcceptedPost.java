package able.helper;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import able.dbclass.Connect;
import able.dbclass.TbPostDb;
import able.helper.CheckViewAcceptedTag;

public class CheckMod_ViewAllAcceptedPost {
	public ArrayList displaypost()
	{
		try
		{
			Connect con = new Connect();
			Connection cn = con.connectdb();
			
			String sql = "SELECT * FROM DB2ADMIN.POSTDB";
			Statement stmt = cn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			ArrayList alist = new ArrayList();
			TbPostDb data;
			
			while(rs.next())
			{
				data = new TbPostDb();
				
				data.setPostid(rs.getInt("postid"));
					CheckViewAcceptedTag fetch_tag = new CheckViewAcceptedTag();
					String tags = fetch_tag.display_acceptedtag(rs.getInt("postid"));
				data.setTitle(rs.getString("title"));
				data.setPostdate(rs.getString("postdate"));
				data.setEmail(rs.getString("email"));
				data.setContent(rs.getString("content"));
				data.setTags(tags);
				
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