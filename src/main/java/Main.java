import com.formdev.flatlaf.FlatDarculaLaf;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Locale;

public class Main {
    private static JFrame adminFrame, mainFrame, logFrame;
    private static JPanel titelPanel, titelStartBtnPanel, spielPanel, skillBtnPanel,
            textAreaPanel, spielerStatsPanel, spielerProgressPanel, optionenPanel, logPanel,
            logBtnPanel, adminPanel, auswahlPanel;
    private static JTextArea logTextArea;
    private static JLabel titelLbl, statSpielerName, statSpielerHpLbl, statSpielerHp, mainTextLbl,
            statSpielerMpLbl, statSpielerMp, statSpielerExpLbl, statSpielerExp,
            statSpielerAtkLbl, statSpielerAtk, statSpielerDefLbl, statSpielerDef, spielGegnerHpLbl, spielGegnerHp,
            spielGegnerLvlLbl, spielGegnerLvl, spielGegnerName, statSpielerLvl, statSpielerLvlLbl;
    private static JButton titelStartBtn, logBtn, skillBtn1, skillBtn2, skillBtn3,
            skillBtn4, skillBtn5, adminBtn1, adminBtn2, adminBtn3, adminBtn4, adminBtn5, adminBtn6,
            adminBtn7, adminBtn8, adminBtn9, auswahlKriegerBtn;
    private static Container con, conLog, conAdmin;
    private static JScrollPane logTextAreaScroll;
    private static JProgressBar spielerHealthBar, spielerExpBar;
    static Font titelFont, normalFont, startBtnFont, statFont, textFont;
    static String gegnerName, spielerName;
    static int gegnerHp, gegnerMaxHp, gegnerMp, gegnerMaxMp, gegnerAtk, gegnerDef, gegnerLvl,
                spielerHp, spielerMaxHp, spielerMp, spielerMaxMp, spielerAtk, spielerDef, spielerLvl;
    static double gegnerExp, spielerExp;
    static SpringLayout layout = new SpringLayout();

    TitleScreenHandler tsHandler = new TitleScreenHandler();

    public static void main(String[] args){
        new Main();
    }

    public Main(){
        FlatDarculaLaf.setup();
        mainFrame = new JFrame("Grinder");
        mainFrame.setPreferredSize(new Dimension(800,600));
        titelFont = new Font("Times New Roman", Font.BOLD, 90);
        startBtnFont = new Font("Segoe UI", Font.BOLD,30);
        normalFont = new Font("Segoe UI", Font.BOLD,25);
        textFont = new Font("Segoe UI",Font.BOLD,15);

        titelPanel = new JPanel();
        titelPanel.setBounds(100,50,600,250);
        titelPanel.setBorder(BorderFactory.createLineBorder(Color.WHITE, 2, true));
        titelLbl = new JLabel("gfdfhrtd");
        titelLbl.setForeground(Color.WHITE);
        titelLbl.setFont(titelFont);
        titelPanel.add(titelLbl);

        titelStartBtnPanel = new JPanel();
        titelStartBtnPanel.setBounds(300,400,200,100);
        titelStartBtnPanel.setBorder(BorderFactory.createLineBorder(Color.WHITE, 2, true));

        titelStartBtn = new JButton("START");
        titelStartBtn.setFont(startBtnFont);
        titelStartBtn.setForeground(Color.WHITE);

        SpringLayout layout = new SpringLayout();
        layout.putConstraint(SpringLayout.NORTH, titelStartBtn, 20, SpringLayout.NORTH, titelStartBtnPanel);
        layout.putConstraint(SpringLayout.WEST, titelStartBtn, 35, SpringLayout.WEST, titelStartBtnPanel);
        titelStartBtnPanel.add(titelStartBtn);
        titelStartBtnPanel.setLayout(layout);

        mainFrame.pack();
        mainFrame.setLayout(null);
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.setVisible(true);
        mainFrame.setResizable(false);
        mainFrame.setLocationRelativeTo(null);
        con = mainFrame.getContentPane();
        con.add(titelStartBtnPanel);
        con.add(titelPanel);

        //region Textlogfenster
        logFrame = new JFrame("Textlog");
        logFrame.setPreferredSize(new Dimension(500,400));
        logFrame.setResizable(false);

        logPanel = new JPanel();
        logTextArea = new JTextArea();
        logTextArea.setLineWrap(true);
        logTextArea.setEditable(false);
        logTextArea.setFont(textFont);

        logTextAreaScroll = new JScrollPane(logTextArea);
        logTextAreaScroll.setPreferredSize(new Dimension(450,285));
        logTextAreaScroll.setBorder(BorderFactory.createEmptyBorder());
        logTextAreaScroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_NEVER);
        logTextAreaScroll.setBorder(BorderFactory.createLineBorder(Color.WHITE,2,true));
        logPanel.add(logTextAreaScroll);
        logPanel.setBackground(Color.GREEN);

        logBtnPanel = new JPanel();
        logBtnPanel.setBounds(17,300,450,50);
        logBtnPanel.setBorder(BorderFactory.createLineBorder(Color.WHITE,2,true));

        conLog = logFrame.getContentPane();
        conLog.setBackground(Color.GREEN);
        conLog.revalidate();
        conLog.add(logBtnPanel);
        conLog.add(logPanel);
        logFrame.pack();
        //endregion

        titelStartBtn.addActionListener(tsHandler);
    }
    public static void adminFenster(){
        adminFrame = new JFrame("Admin");
        adminPanel = new JPanel();
        conAdmin = new Container();

        //region admin Buttons
        adminBtn1 = new JButton("MainText set");
        adminBtn2 = new JButton("MainText app");
        adminBtn3 = new JButton("Exp");
        adminBtn4 = new JButton("DMG");
        adminBtn5 = new JButton("Heal");
        adminBtn6 = new JButton("Zombie");
        adminBtn7 = new JButton("Kampf");
        adminBtn8 = new JButton("Krieger");
        adminBtn9 = new JButton("Zauberer");

        adminPanel.add(adminBtn1);
        adminPanel.add(adminBtn2);
        adminPanel.add(adminBtn3);
        adminPanel.add(adminBtn4);
        adminPanel.add(adminBtn5);
        adminPanel.add(adminBtn6);
        adminPanel.add(adminBtn7);
        adminPanel.add(adminBtn8);
        adminPanel.add(adminBtn9);
        //endregion

        adminBtn1.addActionListener(e -> logTextArea.setText(""));
        adminBtn2.addActionListener(e -> {
            mainTextLbl.setText("<br>aaaaaaaaaaaaaaaaaa<br>bbbbbbbbbbbbbb<br>>cccccccccccc<br>ddddddddddddd<br>eeeeeeeeeeee");
            logTextArea.append("aaaaaaaaaaaaaaaaaa\nbbbbbbbbbbbbbb\ncccccccccccc\nddddddddddddd\neeeeeeeeeeee");
        });
        adminBtn3.addActionListener(e -> {
            spielerExp = spielerExp + 10.0;
            updateSpielerStats();
        });
        adminBtn4.addActionListener(e -> {
            spielerHp -= 5;
            updateSpielerStats();
        });
        adminBtn5.addActionListener(e -> {
            spielerHp += 5;
            updateSpielerStats();
        });
        adminBtn6.addActionListener(e -> {
            Gegner.zombie.lvl = 1;
            gegnerLvl = Gegner.zombie.lvl;
            gegnerName = Gegner.zombie.name;
            gegnerMaxHp = Gegner.zombie.maxHp*Gegner.zombie.lvl;
            gegnerHp = gegnerMaxHp;
            gegnerMaxMp = Gegner.zombie.maxMp*Gegner.zombie.lvl;
            gegnerMp = gegnerMaxMp;
            gegnerAtk = Gegner.zombie.attack()*Gegner.zombie.lvl;
            gegnerDef = Gegner.zombie.defend()*Gegner.zombie.lvl;
            gegnerExp = Gegner.zombie.exp;
            updateGegnerHp();
        });
        adminBtn7.addActionListener(e -> {
            kampf();
        });

        adminBtn8.addActionListener(e -> {

        });

        adminBtn9.addActionListener(e -> {
            spielerName = Spieler.zauberer.name;
            spielerMaxHp = Spieler.zauberer.maxHp;
            spielerHp = spielerMaxHp;
            spielerMaxMp = Spieler.zauberer.maxMp;
            spielerMp = spielerMaxMp;
            spielerAtk = Spieler.zauberer.attack();
            spielerDef = Spieler.zauberer.defend();
            spielerExp = Spieler.zauberer.exp;
            spielerLvl = Spieler.zauberer.lvl;
            updateSpielerStats();
        });

        conAdmin = adminFrame.getContentPane();
        conAdmin.add(adminPanel);
        adminFrame.setPreferredSize(new Dimension(400,300));
        adminFrame.setResizable(false);
        adminFrame.pack();
        adminFrame.setVisible(true);
    }
    public static void updateSpielerStats(){
        if (spielerExp>99.9999999999){
            spielerLvl++;
            spielerExp = 0;

            statSpielerLvl.setText(""+spielerLvl);
            spielerMaxHp *= spielerLvl;
            spielerHp = spielerMaxHp;
            spielerMaxMp *= spielerLvl;
            spielerMp = spielerMaxMp;
            statSpielerExp.setText(""+(String.format(Locale.US,"%.2f",spielerExp)+"%"));
            spielerAtk = spielerLvl;
            spielerDef = spielerLvl;
            updateSpielerStats();
        }
        statSpielerName.setText(spielerName);
        statSpielerExp.setText(String.format(Locale.US,"%.2f",spielerExp)+"%");
        statSpielerLvl.setText(""+spielerLvl);
        statSpielerHp.setText(spielerHp+"/"+spielerMaxHp);
        statSpielerMp.setText(spielerMp+"/"+spielerMaxMp);
        statSpielerAtk.setText(""+spielerAtk);
        statSpielerDef.setText(""+spielerDef);
        spielerHealthBar.setValue(spielerHp);
        spielerExpBar.setValue((int)spielerExp);
    }
    public static void updateGegnerHp(){
        spielGegnerLvl.setText(""+gegnerLvl);
        spielGegnerHp.setText(gegnerHp+"/"+gegnerMaxHp);
    }
    public static void kampf(){
        int angriff = spielerAtk - gegnerDef;
        int schaden = gegnerAtk - spielerDef;

        if (angriff <= 0){
            angriff = 0;
        }
        if (schaden <= 0){
            schaden = 0;
        }

        if((spielerHp > 0) && (gegnerHp > 0)){
            gegnerHp -= angriff;
            logTextArea.append("\n"+spielerName+" verursacht "+angriff+" Schaden an "+ gegnerName+"!");
            mainTextLbl.setText("<html>"+spielerName+" verursacht "+angriff+" Schaden an "+gegnerName+"!");
            if (gegnerHp > 0) {
                spielerHp -= schaden;
                spielerHealthBar.setValue(spielerHp);
                logTextArea.append("\n"+gegnerName+" verursacht "+schaden+" Schaden an "+spielerName+"!");
                mainTextLbl.setText(mainTextLbl.getText()+"<br>"+gegnerName+" verursacht "+schaden+" Schaden an "+spielerName+"!");
                if (spielerHp <= 0){
                    spielerHp = 0;
                    logTextArea.append("\nGestorben...");
                    mainTextLbl.setText(mainTextLbl.getText()+"<br>Gestorben...!");
                }
            } else{
                gegnerHp = 0;
                logTextArea.append("\nGewonnen!\n"+(String.format(Locale.US,"%.2f",gegnerExp))+" Erfahrungspunkte erhalten.");
                mainTextLbl.setText(mainTextLbl.getText()+"<br>Gewonnen!<br>"+(String.format(Locale.US,"%.2f",gegnerExp))+" Erfahrungspunkte erhalten.");
                spielerExp += gegnerExp;
                updateSpielerStats();
            }
        }

        updateSpielerStats();
        updateGegnerHp();
    }
    public static void spielFenster(){
        //region Layout
        spielPanel = new JPanel();
        spielPanel.setBounds(20,20,500,300);
        spielPanel.setBorder(BorderFactory.createLineBorder(Color.WHITE,2,true));

        textAreaPanel = new JPanel();
        textAreaPanel.setBounds(20,330,500,140);
        textAreaPanel.setBorder(BorderFactory.createLineBorder(Color.WHITE,2,true));

        mainTextLbl = new JLabel("<html>TEST<br>hallotestt2<br>qweqe");
        mainTextLbl.setFont(textFont);

        skillBtnPanel = new JPanel();
        skillBtnPanel.setLayout(new GridLayout());
        skillBtnPanel.setBounds(20,480, 500,60);
        skillBtnPanel.setBorder(BorderFactory.createLineBorder(Color.WHITE,2,true));

        spielerStatsPanel = new JPanel();
        spielerStatsPanel.setBounds(550,90,215,230);
        spielerStatsPanel.setBorder(BorderFactory.createLineBorder(Color.WHITE,2,true));

        spielerProgressPanel = new JPanel();
        spielerProgressPanel.setBounds(550,330,215,210);
        spielerProgressPanel.setBorder(BorderFactory.createLineBorder(Color.WHITE,2,true));

        spielerHealthBar = new JProgressBar(0,spielerMaxHp);
        spielerHealthBar.setFont(normalFont);
        spielerHealthBar.setStringPainted(true);
        spielerHealthBar.setPreferredSize(new Dimension(180,20));
        spielerProgressPanel.add(spielerHealthBar);

        spielerExpBar = new JProgressBar(0,100);
        spielerExpBar.setFont(normalFont);
        spielerExpBar.setStringPainted(true);
        spielerExpBar.setPreferredSize(new Dimension(180,20));
        spielerProgressPanel.add(spielerExpBar);

        ImageIcon einstellungIcon = new ImageIcon("res/Settings.png");
        optionenPanel = new JPanel();
        optionenPanel.setLayout(new GridLayout(1,3));
        optionenPanel.setBounds(550,20,215,60);
        optionenPanel.setBorder(BorderFactory.createLineBorder(Color.WHITE,2,true));
        logBtn = new JButton(einstellungIcon);
        logBtn.setFont(normalFont);
        optionenPanel.add(Box.createHorizontalGlue());
        optionenPanel.add(Box.createHorizontalGlue());
        optionenPanel.add(logBtn);
        //endregion

        //region Skillbuttons
        skillBtn1 = new JButton("Skill1");
        skillBtn2 = new JButton("Skill2");
        skillBtn3 = new JButton("Skill3");
        skillBtn4 = new JButton("Skill4");
        skillBtn5 = new JButton("Skill5");

        skillBtn1.setFont(normalFont);
        skillBtn2.setFont(normalFont);
        skillBtn3.setFont(normalFont);
        skillBtn4.setFont(normalFont);
        skillBtn5.setFont(normalFont);

        skillBtn1.setForeground(Color.WHITE);
        skillBtn2.setForeground(Color.WHITE);
        skillBtn3.setForeground(Color.WHITE);
        skillBtn4.setForeground(Color.WHITE);
        skillBtn5.setForeground(Color.WHITE);

        skillBtnPanel.add(skillBtn1);
        skillBtnPanel.add(skillBtn2);
        skillBtnPanel.add(skillBtn3);
        skillBtnPanel.add(skillBtn4);
        skillBtnPanel.add(skillBtn5);
        //endregion
        //region Spielerstats
        statFont = new Font("Segoe UI",Font.BOLD,15);
        statSpielerName = new JLabel(spielerName);
        statSpielerHpLbl = new JLabel("HP");
        statSpielerHp = new JLabel(spielerHp+"/"+spielerMaxHp);
        statSpielerLvlLbl = new JLabel("Level");
        statSpielerLvl = new JLabel(""+spielerLvl);
        statSpielerMpLbl = new JLabel("MP");
        statSpielerMp = new JLabel(spielerMp+"/"+spielerMaxMp);
        statSpielerExpLbl = new JLabel("EXP");
        statSpielerExp = new JLabel(String.format(Locale.US,"%.2f",spielerExp)+"%");
        statSpielerAtkLbl = new JLabel("Angriff");
        statSpielerAtk = new JLabel(""+spielerAtk);
        statSpielerDefLbl = new JLabel("Verteidigung");
        statSpielerDef = new JLabel(""+spielerDef);

        statSpielerName.setFont(statFont);
        statSpielerHpLbl.setFont(statFont);
        statSpielerHp.setFont(statFont);
        statSpielerLvlLbl.setFont(statFont);
        statSpielerLvl.setFont(statFont);
        statSpielerMpLbl.setFont(statFont);
        statSpielerMp.setFont(statFont);
        statSpielerExpLbl.setFont(statFont);
        statSpielerExp.setFont(statFont);
        statSpielerAtkLbl.setFont(statFont);
        statSpielerAtk.setFont(statFont);
        statSpielerDefLbl.setFont(statFont);
        statSpielerDef.setFont(statFont);

        //layout links
        layout.putConstraint(SpringLayout.WEST,statSpielerName,20, SpringLayout.WEST,spielerStatsPanel);
        layout.putConstraint(SpringLayout.WEST,statSpielerHpLbl,20, SpringLayout.WEST,spielerStatsPanel);
        layout.putConstraint(SpringLayout.WEST,statSpielerMpLbl,20, SpringLayout.WEST,spielerStatsPanel);
        layout.putConstraint(SpringLayout.WEST,statSpielerExpLbl,20, SpringLayout.WEST,spielerStatsPanel);
        layout.putConstraint(SpringLayout.WEST,statSpielerAtkLbl,20, SpringLayout.WEST,spielerStatsPanel);
        layout.putConstraint(SpringLayout.WEST,statSpielerDefLbl,20, SpringLayout.WEST,spielerStatsPanel);
        layout.putConstraint(SpringLayout.WEST,statSpielerLvlLbl,20, SpringLayout.WEST,spielerStatsPanel);

      //  layout.putConstraint(SpringLayout.NORTH,statSpielerName,20, SpringLayout.NORTH,spielerStatsPanel);
        layout.putConstraint(SpringLayout.NORTH,statSpielerLvlLbl,20, SpringLayout.NORTH,spielerStatsPanel);
        layout.putConstraint(SpringLayout.NORTH,statSpielerHpLbl,50, SpringLayout.NORTH,spielerStatsPanel);
        layout.putConstraint(SpringLayout.NORTH,statSpielerMpLbl,80, SpringLayout.NORTH,spielerStatsPanel);
        layout.putConstraint(SpringLayout.NORTH,statSpielerExpLbl,110, SpringLayout.NORTH,spielerStatsPanel);
        layout.putConstraint(SpringLayout.NORTH,statSpielerAtkLbl,140, SpringLayout.NORTH,spielerStatsPanel);
        layout.putConstraint(SpringLayout.NORTH,statSpielerDefLbl,170, SpringLayout.NORTH,spielerStatsPanel);

        //layout rechts
        layout.putConstraint(SpringLayout.EAST,statSpielerHp,-20, SpringLayout.EAST,spielerStatsPanel);
        layout.putConstraint(SpringLayout.EAST,statSpielerMp,-20, SpringLayout.EAST,spielerStatsPanel);
        layout.putConstraint(SpringLayout.EAST,statSpielerExp,-20, SpringLayout.EAST,spielerStatsPanel);
        layout.putConstraint(SpringLayout.EAST,statSpielerAtk,-20, SpringLayout.EAST,spielerStatsPanel);
        layout.putConstraint(SpringLayout.EAST,statSpielerDef,-20, SpringLayout.EAST,spielerStatsPanel);
        layout.putConstraint(SpringLayout.EAST,statSpielerLvl,-20, SpringLayout.EAST,spielerStatsPanel);

        layout.putConstraint(SpringLayout.NORTH,statSpielerLvl,20, SpringLayout.NORTH,spielerStatsPanel);
        layout.putConstraint(SpringLayout.NORTH,statSpielerHp,50, SpringLayout.NORTH,spielerStatsPanel);
        layout.putConstraint(SpringLayout.NORTH,statSpielerMp,80, SpringLayout.NORTH,spielerStatsPanel);
        layout.putConstraint(SpringLayout.NORTH,statSpielerExp,110, SpringLayout.NORTH,spielerStatsPanel);
        layout.putConstraint(SpringLayout.NORTH,statSpielerAtk,140, SpringLayout.NORTH,spielerStatsPanel);
        layout.putConstraint(SpringLayout.NORTH,statSpielerDef,170, SpringLayout.NORTH,spielerStatsPanel);


        spielerStatsPanel.setLayout(layout);
        spielerStatsPanel.add(statSpielerName);
        spielerStatsPanel.add(statSpielerHpLbl);
        spielerStatsPanel.add(statSpielerHp);
        spielerStatsPanel.add(statSpielerLvlLbl);
        spielerStatsPanel.add(statSpielerLvl);
        spielerStatsPanel.add(statSpielerMpLbl);
        spielerStatsPanel.add(statSpielerMp);
        spielerStatsPanel.add(statSpielerExpLbl);
        spielerStatsPanel.add(statSpielerExp);
        spielerStatsPanel.add(statSpielerAtkLbl);
        spielerStatsPanel.add(statSpielerAtk);
        spielerStatsPanel.add(statSpielerDefLbl);
        spielerStatsPanel.add(statSpielerDef);

 //       spielerStatsPanel.add(statPanel);
        //endregion
        //region GegnerPanel
        spielGegnerHpLbl = new JLabel("HP");
        spielGegnerHp = new JLabel(gegnerHp+"/"+gegnerMaxHp);
        spielGegnerName = new JLabel(gegnerName);
        spielGegnerLvlLbl = new JLabel("Level");
        spielGegnerLvl = new JLabel(""+gegnerLvl);

        spielPanel.add(spielGegnerHpLbl);
        spielPanel.add(spielGegnerHp);
        spielPanel.add(spielGegnerName);
        spielPanel.add(spielGegnerLvlLbl);
        spielPanel.add(spielGegnerLvl);
        //endregion

        logBtn.addActionListener(e -> logFrame.setVisible(true));

        auswahlPanel.setVisible(false);
        textAreaPanel.add(mainTextLbl);
        updateSpielerStats();
        con.add(spielerStatsPanel);
        con.add(spielPanel);
        con.add(skillBtnPanel);
        con.add(textAreaPanel);
        con.add(spielerProgressPanel);
        con.add(optionenPanel);
        con.setVisible(true);
        con.revalidate();
        con.repaint();
    }

    public static void charakterAuswahl(){
        auswahlPanel = new JPanel();
        auswahlPanel.setBounds(20,20,745,515);
        auswahlPanel.setBorder(BorderFactory.createLineBorder(Color.WHITE,2,true));

        auswahlKriegerBtn = new JButton("Krieger");
        auswahlKriegerBtn.setFont(normalFont);

        auswahlKriegerBtn.addActionListener(e -> {
            spielerName = Spieler.krieger.name;
            spielerMaxHp = Spieler.krieger.maxHp;
            spielerHp = spielerMaxHp;
            spielerMaxMp = Spieler.krieger.maxMp;
            spielerMp = spielerMaxMp;
            spielerAtk = Spieler.krieger.atk;
            spielerDef = Spieler.krieger.defend();
            spielerExp = Spieler.krieger.exp;
            spielerLvl = Spieler.krieger.lvl;
            spielFenster();
        });

        auswahlPanel.add(auswahlKriegerBtn);
        titelPanel.setVisible(false);
        titelStartBtnPanel.setVisible(false);
        con.add(auswahlPanel);
        con.setVisible(true);
        con.revalidate();
        con.repaint();
    }
    public static class TitleScreenHandler implements ActionListener{
        public void actionPerformed(ActionEvent e){
            charakterAuswahl();
            adminFenster();
        }
    }
}
