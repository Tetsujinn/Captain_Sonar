package Captain_sonar_modele;

import java.awt.Color;
import autrevent.AutreEvent;
import autrevent.AutreEventListener;
import autrevent.AutreEventNotifieur;


public class modele_detecteur {
	private boolean mine = false;
	
	
	private AutreEventNotifieur notifieur = new AutreEventNotifieur();
    
	public modele_detecteur(){
	}

	public boolean getMine() {
		return mine;
	}

	public void changeMode() {
		this.mine=!this.mine;
	}

	public void modify() {
	}

/// Permet de reset la map du detecteur
	public void resetAll(){
		/*for(int i=0;i<24;i++)
			this.pannes[i]=false;
		notifieur.diffuserAutreEvent(new AutreEvent(this, new String("resetAll")));*/
	}

    
    public void addAutreEventListener(AutreEventListener listener) {
     notifieur.addAutreEventListener(listener);
    }
      
    public void removeAutreEventListener(AutreEventListener listener) {
        notifieur.removeAutreEventListener(listener);
    }

}
