import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;


public class Salle {
	
	Date arriveeDansLaSalle;
	int tempsAttente; 
	int tempsConsulation;
	SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");

	public Date getArriveeDansLaSalle() {
		return arriveeDansLaSalle;
	}

	public void setArriveeDansLaSalle(Date arriveeDansLaSalle) {
		this.arriveeDansLaSalle = arriveeDansLaSalle;
	}

	public int getTempsAttente() {
		return tempsAttente;
	}

	public void setTempsAttente(int tempsAttente) {
		this.tempsAttente = tempsAttente;
	}
	
	public String toString() {
		return sdf.format(this.arriveeDansLaSalle)+" ----- temps d'attente : "+this.tempsAttente +"mns";
	}
	
	
	public void genererTempsConsultation(int moyenne,int ecart_type) {
		Random var = new Random();
		//1 hour and std-deviation 15 minutes you'll need to call it as
		//System.out.println(var.nextGaussian()*15+60); 		
		System.out.println(var.nextGaussian()*ecart_type+moyenne); 
		
	}
	
	

}
