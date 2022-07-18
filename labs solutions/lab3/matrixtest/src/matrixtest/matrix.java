package matrixtest;
import mpi.*;
import java.io.File;
import java.util.Scanner;

public class matrix
 {

	
	public static void main(String[] args) 
     {
		
		// TODO Auto-generated method stub
		int arr_size;
		
		int recevbuff[];
		 int global_sum=0, local_sum=0;
		 MPI.Init(args);
         int rank = MPI.COMM_WORLD.Rank();
        int size = MPI.COMM_WORLD.Size();
       int arr[]=new int[10000];
       int local_sums[]=new int[1];
       int arr_length[]=new int[1];
	   if(rank==0)
         {
         
             arr=readFiles("D:\\Astudy\\second year\\second term\\APT\\labs solutions\\lab4\\matrixtest\\src\\matrixtest\\test.txt");
           arr_size=arr.length;
           int remain=arr_size-size*(arr_size/size);
           for(int i=arr_size-remain;i<arr_size;i++)
           local_sum+=arr[i];
           //System.out.print("i'm the root process, my rank is: "+rank+" my local sum is: ,"+local_sum +" \n");
         arr_length[0]=arr.length;
           
           
           
 
         }
	 
	  	         
          
      	   
             //arr_length[0]=arr_size;
      	 MPI.COMM_WORLD.Bcast(arr_length,0,1, MPI.INT, 0);
      	 
      //	System.out.print(arr_length[0]+" \n");
    arr_size=arr_length[0];
    int elements_per_process=arr_size/size;
    int first=rank*elements_per_process;
      	recevbuff=new int[arr_size];
	   MPI.COMM_WORLD.Scatter(arr,first,elements_per_process, MPI.INT, recevbuff, 0,elements_per_process, MPI.INT, 0);
         
	  
	  
	   for(int i=0;i<elements_per_process;i++)
	   {
		   System.out.print("i'm a process, my rank is: "+rank+"  i received,"+recevbuff[i]+" \n");
		   local_sum +=recevbuff[i];
	   }
	  
	   System.out.print("i'm a process, my rank is: "+rank+" my local sum is: "+local_sum+" \n");
	   
	   int psum[]=new int[1];
	   psum[0]=local_sum;
	   
	   MPI.COMM_WORLD.Reduce(psum,0,local_sums ,0,1, MPI.INT, MPI.SUM,0);
	 
	   
	   
	   if(rank==0)
	   {
		   global_sum+=local_sums[0];
 
           System.out.print("i'm root process, my rank is: "+rank+"  global sum,"+global_sum+" \n");
           
	   }
	   
	

        MPI.Finalize();
	}
        public static int[] readFiles(String file) 
        {
        	
        	try {
        	File f=new File(file);
        	Scanner s=new Scanner(f);
        	int ctr=0;
        	while (s.hasNextInt())
        	
        	{
        		ctr++;
        		s.nextInt();
        	}
        	
        	int [] arr=new int [ctr];
        	Scanner s1=new Scanner(f);
        	
        	for(int i=0;i<arr.length;i++ )
        		arr[i]=s1.nextInt();
        	return arr;
        	}
        	catch(Exception e)
        	{
        		return null ;
        	}
        	
        }
   
}
	