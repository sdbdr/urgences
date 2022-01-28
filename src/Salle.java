import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;


public class Salle {
	
	Date arriveeDansLaSalle;
	int tempsAttente; 
	int tempsConsulation;
	SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");
	
	public Salle() {
		this.setTempsConsulation(genererTempsConsultation(3,1));
	}
	
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
	
	
	public int getTempsConsulation() {
		return tempsConsulation;
	}

	public void setTempsConsulation(int tempsConsulation) {
		this.tempsConsulation = tempsConsulation;
	}

	/*public String toString() {
		return "\n Arrivee : "+sdf.format(this.arriveeDansLaSalle)+"\n Temps d'attente : "+this.tempsAttente +"mns \n Temps consultation : "+this.tempsConsulation;
	}*/
	
	public String toString() {
		return sdf.format(this.arriveeDansLaSalle)+"; attente : "+this.tempsAttente +"; consultation : "+this.tempsConsulation;
	}
	
	
	public int genererTempsConsultation(int moyenne,int ecart_type) {
		Random var = new Random();
		//1 hour and std-deviation 15 minutes you'll need to call it as
		//System.out.println(var.nextGaussian()*15+60); 		
		int varAleatoire = (int) (var.nextGaussian()*ecart_type+moyenne);
		
		return varAleatoire;		
	}
	

	

}
