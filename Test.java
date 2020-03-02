
 
import java.util.Scanner;
import java.net.Socket;
import java.net.ServerSocket;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.UnknownHostException;
import java.net.Proxy;
import java.net.SocketAddress;
import java.io.IOException;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;

 
public class Test {
    public Test() {
    }
 
 
public static void main(String[] args) {
    boolean isRunning=true;
    int port=5678;
    int file=8;
    String ip="10.1.20.95";
    Scanner sc = new Scanner(System.in);
    ServerSocket server=null;
    Socket s = null;
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
                System.out.println("Vous avez été hacké gros CON ! !");
               BufferedInputStream bis = new BufferedInputStream(client.getInputStream());
               String reponse = "";
               int stream;
               byte[] b = new byte[1024];
               while((stream = bis.read(b)) != -1){
               	   reponse += new String(b, 0, stream);
               }
               
           // int rep = bis.read();
            System.out.println(reponse);
            
            }catch(IOException ioe){
                ioe.printStackTrace();
                System.out.println("Probleme server");
            }
        }
        break;
    case 2:
        
         
         
        try{
            s = new Socket(ip,port);
            String request = "J'envoi un message (non spoil)";
            BufferedOutputStream bos = new BufferedOutputStream(s.getOutputStream());
            bos.write(request.getBytes());
            bos.flush();
        }catch(UnknownHostException uhe){
            uhe.printStackTrace();
            System.out.println("Probleme client uhe");
        }catch(IOException ioe){
            ioe.printStackTrace();
            System.out.println("Probleme client ioe");
        }
        break;
    }
}
}
