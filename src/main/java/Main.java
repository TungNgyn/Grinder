import com.formdev.flatlaf.FlatDarculaLaf;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main {
    private static JFrame adminFrame, mainFrame, logFrame;
    private static JPanel titelPanel, titelStartBtnPanel, spielPanel, skillBtnPanel,
            textAreaPanel, spielerStatsPanel, auswahlBtnPanel, optionenPanel, logPanel,
            logBtnPanel;
    private static JTextArea mainTextArea;
    private static JLabel titelLbl;
    private static JButton titelStartBtn, logBtn, skillBtn1, skillBtn2, skillBtn3,
            skillBtn4, skillBtn5;
    private static Container con, conLog;
    private static JScrollPane logScrollPane, textAreaScroll;
    static Font titelFont, normalFont, startBtnFont;

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

        titelPanel = new JPanel();
        titelPanel.setBounds(100,50,600,250);
        titelPanel.setBorder(BorderFactory.createLineBorder(Color.WHITE, 2, true));
        titelLbl = new JLabel("dahdahad");
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
        logScrollPane = new JScrollPane();
        logScrollPane.setBounds(10,10,450,280);

        logBtnPanel = new JPanel();
        logBtnPanel.setBounds(17,300,450,50);
        logBtnPanel.setBorder(BorderFactory.createLineBorder(Color.WHITE,2,true));

        logPanel.add(logScrollPane);
        conLog = logFrame.getContentPane();
        conLog.add(logBtnPanel);
        conLog.add(logPanel);
        logFrame.pack();
        //endregion

        titelStartBtn.addActionListener(tsHandler);
    }
    public static void adminFenster(){
        adminFrame = new JFrame("Admin");
        adminFrame.setPreferredSize(new Dimension(400,300));
        adminFrame.setResizable(false);
        adminFrame.pack();
        adminFrame.setVisible(true);
    }
    public static void spielFenster(){
        //region Layout
        spielPanel = new JPanel();
        spielPanel.setBounds(20,20,500,300);
        spielPanel.setBorder(BorderFactory.createLineBorder(Color.WHITE,2,true));

        textAreaPanel = new JPanel();
        textAreaPanel.setBounds(20,330,500,140);
        textAreaPanel.setBorder(BorderFactory.createLineBorder(Color.WHITE,2,true));

        mainTextArea = new JTextArea();
        mainTextArea.setLineWrap(true);
        mainTextArea.setEditable(false);
        mainTextArea.setPreferredSize(new Dimension(490,200));

        textAreaScroll = new JScrollPane(mainTextArea);
//        textAreaScroll.setPreferredSize(new Dimension(500,130));
//        textAreaScroll.setBounds(0,0,500,130);

        skillBtnPanel = new JPanel();
        skillBtnPanel.setLayout(new GridLayout());
        skillBtnPanel.setBounds(20,480, 500,60);
        skillBtnPanel.setBorder(BorderFactory.createLineBorder(Color.WHITE,2,true));

        spielerStatsPanel = new JPanel();
        spielerStatsPanel.setBounds(550,90,215,230);
        spielerStatsPanel.setBorder(BorderFactory.createLineBorder(Color.WHITE,2,true));

        auswahlBtnPanel = new JPanel();
        auswahlBtnPanel.setBounds(550,330,215,210);
        auswahlBtnPanel.setBorder(BorderFactory.createLineBorder(Color.WHITE,2,true));

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
        logBtn.addActionListener(e -> {
            logFrame.setVisible(true);
        });

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

        titelPanel.setVisible(false);
        titelStartBtnPanel.setVisible(false);
        textAreaPanel.add(textAreaScroll);
        con.add(spielerStatsPanel);
        con.add(spielPanel);
        con.add(skillBtnPanel);
        con.add(textAreaPanel);
        con.add(auswahlBtnPanel);
        con.add(optionenPanel);
        con.setVisible(true);
        con.repaint();
    }
    public class TitleScreenHandler implements ActionListener{
        public void actionPerformed(ActionEvent e){
            adminFenster();
            spielFenster();
        }
    }
}
