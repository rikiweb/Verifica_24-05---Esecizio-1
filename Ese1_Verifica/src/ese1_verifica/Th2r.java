package ese1_verifica;

import static java.lang.Thread.sleep;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author lambrugo_riccardo
 */


public class Th2r extends Thread {
    Shared shared;

    public Th2r(Shared shared) {
        this.shared = shared;
    }
    
    public void run() {
        Random rn = new Random();
        System.out.println("Partenza razzo 2");
        int rand = rn.nextInt(2)+1;
        try {
            sleep(rand*1000);
        } catch (InterruptedException ex) {
            Logger.getLogger(Th2r.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("Roccia 2 Colpita!");
        shared.waitDestroy2();
        shared.setR2hit(true);
        shared.signalDestroy2();
    }
}
