import java.text.ParseException;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class ListePatients{
	
	HashMap<Integer,Patient>listePatientsUrgences;
	
	public ListePatients() {
		listePatientsUrgences = new HashMap<Integer,Patient>();
	}
	
	public void listerLesPatients() throws ParseException {
	    Scanner scan = new Scanner(System.in);  // Create a Scanner object
	    LinkedList<Patient> liste = new LinkedList<Patient>();
	    /*System.out.println("Entrer le nombre de patient : ");
	    int nbPatient=scan.nextInt();

	    for (int i=0;i<nbPatient;i++) {
			Scanner myScan = new Scanner(System.in);
			System.out.println("Patient " + (i+1));
			System.out.println("Entrez le nom puis le pr�nom");
	    	String nom = myScan.nextLine();
	    	String prenom = myScan.nextLine();
	    	System.out.println("Date d'arriv�e et heure d'arriv�e : dd/MM/yyyy HH:MM");
	    	String date = myScan.nextLine();	    		 
	    	Patient patient = new Patient(nom, prenom, date);
	    	liste.add(patient);
	    	System.out.println(liste.get(i).getListeSalle().get(i));
	    }*/
	   Patient p1 = new Patient("Souppaya","Alban","11/01/2004 11:45");
	   Patient p2 = new Patient("Bouzou","Eva","11/01/2004 11:25");
	   Patient p3 = new Patient("Souppaya","Audrey","11/01/2004 11:33");
	   Patient p4 = new Patient("Nguyen","Marine","11/01/2004 10:56");
	   Patient p5 = new Patient("Lam","Michel","11/01/2004 10:50");
	   Patient p6 = new Patient("Souppaya","Antony","11/01/2004 11:10");
	   
	   
	   liste.add(p1);liste.add(p2);liste.add(p3);liste.add(p4);liste.add(p5);liste.add(p6);
	    trierListePatients(liste);
	    
	    int i=0;
	    for (Patient c : liste) {
	    	listePatientsUrgences.put(i,c);
	    	i++;	    		    	
	    }
	    listePatientsUrgences.forEach((key, value) -> System.out.println(key + " " + value));
	    System.out.println(listePatientsUrgences.get(1).getListeSalle());
	    
	}
	
	public void trierListePatients(LinkedList<Patient> liste) {
		liste.sort(Comparator.comparing(Patient::getArriveeAuxUrgences));
	}
	
}
