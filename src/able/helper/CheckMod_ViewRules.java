package able.helper;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import able.dbclass.Connect;
import able.dbclass.TbRulesDb;

public class CheckMod_ViewRules {
	public ArrayList displaymod_rules()
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
				
				data.setRuleid(rs.getInt("ruleid"));
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
