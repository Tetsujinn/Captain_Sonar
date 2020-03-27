package Captain_sonar_salon;

import javax.swing.JFrame;

import Captain_sonar_modele.*;

import Captain_sonar.*;


public class Vue_General extends JFrame{
	static modele_launcher modele = new modele_launcher();
	static Controleur_launcher controleur = new Controleur_launcher(modele);
	static Vue_launcher vueLauncher = new Vue_launcher(controleur, modele);
	static Vue_salon vueSalon = new Vue_salon();
	static modele_mecano modeleMecano = new modele_mecano();
	static Controleur_mecano controleurMecano = new Controleur_mecano(modeleMecano);
	static modele_second modeleSecond = new modele_second();
	static Controleur_second controleurSecond = new Controleur_second(modeleSecond);
	
	public Vue_General() {
		super();
		vueLauncher.setVisible(true);
	}
	
	static public void changementDeVue(int num_joueur) {
		if(num_joueur==0) {//capitaine
			Vue_capitain vueCapitain = new Vue_capitain();
			vueSalon.setVisible(false);
			vueCapitain.setVisible(true);
		}
		if(num_joueur==1) {//second
			Vue_second vueSecond = new Vue_second(controleurSecond, modeleSecond);
			vueSalon.setVisible(false);
			vueSecond.setVisible(true);
		}
		if(num_joueur==2) {//Mecano
			Vue_mecano vueMecano = new Vue_mecano(controleurMecano, modeleMecano);
			vueSalon.setVisible(false);
			vueMecano.setVisible(true);
		}
		if(num_joueur==3) {//detecteur
			Vue_detecteur vueDetecteur = new Vue_detecteur();
			vueSalon.setVisible(false);
			vueDetecteur.setVisible(true);
			
			
		}
	}
	
	static public void changementDeVueSalon() {
		vueSalon.setVisible(true);
		vueLauncher.setVisible(false);
	}
}
