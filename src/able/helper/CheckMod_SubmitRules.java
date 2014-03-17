package able.helper;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


import able.dbclass.Connect;

public class CheckMod_SubmitRules {
		public boolean control(String title, String content)
		{
				
				Connect con = new Connect();
				Connection cn = con.connectdb();
				
				int ruleId = getmod_RuleId(cn);
				boolean return_value = submitRule(cn, ruleId, title, content);
				return return_value;
		}

		boolean submitRule(Connection cn, int ruleId, String title, String content)
		{
			try
			{
				String sql = "INSERT INTO DB2ADMIN.RULESDB VALUES(?,?,?)";
				PreparedStatement ps = cn.prepareStatement(sql);
				ps.setInt(1, ruleId);
				ps.setString(2, title);
				ps.setString(3, content);
				ps.executeUpdate();
				
				cn.commit();
				ps.close();
				cn.close();
				
				return true;
			}
			catch(Exception e)
			{
				e.printStackTrace();
				return false;
			}
		}
		int getmod_RuleId(Connection cn)
		{
			int ruleId = 0;
			try
			{
				String sql = "SELECT MAX(RULEID) FROM DB2ADMIN.RULESDB";
				PreparedStatement ps = cn.prepareStatement(sql);
				ResultSet rs = ps.executeQuery();
				
				rs.next();
				ruleId = rs.getInt(1);
				return ruleId + 1;
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
			return ruleId;
		}

}
