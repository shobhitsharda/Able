package able.helper;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import able.dbclass.Connect;
import able.dbclass.TbUserDb;

public class CheckMod_ViewUsers {
	public ArrayList displaymod_users()
	{
		try
		{
			Connect con = new Connect();
			Connection cn = con.connectdb();
			
			String sql = "SELECT * FROM DB2ADMIN.USERDB";
			Statement stmt = cn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			ArrayList alist = new ArrayList();
			TbUserDb data;
			
			while(rs.next())
			{
				data = new TbUserDb();
				
				data.setFirstname(rs.getString("firstname"));
				data.setLastname(rs.getString("lastname"));
				data.setEmail(rs.getString("email"));
				data.setAge(rs.getString("age"));
				data.setSex(rs.getString("sex"));
				data.setUsertype(rs.getString("usertype"));
				data.setPassword(rs.getString("password"));
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
