//Autore: Nur Elshakhawy		Verifica Di Info		4L		14/11/23

public class ContrattoTelefonico {
	//Attributi
	String nome, cognome, num_telefono, very;
	double credito;
	
	//Costruttore
	public ContrattoTelefonico(String nome, String cognome, String num_telefono) {
		this.nome = nome;
		this.cognome = cognome;
		this.num_telefono = num_telefono;
		very = "";
		credito = 0;
	}
	
	//Metodi
	public void apri_contratto() {
		credito = 10;
	}
	
	public void versa(double cred) {
		credito = credito + cred;
	}
	
	public double scala(double cred) {
		if(credito-cred <= 0) {
			System.out.println("credito esaurito!");
			System.out.println("Reinserisci la somma da scalare! Il tuo credito è di: " + credito);
			credito = credito - cred;
		} else if(credito-cred >= 0) {
			credito = credito - cred;
		}
		
		return credito;
	}
	
	//Ritorna il credito
	public double getCredito() {
		return credito;
	}
	
	//Stampa i dati
	public void stampaDati() {
		System.out.println("Il tuo nome è: " + nome + "\n" + "Il tuo cognome è: " + cognome + "\n" + "Il tuo numero di telefono è: " + num_telefono);
	}
	
	//Stampa il credito
	public void stampaCredito() {
		System.out.println("Il tuo credito è di: " + credito);
	}
	
	/*
	public String cambiaContratto(String very) {
		System.out.println("Vuoi cambiare contratto? ");
		this.very = very;
		return very;
	}
	
	public void chiudiContratto() {
		credito = 0;
		System.out.println("Il tuo contratto è stato chiuso.");
	}
	*/
}
