import java.util.Random;

public class Spieler extends Charaktere{
    int range;
    private Random rnd = new Random();

    public Spieler(String name, int maxHp, int maxMp, int str, int dex, int kno, int wis,
                   int atk, int def, double exp, int lvl){
        super(name, maxHp, maxMp, str, dex, kno, wis, atk, def, exp, lvl);
    }

    static Spieler krieger = new Spieler("Krieger",20,5,10,5,3,2,
            10,10,0,1);
    static Spieler jaeger = new Spieler("Jäger", 15, 10,5,10,3,4,
            10,4,0,1);
    static Spieler magier = new Spieler("Zauberer", 10,20,2,3,10,7,
            10,3,0,1);
    static Spieler priester = new Spieler("Priester", 10,15,2,4,4,15,
            10,5,0,1);
    static Spieler paladin = new Spieler("Paladin", 30,10,10,2,2,10,
            10,15,0,1);
    static Spieler ninja = new Spieler("Ninja", 10,10,2,15,9,4,
            10,5,0,1);


    public int attack() {
        range = rnd.nextInt((atk-3),(atk+3));
        return range;
    }

    public int defend() {
        range = rnd.nextInt((def-3),(def+3));
        return range;
    }

}
