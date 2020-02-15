package Kevin;
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

public class Vue extends JFrame {
//Controleur controleur, Modele modele
	public Vue() {
		super();
		Box tout = new Box( BoxLayout.Y_AXIS);
		this.setContentPane(tout);
		JPanel grille = new ImagePanel(new ImageIcon("fond.jpg").getImage());
		tout.add(grille);
		grille.setLayout(new FlowLayout());

		JButton create = new JButton("Creer un salon");
		create.setActionCommand("create");
		//create.addActionListener(controleur);
		grille.add(create);
		
		JButton join = new JButton("Rejoindre un salon");
		join.setActionCommand("join");
		//join.addActionListener(controleur);
		grille.add(join);
		
		JButton quit = new JButton("Quitter");
		quit.setActionCommand("quit");
		//quit.addActionListener(controleur);
		grille.add(quit);
		
		this.pack();
		this.setSize(new Dimension(960,722));
		this.setVisible(true);
	}


public static void main(String[] args) {
               javax.swing.SwingUtilities.invokeLater(new Runnable() {
                     public void run() {
                        Vue vue = new Vue();
                     }
              });
       }
	/*
	@SuppressWarnings("deprecation")
	class VueValeurCouleur extends 	JTextField implements AutreEventListener {
		private boolean modeHexa = false;
		private ModeleRVB modele;
		public VueValeurCouleur(ModeleRVB modele, ControleurRVB controleur) {
			super();
			this.modele = modele;
			this.setText(valeurAffichee(modele.getCouleur()));
			modele.addAutreEventListener(this);
			controleur.addAutreEventListener(this);
		}

		public void actionADeclancher(AutreEvent event) {
		    if (event.getSource() instanceof ModeleRVB && event.getDonnee() instanceof Color)  {
				this.setText(valeurAffichee((Color) event.getDonnee()));
			} else if (event.getSource() instanceof ControleurRVB && event.getDonnee() instanceof Boolean) {
			    this.modeHexa = (Boolean)event.getDonnee();
			    this.setText(valeurAffichee(modele.getCouleur()));
			}
		}
		
		private String valeurAffichee(Color couleur) {
			String valeur="";
			if (modeHexa) {
				String hex = Integer.toHexString(couleur.getRed());
				if (hex.length() < 2)
					valeur += "0";
				valeur += hex;
				hex = Integer.toHexString(couleur.getGreen());
				if (hex.length() < 2)
					valeur += "0";
				valeur += hex;
				hex = Integer.toHexString(couleur.getBlue());
				if (hex.length() < 2)
					valeur += "0";
				valeur += hex;
			} else
			    valeur = couleur.getRed()+", "+couleur.getGreen()+", "+couleur.getBlue();
			return valeur;
		}
	}
	

	class VueCouleur extends JPanel implements AutreEventListener {
		@SuppressWarnings("deprecation")
		public VueCouleur(ModeleRVB modele) {
			super();
			this.setPreferredSize(new Dimension(100,100));
			this.setBackground(modele.getCouleur());
			this.repaint();
			modele.addAutreEventListener(this);
		}

		public void actionADeclancher(AutreEvent event) {
		    if (event.getSource() instanceof ModeleRVB && event.getDonnee() instanceof Color)  {
				this.setBackground((Color) event.getDonnee());
				this.repaint();
			} 
		}
	}*/


}
