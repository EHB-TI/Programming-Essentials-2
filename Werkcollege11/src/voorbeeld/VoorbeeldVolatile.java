package voorbeeld;

public class VoorbeeldVolatile {

    private static int counter = 0;
    public static void main(String[] args) {

        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                while(true) {
                    System.out.println(counter);
                    counter++;
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
                    if(vorige != counter) {
                        System.out.println("ONGELIJK");
                        vorige = counter;
                    }

                }
            }
        });
        t2.start();
    }
}
