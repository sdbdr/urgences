import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class ListePatients{
	
	private HashMap<Integer,Patient>listePatientsUrgences;
	private int nbPatients;
	static final long ONE_MINUTE_IN_MILLIS = 6000;
	private int nbSalle = 2;
	
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
	    
	    Patient p1 = new Patient("Souppaya","Alban","11/01/2004 10:54");
	    Patient p2 = new Patient("Bouzou","Eva","11/01/2004 11:25");
	    Patient p3 = new Patient("Souppaya","Audrey","11/01/2004 10:57");
	    Patient p4 = new Patient("Nguyen","Marine","11/01/2004 10:52");
	    Patient p5 = new Patient("Lam","Michel","11/01/2004 10:50");
	    Patient p6 = new Patient("Souppaya","Antony","11/01/2004 11:00");
	    Patient p7 = new Patient("Marius","Melissa","11/01/2004 11:03"); 
	    
	    nbPatients=7;
	   
	   liste.add(p1);liste.add(p2);liste.add(p3);liste.add(p4);liste.add(p5);liste.add(p6);liste.add(p7);
	    trierListePatients(liste);	    
	    int i=0;
	    for (Patient c : liste) {
	    	listePatientsUrgences.put(i,c);
	    	i++;	    		    	
	    }
	    //listePatientsUrgences.forEach((key, value) -> System.out.println(key + " " + value));
	    calculerTempsAttentes();   
	   afficherPatientsDansSalle();	   
	   	}
		
	public void trierListePatients(LinkedList<Patient> liste) {
		liste.sort(Comparator.comparing(Patient::getArriveeAuxUrgences));
	}
	
	
	public void calculerArriveeDansSalle() {
		for (int i=0;i<listePatientsUrgences.size();i++) {
			for (int j=0; j<nbSalle;j++) {
				Salle salle = new Salle();
				if (j==0) {				//salle0
					salle.setTempsConsulation(salle.genererTempsConsultation(3,1));
					salle.setArriveeDansLaSalle(listePatientsUrgences.get(i).getArriveeAuxUrgences());
				}
				else if (i>1) {
					int tPassage = listePatientsUrgences.get(i-1).getListeSalle().get(0).getTempsAttente()+listePatientsUrgences.get(i-1).getListeSalle().get(0).getTempsConsulation();
					Date date = (Date) listePatientsUrgences.get(i-1).getListeSalle().get(0).getArriveeDansLaSalle();
					Date dateApres=addMinutesToDate(tPassage,date);
					int diff = (int) (dateApres.getTime() - listePatientsUrgences.get(i).getListeSalle().get(0).getArriveeDansLaSalle().getTime());//as given
					int tAttente = (int) TimeUnit.MILLISECONDS.toMinutes(diff); 
					if (tAttente<0) {
						tAttente=0;
					}

					listePatientsUrgences.get(i).getListeSalle().get(0).setTempsAttente(tAttente);	
				}
				else {				//salle1							
					salle.setTempsConsulation(salle.genererTempsConsultation(10, 3));		
					Date arrivee = listePatientsUrgences.get(i).getListeSalle().get(j-1).getArriveeDansLaSalle();
					int attenteEtConsultation = listePatientsUrgences.get(i).getListeSalle().get(j-1).getTempsAttente()+listePatientsUrgences.get(i).getListeSalle().get(j-1).getTempsConsulation();
					//System.out.println(attenteEtConsultation);
					//System.out.println(arrivee);
					salle.arriveeDansLaSalle=addMinutesToDate(attenteEtConsultation,arrivee);
					
				}
				listePatientsUrgences.get(i).getListeSalle().add(salle);

				
			}
		}
	}
	
	
	public void calculerTempsAttentes() {
	    calculerArriveeDansSalle();	   
		for (int i=1;i<nbPatients;i++) {

			int tPassage = listePatientsUrgences.get(i-1).getListeSalle().get(0).getTempsAttente()+listePatientsUrgences.get(i-1).getListeSalle().get(0).getTempsConsulation();
			Date date = (Date) listePatientsUrgences.get(i-1).getListeSalle().get(0).getArriveeDansLaSalle();
			Date dateApres=addMinutesToDate(tPassage,date);
			int diff = (int) (dateApres.getTime() - listePatientsUrgences.get(i).getListeSalle().get(0).getArriveeDansLaSalle().getTime());//as given
			int tAttente = (int) TimeUnit.MILLISECONDS.toMinutes(diff); 
			if (tAttente<0) {
				tAttente=0;
			}

			listePatientsUrgences.get(i).getListeSalle().get(0).setTempsAttente(tAttente);		
		}

	}
	
	public void afficherPatientsDansSalle() throws ParseException {
		

		System.out.println("+----------------------------------------------------------------------------------+");
		
		System.out.printf( "|%-15s| %-15s| %-15s| %-15s| %-15s| %n", "Nom","Prenom", "Arrivee","Attente","Consultation" );	
		System.out.println("+----------------------------------------------------------------------------------+");
		
		for (int j=0;j<nbSalle;j++) {
			System.out.println("Salle "+j);
			for (int i=0;i<nbPatients;i++) {
				String nom=listePatientsUrgences.get(i).getNom();			
				String prenom=listePatientsUrgences.get(i).getPrenom();			
				Date arrivee=listePatientsUrgences.get(i).getArriveeAuxUrgences();			
				int attente=listePatientsUrgences.get(i).getListeSalle().get(j).getTempsAttente();			
				int consultation=listePatientsUrgences.get(i).getListeSalle().get(j).getTempsConsulation();		
				System.out.printf( " %-15s  %-15s  %-15s  %-15s  %-15s  %n", nom, prenom, arrivee.getHours()+":"+arrivee.getMinutes(), attente, consultation);					
			}	
		}
		
	}
	
	private static Date addMinutesToDate(int minutes, Date beforeTime){
	    final long ONE_MINUTE_IN_MILLIS = 60000;//millisecs

	    long curTimeInMs = beforeTime.getTime();
	    Date afterAddingMins = new Date(curTimeInMs + (minutes * ONE_MINUTE_IN_MILLIS));
	    return afterAddingMins;
	}	

	public String  toString() {
		
		return null;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
