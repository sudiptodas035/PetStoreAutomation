package api.db;
import java.util.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JavaConnectToSQL {

	public static void sqlCon()
	{
		String url="jdbc:sqlserver:LAPTOP-RRORHA7N\\SQLEXPRESS;databaseName=SUDAS";
		String username="";
		String password="";
		
		try {
			Connection connection=DriverManager.getConnection(url,username,password);
			System.out.println(connection.toString());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
