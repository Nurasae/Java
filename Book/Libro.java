
public class Libro {
	private String titolo, autore;
	private double prezzo;
	
	public Libro() {
		titolo = "";
		autore = "";
		prezzo = 0;
	}
	
	public Libro(String titolo, String autore, double prezzo) {
		this.titolo = titolo;
		this.autore = autore;
		this.prezzo = prezzo;
	}
	
	public void inizializzaPrezzo(double prezzo) {
		this.prezzo = prezzo;
	}
	
	public double getPrezzo() {
		return prezzo;
	}
	
	public double applicaSconto(double sconto) {
		double saldo = prezzo * (sconto/100);
		return saldo;
	}
	
	public double getSconto(double sconto) {
		return sconto;
	}
	
	
	public void stampaPrezzo(double saldo) {
		System.out.println("Il prezzo del libro è di: " + saldo);
	}
}
