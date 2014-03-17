package able.helper;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import able.dbclass.Connect;

public class CheckMod_AcceptAllPendingPost {
	public boolean acceptmod_allpendingpost(int modpostid)
	{
		try
		{
			Connect con = new Connect();
			Connection cn = con.connectdb();
		
			int modtagid = 0,modid,dbtagid;
		//select details from table modpostdb  based on postid	
			
			String sql1 = "SELECT mod_title, mod_email, mod_postdate, mod_content FROM DB2ADMIN.MODPOSTDB where mod_postid = ?";
			PreparedStatement ps = cn.prepareStatement(sql1);
			ps.setInt(1, modpostid);
			ResultSet rs = ps.executeQuery();
	
				rs.next();
				String dbmodtitle = rs.getString("mod_title");
				String dbmodemail = rs.getString("mod_email");
				String dbmoddate = rs.getString("mod_postdate");
				String dbmodcontent = rs.getString("mod_content");
			
		//get the maximum value of postid from table postdb		
				
			String sql2 = "SELECT MAX(POSTID) FROM DB2ADMIN.POSTDB";
			ps = cn.prepareStatement(sql2);
			rs = ps.executeQuery();
			
				rs.next();
				int mod_linkId = rs.getInt(1);
	
		//store the max postid of table postdb in variable modid(also use this id in sql stmt9 to insert in table modposttagdb 		
		
				modid = mod_linkId + 1;			
			
		//insert the new postid(got in previous sql stmt) and the values		
				
			String sql3 = "INSERT INTO DB2ADMIN.POSTDB VALUES(?,?,?,?,?)";
			ps = cn.prepareStatement(sql3);
			ps.setInt(1, modid);
			ps.setString(2, dbmodtitle);
			ps.setString(3, dbmodemail);
			ps.setString(4, dbmoddate);
			ps.setString(5, dbmodcontent);
			ps.executeUpdate();
			cn.commit();
	
		//select tagid based on postid from table modposttagdb	
			
			String sql5 = "SELECT MOD_TAGID FROM DB2ADMIN.MODPOSTTAGDB WHERE MOD_POSTID=?";
			PreparedStatement ps5 = cn.prepareStatement(sql5);
			ps5.setInt(1, modpostid);
			ResultSet rs5 = ps5.executeQuery();
	
		//fetch all the modtagid from table modposttagdb based modpostid
			
			while(rs5.next())
			{
				modtagid = rs5.getInt("mod_tagid");
				
		//select the tag title from table modtagdb based on tagid.		
				
				String sql6 = "SELECT MOD_TAGTITLE FROM DB2ADMIN.MODTAGDB WHERE MOD_TAGID=?";
				PreparedStatement ps6 = cn.prepareStatement(sql6);
				ps6.setInt(1, modtagid);
				ResultSet rs6 = ps6.executeQuery();
				
				rs6.next();
				
				String modtagtitle = rs6.getString("mod_tagtitle");
		
		//find max of tagid and increment it to 1 so insert into		
				
				String sql7 = "SELECT MAX(TAGID) FROM DB2ADMIN.TAGDB";
				PreparedStatement ps7 = cn.prepareStatement(sql7);
				ResultSet rs7 = ps7.executeQuery();
					rs7.next();
					dbtagid = rs7.getInt(1);
					int new_dbtagid = dbtagid + 1; 
					
		//insert the values in table tagdb 	
					
					String sql8 = "INSERT INTO DB2ADMIN.TAGDB VALUES(?,?)";
					PreparedStatement ps8 = cn.prepareStatement(sql8);
					ps8.setInt(1, new_dbtagid);
					ps8.setString(2, modtagtitle);
					ps8.executeUpdate();
					cn.commit();
					
		//insert the values in table posttagdb			
					
					String sql9 = "INSERT INTO DB2ADMIN.POSTTAGDB VALUES(?,?)";
					PreparedStatement ps9 = cn.prepareStatement(sql9);
					ps9.setInt(1, modid);
					ps9.setInt(2, new_dbtagid);
					ps9.executeUpdate();
					cn.commit();	
					
			//delete from table modposttagdb based on postid

					String sql10 = "DELETE FROM DB2ADMIN.MODPOSTTAGDB WHERE MOD_POSTID=?";
						PreparedStatement ps10 = cn.prepareStatement(sql10);
						ps10.setInt(1, modpostid);
						ps10.executeUpdate();
						
			//delete from table modtagdb based on tagid	
			
						String sql11 = "DELETE FROM DB2ADMIN.MODTAGDB WHERE MOD_TAGID=?";
						PreparedStatement ps11 = cn.prepareStatement(sql11);
						ps11.setInt(1, modtagid);
						ps11.executeUpdate();			
			}
			
		
			//delete from table modpostdb based on postid	
			String sql4 = "DELETE FROM DB2ADMIN.MODPOSTDB where mod_postid=?";
				ps = cn.prepareStatement(sql4);
				ps.setInt(1, modpostid);
				ps.executeUpdate();
			
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
