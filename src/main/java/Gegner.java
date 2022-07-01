import java.util.Random;

public class Gegner extends Charaktere{
    public Gegner(String name, int maxHp, int maxSp, int str, int dex, int kno, int wis,
                  String mod, int atk, int def, int hpMod, double exp, int lvl){
        super(name, maxHp, maxSp,str,dex,kno,wis, mod, atk, def,hpMod,0, exp, lvl);
    }

    //region tier1
    static Gegner schneemann = new Gegner("Schneemann", 10,10,
            0,0,0,0,"str",0,0, 3,2,1);

    //str
    static Gegner puppe = new Gegner("Puppe", 15, 0,
            0,0,0,0, "str",3, 2, 2,1, 1);
    static Gegner sahagin = new Gegner("Sahagin", 15, 0,
            0,0,0,0, "str",5, 4, 2,1.5, 1);
    static Gegner skelettkrieger = new Gegner("Skelettkrieger", 25, 0,
            0,0,0,0, "str",7, 5, 2,2, 1);
    static Gegner werwolf = new Gegner("Werwolf", 30, 0,
            0,0,0,0, "str",10, 3, 2,3, 1);

    //dex
    static Gegner fledermaus = new Gegner("Fledermaus", 10, 0,
            0,0,0,0, "dex",2, 4, 2,0.5, 1);
    static Gegner hornisse = new Gegner("Hornisse", 10, 0,
            0,0,0,0, "dex",2, 5, 2,0.5, 1);
    static Gegner ratte = new Gegner("Ratte", 10, 0,
            0,0,0,0, "dex",2, 3, 2,0.5, 1);
    static Gegner schlange = new Gegner("Schlange", 15, 0,
            0,0,0,0, "dex",6, 5, 2,1, 1);
    static Gegner skorpion = new Gegner("Skorpion", 20, 0,
            0,0,0,0, "dex",8, 4, 2,2, 1);

    //kno
    static Gegner pflanze = new Gegner("Pflanze", 15, 0,
            0,0,0,0, "kno",5, 4, 2,1, 1);
    static Gegner imp = new Gegner("Imp", 10, 0,
            0,0,0,0, "kno",3, 4, 2,0.5, 1);

    //wis
    static Gegner schleim = new Gegner("Schleim", 15, 0,
            0,0,0,0, "wis",3, 6, 2,0.8, 1);
    static Gegner spinne = new Gegner("Spinne", 15, 0,
            0,0,0,0, "wis",5, 4, 2,1, 1);
    static Gegner qualle = new Gegner("Qualle", 10, 0,
            0,0,0,0, "wis",3, 2, 2,0.8, 1);
    static Gegner zombie = new Gegner("Zombie", 20, 0,
            0,0,0,0, "wis",4, 3, 2,1.5, 1);

    //endregion

    static Gegner oger = new Gegner("Oger", 80, 40,
            0,0,0,0,"str",4, 6, 10,12, 1);
    static Gegner geist = new Gegner("Geist", 20, 40,
            0,0,0,0,"int",20, 30,5, 8, 1);
    static Gegner schwertmann = new Gegner("Schwertmann", 10, 0,
            0,0,0,0, "str",2, 2, 2,0.8, 1);
    static Gegner dieb = new Gegner("Dieb", 10, 0,
            0,0,0,0, "dex",2, 2, 2,0.8, 1);
    static Gegner vampir = new Gegner("Vampir", 10, 0,
            0,0,0,0, "kno",2, 2, 2,0.8, 1);



}
