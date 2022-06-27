import java.util.Random;

public class Gegner extends Charaktere{
    int range;
    private Random rnd = new Random();
    public Gegner(String name, int maxHp, int maxMp, int atk, int def, int matk, int mdef, double exp, int lvl){
        super(name, maxHp, maxMp,0,0,0,0, atk, def, matk,mdef, exp, lvl);
    }

    public int attack() {
        range = rnd.nextInt((atk-3),(atk+3));
        return range;
    }

    public int defend() {
        range = rnd.nextInt((def-3),(def+3));
        return range;
    }

    static Gegner zombie = new Gegner("Zombie", 10,10,5,5,5,5,10, 1);
    static Gegner monster = new Gegner("Monster", 20, 20, 10, 10, 5,5, 20, 1);


}
