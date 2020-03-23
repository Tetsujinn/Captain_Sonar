package Captain_sonar_salon;

import java.util.Objects;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GraphicsConfiguration;
import java.awt.GridLayout;
import java.awt.FlowLayout;
import java.awt.HeadlessException;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;

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
import javax.swing.JProgressBar;


import autrevent.AutreEvent;
import autrevent.AutreEventListener;

import Captain_sonar_modele.modele_launcher;
import Captain_sonar.Controleur_launcher;

public class Vue_second extends JFrame implements AutreEventListener{

	public Vue_second(Controleur_launcher controleur, modele_launcher modele) {
		super();
		Box tout = new Box( BoxLayout.Y_AXIS);
		this.setContentPane(tout);
		JPanel grille = new ImagePanel(new ImageIcon("image/systeme.jpeg").getImage());
		grille.setLayout(new GridBagLayout());
		tout.add(grille);

		GridBagConstraints gbc = new GridBagConstraints();
		gbc.gridx=0;
		gbc.gridy=0;

		JButton mine = new JButton("Mines");
		mine.setActionCommand("mine");
		//mine.setOpaque(false);
		//mine.setContentAreaFilled(false);
		//mine.setBorderPainted(false);
		mine.setForeground(Color.RED);
		mine.addActionListener(controleur);
		grille.add(mine,gbc);
		
		gbc.gridx++;

		JButton drone = new JButton("Drones");
		drone.setActionCommand("drone");
		//drone.setOpaque(false);
		//drone.setContentAreaFilled(false);
		//drone.setBorderPainted(false);
		drone.addActionListener(controleur);
		grille.add(drone,gbc);
		
		gbc.gridx++;

		JButton silence = new JButton("Silence");
		silence.setActionCommand("silence");
		silence.setOpaque(false);
		silence.setContentAreaFilled(false);
		silence.setBorderPainted(false);
		silence.addActionListener(controleur);
		grille.add(silence,gbc);

		gbc.gridx=0;
		gbc.gridy++;

		JProgressBar jpbMine = new JProgressBar();
		grille.add(jpbMine,gbc);
		gbc.gridx++;
		JProgressBar jpbDrone = new JProgressBar();
		grille.add(jpbDrone,gbc);
		gbc.gridx++;
		JProgressBar jpbSilence = new JProgressBar();
		grille.add(jpbSilence,gbc);
		gbc.gridx++;

		JButton torpille = new JButton("Torpilles");
		torpille.setActionCommand("torpille");
		torpille.setOpaque(false);
		torpille.setContentAreaFilled(false);
		torpille.setBorderPainted(false);
		torpille.addActionListener(controleur);
		grille.add(torpille);
		
		JButton sonar = new JButton("Sonar");
		sonar.setActionCommand("sonar");
		sonar.setOpaque(false);
		sonar.setContentAreaFilled(false);
		sonar.setBorderPainted(false);
		sonar.addActionListener(controleur);
		grille.add(sonar);
		
		modele.addAutreEventListener(this);
		controleur.addAutreEventListener(this);
		
		this.setTitle("vue second");
		this.setSize(960,722);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    this.setLocationRelativeTo(null);
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
