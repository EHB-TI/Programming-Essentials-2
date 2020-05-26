package entity;

import java.time.LocalDate;

public class TooLateException extends Exception {

    private Media media;
    private LocalDate uitleendatum, inleverdatum;

    public TooLateException(Media m, LocalDate ld, LocalDate now) {
        this.media = m;
        this.uitleendatum = ld;
        this.inleverdatum = now;
    }

    public Media getMedia() {
        return media;
    }

    public LocalDate getUitleendatum() {
        return uitleendatum;
    }

    public LocalDate getInleverdatum() {
        return inleverdatum;
    }
}
