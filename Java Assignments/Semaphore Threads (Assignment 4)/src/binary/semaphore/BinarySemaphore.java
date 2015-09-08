package binary.semaphore;

public class BinarySemaphore extends Semaphore
{

	public BinarySemaphore(int initial)
	{
		value = (initial >=1) ? 1 : 0;
	}
	
	public synchronized void P() throws InterruptedException
    {
         while(value==0)
         {
       	  	wait();
         }
         value = 0; 
    }
    
    public synchronized void V()
    {
   	 	value = 1;
   	 	notify(); 
    }
}
