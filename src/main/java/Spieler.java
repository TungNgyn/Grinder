public class Spieler extends Charaktere{
    public Spieler(String name, int maxHp, int maxMp, int atk, int def, double exp, int lvl){
        super(name, maxHp, maxMp, atk, def, exp, lvl);
    }

    @Override
    public int attack() {
        return 0;
    }

    @Override
    public int defend() {
        return 0;
    }

    public boolean amLeben(){
        return hp > 0;
    }

}
