package Kevin;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import autrevent.AutreEvent;
import autrevent.AutreEventListener;
import autrevent.AutreEventNotifieur;

public class Controleur  implements ActionListener {
	
	private String text;
	private Modele modele;
	private AutreEventNotifieur notifieur = new AutreEventNotifieur();

	public Controleur(Modele modele) {
		this.modele = modele;
		this.text = text;
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
	    case "text" : 
	    	System.out.println(text);		
	    	break;
	    case "submit" :
	    	notifieur.diffuserAutreEvent(new AutreEvent(this, new String("submit")));
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
