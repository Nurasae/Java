// Ahmed Noureldin, Salvatore Matteo, Grossi Edoardo, Polce Matteo

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        playGame();
    }

    private static void playGame() {
        Impiccato gioco = new Impiccato();
        Scanner scanner = new Scanner(System.in);

        // Imposta la parola segreta
        System.out.print("Inserisci la parola segreta: ");
        String parolaSegreta = scanner.nextLine();
        gioco.setParolaSegreta(parolaSegreta);
        gioco.setParolaUtente();
        
        boolean very = true;
        // Loop del gioco
        while (!gioco.checkVittoria() && gioco.getErrori() < 6) {
            gioco.disegna();
            System.out.println("Parola: " + gioco.getParolaUtente());
            System.out.println("Lettere già usate: " + gioco.getLettereUsate());

            // Input della lettera
            System.out.print("Inserisci una lettera: ");
            String input = scanner.nextLine().toLowerCase();
            if (input.length() == 1 && Character.isLetter(input.charAt(0))) {
                char lettera = input.charAt(0);

                // Controlla se la lettera è stata usata
                if (gioco.isLetteraUsata(lettera)) {
                    System.out.println("Hai già inserito questa lettera. Riprova con un'altra.");
                    continue; // Se è già stata usata, continua con il prossimo turno
                }

                // Esegue l'indovinamento e aggiorna lo stato del gioco
                boolean trovato = gioco.updateParolaSegreta(lettera);
                if (!trovato) {
                    gioco.numErrori++;
                }
                gioco.lettereUsate += lettera;

            } else {
                System.out.println("Inserisci una singola lettera valida!");
            }
        }

        // Verifica il risultato del gioco
        gioco.disegna();
        if (gioco.checkVittoria()) {
            System.out.println("Hai indovinato la parola! La parola segreta era: " + gioco.getParolaSegreta());
        } else {
            System.out.println("Hai perso! La parola segreta era: " + gioco.getParolaSegreta());
        }
        
        System.out.print("Vuoi rigiocare? (s/n): ");
        String risposta = scanner.next().toLowerCase();
        if(risposta.equals("s")) {
        	playGame();
        }
        else {
        	System.out.println("Grazie per aver giocato. Arrivederci!");
        	very = false; // Termina il loop se la risposta non è 's'
        }
        
        
        scanner.close();
    }
}