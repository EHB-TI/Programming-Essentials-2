package entity;

import java.time.LocalDate;

public class Snack extends Voedsel {

    public Snack(int id, String naam, double prijs, LocalDate houdbaarheidsdatum) {
        super(id, naam, prijs, houdbaarheidsdatum);
    }
}
