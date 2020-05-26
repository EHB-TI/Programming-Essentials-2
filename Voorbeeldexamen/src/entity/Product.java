package entity;

public abstract class Product implements Comparable<Product>{
    private int id;
    private String naam;
    private double prijs;

    public Product(int id, String naam, double prijs) {
        this.id = id;
        this.naam = naam;
        this.prijs = prijs;
    }

    public Product(String naam, double prijs) {
        id = -1;
        this.naam = naam;
        this.prijs = prijs;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNaam() {
        return naam;
    }

    public void setNaam(String naam) {
        this.naam = naam;
    }

    public double getPrijs() {
        return prijs;
    }

    public void setPrijs(double prijs) {
        this.prijs = prijs;
    }

    @Override
    public int compareTo(Product o) {
        return Integer.compare(this.getId(), o.getId());
    }
}
