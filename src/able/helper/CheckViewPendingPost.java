package able.helper;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import able.dbclass.Connect;
import able.dbclass.TbModPostDb;
import able.helper.CheckViewPendingTag;

public class CheckViewPendingPost {
	public ArrayList displaypost(String email)
	{
		try
		{
			Connect con = new Connect();
			Connection cn = con.connectdb();
			int mod_postid;
			String sql = "SELECT mod_postid,mod_title,mod_email,mod_postdate,mod_content FROM DB2ADMIN.MODPOSTDB where mod_email=?";
			PreparedStatement ps = cn.prepareStatement(sql);
			ps.setString(1, email);
			ResultSet rs = ps.executeQuery();
			ArrayList alist = new ArrayList();
			TbModPostDb data;
			while(rs.next())
			{
				data = new TbModPostDb();
				mod_postid = rs.getInt("mod_postid");
				
				data.setMod_title(rs.getString("mod_title"));
				data.setMod_email(rs.getString("mod_email"));
				data.setMod_postdate(rs.getString("mod_postdate"));
				data.setMod_content(rs.getString("mod_content"));
				
					CheckViewPendingTag fetch_tag = new CheckViewPendingTag();
					String mod_tags = fetch_tag.display_pendingtag(mod_postid);
				
				data.setMod_tags(mod_tags);	
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
