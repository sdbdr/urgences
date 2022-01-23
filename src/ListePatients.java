import java.text.ParseException;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class ListePatients{
	
	LinkedList<Patient> listePatientsUrgences; 
	
	public ListePatients() {
		listePatientsUrgences = new LinkedList<Patient>();
	}
	
	public void listerLesPatients() throws ParseException {
	    Scanner scan = new Scanner(System.in);  // Create a Scanner object
	    System.out.println("Entrer le nombre de patient : ");
	    int nbPatient=scan.nextInt();

	    for (int i=0;i<nbPatient;i++) {
			Scanner myScan = new Scanner(System.in);
			System.out.println("Patient " + (i+1));
			System.out.println("Entrez le nom puis le prénom");
	    	String nom = myScan.nextLine();
	    	String prenom = myScan.nextLine();
	    	System.out.println("Date d'arrivée et heure d'arrivée : dd/MM/yyyy HH:MM");
	    	String date = myScan.nextLine();
	    		 
	    	Patient patient = new Patient(nom, prenom, date);
	    	listePatientsUrgences.add(patient);
	    	System.out.println(patient);	    	
	    }
	    for (Patient c : listePatientsUrgences)
            System.out.println(c);
	    this.trierListePatients();
	    for (Patient c : listePatientsUrgences)
            System.out.println(c);
	}
	
	public void trierListePatients() {
		listePatientsUrgences.sort(Comparator.comparing(Patient::getArriveeAuxUrgences));
	}
	
}
