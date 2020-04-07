package Captain_sonar_salon;

import java.util.Objects;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GraphicsConfiguration;
import java.awt.GridLayout;
import java.awt.FlowLayout;
import java.awt.HeadlessException;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Component;

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

import Captain_sonar_modele.modele_second;
import Captain_sonar.Controleur_second;



public class Vue_second extends JPanel implements AutreEventListener{

	private modele_second modele;
	private Controleur_second controleur;

	public Vue_second(Controleur_second controleur, modele_second modele) {
		super();
		
		this.setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.fill=GridBagConstraints.HORIZONTAL;
		gbc.gridx=0;
		gbc.gridy=0;

		JButton mine = new JButton("Mines");
		mine.setActionCommand("mine");
		//mine.setOpaque(false);
		//mine.setContentAreaFilled(false);
		//mine.setBorderPainted(false);
		//mine.setForeground(Color.RED);
		mine.addActionListener(controleur);
		this.add(mine,gbc);
		
		gbc.gridx++;

		JButton drone = new JButton("Drones");
		drone.setActionCommand("drone");
		drone.addActionListener(controleur);
		this.add(drone,gbc);
		
		gbc.gridx++;

		JButton silence = new JButton("Silence");
		silence.setActionCommand("silence");
		silence.addActionListener(controleur);
		this.add(silence,gbc);

		gbc.gridx=0;
		gbc.gridy++;

		JProgressBar jpbMine = new JProgressBar();
		this.add(jpbMine,gbc);
		gbc.gridx++;
		JProgressBar jpbDrone = new JProgressBar();
		this.add(jpbDrone,gbc);
		gbc.gridx++;
		JProgressBar jpbSilence = new JProgressBar();
		this.add(jpbSilence,gbc);

		gbc.gridx=0;
		gbc.gridy++;

		JButton torpille = new JButton("Torpilles");
		torpille.setActionCommand("torpille");
		torpille.addActionListener(controleur);
		this.add(torpille,gbc);

		gbc.gridx++;

		JButton sonar = new JButton("Sonar");
		sonar.setActionCommand("sonar");
		sonar.addActionListener(controleur);
		this.add(sonar,gbc);

		gbc.gridx=0;
		gbc.gridy++;

		JProgressBar jpbTorpille = new JProgressBar();
		this.add(jpbTorpille,gbc);
		gbc.gridx++;
		JProgressBar jpbSonar = new JProgressBar();
		this.add(jpbSonar,gbc);
		
		
		modele.addAutreEventListener(this);
		controleur.addAutreEventListener(this);
		this.modele=modele;
		this.controleur=controleur;
		
	}


	public void actionADeclancher(AutreEvent event) {
		if (event.getSource() instanceof modele_second)  {
			Component[] component=this.getComponents();
			if(event.getDonnee() instanceof String){
				if(Objects.equals((String)event.getDonnee(),new String("mine"))){
					if (component[3] instanceof JProgressBar){
					    JProgressBar jpb = (JProgressBar)component[3];
					    jpb.setValue(modele.getMine());
					}
				}
				if(Objects.equals((String)event.getDonnee(),new String("drone"))){
					if (component[4] instanceof JProgressBar){
					    JProgressBar jpb = (JProgressBar)component[4];
					    jpb.setValue(modele.getDrone());
					}
				}
				if(Objects.equals((String)event.getDonnee(),new String("silence"))){
					if (component[5] instanceof JProgressBar){
					    JProgressBar jpb = (JProgressBar)component[5];
					    jpb.setValue(modele.getSilence());
					}
				}
				if(Objects.equals((String)event.getDonnee(),new String("torpille"))){
					if (component[8] instanceof JProgressBar){
					    JProgressBar jpb = (JProgressBar)component[8];
					    jpb.setValue(modele.getTorpille());
					}
				}
				if(Objects.equals((String)event.getDonnee(),new String("sonar"))){
					if (component[9] instanceof JProgressBar){
					    JProgressBar jpb = (JProgressBar)component[9];
					    jpb.setValue(modele.getSonar());
					}
				}
			}
		}
	}
	public void paintComponent(Graphics g) {
        	g.drawImage(new ImageIcon("../image/systeme.jpeg").getImage(), 0, 0, null);
    	}
}
