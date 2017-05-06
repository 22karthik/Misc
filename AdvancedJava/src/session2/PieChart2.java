package session2;


import java.awt.*;
import java.awt.event.*;
import java.text.*;
import java.util.Date;
import java.io.*;
import java.sql.*;

import org.jfree.chart.*;
import org.jfree.chart.plot.PiePlot3D;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.general.PieDataset;
import org.jfree.util.Rotation;

import javax.swing.*;
public class PieChart2  extends JFrame {
	double avg=0;
	ResultSet result=null;
	int[] a=new int[50];
	int count1;
	int count2;
	int count3;
	PieChart p;
	BelowBetweenAbove bba1=BelowBetweenAbove.BELOW;
	BelowBetweenAbove bba2=BelowBetweenAbove.ABOVE;
	BelowBetweenAbove bba3=BelowBetweenAbove.BETWEEN;
	
	
	private static final long serialVersionUID = 1L;

	public PieChart2()
	{
		
	}
	
    public PieChart2(String applicationTitle, String chartTitle) {
    	 
    super(applicationTitle);
    double x=calcAvg(25);
    // This will create the dataset
    PieDataset dataset = createDataset();
    // based on the dataset we create the chart
    JFreeChart chart = createChart(dataset, chartTitle);
    // we put the chart into a panel
    ChartPanel chartPanel = new ChartPanel(chart);
    // default size
    chartPanel.setPreferredSize(new java.awt.Dimension(500, 270));
    
   
    // add it to our application
    setContentPane(chartPanel);

}

/**
 * Creates a sample dataset
 */
private  PieDataset createDataset() {
    DefaultPieDataset result = new DefaultPieDataset();
    
  
    result.setValue("Before",count1);
    result.setValue("After", count2);
    result.setValue("Same", count3);
    return result;

}

/**
 * Creates a chart
 */
private JFreeChart createChart(PieDataset dataset, String title) {

    JFreeChart chart = ChartFactory.createPieChart3D(
        title,                                  // chart title
        dataset,                // data
        true,                   // include legend
        true,
        false
    );

    PiePlot3D plot = (PiePlot3D) chart.getPlot();
    plot.setStartAngle(290);
    plot.setDirection(Rotation.CLOCKWISE);
    plot.setForegroundAlpha(0.5f);
    return chart;

}






     public static void main(String[] args) {
         
    	 PieChart2 p=new PieChart2();
         double x=p.calcAvg(25);
         System.out.println(x);
            
    	 PieChart2 demo = new PieChart2("Comparison", "The Exchange rate");
       
            demo.pack();
       
            demo.setVisible(true);
        }

     //calculate the avg
     public double calcAvg(int offset)
     {
    	    String url="jdbc:mysql://localhost/exchangerate?autoReconnect=true&useSSL=false";
			String username="root";
			String password="";
			String Driver="";
			int i=0;
			
			
			double d;
			double sum = 0;
			
			  int count = 0;
			  
			
			Connection connection = null;	
			 Statement stmt = null;
				
				
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
				
				String query="select rate from dailyrate";
			 
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
				      
					count++;
					i=Integer.parseInt(result.getString("rate"));
					a[count]=i;
					System.out.println("double parse is"+i);
					 sum=(int)(sum+i);
					 
					
						
					}
					
					System.out.println("count is"+count);
					System.out.println("sum is"+sum);
					avg=(int)sum/count;
					System.out.println("avg is"+avg);
					
					int max=(int)avg+offset;
					int min=(int)avg-offset;
					for(int m=0;m<count;m++){
					
						if(max<a[m])
							 count1++;
						else if(max>a[m])
							 count2++;
						else
							count3++;
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
				
			
			
			return 0;
			
     }
    
     
}
