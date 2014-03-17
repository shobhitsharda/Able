package able.helper;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import able.dbclass.Connect;
import able.dbclass.TbOrganizationDb;

public class CheckMod_ViewOrganization {
	public ArrayList displaymod_organization()
	{
		try
		{
			Connect con = new Connect();
			Connection cn = con.connectdb();
			
			String sql = "SELECT * FROM DB2ADMIN.ORGANIZATIONDB";
			Statement stmt = cn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			ArrayList alist = new ArrayList();
			TbOrganizationDb data;
			
			while(rs.next())
			{
				data = new TbOrganizationDb();
				
				data.setOrgid(rs.getInt("orgid"));
				data.setOrgname(rs.getString("orgname"));
				data.setOrgaddress(rs.getString("orgaddress"));
				data.setOrgcity(rs.getString("orgcity"));
				data.setOrgpincode(rs.getDouble("orgpincode"));
			//	data.setOrgphone(rs.getDouble("orgphone"));
				data.setOrgwebsite(rs.getString("orgwebsite"));
				
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
