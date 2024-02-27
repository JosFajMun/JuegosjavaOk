package Principal;

import Juegos.*;
import java.util.Scanner;

public class Principal {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
        
		while (true) {
            System.out.println("Seleccione el juego:");
            System.out.println("1. Siete y Medio");
            System.out.println("5. Siete y Medio (2 jugadores)");
            System.out.println("6. Siete y Medio (contra el ordenador)");
            System.out.println("2. Tute (No implementado)");
            System.out.println("3. Brisca (No implementado)");
            System.out.println("4. Salir");
            System.out.print("Opción: ");
            
            int opcion = scanner.nextInt();
            
            switch (opcion) {
                case 1:
                    SieteYMedio juego = new SieteYMedio();
                    juego.jugar();
                    break;
                    
                case 2:
                    // Tute tute = new Tute();
                    // tute.jugar();
                    System.out.println("Tute no está implementado aún.");
                    break;
                    
                case 3:
                    // Brisca brisca = new Brisca();
                    // brisca.jugar();
                    System.out.println("Brisca no está implementado aún.");
                    break;
                    
                case 4:
                    System.out.println("Gracias por jugar. Hasta luego.");
                    System.exit(0);
                    break;
                    
                case 5:
                    SieteYMedio2Players juego2 = new SieteYMedio2Players();
                    juego2.jugar();
                    break;
                    
                case 6:
                    SieteYMedioVSOrdenador juego3 = new SieteYMedioVSOrdenador();
                    juego3.jugar();
                    break;
                    
                default:
                    System.out.println("Opción no válida. Intente de nuevo.");
            }
        }

	}

}
