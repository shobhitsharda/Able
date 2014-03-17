package able.helper;
import java.sql.*;
import able.dbclass.Connect;

public class CheckRegister {
	public boolean create(String firstname, String lastname, String email, String age, String sex, String usertype, String password )
	{
		try
		{
			Connect con = new Connect();
			Connection cn = con.connectdb();
			String sql = "INSERT INTO DB2ADMIN.USERDB VALUES(?,?,?,?,?,?,?)";
			PreparedStatement ps = cn.prepareStatement(sql);
			ps.setString(1, firstname);
			ps.setString(2, lastname);
			ps.setString(3, email);
			ps.setString(4, age);
			ps.setString(5, sex);
			ps.setString(6, usertype);
			ps.setString(7, password);
			ps.executeUpdate();
			cn.commit();
			
			cn.commit();
			ps.close();
			cn.close();
			return true;
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return false;
	}
}
