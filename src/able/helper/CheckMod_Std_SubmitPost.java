package able.helper;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.Date;

import able.dbclass.Connect;

public class CheckMod_Std_SubmitPost {
	public boolean control(String title, String content, String type)
	{
			
			Connect con = new Connect();
			Connection cn = con.connectdb();
			String postdate = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
			
			int stdId = getStdId(cn);
			boolean return_value = submitPost(cn, stdId, title, postdate, content, type);
			return return_value;
			
	}

	boolean submitPost(Connection cn, int stdId, String title, String postdate, String content,  String type)
	{
		try
		{
			String sql = "INSERT INTO DB2ADMIN.STANDARDINFODB VALUES(?,?,?,?,?)";
			PreparedStatement ps = cn.prepareStatement(sql);
			ps.setDouble(1, stdId);
			ps.setString(2, title);
			ps.setString(3, postdate);
			ps.setString(4, content);
			ps.setString(5, type);
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
	int getStdId(Connection cn)
	{
		int stdId = 0;
		try
		{
			String sql = "SELECT MAX(STD_ID) FROM DB2ADMIN.STANDARDINFODB";
			PreparedStatement ps = cn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			
			rs.next();
			stdId = rs.getInt(1);
			return stdId + 1;
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return stdId;
	}



}
