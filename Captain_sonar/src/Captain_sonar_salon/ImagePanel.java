package Captain_sonar_salon;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.JPanel;

public class ImagePanel extends JPanel {
 
    private Image img;
     
    public ImagePanel(Image img){
        this.img = img;
    }
     
    public void paintComponent(Graphics g) {
        g.drawImage(img, 0, 0, null);
    }
}
