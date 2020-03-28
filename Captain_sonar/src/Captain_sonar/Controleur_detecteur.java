package Captain_sonar;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JLabel;


import autrevent.AutreEvent;
import autrevent.AutreEventListener;
import autrevent.AutreEventNotifieur;

import Captain_sonar_modele.modele_detecteur;


public class Controleur_detecteur  implements ActionListener,MouseListener {
	
	private modele_detecteur modele;
	private AutreEventNotifieur notifieur = new AutreEventNotifieur();

	public Controleur_detecteur(modele_detecteur modele) {
		this.modele = modele;
	}

	@Override
	public void actionPerformed(ActionEvent evenement) { 
		switch (evenement.getActionCommand()) {
			case "mine" : 
				modele.changeMode();
		    		break;
		}
	}
	
	public void mouseClicked(MouseEvent e){
		JLabel label=(JLabel)e.getSource();
		notifieur.diffuserAutreEvent(new AutreEvent(this,(JLabel)e.getSource()));

	/// modifier une matrice du modele qui represente la map du detecteur
	/// Mais pour cela il faut determiner sur quel JLabel le joueur a clique
		//modele.modify();	
	}
	
	public void mouseEntered(MouseEvent e) {
	}
	public void mouseExited(MouseEvent e) { 
	}
	public void mousePressed(MouseEvent e) { 
	}
	public void mouseReleased(MouseEvent e) {
	}

    public void addAutreEventListener(AutreEventListener listener) {
        notifieur.addAutreEventListener(listener);
    }
         
    public void removeAutreEventListener(AutreEventListener listener) {
        notifieur.removeAutreEventListener(listener);
    }

}
