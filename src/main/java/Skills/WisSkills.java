package Skills;

import javax.swing.*;

public class WisSkills extends Skills{
    public WisSkills(String name, int kraft, int genauigkeit, String mod, ImageIcon bild, String toolText){
        super(name,kraft,genauigkeit,mod,bild,toolText);
    }
    public static WisSkills heiligerBlitzSkill = new WisSkills("Heiliger Blitz", 100, 100,"wis",
            new ImageIcon("res/Skills/Hexer/4.png"),"<html><p><font color='yellow' size='5' face='Segoe UI'>"
            +"Heiliger Blitz</p></font><br><p><font size='4' face='Segoe UI'>Kraft: 100<br>Genauigkeit: 100</p></font>");
}

