package Kevin;
import java.util.Objects;
import java.util.StringTokenizer;
import java.util.Date;
import java.util.Scanner;

import java.net.Socket;
import java.net.ServerSocket;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.UnknownHostException;
import java.net.Proxy;
import java.net.SocketAddress;
import java.net.InetAddress;
import java.net.UnknownHostException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.IOException;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GraphicsConfiguration;
import java.awt.GridLayout;
import java.awt.FlowLayout;
import java.awt.HeadlessException;
import java.awt.Font;
import java.awt.BorderLayout;
import java.awt.TextArea;

import javax.swing.*;
import javax.swing.ImageIcon;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import autrevent.AutreEvent;
import autrevent.AutreEventListener;

public class Vue extends JFrame implements AutreEventListener{
	JTextField text = null;
	TextArea zoneText ;
	ServerSocket server=null;
    Socket s = null;
    boolean isRunning=true;	
    int port=5678;
    int file=8;
    InetAddress ip = null;
    Scanner sc = new Scanner(System.in);
    JButton quit = null;

	        

    Date d2 ;
   // static PrintWriter [] tab = new PrintWriter[20] ;

	public Vue(Controleur controleur, Modele modele) {
		super();
		Box tout = new Box( BoxLayout.Y_AXIS);
		this.setContentPane(tout);
		JPanel grille = new ImagePanel(new ImageIcon("fond.jpg").getImage());
		tout.add(grille);
		grille.setLayout(new FlowLayout());

		JButton create = new JButton("Creer un salon");
		create.setActionCommand("create");
		create.addActionListener(controleur);
		grille.add(create);
		
		JButton join = new JButton("Rejoindre un salon");
		join.setActionCommand("join");
		join.addActionListener(controleur);
		grille.add(join);
		
		quit = new JButton("Quitter");
		quit.setActionCommand("quit");
		quit.addActionListener(controleur);
		grille.add(quit);
		

		text = new JTextField("");
		   // tab[7] = new PrintWriter(con.getOutputStream()) ;
		//JLabel label = new JLabel("Text");
		//text.setBounds(1600, 150, 90, 300);
    	Font police = new Font("Arial", Font.BOLD, 14);
    	text.setFont(police);
    	text.setPreferredSize(new Dimension(200, 30));
    	grille.add(text);

   		JButton submit = new JButton("Envoyer");
		submit.setActionCommand("submit");
		submit.addActionListener(controleur);
		grille.add(submit);

		
		modele.addAutreEventListener(this);
		controleur.addAutreEventListener(this);
	}


	public void actionADeclancher(AutreEvent event) {
		//if (event.getSource() instanceof Modele && event.getDonnee() instanceof String)  {
		if(event.getDonnee() instanceof String)
			if(Objects.equals((String)event.getDonnee(),new String("create"))){
				System.out.println(" Vue create");
				final ServerSocket serveurSocket  ;
			    final Socket client ;
			    final BufferedReader in;
			    final PrintWriter out;
			    final Scanner sc=new Scanner(System.in);
			  
			    try {
			  	  	serveurSocket = new ServerSocket(5000);
			      	client = serveurSocket.accept();
			      	out = new PrintWriter(client.getOutputStream());
			      	in = new BufferedReader (new InputStreamReader (client.getInputStream()));
			      	Thread envoi= new Thread(new Runnable() {
			      	   String message;
			      	   @Override
			      	   public void run() {
			      	    	while(true){
			            	   	message = sc.nextLine();  
			               		out.println(message);
			               		out.flush();
			            	}	
			        	}
			     	});
			      	envoi.start();
			   		

			   		Thread recevoir= new Thread(new Runnable() {
			         	String message ;
			         	@Override
			         	public void run() {
			         	   	try {
			            	   	message = in.readLine();
			            	   	//tant que le client est connecté
			            	   	while(message!=null){
			            			d2= new Date();
			                  		System.out.println("- "+d2.getHours()+":"+d2.getMinutes()+":"+d2.getSeconds()+" "+ "Client : "+message);
			                  		message = in.readLine();
			               		}
			               		//sortir de la boucle si le client a déconecté
			               		System.out.println("Client déconecté");
			               		//fermer le flux et la session socket
			               		out.close();
			               		client.close();
			               		serveurSocket.close();
			            	} 
			            	catch (IOException e) {
			                 	e.printStackTrace();
			            	}
			        	}
			     	});
			      	recevoir.start();
			    }	
			    catch (IOException e) {
			    e.printStackTrace();
			}
        
		}		

		if(Objects.equals((String)event.getDonnee(),new String("join"))){
			System.out.println(" Vue join");

			final Socket client;
		    final BufferedReader in;
		    final PrintWriter out;
		    final Scanner sc = new Scanner(System.in);
		  
		    try {

		        client = new Socket("127.0.1.1",5000);
		   
		        out = new PrintWriter(client.getOutputStream());
		        in = new BufferedReader(new InputStreamReader(client.getInputStream()));
		   
		        Thread envoyer = new Thread(new Runnable() {
		           	String message;
		            @Override
		            public void run() {
		             	while(true){
		                	message = sc.nextLine();
		                	out.println(message);
		                	out.flush();
		                }
		            }
		        });
		        envoyer.start();
		   
		        Thread recevoir = new Thread(new Runnable() {
		            String message;
		            @Override
		            public void run() {
		            	try {
			                message = in.readLine();
			                while(message!=null){
			                	d2= new Date();

			                    System.out.println("- "+d2.getHours()+":"+d2.getMinutes()+":"+d2.getSeconds()+" "+"Serveur : "+message);
			                    message = in.readLine();
			                }
			                System.out.println("Serveur déconecté");
			                out.close();
			                client.close();
		            	} 
		            	catch (IOException e) {
		                  	e.printStackTrace();
		               	}
		           	}
		        });
		        recevoir.start();

		   	} 
		   	catch (IOException e) {
		       	e.printStackTrace();
		    }

		}


		if(Objects.equals((String)event.getDonnee(),new String("submit"))){
			System.out.println(text.getText());

			
		}

    }

}
