package Captain_sonar_test;

import java.util.Scanner;
import java.net.Socket;
import java.net.ServerSocket;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.UnknownHostException;
import java.net.Proxy;
import java.net.SocketAddress;
import java.io.IOException;
 
public class Test {
    public Test() {
    }
 
 
public static void main(String[] args) {
    boolean isRunning=true;
    int port=5678;
    int file=8;
    String ip="192.168.561.1";
    Scanner sc = new Scanner(System.in);
    ServerSocket server=null;
    System.out.println("1) Créer");
    System.out.println("2) Rejoindre");
    switch(sc.nextInt()){
    case 1:
        try{
            server= new ServerSocket(port,file,InetAddress.getByName(ip));
        }catch(IOException ioe){
            ioe.printStackTrace();
            System.out.println("Probleme");
        }
        while(isRunning){
            try{
                Socket client=server.accept();
                System.out.println("Rejoint");
            }catch(IOException ioe){
                ioe.printStackTrace();
                System.out.println("Probleme server");
            }
        }
        break;
    case 2:
        SocketAddress proxyAddress = new InetSocketAddress(ip, port);
     
            //On instancie la classe Proxy avec le type souhaité
            Proxy proxy = new Proxy(Proxy.Type.SOCKS, proxyAddress);
     
            //On crée notre socket utilisant le proxy
            Socket s = new Socket(proxy);
 
        //On crée l'adresse que l'on souhaite atteindre via le proxy
            SocketAddress remote = new InetSocketAddress("10.1.18.68", port);
         
        try{
            s.connect(remote);
        }catch(UnknownHostException uhe){
            uhe.printStackTrace();
            System.out.println("Probleme client uhe");
 
        }catch(IOException ioe){
            ioe.printStackTrace();
            System.out.println("Probleme client ioe : "+ ioe.getMessage());
        }
        break;
    }
}
}