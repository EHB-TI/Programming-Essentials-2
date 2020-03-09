package oefening1;

public class VoorbeeldApp {

    public static void main(String[] args) {
        Dier d = new Dier(0.05, 1000, 1);
        Dier d2 = new Hond(4, 4, 12, 14515, "Samson" , null);
        Object h = new Huisdier(4, 4, 12, 52454, "Shadow");
        Huisdier h2 = new Hond(12, 3, 21, 3431, "Brick", "214844");

        System.out.println(d);
        System.out.println(d2);
        System.out.println(h);
        System.out.println(h2);

        if(h2.getClass() == Huisdier.class)
            System.out.println(((Huisdier)h).getNaam());

        if(h2 instanceof Huisdier)
        System.out.println(((Huisdier)h).getNaam());
    }
}
