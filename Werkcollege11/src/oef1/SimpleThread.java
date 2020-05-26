package oef1;

public class SimpleThread implements Runnable{

	private int counter;
	
	
	public SimpleThread(int counter)
	{
		this.counter = counter;
	}
	
	@Override
	public void run() {
		for (int i = counter ; i>=0; i--)
			System.out.println("Thread " + Thread.currentThread().getName()+": "+ i);
	}

}
