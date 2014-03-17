package able.helper;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import able.dbclass.Connect;
import able.dbclass.TbPostDb;
import able.helper.CheckViewAcceptedTag;

public class CheckViewAcceptedPost {
	public ArrayList displayacceptedpost(String email)
	{
		try
		{
			Connect con = new Connect();
			Connection cn = con.connectdb();
			
			String sql = "SELECT postid,title,email,postdate,content FROM DB2ADMIN.POSTDB where email=?";
			PreparedStatement ps = cn.prepareStatement(sql);
			ps.setString(1, email);
			ResultSet rs = ps.executeQuery();
			ArrayList alist = new ArrayList();
			TbPostDb data;
			while(rs.next())
			{
				data = new TbPostDb();
				data.setTitle(rs.getString("title"));
				data.setEmail(rs.getString("email"));
				data.setPostdate(rs.getString("postdate"));
				data.setContent(rs.getString("content"));
				int postid = rs.getInt("postid");
				
					CheckViewAcceptedTag fetch_tag = new CheckViewAcceptedTag();
					String tags = fetch_tag.display_acceptedtag(postid);
				data.setTags(tags);
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
