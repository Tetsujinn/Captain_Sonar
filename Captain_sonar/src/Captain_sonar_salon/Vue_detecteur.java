package Captain_sonar_salon;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;



public class Vue_detecteur extends JFrame implements MouseListener {
	Boolean mine = false;	
	public Vue_detecteur() {
			super();
			this.setTitle("vue detecteur");
			this.setSize(1500,800);
			this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		    this.setLocationRelativeTo(null);
		    this.setLayout(new BorderLayout());
		    
		    Icon case_normal = new ImageIcon("image/case_normal.png");
		    Icon case_noir = new ImageIcon("image/case_noir.png");
		    Icon case_gris = new ImageIcon("image/case_gris.png");
		    Icon carte = new ImageIcon("image/carte.png");
		    
		    
		    
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
			
			JLabel titre = new JLabel("Les différents types de case");
			annonce.add(titre, gbc);
			JLabel case1 = new JLabel("Déplacement");
			gbc.gridy++;
			annonce.add(case1, gbc);
			JLabel case2 = new JLabel("Silence");
			gbc.gridy++;
			annonce.add(case2, gbc);
			JButton case3 = new JButton("Mine");
			/*case3.addMouseListener(new MouseAdapter()    //PROBLEME D'ACCESSIBILIE DE LA VARIABLE MINE !!!!!!
			{
			    public void mouseClicked(MouseEvent e)  
			    {
			    	JButton bouton=(JButton)e.getSource();
			    	if(mine) {
			    		bouton.getParent().setMine(false);
			    	}else {
			    		mine = true;
			    	}
			    }
			});*/
			gbc.gridy++;
			annonce.add(case3, gbc);
			
			communication.add(annonce, BorderLayout.NORTH);// --------
			
			JPanel chat = new JPanel();// ------ Partie Chat
			chat.setPreferredSize(new Dimension(400,400));
			chat.setBackground(new Color(0,0,255));
			communication.add(chat, BorderLayout.SOUTH);//-----
			
		    this.getContentPane().add(communication, BorderLayout.EAST);
		    // ----------------------- FIN PARTIE COMMUNICATION  -------------------
		    
		    // ------------ PARTIE JEU ---------------
		    /* ------A FAIRE -------
		     * Faire en sorte que quand on clique une fois on a une case noir puis gris. 
		     * Faire le drag and drop
		     */
		    JPanel Jeu = new JPanel();
		    Jeu.setLayout(new BorderLayout());
		    
		    JPanel Tab = new JPanel();
			Tab.setLayout(new GridBagLayout());
			Tab.setPreferredSize(new Dimension(1100, 400));
			
			
			JLabel grille[][] = new JLabel[15][15]; 
			
			
			
			JLabel espace = new JLabel("");
			gbc.gridy = 0;
			gbc.gridx = 0;
			Tab.add(espace, gbc);
			JLabel un = new JLabel("1");
			gbc.gridx = 0;
			gbc.gridy = 1;
			Tab.add(un,gbc);
			JLabel deux = new JLabel("2");
			gbc.gridy++;
			Tab.add(deux,gbc);
			JLabel trois = new JLabel("3");
			gbc.gridy++;
			Tab.add(trois,gbc);
			JLabel quatre = new JLabel("4");
			gbc.gridy++;
			Tab.add(quatre,gbc);
			JLabel cinq = new JLabel("5");
			gbc.gridy++;
			Tab.add(cinq,gbc);
			JLabel six = new JLabel("6");
			gbc.gridy++;
			Tab.add(six,gbc);
			JLabel sept = new JLabel("7");
			gbc.gridy++;
			Tab.add(sept,gbc);
			JLabel huit = new JLabel("8");
			gbc.gridy++;
			Tab.add(huit,gbc);
			JLabel neuf = new JLabel("9");
			gbc.gridy++;
			Tab.add(neuf,gbc);
			JLabel dix = new JLabel("10");
			gbc.gridy++;
			Tab.add(dix,gbc);
			JLabel onze = new JLabel("11");
			gbc.gridy++;
			Tab.add(onze,gbc);
			JLabel douze = new JLabel("12");
			gbc.gridy++;
			Tab.add(douze,gbc);
			JLabel treize = new JLabel("13");
			gbc.gridy++;
			Tab.add(treize,gbc);
			JLabel quatorze = new JLabel("14");
			gbc.gridy++;
			Tab.add(quatorze,gbc);
			JLabel quinze = new JLabel("15");
			gbc.gridy++;
			Tab.add(quinze,gbc);

			JLabel a = new JLabel("a");
			gbc.gridy = 0;
			gbc.gridx = 1;
			Tab.add(a,gbc);
			JLabel b = new JLabel("b");
			gbc.gridx++ ;
			Tab.add(b,gbc);
			JLabel c = new JLabel("c");
			gbc.gridx++ ;
			Tab.add(c,gbc);
			JLabel d = new JLabel("d");
			gbc.gridx++ ;
			Tab.add(d,gbc);
			JLabel e = new JLabel("e");
			gbc.gridx++ ;
			Tab.add(e,gbc);
			JLabel f = new JLabel("f");
			gbc.gridx++ ;
			Tab.add(f,gbc);
			JLabel g = new JLabel("g");
			gbc.gridx++ ;
			Tab.add(g,gbc);
			JLabel h = new JLabel("h");
			gbc.gridx++ ;
			Tab.add(h,gbc);
			JLabel i = new JLabel("i");
			gbc.gridx++ ;
			Tab.add(i,gbc);
			JLabel j = new JLabel("j");
			gbc.gridx++ ;
			Tab.add(j,gbc);
			JLabel k = new JLabel("k");
			gbc.gridx++ ;
			Tab.add(k,gbc);
			JLabel l = new JLabel("l");
			gbc.gridx++ ;
			Tab.add(l,gbc);
			JLabel m = new JLabel("m");
			gbc.gridx++ ;
			Tab.add(m,gbc);
			JLabel n = new JLabel("n");
			gbc.gridx++ ;
			Tab.add(n,gbc);
			JLabel o = new JLabel("o");
			gbc.gridx++ ;
			Tab.add(o,gbc);
		    
			
			
			
			gbc.gridx = 0;
			gbc.gridy = 1;
			for (int x = 0; x<15; x++) {
				for (int y = 0; y<15; y++) {
					grille[x][y] = new JLabel();
					grille[x][y].setIcon(case_normal);
					gbc.gridx++;
					Tab.add(grille[x][y],gbc);
					grille[x][y].addMouseListener(new MouseAdapter()  
					{
					    public void mouseClicked(MouseEvent e)  
					    {  
					    	
					    	JLabel label=(JLabel)e.getSource();
					    	if(mine) {
					    		if(label.getIcon() == case_normal) {
					    		//	label.setIcon(case_normal_mine);
					    		}else if(label.getIcon() == case_noir){
					    		//	label.setIcon(case_noir_mine);
					    		}else {
					    		//	label.setIcon(case_gris_mine);
					    		}
					    	}else {
					    		if(label.getIcon() == case_normal) {
					    			label.setIcon(case_noir);
					    		}else if(label.getIcon() == case_noir){
					    			label.setIcon(case_gris);
					    		}else {
					    			label.setIcon(case_normal);
					    		}
					    	}
					    }  
					});
				}
				gbc.gridy++;
				gbc.gridx = 0;
			}
		    
			
		    
		    
		    JPanel map = new JPanel();
		    JLabel map_lab = new JLabel();
		    map_lab.setIcon(carte);
		    map_lab.setPreferredSize(new Dimension(1100,400));
		    map.add(map_lab);
		    map.setPreferredSize(new Dimension(1100,400));
		    Jeu.add(map, BorderLayout.NORTH);
		    Jeu.add(Tab, BorderLayout.SOUTH);
		    this.getContentPane().add(Jeu, BorderLayout.CENTER);
		    
		    //--------------- FIN PARTIE JEU-------------------
		 
		}
		public void setMine(boolean bool_mine) {
			 this.mine = bool_mine;
		 }


		
		public void mouseClicked(MouseEvent e) {
			System.out.println("bizarre");
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

