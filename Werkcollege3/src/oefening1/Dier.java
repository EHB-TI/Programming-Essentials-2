package oefening1;

public class Dier {

    private double gewicht;
    private int aantal_poten;
    private int leeftijd;

    public Dier(double gewicht, int aantal_poten, int leeftijd) {
        this.gewicht = gewicht;
        this.aantal_poten = aantal_poten;
        this.leeftijd = leeftijd;
    }

    public int getLeeftijd() {
        return leeftijd;
    }

    public void setLeeftijd(int leeftijd) {
        this.leeftijd = leeftijd;
    }

    public double getGewicht() {
        return gewicht;
    }

    public void setGewicht(double gewicht) {
        this.gewicht = gewicht;
    }

    public int getAantal_poten() {
        return aantal_poten;
    }

    public void setAantal_poten(int aantal_poten) {
        this.aantal_poten = aantal_poten;
    }

    @Override
    public String toString() {
        return "Ik ben een " + this.getClass().getSimpleName() +
                ": gewicht = " + gewicht + " kg" +
                ", aantal_poten = " + aantal_poten +
                ", leeftijd = " + leeftijd + " jaar";
    }
}
