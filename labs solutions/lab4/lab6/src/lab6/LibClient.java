package lab6;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class LibClient
{
	public static final int borrow_port = 6666;
	public static final int  return_back_port = 6667;
	 Library lib=new Library();
	public static void main(String[] args) throws UnknownHostException, IOException 
	{
		System.out.println("Enter the client name ..........");
		Scanner scanner = new Scanner(System.in);
		String name = (scanner.next());
		
		Socket s1 = new Socket("localhost", borrow_port);
		Socket s2 = new Socket("localhost",  return_back_port);
		
		
		PrintWriter outs1 = new PrintWriter(s1.getOutputStream(), true);
		PrintWriter outs2 = new PrintWriter(s2.getOutputStream(), true);
		
		BufferedReader socketReader = new BufferedReader(new InputStreamReader(s1.getInputStream()));
		
	
		BufferedReader socketReader2 = new BufferedReader(new InputStreamReader(s2.getInputStream()));
		
		

//		 outs1.println(name); //send message to server
//        outs2.println(name); //send message to server
//		
		////////////////////////
		while(true)
        {

          
//			 outs1.println(name); //send message to server
//	         outs2.println(name); //send message to server
			System.out.println("Enter the port you want to connect to: (1)borrow_port (2) return_back_port");
			Scanner scan = new Scanner(System.in);
			int port=0 ;
			if(scan.nextInt() == 1 )  //borrow_port: return_back_port;
			port=borrow_port;
			else
		  port=return_back_port;
				
			System.out.println("Enter the isbn of the book");
			Scanner scan1 = new Scanner(System.in);
			Integer isbn= (scanner.nextInt()) ;
			//System.out.println(isbn);
			String convertedMessage="" ;//= socketReader.readLine();  
			if(port==borrow_port)
			{
				 outs1.println(name); //send message to server
				 outs1.println(isbn);
				 convertedMessage = socketReader.readLine();  
			}
			else if(port== return_back_port)
			{
				 outs2.println(name); //send message to server
				outs2.println(isbn);
				convertedMessage = socketReader2.readLine();  
			}
			
			if(name.equals(""))
            	break;
				
			
			
			         
			System.out.println("The received message = " + convertedMessage + "\n");
			
			
        }
		System.out.println("I am exiting now, bye.");
		scanner.close();
		outs1.close();
		outs2.close();
		s1.close();
		s2.close();
	}

}
