import java.util.concurrent.Semaphore;

public class Cars {
    private int k;
    private Semaphore sem;

    public Cars(int k) {
        this.k = k;
        sem = new Semaphore(k, true); // inicializar semáforo con k permisos
    }

    public void reserva(int r) throws InterruptedException {
        sem.acquire(r); // adquirir r permisos del semáforo
    }

    public void libera(int l) {
        sem.release(l); // liberar l permisos del semáforo
    }
}
	