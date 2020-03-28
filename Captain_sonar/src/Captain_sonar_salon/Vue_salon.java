package Captain_sonar_salon;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Vue_salon extends JPanel{
	int NOMBRE_DE_JOUEUR = 8;
	public Vue_salon() {
		super();
		this.setLayout(new FlowLayout());

		JLabel joueur[] = new JLabel[8]; 
		for (int i = 0; i < NOMBRE_DE_JOUEUR; i++) {
			joueur[i] = new JLabel("Joueur"+ (i+1));
			this.add(joueur[i]);
		}
		JButton lancer_partie = new JButton("Lancer la partie");
		lancer_partie.addActionListener(new lancerPartie());
		
		this.add(lancer_partie);
		
	}

	class lancerPartie implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			JButton jb = (JButton)e.getSource();
			Vue_General vg=(Vue_General)jb.getTopLevelAncestor();
			vg.changementDeVue(2);
		}
	}


	/*
	
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
