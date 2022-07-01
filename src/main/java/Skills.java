import javax.swing.*;

public class Skills {
    String name;
    int kraft;
    int genauigkeit;
    String mod;
    ImageIcon bild;

    public Skills(String name, int kraft, int genauigkeit, String mod, ImageIcon bild){
        this.name = name;
        this.kraft = kraft;
        this.genauigkeit = genauigkeit;
        this.mod = mod;
        this.bild = bild;
    }
    //region hexer
    static Skills hexerSkill1 = new Skills("Skill 1",100,90,"str",new ImageIcon("res/Skills/Hexer/1.png"));
    static Skills hexerSkill2 = new Skills("2",130,50,"str",new ImageIcon("res/Skills/Hexer/2.png"));
    static Skills hexerSkill3 = new Skills("3",80,200,"dex",new ImageIcon("res/Skills/Hexer/3.png"));
    static Skills hexerSkill4 = new Skills("4",70,180,"dex",new ImageIcon("res/Skills/Hexer/4.png"));
    static Skills hexerSkill5 = new Skills("5",110,80,"kno",new ImageIcon("res/Skills/Hexer/5.png"));
    static Skills hexerSkill6 = new Skills("6",90,80,"kno",new ImageIcon("res/Skills/Hexer/6.png"));
    static Skills hexerSkill7 = new Skills("7",200,50,"wis",new ImageIcon("res/Skills/Hexer/7.png"));
    static Skills hexerSkill8 = new Skills("8",300,30,"wis",new ImageIcon("res/Skills/Hexer/8.png"));
    //endregion
}
