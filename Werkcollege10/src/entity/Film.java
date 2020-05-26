package entity;

import java.util.ArrayList;
import java.util.HashSet;

public class Film extends Media {

    public enum Disktype {BD, DVD, HDDVD}
    private String regisseur;
    private Disktype disktype;
    private HashSet<String> tags;

    public Film(String titel, String beschrijving, double rating, String regisseur, Disktype disktype, HashSet<String> tags) {
        super(titel, beschrijving, rating);
        this.regisseur = regisseur;
        this.disktype = disktype;
        this.tags = tags;
    }

    public Film(int id, String titel, String beschrijving, double rating, String regisseur, Disktype disktype, HashSet<String> tags) {
        super(id, titel, beschrijving, rating);
        this.regisseur = regisseur;
        this.disktype = disktype;
        this.tags = tags;
    }

    public Film(String titel, String beschrijving, double rating, String regisseur, Disktype disktype) {
        super(titel, beschrijving, rating);
        this.regisseur = regisseur;
        this.disktype = disktype;
        this.tags = new HashSet<>();
    }

    public Film(int id, String titel, String beschrijving, double rating, String regisseur, Disktype disktype) {
        super(id, titel, beschrijving, rating);
        this.regisseur = regisseur;
        this.disktype = disktype;
        this.tags = new HashSet<>();
    }

    @Override
    public void verplaatsNaarArchief() {
        //doet er niet toe
    }

    public String getRegisseur() {
        return regisseur;
    }

    public void setRegisseur(String regisseur) {
        this.regisseur = regisseur;
    }

    public Disktype getDisktype() {
        return disktype;
    }

    public void setDisktype(Disktype disktype) {
        this.disktype = disktype;
    }

    public HashSet<String> getTags() {
        return tags;
    }

    public void setTags(HashSet<String> tags) {
        this.tags = tags;
    }
}
