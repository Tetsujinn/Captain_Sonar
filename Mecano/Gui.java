package Mecano;
import java.awt.Dimension;
public class Gui {

	public Gui() {
		Modele modele = new Modele();
		Controleur controleur = new Controleur(modele);
		Vue vue = new Vue(controleur, modele);
		vue.pack();
		vue.setSize(new Dimension(1025,529));
		vue.setVisible(true);

	}

	public static void main(String[] args) {
               javax.swing.SwingUtilities.invokeLater(new Runnable() {
                     public void run() {
                        new Gui();
                     }
              });
       }
  }

