package able.helper;

import able.dbclass.Connect;
//import able.dbclass.TbPostDb;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

//import able.dbclass.TbModTagDb;
public class CheckViewPendingTag {
	public String display_pendingtag(int mod_postid)
	{
		try
		{
			Connect con =new Connect();
			Connection cn = con.connectdb();
			String mod_tag = "NIL" ,mod_tagtitle = null;
			
			String sql2 = "SELECT MOD_TAGID FROM DB2ADMIN.MODPOSTTAGDB WHERE MOD_POSTID=?";
			PreparedStatement ps2 = cn.prepareStatement(sql2);
			ps2.setInt(1, mod_postid);
			ResultSet rs2 = ps2.executeQuery();
			while(rs2.next())
			{
				
				int mod_tagid = rs2.getInt("mod_tagid");
				
				String sql3 = "SELECT MOD_TAGTITLE FROM DB2ADMIN.MODTAGDB WHERE MOD_TAGID=?";
				PreparedStatement ps3 = cn.prepareStatement(sql3);
				ps3.setInt(1, mod_tagid);
				ResultSet rs3 = ps3.executeQuery();
				while(rs3.next())
				{
					mod_tagtitle = rs3.getString("mod_tagtitle");
					if(mod_tag == "NIL")
					{
						mod_tag = mod_tagtitle;
					}
					else
					{
						mod_tag = mod_tag + ", " + mod_tagtitle;
					}
				}
			}
			
			cn.commit();
			ps2.close();
			cn.close();
			return mod_tag;
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return null;
				
	}
}
