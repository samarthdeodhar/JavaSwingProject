import javax.swing.*;
import java.awt.*;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.IOException;
import javax.swing.*;
import javax.sound.sampled.*;
public class InstructionsBackgroundPanel extends JPanel{

        private Image instructionsImage;
        private int instructionsImage_width, instructionsImage_height;
        public InstructionsBackgroundPanel () {
            ImageIcon i = new ImageIcon("src/HistoryGameBackground.jpg");
            instructionsImage = i.getImage();
            // Image 1
            instructionsImage_width = instructionsImage.getWidth(null);
            instructionsImage_height = instructionsImage.getHeight(null);

        }


        public void paintComponent(Graphics x) {
            super.paintComponent(x);
            Graphics2D d2d = (Graphics2D) x;
            d2d.drawImage(instructionsImage, 0, 0, null);
        }
    }


