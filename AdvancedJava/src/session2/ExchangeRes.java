package session2;

import java.awt.*;
import java.awt.event.*;
import java.text.*;
import java.util.Date;
import java.io.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.*;

public class ExchangeRes extends JFrame implements ActionListener {

	JTextField t1;
	JTextField t2;
	JFrame f;
	Date date;
	double f1;
	String str_date;

	// create the constructor
	public ExchangeRes() {
		f = new JFrame("ExchangeRes");
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setLayout(new GridBagLayout());

		GridBagConstraints gbc = new GridBagConstraints();

		// create the textbox and the labels
		JLabel l1 = new JLabel("Date (yyyy-mm-dd)");
		gbc.gridx = 0;
		gbc.gridy = 0;
		f.add(l1, gbc);

		t1 = new JTextField("", 20);

		gbc.gridx = 4;
		gbc.gridy = 0;
		f.add(t1, gbc);

		// convert the text to date

		JLabel l2 = new JLabel("Exchange Rate");
		gbc.gridx = 8;
		gbc.gridy = 0;
		f.add(l2, gbc);

		t2 = new JTextField("", 20);

		gbc.gridx = 10;
		gbc.gridy = 0;
		f.add(t2, gbc);
		// convert the text to double

		JButton b1 = new JButton("Add");
		b1.addActionListener(this);
		b1.setSize(200, 200);
		gbc.gridx = 6;
		gbc.gridy = 1;
		f.add(b1, gbc);
		f.pack();
		f.setVisible(true);

	}

	public static void main(String args[]) {
		ExchangeRes r1 = new ExchangeRes();

	}

	private void showTable(String string, String url, String username, String password, String tablename,
			PrintWriter out) {
		Connection connection = null;
		Statement stmt = null;
		int result;
		// load driver
		try {
			Class.forName("com.mysql.jdbc.Driver");
			// establish connection

		}

		catch (ClassNotFoundException cnfe) {
			System.err.println("class not found");
		}

		try {
			connection = DriverManager.getConnection(url, username, password);
			stmt = connection.createStatement();
			String query = "insert into dailyrate (date,rate) values('" + t1.getText() + "'," + f1 + ")";
			result = stmt.executeUpdate(query);
			System.out.println(result);

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		finally {
			try {
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// validate the date and the exchange

		String regExp = "\\d{4}-\\d{2}-\\d{2}";

		String str1 = t1.getText();
		System.out.println(str1);
		// validate the date string

		if (str1.matches(regExp)) {
			System.out.println("Well done");

		}

		else {
			JOptionPane.showMessageDialog(f, "please enter the date properly");

		}

		PrintWriter out = new PrintWriter(System.out, true);
		String url = "jdbc:mysql://localhost/exchangerate?autoReconnect=true&useSSL=false";
		String username = "root";
		String password = "";
		String tablename = "dailyrate";
		DateFormat formatter;
		formatter = new SimpleDateFormat("yyyy-MM-dd");
		try {
			str_date = t1.getText();

			date = new java.sql.Date(formatter.parse(str_date).getTime());
			System.out.println("after parsing" + date + "");

		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try
		{
			f1 = Double.parseDouble(t2.getText());
			System.out.println(f1);
		}
		
    catch(NumberFormatException e1)
		{
    	  System.err.println("please enter the number");
		}
		showTable("", url, username, password, tablename, out);

	}

}
