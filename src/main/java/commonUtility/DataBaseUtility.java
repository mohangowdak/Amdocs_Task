package commonUtility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class DataBaseUtility {
	
	Connection conn;
	
	public void connectToDataBase() throws SQLException {
		
		Driver driverRef=new Driver();
		DriverManager.registerDriver(driverRef);
		conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "root");	
	}
	
	public void closeConnection() throws SQLException {
		conn.close();
	}
	
	public String executeQuery(int index) throws SQLException {
		Statement stat = conn.createStatement();
		String query="select * from calender;";
		ResultSet result = stat.executeQuery("query");
		String value="";
		while(result.next()) {
		    value = result.getString(index);
			return value;
		}
		return value;
	}

}
