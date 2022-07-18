package lab6;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
public class LibServer {
	
	
	public static final int borrow_port = 6666;
	public static final int  return_back_port = 6667;
	  static Library lib=new Library();
	
	 

	public static int clientNumber = 0; // to keep track of the number of clients connecting to the server.
	
	
	public static void main(String[] args)
	
	{
		
		System.out.println("The server started .. ");
  
		new Thread() {
			public void run() {
				try {
					ServerSocket s1 = new ServerSocket(borrow_port);
					while (true) {
						new CaseChanger(s1.accept(), clientNumber++).start();
					}
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}.start();

		new Thread() {
			public void run() {
				try {
					ServerSocket s2 = new ServerSocket(return_back_port);
					while (true) {
						new CaseChanger(s2.accept(), clientNumber++).start();
					}
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}.start();
		
		
		 
		
		
		
		
		
		
	}
	
	
	private static class CaseChanger extends Thread {
		Socket socket;
		int clientNo;

		public CaseChanger(Socket s, int clientNo) {
			this.socket = s;
			this.clientNo = clientNo;
			System.out.println("Connection with Client #" + clientNo + "at socket " + socket);
		}
	
		public void run() {
			try {
				BufferedReader br = new BufferedReader(new InputStreamReader(this.socket.getInputStream()));
				PrintWriter out = new PrintWriter(this.socket.getOutputStream(), true);
				
				 //Send a welcome message to the client.
               // out.println("Hello, you are client #" + clientNo + ".");

				
				
					
                while (true) {
                	
                
					if (this.socket.getLocalPort() ==borrow_port )
					{
						String name = null;
						String isbn = null;
						
							if ((name = br.readLine()) == null )
								break;
							if ((isbn= br.readLine()) == null )
								break;
							System.out.println(name +" borrow");
							System.out.println(isbn +" borrow");
						String message="";
						int val=lib.Borrow(name, isbn);
						if(val==1)
						message="the borrow is done successfully (Success)";
						else if(val==2)
							message="the isbn is not found in library (Failure)";
						else if(val==3)
							message="the isbn is already borrowed (Failure)";
						else
							message="nothing";
						out.println(message);
						
						
						lib.Print();
					}
					else if(this.socket.getLocalPort() ==return_back_port)
					{
						//System.out.println("ahhhhhhhhhhhhhhhhhhhhhhhs");
						String name = null;
						String isbn = null;
						
							if ((name = br.readLine()) == null )
								break;
							if ((isbn= br.readLine()) == null )
								break;
							System.out.println(name+" return");
							System.out.println(isbn+ " return");
							
						String message="";
						int val=lib.ReturnBack(name, isbn);
						if(val==1)
						message="the return back is done successfully (Success)";
						else if(val==2)
							message="the isbn is not found in library (Failure)";
						else if(val==3)
							message="the isbn is not borrowed (Failure)";
						else if(val==4)
							message="the isbn is borrowed by a different client name (Failure)";
						else
							message="nothing";
						out.println(message);
						
						lib.Print();
						
					}

					
				}
				out.close();
				br.close();
				socket.close();
				System.out.println("Connection with Client #" + this.clientNo + " finished..");
			} catch (IOException e) {
                System.out.println("Error handling client# " + this.clientNo + ": " + e);
            } finally {
                try {
                    socket.close();
                } catch (IOException e) {
                    System.out.println("Couldn't close a socket, what's going on?");
                }
                System.out.println("Connection with client# " + this.clientNo + " closed");
            }
		}
	}
	
	
	
	
	

	
	
}
