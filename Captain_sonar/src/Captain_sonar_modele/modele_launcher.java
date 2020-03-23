package Captain_sonar_modele;

import autrevent.AutreEvent;
import autrevent.AutreEventListener;
import autrevent.AutreEventNotifieur;


//Joueur
public class modele_launcher {
	private String pseudo = "";
	private String ip = "";
	private AutreEventNotifieur notifieur = new AutreEventNotifieur();
    
	public modele_launcher(){
	}

	public String getPseudo() {
		return pseudo;
	}

	public void setPseudo(String pseudo) {
		this.pseudo = pseudo;
		notifieur.diffuserAutreEvent(new AutreEvent(this, this.getPseudo()));
		
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
		notifieur.diffuserAutreEvent(new AutreEvent(this, this.getIp()));
		
	}
    
    public void addAutreEventListener(AutreEventListener listener) {
     notifieur.addAutreEventListener(listener);
    }
      
    public void removeAutreEventListener(AutreEventListener listener) {
        notifieur.removeAutreEventListener(listener);
    }

}
