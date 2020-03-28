package Captain_sonar_salon;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Vue_capitain extends JPanel{
	public Vue_capitain() {
		super();
		
	    this.setLayout(new BorderLayout());
	    
	    Icon carte = new ImageIcon("../image/carte.png");
	    
	    GridBagConstraints gbc = new GridBagConstraints();
	    
	    //---------------partie COMMUNICATION----------------
	    /* ------------------A FAIRE--------------
	     * ajouter la partie chat
	     */
	    JPanel communication = new JPanel();
	    communication.setLayout(new BorderLayout());
		communication.setPreferredSize(new Dimension(400, 800));
		
		JPanel annonce = new JPanel();// ----- Partie annonce
		annonce.setLayout(new GridBagLayout());
		annonce.setPreferredSize(new Dimension(400,400));
		annonce.setBackground(new Color(0,0,255));
		gbc.gridy = 0;
		gbc.gridx = 0;
		JLabel titre = new JLabel("Deplacement");
		annonce.add(titre, gbc);
		JButton case1 = new JButton("Sud");
		gbc.gridy++;
		annonce.add(case1, gbc);
		JButton case2 = new JButton("Nord");
		gbc.gridy++;
		annonce.add(case2, gbc);
		JButton case3 = new JButton("Est");
		gbc.gridy++;
		annonce.add(case3, gbc);
		JButton case4 = new JButton("Ouest");
		gbc.gridy++;
		annonce.add(case4, gbc);
		JLabel titre2 = new JLabel("systeme");
		gbc.gridy = 0;
		gbc.gridx++;
		annonce.add(titre2, gbc);
		JButton case5 = new JButton("torpille");
		gbc.gridy++;
		annonce.add(case5, gbc);
		JButton case6 = new JButton("mine");
		gbc.gridy++;
		annonce.add(case6, gbc);
		JButton case7 = new JButton("drone");
		gbc.gridy++;
		annonce.add(case7, gbc);
		JButton case8 = new JButton("sonar");
		gbc.gridy++;
		annonce.add(case8, gbc);
		JButton case9 = new JButton("silence");
		gbc.gridy++;
		annonce.add(case9, gbc);
		JButton case10 = new JButton("surface");
		gbc.gridx = 0;
		gbc.gridy = 6;
		annonce.add(case10, gbc);
		
		
		communication.add(annonce, BorderLayout.NORTH);// --------
		
		JPanel chat = new JPanel();// ------ Partie Chat
		chat.setPreferredSize(new Dimension(400,400));
		chat.setBackground(new Color(0,0,255));
		communication.add(chat, BorderLayout.SOUTH);//-----
		
	    this.add(communication, BorderLayout.EAST);
	    // ----------------------- FIN PARTIE COMMUNICATION  -------------------
	    
	    // ------------ PARTIE JEU ---------------
	    /* ------A FAIRE -------
	     * Faire en sorte que quand on clique une fois on a une case noir puis gris. 
	     * Faire le drag and drop
	     */
	    JPanel Jeu = new JPanel();
	    Jeu.setLayout(new BorderLayout());
	    JPanel map = new JPanel();
	    JLabel map_lab = new JLabel();
	    map_lab.setIcon(carte);
	    map_lab.setPreferredSize(new Dimension(1100,400));
	    map.add(map_lab);
	    map.setPreferredSize(new Dimension(1100,400));
	    Jeu.add(map, BorderLayout.NORTH);
	    this.add(Jeu, BorderLayout.CENTER);
	    
	    //--------------- FIN PARTIE JEU-------------------
	    
	}
	
}
