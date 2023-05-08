import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.IOException;
import javax.swing.*;
import javax.sound.sampled.*;
public class HistoryTriviaPanel extends JPanel implements ActionListener {
    static HistoryTriviaPanel audioPlayer2;
     static int soundTrack = 0;
    Clip WelcomeSoundtrack;
    Clip subwooferLullaby, moogCity, moogCity2;

    Clip minecraft;

    JLabel selectOptionMessage;

    private int easyTimerLength;

    private int easyTimerValue;

    private int image = 0;
    private int mediumTimerLength;

    private int mediumTimerValue;

    private int hardTimerLength;

    private int hardTimerValue;
    JPanel cards;

    JPanel gameMode;

    InstructionsBackgroundPanel instructionsPanel;
    JPanel selectOptionPanel;

    JPanel levelPanel;

    JLabel HistoryMania;

    JPanel ResultsPanel;

    JPanel TimeRunoutPanel;

    JButton Easy, Medium, Hard;

    Boolean getCorrect = false;

    private Image welcomeImage;

    private int bg_width, bg1_width, bg2_width, bg3_width;

    private int bg_height, bg1_height, bg2_height, bg3_height;

    int qNum = 0;

    Timer easyTimer, mediumTimer, hardTimer;

    JLabel eTimer, mTimer, hTimer;

    int NumberCorrect = 0;

    Timer tm, tm2;

    public int counter = 0;

    int set1 = 1, set2 = 1, set3 = 1, set4 = 1, set5 = 1, set6 = 1, set7 = 1, set8 = 1, set9 = 1;

    private JButton b1, b2, b3, b4, Next, MediumNext, HardNext, start, instruc, quit, c1, c2, c3, c4, d1, d2, d3, d4, Continue, easyRestart, mediumRestart, hardRestart;

    private JLabel Questions, MediumQuestions, HardQuestions;

    JLabel TimeRunoutMessage;

    String[] EasyQuestion = {"1.) What exact moment did Napoleon take his last poop before he died?",
            "2.) How many soldiers were in Alexander the Great's army?", "3.) Who was the first U.S. president?", "4.) Which country did not fight in World War 2?", "5.) What did Paul Revere shout on his midnight ride?", "6.) Who was Christopher Columbus? ", ""};
    String[] EasyOption1 = {"5:34 a.m.", "1000", "Jimmy Neutron", "Italy", "I need to do meh homework", "Italian Explorer", ""};
    String[] EasyOption2 = {"4:37 p.m.", "10", "George Washington", "Japan", "'He spews a mighty fireball...'", "Spanish Immigrant", ""};
    String[] EasyOption3 = {"4:37 a.m.", "1000000", "Brad Pitt", "Sudan", "'THAR SHE BLOWS!!!!'", "Video Game Developer", ""};
    String[] EasyOption4 = {"7:89 p.m.", "Bajillion", "Genghis Khan", "U.S.", "'The British are coming!!!'", "Poet", ""};

    String[] MediumQuestion = {"What year was the World Health Organization founded?", "Who was the 3rd U.S. president?", "Who's assassination started World War 1?", "Which Egyptian Pharaoh had over 100 children?", "What was the murder of over 6 million jews in WWII called?", ""};
    String[] MediumOption1 = {"1963", "George Adams", "Abraham Lincoln", "Bezos III", "The Holocaust",};
    String[] MediumOption2 = {"1987", "John Washington", "Franz Ferdinand", "Cleopatra", "Das Semicide",};
    String[] MediumOption3 = {"1948", "Andrew Jackson", "Warren Bufett", "Ramses II", "9/11",};
    String[] MediumOption4 = {"2002", "Thomas Jefferson", "Quandale Dingle", "Tutankhamen", "Death by Gas",};

    String[] HardQuestion = {"What year was the Declaration of Independence signed?", "Which of these countries is the newest?", "Which of of these people was a Cuban Dicator?", "What year did Iowa become a U.S. state?"};
    String[] HardOption1 = {"1775", "Romania", "Emelio Portes Gil", "1877"};
    String[] HardOption2 = {"1774", "Trinidad & Tobago", "Ernesto de la Cruz", "1799"};
    String[] HardOption3 = {"1776", "South Sudan", "Fidel Alejandro Castro Ruz", "1846"};
    String[] HardOption4 = {"1777", "Zanzibar", "Antonio de Padua María Severino López de Santa Anna y Pérez de Lebrón", "1847"};

    private int[] EasyAnswers = {2, 3, 2, 3, 4, 1};

    private int[] MediumAnswers = {1, 4, 2, 3, 1};

    private int[] HardAnswers = {2, 2, 3, 1, 4};

    //Constructor
    public HistoryTriviaPanel() throws UnsupportedAudioFileException,
            IOException, LineUnavailableException {
        //Image 0
        ImageIcon i = new ImageIcon("src/HistoryGameBackgroundFinal.jpg");
        welcomeImage = i.getImage();
        // Image 1
        bg_width = welcomeImage.getWidth(null);
        bg_height = welcomeImage.getHeight(null);

        //Initiating the timers which will
        easyTimerLength = 1000;
        easyTimerValue = 15;
        easyTimer = new Timer(easyTimerLength, this);
        mediumTimerLength = 1000;
        mediumTimerValue = 15;
        mediumTimer = new Timer(mediumTimerLength, this);
        hardTimerLength = 1000;
        hardTimerValue = 15;
        hardTimer = new Timer(hardTimerLength, this);

        AudioInputStream audioInputStream;
        String filePath = "src/NokiaArabRingtone.wav";
        audioInputStream = AudioSystem.getAudioInputStream(new File(filePath).getAbsoluteFile());
        // create clip reference
        WelcomeSoundtrack = AudioSystem.getClip();
        // open audioInputStream to the clip
        WelcomeSoundtrack.open(audioInputStream);

        AudioInputStream audioInputStream2;
        String filePath2 = "src/SubwooferLullaby.wav";
        audioInputStream2 = AudioSystem.getAudioInputStream(new File(filePath2).getAbsoluteFile());
        subwooferLullaby = AudioSystem.getClip();
        subwooferLullaby.open(audioInputStream2);


    }

    public void playSound() {
        WelcomeSoundtrack.loop(Clip.LOOP_CONTINUOUSLY);
    }

    public void playSound2 () {
        subwooferLullaby.loop(Clip.LOOP_CONTINUOUSLY);
    }

    //Action Performed - PERFORMS the game
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == easyTimer) {

            easyTimerValue--;
            eTimer.setText(easyTimerValue + ":00");
        }
        if (e.getSource() == mediumTimer) {
            mediumTimerValue--;
            mTimer.setText(mediumTimerValue + ":00");
        }
        if (e.getSource() == start) {
            image = 1;
            CardLayout cl = (CardLayout) (cards.getLayout());
            cl.show(cards, "levels");
        }
        else if (e.getSource() == instruc) {
            CardLayout cl = (CardLayout) (cards.getLayout());
            cl.show(cards, "inst");
        }
        else if (e.getSource() == quit) {
            System.exit(0);
        }
        else if (e.getSource() == Easy) {
            soundTrack = 1;
            CardLayout cl = (CardLayout) (cards.getLayout());
            cl.show(cards, "EasyPanel");
            easyTimer.start();
            Next.setEnabled(false);
            audioPlayer2.playSound2();

        }
        else if (e.getSource() == Medium) {
            soundTrack = 2;
            CardLayout cl = (CardLayout) (cards.getLayout());
            cl.show(cards, "MediumPanel");
            mediumTimer.start();
        }

        else if (e.getSource() == Hard) {
            soundTrack = 3;
            CardLayout cl = (CardLayout) (cards.getLayout());
            cl.show(cards, "HardPanel");
            hardTimer.start();
        }
        else if (e.getSource() == b1) {
            if (EasyAnswers[qNum] == 1) {
                NumberCorrect++;
                b1.setBackground(Color.GREEN);
                b1.setOpaque(true);
                easyTimer.stop();
                Next.setEnabled(true);
            } else {
                b1.setBackground(Color.RED);
                b1.setOpaque(true);
                easyTimer.stop();
                Next.setEnabled(true);
            }
        }

        else if (e.getSource() == b2) {
            if (EasyAnswers[qNum] == 2) {
                NumberCorrect++;
                b2.setBackground(Color.GREEN);
                b2.setOpaque(true);
                easyTimer.stop();
                Next.setEnabled(true);
            } else {
                b2.setBackground(Color.RED);
                b2.setOpaque(true);
                easyTimer.stop();
                Next.setEnabled(true);
            }
        }
        else if (e.getSource() == b3) {
            if (EasyAnswers[qNum] == 3) {
                NumberCorrect++;
                b3.setBackground(Color.GREEN);
                b3.setOpaque(true);
                easyTimer.stop();
                Next.setEnabled(true);
            } else {
                b3.setBackground(Color.RED);
                b3.setOpaque(true);
                easyTimer.stop();
                Next.setEnabled(true);
            }
        }

        else if (e.getSource() == b4) {
            if (EasyAnswers[qNum] == 4) {
                NumberCorrect++;
                b4.setBackground(Color.GREEN);
                b4.setOpaque(true);
                easyTimer.stop();
                Next.setEnabled(true);
            } else {
                b4.setBackground(Color.RED);
                b4.setOpaque(true);
                easyTimer.stop();
                Next.setEnabled(true);
            }
        }
        if (qNum == 5 && e.getSource() == Next) {
            easyTimer.stop();
            JLabel Result = new JLabel(NumberCorrect + "/6", 0);
            ResultsPanel.add(Result);
            CardLayout cl = (CardLayout) (cards.getLayout());
            cl.show(cards, "Score");
        }
        if (e.getSource() == Continue) {
            CardLayout cl = (CardLayout) (cards.getLayout());
            cl.show(cards, "EasyPanel");
        }
        if (easyTimerValue == 0 && qNum < 5 || mediumTimerValue == 0) {
            easyTimer.stop();
            mediumTimer.stop();
            CardLayout cl = (CardLayout) (cards.getLayout());
            cl.show(cards, "ranOutOfTime");
        }
        if (e.getSource() == Next && b1.getBackground() == null && b2.getBackground() == null && b3.getBackground() == null && b4.getBackground() == null) {
            easyTimer.stop();
            CardLayout cl = (CardLayout) (cards.getLayout());
            cl.show(cards, "clickOption");
        } else if (e.getSource() == Next) {
            qNum++;
            Questions.setText(EasyQuestion[qNum]);
            b1.setText(EasyOption1[qNum]);
            b2.setText(EasyOption2[qNum]);
            b3.setText(EasyOption3[qNum]);
            b4.setText(EasyOption4[qNum]);
            b1.setEnabled(true);
            b2.setEnabled(true);
            b3.setEnabled(true);
            b4.setEnabled(true);
            b1.setBackground(null);
            b2.setBackground(null);
            b3.setBackground(null);
            b4.setBackground(null);
            easyTimerValue = (15 - (qNum * 2));
            eTimer.setText(easyTimerValue + ":00");
            easyTimer.start();
            Next.setEnabled(false);
        }
        if (e.getSource() == easyRestart) {
            qNum = 0;
            NumberCorrect = 0;
            Questions.setText(EasyQuestion[qNum]);
            b1.setText(EasyOption1[qNum]);
            b2.setText(EasyOption2[qNum]);
            b3.setText(EasyOption3[qNum]);
            b4.setText(EasyOption4[qNum]);
            b1.setEnabled(true);
            b2.setEnabled(true);
            b3.setEnabled(true);
            b4.setEnabled(true);
            b1.setBackground(null);
            b2.setBackground(null);
            b3.setBackground(null);
            b4.setBackground(null);
            easyTimerValue = 15;
            eTimer.setText(easyTimerValue + ":00");
            CardLayout cl = (CardLayout) (cards.getLayout());
            cl.show(cards, "EasyPanel");
            easyTimer.start();
        }
        if (e.getSource() == b1 || e.getSource() == b2 || e.getSource() == b3 || e.getSource() == b4) {
            b1.setEnabled(false);
            b2.setEnabled(false);
            b3.setEnabled(false);
            b4.setEnabled(false);
        }
        //Actionperformed if user clicks next in the medium level
        else if (e.getSource() == c1) {
            if (MediumAnswers[qNum] == 1) {
                NumberCorrect++;
                c1.setBackground(Color.GREEN);
                c1.setOpaque(true);
                mediumTimer.stop();
            } else {
                c1.setBackground(Color.RED);
                c1.setOpaque(true);
                mediumTimer.stop();
            }
        } else if (e.getSource() == c2) {
            if (MediumAnswers[qNum] == 2) {
                NumberCorrect++;
                c2.setBackground(Color.GREEN);
                c2.setOpaque(true);
                mediumTimer.stop();
            } else {
                c2.setBackground(Color.RED);
                c2.setOpaque(true);
                mediumTimer.stop();
            }
        } else if (e.getSource() == c3) {
            if (MediumAnswers[qNum] == 3) {
                NumberCorrect++;
                c3.setBackground(Color.GREEN);
                c3.setOpaque(true);
                mediumTimer.stop();
            } else {
                c3.setBackground(Color.RED);
                c3.setOpaque(true);
                mediumTimer.stop();
            }
        } else if (e.getSource() == c4) {
            if (MediumAnswers[qNum] == 4) {
                NumberCorrect++;
                c4.setBackground(Color.GREEN);
                c4.setOpaque(true);
                mediumTimer.stop();
            } else {
                c4.setBackground(Color.RED);
                c4.setOpaque(true);
                mediumTimer.stop();
            }
        }
        if (qNum == 4 && e.getSource() == MediumNext) {
            JLabel Result = new JLabel(NumberCorrect + "/5", 0);
            ResultsPanel.add(Result);
            CardLayout cl = (CardLayout) (cards.getLayout());
            cl.show(cards, "Score");
        } else if (e.getSource() == MediumNext) {
            qNum++;
            MediumQuestions.setText(MediumQuestion[qNum]);
            c1.setText(MediumOption1[qNum]);
            c2.setText(MediumOption2[qNum]);
            c3.setText(MediumOption3[qNum]);
            c4.setText(MediumOption4[qNum]);
            c1.setEnabled(true);
            c2.setEnabled(true);
            c3.setEnabled(true);
            c4.setEnabled(true);
            c1.setBackground(null);
            c2.setBackground(null);
            c3.setBackground(null);
            c4.setBackground(null);
            mediumTimerValue = (15 - (qNum * 2));
            mTimer.setText(mediumTimerValue + ":00");
            mediumTimer.start();
        }
        if (e.getSource() == mediumRestart) {
            qNum = 0;
            NumberCorrect = 0;
            MediumQuestions.setText(MediumQuestion[qNum]);
            c1.setText(MediumOption1[qNum]);
            c2.setText(MediumOption2[qNum]);
            c3.setText(MediumOption3[qNum]);
            c4.setText(MediumOption4[qNum]);
            c1.setEnabled(true);
            c2.setEnabled(true);
            c3.setEnabled(true);
            c4.setEnabled(true);
            c1.setBackground(null);
            c2.setBackground(null);
            c3.setBackground(null);
            c4.setBackground(null);
            mediumTimerValue = 15;
            mTimer.setText(mediumTimerValue + ":00");
            CardLayout cl = (CardLayout) (cards.getLayout());
            cl.show(cards, "MediumPanel");
            mediumTimer.start();
        }
        if (e.getSource() == c1 || e.getSource() == c2 || e.getSource() == c3 || e.getSource() == c4) {
            c1.setEnabled(false);
            c2.setEnabled(false);
            c3.setEnabled(false);
            c4.setEnabled(false);
        }
        //Actionperformed if user clicks hard level
        //Actionperformed if user clicks next in the medium level
        else if (e.getSource() == d1) {
            if (EasyAnswers[qNum] == 1) {
                NumberCorrect++;
                d1.setBackground(Color.GREEN);
                d1.setOpaque(true);
            } else {
                d1.setBackground(Color.RED);
                d1.setOpaque(true);
            }
        } else if (e.getSource() == d2) {
            if (EasyAnswers[qNum] == 2) {
                NumberCorrect++;
                d2.setBackground(Color.GREEN);
                d2.setOpaque(true);
            } else {
                d2.setBackground(Color.RED);
                d2.setOpaque(true);
            }
        } else if (e.getSource() == d3) {
            if (EasyAnswers[qNum] == 3) {
                NumberCorrect++;
                d3.setBackground(Color.GREEN);
                d3.setOpaque(true);
            } else {
                d3.setBackground(Color.RED);
                d3.setOpaque(true);
            }
        } else if (e.getSource() == d4) {
            if (EasyAnswers[qNum] == 4) {
                NumberCorrect++;
                d4.setBackground(Color.GREEN);
                d4.setOpaque(true);
            } else {
                d4.setBackground(Color.RED);
                d4.setOpaque(true);
            }
        } else if (e.getSource() == HardNext) {
            qNum++;
            Questions.setText(HardQuestion[qNum]);
            d1.setText(HardOption1[qNum]);
            d2.setText(HardOption2[qNum]);
            d3.setText(HardOption3[qNum]);
            d4.setText(HardOption4[qNum]);
            d1.setEnabled(true);
            d2.setEnabled(true);
            d3.setEnabled(true);
            d4.setEnabled(true);
            d1.setBackground(null);
            d2.setBackground(null);
            d3.setBackground(null);
            d4.setBackground(null);
        }
        if (e.getSource() == d1 || e.getSource() == d2 || e.getSource() == d3 || e.getSource() == d4) {
            d1.setEnabled(false);
            d2.setEnabled(false);
            d3.setEnabled(false);
            d4.setEnabled(false);
        }
    }

    public void setupWindow() {
        JFrame HistoryTriviaFrame = new JFrame("History Trivia");
        levelPanel = new JPanel();
        // JPanel welcome = new JPanel();
        JPanel welcome = this;
        setLayout(null);

        QuestionsBackgroundPanel EasyPanel = new QuestionsBackgroundPanel();
        EasyPanel.setLayout(null);
        QuestionsBackgroundPanel MediumPanel = new QuestionsBackgroundPanel();
        MediumPanel.setLayout(null);
        JPanel HardPanel = new JPanel();
        HardPanel.setLayout(null);
        ResultsPanel = new JPanel();
        TimeRunoutPanel = new JPanel();
        instructionsPanel = new InstructionsBackgroundPanel();
        selectOptionPanel = new JPanel();
        //selectOptionPanel is a message that tells the player to first select an answer, then hit next.
        selectOptionMessage = new JLabel("Please select an answer first before clicking next. Press continue to go back to the game.");
        selectOptionPanel.add(selectOptionMessage);
        Continue = new JButton("Continue");
        Continue.addActionListener(this);
        selectOptionPanel.add(Continue);
        // Put a button in welcome panel
        start = new JButton();
        start.setOpaque(false);
        start.setContentAreaFilled(false);
        start.setBorderPainted(false);
        start.setBounds(400, 367, 160, 50);
        start.addActionListener(this);
        welcome.add(start);


        //adding instructions button
        instruc = new JButton();
        instruc.addActionListener(this);
        instruc.setBounds(365, 434, 230, 47);
        instruc.setOpaque(false);
        instruc.setContentAreaFilled(false);
        instruc.setBorderPainted(false);
        welcome.add(instruc);


        //adding quit button to welcome panel
        quit = new JButton();
        quit.addActionListener(this);
        quit.setBounds(365, 501, 230, 47);
        quit.setOpaque(false);
        quit.setContentAreaFilled(false);
        quit.setBorderPainted(false);
        welcome.add(quit);



        //Adding JButtons Easy, Medium, Hard to the panel that shows which difficulty level you want to choose
        Easy = new JButton("Easy");
        Easy.addActionListener(this);
        levelPanel.add(Easy);
        Medium = new JButton("Medium");
        Medium.addActionListener(this);
        levelPanel.add(Medium);
        Hard = new JButton("Hard");
        Hard.addActionListener(this);
        levelPanel.add(Hard);

        //Setting buttons for Easy level
        Questions = new JLabel(EasyQuestion[0]);
        Questions.setBounds(50, 100, 1000, 50);
        EasyPanel.add(Questions);



        Next = new JButton("Next");

        Next.setBackground(Color.ORANGE);

        Next.setOpaque(true);

        Next.addActionListener(this);

        Next.setBounds(675, 100, 100, 55);



        EasyPanel.add(Next);

        eTimer = new JLabel(easyTimerValue + ":00");

        eTimer.setBounds(620, 100, 100, 55);

        EasyPanel.add(eTimer);


        b1 = new JButton(EasyOption1[0]);
        b1.setBounds(170, 200, 300, 175);
        b1.addActionListener(this);
        EasyPanel.add(b1);

        b2 = new JButton(EasyOption2[0]);
        b2.setBounds(480, 200, 300, 175);
        b2.addActionListener(this);
        EasyPanel.add(b2);

        b3 = new JButton(EasyOption3[0]);
        b3.setBounds(170, 385, 300, 175);
        b3.addActionListener(this);
        EasyPanel.add(b3);

        b4 = new JButton(EasyOption4[0]);
        b4.setBounds(480, 385, 300, 175);
        b4.addActionListener(this);
        EasyPanel.add(b4);


        //Setting buttons for Medium level

        MediumQuestions = new JLabel(MediumQuestion[0]);
        MediumPanel.add(MediumQuestions);
        MediumNext = new JButton("Next");
        MediumNext.setBackground(Color.ORANGE);
        MediumNext.setOpaque(true);
        MediumNext.addActionListener(this);
        MediumNext.setBounds(200, 40, 100, 55);


        MediumPanel.add(MediumNext);

        mTimer = new JLabel(mediumTimerValue + ":00");
        mTimer.setBounds(100, 40, 100, 55);

        MediumPanel.add(mTimer);


        c1 = new JButton(MediumOption1[0]);
        c1.addActionListener(this);
        c1.setBounds(170, 200, 300, 175);
        MediumPanel.add(c1);

        c2 = new JButton(MediumOption2[0]);
        c2.addActionListener(this);
        c2.setBounds(480, 200, 300, 175);
        MediumPanel.add(c2);

        c3 = new JButton(MediumOption3[0]);
        c3.addActionListener(this);
        c3.setBounds(170, 385, 300, 175);
        MediumPanel.add(c3);

        c4 = new JButton(MediumOption4[0]);
        c4.addActionListener(this);
        c4.setBounds(480, 385, 300, 175);
        MediumPanel.add(c4);

        //Setting buttons for Hard level
        HardPanel.setLayout(new GridLayout(3, 3));
        HardNext = new JButton("Next");
        HardNext.addActionListener(this);
        HardNext.setBackground(Color.ORANGE);
        HardPanel.add(HardNext);
        d1 = new JButton(HardOption1[0]);
        d1.addActionListener(this);
        HardPanel.add(d1);
        d2 = new JButton(HardOption2[0]);
        d2.addActionListener(this);
        HardPanel.add(d2);
        d3 = new JButton(HardOption3[0]);
        d3.addActionListener(this);
        HardPanel.add(d3);
        d4 = new JButton(HardOption4[0]);
        d4.addActionListener(this);
        HardPanel.add(d4);
        TimeRunoutMessage = new JLabel("UH OH! YOU RAN OUT OF TIME. YOU CAN EITHER EXIT THE GAME, OR TRY AGAIN BY HITTING RESTART!");
        TimeRunoutPanel.add(TimeRunoutMessage);
        easyRestart = new JButton("Restart");
        easyRestart.addActionListener(this);
        TimeRunoutPanel.add(easyRestart);
        JButton INSTRUCTIONS;
        INSTRUCTIONS = new JButton("Instructions: Choose your game level: "
                + "\n Easy, Medium, Hard. When selected, your game will start.");
        instructionsPanel.setLayout(new GridLayout(3, 3));
        instructionsPanel.add(INSTRUCTIONS);
        //Setting up score panel
        cards = new JPanel(new CardLayout());
        cards.add(welcome, "welcome");
        cards.add(EasyPanel, "EasyPanel");
        cards.add(MediumPanel, "MediumPanel");
        cards.add(HardPanel, "HardPanel");
        cards.add(ResultsPanel, "Score");
        cards.add(instructionsPanel, "inst");
        cards.add(levelPanel, "levels");
        cards.add(TimeRunoutPanel, "ranOutOfTime");
        cards.add(selectOptionPanel, "clickOption");
        HistoryTriviaFrame.add(cards);
        HistoryTriviaFrame.setSize(959, 600);
        HistoryTriviaFrame.setLocationRelativeTo(null);
        HistoryTriviaFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        HistoryTriviaFrame.setVisible(true);
    }

    public int getWidth() {
        return bg_width;
    }

    public int getHeight() {

        return bg_height;

    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.drawImage(welcomeImage, 0, 0, null);
    }

    public  static  void main(String[] args) {
        //HistoryTriviaPanel fw = new HistoryTriviaPanel();
        //  fw.setupWindow();
        try {

            if (soundTrack == 0) {
                HistoryTriviaPanel audioPlayer = new HistoryTriviaPanel();
                audioPlayer.setupWindow();
                audioPlayer.playSound();
            }
            else if (soundTrack == 1) {
                audioPlayer2 = new HistoryTriviaPanel();
                audioPlayer2.setupWindow();


            }

        } catch (Exception ex) {
            System.out.println("Error with playing sound. Most likely the file is not present.");
            ex.printStackTrace();
        }
    }
}
