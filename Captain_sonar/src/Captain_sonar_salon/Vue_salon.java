package Captain_sonar_salon;

import javax.swing.*;
 
import java.awt.TextArea;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.List;
import java.util.StringTokenizer;
import java.util.Objects;
 
import autrevent.AutreEvent;
import autrevent.AutreEventListener;

import Captain_sonar_modele.modele_salon;
import Captain_sonar.Controleur_salon;

public class Vue_salon extends JPanel implements AutreEventListener{
 
	JTextField text;
	TextArea historique;
	JButton submit;
	JButton lancer_partie;
	List joueur;

	//Thread thread;
	//reception r ;
	//connexion c ;
	//ServerSocket s;
	//Socket socket1;
	//Date date;
	//PrintWriter [] tab = new PrintWriter[20];
	
	//int n = 0 ;
	
	private modele_salon modele;
	private Controleur_salon controleur;

	public Vue_salon(Controleur_salon controleur, modele_salon modele) {

		this.setLayout(null);
 
		historique = new TextArea();
		historique.setBounds(6, 0, 426, 214);
		historique.setEditable(false);
		this.add(historique);
 
		text = new JTextField();
		text.setBounds(10, 239, 327, 20);
		this.add(text);
		text.setColumns(10);
		text.addKeyListener(controleur);
		/*text.addKeyListener(new KeyAdapter() {
		@Override
		public void keyPressed(KeyEvent arg0) {
		 
			if(arg0.getKeyCode()== KeyEvent.VK_ENTER)
			{
			envoi();
			}
		}
		});*/

		submit = new JButton("Envoyer");
		submit.setBounds(343, 240, 110, 23);
		submit.setActionCommand("envoyer");
		submit.addActionListener(controleur);
		this.add(submit);
		/*submit.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent arg0) {
		envoi();
		}
		});*/

		lancer_partie = new JButton("Lancer la partie");
		lancer_partie.setBounds(460, 240, 110, 23);
		//lancer_partie.setEnabled(false);
		lancer_partie.setActionCommand("lancement");
		lancer_partie.addActionListener(controleur);
		this.add(lancer_partie);
	/*	lancer_partie.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JButton jb = (JButton)arg0.getSource();
				Vue_General vg=(Vue_General)jb.getTopLevelAncestor();
				vg.changementDeVue(2);
			}
		});*/

		joueur = new List();
		joueur.add("Aucun Joueur") ;
		joueur.setBounds(438, 10, 110, 191);
		this.add(joueur);

		modele.addAutreEventListener(this);
		controleur.addAutreEventListener(this);
		this.modele=modele;
		this.controleur=controleur;
	}

	public void lecture_serveur() {
		try {
			modele.setServeurSocket(new ServerSocket(3000));
			historique.append("Port "+modele.getServeurSocket().getLocalPort()+ " utiliser.");
			
			modele_salon.connexion c=modele.new connexion();
			Thread thread = new Thread(c);
			thread.start(); 
		}catch (IOException e1) {
		}
	}
 
	public void actionADeclancher(AutreEvent event) {
		if (event.getSource() instanceof Controleur_salon)  {
			if(event.getDonnee() instanceof String){
				if(Objects.equals((String)event.getDonnee(),new String("envoi"))){
					if(text.getText().length()==0) return;
					Date date=new Date();
					if(joueur.getSelectedIndex()==0||joueur.getSelectedIndex()==-1){
						modele.envoiAll("Serveur : "+text.getText());
						historique.append("\n- "+date.getHours()+":"+date.getMinutes()+":"+date.getSeconds()+" Serveur : "+text.getText());
					}else{
						modele.envoi(joueur.getSelectedIndex()-1,"Serveur : "+text.getText());
						historique.append("\n- "+date.getHours()+":"+date.getMinutes()+":"+date.getSeconds()+" Chuchoter avec le joueur "+joueur.getSelectedItem()+" : "+text.getText()) ;
					}
					text.setText("");
				}
				if(Objects.equals((String)event.getDonnee(),new String("lancement"))){
					Vue_General vg=(Vue_General)lancer_partie.getTopLevelAncestor();
					vg.changementDeVue(2);
				}
			}
		}
		if (event.getSource() instanceof modele_salon){
			if(event.getDonnee() instanceof Socket){
				//r = new reception();
				historique.append("\n Joueur connecter sur le port : "+modele.getSocket().getRemoteSocketAddress());
				joueur.remove(0);
				joueur.addItem(modele.getNbJoueur()+" Joueurs", 0);
				joueur.add("Joueur "+modele.getNbJoueur());
				//thread = new Thread(r);
				//thread.start() ;
			}
			if(event.getDonnee() instanceof String){
				String msg =(String)event.getDonnee();
				StringTokenizer t = new StringTokenizer(msg,"%%%") ;
            	String test = t.nextToken() ;
            	if(msg.equals("NumeroJoueur")){
            		for(int i=0;i<=modele.getNbJoueur()-2;i++){
						modele.envoi(i,"num%%%"+modele.getNbJoueur());
						//tab[i].println("num%%%"+modele.getNbJoueur());
						//tab[i].flush();
					}
					modele.envoi(modele.getNbJoueur()-1,"Joueur%%%"+modele.getNbJoueur());
                	//tab[n-1].println("Joueur%%%"+modele.getNbJoueur()) ;
                	//tab[n-1].flush();
            	}else{
            		if(test.equals("Chuchoter")){
            			int numeroJoueur = Integer.parseInt(t.nextToken());
            			modele.envoi(numeroJoueur-1,t.nextElement());
						//tab[numeroJoueur-1].println(t.nextElement()) ;
						//tab[numeroJoueur-1].flush() ;
					}else{
						modele.envoiAll(msg);
						//tab[j].println(msg) ;
						//tab[j].flush();
						Date date= new Date();
						historique.append("\n- "+date.getHours()+":"+date.getMinutes()+":"+date.getSeconds()+" "+msg);
					}
				}
			} // fin if string
		}// fin if modele salon
	}// fin actionadeclancher






}// FIN
