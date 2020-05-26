package entity;

import java.time.LocalDate;

public class Drank extends Voedsel implements SpecialContainer{

    public Drank(int id, String naam, double prijs, LocalDate houdbaarheidsdatum) {
        super(id, naam, prijs, houdbaarheidsdatum);
    }

    @Override
    public void geefContainerlevel() {

    }
}
