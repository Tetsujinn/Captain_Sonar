package Captain_sonar_modele;

import autrevent.AutreEvent;
import autrevent.AutreEventListener;
import autrevent.AutreEventNotifieur;


//Joueur
public class modele_second {
	private int mine;
	private int drone;
	private int silence;
	private int torpille;
	private int sonar;
	private AutreEventNotifieur notifieur = new AutreEventNotifieur();
    
	public modele_second(){
	}

	public int getMine() {
		return mine;
	}

	public void setMine(int mine) {
		this.mine = mine;
		notifieur.diffuserAutreEvent(new AutreEvent(this, new String("mine")));
		
	}

	public int getDrone() {
		return drone;
	}

	public void setDrone(int drone) {
		this.drone = drone;
		notifieur.diffuserAutreEvent(new AutreEvent(this, new String("drone")));
		
	}

	public int getSilence() {
		return silence;
	}

	public void setSilence(int silence) {
		this.silence = silence;
		notifieur.diffuserAutreEvent(new AutreEvent(this, new String("silence")));
		
	}

	public int getTorpille() {
		return torpille;
	}

	public void setTorpille(int torpille) {
		this.torpille = torpille;
		notifieur.diffuserAutreEvent(new AutreEvent(this, new String("torpille")));
		
	}

	public int getSonar() {
		return sonar;
	}

	public void setSonar(int sonar) {
		this.sonar = sonar;
		notifieur.diffuserAutreEvent(new AutreEvent(this, new String("sonar")));
		
	}
    
    public void addAutreEventListener(AutreEventListener listener) {
     notifieur.addAutreEventListener(listener);
    }
      
    public void removeAutreEventListener(AutreEventListener listener) {
        notifieur.removeAutreEventListener(listener);
    }

}
