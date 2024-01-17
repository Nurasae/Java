
import java.util.*;

public class UsaContrattoTelefonico {
	
	public static void main(String[] args) {

		Scanner input = new Scanner(System.in);
		String n1, n2, c1, c2, num1, num2, verify;
		double credit1, credit2;
		
		//Input valori delle variabili
		System.out.println("Inserisci il tuo nome: ");
		n1 = input.next();
		System.out.println("Inserisci il tuo cognome: ");
		c1 = input.next();
		System.out.println("Inserisci il tuo numero di telefono: ");
		num1 = input.next();
		
		//Creazione Istanza
		ContrattoTelefonico contratto_wind = new ContrattoTelefonico(n1, c1, num1);
		
		contratto_wind.apri_contratto();
		
		System.out.println("Inserisci il credito da versare: ");
		credit1 = input.nextDouble();
		contratto_wind.versa(credit1);
		
		System.out.println("Inserisci il credito da scalare: ");
		credit1 = input.nextDouble();
		if(contratto_wind.scala(credit1) <= 0) {
			credit1 = input.nextDouble();
		}
		
		
		System.out.println("Inserisci il tuo nome: ");
		n2 = input.next();
		System.out.println("Inserisci il tuo cognome: ");
		c2 = input.next();
		System.out.println("Inserisci il tuo numero di telefono: ");
		num2 = input.next();
		
		ContrattoTelefonico contratto_tim = new ContrattoTelefonico(n2, c2, num2);
		
		//Creazione della seconda Istanza
		contratto_tim.apri_contratto();	
		
		System.out.println("Inserisci il credito da versare: ");
		credit2 = input.nextDouble();
		contratto_tim.versa(credit2);
		contratto_tim.stampaCredito();
		
		System.out.println("Inserisci il credito da scalare: ");
		credit2 = input.nextDouble();
		if(contratto_tim.scala(credit2) <= 0) {
			credit2 = input.nextDouble();
		}
		
		if(contratto_wind.getCredito() > contratto_tim.getCredito()) {
			System.out.println("Il credito di Wind " + contratto_wind.getCredito() + " è maggiore del credito di Tim " + contratto_tim.getCredito() + "\n");
		} else {
			System.out.println("Il credito di Tim " + contratto_tim.getCredito() + " è maggiore del credito di Wind " + contratto_wind.getCredito() + "\n");
		}
		
		/*
		System.out.println("Vuoi cambiare contratto?");
		verify = input.next();
		
		if((contratto_wind.cambiaContratto(verify) == "SI") || (contratto_wind.cambiaContratto(verify) == "Si") || (contratto_wind.cambiaContratto(verify) == "si")) {
			
			System.out.println("Inserisci il tuo nome: ");
			n1 = input.next();
			System.out.println("Inserisci il tuo cognome: ");
			c1 = input.next();
			System.out.println("Inserisci il tuo numero di telefono: ");
			num1 = input.next();
			
			ContrattoTelefonico contratto_fastweb = new ContrattoTelefonico(n1, c1, num1);
			
			//Creazione della terza Istanza
			contratto_fastweb.apri_contratto();	
			
			System.out.println("Inserisci il credito da versare: ");
			credit1 = input.nextDouble();
			contratto_tim.versa(credit1);
			
			System.out.println("Inserisci il credito da scalare: ");
			credit1 = input.nextDouble();
			contratto_tim.scala(credit1);
			
			contratto_wind.chiudiContratto();
			
			contratto_fastweb.stampaDati();
			contratto_fastweb.getCredito();
			contratto_fastweb.stampaCredito();
			
			System.out.println("\n");
			
		}		
		*/
		
		contratto_wind.stampaDati();
		contratto_wind.getCredito();
		contratto_wind.stampaCredito();
		System.out.println("\n");
		contratto_tim.stampaDati();
		contratto_tim.getCredito();
		contratto_tim.stampaCredito();
		
		

		
		
	}

}
