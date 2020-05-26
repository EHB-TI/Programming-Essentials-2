package voorbeeld;

public class VoorbeeldNotify {



    public static void main(String[] args) {
        VoorbeeldNotifyFunctie vn = new VoorbeeldNotifyFunctie();

        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                vn.doeIets();
            }
        });
        t.start();

        while(true) {
            System.out.println("OK" + Thread.currentThread().getName());
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Checkpoint: " + Thread.currentThread().getName());
            synchronized (vn) {
                vn.notify();
            }
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
