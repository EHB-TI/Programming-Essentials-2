package entity;

import java.util.HashSet;

public abstract class Spel extends Product{

    private String beschrijving;
    private HashSet<String> tags = new HashSet<>();

    public Spel(int id, String naam, double prijs) {
        super(id, naam, prijs);
    }

    public Spel(int id, String naam, double prijs, String beschrijving) {
        super(id, naam, prijs);
        this.beschrijving = beschrijving;
    }

    public String getBeschrijving() {
        return beschrijving;
    }

    public void setBeschrijving(String beschrijving) {
        this.beschrijving = beschrijving;
    }

    public HashSet<String> getTags() {
        return tags;
    }

    public void setTags(HashSet<String> tags) {
        this.tags = tags;
    }
}
