public class Bridge {
    private int norte;
    private int sur;

    public Bridge() {
        norte = 0;
        sur = 0;
    }

    public synchronized void cruzarNorte() throws InterruptedException {
        while (sur > 0 || norte > 0) {
            wait();
        }
        norte++;
        System.out.println("Coche del norte cruzando el puente");
        Thread.sleep(1000);
        norte--;
        notifyAll();
    }

    public synchronized void cruzarSur() throws InterruptedException {
        while (norte > 0 || sur > 0) {
            wait();
        }
        sur++;
        System.out.println("Coche del sur cruzando el puente");
        Thread.sleep(1000);
        sur--;
        notifyAll();
    }
}