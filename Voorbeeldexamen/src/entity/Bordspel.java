package entity;

public class Bordspel extends Spel {
    private int speelduur;

    public Bordspel(int id, String naam, double prijs, int speelduur) {
        super(id, naam, prijs);
        this.speelduur = speelduur;
    }

    public Bordspel(String naam, double prijs, int speelduur) {
        super(-1, naam, prijs);
        this.speelduur = speelduur;
    }

    @Override
    public String toString() {
     return this.getNaam();
    }

    public int getSpeelduur() {
        return speelduur;
    }

    public void setSpeelduur(int speelduur) {
        this.speelduur = speelduur;
    }
}
