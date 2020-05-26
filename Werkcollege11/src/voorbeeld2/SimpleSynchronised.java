package voorbeeld2;

public class SimpleSynchronised {

    public /*synchronized*/ void tot99(){
        for(int i = 0; i<100; i++) {
            System.out.println("Voorbeeld 1: " + i);
        }
    }

    public void nogmaalsTot99()
    {
        /*synchronized (this)*/ {
            for (int i = 0; i < 100; i++) {
                System.out.println("Voorbeeld 2: " + i);
            }
        }
    }

    public static void main(String[] args) {
        SimpleSynchronised s = new SimpleSynchronised();
        Thread t1 = new Thread( () -> s.tot99());
        Thread t2 = new Thread( () -> s.nogmaalsTot99());

        t1.start();
        t2.start();
    }
}
