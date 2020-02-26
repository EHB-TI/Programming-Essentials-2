package oefening4;

import java.util.ArrayList;

public class Korps {
    private String naam;
    private int maximum;
    private ArrayList<Agent> agenten;

    public Korps(String naam, int maximum) {
        agenten = new ArrayList<>(maximum);
        this.naam = naam;
        this.maximum = maximum;
    }

    public String getNaam() {
        return naam;
    }

    public void setNaam(String naam) {
        this.naam = naam;
    }

    public boolean addAgent(Agent a)
    {
        int aantal = agenten.size();
        int totaalleeftijd = 0;
        for(Agent agent : agenten)
        {
            totaalleeftijd += agent.getLeeftijd();
        }
        aantal++;
        totaalleeftijd+=a.getLeeftijd();

        if((double)totaalleeftijd/aantal<40)
        {
            if(aantal > maximum)
                vergrootRij();
            agenten.add(a);
            return true;
        }

        return false;
    }

    public boolean removeAgent(String naam)
    {
        ArrayList<Agent> copy = new ArrayList<>(agenten);
        int aantal = copy.size();
        int totaalleeftijd = 0;
        for(int i = 0; i<copy.size(); i++)
        {
            if(copy.get(i).getNaam().equals(naam))
            {
                copy.remove(i);
                aantal--;
                i--;
            }
            else {
                totaalleeftijd += copy.get(i).getLeeftijd();
            }
        }

        if((double)totaalleeftijd/aantal < 40)
        {
            agenten = copy;
            if(agenten.size()<=maximum/2)
                verkleinRij();
            return true;
        }

        return false;
    }


    public void vergrootRij()
    {
        System.out.println("VERGROOT RIJ");
        maximum*=2;
        agenten.ensureCapacity(maximum);
    }

    public void verkleinRij()
    {
        System.out.println("VERKLEIN RIJ");
        maximum/=2;
        agenten.trimToSize();
        agenten.ensureCapacity(maximum);
    }

    public static void main(String[] args) {
       Korps c1 = new Korps("EheroesB", 2);
        System.out.println(c1.addAgent(new Agent("Jef", 10))==true?"GELUKT": "MISLUKT");
        System.out.println(c1.addAgent(new Agent("Jos", 100))==true?"GELUKT": "MISLUKT");
        System.out.println(c1.addAgent(new Agent("Jan", 40))==true?"GELUKT": "MISLUKT");
        System.out.println(c1.addAgent(new Agent("Jef", 45))==true?"GELUKT": "MISLUKT");
        System.out.println(c1.addAgent(new Agent("Jos", 15))==true?"GELUKT": "MISLUKT");
        System.out.println(c1.addAgent(new Agent("Jef", 20))==true?"GELUKT": "MISLUKT");
        System.out.println(c1.agenten.size());
        System.out.println(c1.removeAgent("Jack"));
        System.out.println(c1.agenten.size());
        System.out.println(c1.removeAgent("Jef"));
        System.out.println(c1.agenten.size());

        System.out.println("Korps: ");
        for(Agent a : c1.agenten)
        {
            System.out.print(a.getNaam() + " ");
        }
    }
}
