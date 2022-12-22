package Connection_Provider;

import java.sql.Connection;
import java.sql.DriverManager;

public class DatabaseConfig {
	Connection con;	
	public DatabaseConfig()
	{
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver"); 
	         con= DriverManager.getConnection("jdbc:mysql://localhost:3306/phoenix","root","Y1012Jqkhkp"); //url connection 
	      
		}catch(Exception d) {
			System.out.println(d.getMessage());
		}
	}
	public Connection getCon()
	{
		return con;		
	}
}
