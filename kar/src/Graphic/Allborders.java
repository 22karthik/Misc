package Graphic;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollBar;

public class Allborders extends JFrame {

	public Allborders()
	{
		//create just one frame
		JFrame f=new JFrame("All borders");
		JButton b1,b2,b3,b4,b5,b6,b7,b8,b9,b10,b11,b12,b13;
		//section1
		//create the borderlayout
		setLayout(new BorderLayout());
		//create a panel
		JPanel p1=new JPanel();
		
		b1=new JButton();
		b2=new JButton();
		b3=new JButton();
		b4=new JButton();
		b5=new JButton();
		//add the buttons to the panel
		p1.add(b1);
	    p1.add(b2);
	    p1.add(b3);
	    p1.add(b4);
	    p1.add(b5);
	   //specify where the panel has to appear in the frame
	    
	    f.add(p1,BorderLayout.NORTH);
	
	  //create another panel
     JPanel p2=new JPanel();
		//here change the layout of the panel,later on add the whole panel to center of the frame
	   p2.setLayout(new GridLayout(3,2));	
     b6=new JButton();
		b7=new JButton();
		b8=new JButton();
		b9=new JButton();
		b10=new JButton();
	
	//add the buttons to the panel
		p2.add(b6);
		p2.add(b7);
		p2.add(b8);
		p2.add(b9);
		p2.add(b10);
	
	f.add(p2,BorderLayout.CENTER);
	
	
	JPanel p3=new JPanel();
	p3.setLayout(new FlowLayout());
	b11=new JButton();
    JComboBox c=new JComboBox();
	JScrollBar s=new JScrollBar();
	p3.add(b11);
	p3.add(c);
	p3.add(s);
	f.add(p3,BorderLayout.SOUTH);
	
	
	
	f.pack();
	f.show();
	}
	
	public static void main(String args[])
	{
		Allborders a=new Allborders();
	}
}
