package able.helper;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import able.dbclass.Connect;
import able.dbclass.TbRecentUpdatesDb;

public class CheckViewUpdates {
	public ArrayList displayupdates()
	{
		try
		{
			Connect con = new Connect();
			Connection cn = con.connectdb();
			
			String sql = "SELECT * FROM DB2ADMIN.RECENTUPDATESDB";
			Statement stmt = cn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			ArrayList alist = new ArrayList();
			TbRecentUpdatesDb data;
			while(rs.next())
			{
				data = new TbRecentUpdatesDb();
				data.setUpdatetitle(rs.getString("updatetitle"));
				data.setUpdatecontent(rs.getString("updatecontent"));
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
