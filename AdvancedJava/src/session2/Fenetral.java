package session2;

import java.awt.*;

import javax.swing.*;

public class Fenetral extends JFrame {
	
	public Fenetral()
	{
		//add the frame
		JFrame f=new JFrame();
		f.setLayout(new BorderLayout());
	    
		//create the buttons
		JButton b1=new JButton("North");
		JButton b2=new JButton("South");
		JButton b3=new JButton("Center");
		JButton b4=new JButton("East");
		JButton b5=new JButton("West");
		
		//add the buttons
		f.add(b1,BorderLayout.NORTH);
		f.add(b2,BorderLayout.SOUTH);
		f.add(b3,BorderLayout.CENTER);
		f.add(b4,BorderLayout.EAST);
		f.add(b5,BorderLayout.WEST);
		f.pack();
		f.setVisible(true);
		
	}


public static void main(String args[]){
	Fenetral f1=new Fenetral();
}

}
