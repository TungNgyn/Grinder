package Skills;

import javax.swing.*;

public class StrSkills extends Skills{
    public StrSkills(String name, int kraft, int genauigkeit, String mod, ImageIcon bild, String toolText){
        super(name,kraft,genauigkeit,mod,bild,toolText);
    }

    public static StrSkills angriffSkill = new StrSkills("Angriff", 100, 100,"str",
            new ImageIcon("res/Skills/Hexer/10.png"),"<html><p><font color='red' size='5' face='Segoe UI'>"
            +"Angriff</p></font><br><p><font size='4' face='Segoe UI'>Kraft: 100<br>Genauigkeit: 100</p></font>");
    public static StrSkills ansturmSkill = new StrSkills("Ansturm", 150,80,"str",
            new ImageIcon("res/Skills/Hexer/11.png"),"<html><p><font color='red' size='5' face='Segoe UI'>"
            +"Ansturm</p></font><br><p><font size='4' face='Segoe UI'>Kraft: 150<br>Genauigkeit: 80</p></font>");
    public static StrSkills blitzschlagSkill = new StrSkills("Blitzschlag", 120,90,"str",
            new ImageIcon("res/Skills/Hexer/12.png"),"<html><p><font color='red' size='5' face='Segoe UI'>"
            +"Blitzschlag</p></font><br><p><font size='4' face='Segoe UI'>Kraft: 120<br>Genauigkeit: 90</p></font>");
    public static StrSkills stampferSkill = new StrSkills("Stampfer", 60,150,"str",
            new ImageIcon("res/Skills/Hexer/13.png"),"<html><p><font color='red' size='5' face='Segoe UI'>"
            +"Stampfer</p></font><br><p><font size='4' face='Segoe UI'>Kraft: 60<br>Genauigkeit: 150</p></font>");
    public static StrSkills krueppelnderSchlagSkill = new StrSkills("Krüppelnder Schlag", 200,50,"str",
            new ImageIcon("res/Skills/Hexer/14.png"),"<html><p><font color='red' size='5' face='Segoe UI'>"
            +"Krüppelnder Schlag</p></font><br><p><font size='4' face='Segoe UI'>Kraft: 200<br>Genauigkeit: 50</p></font>");
}

