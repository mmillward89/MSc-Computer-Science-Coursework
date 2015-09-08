package binary.semaphore;

import java.util.Random;

public class HThread extends Thread
{
	private String s;
	private Semaphore sem;
	
	public HThread(String s, Semaphore sem)
	{
		this.s = s;
		this.sem = sem;
	}
	
	public void run()
	{
		//create a random double between 0 and 1
		//and cast it to long type
		
		final double min = 0.0;
		final double max = 1.0;
		Random r = new Random();
	
		double d = min + (max - min) * r.nextDouble();
		long l = (long) d;
		
		//thread loop - while true sleep a random time
		// and print the chosen letter
		
		while(true)
		{
			try
			{
				this.sleep(l);
				System.out.print(s + ", ");
				sem.V();
			}
			catch(InterruptedException e)
			{
				e.printStackTrace();
			}
		}
		
	}
}
