package ese1_verifica;

import java.util.concurrent.Semaphore;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author lambrugo_riccardo
 */


public class Shared {
    boolean r1hit,r2hit;
    Semaphore destroy1,destroy2;

    public Shared(boolean r1hit, boolean r2hit) {
        this.r1hit = r1hit;
        this.r2hit = r2hit;
        this.destroy1 = new Semaphore(1);
        this.destroy2 = new Semaphore(1);
    }

    public Shared() {
    }

    public boolean isR1hit() {
        return r1hit;
    }

    public boolean isR2hit() {
        return r2hit;
    }

    public Semaphore getDestroy1() {
        return destroy1;
    }

    public Semaphore getDestroy2() {
        return destroy2;
    }

    public void setR1hit(boolean r1hit) {
        this.r1hit = r1hit;
    }

    public void setR2hit(boolean r2hit) {
        this.r2hit = r2hit;
    }

    public void setDestroy1(Semaphore destroy1) {
        this.destroy1 = destroy1;
    }

    public void setDestroy2(Semaphore destroy2) {
        this.destroy2 = destroy2;
    }
    
    public void waitDestroy1() {
        try {
            destroy1.acquire();
        } catch (InterruptedException ex) {
            Logger.getLogger(Shared.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void waitDestroy2() {
        try {
            destroy2.acquire();
        } catch (InterruptedException ex) {
            Logger.getLogger(Shared.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void signalDestroy1(){
        destroy1.release();
    }
    
    public void signalDestroy2(){
        destroy2.release();
    }
    
}
