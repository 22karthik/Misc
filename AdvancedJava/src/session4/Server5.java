package session4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server5 {
	
	public static void main(String args[])
	{
		//make the server wait in infinte loop
		try
		{
			ServerSocket server=new ServerSocket(8005);
			while(true){
				
			Socket s=server.accept();//returns type of accept() is socket
			
			new ClientHandler(s).start();
			
			
			
		
		
			}//try
		
		
		}
	
	catch(Exception e){
		e.printStackTrace();
	}
	
	}


}
