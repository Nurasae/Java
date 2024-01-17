
import java.util.*;

public class UsaLibro {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		String t1, t2;
		String a1, a2;
		double p1, p2;
		
		System.out.println("Scrivi il titolo del primo libro: ");
		t1 = input.nextLine();
		System.out.println("Scrivi il nome dell'autore del primo libro: ");
		a1 = input.nextLine();
		System.out.println("Scrivi il prezzo del primo libro: ");
		p1 = input.nextDouble();
		
		Libro lib1 = new Libro(t1, a1, p1);
		
		System.out.println("Scrivi il titolo del secondo libro: ");
		t2 = input.nextLine();
		System.out.println("Scrivi il nome dell'autore del secondo libro: ");
		a2 = input.nextLine();
		System.out.println("Scrivi il prezzo del secondo libro: ");
		p2 = input.nextDouble();
		
		Libro lib2 = new Libro(t2, a2, p2);
		
		lib1.inizializzaPrezzo(p1);
		lib2.inizializzaPrezzo(p2);
		
		System.out.println("Vuoi applicare lo sconto al primo libro?: ");
		String verify = input.next();
		
		if((verify == "Si") || (verify == "si") || (verify == "SI")) {
			double sconto;
			System.out.println("Inserisci il valore dello sconto: ");
			sconto = input.nextDouble();
			double p_scontato1 = lib1.applicaSconto(sconto);
		}
		
		System.out.println("Vuoi applicare lo sconto al secondo libro?: ");
		verify = input.next();
		
		if((verify == "Si") || (verify == "si") || (verify == "SI")) {
			double sconto;
			System.out.println("Inserisci il valore dello sconto: ");
			sconto = input.nextDouble();
			double p_scontato2 = lib2.applicaSconto(sconto);
			
		}
		
		if (p_scontato1 < p_scontato2)
	}

}
