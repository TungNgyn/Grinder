import com.formdev.flatlaf.FlatDarculaLaf;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Locale;
import java.util.Random;

public class Main {
    private static JFrame adminFrame, mainFrame, logFrame;
    private static JPanel titelPanel, titelStartBtnPanel, spielPanel, skillBtnPanel,
            textAreaPanel, spielerStatsPanel, spielerProgressPanel, optionenPanel, logPanel, vorschauStatsPanel,
            logBtnPanel, adminPanel, auswahlPanelLinks, vorschauPanel, auswahlPanelRechts, gegnerInfoPanel,
            gegnerBildPanel, naviPanel;
    private static JTextArea logTextArea;
    private static JLabel titelLbl, statSpielerName, statSpielerHpLbl, statSpielerHp, mainTextLbl,
            statSpielerMpLbl, statSpielerMp, statSpielerExpLbl, statSpielerExp,
            statSpielerAtkLbl, statSpielerAtk, statSpielerDefLbl, statSpielerDef, spielGegnerHp,
            spielGegnerLvl, spielGegnerName, statSpielerLvl, statSpielerLvlLbl, vorschauLbl,
            vorschauStatsLblRechts, vorschauStatsLblLinks, vorschauStatsName, gegnerBildLbl,
            naviLinksLbl, naviRechtsLbl, naviLinksLinksLbl, naviLinksRechtsLbl, naviRechtsLinksLbl,
            naviRechtsRechtsLbl;
    private static JButton titelStartBtn, logBtn, skillBtn1, skillBtn2, skillBtn3,
            skillBtn4, skillBtn5, adminBtn1, adminBtn2, adminBtn3, adminBtn4, adminBtn5, adminBtn6,
            adminBtn7, adminBtn8, adminBtn9, auswahlKriegerBtn, auswahlMagierBtn, auswahlJaegerBtn,
            auswahlPriesterBtn, auswahlBtn, adminBtn10, auswahlPaladinBtn, auswahlNinjaBtn,
            adminBtn11, adminBtn12;
    private static Container con, conLog, conAdmin;
    private static JScrollPane logTextAreaScroll;
    private static JProgressBar spielerHealthBar, spielerExpBar, gegnerHealthBar;
    static Font titelFont, normalFont, startBtnFont, statFont, textFont, vorschauFont, barFont;
    static String gegnerName, spielerName;
    static int gegnerHp, gegnerMaxHp, gegnerMp, gegnerMaxMp, gegnerAtk, gegnerDef, gegnerLvl,
                spielerHp, spielerMaxHp, spielerMp, spielerMaxMp, spielerAtk, spielerDef, spielerLvl,
            spielerStr, spielerDex, spielerKno, spielerWis;
    static double gegnerExp, spielerExp;
    static SpringLayout layout = new SpringLayout();

    static Gegner[] gegnerListe = new Gegner[4];
    static Karte[] kartenListe = new Karte[2];

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
        normalFont = new Font("Segoe UI", Font.BOLD,22);
        textFont = new Font("Segoe UI",Font.BOLD,15);
        barFont = new Font("Segoe UI", Font.BOLD,18);

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
    public static void mapInitialisieren(){
        kartenListe[0] = Karte.gegner;
        kartenListe[1] = Karte.lager;
        kartenListe[2] = Karte.event;
    }
    public static void gegnerInitialisieren(){
        gegnerListe[0] = Gegner.schneemann;
        gegnerListe[1] = Gegner.oger;
        gegnerListe[2] = Gegner.fledermaus;
        gegnerListe[3] = Gegner.geist;
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
        adminBtn6 = new JButton("Schneemann");
        adminBtn7 = new JButton("Kampf");
        adminBtn8 = new JButton("Fledermaus");
        adminBtn9 = new JButton("Oger");
        adminBtn10 = new JButton("Geist");
        adminBtn11 = new JButton("Skill1 ändern");
        adminBtn12 = new JButton("Random Encounter");

        adminPanel.add(adminBtn1);
        adminPanel.add(adminBtn2);
        adminPanel.add(adminBtn3);
        adminPanel.add(adminBtn4);
        adminPanel.add(adminBtn5);
        adminPanel.add(adminBtn6);
        adminPanel.add(adminBtn7);
        adminPanel.add(adminBtn8);
        adminPanel.add(adminBtn9);
        adminPanel.add(adminBtn10);
        adminPanel.add(adminBtn11);
        adminPanel.add(adminBtn12);
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
            Gegner.schneemann.lvl = 1;
            gegnerLvl = Gegner.schneemann.lvl;
            gegnerName = Gegner.schneemann.name;
            gegnerMaxHp = Gegner.schneemann.maxHp*Gegner.schneemann.lvl;
            gegnerHp = gegnerMaxHp;
            gegnerMaxMp = Gegner.schneemann.maxMp*Gegner.schneemann.lvl;
            gegnerMp = gegnerMaxMp;
            gegnerAtk = Gegner.schneemann.attack()*Gegner.schneemann.lvl;
            gegnerDef = Gegner.schneemann.defend()*Gegner.schneemann.lvl;
            gegnerExp = Gegner.schneemann.exp;
            gegnerHealthBar.setMaximum(gegnerMaxHp);
            updateGegnerHp();
            gegnerInfoPanel.setVisible(true);
            ImageIcon gegnerBild = new ImageIcon("res/Gegner/Schneemann.png");
            gegnerBildLbl.setVisible(true);
            gegnerBildLbl.setIcon(gegnerBild);
        });
        adminBtn7.addActionListener(e -> {
            kampf();
        });
        adminBtn8.addActionListener(e -> {
            Gegner.fledermaus.lvl = 1;
            gegnerLvl = Gegner.fledermaus.lvl;
            gegnerName = Gegner.fledermaus.name;
            gegnerMaxHp = Gegner.fledermaus.maxHp*Gegner.fledermaus.lvl;
            gegnerHp = gegnerMaxHp;
            gegnerMaxMp = Gegner.fledermaus.maxMp*Gegner.fledermaus.lvl;
            gegnerMp = gegnerMaxMp;
            gegnerAtk = Gegner.fledermaus.attack()*Gegner.fledermaus.lvl;
            gegnerDef = Gegner.fledermaus.defend()*Gegner.fledermaus.lvl;
            gegnerExp = Gegner.fledermaus.exp;
            gegnerHealthBar.setMaximum(gegnerMaxHp);
            updateGegnerHp();
            gegnerInfoPanel.setVisible(true);
            ImageIcon gegnerBild = new ImageIcon("res/Gegner/Bat.png");
            gegnerBildLbl.setVisible(true);
            gegnerBildLbl.setIcon(gegnerBild);
        });
        adminBtn9.addActionListener(e -> {
            Gegner.oger.lvl = 1;
            gegnerLvl = Gegner.oger.lvl;
            gegnerName = Gegner.oger.name;
            gegnerMaxHp = Gegner.oger.maxHp*Gegner.oger.lvl;
            gegnerHp = gegnerMaxHp;
            gegnerMaxMp = Gegner.oger.maxMp*Gegner.oger.lvl;
            gegnerMp = gegnerMaxMp;
            gegnerAtk = Gegner.oger.attack()*Gegner.oger.lvl;
            gegnerDef = Gegner.oger.defend()*Gegner.oger.lvl;
            gegnerExp = Gegner.oger.exp;
            gegnerHealthBar.setMaximum(gegnerMaxHp);
            updateGegnerHp();
            gegnerInfoPanel.setVisible(true);
            ImageIcon gegnerBild = new ImageIcon("res/Gegner/Ogre.png");
            gegnerBildLbl.setVisible(true);
            gegnerBildLbl.setIcon(gegnerBild);
        });
        adminBtn10.addActionListener(e -> {
            Gegner.geist.lvl = 1;
            gegnerLvl = Gegner.geist.lvl;
            gegnerName = Gegner.geist.name;
            gegnerMaxHp = Gegner.geist.maxHp*Gegner.geist.lvl;
            gegnerHp = gegnerMaxHp;
            gegnerMaxMp = Gegner.geist.maxMp*Gegner.geist.lvl;
            gegnerMp = gegnerMaxMp;
            gegnerAtk = Gegner.geist.attack()*Gegner.geist.lvl;
            gegnerDef = Gegner.geist.defend()*Gegner.geist.lvl;
            gegnerExp = Gegner.geist.exp;
            gegnerHealthBar.setMaximum(gegnerMaxHp);
            updateGegnerHp();
            gegnerInfoPanel.setVisible(true);
            ImageIcon gegnerBild = new ImageIcon("res/Gegner/Ghost.png");
            gegnerBildLbl.setVisible(true);
            gegnerBildLbl.setIcon(gegnerBild);
        });
        adminBtn11.addActionListener(e -> {
            skillBtn1.setIcon(Skills.hexerSkill27);
            System.out.println(true);
            skillBtn1.setToolTipText("<html><font color='#ff0000'>Skill 2</font><br>lklk<br>izztf");
        });
        adminBtn12.addActionListener(e -> {
            Random rnd = new Random();
            int i = rnd.nextInt(0,3);
            gegnerName = gegnerListe[i].name;
            updateGegnerHp();
            Gegner.geist.lvl = 1;
            gegnerLvl = gegnerListe[i].lvl;
            gegnerName = gegnerListe[i].name;
            gegnerMaxHp = gegnerListe[i].maxHp*gegnerListe[i].lvl;
            gegnerHp = gegnerMaxHp;
            gegnerMaxMp = gegnerListe[i].maxMp*gegnerListe[i].lvl;
            gegnerMp = gegnerMaxMp;
            gegnerAtk = gegnerListe[i].attack()*gegnerListe[i].lvl;
            gegnerDef = gegnerListe[i].defend()*gegnerListe[i].lvl;
            gegnerExp = gegnerListe[i].exp;
            gegnerHealthBar.setMaximum(gegnerMaxHp);
            updateGegnerHp();
            gegnerInfoPanel.setVisible(true);
            ImageIcon gegnerBild = new ImageIcon("res/Gegner/"+gegnerListe[i].name+".png");
            gegnerBildLbl.setVisible(true);
            gegnerBildLbl.setIcon(gegnerBild);
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
            spielerAtk *= spielerLvl;
            spielerDef *= spielerLvl;
            spielerHealthBar.setMaximum(spielerMaxHp);
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
        spielGegnerName.setText(gegnerName);
        spielGegnerLvl.setText("Level: "+gegnerLvl);
        spielGegnerHp.setText("HP: "+gegnerHp+"/"+gegnerMaxHp);
        gegnerHealthBar.setValue(gegnerHp);
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
                gegnerBildLbl.setVisible(false);
                gegnerInfoPanel.setVisible(false);
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
        SpringLayout skillBtnLayout = new SpringLayout();
        skillBtnPanel.setLayout(skillBtnLayout);
        skillBtnPanel.setBounds(20,480, 500,60);
        skillBtnPanel.setBorder(BorderFactory.createLineBorder(Color.WHITE,2,true));

        spielerStatsPanel = new JPanel();
        spielerStatsPanel.setBounds(550,90,215,230);
        spielerStatsPanel.setBorder(BorderFactory.createLineBorder(Color.WHITE,2,true));

        SpringLayout spielerProgressLayout = new SpringLayout();
        spielerProgressPanel = new JPanel();
        spielerProgressPanel.setBounds(550,330,215,210);
        spielerProgressPanel.setBorder(BorderFactory.createLineBorder(Color.WHITE,2,true));
        spielerProgressPanel.setLayout(spielerProgressLayout);

        spielerHealthBar = new JProgressBar(0,spielerMaxHp);
        spielerExpBar = new JProgressBar(0,100);

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
        skillBtn1 = new JButton(Skills.hexerSkill1);
        skillBtn2 = new JButton(Skills.hexerSkill2);
        skillBtn3 = new JButton(Skills.hexerSkill3);
        skillBtn4 = new JButton(Skills.hexerSkill4);
        skillBtn5 = new JButton(Skills.hexerSkill5);
//        skillBtn6 = new JButton(Skills.hexerSkill6);
//        skillBtn7 = new JButton(Skills.hexerSkill7);
//        skillBtn8 = new JButton(Skills.hexerSkill8);

        skillBtn1.setPreferredSize(new Dimension(50,50));
        skillBtn2.setPreferredSize(new Dimension(50,50));
        skillBtn3.setPreferredSize(new Dimension(50,50));
        skillBtn4.setPreferredSize(new Dimension(50,50));
        skillBtn5.setPreferredSize(new Dimension(50,50));
//        skillBtn6.setPreferredSize(new Dimension(50,50));
//        skillBtn7.setPreferredSize(new Dimension(50,50));
//        skillBtn8.setPreferredSize(new Dimension(50,50));

        skillBtn1.setToolTipText("<html><font color='green'>Skill 1</font><br>lklk<br>izztf");
        skillBtn5.setEnabled(false);
        //region layout
        skillBtnLayout.putConstraint(SpringLayout.VERTICAL_CENTER,skillBtn1,0,SpringLayout.VERTICAL_CENTER,skillBtnPanel);
        skillBtnLayout.putConstraint(SpringLayout.VERTICAL_CENTER,skillBtn2,0,SpringLayout.VERTICAL_CENTER,skillBtnPanel);
        skillBtnLayout.putConstraint(SpringLayout.VERTICAL_CENTER,skillBtn3,0,SpringLayout.VERTICAL_CENTER,skillBtnPanel);
        skillBtnLayout.putConstraint(SpringLayout.VERTICAL_CENTER,skillBtn4,0,SpringLayout.VERTICAL_CENTER,skillBtnPanel);
        skillBtnLayout.putConstraint(SpringLayout.VERTICAL_CENTER,skillBtn5,0,SpringLayout.VERTICAL_CENTER,skillBtnPanel);
//        skillBtnLayout.putConstraint(SpringLayout.VERTICAL_CENTER,skillBtn6,0,SpringLayout.VERTICAL_CENTER,skillBtnPanel);
//        skillBtnLayout.putConstraint(SpringLayout.VERTICAL_CENTER,skillBtn7,0,SpringLayout.VERTICAL_CENTER,skillBtnPanel);
//        skillBtnLayout.putConstraint(SpringLayout.VERTICAL_CENTER,skillBtn8,0,SpringLayout.VERTICAL_CENTER,skillBtnPanel);

        skillBtnLayout.putConstraint(SpringLayout.WEST,skillBtn1,100,SpringLayout.WEST,skillBtnPanel);
        skillBtnLayout.putConstraint(SpringLayout.WEST,skillBtn2,10,SpringLayout.EAST,skillBtn1);
        skillBtnLayout.putConstraint(SpringLayout.WEST,skillBtn3,10,SpringLayout.EAST,skillBtn2);
        skillBtnLayout.putConstraint(SpringLayout.WEST,skillBtn4,10,SpringLayout.EAST,skillBtn3);
        skillBtnLayout.putConstraint(SpringLayout.WEST,skillBtn5,10,SpringLayout.EAST,skillBtn4);
//        skillBtnLayout.putConstraint(SpringLayout.WEST,skillBtn6,10,SpringLayout.EAST,skillBtn5);
//        skillBtnLayout.putConstraint(SpringLayout.WEST,skillBtn7,10,SpringLayout.EAST,skillBtn6);
//        skillBtnLayout.putConstraint(SpringLayout.WEST,skillBtn8,10,SpringLayout.EAST,skillBtn7);
        //endregion
//        skillBtn1.setBorderPainted(false);
//        skillBtn1.setContentAreaFilled(false);
//        skillBtn1.setFocusPainted(false);
//        skillBtn1.setOpaque(false);

//        skillBtn1.setFont(normalFont);
//        skillBtn2.setFont(normalFont);
//        skillBtn3.setFont(normalFont);
//        skillBtn4.setFont(normalFont);
//        skillBtn5.setFont(normalFont);

//        skillBtn1.setForeground(Color.WHITE);
//        skillBtn2.setForeground(Color.WHITE);
//        skillBtn3.setForeground(Color.WHITE);
//        skillBtn4.setForeground(Color.WHITE);
//        skillBtn5.setForeground(Color.WHITE);

        skillBtnPanel.add(skillBtn1);
        skillBtnPanel.add(skillBtn2);
        skillBtnPanel.add(skillBtn3);
        skillBtnPanel.add(skillBtn4);
        skillBtnPanel.add(skillBtn5);
//        skillBtnPanel.add(skillBtn6);
//        skillBtnPanel.add(skillBtn7);
//        skillBtnPanel.add(skillBtn8);
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
        JLabel statSpielerStrLbl = new JLabel("<html><font color='#ff0000'>Stärke");
        JLabel statSpielerStr = new JLabel("" + spielerStr);
        JLabel statSpielerDexLbl = new JLabel("<html><font color='#3cb371'>Geschick");
        JLabel statSpielerDex = new JLabel("" + spielerDex);
        JLabel statSpielerKnoLbl = new JLabel("<html><font color='#94d0ff'>Intelligenz");
        JLabel statSpielerKno = new JLabel("" + spielerKno);
        JLabel statSpielerWisLbl = new JLabel("<html><font color='#ffe400'>Weisheit");
        JLabel statSpielerWis = new JLabel("" + spielerWis);


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
        statSpielerStrLbl.setFont(statFont);
        statSpielerStr.setFont(statFont);
        statSpielerDexLbl.setFont(statFont);
        statSpielerDex.setFont(statFont);
        statSpielerKnoLbl.setFont(statFont);
        statSpielerKno.setFont(statFont);
        statSpielerWisLbl.setFont(statFont);
        statSpielerWis.setFont(statFont);

        spielerHealthBar.setFont(barFont);
        spielerHealthBar.setStringPainted(true);
        spielerHealthBar.setForeground(Color.decode("#C70039"));
        spielerHealthBar.setPreferredSize(new Dimension(180,20));

        spielerExpBar.setFont(barFont);
        spielerExpBar.setStringPainted(true);
        spielerExpBar.setForeground(new Color(192,129,0));
        spielerExpBar.setPreferredSize(new Dimension(180,20));

        //layout links
        layout.putConstraint(SpringLayout.HORIZONTAL_CENTER,statSpielerName,0, SpringLayout.HORIZONTAL_CENTER,spielerStatsPanel);
        layout.putConstraint(SpringLayout.WEST,statSpielerLvlLbl,20, SpringLayout.WEST,spielerStatsPanel);
        layout.putConstraint(SpringLayout.WEST,statSpielerHpLbl,20, SpringLayout.WEST,spielerStatsPanel);
        layout.putConstraint(SpringLayout.HORIZONTAL_CENTER,spielerHealthBar,0,SpringLayout.HORIZONTAL_CENTER,spielerStatsPanel);
        layout.putConstraint(SpringLayout.WEST,statSpielerMpLbl,20, SpringLayout.WEST,spielerStatsPanel);
        layout.putConstraint(SpringLayout.WEST,statSpielerExpLbl,20, SpringLayout.WEST,spielerStatsPanel);
        layout.putConstraint(SpringLayout.HORIZONTAL_CENTER,spielerExpBar,0,SpringLayout.HORIZONTAL_CENTER,spielerStatsPanel);

        spielerProgressLayout.putConstraint(SpringLayout.WEST,statSpielerAtkLbl,20, SpringLayout.WEST,spielerProgressPanel);
        spielerProgressLayout.putConstraint(SpringLayout.WEST,statSpielerDefLbl,20, SpringLayout.WEST,spielerProgressPanel);
        spielerProgressLayout.putConstraint(SpringLayout.WEST,statSpielerStrLbl, 20, SpringLayout.WEST,spielerProgressPanel);
        spielerProgressLayout.putConstraint(SpringLayout.WEST,statSpielerDexLbl, 20, SpringLayout.WEST,spielerProgressPanel);
        spielerProgressLayout.putConstraint(SpringLayout.WEST,statSpielerKnoLbl, 20, SpringLayout.WEST,spielerProgressPanel);
        spielerProgressLayout.putConstraint(SpringLayout.WEST,statSpielerWisLbl, 20, SpringLayout.WEST,spielerProgressPanel);

        layout.putConstraint(SpringLayout.NORTH,statSpielerLvlLbl,10, SpringLayout.SOUTH,statSpielerName);
        layout.putConstraint(SpringLayout.NORTH,statSpielerHpLbl,10, SpringLayout.SOUTH,statSpielerLvlLbl);
        layout.putConstraint(SpringLayout.NORTH,spielerHealthBar,5, SpringLayout.SOUTH,statSpielerHpLbl);
        layout.putConstraint(SpringLayout.NORTH,statSpielerMpLbl,10, SpringLayout.SOUTH,spielerHealthBar);
        layout.putConstraint(SpringLayout.NORTH,statSpielerExpLbl,10, SpringLayout.SOUTH,statSpielerMpLbl);
        layout.putConstraint(SpringLayout.NORTH,spielerExpBar,5, SpringLayout.SOUTH,statSpielerExpLbl);

        spielerProgressLayout.putConstraint(SpringLayout.NORTH,statSpielerAtkLbl,10, SpringLayout.NORTH,spielerProgressPanel);
        spielerProgressLayout.putConstraint(SpringLayout.NORTH,statSpielerDefLbl,10, SpringLayout.SOUTH,statSpielerAtkLbl);
        spielerProgressLayout.putConstraint(SpringLayout.NORTH,statSpielerStrLbl,10, SpringLayout.SOUTH,statSpielerDefLbl);
        spielerProgressLayout.putConstraint(SpringLayout.NORTH,statSpielerDexLbl,10, SpringLayout.SOUTH,statSpielerStrLbl);
        spielerProgressLayout.putConstraint(SpringLayout.NORTH,statSpielerKnoLbl,10, SpringLayout.SOUTH,statSpielerDexLbl);
        spielerProgressLayout.putConstraint(SpringLayout.NORTH,statSpielerWisLbl,10, SpringLayout.SOUTH,statSpielerKnoLbl);

        //layout rechts
        layout.putConstraint(SpringLayout.EAST,statSpielerHp,-20, SpringLayout.EAST,spielerStatsPanel);
        layout.putConstraint(SpringLayout.EAST,statSpielerMp,-20, SpringLayout.EAST,spielerStatsPanel);
        layout.putConstraint(SpringLayout.EAST,statSpielerExp,-20, SpringLayout.EAST,spielerStatsPanel);
        layout.putConstraint(SpringLayout.EAST,statSpielerLvl,-20, SpringLayout.EAST,spielerStatsPanel);

        spielerProgressLayout.putConstraint(SpringLayout.EAST,statSpielerAtk,-20, SpringLayout.EAST,spielerProgressPanel);
        spielerProgressLayout.putConstraint(SpringLayout.EAST,statSpielerDef,-20, SpringLayout.EAST,spielerProgressPanel);
        spielerProgressLayout.putConstraint(SpringLayout.EAST,statSpielerStr,-20, SpringLayout.EAST,spielerProgressPanel);
        spielerProgressLayout.putConstraint(SpringLayout.EAST,statSpielerDex,-20, SpringLayout.EAST,spielerProgressPanel);
        spielerProgressLayout.putConstraint(SpringLayout.EAST,statSpielerKno,-20, SpringLayout.EAST,spielerProgressPanel);
        spielerProgressLayout.putConstraint(SpringLayout.EAST,statSpielerWis,-20, SpringLayout.EAST,spielerProgressPanel);

        layout.putConstraint(SpringLayout.NORTH,statSpielerLvl,10, SpringLayout.SOUTH,statSpielerName);
        layout.putConstraint(SpringLayout.NORTH,statSpielerHp,10, SpringLayout.SOUTH,statSpielerLvl);
        layout.putConstraint(SpringLayout.NORTH,statSpielerMp,10, SpringLayout.SOUTH,spielerHealthBar);
        layout.putConstraint(SpringLayout.NORTH,statSpielerExp,10, SpringLayout.SOUTH,statSpielerMp);

        spielerProgressLayout.putConstraint(SpringLayout.NORTH,statSpielerAtk,10, SpringLayout.NORTH,spielerProgressPanel);
        spielerProgressLayout.putConstraint(SpringLayout.NORTH,statSpielerDef,10, SpringLayout.SOUTH,statSpielerAtk);
        spielerProgressLayout.putConstraint(SpringLayout.NORTH,statSpielerStr,10, SpringLayout.SOUTH,statSpielerDef);
        spielerProgressLayout.putConstraint(SpringLayout.NORTH,statSpielerDex,10, SpringLayout.SOUTH,statSpielerStr);
        spielerProgressLayout.putConstraint(SpringLayout.NORTH,statSpielerKno,10, SpringLayout.SOUTH,statSpielerDex);
        spielerProgressLayout.putConstraint(SpringLayout.NORTH,statSpielerWis,10, SpringLayout.SOUTH,statSpielerKno);


        spielerStatsPanel.setLayout(layout);
        spielerStatsPanel.add(statSpielerName);
        spielerStatsPanel.add(statSpielerHpLbl);
        spielerStatsPanel.add(statSpielerHp);
        spielerStatsPanel.add(spielerHealthBar);
        spielerStatsPanel.add(statSpielerLvlLbl);
        spielerStatsPanel.add(statSpielerLvl);
        spielerStatsPanel.add(statSpielerMpLbl);
        spielerStatsPanel.add(statSpielerMp);
        spielerStatsPanel.add(statSpielerExpLbl);
        spielerStatsPanel.add(statSpielerExp);
        spielerStatsPanel.add(spielerExpBar);
        spielerProgressPanel.add(statSpielerAtkLbl);
        spielerProgressPanel.add(statSpielerAtk);
        spielerProgressPanel.add(statSpielerDefLbl);
        spielerProgressPanel.add(statSpielerDef);
        spielerProgressPanel.add(statSpielerStrLbl);
        spielerProgressPanel.add(statSpielerStr);
        spielerProgressPanel.add(statSpielerDexLbl);
        spielerProgressPanel.add(statSpielerDex);
        spielerProgressPanel.add(statSpielerKnoLbl);
        spielerProgressPanel.add(statSpielerKno);
        spielerProgressPanel.add(statSpielerWisLbl);
        spielerProgressPanel.add(statSpielerWis);
        //endregion
        //region GegnerPanel
        SpringLayout layoutGegner = new SpringLayout();
        SpringLayout layoutGegnerInfo = new SpringLayout();
        spielGegnerHp = new JLabel("HP: "+gegnerHp+"/"+gegnerMaxHp);
        spielGegnerName = new JLabel(gegnerName);
        spielGegnerLvl = new JLabel("Level: "+gegnerLvl);
        gegnerBildLbl = new JLabel();
        gegnerBildPanel = new JPanel();
        spielPanel.setLayout(layoutGegner);
        spielGegnerName.setFont(barFont);

        gegnerInfoPanel = new JPanel();
        gegnerInfoPanel.setVisible(false);
        gegnerInfoPanel.setPreferredSize(new Dimension(200,70));
        gegnerInfoPanel.setBorder(BorderFactory.createLineBorder(Color.WHITE,1,true));
        gegnerInfoPanel.setLayout(layoutGegnerInfo);

        gegnerHealthBar = new JProgressBar();
        gegnerHealthBar.setValue(gegnerHp);
        gegnerHealthBar.setFont(barFont);
        gegnerHealthBar.setStringPainted(true);
        gegnerHealthBar.setForeground(Color.decode("#C70039"));
        gegnerHealthBar.setPreferredSize(new Dimension(180,15));

        gegnerBildPanel.setPreferredSize(new Dimension(297,297));
        gegnerBildPanel.setLayout(layoutGegnerInfo);
        gegnerBildPanel.setBorder(BorderFactory.createLineBorder(Color.WHITE,1,true));

        layoutGegner.putConstraint(SpringLayout.EAST,gegnerInfoPanel,0,SpringLayout.EAST,spielPanel);
        layoutGegnerInfo.putConstraint(SpringLayout.HORIZONTAL_CENTER,gegnerHealthBar,0,SpringLayout.HORIZONTAL_CENTER,gegnerInfoPanel);
        layoutGegnerInfo.putConstraint(SpringLayout.VERTICAL_CENTER,gegnerHealthBar,20,SpringLayout.VERTICAL_CENTER,gegnerInfoPanel);

        layoutGegnerInfo.putConstraint(SpringLayout.HORIZONTAL_CENTER, spielGegnerName,0,SpringLayout.HORIZONTAL_CENTER,gegnerInfoPanel);
        layoutGegnerInfo.putConstraint(SpringLayout.VERTICAL_CENTER,spielGegnerName,-20,SpringLayout.VERTICAL_CENTER,gegnerInfoPanel);

        layoutGegnerInfo.putConstraint(SpringLayout.WEST,spielGegnerHp,10,SpringLayout.WEST,gegnerInfoPanel);
        layoutGegnerInfo.putConstraint(SpringLayout.VERTICAL_CENTER, spielGegnerHp,0,SpringLayout.VERTICAL_CENTER,gegnerInfoPanel);

        layoutGegnerInfo.putConstraint(SpringLayout.EAST, spielGegnerLvl, -10,SpringLayout.EAST, gegnerInfoPanel);
        layoutGegnerInfo.putConstraint(SpringLayout.VERTICAL_CENTER, spielGegnerLvl,0,SpringLayout.VERTICAL_CENTER,gegnerInfoPanel);

        layoutGegnerInfo.putConstraint(SpringLayout.VERTICAL_CENTER, gegnerBildLbl, 0, SpringLayout.VERTICAL_CENTER,gegnerBildPanel);
        layoutGegnerInfo.putConstraint(SpringLayout.HORIZONTAL_CENTER, gegnerBildLbl, 0, SpringLayout.HORIZONTAL_CENTER,gegnerBildPanel);


        gegnerInfoPanel.add(spielGegnerName);
        gegnerInfoPanel.add(spielGegnerHp);
        gegnerInfoPanel.add(spielGegnerLvl);
        gegnerInfoPanel.add(gegnerHealthBar);
        gegnerBildPanel.add(gegnerBildLbl);
        spielPanel.add(gegnerInfoPanel);
        spielPanel.add(gegnerBildPanel);
        //endregion
        //region navigation
        naviPanel = new JPanel();
        naviPanel.setPreferredSize(new Dimension(200,227));
        naviPanel.setBorder(BorderFactory.createLineBorder(Color.WHITE,1,true));
        SpringLayout naviLayout = new SpringLayout();
        naviPanel.setLayout(naviLayout);

        layoutGegner.putConstraint(SpringLayout.EAST,naviPanel,0,SpringLayout.EAST,spielPanel);
        layoutGegner.putConstraint(SpringLayout.SOUTH,naviPanel,0,SpringLayout.SOUTH,spielPanel);
        ImageIcon linksBild = new ImageIcon("res/Icons/Skull.png");

        naviLinksLbl = new JLabel(linksBild);
        naviRechtsLbl = new JLabel("Rechts");
        naviLinksLinksLbl = new JLabel("LinksLinks");
        naviLinksRechtsLbl = new JLabel("LinksRechts");
        naviRechtsLinksLbl = new JLabel("RechtsLinks");
        naviRechtsRechtsLbl = new JLabel("RechtsRechts");

        naviLayout.putConstraint(SpringLayout.HORIZONTAL_CENTER,naviLinksLbl,-50,SpringLayout.HORIZONTAL_CENTER,naviPanel);
        naviLayout.putConstraint(SpringLayout.HORIZONTAL_CENTER,naviRechtsLbl,50,SpringLayout.HORIZONTAL_CENTER,naviPanel);
        naviLayout.putConstraint(SpringLayout.VERTICAL_CENTER,naviLinksLbl,50,SpringLayout.VERTICAL_CENTER,naviPanel);
        naviLayout.putConstraint(SpringLayout.VERTICAL_CENTER,naviRechtsLbl,50,SpringLayout.VERTICAL_CENTER,naviPanel);

        //links
        naviLayout.putConstraint(SpringLayout.VERTICAL_CENTER, naviLinksLinksLbl,-30,SpringLayout.VERTICAL_CENTER,naviLinksLbl);
        naviLayout.putConstraint(SpringLayout.VERTICAL_CENTER, naviLinksRechtsLbl,-30,SpringLayout.VERTICAL_CENTER,naviLinksLbl);
        naviLayout.putConstraint(SpringLayout.HORIZONTAL_CENTER, naviLinksLinksLbl,-30,SpringLayout.HORIZONTAL_CENTER,naviLinksLbl);
        naviLayout.putConstraint(SpringLayout.HORIZONTAL_CENTER, naviLinksRechtsLbl,30,SpringLayout.HORIZONTAL_CENTER,naviLinksLbl);


        //rechts
        naviLayout.putConstraint(SpringLayout.VERTICAL_CENTER, naviRechtsLinksLbl,-30,SpringLayout.VERTICAL_CENTER,naviRechtsLbl);
        naviLayout.putConstraint(SpringLayout.VERTICAL_CENTER, naviRechtsRechtsLbl,-30,SpringLayout.VERTICAL_CENTER,naviRechtsLbl);
        naviLayout.putConstraint(SpringLayout.HORIZONTAL_CENTER, naviRechtsLinksLbl,-30,SpringLayout.HORIZONTAL_CENTER,naviRechtsLbl);
        naviLayout.putConstraint(SpringLayout.HORIZONTAL_CENTER, naviRechtsRechtsLbl,30,SpringLayout.HORIZONTAL_CENTER,naviRechtsLbl);



        naviPanel.add(naviLinksLbl);
        naviPanel.add(naviRechtsLbl);
        naviPanel.add(naviLinksLinksLbl);
        naviPanel.add(naviLinksRechtsLbl);
        naviPanel.add(naviRechtsLinksLbl);
        naviPanel.add(naviRechtsRechtsLbl);
        spielPanel.add(naviPanel);
        //endregion

        logBtn.addActionListener(e -> logFrame.setVisible(true));


        auswahlPanelLinks.setVisible(false);
        vorschauPanel.setVisible(false);
        auswahlPanelRechts.setVisible(false);
        auswahlBtn.setVisible(false);
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
        //region layout
        auswahlPanelLinks = new JPanel();
        auswahlPanelLinks.setBounds(20,20,225,515);
        auswahlPanelLinks.setBorder(BorderFactory.createLineBorder(Color.WHITE,2,true));
        auswahlPanelLinks.setLayout(new GridLayout(10,2));

        auswahlPanelRechts = new JPanel();
        auswahlPanelRechts.setBounds(540,20,225,515);
        auswahlPanelRechts.setBorder(BorderFactory.createLineBorder(Color.WHITE,2,true));
        auswahlPanelRechts.setLayout(new GridLayout(10,2));
        //endregion
        //region Vorschau
        SpringLayout layout = new SpringLayout();
        SpringLayout layoutStats = new SpringLayout();
        vorschauPanel = new JPanel();
        vorschauPanel.setBounds(250,28,285,500);
        vorschauPanel.setBorder(BorderFactory.createLineBorder(Color.WHITE,2,true));
        vorschauPanel.setLayout(layout);

        vorschauStatsPanel = new JPanel();
        vorschauStatsPanel.setPreferredSize(new Dimension(281,150));
        vorschauStatsPanel.setBorder(BorderFactory.createLineBorder(Color.WHITE,1, true));
        layout.putConstraint(SpringLayout.NORTH, vorschauStatsPanel, -148, SpringLayout.SOUTH, vorschauPanel);
        vorschauStatsPanel.setLayout(layoutStats);

        auswahlBtn = new JButton("Auswahl");
        auswahlBtn.setFont(normalFont);
        auswahlBtn.setBounds(318,500,150,50);
        auswahlBtn.setBorder(BorderFactory.createLineBorder(Color.WHITE,2,true));

        vorschauStatsName = new JLabel();
        vorschauStatsName.setFont(normalFont);

        vorschauLbl = new JLabel();
        layout.putConstraint(SpringLayout.HORIZONTAL_CENTER,vorschauLbl,0,SpringLayout.HORIZONTAL_CENTER,vorschauPanel);
//        layout.putConstraint(SpringLayout.VERTICAL_CENTER,vorschauLbl,0,SpringLayout.VERTICAL_CENTER,vorschauPanel);
        vorschauStatsLblLinks = new JLabel();
        vorschauFont = new Font("Segoe UI",Font.BOLD,14);
        vorschauStatsLblLinks.setFont(vorschauFont);

        vorschauStatsLblRechts = new JLabel();
        vorschauStatsLblRechts.setFont(vorschauFont);
        layoutStats.putConstraint(SpringLayout.WEST,vorschauStatsLblLinks,50,SpringLayout.WEST,vorschauStatsPanel);
        layoutStats.putConstraint(SpringLayout.NORTH,vorschauStatsLblLinks,30,SpringLayout.NORTH,vorschauStatsPanel);
        layoutStats.putConstraint(SpringLayout.WEST,vorschauStatsLblRechts,170,SpringLayout.WEST,vorschauStatsPanel);
        layoutStats.putConstraint(SpringLayout.NORTH,vorschauStatsLblRechts,30,SpringLayout.NORTH,vorschauStatsPanel);
        layoutStats.putConstraint(SpringLayout.HORIZONTAL_CENTER,vorschauStatsName,0,SpringLayout.HORIZONTAL_CENTER,vorschauStatsPanel);


        auswahlBtn.addActionListener(e -> {
            spielFenster();
        });
        //endregion
        //region buttons
        //links
        auswahlKriegerBtn = new JButton("Krieger");
        auswahlJaegerBtn = new JButton("Jäger");
        auswahlMagierBtn = new JButton("Magier");
        auswahlPriesterBtn = new JButton("Priester");

        auswahlKriegerBtn.setFont(barFont);
        auswahlJaegerBtn.setFont(barFont);
        auswahlMagierBtn.setFont(barFont);
        auswahlPriesterBtn.setFont(barFont);

        auswahlKriegerBtn.addActionListener(e -> {
            spielerName = Spieler.krieger.name;
            spielerMaxHp = Spieler.krieger.maxHp;
            spielerHp = spielerMaxHp;
            spielerMaxMp = Spieler.krieger.maxMp;
            spielerMp = spielerMaxMp;
            spielerAtk = Spieler.krieger.atk+Spieler.krieger.str;
            spielerDef = Spieler.krieger.def;
            spielerExp = Spieler.krieger.exp;
            spielerLvl = Spieler.krieger.lvl;
            spielerStr = Spieler.krieger.str;
            spielerDex = Spieler.krieger.dex;
            spielerKno = Spieler.krieger.kno;
            spielerWis = Spieler.krieger.wis;
            ImageIcon vorschauBild = new ImageIcon("res/Spieler/Krieger.png");
            vorschauStatsName.setText(spielerName);
            vorschauStatsLblLinks.setText("<html>HP: "+spielerHp+"/"+spielerMaxHp+"<br>MP: "+
                    spielerMp+"/"+spielerMaxMp+"<br>Atk: "+spielerAtk+"<br>Def: "+spielerDef+"</html>");
            vorschauStatsLblRechts.setText("<html><font color='#ff0000'>Str: </font>"+spielerStr+
                    "<font color='#3cb371'><br>Dex: </font>"+spielerDex+"<br><font color='#94d0ff'>Int: </font>"+
                    spielerKno+"<br><font color='#ffe400'>Wis: </font>"+spielerWis);
            vorschauLbl.setIcon(vorschauBild);
            con.repaint();
        });
        auswahlJaegerBtn.addActionListener(e -> {
            spielerName = Spieler.jaeger.name;
            spielerMaxHp = Spieler.jaeger.maxHp;
            spielerHp = spielerMaxHp;
            spielerMaxMp = Spieler.jaeger.maxMp;
            spielerMp = spielerMaxMp;
            spielerAtk = Spieler.jaeger.atk+Spieler.jaeger.dex;
            spielerDef = Spieler.jaeger.def;
            spielerExp = Spieler.jaeger.exp;
            spielerLvl = Spieler.jaeger.lvl;
            spielerStr = Spieler.jaeger.str;
            spielerDex = Spieler.jaeger.dex;
            spielerKno = Spieler.jaeger.kno;
            spielerWis = Spieler.jaeger.wis;
            ImageIcon vorschauBild = new ImageIcon("res/Spieler/Jaeger.png");
            vorschauLbl.setIcon(vorschauBild);
            vorschauStatsName.setText(spielerName);
            vorschauStatsLblLinks.setText("<html>HP: "+spielerHp+"/"+spielerMaxHp+"<br>MP: "+
                    spielerMp+"/"+spielerMaxMp+"<br>Atk: "+spielerAtk+"<br>Def: "+spielerDef+"</html>");
            vorschauStatsLblRechts.setText("<html><font color='#ff0000'>Str: </font>"+spielerStr+
                    "<font color='#3cb371'><br>Dex: </font>"+spielerDex+"<br><font color='#94d0ff'>Int: </font>"+
                    spielerKno+"<br><font color='#ffe400'>Wis: </font>"+spielerWis);
            con.repaint();
        });
        auswahlMagierBtn.addActionListener(e -> {
            spielerName = Spieler.magier.name;
            spielerMaxHp = Spieler.magier.maxHp;
            spielerHp = spielerMaxHp;
            spielerMaxMp = Spieler.magier.maxMp;
            spielerMp = spielerMaxMp;
            spielerAtk = Spieler.magier.atk+Spieler.magier.kno;
            spielerDef = Spieler.magier.def;
            spielerExp = Spieler.magier.exp;
            spielerLvl = Spieler.magier.lvl;
            spielerStr = Spieler.magier.str;
            spielerDex = Spieler.magier.dex;
            spielerKno = Spieler.magier.kno;
            spielerWis = Spieler.magier.wis;
            ImageIcon vorschauBild = new ImageIcon("res/Spieler/Magier.png");
            vorschauLbl.setIcon(vorschauBild);
            vorschauStatsName.setText(spielerName);
            vorschauStatsLblLinks.setText("<html>HP: "+spielerHp+"/"+spielerMaxHp+"<br>MP: "+
                    spielerMp+"/"+spielerMaxMp+"<br>Atk: "+spielerAtk+"<br>Def: "+spielerDef+"</html>");
            vorschauStatsLblRechts.setText("<html><font color='#ff0000'>Str: </font>"+spielerStr+
                    "<font color='#3cb371'><br>Dex: </font>"+spielerDex+"<br><font color='#94d0ff'>Int: </font>"+
                    spielerKno+"<br><font color='#ffe400'>Wis: </font>"+spielerWis);
            con.repaint();
        });
        auswahlPriesterBtn.addActionListener(e -> {
            spielerName = Spieler.priester.name;
            spielerMaxHp = Spieler.priester.maxHp;
            spielerHp = spielerMaxHp;
            spielerMaxMp = Spieler.priester.maxMp;
            spielerMp = spielerMaxMp;
            spielerAtk = Spieler.priester.atk+Spieler.priester.wis;
            spielerDef = Spieler.priester.def;
            spielerExp = Spieler.priester.exp;
            spielerLvl = Spieler.priester.lvl;
            spielerStr = Spieler.priester.str;
            spielerDex = Spieler.priester.dex;
            spielerKno = Spieler.priester.kno;
            spielerWis = Spieler.priester.wis;
            ImageIcon vorschauBild = new ImageIcon("res/Spieler/Priester.png");
            vorschauLbl.setIcon(vorschauBild);
            vorschauStatsName.setText(spielerName);
            vorschauStatsLblLinks.setText("<html>HP: "+spielerHp+"/"+spielerMaxHp+"<br>MP: "+
                    spielerMp+"/"+spielerMaxMp+"<br>Atk: "+spielerAtk+"<br>Def: "+spielerDef+"</html>");
            vorschauStatsLblRechts.setText("<html><font color='#ff0000'>Str: </font>"+spielerStr+
                    "<font color='#3cb371'><br>Dex: </font>"+spielerDex+"<br><font color='#94d0ff'>Int: </font>"+
                    spielerKno+"<br><font color='#ffe400'>Wis: </font>"+spielerWis);
            con.repaint();
        });

        auswahlPanelLinks.add(auswahlKriegerBtn);
        auswahlPanelLinks.add(auswahlJaegerBtn);
        auswahlPanelLinks.add(auswahlMagierBtn);
        auswahlPanelLinks.add(auswahlPriesterBtn);

        //rechts
        auswahlPaladinBtn = new JButton("Paladin");
        auswahlNinjaBtn = new JButton("Ninja");

        auswahlPaladinBtn.setFont(barFont);
        auswahlNinjaBtn.setFont(barFont);

        auswahlPaladinBtn.addActionListener(e -> {
            spielerName = Spieler.paladin.name;
            spielerMaxHp = Spieler.paladin.maxHp;
            spielerHp = spielerMaxHp;
            spielerMaxMp = Spieler.paladin.maxMp;
            spielerMp = spielerMaxMp;
            spielerAtk = Spieler.paladin.atk+Spieler.paladin.str;
            spielerDef = Spieler.paladin.def;
            spielerExp = Spieler.paladin.exp;
            spielerLvl = Spieler.paladin.lvl;
            spielerStr = Spieler.paladin.str;
            spielerDex = Spieler.paladin.dex;
            spielerKno = Spieler.paladin.kno;
            spielerWis = Spieler.paladin.wis;
            ImageIcon vorschauBild = new ImageIcon("res/Spieler/Paladin.png");
            vorschauLbl.setIcon(vorschauBild);
            vorschauStatsName.setText(spielerName);
            vorschauStatsLblLinks.setText("<html>HP: "+spielerHp+"/"+spielerMaxHp+"<br>MP: "+
                    spielerMp+"/"+spielerMaxMp+"<br>Atk: "+spielerAtk+"<br>Def: "+spielerDef+"</html>");
            vorschauStatsLblRechts.setText("<html><font color='#ff0000'>Str: </font>"+spielerStr+
                    "<font color='#3cb371'><br>Dex: </font>"+spielerDex+"<br><font color='#94d0ff'>Int: </font>"+
                    spielerKno+"<br><font color='#ffe400'>Wis: </font>"+spielerWis);
            con.repaint();
        });
        auswahlNinjaBtn.addActionListener(e -> {
            spielerName = Spieler.ninja.name;
            spielerMaxHp = Spieler.ninja.maxHp;
            spielerHp = spielerMaxHp;
            spielerMaxMp = Spieler.ninja.maxMp;
            spielerMp = spielerMaxMp;
            spielerAtk = Spieler.ninja.atk+Spieler.ninja.str;
            spielerDef = Spieler.ninja.def;
            spielerExp = Spieler.ninja.exp;
            spielerLvl = Spieler.ninja.lvl;
            spielerStr = Spieler.ninja.str;
            spielerDex = Spieler.ninja.dex;
            spielerKno = Spieler.ninja.kno;
            spielerWis = Spieler.ninja.wis;
            ImageIcon vorschauBild = new ImageIcon("res/Spieler/Ninja.png");
            vorschauLbl.setIcon(vorschauBild);
            vorschauStatsName.setText(spielerName);
            vorschauStatsLblLinks.setText("<html>HP: "+spielerHp+"/"+spielerMaxHp+"<br>MP: "+
                    spielerMp+"/"+spielerMaxMp+"<br>Atk: "+spielerAtk+"<br>Def: "+spielerDef+"</html>");
            vorschauStatsLblRechts.setText("<html><font color='#ff0000'>Str: </font>"+spielerStr+
                    "<font color='#3cb371'><br>Dex: </font>"+spielerDex+"<br><font color='#94d0ff'>Int: </font>"+
                    spielerKno+"<br><font color='#ffe400'>Wis: </font>"+spielerWis);
            con.repaint();
        });

        auswahlPanelRechts.add(auswahlPaladinBtn);
        auswahlPanelRechts.add(auswahlNinjaBtn);
        //endregion

        titelPanel.setVisible(false);
        titelStartBtnPanel.setVisible(false);
        vorschauStatsPanel.add(vorschauStatsName);
        vorschauStatsPanel.add(vorschauStatsLblLinks);
        vorschauStatsPanel.add(vorschauStatsLblRechts);
        vorschauPanel.add(vorschauStatsPanel);
        vorschauPanel.add(vorschauLbl);
        con.add(auswahlBtn);
        con.add(vorschauPanel);
        con.add(auswahlPanelLinks);
        con.add(auswahlPanelRechts);
        con.setVisible(true);
        con.revalidate();
        con.repaint();
    }
    public static class TitleScreenHandler implements ActionListener{
        public void actionPerformed(ActionEvent e){
            gegnerInitialisieren();
            charakterAuswahl();
            adminFenster();
        }
    }
}
