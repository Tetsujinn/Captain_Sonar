package Second;
import java.awt.Color;
import autrevent.AutreEvent;
import autrevent.AutreEventListener;
import autrevent.AutreEventNotifieur;


//Joueur
public class Modele {
	private String pseudo = "";
	private String ip = "";
	private AutreEventNotifieur notifieur = new AutreEventNotifieur();
    
	public Modele(String pseudo, String ip){
		this.pseudo=pseudo;
		this.ip=ip;
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
