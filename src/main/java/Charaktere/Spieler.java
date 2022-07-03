package Charaktere;

public class Spieler extends Charaktere{
    public Spieler(String name, int maxHp, int maxSp, int str, int dex, int kno, int wis,
                   String mod, int atk, int def, int hpMod, int spMod,
                   int exp, int lvl){
        super(name, maxHp, maxSp, str, dex, kno, wis, mod, atk, def, hpMod, spMod, exp, lvl);
    }

    public static Spieler krieger = new Spieler("Krieger",40,10,8,6,2,4,
            "str",6,6,5,2,0,1);
    public static Spieler jaeger = new Spieler("Jäger", 25, 15,3,8,3,6,
            "dex",5,4,5,3,0,1);
    public static Spieler magier = new Spieler("Zauberer", 15,30,2,6,10,2,
            "kno",6,3,3,5,0,1);
    public static Spieler priester = new Spieler("Priester", 25,15,2,6,2,10,
            "wis",4,4,4,3,0,1);
    public static Spieler paladin = new Spieler("Paladin", 50,10,8,2,2,8,
            "wis",4,8,5,2,0,1);
    public static Spieler ninja = new Spieler("Ninja", 15,25,2,12,5,3,
            "dex",8,3,3,4,0,1);
}
