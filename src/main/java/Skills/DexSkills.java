package Skills;

import javax.swing.*;

public class DexSkills extends Skills{
    public DexSkills(String name, int kraft, int genauigkeit, String mod, int spKosten, int schlagAnzhl, ImageIcon bild, String toolText){
        super(name,kraft,genauigkeit,mod,spKosten,schlagAnzhl,bild,toolText);
    }
    public static DexSkills gezielterSchussSkill = new DexSkills("Gezielter Schuss", 100, 100,
            "dex", 0,1,
            new ImageIcon("res/Skills/Hexer/2.png"),"<html><p><font color='green' size='5' face='Segoe UI'>"
            +"Gezielter Schuss</p></font><br><p><font size='4' face='Segoe UI'>Kraft: 100<br>Genauigkeit: 100</p></font>");
}
