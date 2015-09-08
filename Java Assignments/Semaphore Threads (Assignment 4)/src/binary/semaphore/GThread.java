package binary.semaphore;
import java.util.*;

public class GThread extends Thread
{
	private String s;
	private BinarySemaphore a;
	private BinarySemaphore b;
	
	public GThread(String s, BinarySemaphore a, BinarySemaphore b)
	{
		this.s = s;
		this.a = a;
		this.b = b;
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
				a.P();
				Thread.sleep(l);
				System.out.print(s + ", ");
				b.V();
			}
			catch(InterruptedException e)
			{
				e.printStackTrace();
			}
		}

	}
}
