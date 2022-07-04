import Charaktere.*;
import Skills.*;
import com.formdev.flatlaf.FlatDarculaLaf;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import static java.lang.Math.round;

public class Main {
    private static JFrame adminFrame, mainFrame, logFrame;
    private static JPanel titelPanel, titelStartBtnPanel, spielPanel, skillBtnPanel,
            textAreaPanel, spielerStatsPanel, spielerProgressPanel, optionenPanel,
            logPanel, vorschauStatsPanel,
            logBtnPanel, adminPanel, auswahlPanelLinks, vorschauPanel,
            auswahlPanelRechts, gegnerInfoPanel, gameOverBtnPanel,
            gegnerBildPanel, naviPanel;
    private static JTextArea logTextArea, mainTextArea;
    private static JLabel titelLbl, statSpielerName, statSpielerHpLbl, statSpielerHp,
            statspielerSpLbl, statspielerSp, statSpielerExpLbl, statSpielerExp,
            statSpielerAtkLbl, statSpielerAtk, statSpielerDefLbl, statSpielerDef,
            spielGegnerHp,
            spielGegnerLvl, spielGegnerName, statSpielerLvl, statSpielerLvlLbl, vorschauLbl,
            vorschauStatsLblRechts, vorschauStatsLblLinks, vorschauStatsName, gegnerBildLbl,
            naviLinksLinksLbl, naviLinksRechtsLbl, naviRechtsLinksLbl,
            naviRechtsRechtsLbl, pfeilHochLinks, pfeilHochRechts, naviLbl, naviTitelLbl,
            naviEbeneLbl, skillpointsLbl,
            statSpielerStr, statSpielerDex, statSpielerKno, statSpielerWis;
    private static JButton titelStartBtn, logBtn,  adminBtn1, adminBtn2, adminBtn3, adminBtn4, adminBtn5,
            adminBtn6, skillBtn1, skillBtn2, skillBtn3, skillBtn4, skillBtn5,
            adminBtn7, adminBtn8, adminBtn9, auswahlKriegerBtn, auswahlMagierBtn,
            auswahlJaegerBtn,
            auswahlPriesterBtn, auswahlBtn, adminBtn10, auswahlPaladinBtn, auswahlNinjaBtn,
            adminBtn11, adminBtn12, adminBtn13, strUpBtn, dexUpBtn, knoUpBtn, wisUpBtn,
            naviLinksBtn, naviRechtsBtn;
    private static Container con, conLog, conAdmin;
    private static JScrollPane logTextAreaScroll, mainTextAreaScroll;
    private static JProgressBar spielerHpBar, spielerSpBar, spielerExpBar, gegnerHealthBar;
    static Font titelFont, normalFont, startBtnFont, statFont, textFont, mainTextFont, vorschauFont, barFont;
    static String gegnerName, spielerName, skill1Name, skill1Mod, gegnerMod, skill2Name, skill3Name,skill4Name,
                    skill5Name, skill2Mod, skill3Mod, skill4Mod, skill5Mod;
    static int gegnerHp, gegnerMaxHp, gegnerSp, gegnermaxSp, gegnerAtk, gegnerDef, gegnerLvl,
            spielerHp, spielerMaxHp, spielerSp, spielerMaxSp, spielerAtk, spielerDef, spielerLvl,
            spielerStr, spielerDex, spielerKno, spielerWis, spielerHpMod, spielerSpMod,
            gegnerStr, gegnerDex, gegnerKno, gegnerWis, skill1Genauigkeit, skill1Kraft, skill2Kraft,
            skill3Kraft,skill4Kraft,skill5Kraft, skill2Genauigkeit, skill3Genauigkeit, skill4Genauigkeit, skill5Genauigkeit;
    static int skillpoints = 0;
    static int raumCounter = 0;
    static int gegnerExp, spielerExp;
    static JPanel gameOverPanel = new JPanel();
    static SpringLayout layout = new SpringLayout();
    static Random rnd = new Random();
    static int trefferChance;
    static int angriff, schaden, range1, range2;
    static String angriffMod, schadenMod;
    static ImageIcon skill1Bild, skill2Bild, skill3Bild, skill4Bild, skill5Bild;

    static Skills[] skillListe = new Skills[4];
    static Gegner[] gegnerListeT1 = new Gegner[15];
    static Karte[] kartenListe = new Karte[7];

    TitleScreenHandler tsHandler = new TitleScreenHandler();

    static Dimension btnDimension = new Dimension(50,50);
    public static void btnInitialisieren(){
        skillBtn1 = new JButton();
        skillBtn2 = new JButton();
        skillBtn3 = new JButton();
        skillBtn4 = new JButton();
        skillBtn5 = new JButton();

        skillBtn1.setPreferredSize(btnDimension);
        skillBtn2.setPreferredSize(btnDimension);
        skillBtn3.setPreferredSize(btnDimension);
        skillBtn4.setPreferredSize(btnDimension);
        skillBtn5.setPreferredSize(btnDimension);
    }
    public static void main(String[] args) {new Main();}
    public Main() {
        FlatDarculaLaf.setup();
        mainFrame = new JFrame("Grinder");
        mainFrame.setPreferredSize(new Dimension(800, 600));
        titelFont = new Font("Times New Roman", Font.BOLD, 90);
        startBtnFont = new Font("Segoe UI", Font.BOLD, 30);
        normalFont = new Font("Segoe UI", Font.BOLD, 22);
        textFont = new Font("Segoe UI", Font.BOLD, 12);
        mainTextFont = new Font("Segoe UI", Font.BOLD, 15);
        barFont = new Font("Segoe UI", Font.BOLD, 15);

        titelPanel = new JPanel();
        titelPanel.setBounds(100, 50, 600, 250);
        titelPanel.setBorder(BorderFactory.createLineBorder(Color.WHITE, 2, true));
        titelLbl = new JLabel("GGGGGGG");
        titelLbl.setForeground(Color.WHITE);
        titelLbl.setFont(titelFont);
        titelPanel.add(titelLbl);

        titelStartBtnPanel = new JPanel();
        titelStartBtnPanel.setBounds(300, 400, 200, 100);
        titelStartBtnPanel.setBorder(BorderFactory.createLineBorder(Color.WHITE, 2, true));

        titelStartBtn = new JButton("START");
        titelStartBtn.setFont(startBtnFont);
        titelStartBtn.setForeground(Color.WHITE);

        SpringLayout layout = new SpringLayout();
        layout.putConstraint(SpringLayout.HORIZONTAL_CENTER, titelStartBtn, 0, SpringLayout.HORIZONTAL_CENTER, titelStartBtnPanel);
        layout.putConstraint(SpringLayout.VERTICAL_CENTER, titelStartBtn, 0, SpringLayout.VERTICAL_CENTER, titelStartBtnPanel);
        titelStartBtnPanel.add(titelStartBtn);
        titelStartBtnPanel.setLayout(layout);

        con = mainFrame.getContentPane();
        con.setLayout(null);
        con.add(titelStartBtnPanel);
        con.add(titelPanel);
        mainFrame.pack();
        mainFrame.setLayout(null);
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.setVisible(true);
        mainFrame.setResizable(false);
        mainFrame.setLocationRelativeTo(null);

        //region Textlogfenster
        logFrame = new JFrame("Textlog");
        logFrame.setPreferredSize(new Dimension(500, 400));
        logFrame.setResizable(false);

        logPanel = new JPanel();
        logTextArea = new JTextArea();
        logTextArea.setLineWrap(true);
        logTextArea.setEditable(false);
        logTextArea.setFont(mainTextFont);

        logTextAreaScroll = new JScrollPane(logTextArea);
        logTextAreaScroll.setPreferredSize(new Dimension(450, 285));
        logTextAreaScroll.setBorder(BorderFactory.createEmptyBorder());
        logTextAreaScroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_NEVER);
        logTextAreaScroll.setBorder(BorderFactory.createLineBorder(Color.WHITE, 2, true));
        logPanel.add(logTextAreaScroll);

        logBtnPanel = new JPanel();
        logBtnPanel.setBounds(17, 300, 450, 50);
        logBtnPanel.setBorder(BorderFactory.createLineBorder(Color.WHITE, 2, true));

        conLog = logFrame.getContentPane();
        conLog.setBackground(Color.GREEN);
        conLog.revalidate();
        conLog.add(logBtnPanel);
        conLog.add(logPanel);
        logFrame.pack();
        //endregion

        titelStartBtn.addActionListener(tsHandler);
    }
    public static void mapInitialisieren() {
        kartenListe[0] = Karte.kampf;
        kartenListe[1] = Karte.kampf;
        kartenListe[2] = Karte.kampf;
        kartenListe[3] = Karte.kampf;
        kartenListe[4] = Karte.lager;
        kartenListe[5] = Karte.lager;
        kartenListe[6] = Karte.event;
    }
    public static void gegnerInitialisieren() {
        gegnerListeT1[0] = Gegner.puppe;
        gegnerListeT1[1] = Gegner.sahagin;
        gegnerListeT1[2] = Gegner.skelettkrieger;
        gegnerListeT1[3] = Gegner.werwolf;
        gegnerListeT1[4] = Gegner.fledermaus;
        gegnerListeT1[5] = Gegner.hornisse;
        gegnerListeT1[6] = Gegner.ratte;
        gegnerListeT1[7] = Gegner.schlange;
        gegnerListeT1[8] = Gegner.skorpion;
        gegnerListeT1[9] = Gegner.pflanze;
        gegnerListeT1[10] = Gegner.imp;
        gegnerListeT1[11] = Gegner.schleim;
        gegnerListeT1[12] = Gegner.spinne;
        gegnerListeT1[13] = Gegner.qualle;
        gegnerListeT1[14] = Gegner.zombie;
    }
    public static void randomEncounterTier1() {
        naviLinksBtn.setEnabled(false);
        naviRechtsBtn.setEnabled(false);
        Random rnd = new Random();
        int i = rnd.nextInt(0, 15);
        gegnerName = gegnerListeT1[i].name;
        updateGegnerHp();
        gegnerListeT1[i].lvl = 1;
        gegnerLvl = gegnerListeT1[i].lvl;
        gegnerName = gegnerListeT1[i].name;
        gegnerMaxHp = gegnerListeT1[i].maxHp * gegnerListeT1[i].lvl;
        gegnerHp = gegnerMaxHp;
        gegnermaxSp = gegnerListeT1[i].maxSp * gegnerListeT1[i].lvl;
        gegnerSp = gegnermaxSp;
        gegnerAtk = gegnerListeT1[i].atk;
        gegnerDef = gegnerListeT1[i].def;
        gegnerExp = gegnerListeT1[i].exp;
        gegnerStr = gegnerListeT1[i].str;
        gegnerDex = gegnerListeT1[i].dex;
        gegnerKno = gegnerListeT1[i].kno;
        gegnerWis = gegnerListeT1[i].wis;
        gegnerMod = gegnerListeT1[i].mod;
        gegnerHealthBar.setMaximum(gegnerMaxHp);
        updateGegnerHp();
        gegnerInfoPanel.setVisible(true);
        ImageIcon gegnerBild = new ImageIcon("res/Gegner/" + gegnerListeT1[i].name + ".png");
        gegnerBildLbl.setVisible(true);
        gegnerBildLbl.setIcon(gegnerBild);
    }
    public static void adminFenster() {
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
        adminBtn13 = new JButton("Game Over");

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
        adminPanel.add(adminBtn13);
        //endregion

        adminBtn1.addActionListener(e -> logTextArea.append(""));
        adminBtn2.addActionListener(e -> {
            mainTextArea.append("<br>aaaaaaaaaaaaaaaaaa<br>bbbbbbbbbbbbbb<br>>cccccccccccc<br>ddddddddddddd<br>eeeeeeeeeeee");
            logTextArea.append("aaaaaaaaaaaaaaaaaa\nbbbbbbbbbbbbbb\ncccccccccccc\nddddddddddddd\neeeeeeeeeeee");
        });
        adminBtn3.addActionListener(e -> {
            spielerExp = spielerExp + 3;
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
            gegnerMaxHp = Gegner.schneemann.maxHp * Gegner.schneemann.lvl;
            gegnerHp = gegnerMaxHp;
            gegnermaxSp = Gegner.schneemann.maxSp * Gegner.schneemann.lvl;
            gegnerSp = gegnermaxSp;
            gegnerAtk = Gegner.schneemann.atk;
            gegnerDef = Gegner.schneemann.def;
            gegnerExp = Gegner.schneemann.exp;
            gegnerHealthBar.setMaximum(gegnerMaxHp);
            updateGegnerHp();
            gegnerInfoPanel.setVisible(true);
            ImageIcon gegnerBild = new ImageIcon("res/Gegner/Schneemann.png");
            gegnerBildLbl.setVisible(true);
            gegnerBildLbl.setIcon(gegnerBild);
        });
        adminBtn7.addActionListener(e -> {
            spielerAngriff();
            if (gegnerHp > 0)wait(700);
        });
        adminBtn8.addActionListener(e -> {
            Gegner.fledermaus.lvl = 1;
            gegnerLvl = Gegner.fledermaus.lvl;
            gegnerName = Gegner.fledermaus.name;
            gegnerMaxHp = Gegner.fledermaus.maxHp * Gegner.fledermaus.lvl;
            gegnerHp = gegnerMaxHp;
            gegnermaxSp = Gegner.fledermaus.maxSp * Gegner.fledermaus.lvl;
            gegnerSp = gegnermaxSp;
            gegnerAtk = Gegner.fledermaus.atk;
            gegnerDef = Gegner.fledermaus.def;
            gegnerExp = Gegner.fledermaus.exp;
            gegnerHealthBar.setMaximum(gegnerMaxHp);
            updateGegnerHp();
            gegnerInfoPanel.setVisible(true);
            ImageIcon gegnerBild = new ImageIcon("res/Gegner/Fledermaus.png");
            gegnerBildLbl.setVisible(true);
            gegnerBildLbl.setIcon(gegnerBild);
        });
        adminBtn9.addActionListener(e -> {
            Gegner.oger.lvl = 1;
            gegnerLvl = Gegner.oger.lvl;
            gegnerName = Gegner.oger.name;
            gegnerMaxHp = Gegner.oger.maxHp * Gegner.oger.lvl;
            gegnerHp = gegnerMaxHp;
            gegnermaxSp = Gegner.oger.maxSp * Gegner.oger.lvl;
            gegnerSp = gegnermaxSp;
            gegnerAtk = Gegner.oger.atk;
            gegnerDef = Gegner.oger.def;
            gegnerExp = Gegner.oger.exp;
            gegnerHealthBar.setMaximum(gegnerMaxHp);
            updateGegnerHp();
            gegnerInfoPanel.setVisible(true);
            ImageIcon gegnerBild = new ImageIcon("res/Gegner/Oger.png");
            gegnerBildLbl.setVisible(true);
            gegnerBildLbl.setIcon(gegnerBild);
        });
        adminBtn10.addActionListener(e -> {
            Gegner.geist.lvl = 1;
            gegnerLvl = Gegner.geist.lvl;
            gegnerName = Gegner.geist.name;
            gegnerMaxHp = Gegner.geist.maxHp * Gegner.geist.lvl;
            gegnerHp = gegnerMaxHp;
            gegnermaxSp = Gegner.geist.maxSp * Gegner.geist.lvl;
            gegnerSp = gegnermaxSp;
            gegnerAtk = Gegner.geist.atk;
            gegnerDef = Gegner.geist.def;
            gegnerExp = Gegner.geist.exp;
            gegnerHealthBar.setMaximum(gegnerMaxHp);
            updateGegnerHp();
            gegnerInfoPanel.setVisible(true);
            ImageIcon gegnerBild = new ImageIcon("res/Gegner/Geist.png");
            gegnerBildLbl.setVisible(true);
            gegnerBildLbl.setIcon(gegnerBild);
        });
        adminBtn12.addActionListener(e -> {
            randomEncounterTier1();
        });
        adminBtn13.addActionListener(e -> {
            gameOverScreen();
        });

        conAdmin = adminFrame.getContentPane();
        conAdmin.add(adminPanel);
        adminFrame.setPreferredSize(new Dimension(400, 300));
        adminFrame.setResizable(false);
        adminFrame.pack();
        adminFrame.setVisible(true);
    }
    public static void updateSpielerStats() {
        checkExp();

        statSpielerName.setText(spielerName);
        statSpielerExp.setText("" + spielerExp);
        statSpielerLvl.setText("" + spielerLvl);
        statSpielerHp.setText(spielerHp + "/" + spielerMaxHp);
        statspielerSp.setText(spielerSp + "/" + spielerMaxSp);
        statSpielerAtk.setText("" + spielerAtk);
        statSpielerDef.setText("" + spielerDef);
        statSpielerStr.setText("" + spielerStr);
        statSpielerDex.setText("" + spielerDex);
        statSpielerKno.setText("" + spielerKno);
        statSpielerWis.setText("" + spielerWis);
        spielerHpBar.setValue(spielerHp);;
        spielerSpBar.setValue(spielerSp);
        spielerExpBar.setValue(spielerExp);
        spielerExpBar.setMaximum((int) expNeed());
    }
    public static void skillpoints() {
        skillpoints += 2;
        strUpBtn.setVisible(true);
        dexUpBtn.setVisible(true);
        knoUpBtn.setVisible(true);
        wisUpBtn.setVisible(true);
        skillpointsLbl.setVisible(true);
    }
    public static void wait(int ms) {
        Timer timer = new Timer(ms, e -> {
            checkLeben();
            if (gegnerHp > 0){
                gegnerAngriff();
            }
        });
        timer.setRepeats(false);
        timer.start();
    }
    static void checkExp() {
        if (spielerExp >= (expNeed())) {
            spielerExpBar.setMinimum((int)Math.round(10*(Math.pow(spielerLvl,1.5))));
            spielerLvl++;
            skillpoints();
            skillpointsLbl.setText("("+skillpoints+") Skillpunkte verfügbar");

            statSpielerLvl.setText("" + spielerLvl);
            spielerMaxHp += (spielerHpMod);
            spielerHp = spielerMaxHp;
            spielerMaxSp += (spielerSpMod);
            spielerSp = spielerMaxSp;
            statSpielerExp.setText("" + spielerExp);
            spielerAtk += spielerLvl;
            spielerDef += spielerLvl;
            spielerHpBar.setMaximum(spielerMaxHp);
            spielerSpBar.setMaximum(spielerMaxSp);
            updateSpielerStats();
        }
    }
    static double expNeed() {
//        if (spielerLvl == 1) {
//            return 20;
//        } else if (spielerLvl == 2){
//            return 40;
//        } else {
//            return (20 * (spielerLvl * spielerLvl) - (20 * spielerLvl));
//        }
        double exponent = 1.5;
        double basisExp = 10;
        return Math.round(basisExp*(Math.pow(spielerLvl,exponent)));
    }
    public static void updateGegnerHp() {
        spielGegnerName.setText(gegnerName);
        spielGegnerLvl.setText("Level: " + gegnerLvl);
        spielGegnerHp.setText("HP: " + gegnerHp + "/" + gegnerMaxHp);
        gegnerHealthBar.setValue(gegnerHp);
    }
    public static void spielerAngriff() {
        Timer timer = new Timer(700, e -> {
            if(gegnerHp > 0){
                if (angriff <= 0) {
                    angriff = 0;
                }
                gegnerHp -= angriff;
                logTextArea.append("\n" + spielerName + " verursacht " + angriff + " Schaden an " + gegnerName + "!");
                mainTextArea.append( "\n" + spielerName + " verursacht " + angriff + " Schaden an " + gegnerName + "!");
                if (gegnerHp <= 0) {
                    gegnerHp = 0;
                }
                updateGegnerHp();
                updateSpielerStats();
            }
        });
        timer.setRepeats(false);
        timer.start();
    }
    public static void spielerBesiegt(){
            spielerHp = 0;
            logTextArea.append("\nGestorben...");
            mainTextArea.append("<br>Gestorben...!");
            updateSpielerStats();
            updateGegnerHp();
            gameOverScreen();
    }
    public static void checkLeben(){
            if (spielerHp <= 0) {
                spielerBesiegt();
            }
            if (gegnerHp <= 0) {
                gegnerBesiegt();
            }
    }
    public static void gegnerAngriff(){
        switch (gegnerMod) {
            case "str":
                range1 = ((gegnerAtk+(gegnerStr/100*gegnerStr)*gegnerStr/10))-(spielerDef+(spielerStr/2));
                range2 = (int) Math.ceil((((gegnerAtk+(gegnerStr/100*gegnerStr)*gegnerStr/10))-(spielerDef+(spielerStr/2)))*1.3);
                System.out.println(range1);
                System.out.println(range2);
                if ((range1 < 0 )|(range2 == 0)){
                    range1 = 0;
                    range2 = 1;
                }
                schaden = rnd.nextInt(range1, range2);
                break;
            case "dex":
                range1 = ((gegnerAtk+(gegnerDex/100*gegnerDex)*gegnerDex/10))-(spielerDef+(spielerDex/2));
                range2 = (int) Math.ceil((((gegnerAtk+(gegnerDex/100*gegnerDex)*gegnerDex/10))-(spielerDef+(spielerDex/2)))*1.3);
                System.out.println(range1);
                System.out.println(range2);
                if ((range1 < 0 )|(range2 == 0)){
                    range1 = 0;
                    range2 = 1;
                }
                schaden = rnd.nextInt(range1, range2);
                break;
            case "kno":
                range1 = ((gegnerAtk+(gegnerKno/100*gegnerKno)*gegnerKno/10))-(spielerDef+(spielerKno/2));
                range2 = (int) Math.ceil((((gegnerAtk+(gegnerKno/100*gegnerKno)*gegnerKno/10))-(spielerDef+(spielerKno/2)))*1.3);
                System.out.println(range1);
                System.out.println(range2);
                if ((range1 < 0 )|(range2 == 0)){
                    range1 = 0;
                    range2 = 1;
                }
                schaden = rnd.nextInt(range1, range2);
                break;
            case "wis":
                range1 = ((gegnerAtk+(gegnerWis/100*gegnerWis)*gegnerWis/10))-(spielerDef+(spielerWis/2));
                range2 = (int) Math.ceil((((gegnerAtk+(gegnerWis/100*gegnerWis)*gegnerWis/10))-(spielerDef+(spielerWis/2)))*1.3);
                System.out.println(range1);
                System.out.println(range2);
                if ((range1 < 0 )|(range2 == 0)){
                    range1 = 0;
                    range2 = 1;
                }
                schaden = rnd.nextInt(range1, range2);
                break;
        }

        if (schaden <= 0){
            schaden = 0;
        }
        Timer timer = new Timer (700, e -> {
            spielerHp -= schaden;
            spielerHpBar.setValue(spielerHp);
            logTextArea.append("\n"+gegnerName+" verursacht "+schaden+" Schaden an "+spielerName+"!");
            mainTextArea.append("\n"+gegnerName+" verursacht "+schaden+" Schaden an "+spielerName+"!");
            if (spielerHp <= 0) {
                spielerHp = 0;
                spielerBesiegt();
            }
            updateGegnerHp();
            updateSpielerStats();
        });
        timer.setRepeats(false);
        timer.start();
    }
    public static void gegnerBesiegt(){
        Timer timer = new Timer(0, e -> {
            gegnerHp = 0;
            logTextArea.append("\nGewonnen!");
            mainTextArea.append("\nGewonnen!");
            Timer timer2 = new Timer(700, e1 -> {
                logTextArea.append("\n" + gegnerExp + " Erfahrungspunkte erhalten.");
                mainTextArea.append("\n" + gegnerExp + " Erfahrungspunkte erhalten.");
                spielerExp += gegnerExp;
                gegnerBildLbl.setVisible(false);
                gegnerInfoPanel.setVisible(false);
                updateSpielerStats();
                updateGegnerHp();
                naviLinksBtn.setEnabled(true);
                naviRechtsBtn.setEnabled(true);
            });
            timer2.setRepeats(false);
            timer2.start();
        });
        timer.setRepeats(false);
        timer.start();
    }
    public static void spielFenster(){
        //region Layout
        spielPanel = new JPanel();
        spielPanel.setBounds(20,20,500,300);
        spielPanel.setBorder(BorderFactory.createLineBorder(Color.WHITE,2,true));

//        textAreaPanel = new JPanel();
//        textAreaPanel.setBounds(20,330,500,140);
//        textAreaPanel.setBorder(BorderFactory.createLineBorder(Color.WHITE,2,true));
//
//        mainTextArea = new JTextArea();
//        mainTextArea.setPreferredSize(new Dimension(480,120));
//        mainTextArea.setLineWrap(true);
//        mainTextArea.setWrapStyleWord(true);
////        mainTextArea.setEnabled(false);
//        mainTextArea.setFont(mainTextFont);
//
//        mainTextAreaScroll = new JScrollPane(mainTextArea);
//        mainTextAreaScroll.setPreferredSize(new Dimension(480, 120));
//        mainTextAreaScroll.setBorder(BorderFactory.createEmptyBorder());
//        mainTextAreaScroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_NEVER);
//        textAreaPanel.add(mainTextAreaScroll);

        textAreaPanel = new JPanel();
        textAreaPanel.setBounds(20,330,500,140);
        mainTextArea = new JTextArea();
        mainTextArea.setLineWrap(true);
        mainTextArea.setEditable(false);
        mainTextArea.setFont(mainTextFont);

        mainTextAreaScroll = new JScrollPane(mainTextArea);
        mainTextAreaScroll.setPreferredSize(new Dimension(500, 135));
        mainTextAreaScroll.setBorder(BorderFactory.createEmptyBorder());
        mainTextAreaScroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_NEVER);
        mainTextAreaScroll.setBorder(BorderFactory.createLineBorder(Color.WHITE, 2, true));
        textAreaPanel.add(mainTextAreaScroll);

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

        spielerHpBar = new JProgressBar(0,spielerMaxHp);
        spielerSpBar = new JProgressBar(0,spielerMaxSp);
        spielerExpBar = new JProgressBar();

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
//        skillBtn6 = new JButton(Skills.Skills.hexerSkill6);
//        skillBtn7 = new JButton(Skills.Skills.hexerSkill7);
//        skillBtn8 = new JButton(Skills.Skills.hexerSkill8);
//        skillBtn6.setPreferredSize(new Dimension(50,50));
//        skillBtn7.setPreferredSize(new Dimension(50,50));
//        skillBtn8.setPreferredSize(new Dimension(50,50));

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
        statspielerSpLbl = new JLabel("SP");
        statspielerSp = new JLabel(spielerSp+"/"+spielerMaxSp);
        statSpielerExpLbl = new JLabel("EXP");
        statSpielerExp = new JLabel("" + spielerExp);

        statSpielerAtkLbl = new JLabel("Angriff");
        statSpielerAtk = new JLabel(""+spielerAtk);
        statSpielerDefLbl = new JLabel("Verteidigung");
        statSpielerDef = new JLabel(""+spielerDef);
        ImageIcon statUp = new ImageIcon("res/Icons/Plus.png");
        strUpBtn = new JButton(statUp);
        dexUpBtn = new JButton(statUp);
        knoUpBtn = new JButton(statUp);
        wisUpBtn = new JButton(statUp);
        skillpointsLbl = new JLabel("(2) Skillpunkte zu vergeben.");
        skillpointsLbl.setFont(new Font("Segoe UI", Font.BOLD, 11));


        JLabel statSpielerStrLbl = new JLabel("<html><font color='#ff0000'>Stärke");
        statSpielerStr = new JLabel("" + spielerStr);
        JLabel statSpielerDexLbl = new JLabel("<html><font color='#3cb371'>Geschick");
        statSpielerDex = new JLabel("" + spielerDex);
        JLabel statSpielerKnoLbl = new JLabel("<html><font color='#94d0ff'>Intelligenz");
        statSpielerKno = new JLabel("" + spielerKno);
        JLabel statSpielerWisLbl = new JLabel("<html><font color='#ffe400'>Weisheit");
        statSpielerWis = new JLabel("" + spielerWis);


        statSpielerName.setFont(statFont);
        statSpielerHpLbl.setFont(statFont);
        statSpielerHp.setFont(statFont);
        statSpielerLvlLbl.setFont(statFont);
        statSpielerLvl.setFont(statFont);
        statspielerSpLbl.setFont(statFont);
        statspielerSp.setFont(statFont);
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

        spielerHpBar.setFont(barFont);
        spielerHpBar.setStringPainted(true);
        spielerHpBar.setForeground(Color.decode("#C70039"));
        spielerHpBar.setPreferredSize(new Dimension(180,20));

        spielerSpBar.setFont(barFont);
        spielerSpBar.setStringPainted(true);
        spielerSpBar.setForeground(Color.decode("#234ba1"));
        spielerSpBar.setPreferredSize(new Dimension(180,20));

        spielerExpBar.setFont(barFont);
        spielerExpBar.setStringPainted(true);
        spielerExpBar.setForeground(new Color(192,129,0));
        spielerExpBar.setPreferredSize(new Dimension(180,20));

        //layout links
        layout.putConstraint(SpringLayout.HORIZONTAL_CENTER,statSpielerName,0, SpringLayout.HORIZONTAL_CENTER,spielerStatsPanel);
        layout.putConstraint(SpringLayout.WEST,statSpielerLvlLbl,20, SpringLayout.WEST,spielerStatsPanel);
        layout.putConstraint(SpringLayout.WEST,statSpielerHpLbl,20, SpringLayout.WEST,spielerStatsPanel);
        layout.putConstraint(SpringLayout.HORIZONTAL_CENTER,spielerHpBar,0,SpringLayout.HORIZONTAL_CENTER,spielerStatsPanel);
        layout.putConstraint(SpringLayout.HORIZONTAL_CENTER,spielerSpBar,0,SpringLayout.HORIZONTAL_CENTER,spielerStatsPanel);
        layout.putConstraint(SpringLayout.WEST,statspielerSpLbl,20, SpringLayout.WEST,spielerStatsPanel);
        layout.putConstraint(SpringLayout.WEST,statSpielerExpLbl,20, SpringLayout.WEST,spielerStatsPanel);
        layout.putConstraint(SpringLayout.HORIZONTAL_CENTER,spielerExpBar,0,SpringLayout.HORIZONTAL_CENTER,spielerStatsPanel);

        spielerProgressLayout.putConstraint(SpringLayout.WEST,statSpielerAtkLbl,20, SpringLayout.WEST,spielerProgressPanel);
        spielerProgressLayout.putConstraint(SpringLayout.WEST,statSpielerDefLbl,20, SpringLayout.WEST,spielerProgressPanel);
        spielerProgressLayout.putConstraint(SpringLayout.WEST,statSpielerStrLbl, 20, SpringLayout.WEST,spielerProgressPanel);
        spielerProgressLayout.putConstraint(SpringLayout.WEST,statSpielerDexLbl, 20, SpringLayout.WEST,spielerProgressPanel);
        spielerProgressLayout.putConstraint(SpringLayout.WEST,statSpielerKnoLbl, 20, SpringLayout.WEST,spielerProgressPanel);
        spielerProgressLayout.putConstraint(SpringLayout.WEST,statSpielerWisLbl, 20, SpringLayout.WEST,spielerProgressPanel);

        layout.putConstraint(SpringLayout.NORTH,statSpielerName,5, SpringLayout.NORTH,spielerStatsPanel);
        layout.putConstraint(SpringLayout.NORTH,statSpielerLvlLbl,5, SpringLayout.SOUTH,statSpielerName);
        layout.putConstraint(SpringLayout.NORTH,statSpielerHpLbl,10, SpringLayout.SOUTH,statSpielerLvlLbl);
        layout.putConstraint(SpringLayout.NORTH,spielerHpBar,3, SpringLayout.SOUTH,statSpielerHpLbl);
        layout.putConstraint(SpringLayout.NORTH,statspielerSpLbl,10, SpringLayout.SOUTH,spielerHpBar);
        layout.putConstraint(SpringLayout.NORTH,spielerSpBar,3, SpringLayout.SOUTH,statspielerSpLbl);
        layout.putConstraint(SpringLayout.NORTH,statSpielerExpLbl,10, SpringLayout.SOUTH,spielerSpBar);
        layout.putConstraint(SpringLayout.NORTH,spielerExpBar,3, SpringLayout.SOUTH,statSpielerExpLbl);

        spielerProgressLayout.putConstraint(SpringLayout.NORTH,statSpielerAtkLbl,10, SpringLayout.NORTH,spielerProgressPanel);
        spielerProgressLayout.putConstraint(SpringLayout.NORTH,statSpielerDefLbl,10, SpringLayout.SOUTH,statSpielerAtkLbl);
        spielerProgressLayout.putConstraint(SpringLayout.NORTH,statSpielerStrLbl,10, SpringLayout.SOUTH,statSpielerDefLbl);
        spielerProgressLayout.putConstraint(SpringLayout.NORTH,statSpielerDexLbl,10, SpringLayout.SOUTH,statSpielerStrLbl);
        spielerProgressLayout.putConstraint(SpringLayout.NORTH,statSpielerKnoLbl,10, SpringLayout.SOUTH,statSpielerDexLbl);
        spielerProgressLayout.putConstraint(SpringLayout.NORTH,statSpielerWisLbl,10, SpringLayout.SOUTH,statSpielerKnoLbl);

        //layout rechts
        layout.putConstraint(SpringLayout.EAST,statSpielerHp,-20, SpringLayout.EAST,spielerStatsPanel);
        layout.putConstraint(SpringLayout.EAST,statspielerSp,-20, SpringLayout.EAST,spielerStatsPanel);
        layout.putConstraint(SpringLayout.EAST,statSpielerExp,-20, SpringLayout.EAST,spielerStatsPanel);
        layout.putConstraint(SpringLayout.EAST,statSpielerLvl,-20, SpringLayout.EAST,spielerStatsPanel);

        spielerProgressLayout.putConstraint(SpringLayout.EAST,statSpielerAtk,-20, SpringLayout.EAST,spielerProgressPanel);
        spielerProgressLayout.putConstraint(SpringLayout.EAST,statSpielerDef,-20, SpringLayout.EAST,spielerProgressPanel);
        spielerProgressLayout.putConstraint(SpringLayout.EAST,statSpielerStr,-20, SpringLayout.EAST,spielerProgressPanel);
        spielerProgressLayout.putConstraint(SpringLayout.EAST,statSpielerDex,-20, SpringLayout.EAST,spielerProgressPanel);
        spielerProgressLayout.putConstraint(SpringLayout.EAST,statSpielerKno,-20, SpringLayout.EAST,spielerProgressPanel);
        spielerProgressLayout.putConstraint(SpringLayout.EAST,statSpielerWis,-20, SpringLayout.EAST,spielerProgressPanel);

        layout.putConstraint(SpringLayout.NORTH,statSpielerLvl,5, SpringLayout.SOUTH,statSpielerName);
        layout.putConstraint(SpringLayout.NORTH,statSpielerHp,10, SpringLayout.SOUTH,statSpielerLvl);
        layout.putConstraint(SpringLayout.NORTH,statspielerSp,10, SpringLayout.SOUTH,spielerHpBar);
        layout.putConstraint(SpringLayout.NORTH,statSpielerExp,10, SpringLayout.SOUTH,spielerSpBar);

        spielerProgressLayout.putConstraint(SpringLayout.NORTH,statSpielerAtk,10, SpringLayout.NORTH,spielerProgressPanel);
        spielerProgressLayout.putConstraint(SpringLayout.NORTH,statSpielerDef,10, SpringLayout.SOUTH,statSpielerAtk);
        spielerProgressLayout.putConstraint(SpringLayout.NORTH,statSpielerStr,10, SpringLayout.SOUTH,statSpielerDef);
        spielerProgressLayout.putConstraint(SpringLayout.NORTH,statSpielerDex,10, SpringLayout.SOUTH,statSpielerStr);
        spielerProgressLayout.putConstraint(SpringLayout.NORTH,statSpielerKno,10, SpringLayout.SOUTH,statSpielerDex);
        spielerProgressLayout.putConstraint(SpringLayout.NORTH,statSpielerWis,10, SpringLayout.SOUTH,statSpielerKno);

        spielerProgressLayout.putConstraint(SpringLayout.EAST, strUpBtn, -50,SpringLayout.EAST,spielerProgressPanel);
        spielerProgressLayout.putConstraint(SpringLayout.EAST, dexUpBtn, -50,SpringLayout.EAST,spielerProgressPanel);
        spielerProgressLayout.putConstraint(SpringLayout.EAST, knoUpBtn, -50,SpringLayout.EAST,spielerProgressPanel);
        spielerProgressLayout.putConstraint(SpringLayout.EAST, wisUpBtn, -50,SpringLayout.EAST,spielerProgressPanel);

        spielerProgressLayout.putConstraint(SpringLayout.NORTH,strUpBtn,10, SpringLayout.SOUTH,statSpielerDef);
        spielerProgressLayout.putConstraint(SpringLayout.NORTH,dexUpBtn,10, SpringLayout.SOUTH,statSpielerStr);
        spielerProgressLayout.putConstraint(SpringLayout.NORTH,knoUpBtn,10, SpringLayout.SOUTH,statSpielerDex);
        spielerProgressLayout.putConstraint(SpringLayout.NORTH,wisUpBtn,10, SpringLayout.SOUTH,statSpielerKno);

        spielerProgressLayout.putConstraint(SpringLayout.HORIZONTAL_CENTER,skillpointsLbl,0,SpringLayout.HORIZONTAL_CENTER,spielerProgressPanel);
        spielerProgressLayout.putConstraint(SpringLayout.NORTH,skillpointsLbl,5,SpringLayout.SOUTH,statSpielerWis);

        spielerStatsPanel.setLayout(layout);
        spielerStatsPanel.add(statSpielerName);
        spielerStatsPanel.add(statSpielerHpLbl);
        spielerStatsPanel.add(statSpielerHp);
        spielerStatsPanel.add(spielerHpBar);
        spielerStatsPanel.add(spielerSpBar);
        spielerStatsPanel.add(statSpielerLvlLbl);
        spielerStatsPanel.add(statSpielerLvl);
        spielerStatsPanel.add(statspielerSpLbl);
        spielerStatsPanel.add(statspielerSp);
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
        spielerProgressPanel.add(strUpBtn);
        spielerProgressPanel.add(dexUpBtn);
        spielerProgressPanel.add(knoUpBtn);
        spielerProgressPanel.add(wisUpBtn);
        spielerProgressPanel.add(skillpointsLbl);
        strUpBtn.setVisible(false);
        dexUpBtn.setVisible(false);
        knoUpBtn.setVisible(false);
        wisUpBtn.setVisible(false);
        skillpointsLbl.setVisible(false);

        strUpBtn.addActionListener(e -> {
            skillpoints--;
            spielerStr++;
            spielerMaxHp += 2;
            spielerHp += 2;
            spielerAtk += 2;
            spielerDef += 2;
            skillpointsLbl.setText("("+skillpoints+") Skillpunkte zu vergeben.");
            if (skillpoints <= 0){
                strUpBtn.setVisible(false);
                dexUpBtn.setVisible(false);
                knoUpBtn.setVisible(false);
                wisUpBtn.setVisible(false);
                skillpointsLbl.setVisible(false);
            }
            updateSpielerStats();
        });
        dexUpBtn.addActionListener(e -> {
            skillpoints--;
            spielerDex++;
            spielerAtk += 3;
            spielerDef++;
            skillpointsLbl.setText("("+skillpoints+") Skillpunkte zu vergeben.");
            if (skillpoints <= 0){
                strUpBtn.setVisible(false);
                dexUpBtn.setVisible(false);
                knoUpBtn.setVisible(false);
                wisUpBtn.setVisible(false);
                skillpointsLbl.setVisible(false);
            }
            updateSpielerStats();
        });
        knoUpBtn.addActionListener(e -> {
            skillpoints--;
            spielerKno++;
            spielerMaxSp += 2;
            spielerSp += 2;
            spielerAtk += 3;
            spielerDef++;
            skillpointsLbl.setText("("+skillpoints+") Skillpunkte zu vergeben.");
            if (skillpoints <= 0){
                strUpBtn.setVisible(false);
                dexUpBtn.setVisible(false);
                knoUpBtn.setVisible(false);
                wisUpBtn.setVisible(false);
                skillpointsLbl.setVisible(false);
            }
            updateSpielerStats();
        });
        wisUpBtn.addActionListener(e -> {
            skillpoints--;
            spielerWis++;
            spielerMaxHp++;
            spielerHp++;
            spielerMaxSp++;
            spielerSp++;
            spielerAtk += 2;
            spielerDef += 2;
            skillpointsLbl.setText("("+skillpoints+") Skillpunkte zu vergeben.");
            if (skillpoints <= 0){
                strUpBtn.setVisible(false);
                dexUpBtn.setVisible(false);
                knoUpBtn.setVisible(false);
                wisUpBtn.setVisible(false);
                skillpointsLbl.setVisible(false);
            }
            updateSpielerStats();
        });
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
        int rnd1 = rnd.nextInt(0,7);
        int rnd2 = rnd.nextInt(0,7);
        int rnd3 = rnd.nextInt(0,7);
        int rnd4 = rnd.nextInt(0,7);
        int rnd5 = rnd.nextInt(0,7);
        int rnd6 = rnd.nextInt(0,7);

        ImageIcon linksBild = new ImageIcon("res/Icons/"+kartenListe[rnd1].name+".png");
        ImageIcon rechtsBild = new ImageIcon("res/Icons/"+kartenListe[rnd2].name+".png");
        ImageIcon linksLinksBild = new ImageIcon("res/Icons/"+kartenListe[rnd3].name+".png");
        ImageIcon linksRechtsBild = new ImageIcon("res/Icons/"+kartenListe[rnd4].name+".png");
        ImageIcon rechtsLinksBild = new ImageIcon("res/Icons/"+kartenListe[rnd5].name+".png");
        ImageIcon rechtsRechtsBild = new ImageIcon("res/Icons/"+kartenListe[rnd6].name+".png");
        ImageIcon pfeilHoch = new ImageIcon("res/Icons/PfeilHoch.png");

        //region navi layout
        naviLinksBtn = new JButton(linksBild);
        naviRechtsBtn = new JButton(rechtsBild);
        naviLinksLinksLbl = new JLabel(linksLinksBild);
        naviLinksRechtsLbl = new JLabel(linksRechtsBild);
        naviRechtsLinksLbl = new JLabel(rechtsLinksBild);
        naviRechtsRechtsLbl = new JLabel(rechtsRechtsBild);
        pfeilHochLinks = new JLabel(pfeilHoch);
        pfeilHochRechts = new JLabel(pfeilHoch);
        naviLbl = new JLabel("Richtung auswählen");
        naviLbl.setFont(textFont);
        naviTitelLbl = new JLabel("Titel");
        naviEbeneLbl = new JLabel("Ebene 1");
        naviTitelLbl.setFont(statFont);
        naviEbeneLbl.setFont(textFont);

        //btn
        naviLayout.putConstraint(SpringLayout.HORIZONTAL_CENTER,naviLinksBtn,-50,SpringLayout.HORIZONTAL_CENTER,naviPanel);
        naviLayout.putConstraint(SpringLayout.HORIZONTAL_CENTER,naviRechtsBtn,50,SpringLayout.HORIZONTAL_CENTER,naviPanel);
        naviLayout.putConstraint(SpringLayout.VERTICAL_CENTER,naviLinksBtn,35,SpringLayout.VERTICAL_CENTER,naviPanel);
        naviLayout.putConstraint(SpringLayout.VERTICAL_CENTER,naviRechtsBtn,35,SpringLayout.VERTICAL_CENTER,naviPanel);
        //lbl
        naviLayout.putConstraint(SpringLayout.HORIZONTAL_CENTER, pfeilHochLinks, 0, SpringLayout.HORIZONTAL_CENTER,naviLinksBtn);
        naviLayout.putConstraint(SpringLayout.HORIZONTAL_CENTER, pfeilHochRechts, 0, SpringLayout.HORIZONTAL_CENTER,naviRechtsBtn);
        naviLayout.putConstraint(SpringLayout.NORTH, pfeilHochLinks, 0, SpringLayout.SOUTH,naviLinksBtn);
        naviLayout.putConstraint(SpringLayout.NORTH, pfeilHochRechts, 0, SpringLayout.SOUTH,naviRechtsBtn);

        naviLayout.putConstraint(SpringLayout.NORTH, naviTitelLbl,5,SpringLayout.NORTH,naviPanel);
        naviLayout.putConstraint(SpringLayout.HORIZONTAL_CENTER, naviTitelLbl,0,SpringLayout.HORIZONTAL_CENTER,naviPanel);
        naviLayout.putConstraint(SpringLayout.HORIZONTAL_CENTER, naviEbeneLbl, 0, SpringLayout.HORIZONTAL_CENTER, naviPanel);
        naviLayout.putConstraint(SpringLayout.NORTH, naviEbeneLbl, 0, SpringLayout.SOUTH, naviTitelLbl);

        naviLayout.putConstraint(SpringLayout.HORIZONTAL_CENTER, naviLbl, 0,SpringLayout.HORIZONTAL_CENTER, naviPanel);
        naviLayout.putConstraint(SpringLayout.NORTH, naviLbl, 0,SpringLayout.SOUTH, pfeilHochLinks);
        //links
        naviLayout.putConstraint(SpringLayout.VERTICAL_CENTER, naviLinksLinksLbl,-40,SpringLayout.VERTICAL_CENTER,naviLinksBtn);
        naviLayout.putConstraint(SpringLayout.VERTICAL_CENTER, naviLinksRechtsLbl,-40,SpringLayout.VERTICAL_CENTER,naviLinksBtn);
        naviLayout.putConstraint(SpringLayout.HORIZONTAL_CENTER, naviLinksLinksLbl,-30,SpringLayout.HORIZONTAL_CENTER,naviLinksBtn);
        naviLayout.putConstraint(SpringLayout.HORIZONTAL_CENTER, naviLinksRechtsLbl,30,SpringLayout.HORIZONTAL_CENTER,naviLinksBtn);

        //rechts
        naviLayout.putConstraint(SpringLayout.VERTICAL_CENTER, naviRechtsLinksLbl,-40,SpringLayout.VERTICAL_CENTER,naviRechtsBtn);
        naviLayout.putConstraint(SpringLayout.VERTICAL_CENTER, naviRechtsRechtsLbl,-40,SpringLayout.VERTICAL_CENTER,naviRechtsBtn);
        naviLayout.putConstraint(SpringLayout.HORIZONTAL_CENTER, naviRechtsLinksLbl,-30,SpringLayout.HORIZONTAL_CENTER,naviRechtsBtn);
        naviLayout.putConstraint(SpringLayout.HORIZONTAL_CENTER, naviRechtsRechtsLbl,30,SpringLayout.HORIZONTAL_CENTER,naviRechtsBtn);
        //endregion
        //region navi add
        naviPanel.add(naviLinksBtn);
        naviPanel.add(naviRechtsBtn);
        naviPanel.add(naviLinksLinksLbl);
        naviPanel.add(naviLinksRechtsLbl);
        naviPanel.add(naviRechtsLinksLbl);
        naviPanel.add(naviRechtsRechtsLbl);
        naviPanel.add(pfeilHochLinks);
        naviPanel.add(pfeilHochRechts);
        naviPanel.add(naviLbl);
        naviPanel.add(naviTitelLbl);
        naviPanel.add(naviEbeneLbl);
        spielPanel.add(naviPanel);
        //endregion
        //movement
        naviLinksBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                raumCounter++;
                int z = rnd.nextInt(0,7);
                int y = rnd.nextInt(0,7);
                int x = rnd.nextInt(0,7);
                int w = rnd.nextInt(0,7);

                if (naviLinksBtn.getIcon().toString().equals("res/Icons/Kampf.png")) {
                    randomEncounterTier1();
                    System.out.println(gegnerName);
                } else if (naviLinksBtn.getIcon().toString().equals("res/Icons/Lager.png")) {
                    System.out.println("Lager");
                } else if (naviLinksBtn.getIcon().toString().equals("res/Icons/Event.png")) {
                    System.out.println("Event");
                }

                naviLinksBtn.setIcon(naviLinksLinksLbl.getIcon());
                naviRechtsBtn.setIcon(naviLinksRechtsLbl.getIcon());
                naviLinksLinksLbl.setIcon(new ImageIcon("res/Icons/"+kartenListe[z].name+".png"));
                naviLinksRechtsLbl.setIcon(new ImageIcon("res/Icons/"+kartenListe[y].name+".png"));
                naviRechtsLinksLbl.setIcon(new ImageIcon("res/Icons/"+kartenListe[x].name+".png"));
                naviRechtsRechtsLbl.setIcon(new ImageIcon("res/Icons/"+kartenListe[w].name+".png"));


            }
        });
        naviRechtsBtn.addActionListener(e -> {
            int z = rnd.nextInt(0,7);
            int y = rnd.nextInt(0,7);
            int x = rnd.nextInt(0,7);
            int w = rnd.nextInt(0,7);

            if (naviRechtsBtn.getIcon().toString().equals("res/Icons/Kampf.png")) {
                randomEncounterTier1();
                System.out.println(gegnerName);
            } else if (naviRechtsBtn.getIcon().toString().equals("res/Icons/Lager.png")) {
                System.out.println("Lager");
            } else if (naviRechtsBtn.getIcon().toString().equals("res/Icons/Event.png")) {
                System.out.println("Event");
            }

            naviLinksBtn.setIcon(naviRechtsLinksLbl.getIcon());
            naviRechtsBtn.setIcon(naviRechtsRechtsLbl.getIcon());
            naviLinksLinksLbl.setIcon(new ImageIcon("res/Icons/"+kartenListe[z].name+".png"));
            naviLinksRechtsLbl.setIcon(new ImageIcon("res/Icons/"+kartenListe[y].name+".png"));
            naviRechtsLinksLbl.setIcon(new ImageIcon("res/Icons/"+kartenListe[x].name+".png"));
            naviRechtsRechtsLbl.setIcon(new ImageIcon("res/Icons/"+kartenListe[w].name+".png"));
        });
        //endregion

        logBtn.addActionListener(e -> logFrame.setVisible(true));


        auswahlPanelLinks.setVisible(false);
        vorschauPanel.setVisible(false);
        auswahlPanelRechts.setVisible(false);
        auswahlBtn.setVisible(false);
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
    public static void spielerVerfehlt(){
        if(gegnerHp > 0){
            logTextArea.append("\n" + spielerName + " verfehlt...");
            mainTextArea.append("\n" + spielerName + " verfehlt...");
            if (gegnerHp > 0)wait(700);
        }
    }
    public static void skillLeiste(){
        skillBtn1.addActionListener(e -> {
            switch (skill1Mod){
                case "str":
                    trefferChance = ((int) (Math.random()*100));
                    if (skill1Genauigkeit >= trefferChance){
                        range1 = (((skill1Kraft*spielerStr)/100)+((spielerAtk+spielerStr)/8)-(gegnerDef+gegnerStr));
                        range2 = ((int) Math.ceil((((skill1Kraft*spielerStr)/100)+((spielerAtk+spielerStr)/8)-(gegnerDef+gegnerStr))*1.5));
                        System.out.println(range1);
                        System.out.println(range2);
                        if ((range1 < 0 )|(range2 == 0)){
                            range1 = 0;
                            range2 = 1;
                        } else if (range1 >= range2){
                            range2 = range1;
                            range2++;
                        }
                        angriff = rnd.nextInt(range1, range2);
                        spielerAngriff();
                    } else {
                        spielerVerfehlt();
                    }
                    break;
                case "dex":
                    trefferChance = ((int) (Math.random()*100));
                    if (skill1Genauigkeit >= trefferChance){
                        range1 = (((skill1Kraft*spielerDex)/100)+((spielerAtk+spielerDex)/8)-(gegnerDef+gegnerDex));
                        range2 = ((int) Math.ceil((((skill1Kraft*spielerDex)/100)+((spielerAtk+spielerDex)/8)-(gegnerDef+gegnerDex))*1.5));

                        if ((range1 < 0 )|(range2 == 0)){
                            range1 = 0;
                            range2 = 1;
                        } else if (range1 >= range2){
                            range2 = range1;
                            range2++;
                        }
                        angriff = rnd.nextInt(range1, range2);
                        spielerAngriff();
                    } else {
                        spielerVerfehlt();
                    }
                    break;
                case "kno":
                    trefferChance = ((int) (Math.random()*100));
                    if (skill1Genauigkeit >= trefferChance){
                        range1 = (((skill1Kraft*spielerKno)/100)+((spielerAtk+spielerKno)/8)-(gegnerDef+gegnerKno));
                        range2 = ((int) Math.ceil((((skill1Kraft*spielerKno)/100)+((spielerAtk+spielerKno)/8)-(gegnerDef+gegnerKno))*1.5));
                        System.out.println(range1);
                        System.out.println(range2);

                        if ((range1 < 0 )|(range2 == 0)){
                            range1 = 0;
                            range2 = 1;
                        } else if (range1 >= range2){
                            range2 = range1;
                            range2++;
                        }
                        angriff = rnd.nextInt(range1, range2);
                        spielerAngriff();
                    } else {
                        spielerVerfehlt();
                    }
                    break;
                case "wis":
                    trefferChance = ((int) (Math.random()*100));
                    if (skill1Genauigkeit >= trefferChance){
                        range1 = (((skill1Kraft*spielerWis)/100)+((spielerAtk+spielerWis)/8)-(gegnerDef+gegnerWis));
                        range2 = ((int) Math.ceil((((skill1Kraft*spielerWis)/100)+((spielerAtk+spielerWis)/8)-(gegnerDef+gegnerWis))*1.5));
                        System.out.println(range1);
                        System.out.println(range2);

                        if ((range1 < 0 )|(range2 == 0)){
                            range1 = 0;
                            range2 = 1;
                        } else if (range1 >= range2){
                            range2 = range1;
                            range2++;
                        }
                        angriff = rnd.nextInt(range1, range2);
                        spielerAngriff();
                    } else {
                        spielerVerfehlt();
                    }
                    break;
            }
        });
        skillBtn2.addActionListener(e -> {
            switch (skill2Mod){
                case "str":
                    trefferChance = ((int) (Math.random()*100));
                    if (skill2Genauigkeit >= trefferChance){
                        range1 = (((skill2Kraft*spielerStr)/100)+((spielerAtk+spielerStr)/8)-(gegnerDef+gegnerStr));
                        range2 = ((int) Math.ceil((((skill2Kraft*spielerStr)/100)+((spielerAtk+spielerStr)/8)-(gegnerDef+gegnerStr))*1.5));
                        System.out.println(range1);
                        System.out.println(range2);
                        if ((range1 < 0 )|(range2 == 0)){
                            range1 = 0;
                            range2 = 1;
                        } else if (range1 >= range2){
                            range2 = range1;
                            range2++;
                        }
                        angriff = rnd.nextInt(range1, range2);
                        spielerAngriff();
                    } else {
                        spielerVerfehlt();
                    }
                    break;
                case "dex":
                    trefferChance = ((int) (Math.random()*100));
                    if (skill2Genauigkeit >= trefferChance){
                        range1 = (((skill2Kraft*spielerDex)/100)+((spielerAtk+spielerDex)/8)-(gegnerDef+gegnerDex));
                        range2 = ((int) Math.ceil(((((skill2Kraft*spielerDex)/100)+(spielerAtk+spielerDex)/8)-(gegnerDef+gegnerDex))*1.5));
                        System.out.println(range1);
                        System.out.println(range2);
                        if ((range1 < 0 )|(range2 == 0)){
                            range1 = 0;
                            range2 = 1;
                        } else if (range1 >= range2){
                            range2 = range1;
                            range2++;
                        }
                        angriff = rnd.nextInt(range1, range2);
                        spielerAngriff();
                    } else {
                        spielerVerfehlt();
                    }
                    break;
                case "kno":
                    trefferChance = ((int) (Math.random()*100));
                    if (skill2Genauigkeit >= trefferChance){
                        range1 = (((skill2Kraft*spielerKno)/100)+((spielerAtk+spielerKno)/8)-(gegnerDef+gegnerKno));
                        range2 = ((int) Math.ceil((((skill2Kraft*spielerKno)/100)+((spielerAtk+spielerKno)/8)-(gegnerDef+gegnerKno))*1.5));
                        System.out.println(range1);
                        System.out.println(range2);
                        if ((range1 < 0 )|(range2 == 0)){
                            range1 = 0;
                            range2 = 1;
                        } else if (range1 >= range2){
                            range2 = range1;
                            range2++;
                        }
                        angriff = rnd.nextInt(range1, range2);
                        spielerAngriff();
                    } else {
                        spielerVerfehlt();
                    }
                    break;
                case "wis":
                    trefferChance = ((int) (Math.random()*100));
                    if (skill2Genauigkeit >= trefferChance){
                        range1 = (((skill2Kraft*spielerWis)/100)+((spielerAtk+spielerWis)/8)-(gegnerDef+gegnerWis));
                        range2 = ((int) Math.ceil((((skill2Kraft*spielerWis)/100)+((spielerAtk+spielerWis)/8)-(gegnerDef+gegnerWis))*1.5));
                        System.out.println(range1);
                        System.out.println(range2);
                        if ((range1 < 0 )|(range2 == 0)){
                            range1 = 0;
                            range2 = 1;
                        } else if (range1 >= range2){
                            range2 = range1;
                            range2++;
                        }
                        angriff = rnd.nextInt(range1, range2);
                        spielerAngriff();
                    } else {
                        spielerVerfehlt();
                    }
                    break;
            }
        });
        skillBtn3.addActionListener(e -> {
            switch (skill3Mod){
                case "str":
                    trefferChance = ((int) (Math.random()*100));
                    if (skill3Genauigkeit >= trefferChance){
                        range1 = (((skill3Kraft*spielerStr)/100)+((spielerAtk+spielerStr)/8)-(gegnerDef+gegnerStr));
                        range2 = ((int) Math.ceil((((skill3Kraft*spielerStr)/100)+((spielerAtk+spielerStr)/8)-(gegnerDef+gegnerStr))*1.5));

                        if ((range1 < 0 )|(range2 == 0)){
                            range1 = 0;
                            range2 = 1;
                        } else if (range1 >= range2){
                            range2 = range1;
                            range2++;
                        }
                        angriff = rnd.nextInt(range1, range2);
                        spielerAngriff();

                        if (schaden <= 0){
                            schaden = 0;
                        }
                        Timer timer = new Timer (700, e1 -> {
                            trefferChance = ((int) (Math.random()*100));
                            if (skill3Genauigkeit >= trefferChance){
                                range1 = (((skill3Kraft*spielerStr)/100)+((spielerAtk+spielerStr)/8)-(gegnerDef+gegnerStr));
                                range2 = ((int) Math.ceil((((skill3Kraft*spielerStr)/100)+((spielerAtk+spielerStr)/8)-(gegnerDef+gegnerStr))*1.5));

                                if ((range1 < 0 )|(range2 == 0)){
                                    range1 = 0;
                                    range2 = 1;
                                } else if (range1 >= range2){
                                    range2 = range1;
                                    range2++;
                                }
                                angriff = rnd.nextInt(range1, range2);
                                spielerAngriff();

                                if (schaden <= 0){
                                    schaden = 0;
                                }
                        }
                        });
                        timer.setRepeats(false);
                        timer.start();
                        Timer timer2 = new Timer(700, e2 -> {
                            wait(700);
                        });
                        timer2.setRepeats(false);
                        timer2.start();
                    } else {
                        spielerVerfehlt();
                    }
                    break;
                case "dex":
                    trefferChance = ((int) (Math.random()*100));
                    if (skill3Genauigkeit >= trefferChance){
                        range1 = (((skill3Kraft*spielerDex)/100)+((spielerAtk+spielerDex)/8)-(gegnerDef+gegnerDex));
                        range2 = ((int) Math.ceil((((skill3Kraft*spielerDex)/100)+((spielerAtk+spielerDex)/8)-(gegnerDef+gegnerDex))*1.5));

                        if ((range1 < 0 )|(range2 == 0)){
                            range1 = 0;
                            range2 = 1;
                        } else if (range1 >= range2){
                            range2 = range1;
                            range2++;
                        }
                        angriff = rnd.nextInt(range1, range2);
                        spielerAngriff();
                    } else {
                        spielerVerfehlt();
                    }
                    break;
                case "kno":
                    trefferChance = ((int) (Math.random()*100));
                    if (skill3Genauigkeit >= trefferChance){
                        range1 = (((skill3Kraft*spielerKno)/100)+((spielerAtk+spielerKno)/8)-(gegnerDef+gegnerKno));
                        range2 = ((int) Math.ceil((((skill3Kraft*spielerKno)/100)+((spielerAtk+spielerKno)/8)-(gegnerDef+gegnerKno))*1.5));
                        System.out.println(range1);
                        System.out.println(range2);
                        if ((range1 < 0 )|(range2 == 0)){
                            range1 = 0;
                            range2 = 1;
                        } else if (range1 >= range2){
                            range2 = range1;
                            range2++;
                        }
                        angriff = rnd.nextInt(range1, range2);
                        spielerAngriff();
                    } else {
                        spielerVerfehlt();
                    }
                    break;
                case "wis":
                    trefferChance = ((int) (Math.random()*100));
                    if (skill3Genauigkeit >= trefferChance){
                        range1 = (((skill3Kraft*spielerWis)/100)+((spielerAtk+spielerWis)/8)-(gegnerDef+gegnerWis));
                        range2 = ((int) Math.ceil((((skill3Kraft*spielerWis)/100)+((spielerAtk+spielerWis)/8)-(gegnerDef+gegnerWis))*1.5));

                        if ((range1 < 0 )|(range2 == 0)){
                            range1 = 0;
                            range2 = 1;
                        } else if (range1 >= range2){
                            range2 = range1;
                            range2++;
                        }
                        angriff = rnd.nextInt(range1, range2);
                        spielerAngriff();
                    } else {
                        spielerVerfehlt();
                    }
                    break;
            }
        });
        skillBtn4.addActionListener(e -> {
            switch (skill4Mod){
                case "str":
                    trefferChance = ((int) (Math.random()*100));
                    if (skill4Genauigkeit >= trefferChance){
                        range1 = (((skill4Kraft*spielerStr)/100)+((spielerAtk+spielerStr)/8)-(gegnerDef+gegnerStr));
                        range2 = ((int) Math.ceil(((((skill4Kraft*spielerStr)/100)+(spielerAtk+spielerStr)/8)-(gegnerDef+gegnerStr))*1.5));

                        if ((range1 < 0 )|(range2 == 0)){
                            range1 = 0;
                            range2 = 1;
                        } else if (range1 >= range2){
                            range2 = range1;
                            range2++;
                        }
                        angriff = rnd.nextInt(range1, range2);
                        spielerAngriff();
                    } else {
                        spielerVerfehlt();
                    }
                    break;
                case "dex":
                    trefferChance = ((int) (Math.random()*100));
                    if (skill4Genauigkeit >= trefferChance){
                        range1 = (((skill4Kraft*spielerDex)/100)+((spielerAtk+spielerDex)/8)-(gegnerDef+gegnerDex));
                        range2 = ((int) Math.ceil(((((skill4Kraft*spielerDex)/100)+(spielerAtk+spielerDex)/8)-(gegnerDef+gegnerDex))*1.5));

                        if ((range1 < 0 )|(range2 == 0)){
                            range1 = 0;
                            range2 = 1;
                        } else if (range1 >= range2){
                            range2 = range1;
                            range2++;
                        }
                        angriff = rnd.nextInt(range1, range2);
                        spielerAngriff();
                    } else {
                        spielerVerfehlt();
                    }
                    break;
                case "kno":
                    trefferChance = ((int) (Math.random()*100));
                    if (skill4Genauigkeit >= trefferChance){
                        range1 = (((skill4Kraft*spielerKno)/100)+((spielerAtk+spielerKno)/8)-(gegnerDef+gegnerKno));
                        range2 = ((int) Math.ceil(((((skill4Kraft*spielerKno)/100)+(spielerAtk+spielerKno)/8)-(gegnerDef+gegnerKno))*1.5));

                        if ((range1 < 0 )|(range2 == 0)){
                            range1 = 0;
                            range2 = 1;
                        } else if (range1 >= range2){
                            range2 = range1;
                            range2++;
                        }
                        angriff = rnd.nextInt(range1, range2);
                        spielerAngriff();
                    } else {
                        spielerVerfehlt();
                    }
                    break;
                case "wis":
                    trefferChance = ((int) (Math.random()*100));
                    if (skill4Genauigkeit >= trefferChance){
                        range1 = (((skill4Kraft*spielerWis)/100)+((spielerAtk+spielerWis)/8)-(gegnerDef+gegnerWis));
                        range2 = ((int) Math.ceil(((((skill4Kraft*spielerWis)/100)+(spielerAtk+spielerWis)/8)-(gegnerDef+gegnerWis))*1.5));
                        System.out.println(range1);
                        System.out.println(range2);
                        if ((range1 < 0 )|(range2 == 0)){
                            range1 = 0;
                            range2 = 1;
                        } else if (range1 >= range2){
                            range2 = range1;
                            range2++;
                        }
                        angriff = rnd.nextInt(range1, range2);
                        spielerAngriff();
                    } else {
                        spielerVerfehlt();
                    }
                    break;
            }
        });
        skillBtn5.addActionListener(e -> {
            switch (skill5Mod){
                case "str":
                    trefferChance = ((int) (Math.random()*100));
                    if (skill5Genauigkeit >= trefferChance){
                        range1 = (((skill5Kraft*spielerStr)/100)+((spielerAtk+spielerStr)/8)-(gegnerDef+gegnerStr));
                        range2 = ((int) Math.ceil(((((skill5Kraft*spielerStr)/100)+(spielerAtk+spielerStr)/8)-(gegnerDef+gegnerStr))*1.5));

                        if ((range1 < 0 )|(range2 == 0)){
                            range1 = 0;
                            range2 = 1;
                        } else if (range1 >= range2){
                            range2 = range1;
                            range2++;
                        }
                        angriff = rnd.nextInt(range1, range2);
                        spielerAngriff();
                    } else {
                        spielerVerfehlt();
                    }
                    break;
                case "dex":
                    trefferChance = ((int) (Math.random()*100));
                    if (skill5Genauigkeit >= trefferChance){
                        range1 = (((skill5Kraft*spielerDex)/100)+((spielerAtk+spielerDex)/8)-(gegnerDef+gegnerDex));
                        range2 = ((int) Math.ceil(((((skill5Kraft*spielerDex)/100)+(spielerAtk+spielerDex)/8)-(gegnerDef+gegnerDex))*1.5));

                        if ((range1 < 0 )|(range2 == 0)){
                            range1 = 0;
                            range2 = 1;
                        } else if (range1 >= range2){
                            range2 = range1;
                            range2++;
                        }
                        angriff = rnd.nextInt(range1, range2);
                        spielerAngriff();
                    } else {
                        spielerVerfehlt();
                    }
                    break;
                case "kno":
                    trefferChance = ((int) (Math.random()*100));
                    if (skill5Genauigkeit >= trefferChance){
                        range1 = (((skill5Kraft*spielerKno)/100)+((spielerAtk+spielerKno)/8)-(gegnerDef+gegnerKno));
                        range2 = ((int) Math.ceil(((((skill5Kraft*spielerKno)/100)+(spielerAtk+spielerKno)/8)-(gegnerDef+gegnerKno))*1.5));

                        if ((range1 < 0 )|(range2 == 0)){
                            range1 = 0;
                            range2 = 1;
                        } else if (range1 >= range2){
                            range2 = range1;
                            range2++;
                        }
                        angriff = rnd.nextInt(range1, range2);
                        spielerAngriff();
                    } else {
                        spielerVerfehlt();
                    }
                    break;
                case "wis":
                    trefferChance = ((int) (Math.random()*100));
                    if (skill5Genauigkeit >= trefferChance){
                        range1 = (((skill5Kraft*spielerWis)/100)+((spielerAtk+spielerWis)/8)-(gegnerDef+gegnerWis));
                        range2 = ((int) Math.ceil(((((skill5Kraft*spielerWis)/100)+(spielerAtk+spielerWis)/8)-(gegnerDef+gegnerWis))*1.5));
                        System.out.println(range1);
                        System.out.println(range2);
                        if ((range1 < 0 )|(range2 == 0)){
                            range1 = 0;
                            range2 = 1;
                        } else if (range1 >= range2){
                            range2 = range1;
                            range2++;
                        }
                        angriff = rnd.nextInt(range1, range2);
                        spielerAngriff();
                    } else {
                        spielerVerfehlt();
                    }
                    break;
            }
        });
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
            spielerMaxSp = Spieler.krieger.maxSp;
            spielerSp = spielerMaxSp;
            spielerAtk = Spieler.krieger.atk;
            spielerDef = Spieler.krieger.def;
            spielerExp = Spieler.krieger.exp;
            spielerLvl = Spieler.krieger.lvl;
            spielerStr = Spieler.krieger.str;
            spielerDex = Spieler.krieger.dex;
            spielerKno = Spieler.krieger.kno;
            spielerWis = Spieler.krieger.wis;
            spielerHpMod = Spieler.krieger.hpMod;
            spielerSpMod = Spieler.krieger.spMod;

            ImageIcon vorschauBild = new ImageIcon("res/Spieler/Krieger.png");
            vorschauStatsName.setText(spielerName);
            vorschauStatsLblLinks.setText("<html>HP: "+spielerHp+"/"+spielerMaxHp+"<br>SP: "+
                    spielerSp+"/"+spielerMaxSp+"<br>Atk: "+spielerAtk+"<br>Def: "+spielerDef+"</html>");
            vorschauStatsLblRechts.setText("<html><font color='#ff0000'>Str: </font>"+spielerStr+
                    "<font color='#3cb371'><br>Dex: </font>"+spielerDex+"<br><font color='#94d0ff'>Int: </font>"+
                    spielerKno+"<br><font color='#ffe400'>Wis: </font>"+spielerWis);
            vorschauLbl.setIcon(vorschauBild);



            skill1Name = StrSkills.angriffSkill.name;
            skill1Kraft = StrSkills.angriffSkill.kraft;
            skill1Genauigkeit = StrSkills.angriffSkill.genauigkeit;
            skill1Mod = StrSkills.angriffSkill.mod;
            skill1Bild = StrSkills.angriffSkill.bild;
            skillBtn1.setIcon(skill1Bild);
            skillBtn1.setToolTipText(StrSkills.angriffSkill.toolText);

            skill2Name = StrSkills.ansturmSkill.name;
            skill2Kraft = StrSkills.ansturmSkill.kraft;
            skill2Genauigkeit = StrSkills.ansturmSkill.genauigkeit;
            skill2Mod = StrSkills.ansturmSkill.mod;
            skill2Bild = StrSkills.ansturmSkill.bild;
            skillBtn2.setToolTipText(StrSkills.ansturmSkill.toolText);
            skillBtn2.setIcon(skill2Bild);

            skill3Name = StrSkills.blitzschlagSkill.name;
            skill3Kraft = StrSkills.blitzschlagSkill.kraft;
            skill3Genauigkeit = StrSkills.blitzschlagSkill.genauigkeit;
            skill3Mod = StrSkills.blitzschlagSkill.mod;
            skill3Bild = StrSkills.blitzschlagSkill.bild;
            skillBtn3.setToolTipText(StrSkills.blitzschlagSkill.toolText);
            skillBtn3.setIcon(skill3Bild);

            skill4Name = StrSkills.stampferSkill.name;
            skill4Kraft = StrSkills.stampferSkill.kraft;
            skill4Genauigkeit = StrSkills.stampferSkill.genauigkeit;
            skill4Mod = StrSkills.stampferSkill.mod;
            skill4Bild = StrSkills.stampferSkill.bild;
            skillBtn4.setToolTipText(StrSkills.stampferSkill.toolText);
            skillBtn4.setIcon(skill4Bild);

            skill5Name = StrSkills.krueppelnderSchlagSkill.name;
            skill5Kraft = StrSkills.krueppelnderSchlagSkill.kraft;
            skill5Genauigkeit = StrSkills.krueppelnderSchlagSkill.genauigkeit;
            skill5Mod = StrSkills.krueppelnderSchlagSkill.mod;
            skill5Bild = StrSkills.krueppelnderSchlagSkill.bild;
            skillBtn5.setToolTipText(StrSkills.krueppelnderSchlagSkill.toolText);
            skillBtn5.setIcon(skill5Bild);

            con.repaint();
        });
        auswahlJaegerBtn.addActionListener(e -> {
            spielerName = Spieler.jaeger.name;
            spielerMaxHp = Spieler.jaeger.maxHp;
            spielerHp = spielerMaxHp;
            spielerMaxSp = Spieler.jaeger.maxSp;
            spielerSp = spielerMaxSp;
            spielerAtk = Spieler.jaeger.atk;
            spielerDef = Spieler.jaeger.def;
            spielerExp = Spieler.jaeger.exp;
            spielerLvl = Spieler.jaeger.lvl;
            spielerStr = Spieler.jaeger.str;
            spielerDex = Spieler.jaeger.dex;
            spielerKno = Spieler.jaeger.kno;
            spielerWis = Spieler.jaeger.wis;
            spielerHpMod = Spieler.jaeger.hpMod;
            spielerSpMod = Spieler.jaeger.spMod;
            ImageIcon vorschauBild = new ImageIcon("res/Spieler/Jaeger.png");
            vorschauLbl.setIcon(vorschauBild);
            vorschauStatsName.setText(spielerName);
            vorschauStatsLblLinks.setText("<html>HP: "+spielerHp+"/"+spielerMaxHp+"<br>SP: "+
                    spielerSp+"/"+spielerMaxSp+"<br>Atk: "+spielerAtk+"<br>Def: "+spielerDef+"</html>");
            vorschauStatsLblRechts.setText("<html><font color='#ff0000'>Str: </font>"+spielerStr+
                    "<font color='#3cb371'><br>Dex: </font>"+spielerDex+"<br><font color='#94d0ff'>Int: </font>"+
                    spielerKno+"<br><font color='#ffe400'>Wis: </font>"+spielerWis);
            con.repaint();
        });
        auswahlMagierBtn.addActionListener(e -> {
            spielerName = Spieler.magier.name;
            spielerMaxHp = Spieler.magier.maxHp;
            spielerHp = spielerMaxHp;
            spielerMaxSp = Spieler.magier.maxSp;
            spielerSp = spielerMaxSp;
            spielerAtk = Spieler.magier.atk;
            spielerDef = Spieler.magier.def;
            spielerExp = Spieler.magier.exp;
            spielerLvl = Spieler.magier.lvl;
            spielerStr = Spieler.magier.str;
            spielerDex = Spieler.magier.dex;
            spielerKno = Spieler.magier.kno;
            spielerWis = Spieler.magier.wis;
            spielerHpMod = Spieler.magier.hpMod;
            spielerSpMod = Spieler.magier.spMod;
            ImageIcon vorschauBild = new ImageIcon("res/Spieler/Magier.png");
            vorschauLbl.setIcon(vorschauBild);
            vorschauStatsName.setText(spielerName);
            vorschauStatsLblLinks.setText("<html>HP: "+spielerHp+"/"+spielerMaxHp+"<br>SP: "+
                    spielerSp+"/"+spielerMaxSp+"<br>Atk: "+spielerAtk+"<br>Def: "+spielerDef+"</html>");
            vorschauStatsLblRechts.setText("<html><font color='#ff0000'>Str: </font>"+spielerStr+
                    "<font color='#3cb371'><br>Dex: </font>"+spielerDex+"<br><font color='#94d0ff'>Int: </font>"+
                    spielerKno+"<br><font color='#ffe400'>Wis: </font>"+spielerWis);
            con.repaint();
        });
        auswahlPriesterBtn.addActionListener(e -> {
            spielerName = Spieler.priester.name;
            spielerMaxHp = Spieler.priester.maxHp;
            spielerHp = spielerMaxHp;
            spielerMaxSp = Spieler.priester.maxSp;
            spielerSp = spielerMaxSp;
            spielerAtk = Spieler.priester.atk;
            spielerDef = Spieler.priester.def;
            spielerExp = Spieler.priester.exp;
            spielerLvl = Spieler.priester.lvl;
            spielerStr = Spieler.priester.str;
            spielerDex = Spieler.priester.dex;
            spielerKno = Spieler.priester.kno;
            spielerWis = Spieler.priester.wis;
            spielerHpMod = Spieler.priester.hpMod;
            spielerSpMod = Spieler.priester.spMod;
            ImageIcon vorschauBild = new ImageIcon("res/Spieler/Priester.png");
            vorschauLbl.setIcon(vorschauBild);
            vorschauStatsName.setText(spielerName);
            vorschauStatsLblLinks.setText("<html>HP: "+spielerHp+"/"+spielerMaxHp+"<br>SP: "+
                    spielerSp+"/"+spielerMaxSp+"<br>Atk: "+spielerAtk+"<br>Def: "+spielerDef+"</html>");
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
            spielerMaxSp = Spieler.paladin.maxSp;
            spielerSp = spielerMaxSp;
            spielerAtk = Spieler.paladin.atk;
            spielerDef = Spieler.paladin.def;
            spielerExp = Spieler.paladin.exp;
            spielerLvl = Spieler.paladin.lvl;
            spielerStr = Spieler.paladin.str;
            spielerDex = Spieler.paladin.dex;
            spielerKno = Spieler.paladin.kno;
            spielerWis = Spieler.paladin.wis;
            spielerHpMod = Spieler.paladin.hpMod;
            spielerSpMod = Spieler.paladin.spMod;
            ImageIcon vorschauBild = new ImageIcon("res/Spieler/Paladin.png");
            vorschauLbl.setIcon(vorschauBild);
            vorschauStatsName.setText(spielerName);
            vorschauStatsLblLinks.setText("<html>HP: "+spielerHp+"/"+spielerMaxHp+"<br>SP: "+
                    spielerSp+"/"+spielerMaxSp+"<br>Atk: "+spielerAtk+"<br>Def: "+spielerDef+"</html>");
            vorschauStatsLblRechts.setText("<html><font color='#ff0000'>Str: </font>"+spielerStr+
                    "<font color='#3cb371'><br>Dex: </font>"+spielerDex+"<br><font color='#94d0ff'>Int: </font>"+
                    spielerKno+"<br><font color='#ffe400'>Wis: </font>"+spielerWis);
            con.repaint();
        });
        auswahlNinjaBtn.addActionListener(e -> {
            spielerName = Spieler.ninja.name;
            spielerMaxHp = Spieler.ninja.maxHp;
            spielerHp = spielerMaxHp;
            spielerMaxSp = Spieler.ninja.maxSp;
            spielerSp = spielerMaxSp;
            spielerAtk = Spieler.ninja.atk;
            spielerDef = Spieler.ninja.def;
            spielerExp = Spieler.ninja.exp;
            spielerLvl = Spieler.ninja.lvl;
            spielerStr = Spieler.ninja.str;
            spielerDex = Spieler.ninja.dex;
            spielerKno = Spieler.ninja.kno;
            spielerWis = Spieler.ninja.wis;
            spielerHpMod = Spieler.ninja.hpMod;
            spielerSpMod = Spieler.ninja.spMod;
            ImageIcon vorschauBild = new ImageIcon("res/Spieler/Ninja.png");
            vorschauLbl.setIcon(vorschauBild);
            vorschauStatsName.setText(spielerName);
            vorschauStatsLblLinks.setText("<html>HP: "+spielerHp+"/"+spielerMaxHp+"<br>SP: "+
                    spielerSp+"/"+spielerMaxSp+"<br>Atk: "+spielerAtk+"<br>Def: "+spielerDef+"</html>");
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
            mapInitialisieren();
            gegnerInitialisieren();
            btnInitialisieren();
            skillLeiste();
            charakterAuswahl();
            adminFenster();
        }
    }
    public static void delay(int ms){
        Timer timer = new Timer(ms, e -> {
            spielPanel.setVisible(false);
            spielerStatsPanel.setVisible(false);
            spielerProgressPanel.setVisible(false);
            skillBtnPanel.setVisible(false);
            textAreaPanel.setVisible(false);
            optionenPanel.setVisible(false);
            gameOverPanel.setVisible(true);
            gameOverBtnPanel.setVisible(true);
        });
        timer.setRepeats(false);
        timer.start();
    }
    public static void gameOverScreen(){
        delay(1000);
        gameOverPanel = new JPanel();
        gameOverBtnPanel = new JPanel();
        JLabel gameOverLbl = new JLabel("Game Over");
        JButton gameOverBtn = new JButton("Neustart");
        gameOverLbl.setFont(titelFont);
        gameOverPanel.setBounds(100, 50, 600, 250);
        gameOverPanel.setBounds(100, 50, 600, 250);
        gameOverPanel.setBorder(BorderFactory.createLineBorder(Color.WHITE,2,true));
        gameOverBtnPanel.setBounds(300, 400, 200, 100);
        gameOverBtnPanel.setBorder(BorderFactory.createLineBorder(Color.WHITE, 2, true));
        gameOverPanel.setVisible(false);
        gameOverBtnPanel.setVisible(false);

        gameOverBtn.setFont(startBtnFont);
        gameOverBtn.setForeground(Color.WHITE);

        SpringLayout layout = new SpringLayout();
        layout.putConstraint(SpringLayout.HORIZONTAL_CENTER, gameOverBtn, 0, SpringLayout.HORIZONTAL_CENTER, gameOverBtnPanel);
        layout.putConstraint(SpringLayout.VERTICAL_CENTER, gameOverBtn, 0, SpringLayout.VERTICAL_CENTER, gameOverBtnPanel);
        gameOverBtnPanel.add(gameOverBtn);
        gameOverBtnPanel.setLayout(layout);

        gameOverPanel.add(gameOverLbl);
        con.add(gameOverBtnPanel);
        con.add(gameOverPanel);
        mainFrame.pack();
        con.setVisible(true);
        con.revalidate();
        con.repaint();

        gameOverBtn.addActionListener(e -> {
            mainFrame.dispose();
            adminFrame.dispose();
            logFrame.dispose();
            new Main();
        });
    }
}
