package session4;

import java.net.*;
import java.io.*;
/* server wait for the another connection after breaking the loop*/
public class Server2 {

	public static void main(String args[])
	{
		//make the server wait in infinte loop
		try
		{
			ServerSocket server=new ServerSocket(8002);//server socket
			while(true){
				
			Socket s=server.accept();//returns type of accept() is socket,client socket
			
			//read n write from the buffer
		BufferedReader b1=new BufferedReader(new InputStreamReader(s.getInputStream()));
		PrintWriter w=new PrintWriter(new OutputStreamWriter(s.getOutputStream()));	
		w.println("Hello welcome to server2");
		w.println("Enter BYE to leave the server");
		w.flush();
		
		String str=null;
		
		while((str=b1.readLine())!=null){
			int count=0;
			  
			System.out.println("received:"+str);
			w.println("Echo:"+str);
			w.flush();
			
			if(count<5)
			{
				break;
			}
			
		}
		
		s.close();
			
			}
		
			
		}
	
	catch(Exception e){
		e.printStackTrace();
	}
	
	}


	



}
