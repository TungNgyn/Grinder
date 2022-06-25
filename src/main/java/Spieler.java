public class Spieler extends Charaktere{
    public Spieler(String name, int maxHp, int maxMp, int atk, int def, double exp, int lvl){
        super(name, maxHp, maxMp, atk, def, exp, lvl);
    }

    public int attack() {
        return atk;
    }

    public int defend() {
        return def;
    }

    public boolean amLeben(){
        return hp > 0;
    }

}
