package Captain_sonar;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import autrevent.AutreEvent;
import autrevent.AutreEventListener;
import autrevent.AutreEventNotifieur;

import Captain_sonar_modele.modele_salon;

public class Controleur_salon  implements ActionListener,KeyListener {
	
	private modele_salon modele;
	private AutreEventNotifieur notifieur = new AutreEventNotifieur();

	public Controleur_salon(modele_salon modele) {
		this.modele = modele;
	}

	@Override
	public void actionPerformed(ActionEvent evenement) { 
		switch (evenement.getActionCommand()) {
	    case "envoyer" : 
		notifieur.diffuserAutreEvent(new AutreEvent(this, new String("envoi")));
	    	break;
	    case "lancement" : 
	    	notifieur.diffuserAutreEvent(new AutreEvent(this, new String("lancement")));
	    	break;
		}
	}
	
	public void keyPressed(KeyEvent e){
		if(e.getKeyCode()== KeyEvent.VK_ENTER){
			notifieur.diffuserAutreEvent(new AutreEvent(this, new String("envoi")));
		}
	}
	public void keyReleased(KeyEvent e){}
	public void keyTyped(KeyEvent e){}
	
    public void addAutreEventListener(AutreEventListener listener) {
        notifieur.addAutreEventListener(listener);
    }
         
    public void removeAutreEventListener(AutreEventListener listener) {
        notifieur.removeAutreEventListener(listener);
    }

}
