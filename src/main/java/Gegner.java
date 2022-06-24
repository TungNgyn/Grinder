public class Gegner extends Charaktere{
    public Gegner(String name, int maxHp, int maxMp, int atk, int def,  double exp, int lvl){
        super(name, maxHp, maxMp, atk, def, exp, lvl);
    }

    public boolean amLeben(){
        return hp > 0;
    }
    public int attack(){
        return 0;
    }
    public int defend(){
        return 0;
    }
}
