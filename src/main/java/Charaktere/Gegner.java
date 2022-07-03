package Charaktere;

public class Gegner extends Charaktere{
    public Gegner(String name, int maxHp, int maxSp, int str, int dex, int kno, int wis,
                  String mod, int atk, int def, int hpMod, int exp, int lvl){
        super(name, maxHp, maxSp,str,dex,kno,wis, mod, atk, def,hpMod,0, exp, lvl);
    }

    //region tier1
    public static Gegner schneemann = new Gegner("Schneemann", 10,10,
            10,10,10,10,"str",0,0, 3,2,1);

    //str
    public static Gegner puppe = new Gegner("Puppe", 15, 0,
            4,2,1,1, "str",3, 2, 2,1, 1);
    public static Gegner sahagin = new Gegner("Sahagin", 15, 0,
            6,4,2,3, "str",5, 4, 2,2, 1);
    public static Gegner skelettkrieger = new Gegner("Skelettkrieger", 25, 0,
            7,3,2,1, "str",7, 5, 2,3, 1);
    public static Gegner werwolf = new Gegner("Werwolf", 30, 0,
            8,5,3,3, "str",10, 3, 2,4, 1);

    //dex
    public static Gegner fledermaus = new Gegner("Fledermaus", 10, 0,
            2,4,2,1, "dex",2, 4, 2,1, 1);
    public static Gegner hornisse = new Gegner("Hornisse", 10, 0,
            1,5,1,1, "dex",2, 5, 2,1, 1);
    public static Gegner ratte = new Gegner("Ratte", 10, 0,
            1,4,1,1, "dex",2, 3, 2,1, 1);
    public static Gegner schlange = new Gegner("Schlange", 15, 0,
            5,8,4,1, "dex",6, 5, 2,2, 1);
    public static Gegner skorpion = new Gegner("Skorpion", 20, 0,
            6,8,3,2, "dex",8, 4, 2,3, 1);

    //kno
    public static Gegner pflanze = new Gegner("Pflanze", 15, 0,
            2,2,4,2, "kno",5, 4, 2,2, 1);
    public static Gegner imp = new Gegner("Imp", 10, 0,
            1,2,3,1, "kno",3, 4, 2,1, 1);

    //wis
    public static Gegner schleim = new Gegner("Schleim", 15, 0,
            1,2,1,5, "wis",3, 6, 2,1, 1);
    public static Gegner spinne = new Gegner("Spinne", 15, 0,
            1,3,2,4, "wis",5, 4, 2,1, 1);
    public static Gegner qualle = new Gegner("Qualle", 10, 0,
            1,2,1,6, "wis",3, 2, 2,1, 1);
    public static Gegner zombie = new Gegner("Zombie", 20, 0,
            4,2,1,5, "wis",4, 3, 2,2, 1);

    //endregion

    public static Gegner oger = new Gegner("Oger", 80, 40,
            0,0,0,0,"str",4, 6, 10,12, 1);
    public static Gegner geist = new Gegner("Geist", 20, 40,
            0,0,0,0,"int",20, 30,5, 8, 1);
    public static Gegner schwertmann = new Gegner("Schwertmann", 10, 0,
            0,0,0,0, "str",2, 2, 2,5, 1);
    public static Gegner dieb = new Gegner("Dieb", 10, 0,
            0,0,0,0, "dex",2, 2, 2,3, 1);
    public static Gegner vampir = new Gegner("Vampir", 10, 0,
            0,0,0,0, "kno",2, 2, 2,6, 1);



}
