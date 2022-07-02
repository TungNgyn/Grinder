public abstract class Charaktere {
    public String name;
    public int maxHp;
    public int hp;
    public int maxSp;
    public int sp;
    public int str;
    public int dex;
    public int kno;
    public int wis;
    public int atk;
    public int def;
    public int hpMod;
    public int spMod;
    public String mod;
    public int lvl;
    public int exp;

    public Charaktere(String name, int maxHp, int maxSp, int str, int dex, int kno, int wis,
                      String mod, int atk, int def, int hpMod, int spMod, int exp, int lvl){
        this.name = name;
        this.maxHp = maxHp;
        this.hp = maxHp;
        this.maxSp = maxSp;
        this.sp = maxSp;
        this.str = str;
        this.dex = dex;
        this.kno = kno;
        this.wis = wis;
        this.mod = mod;
        this.atk = atk;
        this.def = def;
        this.hpMod = hpMod;
        this.spMod = spMod;
        this.exp = exp;
        this.lvl = lvl;
    }
}
