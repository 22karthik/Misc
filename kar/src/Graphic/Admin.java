package Graphic;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.JPanel;
import java.awt.BorderLayout;
public class Admin extends JFrame {

public Admin()
{
	JFrame f=new JFrame("hello");
	setLayout(new BorderLayout());
	
	JPanel p1=new JPanel();
	JLabel l1=new JLabel("Enter your name");
	JTextField t1=new JTextField(15);
	//adds to panel
	p1.add(l1);
	p1.add(t1);
	//add the panel to frame
	f.add(p1,BorderLayout.NORTH);
	
	JPanel p2=new JPanel();
	p2.setLayout(new GridLayout(2,2));
	JLabel l2=new JLabel("enter your date of birth");
	JTextField t2=new JTextField(15);
   
	p2.add(l2);
	p2.add(t2);
    f.add(p2,BorderLayout.WEST);
  
	JPanel p3=new JPanel();
	JButton b1=new JButton("Submit");
	p3.setLayout(new BorderLayout()); 
	                             
	p3.add(b1);
	f.add(p3,BorderLayout.SOUTH);

	f.setLayout(new FlowLayout());
	
	f.pack();
	f.setVisible(true);
   
}

 public static void main(String args[])
 {
	 Admin a=new Admin();
	 
 }
}
/*steps to different panels for the same frame
create a frame
create a panel 
set the layout of the panel
add the components to the panel
then add the panel to the frame
*/

/*steps to implement actionlistener for a button
make the class implement the actionlistener interface
then override the method actionPerformed
public void actionPerformed(ActionEvent args[0)*/