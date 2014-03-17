package able.helper;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import able.dbclass.Connect;
import able.dbclass.TbModPostDb;
import able.helper.CheckViewPendingTag;

public class CheckMod_ViewAllPendingPost {
	public ArrayList displaymod_post()
	{
		try
		{
			Connect con = new Connect();
			Connection cn = con.connectdb();
			
			String sql = "SELECT * FROM DB2ADMIN.MODPOSTDB";
			Statement stmt = cn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			ArrayList alist = new ArrayList();
			TbModPostDb data;
			
			while(rs.next())
			{
				data = new TbModPostDb();
				
				data.setMod_postid(rs.getInt("mod_postid"));
					
					CheckViewPendingTag fetch_tag = new CheckViewPendingTag();
					String mod_tags = fetch_tag.display_pendingtag(rs.getInt("mod_postid"));
										
				data.setMod_title(rs.getString("mod_title"));
				data.setMod_postdate(rs.getString("mod_postdate"));
				data.setMod_email(rs.getString("mod_email"));
				data.setMod_content(rs.getString("mod_content"));
				data.setMod_tags(mod_tags);
				
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
