package Captain_sonar;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JLabel;

public class Controleur implements MouseListener{
	public Controleur() {
	}
	
	public void mouseClicked(MouseEvent e) {
		System.out.println("test reussi");
	}
	public void mouseEntered(MouseEvent e) {
	}
	public void mouseExited(MouseEvent e) { 
	}
	public void mousePressed(MouseEvent e) { 
	}
	public void mouseReleased(MouseEvent e) {
	}
}

/*public class ControleurJLabelCliquable implements MouseListener {
//les attributs
private JLabel _lblPlus;
private Cursor _cursor;
 
public ControleurJLabelCliquable(JLabel lblPlus) {
    _lblPlus = lblPlus;
    _cursor = new Cursor(Cursor.DEFAULT_CURSOR);
}

@Override
public void mouseClicked(MouseEvent e) {
    javax.swing.JOptionPane.showMessageDialog(null, "Ceci est un test du clic !", "Erreur", javax.swing.JOptionPane.INFORMATION_MESSAGE);
     
}

@Override
public void mouseEntered(MouseEvent e) {
    _cursor = new Cursor(Cursor.HAND_CURSOR);
}

@Override
public void mouseExited(MouseEvent e) {
    _cursor = new Cursor(Cursor.DEFAULT_CURSOR);   
}

@Override
public void mousePressed(MouseEvent e) {
    // TODO Auto-generated method stub 
}

@Override
public void mouseReleased(MouseEvent e) {
    // TODO Auto-generated method stub
*/
