package lab6;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Library {
	List<Book> books;
	
	public Library()
	{
	 books=new ArrayList<Book> ();
	 
	 
	 
		 
	 Scanner scanner=null;
		try {
			
			scanner = new Scanner(new File("D:\\\\Astudy\\\\second year\\\\second term\\\\APT\\\\labs solutions\\\\lab6\\\\lab6\\\\src\\\\test.txt"));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	        while(scanner.hasNextLine()) {
	            //System.out.println(scanner.nextLine());
	        	String input = scanner.nextLine();
	        	StringTokenizer strtoken = new StringTokenizer(input);
	        	List<String> filetoken = new ArrayList<String>();
	        	while(strtoken.hasMoreElements()){
	        	filetoken.add(strtoken.nextToken());
	        	//System.out.println(filetoken.get(0));
	        	}
	        	Book k=new Book();
	        	for(int i=0;i<filetoken.size();i++)
	        	{
	        		
	        		if(i==0)
	        		k.isbn=filetoken.get(i);
	        		else if(i==1)
	        				k.title=filetoken.get(i);
	        			else if(i==2)
	        				k.author=filetoken.get(i);
	        			else if(i==3)
	        			{
	        				if(filetoken.get(i).equals("true"))
	        				k.borrowed=true;
	        				else 
	        				k.borrowed=false;
	        			}
	        			else if(i==4)
	        				k.borrower=filetoken.get(i);
	        		
	        		
	        	}
	        	System.out.println(k.isbn+" ,"+k.title+" ,"+k.author+" ,"+k.borrower+" ," +k.borrowed+"\n");
	        	books.add(k);
	        	
	        	
        }
	        scanner.close();
	 
	
		
	}
	
	public int Borrow(String client_name,String isBN)
	{ 
	   
		for (int i=0;i<books.size();i++)
		{
			if(books.get(i).isbn!=null && books.get(i).isbn.equals(isBN))
			{ 
				
				if(!books.get(i).borrowed)
				{
					
					books.get(i).borrower=client_name;
					books.get(i).borrowed=true;
					
					return 1;
				}
				else
				{
					
					return 3;
				}
				
			}
			
		}
		return 2;
		
		
	}
	public int ReturnBack(String client_name,String isBN)
	{
		/*for (int i=0;i<books.size();i++)
		{
			if(books.get(i).isbn !=null && books.get(i).isbn.equals(isBN))
			{
				if(books.get(i).borrowed==true && books.get(i).borrower.equals(client_name))
				{
					books.get(i).borrower=null;
					books.get(i).borrowed=false;
					return 1;
					
					
				}
				else if(books.get(i).borrowed==false)
					return 3;
				else if(books.get(i).borrowed==true && !books.get(i).borrower.equals(client_name))
				{
					return 4;
				}
				
			}
			
		}
		return 2;*/
		for (int i=0;i<books.size();i++)
		{
			if(books.get(i).isbn!=null && books.get(i).isbn.equals(isBN))
			{ 
				
				if(!books.get(i).borrowed)
				{
					
					
					
					return 3;
				}
				else
				{
					if(books.get(i).borrower.equals(client_name))
					
					{
						books.get(i).borrower="";
						books.get(i).borrowed=false;
					return 1;
					}
					else
						return 4;
				}
				
			}
			
		}
		return 2;
			
			
		
		
	}
	
	public void Print()
	{
		
		for (int i=0;i<books.size();i++)
		{
			System.out.printf("isbn:%s , borrower:%s \n",books.get(i).isbn,books.get(i).borrower);
			
		}
			
	}

}