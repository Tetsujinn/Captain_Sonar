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
 
 
 
public class Serveur extends JFrame {
 
private JTextField text;
TextArea historique;
JButton submit;
 
ServerSocket s;
Socket socket1;
Date date;
static PrintWriter [] tab = new PrintWriter[20] ;
Thread thread ;
reception r ;
static int n = 0 ;
List joueur ;
public Serveur() {
    setAlwaysOnTop(true) ;
     
//setResizable(false);
setTitle("Serveur");
getContentPane().setLayout(null);
 
historique = new TextArea();
historique.setBounds(6, 0, 426, 214);
getContentPane().add(historique);
 
text = new JTextField();
text.setBounds(10, 239, 327, 20);
getContentPane().add(text);
text.setColumns(10);
 
 
text.addKeyListener(new KeyAdapter() {
@Override
public void keyPressed(KeyEvent arg0) {
 
if(arg0.getKeyCode()== KeyEvent.VK_ENTER)
{
envoi();
}
}
});
 
 
submit = new JButton("Envoyer");
 
 
submit.setBounds(343, 240, 110, 23);
 
 
getContentPane().add(submit);
 joueur = new List();
 joueur.add("Aucun Joueur") ;
joueur.setBounds(438, 10, 110, 191);
getContentPane().add(joueur);
 
 
 
 
submit.addActionListener(new ActionListener() {
public void actionPerformed(ActionEvent arg0) {
envoi();
}
});
 
 
 
 
}
 
public void lecture_serveur()
{
try {
s = new ServerSocket(3000);
historique.append("Port "+s.getLocalPort()+ " utiliser.");
 
 
while(true)
     
{
    socket1 = s.accept() ;
    tab[n] = new PrintWriter(socket1.getOutputStream()) ;
    r = new reception(historique,socket1) ;
    historique.append("\n Joueur connecter sur le port : "+socket1.getRemoteSocketAddress());  
    n++ ;
 
    joueur.remove(0);
    joueur.addItem(n+" Joueurs", 0) ;
    joueur.add("Joueur "+n) ;
    thread = new Thread(r) ;
    thread.start() ;
         
 
}
}catch (IOException e1) {
 
}
 
}
 
public void envoi(){
PrintWriter serveurPrint;
 
try {
 
serveurPrint = new PrintWriter(socket1.getOutputStream());
if(text.getText().length()==0) return;
if(joueur.getSelectedIndex()==0||joueur.getSelectedIndex()==-1)
{
for(int j=0;j<n;j++)
{
tab[j].println("Serveur : "+text.getText());
tab[j].flush();
}
date=new Date();
historique.append("\n- "+date.getHours()+":"+date.getMinutes()+":"+date.getSeconds()+" Serveur : "+text.getText());
}
else
{
    tab[joueur.getSelectedIndex()-1].println("Serveur : "+text.getText());
    tab[joueur.getSelectedIndex()-1].flush() ;
    historique.append("\n- "+date.getHours()+":"+date.getMinutes()+":"+date.getSeconds()+" Chuchoter avec le joueur "+joueur.getSelectedItem()+" : "+text.getText()) ;
}
} catch (Exception e) {
//historique.append("\n - Tous les joueurs sont hors ligne");
}
text.setText("");
}
 
 
 
 
 
 
 
public static void main( String atgv[] )
{
Serveur f = new Serveur();
f.setVisible(true);
f.setSize(600,350);
f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
f.lecture_serveur();
 
}
}