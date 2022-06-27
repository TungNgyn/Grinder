public abstract class Charaktere {
    public String name;
    public int maxHp;
    public int hp;
    public int maxMp;
    public int mp;
    public int str;
    public int dex;
    public int kno;
    public int wis;
    public int atk;
    public int def;
    public int lvl;
    public double exp;

    public Charaktere(String name, int maxHp, int maxMp, int str, int dex, int kno, int wis,
                      int atk, int def, double exp, int lvl){
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
        this.exp = exp;
        this.lvl = lvl;
    }
    public abstract int attack();
    public abstract int defend();




}
