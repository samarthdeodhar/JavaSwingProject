import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.IOException;
import javax.swing.*;
import javax.sound.sampled.*;
public class QuestionsBackgroundPanel extends  JPanel {
    private Image questionsImage;
    private int questionsImage_width, questionsImage_height;
    public QuestionsBackgroundPanel () {
        ImageIcon i = new ImageIcon("src/HistoryGameBackground.jpg");
        questionsImage = i.getImage();
        // Image 1
        questionsImage_width = questionsImage.getWidth(null);
        questionsImage_height = questionsImage.getHeight(null);

    }


    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.drawImage(questionsImage, 0, 0, null);
    }

}
