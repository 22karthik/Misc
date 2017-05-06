package Graphic;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class BorderLyt extends JFrame {

	public static void main(String args[])
	{
		JFrame f1=new JFrame("BorderLyt");
		JPanel p1=new JPanel();
	    JButton b1=new JButton("North");
	    JButton b2=new JButton("South");
	    JButton b3=new JButton("West");
	    JButton b4=new JButton("East");
	    JButton b5=new JButton("center");
	    f1.setLayout(new BorderLayout());
	    f1.add(b1,BorderLayout.NORTH);
	    f1.add(b2,BorderLayout.SOUTH);
	    f1.add(b3,BorderLayout.WEST);
	    f1.add(b4,BorderLayout.EAST);
	    f1.add(b5,BorderLayout.CENTER);
	    f1.pack();
	    f1.show();
	    
	    
	}
	
}
