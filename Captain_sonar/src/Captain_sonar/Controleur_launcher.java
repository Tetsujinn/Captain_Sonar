package Captain_sonar;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import autrevent.AutreEvent;
import autrevent.AutreEventListener;
import autrevent.AutreEventNotifieur;

import Captain_sonar_modele.modele_launcher;

public class Controleur_launcher  implements ActionListener {
	
	private modele_launcher modele;
	private AutreEventNotifieur notifieur = new AutreEventNotifieur();

	public Controleur_launcher(modele_launcher modele) {
		this.modele = modele;
	}

	@Override
	public void actionPerformed(ActionEvent evenement) { 
		switch (evenement.getActionCommand()) {
	    case "create" : 
		notifieur.diffuserAutreEvent(new AutreEvent(this, new String("create")));
	    	break;
	    case "join" : 
	    	notifieur.diffuserAutreEvent(new AutreEvent(this, new String("join")));
	    	break;
	    case "quit" : 
	    	System.out.println("Quitter le jeu");
		System.exit(0);
	    	break;
		}
	}
	
    public void addAutreEventListener(AutreEventListener listener) {
        notifieur.addAutreEventListener(listener);
    }
         
    public void removeAutreEventListener(AutreEventListener listener) {
        notifieur.removeAutreEventListener(listener);
    }

}