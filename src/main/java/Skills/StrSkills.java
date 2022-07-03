package Skills;

import javax.swing.*;

public class StrSkills extends Skills{
    public StrSkills(String name, int kraft, int genauigkeit, String mod, ImageIcon bild, String toolText){
        super(name,kraft,genauigkeit,mod,bild,toolText);
    }

    public static StrSkills angriffSkill = new StrSkills("Angriff", 100, 100,"str",
            new ImageIcon("res/Skills/Hexer/1.png"),"<html><p><font color='red' size='5' face='Segoe UI'>"
            +"Angriff</p></font><br><p><font size='4' face='Segoe UI'>Kraft: 100<br>Genauigkeit: 100</p></font>");
}
