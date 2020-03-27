package Second;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import autrevent.AutreEvent;
import autrevent.AutreEventListener;
import autrevent.AutreEventNotifieur;

public class ControleurSecond  implements ActionListener {
	
	private ModeleSecond modele;
	private AutreEventNotifieur notifieur = new AutreEventNotifieur();

	public ControleurSecond(ModeleSecond modele) {
		this.modele = modele;
	}

	@Override
	public void actionPerformed(ActionEvent evenement) { 
	switch (evenement.getActionCommand()) {
		case "mine" : 
			modele.setMine(modele.getMine()+34);
	    		break;
		case "drone" : 
			modele.setDrone(modele.getDrone()+25);
			break;
		case "silence" : 
			modele.setSilence(modele.getSilence()+17);
			break;
		case "torpille" : 
			modele.setTorpille(modele.getTorpille()+34);
			break;
		case "sonar" : 
			modele.setSonar(modele.getSonar()+34);
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
