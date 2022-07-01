import java.util.Random;

public class Spieler extends Charaktere{
    int range;
    private Random rnd = new Random();

    public Spieler(String name, int maxHp, int maxSp, int str, int dex, int kno, int wis,
                   String mod, int atk, int def, int hpMod, int spMod,
                   double exp, int lvl){
        super(name, maxHp, maxSp, str, dex, kno, wis, mod, atk, def, hpMod, spMod, exp, lvl);
    }

    static Spieler krieger = new Spieler("Krieger",20,5,8,6,2,4,
            "str",10,10,5,3,0,1);
    static Spieler jaeger = new Spieler("Jäger", 15, 10,3,8,3,6,
            "dex",10,4,5,5,0,1);
    static Spieler magier = new Spieler("Zauberer", 10,20,2,6,10,2,
            "kno",10,3,3,8,0,1);
    static Spieler priester = new Spieler("Priester", 10,15,2,6,2,10,
            "wis",10,5,4,6,0,1);
    static Spieler paladin = new Spieler("Paladin", 30,10,8,2,2,8,
            "wis",10,15,5,4,0,1);
    static Spieler ninja = new Spieler("Ninja", 10,10,2,12,5,3,
            "dex",10,5,3,6,0,1);
}
