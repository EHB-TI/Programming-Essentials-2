package oef1;

public class Main {
public static void main(String[] args) {
	
	Thread t1 = new Thread(new SimpleThread(100));
	Thread t2 = new Thread(new SimpleThread(100));
	Thread t3 = new Thread(new SimpleThread(100));
	
	t1.setName("nummer 1");
	t2.setName("nummer 2");
	t3.setName("nummer 3");
	
	t1.start();
	t2.start();
	t3.start();
}

}
