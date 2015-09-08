package binary.semaphore;

public class Start 
{

	public static void main(String[] args)
	{		
		BinarySemaphore f = new BinarySemaphore(1);
		BinarySemaphore g = new BinarySemaphore(0);
		Semaphore sem = new Semaphore(0);
		
		Thread F = new FThread("F", f, g, sem);
		Thread G = new GThread("G", g, f);
		Thread H = new HThread("H", sem);
		
		H.start();
		F.start();
		G.start();
		System.exit(0);
	}

}
