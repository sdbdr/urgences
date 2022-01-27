import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date; 



public class Application {
	
	

	public static void main (String[] args) throws ParseException {
		
		ListePatients listePatients = new ListePatients();
		listePatients.listerLesPatients();
		/*for (int i=0;i<20;i++) {
			Random var = new Random();
			//1 hour and std-deviation 15 minutes you'll need to call it as
			System.out.println(var.nextGaussian()*2+12); 			
		}*/
		
		


	}

}
