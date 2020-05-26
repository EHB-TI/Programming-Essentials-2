package entity;

import java.time.LocalDate;

public class VervallenException extends Exception{

    private LocalDate vervaldatum;

    public VervallenException(LocalDate vervaldatum) {
        super("Voedsel is vervallen: Datum - " + vervaldatum.toString());
        this.vervaldatum = vervaldatum;
    }
}
