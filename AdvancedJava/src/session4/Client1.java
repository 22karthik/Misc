package session4;

import java.net.*;
import java.io.*;

public class Client1 {

	public static void main(String args[]){
		
	try
	{
		Socket server=new Socket("localhost",8005);//port no changes for the customer
		//takes in the input
		BufferedReader in=new BufferedReader(new InputStreamReader(server.getInputStream()));
		
		//gives the output
		PrintWriter w=new PrintWriter(new OutputStreamWriter(server.getOutputStream()));
		for(int i=0;i<5;i++)
		{
			
			System.out.println("sent:line"+i);
			w.println("line:"+i); 
			w.flush();
		}
		
	}
	
	catch(Exception e)
	{
		e.printStackTrace();
	}
	}
}
