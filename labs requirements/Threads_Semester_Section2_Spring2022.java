/***********************************Requirement description**********************************************/
// •	There is a bookstore that has different branches, each of them sell a number of books, these books are supplied by the Supplier. 
// •	A bookstore shouldn’t sell a book when the number of books is 0, it should block and notify the Supplier to provide more
// •	A supplier shouldn’t provide a book when the max count of books is reached, when it provides a book, it should tell stores that there are more books available.
// •	Modify the requirement_student.java code to reflect this behaviour.
// •	All threads should execute in parallel, you cannot allow a thread to stop another thread (should guarantee progress)
// •	Follow the 8 TODOs in the Code
 /***********************************************************************************************/


class Threadsrequirement {
	 public static void main(String... args) throws InterruptedException {
	 	BookStock b = new BookStock (10);
	 	
	 	 
		
		//TODO-1: Create 4 threads,
		// 1 for Supplier
		// 3 for StoreBranches and Name them as the following: Giza branch, Cairo branch, Daqahley branch
	 	// create objects 
	 	Supplier supplier=new Supplier(b);
	 	StoreBranch Giza_branch=new StoreBranch(b);
	 	StoreBranch Cairo_branch=new StoreBranch(b);
	 	StoreBranch Daqahley_branch=new StoreBranch(b);
	 	
	 	//creating threads 
	 	Thread supplier_thread=new Thread(supplier);
	    Thread Giza_thread=new Thread(Giza_branch);
	    Thread Cairo_thread=new Thread(Cairo_branch);
	    Thread Daqahley_thread=new Thread(Daqahley_branch);
	 	
	    // naming the threads
	    supplier_thread.setName("Supplier");
	    Giza_thread.setName("Giza branch");
	    Cairo_thread.setName("Cairo branch");
	    Daqahley_thread.setName("Daqahley branch");
	 	
      
		//TODO-2: Run the 4 threads
	    supplier_thread.start();
	    Giza_thread.start();
	    Cairo_thread.start();
	    Daqahley_thread.start();
	    
	    
	    
    }
}

class BookStock {
	private int book_count;
	private int max;
	public BookStock  (int max) {
		this.max = max;
	}
	public void produce() {
		book_count++;
	}

	public void consume () {
		book_count--;
	}

	public int getCount () {
		return book_count;
	}
	
	public int getMaxcount()
	{
		return max;
		
	}
}

//TODO-3: should it implement or extend anything? 
// it should implement Runnable interdace  or extend Thread class to be a Thread in jave, in the first way you need to create new Thread and pass the object to 
//it but in the second way you can use the objects directly but i prefer the first way :)

class Supplier implements Runnable  { //added by norhan implements Runnable 
	private BookStock b;

	public Supplier (BookStock b) {
		this.b = b;
	}
//TODO-4:is a function missing ?
	// yes we should add the function run which is implemented by the Thread when it is start
	public void run()
	{
		doWork();
		
	}
	
	public  void doWork () {
		
		while (true) {
	//TODO-5: how to make it stop producing when it reaches max, without adding extra sleeps or busy waiting ?
			//wait
			synchronized(b)
			{
			while(b.getCount()>=b.getMaxcount())
				try {
					
				 b.wait();
				} catch (InterruptedException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			
			b.produce();
			// notify the bookstore that he can consume a book
			b.notifyAll();
			
			System.out.println (Thread.currentThread().getName() + " provided a book, total " +b.getCount());
			}
			try {
				Thread.sleep (1000);
			} catch (InterruptedException e) {
				System.out.println (Thread.currentThread().getName() + "is awaken");
			}
			
        }
	}

}

//TODO-6: should it implement or extend anything? 
//it should implement Runnable interdace  or extend Thread class to be a Thread in jave, in the first way you need to create new Thread and pass the object to 
//it but in the second way you can use the objects directly but i prefer the first way :)

class StoreBranch implements Runnable {
	private BookStock b;

	public StoreBranch (BookStock b) {
		this.b = b;
	}

//TODO-7: is a function missing ?
	// yes, function run
	public void run()
	{
		doWork();
	}
	public  void  doWork () {
		while (true) {
		//TODO-8: how to make it stop consuming when the store is empty, without adding extra sleeps or busy waiting ?
			synchronized(b)
			{
			while(b.getCount()<=0)
				try {
					//notify the supplier that to provide a book 
					b.notifyAll();
					b.wait();
					
				} catch (InterruptedException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			//System.out.println (Thread.currentThread().getName() + " sold a book");
			}
			
			
			
			b.consume();
			System.out.println (Thread.currentThread().getName() + " sold a book");
			
			try {
				Thread.sleep (2000);
			} catch (InterruptedException e) {
				System.out.println (Thread.currentThread().getName() + "is awaken");
			}
			
        }
	}
}
