package Captain_sonar_salon;

import javax.swing.JFrame;

import Captain_sonar_modele.*;

import Captain_sonar.*;


public class Vue_General extends JFrame{

	public modele_launcher modele = new modele_launcher();
	public Controleur_launcher controleur = new Controleur_launcher(modele);
	public Vue_launcher vueLauncher = new Vue_launcher(controleur, modele);
	public Vue_salon vueSalon = new Vue_salon();

	public modele_mecano modeleMecano = new modele_mecano();
	public Controleur_mecano controleurMecano = new Controleur_mecano(modeleMecano);

	public modele_second modeleSecond = new modele_second();
	public Controleur_second controleurSecond = new Controleur_second(modeleSecond);
	public modele_detecteur modeleDetecteur = new modele_detecteur();
	public Controleur_detecteur controleurDetecteur = new Controleur_detecteur(modeleDetecteur);
	
	public Vue_General() {
		super();
		
		this.setContentPane(vueLauncher);
		
		/// VUE SALON & LAUNCHER
		
		this.setTitle("launcher");
		this.setSize(1500,800);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    	this.setLocationRelativeTo(null);
		this.setVisible(true);
	}
	
	public void changementDeVue(int num_joueur) {
		if(num_joueur==0) {//capitaine
			Vue_capitain vueCapitain = new Vue_capitain();
			this.setContentPane(vueCapitain);
			this.repaint();
			this.revalidate();
		}
		if(num_joueur==1) {//second
			Vue_second vueSecond = new Vue_second(controleurSecond, modeleSecond);
			this.setContentPane(vueSecond);
			this.repaint();
			this.revalidate();
		}
		if(num_joueur==2) {//Mecano
			Vue_mecano vueMecano = new Vue_mecano(controleurMecano, modeleMecano);
			this.setContentPane(vueMecano);
			this.repaint();
			this.revalidate();
		}
		if(num_joueur==3) {//detecteur
			Vue_detecteur vueDetecteur = new Vue_detecteur(controleurDetecteur, modeleDetecteur);
			this.setContentPane(vueDetecteur);
			this.repaint();
			this.revalidate();
			
			
		}
	}
	
	public void changementDeVueSalon() {
		this.setContentPane(vueSalon);
		this.repaint();
		this.revalidate();
	}
}
