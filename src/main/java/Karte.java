public class Karte {
    String name;

    public Karte(String name){
        this.name = name;
    }

    static Karte lager = new Karte("Lager");
    static Karte kampf = new Karte("Kampf");
    static Karte event = new Karte("Event");
}
