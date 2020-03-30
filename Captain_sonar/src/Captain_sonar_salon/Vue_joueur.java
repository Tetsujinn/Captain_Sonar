package Captain_sonar_salon;

import java.awt.List;
import javax.swing.*;
import java.awt.TextArea;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Date;
import java.util.StringTokenizer;
import java.util.Objects;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
 
import autrevent.AutreEvent;
import autrevent.AutreEventListener;

import Captain_sonar_modele.modele_salon;
import Captain_sonar.Controleur_salon;

public class Vue_joueur extends JPanel implements AutreEventListener{
	JTextField text;
	JButton submit;
	TextArea historique;
	List l;

	//PrintWriter serveurPrint;
	//Socket socketJ;
	//Date date;
	//int compteurNumeroJoueur;

	//reception r;
	//Thread thread;

	private modele_salon modele;
	private Controleur_salon controleur;

	public Vue_joueur(Controleur_salon controleur, modele_salon modele) {
	 
		this.setLayout(null);
		historique = new TextArea();
		historique.setBounds(6, 0, 426, 215);
		historique.setEditable(false);
		this.add(historique);
	 
		text = new JTextField();
		/*text.addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent arg) {
				if(arg.getKeyCode() == KeyEvent.VK_ENTER){
					envoi();
				}
			}
		});*/
		text.setBounds(6, 241, 327, 20);
		this.add(text);
		text.setColumns(10);
		text.addKeyListener(controleur);
 
		submit = new JButton("Envoyer");
		/*submit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				envoi();
			}
		});*/
		submit.setBounds(343, 240, 134, 23);
		submit.setActionCommand("envoyer");
		submit.addActionListener(controleur);
		this.add(submit);

		l = new List();
		l.add("Serveur") ;
		l.setBounds(438, 10, 110, 191);
		this.add(l);

		modele.addAutreEventListener(this);
		controleur.addAutreEventListener(this);
		this.modele=modele;
		this.controleur=controleur;
	}
 
 
	public void lecture_joueur(){
		try {
			modele.setSocket(new Socket("localhost",3000));
			historique.append("Connecter au Serveur : "+modele.getSocket().getLocalAddress());
			 
			modele.setTab(0,new PrintWriter(modele.getSocket().getOutputStream()));
			modele.envoi(0,"NumeroJoueur");
			/*serveurPrint = new PrintWriter(modele.getSocket().getOutputStream());
			serveurPrint.println("NumeroJoueur") ;
			serveurPrint.flush() ;*/
			 
			modele_salon.reception r=modele.new reception();
			Thread thread = new Thread(r) ;
			thread.start() ;
		 
		} catch (IOException e) {
			historique.append("\nImpossible de se connecter !!! \n");
		}
	}
	
	public void actionADeclancher(AutreEvent event) {
		if (event.getSource() instanceof Controleur_salon)  {
			if(event.getDonnee() instanceof String){
				if(Objects.equals((String)event.getDonnee(),new String("envoi"))){
					if(text.getText().length()==0) return;
					Date date= new Date();
					String zeroH ="";
					String zeroM ="";
					String zeroS ="";
					int hours = date.getHours();
					if(hours<10) zeroH="0";
					int minutes = date.getMinutes();
					if(minutes<10) zeroM="0";
					int seconds= date.getSeconds();
					if(seconds<10) zeroS="0";
					if ((l.getSelectedIndex()==0)||(l.getSelectedIndex()==-1)){
						String env = " joueur "+modele.getMonNum()+" : "+text.getText();
						modele.envoi(0,env);
					}else{
						String numC=l.getSelectedItem();
						StringTokenizer t = new StringTokenizer(numC," ") ;
						String num =t.nextToken() ;
						num =t.nextToken();
						String env="Chuchoter%%%"+num+"%%%"+" joueur "+modele.getMonNum()+" : "+text.getText();
						historique.append("\n- "+zeroH+date.getHours()+":"+zeroM+date.getMinutes()+":"+zeroS+date.getSeconds()+" chuchoter avec le joueur "+num+" : "+text.getText());
						zeroH="";
						zeroM="";
						zeroS="";
						modele.envoi(0,env);
					}
					text.setText("");
				}
			}
		}
		if (event.getSource() instanceof modele_salon){
			if(event.getDonnee() instanceof String){
				String msg =(String)event.getDonnee();
				//Le jeton permet de reconaitre le numero du joueur
				StringTokenizer t = new StringTokenizer(msg,"%%%") ;
				String test = t.nextToken();
				if (test.equals("num")){
	    			int k=Integer.parseInt(t.nextToken());
	    			l.removeAll();
	    			l.add("Vers tout");
	    			for(int i=1;i<=k;i++){
						if(i!=modele.getMonNum())
							l.add("joueur "+i);
	    			}
	    		}
	    		if(test.equals("Joueur")){
					modele.setMonNum(Integer.parseInt(t.nextToken()));
					//compteurNumeroJoueur = Integer.parseInt(t.nextToken()) ;
					//setTitle("Joueur "+compteurNumeroJoueur) ;
					l.removeAll();
					l.add("Vers tout");
					for(int i=1;i<modele.getMonNum();i++){
							l.add("joueur "+i);
					}
				}else{
					//pour le jeton
					if((test.equals("NumeroJoueur"))||test.equals("num"))
					{}else{
						Date date= new Date();
						String zeroH ="";
						String zeroM ="";
						String zeroS ="";
						int hours = date.getHours();
						if(hours<10) zeroH="0";
						int minutes = date.getMinutes();
						if(minutes<10) zeroM="0";
						int seconds= date.getSeconds();
						if(seconds<10) zeroS="0";
						historique.append("\n- "+zeroH+date.getHours()+":"+zeroM+date.getMinutes()+":"+zeroS+date.getSeconds()+" "+msg);
						zeroH="";
						zeroM="";
						zeroS="";
					}
				}
			}// fin if string
		}//fin if modele_salon
	}// fin actionadeclancher


 
}// FIN
