public class Main {
	
    public static void main(String[] args) throws InterruptedException {
    	
        // Se crea el objeto UsoDeRecursos con 1 unidad disponible
        Cars cars = new Cars(1);
        // Se crea el objeto Puente con capacidad de 1 coche en cada dirección
        Bridge bridge = new Bridge();

        // Se crean varios procesos que usan el recurso y cruzan el puente
        Thread proceso1 = new Thread(() -> {
            try {
                cars.reserva(1); // Se reserva el recurso (1 unidad)
                System.out.println("Coche 1 llega al puente desde el norte");
                bridge.cruzarNorte(); // Se intenta entrar al puente desde el norte
                System.out.println("Coche 1 cruza el puente hacia el sur");
                Thread.sleep(1000); // Se simula el tiempo que tarda en cruzar
                bridge.cruzarNorte(); // Se sale del puente por el sur
                cars.libera(1); // Se libera el recurso (1 unidad)
                System.out.println("Coche 1 sale del puente hacia el sur");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        Thread proceso2 = new Thread(() -> {
            try {
                cars.reserva(1); // Se reserva el recurso (1 unidad)
                System.out.println("Coche 2 llega al puente desde el sur");
                bridge.cruzarSur(); // Se intenta entrar al puente desde el sur
                System.out.println("Coche 2 cruza el puente hacia el norte");
                Thread.sleep(500); // Se simula el tiempo que tarda en cruzar
                bridge.cruzarSur(); // Se sale del puente por el norte
                cars.libera(1); // Se libera el recurso (1 unidad)
                System.out.println("Coche 2 sale del puente hacia el norte");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        Thread proceso3 = new Thread(() -> {
            try {
                cars.reserva(1); // Se reserva el recurso (1 unidad)
                System.out.println("Coche 3 llega al puente desde el norte");
                bridge.cruzarNorte(); // Se intenta entrar al puente desde el norte
                System.out.println("Coche 3 cruza el puente hacia el sur");
                Thread.sleep(2000); // Se simula el tiempo que tarda en cruzar
                bridge.cruzarNorte(); // Se sale del puente por el sur
                cars.libera(1); // Se libera el recurso (1 unidad)
                System.out.println("Coche 3 sale del puente hacia el sur");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        Thread proceso4 = new Thread(() -> {
            try {
                cars.reserva(1); // Se reserva el recurso (1 unidad)
                System.out.println("Coche 4 llega al puente desde el sur");
                bridge.cruzarSur(); // Se intenta entrar al puente desde el sur
                System.out.println("Coche 4 cruza el puente hacia el norte");
                Thread.sleep(1000); // Se simula el tiempo que tarda en cruzar
                bridge.cruzarSur(); // Se sale del puente por el norte
                cars.libera(1); // Se libera el recurso (1 unidad)
                System.out.println("Coche 4 sale del puente hacia el norte");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        // Se inician los procesos
        proceso1.start();
        Thread.sleep(100); // Se espera un poco para dar tiempo a que llegue el segundo coche
        proceso2.start();
        Thread.sleep(100); // Se espera un poco para dar tiempo a que llegue el tercer coche
        proceso3.start();
        Thread.sleep(100); // Se espera un poco para dar tiempo a que llegue el cuarto coche
        proceso4.start();
    }
}
        
