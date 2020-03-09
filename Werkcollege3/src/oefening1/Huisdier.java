package oefening1;

public class Huisdier extends Dier {

    private int registratienummer;
    private String naam;

    public Huisdier(double gewicht, int aantal_poten, int leeftijd, int registratienummer, String naam) {
        super(gewicht, aantal_poten, leeftijd);
        this.registratienummer = registratienummer;
        this.naam = naam;
    }

    public int getRegistratienummer() {
        return registratienummer;
    }

    public void setRegistratienummer(int registratienummer) {
        this.registratienummer = registratienummer;
    }

    public String getNaam() {
        return naam;
    }

    public void setNaam(String naam) {
        this.naam = naam;
    }


    @Override
    public String toString() {
        return super.toString() +
                ", registratienummer = " + registratienummer
                +", naam = " + naam;
    }
}
