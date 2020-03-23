package Captain_sonar_salon;

import java.util.Objects;


import java.awt.FlowLayout;

import javax.swing.ImageIcon;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import autrevent.AutreEvent;
import autrevent.AutreEventListener;

import Captain_sonar.Controleur_launcher;
import Captain_sonar_modele.modele_launcher;

public class Vue_launcher extends JFrame implements AutreEventListener{

	public Vue_launcher(Controleur_launcher controleur, modele_launcher modele) {
		super();
		Box tout = new Box( BoxLayout.Y_AXIS);
		this.setContentPane(tout);
		JPanel grille = new ImagePanel(new ImageIcon("image/fond.jpg").getImage());
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
		
		this.setTitle("launcher");
		this.setSize(960,722);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    this.setLocationRelativeTo(null);
	}


	public void actionADeclancher(AutreEvent event) {
		//if (event.getSource() instanceof Modele && event.getDonnee() instanceof String)  {
		if(event.getDonnee() instanceof String){
			if(Objects.equals((String)event.getDonnee(),new String("create")))
				Vue_General.changementDeVueSalon();
			if(Objects.equals((String)event.getDonnee(),new String("join")))
				System.out.println(" Vue join");
		}
		//}
	}

}
