import java.util.Random;

public class Gegner extends Charaktere{
    public Gegner(String name, int maxHp, int maxSp, int str, int dex, int kno, int wis,
                  String mod, int atk, int def, double exp, int lvl){
        super(name, maxHp, maxSp,str,dex,kno,wis, mod, atk, def,0,0, exp, lvl);
    }


    static Gegner schneemann = new Gegner("Schneemann", 10,10,
            500,0,0,0,"str",0,0, 0.4,1);
    static Gegner fledermaus = new Gegner("Fledermaus", 5, 0,
            0,0,0,0, "str",2, 2, 0.8, 1);
    static Gegner oger = new Gegner("Oger", 80, 40,
            0,0,0,0,"str",4, 6, 12, 1);
    static Gegner geist = new Gegner("Geist", 20, 40,
            0,0,0,0,"int",20, 30, 8, 1);
    static Gegner affe = new Gegner("Geist", 20, 40,
            0,0,0,0,"str",20, 30, 8, 1);



}
