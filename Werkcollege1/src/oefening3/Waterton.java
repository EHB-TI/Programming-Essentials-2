package oefening3;

public class Waterton {
    private int capaciteit;
    private int inhoud;

    public Waterton(int capaciteit) {
        this.capaciteit = capaciteit;
        inhoud = 0;
    }

    public Waterton(int capaciteit, int inhoud) {
        this.capaciteit = capaciteit;
        this.inhoud = inhoud;
    }

    public int getCapaciteit() {
        return capaciteit;
    }

    public void setCapaciteit(int capaciteit) {
        this.capaciteit = capaciteit;
    }

    public int getInhoud() {
        return inhoud;
    }

    public void setInhoud(int inhoud) {
        this.inhoud = inhoud;
    }

    public boolean voegWaterToe(int liter)
    {
        if(liter+inhoud >capaciteit)
        {
            inhoud = capaciteit;
            return true;
        }
        else
            inhoud +=liter;
        return false;
    }

    public int waterAftappen(int liter)
    {
        if(inhoud - liter < 0)
        {
            int re = inhoud;
            inhoud = 0;
            return re;
        }
        else
            inhoud -= liter;
        return liter;
    }

    public void print()
    {
        System.out.println("Capaciteit: "+ capaciteit);
        System.out.println("Inhoud: " + inhoud);
    }
}
