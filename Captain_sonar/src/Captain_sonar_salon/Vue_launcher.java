package Captain_sonar_salon;

import java.util.Objects;


import java.awt.FlowLayout;
import java.awt.Graphics;

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

public class Vue_launcher extends JPanel implements AutreEventListener{

	public Vue_launcher(Controleur_launcher controleur, modele_launcher modele) {
		super();
		
		this.setLayout(new FlowLayout());

		JButton create = new JButton("Creer un salon");
		create.setActionCommand("create");
		create.addActionListener(controleur);
		this.add(create);
		
		JButton join = new JButton("Rejoindre un salon");
		join.setActionCommand("join");
		join.addActionListener(controleur);
		this.add(join);
		
		JButton quit = new JButton("Quitter");
		quit.setActionCommand("quit");
		quit.addActionListener(controleur);
		this.add(quit);
		
		
		modele.addAutreEventListener(this);
		controleur.addAutreEventListener(this);
		
		
	}


	public void actionADeclancher(AutreEvent event) {
		if(event.getDonnee() instanceof String){
			Vue_General vg=(Vue_General)this.getTopLevelAncestor();
			if(Objects.equals((String)event.getDonnee(),new String("create")))
				vg.changementDeVueSalon(0);
			if(Objects.equals((String)event.getDonnee(),new String("join")))
				vg.changementDeVueSalon(1);
		}
	}

	public void paintComponent(Graphics g) {
        	g.drawImage(new ImageIcon("../image/fond.jpg").getImage(), 0, 0, null);
    	}
}
