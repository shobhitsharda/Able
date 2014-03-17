package able.helper;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import able.dbclass.Connect;


public class CheckViewAcceptedTag {
	public String display_acceptedtag(int postid)
	{
		try
		{
			Connect con =new Connect();
			Connection cn = con.connectdb();
			String tag = "NIL" ,tagtitle = null;
			
			String sql2 = "SELECT TAGID FROM DB2ADMIN.POSTTAGDB WHERE POSTID=?";
			PreparedStatement ps2 = cn.prepareStatement(sql2);
			ps2.setInt(1, postid);
			ResultSet rs2 = ps2.executeQuery();
			while(rs2.next())
			{
				
				int tagid = rs2.getInt("tagid");
				
				String sql3 = "SELECT TAGTITLE FROM DB2ADMIN.TAGDB WHERE TAGID=?";
				PreparedStatement ps3 = cn.prepareStatement(sql3);
				ps3.setInt(1, tagid);
				ResultSet rs3 = ps3.executeQuery();
				while(rs3.next())
				{

					tagtitle = rs3.getString("tagtitle");
					if(tag == "NIL")
					{
						tag = tagtitle;
					}
					else
					{
						tag = tag + ", " + tagtitle;
					}
				}
			}
			
			cn.commit();
			ps2.close();
			cn.close();
			return tag;
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return null;
				
	}

}
