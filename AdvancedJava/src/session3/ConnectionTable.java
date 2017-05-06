package session3;

import java.sql.*;
import java.io.*;
public class ConnectionTable {
	
	
public static void main(String args[]){
	//params to connect to table
	PrintWriter out = new PrintWriter(System.out, true);		
	String url="jdbc:mysql://localhost/exchangerate?autoReconnect=true&useSSL=false";
			String username="root";
			String password="";
			String tablename="dailyrate";
			
		    out.println("<HTML><HEAD></HEAD><BODY><TABLE>");
		    out.println("<tr><th>idDailyRate</th>&nbsp<th>date</th>&nbsp<th>rate</th></tr>");
			showTable("", url, username, password, tablename, out);
			out.println("</table></BODY></HTML>");
	
	
			
}
			
public static void showTable(String Driver,String url,String username,String password,String tableName,PrintWriter out) 	{		
	 Connection connection = null;	
	 Statement stmt = null;
		ResultSet result=null;
	//load driver
    try
    {
    	Class.forName("com.mysql.jdbc.Driver");
    	 //establish connection
        
    }
    
    catch(ClassNotFoundException cnfe){
    	System.err.println("class not found");
    }	

    try {
	    connection =DriverManager.getConnection(url, username, password);
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}

//create the statement
    
 
	try {
		stmt=connection.createStatement();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
    

//execute query
	
	String query="select idDailyRate,date,rate from dailyrate";
 
	try {
		 result=stmt.executeQuery(query);
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}

//process the result
	
	try {
		while(result.next())
		{
			
			System.out.println("<tr><td>"+result.getString("idDailyRate")+"</td>"+" "+"<td>"+result.getString("date")+"</td>"+""+"<td>"+result.getString("rate")+"</td>"+"</tr>");
		}
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	//finally
	
	finally
	{
		try {
			connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
		
}
