package entity;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.util.*;

public class Klant {
    private TreeMap<Media, LocalDate> mandje;
    private String naam;

    public Klant(String naam) {
        this.mandje = new TreeMap<>();
        this.naam = naam;
    }

    public void huur(Media m)
    {
        //eventueel toevoegen controle al aanwezig zodat de datum niet overschreven wordt
        mandje.put(m, LocalDate.now());
    }

    public void inlevering(Media m) throws NoSuchItem, TooLateException {
        if(!mandje.containsKey(m))
            throw new NoSuchItem(m);


        //keuze gemaakt om sowieso toch te verwijderen anders kan je eerst de exception gooien. De LocalDate kan je opvragen door mandje.get(m)
        LocalDate ld = mandje.remove(m);

        if(ld.plusDays(21).isBefore(LocalDate.now()))
            throw new TooLateException(m, ld, LocalDate.now());
    }

    public void save()
    {
        try(PrintWriter pw = new PrintWriter(new FileOutputStream(naam+".txt")))
        {
            pw.println("Klant: " + naam);
            for(Map.Entry<Media, LocalDate> entry : mandje.entrySet())
            {
                pw.println(entry.getKey().getTitel() + " - " + entry.getValue());
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public String sorteerOpTitel()
    {
        String s = "";
        //beter met StringBuilder
        for(Media m : mandje.keySet())
            s+=m.getTitel() + "\n";
        return s;
    }

    public TreeSet<Media> sorteerOpRating()
    {
        //met Lambda: TreeSet<Media> ts = new TreeSet<>( (a, b) -> Double.compare(a.getRating(), b.getRating()));
        TreeSet<Media> ts = new TreeSet<>(new Comparator<Media>() {
            @Override
            public int compare(Media o1, Media o2) {
                //niet null-safe
               return Double.compare(o1.getRating(), o2.getRating());
            }
        });
        ts.addAll(mandje.keySet());
        return ts;
    }

    @Override
    public String toString() {
        return naam;
    }
}
