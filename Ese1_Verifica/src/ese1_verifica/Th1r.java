package ese1_verifica;

import static java.lang.Thread.sleep;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author lambrugo_riccardo
 */


public class Th1r extends Thread {
    Shared shared;

    public Th1r(Shared shared) {
        this.shared = shared;
    }
    
    public void run() {
        Random rn = new Random();
        System.out.println("Partenza razzo 1");
        int rand = rn.nextInt(2)+1;
        try {
            sleep(rand*1000);
        } catch (InterruptedException ex) {
            Logger.getLogger(Th1r.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("Roccia 1 Colpita!");
        shared.waitDestroy1();
        shared.setR1hit(true);
        shared.signalDestroy1();
    }
}
