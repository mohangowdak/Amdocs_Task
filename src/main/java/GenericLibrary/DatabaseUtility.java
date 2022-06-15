
package GenericLibrary;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;


import com.mysql.cj.jdbc.Driver;

/**
 * This method consists of all generic methods related to database
 * @author LHR
 *
 */
public class DatabaseUtility 
{
	Connection con=null;
	
	/**
	 * This method will register the database
	 * @throws Throwable
	 */
	public void registerDatabase() throws Throwable
	{
		Driver driverref=new Driver();
		DriverManager.registerDriver(driverref);
		
	}
	
	/** 
	 * This method is used to establish the connection for the databas
	 * @param url
	 * @param username
	 * @param passowrd
	 * @throws Throwable
	 */
   public void databaseConnection(String url, String username, String passowrd) throws Throwable
  {
  DriverManager.getConnection(IPathConstants.dburl, IPathConstants.username, IPathConstants.password);
  }
   
   /**
    * This method will close the datavbase
 * @throws Throwable 
    */
   public void closeDB() throws Throwable
   {
	   con.close();
   }
   
   /**
    * This method will execute query and return the matching data to user
 * @throws Throwable 
    * @throws Throwable
    */
   public String executeQueryAndGetData(String query, int colindex, String expdata) throws Throwable
   {
	   boolean flag=false;//
	   String data=null;
	   ResultSet result = con.createStatement().executeQuery(query);//method chaining
	   while(result.next())
	   {
		   
		   data=result.getString(colindex);
		   if(data.equalsIgnoreCase(expdata))
		   {
			   flag=true;// flag rising
			   break;
		   }
	   }
	   if(flag)
	   {
		  System.out.println(data+"---------->data verified"); 
		  return expdata;
	   }
	   
	   else
	   {
		   System.out.println("data not verified");
		   return "";
	   }
   }
   
   
   
   

}











