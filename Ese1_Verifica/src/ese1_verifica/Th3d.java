package ese1_verifica;

import static java.lang.Thread.sleep;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author lambrugo_riccardo
 */


public class Th3d extends Thread {
    Shared shared;

    public Th3d(Shared shared) {
        this.shared = shared;
    }
    
    public void run() {
        boolean colpito = false;
        while(!colpito){
            shared.waitDestroy1();
            if(shared.isR1hit()==true){
                Random rn = new Random();
                shared.signalDestroy1();
                System.out.println("Inizio Disintegrazione roccia 1.");
                int rand = rn.nextInt(2)+1;
                try {
                   sleep(rand*1000);
                } catch (InterruptedException ex) {
                    Logger.getLogger(Th3d.class.getName()).log(Level.SEVERE, null, ex);
                }
                System.out.println("Fine Disintegrazione roccia 1!");
                colpito = true;
            } else {
                shared.signalDestroy1();
            }
        }
    }
}
