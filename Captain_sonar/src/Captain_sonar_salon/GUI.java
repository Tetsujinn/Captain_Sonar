package Captain_sonar_salon;

public class GUI {

	public static void main(String[] args) {
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
               Vue_General vue = new Vue_General();
            }
      });	 
	}

}
