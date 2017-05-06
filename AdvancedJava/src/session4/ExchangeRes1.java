package session4;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ExchangeRes1 extends JFrame implements ActionListener{
	
	static double fxrt;
	JTextField fexrate;
	static JTextField fdate;
	
	public ExchangeRes1() throws ParseException{
	
	this.setLayout(new BorderLayout());
	JPanel pnorth = new JPanel();
	JLabel date = new JLabel ("Date yyyy-mm-dd");
	
	fdate = new JTextField ();//text field


	fdate.setPreferredSize(new Dimension(200,25));
	JLabel exrate = new JLabel ("Exchange Rate");
	fexrate = new JTextField ("", 30);
	
	
	//Date myDate = sdf.parse(fdate.getText());
	
	pnorth.add(date);
	pnorth.add(fdate);
	pnorth.add(exrate);
	pnorth.add(fexrate);
	this.add(pnorth,BorderLayout.NORTH);
	
	JButton add = new JButton("Add");
	this.add(add, BorderLayout.CENTER);
	add.addActionListener(this);
	this.pack();
	this.show();
	
	}
	
	public void actionPerformed( ActionEvent e ){
		
		 fxrt = Double.parseDouble(fexrate.getText());
			System.out.println("double value is"+fxrt);
			insertintoTable();
		
	}
	
	public static void printEntireTable(){
		
		try{
			Class.forName("com.mysql.jdbc.Driver");
			
		String mySQLURL = "jdbc:mysql://localhost/exchangerate?autoReconnect=true&useSSL=false";
		String username = "root";
		String password = "";
		
		
			Connection connection = DriverManager.getConnection(mySQLURL,username,password);
		
		
		
		Statement statement = connection.createStatement();
				
		String query = "SELECT * FROM dailyrate";
		ResultSet resultSet = statement.executeQuery(query);
		
		while(resultSet.next()) {
			System.out.println(resultSet.getString("idDailyRate") + " " +
			resultSet.getString("date") + " " +
			resultSet.getString("rate"));
			}
		connection.close();
		} catch(Exception cnfe) {
			System.err.println("Error loading driver: " +cnfe);
		}
			
	}
	
	public static void main(String[] args) throws ParseException {
		// TODO Auto-generated method stub
		
	
		ExchangeRes1 er = new ExchangeRes1();
		printEntireTable();
		

	
}

	private static void insertintoTable() {
		int result;
		System.out.println ("Entered date:"+fdate.getText()) ;
				try{
					Class.forName("com.mysql.jdbc.Driver");
					
				String mySQLURL = "jdbc:mysql://localhost/exchangerate?autoReconnect=true&useSSL=false";
				String username = "root";
				String password = "";
				
				
					Connection connection = DriverManager.getConnection(mySQLURL,username,password);
				
				
				
				Statement statement = connection.createStatement();
				
				
						
				String query = "INSERT INTO dailyrate(date,rate)VALUES('" + fdate.getText() + "'," + fxrt + ")";
				result=statement.executeUpdate(query);
				System.out.println("no of rows inserted"+result);
				
				connection.close();
				} catch(Exception cnfe) {
					System.err.println("Error loading driver: " +cnfe);
				}
		
		
	}
}

