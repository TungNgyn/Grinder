package Skills;

import javax.swing.*;

public class KnoSkills extends Skills{
    public KnoSkills(String name, int kraft, int genauigkeit, String mod, ImageIcon bild, String toolText){
        super(name,kraft,genauigkeit,mod,bild,toolText);
    }
    public static KnoSkills magischesGeschossSkill = new KnoSkills("Magisches Geschoss", 100, 100,"kno",
            new ImageIcon("res/Skills/Hexer/3.png"),"<html><p><font color='blue' size='5' face='Segoe UI'>"
            +"Magisches Geschoss</p></font><br><p><font size='4' face='Segoe UI'>Kraft: 100<br>Genauigkeit: 100</p></font>");
}
