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
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
 
public class Joueur extends JFrame {
private JTextField text;
JButton submit;
PrintWriter serveurPrint;
TextArea historique;
Socket socketJ;
Date date;
int compteurNumeroJoueur ;
private JTextField numJoueur;
JLabel label ;
List l;
public Joueur() {
 
getContentPane().setLayout(null);
setAlwaysOnTop(true) ;
historique = new TextArea();
historique.setBounds(6, 0, 426, 215);
getContentPane().add(historique);
 
text = new JTextField();
text.addKeyListener(new KeyAdapter() {
 
public void keyPressed(KeyEvent arg) {
 
if(arg.getKeyCode() == KeyEvent.VK_ENTER)
{
envoi();
}
}
});
text.setBounds(6, 241, 327, 20);
getContentPane().add(text);
text.setColumns(10);
 
submit = new JButton("Envoyer");
 
 
submit.setBounds(343, 240, 134, 23);
 
getContentPane().add(submit);
l = new List();
 l.add("Serveur") ;
 
l.setBounds(438, 10, 110, 191);
getContentPane().add(l);

 
submit.addActionListener(new ActionListener() {
public void actionPerformed(ActionEvent arg0) {
envoi();
}
});

}
 
 
public void lecture_joueur()
{
     
try {
socketJ = new Socket("localhost",3000);
historique.append("Connecter au Serveur : "+socketJ.getLocalAddress());
String msg;
 
serveurPrint = new PrintWriter(socketJ.getOutputStream());
serveurPrint.println("NumeroJoueur") ;
serveurPrint.flush() ;
 
while(true)
{
BufferedReader cap_serveur = new BufferedReader(new InputStreamReader(socketJ.getInputStream()));
msg = cap_serveur.readLine();
//Le jeton permet de reconaitre le numero du joeueur
StringTokenizer t = new StringTokenizer(msg,"%%%") ;
String test = t.nextToken() ;
 
 
if (test.equals("num")){
    int k=Integer.parseInt(t.nextToken());
    l.removeAll();
    l.add("Vers tout");
    for(int i=1;i<=k;i++){
        if(i!=compteurNumeroJoueur)
        l.add("joueur "+i);
    }
}
 
 
 
if(test.equals("Joueur"))
{
     compteurNumeroJoueur = Integer.parseInt(t.nextToken()) ;
    setTitle("Joueur "+compteurNumeroJoueur) ;
        l.removeAll();
        l.add("Vers tout");
        for(int i=1;i<compteurNumeroJoueur;i++){
            l.add("joueur "+i);
        }
         
}
else
	//pour le jeton
{ if((test.equals("NumeroJoueur"))||test.equals("num"))
{}else{
date= new Date();
historique.append("\n- "+date.getHours()+":"+date.getMinutes()+":"+date.getSeconds()+" "+msg);
}
}
 
}
 
} catch (IOException e) {
 
historique.append("\nImpossible de se connecter !!! \n");
}
 
 
}
 
public void envoi()
{
 
try {
 
if(text.getText().length()==0) return;
if ((l.getSelectedIndex()==0)||(l.getSelectedIndex()==-1)){
String env = " joueur "+compteurNumeroJoueur+" : "+text.getText();
serveurPrint.println(env);
serveurPrint.flush();}
else{
    String numC=l.getSelectedItem();
    StringTokenizer t = new StringTokenizer(numC," ") ;
String num =t.nextToken() ;
num =t.nextToken();
    String env="Chuchoter%%%"+num+"%%%"+" joueur "+compteurNumeroJoueur+" : "+text.getText();
historique.append("\n- "+date.getHours()+":"+date.getMinutes()+":"+date.getSeconds()+" chuchoter avec le joueur "+num+" : "+text.getText());
    serveurPrint.println(env);
serveurPrint.flush();
}
 
 
 
 
 
} catch (Exception e) {
 
}
text.setText("");
}
 
 
 
 
 
 
 
public static void main( String atgv[] )
{
Joueur f = new Joueur();
f.setVisible(true);
f.setSize(600,350);
f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
f.lecture_joueur();
 
}
}