package Second;
import java.awt.Dimension;
public class Gui {

	public Gui() {
		Modele modele = new Modele("Tetsujin","127.0.0.1");
		Controleur controleur = new Controleur(modele);
		Vue vue = new Vue(controleur, modele);
		vue.pack();
		vue.setSize(new Dimension(700,529));
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

