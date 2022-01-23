import java.util.Date;
import java.util.LinkedList;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;


public class Patient {
	
	String nom;
	String prenom; 
	Date arriveeAuxUrgences;
	SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");
	LinkedList<Salle> listeSalle = new LinkedList<Salle>();
	
	public Patient(String n, String p, String date) throws ParseException {
		this.nom=n;
		this.prenom=p;
		this.arriveeAuxUrgences = sdf.parse(date);
		Salle salle0 = new Salle();
		salle0.setArriveeDansLaSalle(this.arriveeAuxUrgences);
		salle0.setTempsAttente(0);
		this.listeSalle.add(salle0);
	}
	
	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public Date getArriveeAuxUrgences() {
		return arriveeAuxUrgences;
	}

	public void setArriveeAuxUrgences(Date dateArrivee) {
		this.arriveeAuxUrgences = dateArrivee;
	}

	public String toString() {
		return this.nom+" "+this.prenom+" arrive le "+sdf.format(this.arriveeAuxUrgences)+" aux urgences";
	}
	
	public void enregistrerSonArrivee() {
		
	}
	
	

}
