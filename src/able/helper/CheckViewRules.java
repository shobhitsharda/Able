package able.helper;

import java.sql.*;
import java.util.ArrayList;

import able.dbclass.Connect;
import able.dbclass.TbRulesDb;

public class CheckViewRules {
	public ArrayList displayrules()
	{
		try
		{
			Connect con = new Connect();
			Connection cn = con.connectdb();
			
			String sql = "SELECT * FROM DB2ADMIN.RULESDB";
			Statement stmt = cn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			ArrayList alist = new ArrayList();
			TbRulesDb data;
			while(rs.next())
			{
				data = new TbRulesDb();
				data.setRuletitle(rs.getString("ruletitle"));
				data.setRulecontent(rs.getString("rulecontent"));
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

