package voorbeeld2;

public class SimpleSynchronisedWait {

    public synchronized void tot99(){
        for(int i = 0; i<100; i++) {
            System.out.println("Voorbeeld 1: " + i);
            try {
                notify();
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void nogmaalsTot99()
    {
        synchronized (this) {
            for (int i = 0; i < 100; i++) {
                System.out.println("Voorbeeld 2: " + i);
                try {
                    notify();
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args) {
        SimpleSynchronisedWait s = new SimpleSynchronisedWait();
        Thread t1 = new Thread( () -> s.tot99());
        Thread t2 = new Thread( () -> s.nogmaalsTot99());

        t1.start();
        t2.start();
    }
}
