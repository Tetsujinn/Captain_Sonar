package Kevin;
import java.util.Objects;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GraphicsConfiguration;
import java.awt.GridLayout;
import java.awt.FlowLayout;
import java.awt.HeadlessException;

import javax.swing.ImageIcon;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import autrevent.AutreEvent;
import autrevent.AutreEventListener;

public class Vue extends JFrame implements AutreEventListener{

	public Vue(Controleur controleur, Modele modele) {
		super();
		Box tout = new Box( BoxLayout.Y_AXIS);
		this.setContentPane(tout);
		JPanel grille = new ImagePanel(new ImageIcon("fond.jpg").getImage());
		tout.add(grille);
		grille.setLayout(new FlowLayout());

		JButton create = new JButton("Creer un salon");
		create.setActionCommand("create");
		create.addActionListener(controleur);
		grille.add(create);
		
		JButton join = new JButton("Rejoindre un salon");
		join.setActionCommand("join");
		join.addActionListener(controleur);
		grille.add(join);
		
		JButton quit = new JButton("Quitter");
		quit.setActionCommand("quit");
		quit.addActionListener(controleur);
		grille.add(quit);
		
		
		modele.addAutreEventListener(this);
		controleur.addAutreEventListener(this);
	}


	public void actionADeclancher(AutreEvent event) {
		//if (event.getSource() instanceof Modele && event.getDonnee() instanceof String)  {
		if(event.getDonnee() instanceof String){
			if(Objects.equals((String)event.getDonnee(),new String("create")))
				System.out.println(" Vue create");
			if(Objects.equals((String)event.getDonnee(),new String("join")))
				System.out.println(" Vue join");
		}
		//}
	}

}
