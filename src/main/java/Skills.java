import javax.swing.*;

public class Skills {
    ImageIcon bild;
    String name;
    public Skills(ImageIcon bild, String name){
        this.bild = bild;
        this.name = name;
    }
    //region hexer
    static Skills hexerSkill1 = new Skills(new ImageIcon("res/Skills/Hexer/1.png"), "1");
    static Skills hexerSkill2 = new Skills(new ImageIcon("res/Skills/Hexer/2.png"), "2");
    static Skills hexerSkill3 = new Skills(new ImageIcon("res/Skills/Hexer/3.png"), "3");
    static Skills hexerSkill4 = new Skills(new ImageIcon("res/Skills/Hexer/4.png"), "4");
    static Skills hexerSkill5 = new Skills(new ImageIcon("res/Skills/Hexer/5.png"), "5");
    static Skills hexerSkill6 = new Skills(new ImageIcon("res/Skills/Hexer/6.png"), "6");
    static Skills hexerSkill7 = new Skills(new ImageIcon("res/Skills/Hexer/7.png"), "7");
    static Skills hexerSkill8 = new Skills(new ImageIcon("res/Skills/Hexer/8.png"), "8");
    //endregion
}
