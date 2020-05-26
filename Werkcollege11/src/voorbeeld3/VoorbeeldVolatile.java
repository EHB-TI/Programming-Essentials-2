package voorbeeld3;

public class VoorbeeldVolatile {

    private volatile int counter = 0;

    public static void main(String[] args) {

        VoorbeeldVolatile v2 = new VoorbeeldVolatile();

        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                while(true) {
                    System.out.println(v2.counter);
                    v2.counter++;
                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
        t.start();


        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                int vorige = 0;
                while(true) {
                    if(vorige != v2.counter) {
                        System.out.println("ONGELIJK");
                        vorige = v2.counter;
                    }
                }
            }
        });
        t2.start();
    }
}
