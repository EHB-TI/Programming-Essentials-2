package entity;

import db.BordspelDAO;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.util.Map;
import java.util.TreeMap;
import java.util.TreeSet;

public class Tafel {
    private String naam;
    private final int id;
    private static int teller;
    private TreeMap<Product, Integer> bestelling;

    public Tafel(String naam) {
        teller++;
        id = teller;
        this.naam = naam;
        bestelling = new TreeMap<>();
    }

    public void voegProductToe(Product p) throws VervallenException {
        if(p==null)
            return;

        if(p instanceof Voedsel && ((Voedsel) p).getHoudbaarheidsdatum().isBefore(LocalDate.now()))
            throw new VervallenException(((Voedsel) p).getHoudbaarheidsdatum());

        if(bestelling.containsKey(p))
            bestelling.put(p, bestelling.get(p)+1);
        else
            bestelling.put(p, 1);

    }

    public TreeSet<Product> geefProductenOpNaam()
    {
        TreeSet ts = new TreeSet(new VergelijkProductOpNaam());
        ts.addAll(bestelling.keySet());
        return ts;
    }

    public void bewaar()
    {
        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                try(PrintWriter pw = new PrintWriter(new FileOutputStream(naam+".txt")))
                {
                    for(Map.Entry<Product, Integer> entry : bestelling.entrySet())
                    {
                        pw.println(entry.getKey().getNaam() + ": " + entry.getValue());
                    }
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
            }
        });
        t.start();
    }

    @Override
    public String toString()
    {
        return naam;
    }

    public String bestellingToString()
    {
        String uitvoer = "";
        double eindtotaal = 0;
        for(Map.Entry<Product, Integer> entry : bestelling.entrySet())
        {
            Product p = entry.getKey();
            uitvoer+= p.getClass().getSimpleName() + " " + p.getNaam() + " " + p.getPrijs() + ": " + entry.getValue() + "\n";
            eindtotaal += entry.getValue()*p.getPrijs();
        }
        uitvoer+="Eindtotaal: " + eindtotaal;
        return uitvoer;
    }


    public static void main(String[] args) {
        Tafel t = new Tafel("Tafel1");
        BordspelDAO bda = new BordspelDAO();
        bda.geefAlleBordspellen().forEach( (b) -> {
            try {
                t.voegProductToe(b);
            } catch (VervallenException e) {
                e.printStackTrace();
            }
        });
        t.bewaar();

    }
}
