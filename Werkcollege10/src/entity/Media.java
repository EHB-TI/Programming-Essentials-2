package entity;

public abstract class Media implements Comparable<Media> {

    private int id;
    private String titel;
    private String beschrijving;
    private double rating;

    public Media(String titel, String beschrijving, double rating) {
        this.titel = titel;
        this.beschrijving = beschrijving;
        this.rating = rating;
    }

    public Media(int id, String titel, String beschrijving, double rating) {
        this.id = id;
        this.titel = titel;
        this.beschrijving = beschrijving;
        this.rating = rating;
    }

    public abstract void verplaatsNaarArchief();

    @Override
    public int compareTo(Media o) {
        if(o == null)
            return 1;
        if(getTitel() == null)
            return (o.getTitel()==null?0:-1);
        else
            return (o.getTitel()==null?1:this.getTitel().compareTo(o.getTitel()));
    }

    @Override
    public String toString() {
      return this.getClass().getSimpleName();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitel() {
        return titel;
    }

    public void setTitel(String titel) {
        this.titel = titel;
    }

    public String getBeschrijving() {
        return beschrijving;
    }

    public void setBeschrijving(String beschrijving) {
        this.beschrijving = beschrijving;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }
}
