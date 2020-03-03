package Second;
import java.awt.Graphics;
import java.awt.Image;
 
import javax.swing.JPanel;


 
public class ImagePanel extends JPanel {
 
    private Image img;
     
    public ImagePanel(Image img){
        this.img = img;
        //add(new JButton("Bouton1"));
        //add(new JButton("Bouton2"));
    }
     
    public void paintComponent(Graphics g) {
        g.drawImage(img, 0, 0, null);
    }
}
