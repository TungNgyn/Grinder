public abstract class Charaktere {
    public String name;
    public int maxHp, hp, maxMp, mp, str, dex, kno, wis, atk, def, matk, mdef, lvl;
    public double exp;

    public Charaktere(String name, int maxHp, int maxMp, int str, int dex, int kno, int wis,
                      int atk, int def, int matk, int mdef, double exp, int lvl){
        this.name = name;
        this.maxHp = maxHp;
        this.hp = maxHp;
        this.maxMp = maxMp;
        this.mp = maxMp;
        this.str = str;
        this.dex = dex;
        this.kno = kno;
        this.wis = wis;
        this.atk = atk;
        this.def = def;
        this.matk = matk;
        this.mdef = mdef;
        this.exp = exp;
        this.lvl = lvl;
    }
    public abstract int attack();
    public abstract int defend();




}
