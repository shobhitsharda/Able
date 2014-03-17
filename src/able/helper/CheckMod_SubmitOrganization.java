package able.helper;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import able.dbclass.Connect;

public class CheckMod_SubmitOrganization {
	public boolean control(String name, String address, String city, double pincode, String website)
	{
		
		Connect con = new Connect();
		Connection cn = con.connectdb();
		
		int orgId = getorgId(cn);
		boolean return_value = submitorg(cn, orgId, name, address, city, pincode, website);
		return return_value;
		
	}

boolean submitorg(Connection cn, int orgId, String name, String address, String city, double pincode, String website)
{
	try
	{
		String sql = "INSERT INTO DB2ADMIN.ORGANIZATIONDB VALUES(?,?,?,?,?,?,?)";
		PreparedStatement ps = cn.prepareStatement(sql);
		ps.setInt(1, orgId);
		ps.setString(2, name);
		ps.setString(3, address);
		ps.setString(4, city);
		ps.setDouble(5, pincode);
	//	ps.setDouble(6, phone);
		ps.setString(7, website);
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
int getorgId(Connection cn)
{
	int orgId = 0;
	try
	{
		String sql = "SELECT MAX(ORGID) FROM DB2ADMIN.ORGANIZATIONDB";
		PreparedStatement ps = cn.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		
		rs.next();
		orgId = rs.getInt(1);
		return orgId + 1;
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}
	return orgId;
}
}
