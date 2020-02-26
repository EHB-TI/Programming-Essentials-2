package oefening4;

public class Agent {
    private String naam;
    private int leeftijd;

    public Agent(String naam, int leeftijd) {
        this.naam = naam;
        this.leeftijd = leeftijd;
    }

    public String getNaam() {
        return naam;
    }

    public void setNaam(String naam) {
        this.naam = naam;
    }

    public int getLeeftijd() {
        return leeftijd;
    }

    public void setLeeftijd(int leeftijd) {
        this.leeftijd = leeftijd;
    }

    public String toString()
    {
        return "Naam: " + naam + ", leeftijd: " + leeftijd;
    }
}
