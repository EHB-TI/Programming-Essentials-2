package entity;

public class Game extends Media{
    private String uitgever;

    public Game(String titel, String beschrijving, double rating, String uitgever) {
        super(titel, beschrijving, rating);
        this.uitgever = uitgever;
    }

    public Game(int id, String titel, String beschrijving, double rating, String uitgever) {
        super(id, titel, beschrijving, rating);
        this.uitgever = uitgever;
    }

    @Override
    public void verplaatsNaarArchief() {
        //doet er niet toe
    }

    public String getUitgever() {
        return uitgever;
    }
}
