package lab1;

import java.util.ArrayList;



public class matrix <T extends Number >{
	protected int m;
	protected int n;
	
     protected ArrayList<ArrayList<T>> numbers;
	
	  
	 
	
	
	public matrix(int r,int c)
	
	{
		
		m=r;
		n=c;
		
		 numbers= new ArrayList<ArrayList<T>>(m);
		 for(int i=0;i<m;i++)
		 {
			 ArrayList<T> temp =new ArrayList<T>(n);
			 for(int j=0;j<n;j++)
			 {
				 temp.add(null);
				 
			 }
			 numbers.add(temp);
			 
		 }
		
	}

    public boolean setNumbers(ArrayList<T> one_Row) {
        if (one_Row.size() != m * n)
        {
        	numbers=null;
            return false;
        }

       int val=0;
        for(int i=0;i<m;i++)
        {
        	for(int j=0;j<n;j++)
        	{
        	numbers.get(i).add(j, one_Row.get(val));
        	val++;
        	}
        }

        return true;
    }
    
    public void print() {
       
    	if(this.numbers != null)
    	{
    	for(int i=0;i<m;i++)
    	{
    		for(int j=0;j<n;j++)
    		{
    			
    			 System.out.print(numbers.get(i).get(j));
    			 System.out.print(" ");
    		}
    	System.out.print("\n");
    	
    	}
    	System.out.print("\n");
    	}
    }
    
    
   
void transpose() {
     
	   if(numbers !=null)
	   {
	   
		  
		   ArrayList<ArrayList<T>> transposed;
		   transposed= new ArrayList<ArrayList<T>>(n);
		   
			 for(int i=0;i<n;i++)
			 {
				 ArrayList<T> t =new ArrayList<T>(m);
				 for(int j=0;j<m;j++)
				 {
					 t.add(null);
					 
				 }
				 transposed.add(t);
				 
			 }
		   
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
            	
            	transposed.get(i).add(j, numbers.get(j).get(i));
            }
        }
        int t=m;
        m=n;
        n=t;
        
        numbers=transposed;
	   }
       
    }
	
	
	
	
	
	
	
	

}
