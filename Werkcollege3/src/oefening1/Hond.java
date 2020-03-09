package oefening1;

public class Hond extends Huisdier {
    private String stamboomnummer;

    public Hond(double gewicht, int aantal_poten, int leeftijd, int registratienummer, String naam, String stamboomnummer) {
        super(gewicht, aantal_poten, leeftijd, registratienummer, naam);
        this.stamboomnummer = stamboomnummer;
    }

    public String getStamboomnummer() {
        return stamboomnummer;
    }

    public void setStamboomnummer(String stamboomnummer) {
        this.stamboomnummer = stamboomnummer;
    }

    @Override
    public String toString() {
        return super.toString() +
                (stamboomnummer!=null ? ", stamboomnummer= '" + stamboomnummer + '\'' : ", dit is geen rashond.");
    }
}
