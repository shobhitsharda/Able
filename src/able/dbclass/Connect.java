// This is to connect to database 
package able.dbclass;
import java.sql.*;
public class Connect {
	public Connection connectdb()//Function to Create connection with DB2 Database
	{
		try{
			Class.forName( "com.ibm.db2.jcc.DB2Driver" ); 
			Connection con = DriverManager.getConnection( "jdbc:db2://localhost:50000/ABLE", "db2admin", "tgmc" ); 
			
		//returning the connection variable con
			
			return con;
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return null;
	}
}
