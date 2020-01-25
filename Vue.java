
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GraphicsConfiguration;
import java.awt.GridLayout;
import java.awt.HeadlessException;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import javax.swing.ImageIcon;


public class Vue extends JFrame {

	public Vue() {
		super();
		//Box tout = new Box( BoxLayout.X_AXIS);
		
		JPanel grille = new JPanel(new GridLayout(2,2,5,5));
		this.setContentPane(grille);
		//tout.add(grille);
		
		ImageIcon armes = new ImageIcon(grille.getClass().getResource("/armes.jpg"));
		ImageIcon pannes = new ImageIcon(grille.getClass().getResource("/panne.jpeg"));
		
		JButton plus = new JButton(armes);
		plus.setActionCommand("+R");
		//plus.addActionListener(controleur);
		
		grille.add(new JLabel("Ma Map", JLabel.CENTER));
		grille.add(plus);
		grille.add(new JLabel("Chemin ennemi", JLabel.CENTER));
		JButton moins = new JButton(pannes);
		moins.setActionCommand("-R");
		//moins.addActionListener(controleur);
		grille.add(moins);
		
		this.pack();
		this.setVisible(true);
	}


	public static void main(String[] args) {
               javax.swing.SwingUtilities.invokeLater(new Runnable() {
                     public void run() {
                        Vue vue = new Vue();
                     }
              });
       }
}
