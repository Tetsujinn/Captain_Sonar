import java.awt.TextArea;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Date;
import java.util.StringTokenizer;
 
 
public class reception extends Serveur implements Runnable
{
     
    Socket socket ;
    BufferedReader serveur ;
    TextArea text ;
    Date date ;
     
    reception(TextArea text,Socket socket)
    {
        this.socket=socket ;
        this.text=text ;
               
    }
     
    public void run() {
         
        while(true){
        BufferedReader serveur;
        try {
            serveur = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            String msg = serveur.readLine();
             
            StringTokenizer t = new StringTokenizer(msg,"%%%") ;
            String test = t.nextToken() ;
             
                        if(msg.equals("NumeroJoueur"))
            {
                            for(int i=0;i<=n-2;i++){
                                
                                tab[i].println("num%%%"+n);
                                tab[i].flush();
                            }
                            
                tab[n-1].println("Joueur%%%"+n) ;
                tab[n-1].flush();
                                 
            }
            else
            {
            if(test.equals("Chuchoter"))
            {
                 
                int numeroJoueur = Integer.parseInt(t.nextToken()) ;
                tab[numeroJoueur-1].println(t.nextElement()) ;
                tab[numeroJoueur-1].flush() ;
                                        }
            else{
            date= new Date();
            for(int j=0;j<n;j++)
            {
                tab[j].println(msg) ;
                tab[j].flush();
                                 
            }
            text.append("\n- "+date.getHours()+":"+date.getMinutes()+":"+date.getSeconds()+" "+msg);
            }
            }
        } catch (IOException e) {
             
        }
         
        }
         
    }
}