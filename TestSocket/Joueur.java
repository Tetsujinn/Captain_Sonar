package TestSocket;
import java.util.Scanner;
import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;


public class Joueur {
	
	public Joueur() {
		

	}

	public static void main(String[] args) {
		int port=1024;
		int file=8;
		String ip= "127.0.0.1";
		ServerSocket sSocket=null;
		int isRunning=1;
		Scanner sc = new Scanner(System.in);
		System.out.println("1) Creer un salon");
		System.out.println("2) Rejoindre un salon");
		switch(sc.nextInt()){
		case 1:
			//for(int port= 1; port<10000; port++){
			try{
				sSocket= new ServerSocket(port,file,InetAddress.getByName(ip));
			}catch(IOException ioe){
				System.out.println("Probleme port: "+port);
			}
			while(isRunning==1){
				try{
					Socket client = sSocket.accept();
					System.out.println("connexion");
				}catch(IOException ioe){
					System.out.println("Probleme connexion serveur");
				}

			}
			//}
			break;
		case 2:
			try{
				Socket client=new Socket(ip,port);
			}catch(UnknownHostException uhe){
				System.out.println("Probleme connexion client");
			}catch(IOException ioe){
				System.out.println("Probleme connexion client");
			}
			break;
		default:
			break;
		}
       }
  }

