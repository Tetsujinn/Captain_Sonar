package Mecano;
import java.util.Objects;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GraphicsConfiguration;
import java.awt.GridLayout;
import java.awt.FlowLayout;
import java.awt.HeadlessException;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Image;

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

public class VueMecano extends JPanel implements AutreEventListener{

	private ModeleMecano modele;
	private ControleurMecano controleur;

	public VueMecano(ControleurMecano controleur, ModeleMecano modele) {
		super();
		//Box tout = new Box( BoxLayout.Y_AXIS);
		
		//JPanel grille = new ImagePanel(new ImageIcon("panne.jpeg").getImage());
		
		this.setLayout(new GridBagLayout());
		//this.setContentPane(grille);
		//tout.add(grille);

		GridBagConstraints gbc = new GridBagConstraints();
		gbc.fill=GridBagConstraints.HORIZONTAL;
		gbc.gridx=0;
		gbc.gridy=0;

		/// OUEST
		
		JButton arme0 = new JButton("Arme0");
		arme0.setActionCommand("0");
		arme0.addActionListener(controleur);
		this.add(arme0,gbc);
		
		gbc.gridx++;gbc.gridx++;

		JButton outil0 = new JButton("Outil0");
		outil0.setActionCommand("12");
		outil0.addActionListener(controleur);
		this.add(outil0,gbc);
		
		gbc.gridy++;

		JButton scan0 = new JButton("Scan0");
		scan0.setActionCommand("6");
		scan0.addActionListener(controleur);
		this.add(scan0,gbc);

		gbc.gridx=0;
		gbc.gridy++;

		JButton scan1 = new JButton("Scan1");
		scan1.setActionCommand("7");
		scan1.addActionListener(controleur);
		this.add(scan1,gbc);

		gbc.gridx++;

		JButton rad0 = new JButton("Rad0");
		rad0.setActionCommand("18");
		rad0.addActionListener(controleur);
		this.add(rad0,gbc);
	
		gbc.gridx++;

		JButton rad1 = new JButton("Rad1");
		rad1.setActionCommand("19");
		rad1.addActionListener(controleur);
		this.add(rad1,gbc);

		///NORD
		gbc.gridy=0;
		gbc.gridx++;

		JButton outil1 = new JButton("Outil1");
		outil1.setActionCommand("13");
		outil1.addActionListener(controleur);
		this.add(outil1,gbc);

		gbc.gridy++;
		
		JButton arme1 = new JButton("Arme1");
		arme1.setActionCommand("1");
		arme1.addActionListener(controleur);
		this.add(arme1,gbc);

		gbc.gridx++;gbc.gridx++;

		JButton outil2 = new JButton("Outil2");
		outil2.setActionCommand("14");
		outil2.addActionListener(controleur);
		this.add(outil2,gbc);

		gbc.gridx=3;gbc.gridy++;

		JButton scan2 = new JButton("Scan2");
		scan2.setActionCommand("8");
		scan2.addActionListener(controleur);
		this.add(scan2,gbc);

		gbc.gridx++;

		JButton arme2 = new JButton("Arme2");
		arme2.setActionCommand("2");
		arme2.addActionListener(controleur);
		this.add(arme2,gbc);

		gbc.gridx++;

		JButton rad2 = new JButton("Rad2");
		rad2.setActionCommand("20");
		rad2.addActionListener(controleur);
		this.add(rad2,gbc);
		
		///SUD
		gbc.gridx++;gbc.gridy=0;

		JButton scan3 = new JButton("Scan3");
		scan3.setActionCommand("9");
		scan3.addActionListener(controleur);
		this.add(scan3,gbc);

		gbc.gridy++;

		JButton outil3 = new JButton("Outil3");
		outil3.setActionCommand("15");
		outil3.addActionListener(controleur);
		this.add(outil3,gbc);

		gbc.gridx++;gbc.gridx++;

		JButton arme3 = new JButton("Arme3");
		arme3.setActionCommand("3");
		arme3.addActionListener(controleur);
		this.add(arme3,gbc);

		gbc.gridx=6;gbc.gridy++;

		JButton arme4 = new JButton("Arme4");
		arme4.setActionCommand("4");
		arme4.addActionListener(controleur);
		this.add(arme4,gbc);
		
		gbc.gridx++;

		JButton rad3 = new JButton("Rad3");
		rad3.setActionCommand("21");
		rad3.addActionListener(controleur);
		this.add(rad3,gbc);

		gbc.gridx++;

		JButton outil4 = new JButton("Outil4");
		outil4.setActionCommand("16");
		outil4.addActionListener(controleur);
		this.add(outil4,gbc);
		
		///EST
		gbc.gridy=0;
		gbc.gridx++;

		JButton scan4 = new JButton("Scan4");
		scan4.setActionCommand("10");
		scan4.addActionListener(controleur);
		this.add(scan4,gbc);

		gbc.gridy++;
		
		JButton outil5 = new JButton("Outil5");
		outil5.setActionCommand("17");
		outil5.addActionListener(controleur);
		this.add(outil5,gbc);

		gbc.gridx++;gbc.gridx++;

		JButton arme5 = new JButton("Arme5");
		arme5.setActionCommand("5");
		arme5.addActionListener(controleur);
		this.add(arme5,gbc);

		gbc.gridx=9;gbc.gridy++;

		JButton rad4 = new JButton("Rad4");
		rad4.setActionCommand("22");
		rad4.addActionListener(controleur);
		this.add(rad4,gbc);

		gbc.gridx++;

		JButton scan5 = new JButton("Scan5");
		scan5.setActionCommand("11");
		scan5.addActionListener(controleur);
		this.add(scan5,gbc);

		gbc.gridx++;

		JButton rad5 = new JButton("Rad5");
		rad5.setActionCommand("23");
		rad5.addActionListener(controleur);
		this.add(rad5,gbc);
		
		

		modele.addAutreEventListener(this);
		controleur.addAutreEventListener(this);
		this.modele=modele;
		this.controleur=controleur;
	}


	public void actionADeclancher(AutreEvent event) {
		Component[] component=this.getComponents();
		if (event.getSource() instanceof ControleurMecano)  {
			if(event.getDonnee() instanceof Integer){
				JButton jb = (JButton)component[(Integer)event.getDonnee()];
				jb.setEnabled(false);
			}
		}
		if (event.getSource() instanceof ModeleMecano)  {
			if(event.getDonnee() instanceof String){
				if(Objects.equals((String)event.getDonnee(),new String("vie"))){
					System.out.println("-1 PV");
				}
				if(Objects.equals((String)event.getDonnee(),new String("resetP1"))){
					if (component[0] instanceof JButton){
						JButton jb = (JButton)component[0];jb.setEnabled(true);
						jb = (JButton)component[1];jb.setEnabled(true);
						jb = (JButton)component[2];jb.setEnabled(true);
						jb = (JButton)component[20];jb.setEnabled(true);
					}
				}
				if(Objects.equals((String)event.getDonnee(),new String("resetP2"))){
					if (component[7] instanceof JButton){
					    JButton jb = (JButton)component[7];jb.setEnabled(true);
					    jb = (JButton)component[18];jb.setEnabled(true);
					    jb = (JButton)component[6];jb.setEnabled(true);
					    jb = (JButton)component[8];jb.setEnabled(true);
					}
				}
				if(Objects.equals((String)event.getDonnee(),new String("resetP3"))){
					if (component[14] instanceof JButton){
					    JButton jb = (JButton)component[14];jb.setEnabled(true);
					    jb = (JButton)component[12];jb.setEnabled(true);
					    jb = (JButton)component[13];jb.setEnabled(true);
					    jb = (JButton)component[19];jb.setEnabled(true);
					}
				}
				if(Objects.equals((String)event.getDonnee(),new String("resetAll"))){
					for(int i=0;i<component.length;i++){
						if (component[i] instanceof JButton){
						    JButton jb = (JButton)component[i];
						    jb.setEnabled(true);
						}
					}
				}
			}
		}
	}
	
	public void paintComponent(Graphics g) {
        	g.drawImage(new ImageIcon("panne.jpeg").getImage(), 0, 0, null);
    	}

}
