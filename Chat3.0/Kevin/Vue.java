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
    Socket s[] = new Socket[7];
    int nombre_client = 7;
    boolean isRunning=true;	
    int port=5678;
    int file=8;
    InetAddress ip = null;
    Scanner sc = new Scanner(System.in);
    JButton quit = null;

    TextArea historique;
    String Newligne=System.getProperty("line.separator");

	        

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
		

		/*text = new JTextField("");
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
		grille.add(submit);*/

		historique = new TextArea();
		historique.setBounds(50, 0, 426, 215);
		grille.add(historique);

		
		modele.addAutreEventListener(this);
		controleur.addAutreEventListener(this);
	}


	public void actionADeclancher(AutreEvent event) {
		//if (event.getSource() instanceof Modele && event.getDonnee() instanceof String)  {
		if(event.getDonnee() instanceof String)
			if(Objects.equals((String)event.getDonnee(),new String("create"))){
				System.out.println(" Vue create");
				final ServerSocket serveurSocket  ;
			    final Socket client[] = new Socket[7];
			    final BufferedReader in,in1,in2,in3,in4,in5,in6;
			    final PrintWriter out,out2,out3,out4,out1,out5,out6;
			    final Scanner sc=new Scanner(System.in);
			  
			    try {
			  	  	serveurSocket = new ServerSocket(5000);
			  	  	for(int i=0; i!=7; i++){
			      		client[i] = serveurSocket.accept();
			      		d2= new Date();
			      		historique.append("- "+d2.getHours()+":"+d2.getMinutes()+":"+d2.getSeconds()+" "+"Client"+ i+" : Vient de se connecter"+Newligne);
			      	}

			      	out = new PrintWriter(client[0].getOutputStream());
			      	in = new BufferedReader (new InputStreamReader (client[0].getInputStream()));
			      	out1 = new PrintWriter(client[1].getOutputStream());
			      	in1 = new BufferedReader (new InputStreamReader (client[1].getInputStream()));
			      	out2 = new PrintWriter(client[2].getOutputStream());
			      	in2 = new BufferedReader (new InputStreamReader (client[2].getInputStream()));
			      	out3 = new PrintWriter(client[3].getOutputStream());
			      	in3 = new BufferedReader (new InputStreamReader (client[3].getInputStream()));
			      	out4 = new PrintWriter(client[4].getOutputStream());
			      	in4 = new BufferedReader (new InputStreamReader (client[4].getInputStream()));
			      	out5 = new PrintWriter(client[5].getOutputStream());
			      	in5 = new BufferedReader (new InputStreamReader (client[5].getInputStream()));
			      	out6 = new PrintWriter(client[6].getOutputStream());
			      	in6 = new BufferedReader (new InputStreamReader (client[6].getInputStream()));
			      	String message ="";
			      		
			      	out.println(message);
			        out.flush();
			  		out1.println(message);
             		out1.flush();
               		out2.println(message);
	          		out2.flush();
		       		out3.println(message);
			        out3.flush();
		       		out4.println(message);
			      	out4.flush();
	        		out5.println(message);
			        out5.flush();
		       		out6.println(message);
		    		out6.flush();
			      
			      	
			      	Thread envoi= new Thread(new Runnable() {
			      	   String message;
			      	   @Override
			      	   public void run() {
			      	    	while(true){
			            	   	message = sc.nextLine();  
			            	   	d2= new Date();
			            	   	historique.append("- "+d2.getHours()+":"+d2.getMinutes()+":"+d2.getSeconds()+" "+"Serveur : "+message+Newligne);
			               		out.println(message);
			               		out.flush();
			               		out1.println(message);
			               		out1.flush();
			               		out2.println(message);
			               		out2.flush();
			               		out3.println(message);
			               		out3.flush();
			               		out4.println(message);
			               		out4.flush();
			               		out5.println(message);
			               		out5.flush();
			               		out6.println(message);
			               		out6.flush();

			            	}	
			        	}
			     	});
			      	envoi.start();
			   		

			   		Thread recevoir= new Thread(new Runnable() {
			         	String message ;
			         	int numeroClient;
			         	@Override
			         	public void run() {
			         	   	try {
			         	   		if(in.readLine()==null){
			         	   			message = in.readLine();
			            	   		numeroClient = 0;}
			            	   	if(in1.readLine()==null){
			         	   			message = in1.readLine();
			            	   		numeroClient = 1;}
			            	   	if(in2.readLine()==null){
			         	   			message = in2.readLine();
			            	   		numeroClient = 2;}
			            	   	if(in3.readLine()==null){
			         	   			message = in3.readLine();
			            	   		numeroClient = 3;}
			            	   	if(in4.readLine()==null){
			         	   			message = in4.readLine();
			            	   		numeroClient = 4;}
			            	   	if(in5.readLine()==null){
			         	   			message = in5.readLine();
			            	   		numeroClient = 5;}
			            	   	if(in.readLine()==null){
			         	   			message = in6.readLine();
			            	   		numeroClient = 6;}

			         	   			

			            	   


			            	   /*if(in.readLine()==null)
			            	   {
			            	   		if(in1.readLine()==null){
			            	   			if(in2.readLine()==null){
			            	   				if(in3.readLine()==null){
			            	   					if(in4.readLine()==null){
			            	   						if(in5.readLine()==null){
			            	   							if(in6.readLine()==null){

			            	   							}else{
			            	   								message = in6.readLine();
			            	   								numeroClient = 6;
			            	   							}
			            	   						}else{
			            	   							message = in5.readLine();
			            	   							numeroClient = 5;
			            	   						}
			            	   					}else{
			            	   						message = in4.readLine();
			            	   						numeroClient = 4;
			            	   					}
			            	   				}else{
			            	   					message = in3.readLine();
			            	   					numeroClient = 3;
			            	   				}
			            	   			}else{
			            	   				message = in2.readLine();
			            	   				numeroClient = 2;
			            	   			}
			            	   		}else{
			            	   			message = in1.readLine();
			            	   			numeroClient = 1;
			            	   		}
			            	   	}else{
			            	   		message = in.readLine();
			            	   		numeroClient = 0;
			            	   	}*/


			            	   //	message = in.readLine();
			            	   	//tant que le client est connecté
			            	   	while(message!=null){
			            			d2= new Date();
			                  		historique.append("- "+d2.getHours()+":"+d2.getMinutes()+":"+d2.getSeconds()+" "+ "Client"+(numeroClient+1)+" : "+message+Newligne);
			                  		out.println(message);
			               		out.flush();
			               		out1.println(message);
			               		out1.flush();
			               		out2.println(message);
			               		out2.flush();
			               		out3.println(message);
			               		out3.flush();
			               		out4.println(message);
			               		out4.flush();
			               		out5.println(message);
			               		out5.flush();
			               		out6.println(message);
			               		out6.flush();
			               		
			               		if(numeroClient==0)
			                  		message = in.readLine();
			                  	if(numeroClient==1)
			                  		message = in1.readLine();
			                  	if(numeroClient==2)
			                  		message = in2.readLine();
			                  	if(numeroClient==3)
			                  		message = in3.readLine();
			                  	if(numeroClient==4)
			                  		message = in4.readLine();
			                  	if(numeroClient==5)
			                  		message = in5.readLine();
			                  	if(numeroClient==6)
			                  		message = in6.readLine();

			               		}
			               		/*//POUR UN CLIENT sortir de la boucle si le client a déconecté
			               		historique.append("Client déconecté");
			               		//fermer le flux et la session socket
			               		out.close();
			               		client.close();
			               		serveurSocket.close();*/
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
		        String tes="";
		        out.println(tes);
		        out.flush();
		   
		        Thread envoyer = new Thread(new Runnable() {
		           	String message;
		            @Override
		            public void run() {
		             	while(true){
		                	message = sc.nextLine();
		                	d2= new Date();
		                	//N'ecrit pas le message qu'il envoi car le serveur lui renvoie le messagehistorique.append("- "+d2.getHours()+":"+d2.getMinutes()+":"+d2.getSeconds()+" "+"Client : "+message+Newligne);
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

			                    historique.append("- "+d2.getHours()+":"+d2.getMinutes()+":"+d2.getSeconds()+" "+"Serveur : "+message+Newligne);
			                    message = in.readLine();
			                }
			               historique.append("Serveur déconecté");
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
