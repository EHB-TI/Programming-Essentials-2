package voorbeeld2;

public class MyRun implements Runnable{

    @Override
    public synchronized void run() {
        for (int i = 0; i<10 ; i++)
        {
            System.out.println(i);
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        MyRun myRun = new MyRun();

        Thread t1 = new Thread(myRun);
        Thread t2 = new Thread(myRun);
        t1.start();
        t2.start();

        while(true) {
            synchronized (myRun) {
                myRun.notifyAll();
            }
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
