package ese1_verifica;

import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author lambrugo_riccardo
 */


public class Ese1_Verifica {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        String start = "";
        java.io.BufferedReader console = new java.io.BufferedReader(new java.io.InputStreamReader(System.in));
        Shared dati = new Shared(false, false);
        Th1r razzo1 = new Th1r(dati);
        Th2r razzo2 = new Th2r(dati);
        Th3d roccia1 = new Th3d(dati);
        Th4d roccia2 = new Th4d(dati);
        while (!(start.equals("s"))) {
            System.out.println("Premi 's' per far partire i razzi.");
            start = console.readLine();
            if (!(start.equals("s"))) {
                System.out.println("Errore, inserisci la lettera s");
            }
        }
        razzo1.start();
        razzo2.start();
        roccia1.start();
        roccia2.start();
    }  
}
