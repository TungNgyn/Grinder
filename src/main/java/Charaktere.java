public abstract class Charaktere {
    public String name;
    public int maxHp;
    public int hp;
    public int maxMp;
    public int mp;
    public int atk;
    public int def;
    public double exp;
    public static int lvl;

    public Charaktere(String name, int maxHp, int maxMp, int atk, int def, double exp, int lvl){
        this.name = name;
        this.maxHp = maxHp;
        this.hp = maxHp;
        this.maxMp = maxMp;
        this.mp = maxMp;
        this.atk = atk;
        this.def = def;
        this.exp = exp;
        this.lvl = lvl;
    }
    public abstract int attack();
    public abstract int defend();




}
