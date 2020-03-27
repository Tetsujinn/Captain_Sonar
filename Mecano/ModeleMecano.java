package Mecano;
import java.awt.Color;
import autrevent.AutreEvent;
import autrevent.AutreEventListener;
import autrevent.AutreEventNotifieur;


//Joueur
public class ModeleMecano {
	private boolean pannes[] = new boolean[24];
	private int pipe1[]={0,5,6,12};
	private int pipe2[]={1,10,13,14};
	private int pipe3[]={3,9,15,17};
	private int pipeO[]={0,6,7,12,18,19};
	private int pipeN[]={1,2,8,13,14,20};
	private int pipeS[]={3,4,9,15,16,21};
	private int pipeE[]={5,10,11,17,22,23};
	private int vie=3;
	private AutreEventNotifieur notifieur = new AutreEventNotifieur();
    
	public ModeleMecano(){
		for(int i=0;i<24;i++)
			this.pannes[i]=false;
	}

	public int getVie() {
		return vie;
	}

	public void setVie(int vie) {
		this.vie = vie;
		notifieur.diffuserAutreEvent(new AutreEvent(this, new String("vie")));
	}

	public void modify(int index) {
		this.pannes[index] = true;
	}

	public boolean checkP1() {
		boolean result=true;
		for(int i:this.pipe1){
			result=result&&this.pannes[i];
		}
		return result;
	}

	public void resetP1() {
		for(int i:this.pipe1){
			this.pannes[i]=false;
		}
		notifieur.diffuserAutreEvent(new AutreEvent(this, new String("resetP1")));
	}

	public boolean checkP2() {
		boolean result=true;
		for(int i:this.pipe2){
			result=result&&this.pannes[i];
		}
		return result;
	}

	public void resetP2() {
		for(int i:this.pipe2){
			this.pannes[i]=false;
		}
		notifieur.diffuserAutreEvent(new AutreEvent(this, new String("resetP2")));
	}

	public boolean checkP3() {
		boolean result=true;
		for(int i:this.pipe3){
			result=result&&this.pannes[i];
		}
		return result;
	}

	public void resetP3() {
		for(int i:this.pipe3){
			this.pannes[i]=false;
		}
		notifieur.diffuserAutreEvent(new AutreEvent(this, new String("resetP3")));
	}

	public void resetAll(){
		for(int i=0;i<24;i++)
			this.pannes[i]=false;
		notifieur.diffuserAutreEvent(new AutreEvent(this, new String("resetAll")));
	}

	public boolean checkOuest() {
		boolean result=true;
		for(int i:this.pipeO){
			result=result&&this.pannes[i];
		}
		return result;
	}
	
	public boolean checkNord() {
		boolean result=true;
		for(int i:this.pipeN){
			result=result&&this.pannes[i];
		}
		return result;
	}

	public boolean checkSud() {
		boolean result=true;
		for(int i:this.pipeS){
			result=result&&this.pannes[i];
		}
		return result;
	}
	
	public boolean checkEst() {
		boolean result=true;
		for(int i:this.pipeE){
			result=result&&this.pannes[i];
		}
		return result;
	}
	
	public boolean checkRad() {
		boolean result=true;
		for(int i=18;i<24;i++){
			result=result&&this.pannes[i];
		}
		return result;
	}
    
    public void addAutreEventListener(AutreEventListener listener) {
     notifieur.addAutreEventListener(listener);
    }
      
    public void removeAutreEventListener(AutreEventListener listener) {
        notifieur.removeAutreEventListener(listener);
    }

}
