package Library_Management;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class DbConnection 
{
	Connection con;

	DbConnection() 
	{
		try {
//			driver loaded successfully
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Library_Management","root","");
			System.out.println("Connection got Successful");
		}
		
		catch(Exception e)
		{
			System.out.println(e);
		}
	}

	public static void main(String[] args) throws Exception
	{
		new DbConnection();
	}
}
