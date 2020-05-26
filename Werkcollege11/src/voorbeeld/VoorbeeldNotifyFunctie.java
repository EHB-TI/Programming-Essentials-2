package voorbeeld;

public class VoorbeeldNotifyFunctie {

    public synchronized void doeIets()
    {
        while(true)
        {
            System.out.println("OK: " + Thread.currentThread().getName());
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
