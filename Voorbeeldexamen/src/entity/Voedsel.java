package entity;

import java.time.LocalDate;

public abstract class Voedsel extends Product {

    private LocalDate houdbaarheidsdatum;


    public Voedsel(int id, String naam, double prijs, LocalDate houdbaarheidsdatum) {
        super(id, naam, prijs);
        this.houdbaarheidsdatum = houdbaarheidsdatum;
    }

    public LocalDate getHoudbaarheidsdatum() {
        return houdbaarheidsdatum;
    }

    public void setHoudbaarheidsdatum(LocalDate houdbaarheidsdatum) {
        this.houdbaarheidsdatum = houdbaarheidsdatum;
    }
}
