package voorbeeld;

public class SimpleNotify {

    public synchronized void methode1() {
        while (true) {
            System.out.println("Go Go 1");
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void methode2() {
        synchronized (this) {
            while (true) {
                System.out.println("Go Go 2");
                try {
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args) {
        SimpleNotify sn = new SimpleNotify();

        Thread t1 = new Thread(() -> sn.methode1());//.start();
        t1.start();
        new Thread(() -> sn.methode2()).start();

        while (true) {
            synchronized (sn) {
                    sn.notify();
            }
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
