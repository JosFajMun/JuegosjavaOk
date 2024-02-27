package Juegos;

import java.util.Scanner;
import Barajas.Carta;

public class SieteYMedio extends Juego {
    private Scanner scanner = new Scanner(System.in);

    public SieteYMedio() {
    	
    	//super llama al constructor de la clase base, en este caso Juego, para que cree la baraja y llame a barajar
        super();
    }

    //override sobreescribe jugar de la clase base. Recordemos que jugar no tiene implementación en la clase base Juego
    @Override
    public void jugar() {
        double puntosJugador = 0;
        System.out.println("Bienvenido al juego del Siete y Medio");

        do {
            Carta carta = baraja.sacarCarta();
            System.out.println("Has sacado una carta: " + carta);
            puntosJugador += carta.getValor7yMedio();
            System.out.println("Tus puntos actuales son: " + puntosJugador);

            if (puntosJugador > 7.5) {
                System.out.println("Te has pasado de 7.5. Has perdido.");
                return;
            }

            System.out.println("¿Quieres sacar otra carta? (s/n)");
        } while ("s".equalsIgnoreCase(scanner.nextLine()));
        //equalsIgnoreCase compara la s con lo introducido por el usuario ignorando las mayúsculas y minúsculas (case)

        if (puntosJugador >= 6 && puntosJugador <= 7.5) {
            System.out.println("¡Enhorabuena! Has conseguido " + puntosJugador + ". Has ganado.");
        } else {
            System.out.println("Tus puntos finales son: " + puntosJugador + ". No te has pasado, pero tampoco no has llegado al 6.");
        }
    }
}


