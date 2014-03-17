package able.helper;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.Date;
import able.dbclass.Connect;

public class CheckSubmitPost {
	
	public boolean control(String title, String content, String email, String tag)
	{
			
			Connect con = new Connect();
			Connection cn = con.connectdb();
			String date = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
			
			double postId = getPostId(cn);
			boolean return_value = submitPost(cn, postId, title, content, date, email, tag);
			return return_value;
			
	}

	boolean submitPost(Connection cn, double postId, String title, String content, String date, String email, String tag)
	{
		try
		{
			String sql = "INSERT INTO DB2ADMIN.MODPOSTDB VALUES(?,?,?,?,?)";
			PreparedStatement ps = cn.prepareStatement(sql);
			ps.setDouble(1, postId);
			ps.setString(2, title);
			ps.setString(3, email);
			ps.setString(4, date);
			ps.setString(5, content);
			ps.executeUpdate();
	
			String[] words = tag.split(",");
			for (String str : words) 
			{
			
				String sql2 = "SELECT MAX(MOD_TAGID) FROM DB2ADMIN.MODTAGDB";
					ps = cn.prepareStatement(sql2);
					ResultSet rs = ps.executeQuery();
					rs.next();
					int tagId = rs.getInt(1);
					int mod_tagid = tagId + 1;
				

				String sql3 = "INSERT INTO DB2ADMIN.MODPOSTTAGDB VALUES(?,?)";
					ps = cn.prepareStatement(sql3);
					ps.setDouble(1, postId);
					ps.setInt(2, mod_tagid);
					ps.executeUpdate();
					
				String sql4 = "INSERT INTO DB2ADMIN.MODTAGDB VALUES(?,?)";
					ps = cn.prepareStatement(sql4);
					ps.setInt(1, mod_tagid);
					ps.setString(2, str);
					ps.executeUpdate();
			}
		
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
	double getPostId(Connection cn)
	{
		double postId = 0;
		try
		{
			String sql = "SELECT MAX(MOD_POSTID) FROM DB2ADMIN.MODPOSTDB";
			PreparedStatement ps = cn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			
			rs.next();
			postId = rs.getDouble(1);
			return postId + 1;
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return postId;
	}
}
