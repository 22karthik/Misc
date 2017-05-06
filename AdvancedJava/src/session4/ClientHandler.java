package session4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;

public class ClientHandler extends Thread {

	private Socket s;
	public ClientHandler(Socket s){
		this.s=s;
		
	}
	
	public void run()
	{
		try{
			
		
		//read n write from the buffer
		BufferedReader b1=new BufferedReader(new InputStreamReader(s.getInputStream()));
		PrintWriter w=new PrintWriter(new OutputStreamWriter(s.getOutputStream()));	
		w.println("Hello welcome to server2");
		w.println("Enter BYE to leave the server");
		w.flush();
		
		String str=null;
		
		while((str=b1.readLine())!=null)
		{
			int count=0;
			  
			System.out.println("received:"+str);
			w.println("Echo:"+str);
			w.flush();
			
			if(count<5)
			{
				break;
			}
		}
		}
		
		catch(Exception e){
			e.printStackTrace();
		}
		
			
	}
	}


