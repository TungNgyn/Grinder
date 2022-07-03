package Skills;

import javax.swing.*;

public class Skills {
    public String name;
    public int kraft;
    public int genauigkeit;
    public String mod;
    public ImageIcon bild;
    public String toolText;

    public Skills(String name, int kraft, int genauigkeit, String mod, ImageIcon bild, String toolText){
        this.name = name;
        this.kraft = kraft;
        this.genauigkeit = genauigkeit;
        this.mod = mod;
        this.bild = bild;
        this.toolText = toolText;
    }
    //region hexer
//    public static Skills hexerSkill1 = new Skills("Angriff",100,90,"str",new ImageIcon("res/Skills/Hexer/1.png"));
//    public static Skills hexerSkill2 = new Skills("Schuss",130,50,"dex",new ImageIcon("res/Skills/Hexer/2.png"));
//    public static Skills hexerSkill3 = new Skills("Feuerball",80,200,"kno",new ImageIcon("res/Skills/Hexer/3.png"));
//    public static Skills hexerSkill4 = new Skills("Heiliger Blitz",70,180,"wis",new ImageIcon("res/Skills/Hexer/4.png"));
//    public static Skills hexerSkill5 = new Skills("5",110,80,"kno",new ImageIcon("res/Skills/Hexer/5.png"));
//    public static Skills hexerSkill6 = new Skills("6",90,80,"kno",new ImageIcon("res/Skills/Hexer/6.png"));
//    public static Skills hexerSkill7 = new Skills("7",200,50,"wis",new ImageIcon("res/Skills/Hexer/7.png"));
//    public static Skills hexerSkill8 = new Skills("8",300,30,"wis",new ImageIcon("res/Skills/Hexer/8.png"));
    //endregion
}
