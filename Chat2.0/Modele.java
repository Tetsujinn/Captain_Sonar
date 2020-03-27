package Kevin;
import java.awt.Color;
import autrevent.AutreEvent;
import autrevent.AutreEventListener;
import autrevent.AutreEventNotifieur;

import java.util.Scanner;
import java.util.Date;

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

//Joueur
public class Modele {
	private String pseudo = "";
	private String ip = "";
	private AutreEventNotifieur notifieur = new AutreEventNotifieur();
    
	public Modele(String pseudo, String ip){
		this.pseudo=pseudo;
		this.ip=ip;
	}

	public String getPseudo() {
		return pseudo;
	}

	public void setPseudo(String pseudo) {
		this.pseudo = pseudo;
		notifieur.diffuserAutreEvent(new AutreEvent(this, this.getPseudo()));
		
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
		notifieur.diffuserAutreEvent(new AutreEvent(this, this.getIp()));
		
	}
    
    public void addAutreEventListener(AutreEventListener listener) {
     notifieur.addAutreEventListener(listener);
    }
      
    public void removeAutreEventListener(AutreEventListener listener) {
        notifieur.removeAutreEventListener(listener);
    }

 
 
	/*public InetAddress Test() {
	    
	    
		InetAddress ip = null;
	        String hostname;
        try {
            ip = InetAddress.getLocalHost();
            hostname = ip.getHostName();
            System.out.println("Your current IP address : " + ip);
            System.out.println("Your current Hostname : " + hostname);
 
        } catch (UnknownHostException e) {
 
            e.printStackTrace();
       	}
       	return ip;


    }*/

}
