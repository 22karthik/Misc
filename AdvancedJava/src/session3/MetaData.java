package session3;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;

public class MetaData {


	
		public static void main(String[] args) {
			PrintWriter out = new PrintWriter(System.out, true);
			String url = "jdbc:mysql://localhost/exchangerate";
			String username = "root";
			String password = "";
			String tableName="dailyrate";
			
			out.println("<HTML><HEAD></HEAD><BODY><TABLE>");
			showTable("", url, username, password, tableName, out);
			out.println("</BODY></HTML>");
		}

		private static void showTable(String driver,
				String url,
				String username,
				String password,
				String tableName,
				PrintWriter out) {
			try {
				Class.forName("com.mysql.jdbc.Driver").newInstance();
				Connection connection =
					DriverManager.getConnection(url, username, password);
				DatabaseMetaData dbMetaData = connection.getMetaData();
				out.println("<UL>");
				String productName =
					dbMetaData.getDatabaseProductName();
				out.println("  <LI><B>Database:</B> " +
						productName);
				String productVersion =
					dbMetaData.getDatabaseProductVersion();
				out.println("  <LI><B>Version:</B> " +
						productVersion +
				"\n</UL>");
				Statement statement = connection.createStatement();
				String query =
					"SELECT * FROM " + tableName;
				ResultSet resultSet = statement.executeQuery(query);
				out.println("<TABLE BORDER=1>");
				ResultSetMetaData resultsMetaData =
					resultSet.getMetaData();
				int columnCount = resultsMetaData.getColumnCount();
				out.println("<TR>");
				for(int i=1; i<columnCount+1; i++) {
					out.print("<TH>" + resultsMetaData.getColumnName(i)+"</TH>");
				}
				out.println();
				while(resultSet.next()) {
					out.println("<TR>");
					for(int i=1; i<columnCount+1; i++) {
						out.print("<TD>" + resultSet.getString(i) + "</TD>");
					}
					out.println();
				}
				out.println("</TABLE>");
				connection.close();
			} catch(Exception e) {System.out.println(e.getMessage());}
		}
	}



