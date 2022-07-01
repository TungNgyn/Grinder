import java.util.Random;

public class Spieler extends Charaktere{
    public Spieler(String name, int maxHp, int maxSp, int str, int dex, int kno, int wis,
                   String mod, int atk, int def, int hpMod, int spMod,
                   double exp, int lvl){
        super(name, maxHp, maxSp, str, dex, kno, wis, mod, atk, def, hpMod, spMod, exp, lvl);
    }

    static Spieler krieger = new Spieler("Krieger",20,10,8,6,2,4,
            "str",6,6,5,2,0,1);
    static Spieler jaeger = new Spieler("Jäger", 15, 15,3,8,3,6,
            "dex",5,4,5,3,0,1);
    static Spieler magier = new Spieler("Zauberer", 10,30,2,6,10,2,
            "kno",6,3,3,5,0,1);
    static Spieler priester = new Spieler("Priester", 15,15,2,6,2,10,
            "wis",4,4,4,3,0,1);
    static Spieler paladin = new Spieler("Paladin", 25,10,8,2,2,8,
            "wis",4,8,5,2,0,1);
    static Spieler ninja = new Spieler("Ninja", 10,25,2,12,5,3,
            "dex",8,3,3,4,0,1);
}
