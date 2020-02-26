package oefening1;

import oefening2.Adres;

public class Persoon {
    private String voornaam;
    private String achternaam;
    private String telefoon;
    private Adres adres;

    public Persoon(String voornaam, String achternaam) {
        this.voornaam = voornaam;
        this.achternaam = achternaam;
    }

    public String getVoornaam() {
        return voornaam;
    }

    public void setVoornaam(String voornaam) {
        this.voornaam = voornaam;
    }

    public String getAchternaam() {
        return achternaam;
    }

    public void setAchternaam(String achternaam) {
        this.achternaam = achternaam;
    }

    public String getTelefoon() {
        return telefoon;
    }

    public void setTelefoon(String telefoon) {
        this.telefoon = telefoon;
    }

    public Adres getAdres() {
        return adres;
    }

    public void setAdres(Adres adres) {
        this.adres = adres;
    }

    public static void main(String[] args) {
        Persoon p1 = new Persoon("Joske", "Joskens");
        p1.setAdres(new Adres("Pennylane", (short) 50, "5b", 8879, "Nowhere"));
        System.out.println(p1.getAdres());

        Persoon p2 = new Persoon("Jefke", "Jefkens");
        p2.setAdres(new Adres("Route 66", (short) 20, "", 8478, "Ontheedge"));
        System.out.println(p2.getAdres());
    }
}
