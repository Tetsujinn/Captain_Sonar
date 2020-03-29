package Captain_sonar_modele;

import java.net.Socket;
import java.net.ServerSocket;
import java.io.PrintWriter;

import autrevent.AutreEvent;
import autrevent.AutreEventListener;
import autrevent.AutreEventNotifieur;



public class modele_salon{
	
	//Joueur
	private Socket socketJ;
	private PrintWriter serveurPrint;
	private int monNumeroJoueur;
	//Serveur
	private ServerSocket s;
	private PrintWriter [] tab = new PrintWriter[20];
	private int nbJoueur = 0;
	
	private AutreEventNotifieur notifieur = new AutreEventNotifieur();
    
	public modele_salon(){
	}
	/// Joueur
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
	
	///Serveur
	public void setServeurSocket(ServerSocket s) {
		this.s = s;
	}

	public ServerSocket getServeurSocket() {
		return s;
	}

	public void setTab(int n, PrintWriter tab) {
		this.tab[n] = tab;
		this.nbJoueur++;
		System.out.println(nbJoueur);
	}
	
	public PrintWriter getTab(int n) {
		return tab[n];
	}

	public int getNbJoueur() {
		return nbJoueur;
	}


    public void addAutreEventListener(AutreEventListener listener) {
     notifieur.addAutreEventListener(listener);
    }
      
    public void removeAutreEventListener(AutreEventListener listener) {
        notifieur.removeAutreEventListener(listener);
    }

}
