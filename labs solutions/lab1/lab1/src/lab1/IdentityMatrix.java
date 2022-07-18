package lab1;

import java.util.ArrayList;
import java.util.Objects;
import java.lang.Integer;
import java.lang.Double;

public class IdentityMatrix <T extends Number> extends matrix <T >{
	
	//constructor
	  public IdentityMatrix(int m, int n) {
	        super(m, n);
	        
	    }
	
	  
	  
	  
	  public boolean setNumbers(ArrayList<T> rows)
	  {
	    
		 boolean flag=true;
		
	        if (super.setNumbers(rows) && (m==n)  ) //&& (rows.get(0).getClass().getName()==Integer.class.getName()) 
	        {

	        for (int i = 0; i < m; i++) 
	            for (int j = 0; j <n; j++) 
	            {
	            	
	                if ((i == j && (double)((super.numbers.get(i).get(j)).doubleValue()) != 1.0) ||  (i != j && (double)((super.numbers.get(i).get(j)).doubleValue()) != 0.0))
	                {
	                	super.numbers=null;
	                   flag=false;
	                   return flag;
	                }
	           }
	            	
	            
	            }
	        else
	        {
	        	super.numbers=null;
	        	flag=false;
	        }
		  
		  return flag;
		  
	  }

	    public void transpose() 
	    {
	    	return;
	    }
	
	  
	
	

}
