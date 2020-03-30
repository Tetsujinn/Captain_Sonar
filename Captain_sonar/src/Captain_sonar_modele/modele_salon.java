package Captain_sonar_modele;

import java.net.Socket;
import java.net.ServerSocket;
import java.io.PrintWriter;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Objects;

import autrevent.AutreEvent;
import autrevent.AutreEventListener;
import autrevent.AutreEventNotifieur;



public class modele_salon{
	
	
	private Socket socketJ;
	private PrintWriter serveurPrint;
	private int monNumeroJoueur;
	
	private ServerSocket s;
	private PrintWriter [] tab = new PrintWriter[20];
	private int nbJoueur = 0;
	
	private AutreEventNotifieur notifieur = new AutreEventNotifieur();
    
	public modele_salon(){
	}
	
	public void setSocket(Socket socketJ) {
		this.socketJ = socketJ;
	}

	public Socket getSocket() {
		return socketJ;
	}
	
	public void setPrintWriter(PrintWriter serveurPrint) {
		this.serveurPrint = serveurPrint;
	}

	public PrintWriter getPrintWriter() {
		return serveurPrint;
	}
	
	public void setMonNum(int monNumeroJoueur) {
		this.monNumeroJoueur = monNumeroJoueur;
	}
	
	public int getMonNum() {
		return monNumeroJoueur;
	}
	
	public void setServeurSocket(ServerSocket s) {
		this.s = s;
	}

	public ServerSocket getServeurSocket() {
		return s;
	}

	public void setTab(int n, PrintWriter tab) {
		this.tab[n] = tab;
		this.nbJoueur++;
	}
	
	public PrintWriter getTab(int n) {
		return tab[n];
	}

	public int getNbJoueur() {
		return nbJoueur;
	}

	public void envoiAll(String text){
		try {
			for(int j=0;j<this.nbJoueur;j++){
				this.tab[j].println(text);
				this.tab[j].flush();
			}
		}catch(Exception e){
			//historique.append("\n - Tous les joueurs sont hors ligne");
		}
	}
	
	public void envoi(int ind, String text){
		try {
			this.tab[ind].println(text);
			this.tab[ind].flush();
		}catch(Exception e){
			//historique.append("\n - Tous les joueurs sont hors ligne");
		}
	}

	public void envoi(int ind, Object text){
		try {
			this.tab[ind].println(text);
			this.tab[ind].flush();
		}catch(Exception e){
			//historique.append("\n - Tous les joueurs sont hors ligne");
		}
	}
	
    public void addAutreEventListener(AutreEventListener listener) {
     notifieur.addAutreEventListener(listener);
    }
      
    public void removeAutreEventListener(AutreEventListener listener) {
        notifieur.removeAutreEventListener(listener);
    }

    
    /// THREAD CONNEXION
	public class connexion implements Runnable{
		public connexion(){}

		public void run() {
			try{
				while(modele_salon.this.getNbJoueur()<7){
				    modele_salon.this.setSocket(modele_salon.this.getServeurSocket().accept());
				    modele_salon.this.setTab(modele_salon.this.getNbJoueur(), new PrintWriter(modele_salon.this.getSocket().getOutputStream()));
				    notifieur.diffuserAutreEvent(new AutreEvent(modele_salon.this, modele_salon.this.getSocket()));
				    modele_salon.reception r=modele_salon.this.new reception();
				    Thread thread = new Thread(r);
				    thread.start() ;
				}
				System.out.println("Le bouton est dispo, salon plein !");
/// SURMENT A REMPLACER PAR UN EVENEMENT BOOLEAN POUR PREVENIR LA VUE DU CHANGEMENT DETAT DU BOUTON
				//lancer_partie.setEnabled(true);
		
			}catch (IOException e1) {
			}
		}
	}// fin thread connexion
	
	/// THREAD RECEPTION
	public class reception implements Runnable{

		BufferedReader serveur;
		PrintWriter pw;
		public reception(){}
     
		public void run() {
        		while(true){
        			try {
            			serveur = new BufferedReader(new InputStreamReader(modele_salon.this.getSocket().getInputStream()));
            			String msg = serveur.readLine();
            			notifieur.diffuserAutreEvent(new AutreEvent(modele_salon.this, msg));
            		} catch (IOException e) {  
            		}
        		}//fin while(true)
    		}//fin run
	}//fin thread reception
	
}
