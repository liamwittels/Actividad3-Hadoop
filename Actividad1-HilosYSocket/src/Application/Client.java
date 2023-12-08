package Application;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;


public class Client {

	public static void main(String[] args){
		
		try {
			
			//Pedir direccion IP
			String serverAddress = System.console().readLine("Direccion IP (Servidor): ");
			
			//Creamos el socket
			Socket socket = new Socket(serverAddress, 9999);
			
			//Enviamos la opcion al servidor
			PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
			//Recibimos la respuesta del servidor
			BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			
			
			while(true){
				//Solicitamos un numero que seria la opcion de que loteria quiere jugar
				String option = System.console().readLine("\n-----LOTERIA-----\n"
														+ "1. 1-10      (10$)\n"
														+ "2. 1-100     (100$)\n"
														+ "3. 1-1000    (1000$)\n"
														+ "4. 1-10.000  (10.000$)\n"
														+ "5. 1-100.000 (100.000$)\n"
														+ "\n"
														+ "Opcion: ");
				out.println(option);
				
				String answer = input.readLine();
				//Imprimir respuesta
				System.out.print(answer);
			}


		

		}catch (IOException e){
    		e.printStackTrace();
		}
	}
}