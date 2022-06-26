public class Gegner extends Charaktere{
    public Gegner(String name, int maxHp, int maxMp, int atk, int def,  double exp, int lvl){
        super(name, maxHp, maxMp, atk, def, exp, lvl);
    }

    public int attack() {
        return atk;
    }

    public int defend() {
        return def;
    }

    static Gegner zombie = new Gegner("Zombie", 10,10,5,5,10, 1);
    static Gegner monster = new Gegner("Monster", 20, 20, 10, 10, 20, 1);


}
