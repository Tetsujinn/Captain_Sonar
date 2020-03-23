package Captain_sonar_salon;

import javax.swing.JFrame;

import Captain_sonar_modele.modele_launcher;

import Captain_sonar.Controleur_launcher;


public class Vue_General extends JFrame{
	static modele_launcher modele = new modele_launcher();
	static Controleur_launcher controleur = new Controleur_launcher(modele);
	static Vue_launcher vueLauncher = new Vue_launcher(controleur, modele);
	static Vue_salon vueSalon = new Vue_salon();
	public Vue_General() {
		super();
		vueLauncher.setVisible(true);
	}
	
	static public void changementDeVue(int num_joueur) {
		if(num_joueur==0) {//capitaine
			
		}
		if(num_joueur==1) {//second
			Vue_second vueSecond = new Vue_second(controleur, modele);
			vueSalon.setVisible(false);
			vueSecond.setVisible(true);
		}
		if(num_joueur==2) {//Mecano
			
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
