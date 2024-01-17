// Ahmed Noureldin, Salvatore Matteo, Grossi Edoardo, Polce Matteo

public class Impiccato {
    String parolaSegreta;
    String parolaUtente;
    String lettereUsate;
    int numErrori;

    public Impiccato() {
        parolaSegreta = "";
        parolaUtente = "";
        lettereUsate = "";
        numErrori = 0;
    }

    public void reset() {
        parolaSegreta = "";
        parolaUtente = "";
        lettereUsate = "";
        numErrori = 0;
    }

    public int getErrori() {
        return numErrori;
    }

    public void setParolaSegreta(String parola) {
        this.parolaSegreta = parola;
    }

    public void setParolaUtente() {
        char temp[] = new char[parolaSegreta.length()];
        for (int i = 0; i < parolaSegreta.length(); i++) {
            temp[i] = '-';
        }
        parolaUtente = new String(temp);
    }

    public String getParolaSegreta() {
        return parolaSegreta;
    }

    public String getParolaUtente() {
        return parolaUtente;
    }

    public boolean Indovina(char c) {
        boolean trovato = false;
        for (int i = 0; i < parolaSegreta.length(); i++) {
            if (c == parolaSegreta.charAt(i)) {
                trovato = true;
            }
        }
        return trovato;
    }

    public boolean updateParolaSegreta(char c) {
        boolean flag = false;
        for (int i = 0; i < parolaSegreta.length(); i++) {
            if (parolaSegreta.charAt(i) == c) {
                char temp[] = parolaUtente.toCharArray();
                temp[i] = c;
                parolaUtente = new String(temp);
                flag = true;
            }
        }
        return flag;
    }

    public void disegna() {
        switch (numErrori) {
            case 0:
                System.out.println("__________");
                System.out.println("|        |");
                System.out.println("|");
                System.out.println("|");
                System.out.println("|");
                System.out.println("|");
                System.out.println("|");
                System.out.println("----------");
                break;
            case 1:
                System.out.println("__________");
                System.out.println("|        |");
                System.out.println("|        O");
                System.out.println("|");
                System.out.println("|");
                System.out.println("|");
                System.out.println("|");
                System.out.println("----------");
                break;
            case 2:
                System.out.println("__________");
                System.out.println("|        |");
                System.out.println("|        O");
                System.out.println("|        |");
                System.out.println("|");
                System.out.println("|");
                System.out.println("|");
                System.out.println("----------");
                break;
            case 3:
                System.out.println("__________");
                System.out.println("|        |");
                System.out.println("|        O");
                System.out.println("|       /|");
                System.out.println("|");
                System.out.println("|");
                System.out.println("|");
                System.out.println("----------");
                break;
            case 4:
                System.out.println("__________");
                System.out.println("|        |");
                System.out.println("|        O");
                System.out.println("|       /|\\");
                System.out.println("|");
                System.out.println("|");
                System.out.println("|");
                System.out.println("----------");
                break;
            case 5:
                System.out.println("__________");
                System.out.println("|        |");
                System.out.println("|        O");
                System.out.println("|       /|\\");
                System.out.println("|       /");
                System.out.println("|");
                System.out.println("|");
                System.out.println("----------");
                break;
            case 6:
                System.out.println("__________");
                System.out.println("|        |");
                System.out.println("|        O");
                System.out.println("|       /|\\");
                System.out.println("|       / \\");
                System.out.println("|");
                System.out.println("|");
                System.out.println("----------");
                break;
            default:
                break;
        }
    }


    public boolean checkVittoria() {
        return parolaSegreta.equals(parolaUtente);
    }

    public boolean isLetteraUsata(char c) {
        for (int i = 0; i < lettereUsate.length(); i++) {
            if (c == lettereUsate.charAt(i)) {
                System.out.println("La lettera inserita è già stata usata!");
                return true;
            }
        }
        return false;
    }

    public String getLettereUsate() {
        return lettereUsate;
    }
}