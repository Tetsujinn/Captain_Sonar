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

	reception r ;
	connexion c ;
	//ServerSocket s;
	Socket socket1;
	Date date;
	//PrintWriter [] tab = new PrintWriter[20];
	Thread thread;
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
			
			c=new connexion();
			thread = new Thread(c);
			thread.start(); // Ligne 216
		}catch (IOException e1) {
		}
	}

	public void envoi(){
		try {
		PrintWriter pw;
			if(text.getText().length()==0) return;
			if(joueur.getSelectedIndex()==0||joueur.getSelectedIndex()==-1){
				for(int j=0;j<modele.getNbJoueur();j++){
					pw=modele.getTab(j);
					pw.println("Serveur : "+text.getText());
					pw.flush();
				}
				date=new Date();
				historique.append("\n- "+date.getHours()+":"+date.getMinutes()+":"+date.getSeconds()+" Serveur : "+text.getText());
			}else{
				pw=modele.getTab(joueur.getSelectedIndex()-1);
				pw.println("Serveur : "+text.getText());
				pw.flush();
				/*tab[joueur.getSelectedIndex()-1].println("Serveur : "+text.getText());
				tab[joueur.getSelectedIndex()-1].flush() ;*/
				historique.append("\n- "+date.getHours()+":"+date.getMinutes()+":"+date.getSeconds()+" Chuchoter avec le joueur "+joueur.getSelectedItem()+" : "+text.getText()) ;
			}
		}catch(Exception e){
			//historique.append("\n - Tous les joueurs sont hors ligne");
		}
		text.setText("");
	}
 
	public void actionADeclancher(AutreEvent event) {
		if (event.getSource() instanceof Controleur_salon)  {
			if(event.getDonnee() instanceof String){
				if(Objects.equals((String)event.getDonnee(),new String("envoi"))){
					envoi();
				}
				if(Objects.equals((String)event.getDonnee(),new String("lancement"))){
					Vue_General vg=(Vue_General)lancer_partie.getTopLevelAncestor();
					vg.changementDeVue(2);
				}
			}
		}
	}



/// THREAD RECEPTION
	class reception implements Runnable{

		BufferedReader serveur;
		PrintWriter pw;
		reception(){}
     
		public void run() {
        		while(true){
        			try {
            				serveur = new BufferedReader(new InputStreamReader(socket1.getInputStream()));
            				String msg = serveur.readLine();
            				StringTokenizer t = new StringTokenizer(msg,"%%%") ;
            				String test = t.nextToken() ;
                        		if(msg.equals("NumeroJoueur")){
						for(int i=0;i<=modele.getNbJoueur()-2;i++){
							pw=modele.getTab(i);
							pw.println("num%%%"+modele.getNbJoueur());
							pw.flush();
							//tab[i].println("num%%%"+modele.getNbJoueur());
							//tab[i].flush();
						}
						pw=modele.getTab(modele.getNbJoueur()-1);
						pw.println("Joueur%%%"+modele.getNbJoueur());
						pw.flush();
                				//tab[n-1].println("Joueur%%%"+modele.getNbJoueur()) ;
                				//tab[n-1].flush();
            				}else{
					if(test.equals("Chuchoter")){
						int numeroJoueur = Integer.parseInt(t.nextToken()) ;
						pw=modele.getTab(numeroJoueur-1);
						pw.println(t.nextElement());
						pw.flush();
						//tab[numeroJoueur-1].println(t.nextElement()) ;
						//tab[numeroJoueur-1].flush() ;
                                        }else{
						date= new Date();
						for(int j=0;j<modele.getNbJoueur();j++){
							pw=modele.getTab(j);
							pw.println(msg);
							pw.flush();
							//tab[j].println(msg) ;
							//tab[j].flush();		 
						}
						historique.append("\n- "+date.getHours()+":"+date.getMinutes()+":"+date.getSeconds()+" "+msg);
					 }
					 }
				} catch (IOException e) {  
        			}
        		}//fin while(true)
    		}//fin run
	}//fin thread reception

/// THREAD CONNEXION
	class connexion implements Runnable{
		connexion(){}

		public void run() {
			try{
				while(modele.getNbJoueur()<7){
				    socket1 = modele.getServeurSocket().accept() ;
				    modele.setTab(modele.getNbJoueur(), new PrintWriter(socket1.getOutputStream()));
				    r = new reception() ;
				    historique.append("\n Joueur connecter sur le port : "+socket1.getRemoteSocketAddress());  
				    
				 
				    joueur.remove(0);
				    joueur.addItem(modele.getNbJoueur()+" Joueurs", 0);
				    joueur.add("Joueur "+modele.getNbJoueur());
				    thread = new Thread(r) ;
				    thread.start() ;
				
				}
				System.out.println("Le bouton est dispo, salon plein !");
				//lancer_partie.setEnabled(true);
			}catch (IOException e1) {
			}
		}
	}// fin thread connexion
}// FIN
