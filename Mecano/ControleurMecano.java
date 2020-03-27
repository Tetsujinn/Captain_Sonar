package Mecano;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import autrevent.AutreEvent;
import autrevent.AutreEventListener;
import autrevent.AutreEventNotifieur;

public class ControleurMecano  implements ActionListener {
	
	private ModeleMecano modele;
	private AutreEventNotifieur notifieur = new AutreEventNotifieur();

	public ControleurMecano(ModeleMecano modele) {
		this.modele = modele;
	}

	@Override
	public void actionPerformed(ActionEvent evenement) { 
	switch (evenement.getActionCommand()) {
		case "0" : 
			notifieur.diffuserAutreEvent(new AutreEvent(this, new Integer(0)));
			modele.modify(0);
			if(modele.checkP1())
				modele.resetP1();
			if(modele.checkOuest()){
				modele.setVie(modele.getVie()-1);
				modele.resetAll();
			}
	    		break;
		case "1" : 
			notifieur.diffuserAutreEvent(new AutreEvent(this, new Integer(7)));
			modele.modify(1);
			if(modele.checkP2())
				modele.resetP2();
			if(modele.checkNord()){
				modele.setVie(modele.getVie()-1);
				modele.resetAll();
			}
			break;
		case "2" : 
			notifieur.diffuserAutreEvent(new AutreEvent(this, new Integer(10)));
			modele.modify(2);
			if(modele.checkNord()){
				modele.setVie(modele.getVie()-1);
				modele.resetAll();
			}
			break;
		case "3" : 
			notifieur.diffuserAutreEvent(new AutreEvent(this, new Integer(14)));
			modele.modify(3);
			if(modele.checkP3())
				modele.resetP3();
			if(modele.checkSud()){
				modele.setVie(modele.getVie()-1);
				modele.resetAll();
			}
			break;
		case "4" : 
			notifieur.diffuserAutreEvent(new AutreEvent(this, new Integer(15)));
			modele.modify(4);
			if(modele.checkSud()){
				modele.setVie(modele.getVie()-1);
				modele.resetAll();
			}
			break;
		case "5" : 
			notifieur.diffuserAutreEvent(new AutreEvent(this, new Integer(20)));
			modele.modify(5);
			if(modele.checkP1())
				modele.resetP1();
			if(modele.checkEst()){
				modele.setVie(modele.getVie()-1);
				modele.resetAll();
			}
			break;
		case "6" : 
			notifieur.diffuserAutreEvent(new AutreEvent(this, new Integer(2)));
			modele.modify(6);
			if(modele.checkP1())
				modele.resetP1();
			if(modele.checkOuest()){
				modele.setVie(modele.getVie()-1);
				modele.resetAll();
			}
			break;
		case "7" : 
			notifieur.diffuserAutreEvent(new AutreEvent(this, new Integer(3)));
			modele.modify(7);
			if(modele.checkOuest()){
				modele.setVie(modele.getVie()-1);
				modele.resetAll();
			}
			break;
		case "8" : 
			notifieur.diffuserAutreEvent(new AutreEvent(this, new Integer(9)));
			modele.modify(8);
			if(modele.checkNord()){
				modele.setVie(modele.getVie()-1);
				modele.resetAll();
			}
	    		break;
		case "9" : 
			notifieur.diffuserAutreEvent(new AutreEvent(this, new Integer(12)));
			modele.modify(9);
			if(modele.checkP3())
				modele.resetP3();
			if(modele.checkSud()){
				modele.setVie(modele.getVie()-1);
				modele.resetAll();
			}
			break;
		case "10" : 
			notifieur.diffuserAutreEvent(new AutreEvent(this, new Integer(18)));
			modele.modify(10);
			if(modele.checkP2())
				modele.resetP2();
			if(modele.checkEst()){
				modele.setVie(modele.getVie()-1);
				modele.resetAll();
			}
			break;
		case "11" : 
			notifieur.diffuserAutreEvent(new AutreEvent(this, new Integer(22)));
			modele.modify(11);
			if(modele.checkEst()){
				modele.setVie(modele.getVie()-1);
				modele.resetAll();
			}
			break;
		case "12" : 
			notifieur.diffuserAutreEvent(new AutreEvent(this, new Integer(1)));
			modele.modify(12);
			if(modele.checkP1())
				modele.resetP1();
			if(modele.checkOuest()){
				modele.setVie(modele.getVie()-1);
				modele.resetAll();
			}
			break;
		case "13" : 
			notifieur.diffuserAutreEvent(new AutreEvent(this, new Integer(6)));
			modele.modify(13);
			if(modele.checkP2())
				modele.resetP2();
			if(modele.checkNord()){
				modele.setVie(modele.getVie()-1);
				modele.resetAll();
			}
			break;
		case "14" : 
			notifieur.diffuserAutreEvent(new AutreEvent(this, new Integer(8)));
			modele.modify(14);
			if(modele.checkP2())
				modele.resetP2();
			if(modele.checkNord()){
				modele.setVie(modele.getVie()-1);
				modele.resetAll();
			}
			break;
		case "15" : 
			notifieur.diffuserAutreEvent(new AutreEvent(this, new Integer(13)));
			modele.modify(15);
			if(modele.checkP3())
				modele.resetP3();
			if(modele.checkSud()){
				modele.setVie(modele.getVie()-1);
				modele.resetAll();
			}
			break;
		case "16" : 
			notifieur.diffuserAutreEvent(new AutreEvent(this, new Integer(17)));
			modele.modify(16);
			if(modele.checkSud()){
				modele.setVie(modele.getVie()-1);
				modele.resetAll();
			}
	    		break;
		case "17" : 
			notifieur.diffuserAutreEvent(new AutreEvent(this, new Integer(19)));
			modele.modify(17);
			if(modele.checkP3())
				modele.resetP3();
			if(modele.checkEst()){
				modele.setVie(modele.getVie()-1);
				modele.resetAll();
			}
			break;
		case "18" : 
			notifieur.diffuserAutreEvent(new AutreEvent(this, new Integer(4)));
			modele.modify(18);
			if(modele.checkOuest()||modele.checkRad()){
				modele.setVie(modele.getVie()-1);
				modele.resetAll();
			}
			break;
		case "19" : 
			notifieur.diffuserAutreEvent(new AutreEvent(this, new Integer(5)));
			modele.modify(19);
			if(modele.checkOuest()||modele.checkRad()){
				modele.setVie(modele.getVie()-1);
				modele.resetAll();
			}
			break;
		case "20" : 
			notifieur.diffuserAutreEvent(new AutreEvent(this, new Integer(11)));
			modele.modify(20);
			if(modele.checkNord()||modele.checkRad()){
				modele.setVie(modele.getVie()-1);
				modele.resetAll();
			}
			break;
		case "21" : 
			notifieur.diffuserAutreEvent(new AutreEvent(this, new Integer(16)));
			modele.modify(21);
			if(modele.checkSud()||modele.checkRad()){
				modele.setVie(modele.getVie()-1);
				modele.resetAll();
			}
			break;
		case "22" : 
			notifieur.diffuserAutreEvent(new AutreEvent(this, new Integer(21)));
			modele.modify(22);
			if(modele.checkEst()||modele.checkRad()){
				modele.setVie(modele.getVie()-1);
				modele.resetAll();
			}
			break;
		case "23" : 
			notifieur.diffuserAutreEvent(new AutreEvent(this, new Integer(23)));
			modele.modify(23);
			if(modele.checkEst()||modele.checkRad()){
				modele.setVie(modele.getVie()-1);
				modele.resetAll();
			}
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
