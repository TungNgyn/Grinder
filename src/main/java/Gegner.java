import java.util.Random;

public class Gegner extends Charaktere{
    int range;
    private Random rnd = new Random();
    public Gegner(String name, int maxHp, int maxMp, int atk, int def, double exp, int lvl){
        super(name, maxHp, maxMp,0,0,0,0, atk, def,0,0, exp, lvl);
    }

    public int attack() {
        range = rnd.nextInt((atk-3),(atk+3));
        return range;
    }
    public int defend() {
        range = rnd.nextInt((def-3),(def+3));
        return range;
    }

    static Gegner schneemann = new Gegner("Schneemann", 10,10,5,5,0.4, 1);
    static Gegner fledermaus = new Gegner("Fledermaus", 5, 0, 2, 2, 0.8, 1);
    static Gegner oger = new Gegner("Oger", 80, 40, 40, 60, 12, 1);
    static Gegner geist = new Gegner("Geist", 20, 40, 20, 30, 8, 1);
    static Gegner affe = new Gegner("Geist", 20, 40, 20, 30, 8, 1);


}
