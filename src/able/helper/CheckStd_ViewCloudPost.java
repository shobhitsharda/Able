package able.helper;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import able.dbclass.Connect;
import able.dbclass.TbPostDb;
import able.dbclass.TbStandardInfoDb;

public class CheckStd_ViewCloudPost {
	public ArrayList displayallpost(String tag)
	{
		try
		{
	
			Connect con = new Connect();
			Connection cn = con.connectdb();
			int checkpostid = 0;
			int flag=0;
			int new_flag = 0;
			String sql1 = "SELECT TAGID FROM DB2ADMIN.TAGDB WHERE TAGTITLE=?";
			PreparedStatement ps1 = cn.prepareStatement(sql1);
	
			ps1.setString(1, tag);
	
			ResultSet rs1 = ps1.executeQuery();
			ArrayList alist = new ArrayList();
			
			while(rs1.next())
			{
			int tagid = rs1.getInt(1);
			
			String sql2="SELECT DISTINCT POSTID FROM DB2ADMIN.POSTTAGDB WHERE TAGID=?";
				PreparedStatement ps2 = cn.prepareStatement(sql2);
				ps2.setInt(1, tagid);
				ResultSet rs2 = ps2.executeQuery();
				rs2.next();
		
					int postid = rs2.getInt(1);
					if(postid != checkpostid)
					{
						if(flag == 0)
						{
							String sql3 = "SELECT STD_TITLE,STD_POSTDATE,STD_CONTENT,STD_TYPE FROM DB2ADMIN.STANDARDINFODB WHERE STD_TYPE=?";
							PreparedStatement ps3 = cn.prepareStatement(sql3);
							ps3.setString(1, tag);
							ResultSet rs3 = ps3.executeQuery();
							TbStandardInfoDb data1 = new TbStandardInfoDb();
							rs3.next();
						
						
							data1.setStd_title(rs3.getString("std_title"));
							data1.setStd_postdate(rs3.getString("std_postdate"));
							data1.setStd_content(rs3.getString("std_content"));
							data1.setStd_type(rs3.getString("std_type"));
							
							flag = 1;
							data1.setFlag(flag);
							alist.add(data1);
						}
				/*		else if(new_flag == 0)
						{
							TbStandardInfoDb data1 = new TbStandardInfoDb();
							data1.setFlag(new_flag);
							alist.add(data1);
							new_flag = 1;
						}
				*/		
			
						String sql4 = "SELECT POSTID,TITLE,EMAIL,POSTDATE,CONTENT FROM DB2ADMIN.POSTDB WHERE POSTID=?";
						PreparedStatement ps4 = cn.prepareStatement(sql4);
						ps4.setInt(1, postid);
						ResultSet rs4 = ps4.executeQuery();
						TbPostDb data;
						while(rs4.next())
						{
							data = new TbPostDb();
							data.setTitle(rs4.getString("title"));
							data.setEmail(rs4.getString("email"));
							data.setPostdate(rs4.getString("postdate"));
							data.setContent(rs4.getString("content"));
							int dbpostid = rs4.getInt("postid");
							
							CheckViewAcceptedTag fetch_tag = new CheckViewAcceptedTag();
							String tags = fetch_tag.display_acceptedtag(postid);
						data.setTags(tags);
			
							alist.add(data);
						}
						checkpostid = postid;
					}	
			}
			ps1.close();
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
