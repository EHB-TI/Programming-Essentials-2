package oefening4;

public class Auto {
    private double kilometerteller;
    private final double maxtank;
    private double inhoudtank;
    private double verbruik;

    public Auto(double maxtank, double verbruik) {
        inhoudtank = 0;
        kilometerteller = 0;
        this.maxtank = maxtank;
        this.verbruik = verbruik;
    }

    public Auto(double kilometerteller, double maxtank, double inhoudtank, double verbruik) {
        this.kilometerteller = kilometerteller;
        this.maxtank = maxtank;
        this.inhoudtank = inhoudtank;
        this.verbruik = verbruik;
    }

    public double tanken()
    {
        double aantalliter = maxtank - inhoudtank;
        inhoudtank = maxtank;
        return aantalliter;
    }

    public double rijden(double km)
    {
        double liter = verbruik * Math.abs(km);
        if(liter>=inhoudtank) {
            double effectief = inhoudtank / verbruik;
            inhoudtank = 0;
            kilometerteller += effectief;
            return effectief;
        }
        else
        {
            inhoudtank -=liter;
            kilometerteller += km;
            return km;
        }
    }

    public void print()
    {
        System.out.println("Teller: " + kilometerteller);
        System.out.println("Verbruik" + verbruik);
        System.out.println("Max capaciteit tank: "+ maxtank);
        System.out.println("Inhoud tank: " + inhoudtank);
    }

}
