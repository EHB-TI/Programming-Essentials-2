package entity;

public class Kaartspel extends Spel implements SpecialContainer{

    @Override
    public void geefContainerlevel() {

    }

    public enum CardType {FULL, BOOSTER, SINGLE};

    private CardType cartype;

    public Kaartspel(int id, String naam, double prijs) {
        super(id, naam, prijs);
    }

    public Kaartspel(int id, String naam, double prijs, CardType cartype) {
        super(id, naam, prijs);
        this.cartype = cartype;
    }

    public Kaartspel(int id, String naam, double prijs, String beschrijving, CardType cartype) {
        super(id, naam, prijs, beschrijving);
        this.cartype = cartype;
    }

    public CardType getCartype() {
        return cartype;
    }

    public void setCartype(CardType cartype) {
        this.cartype = cartype;
    }
}
