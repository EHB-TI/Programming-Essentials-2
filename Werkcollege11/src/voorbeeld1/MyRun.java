package voorbeeld1;

public class MyRun implements Runnable{

    @Override
    public void run() {
        for (int i = 0; i<100 ; i++)
        {
            System.out.println(i);
           /* try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }*/
        }
    }

    public static void main(String[] args) {
        MyRun myRun = new MyRun();
        Thread t1 = new Thread(myRun);
        Thread t2 = new Thread(myRun);
        t1.start();
        t2.start();
    }
}
