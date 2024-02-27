package Juegos;

import java.util.Scanner;
import Barajas.Carta;

public class SieteYMedioVSOrdenador extends Juego {
    private Scanner scanner = new Scanner(System.in);
    private final double UMBRAL_ORDENADOR = 6;

    public SieteYMedioVSOrdenador() {
        super();
    }

    @Override
    public void jugar() {
        double puntosJugador = 0;
        double puntosOrdenador = 0;
        boolean jugadorContinua = true;
        boolean ordenadorContinua = true;

        System.out.println("Bienvenido al juego del Siete y Medio contra el ordenador");

        while (jugadorContinua || ordenadorContinua) {
            if (jugadorContinua) {
                System.out.println("Turno del Jugador:");
                Carta cartaJugador = baraja.sacarCarta();
                System.out.println("Has sacado: " + cartaJugador);
                puntosJugador += cartaJugador.getValor7yMedio();
                System.out.println("Tus puntos actuales: " + puntosJugador);

                if (puntosJugador > 7.5) {
                    System.out.println("Te has pasado de 7.5. Has perdido.");
                    return;
                } else {
                    System.out.println("¿Quieres sacar otra carta? (s/n)");
                    jugadorContinua = "s".equalsIgnoreCase(scanner.nextLine());
                }
            }

            if (ordenadorContinua && puntosOrdenador < UMBRAL_ORDENADOR) {
                Carta cartaOrdenador = baraja.sacarCarta();
                System.out.println("El ordenador ha sacado: " + cartaOrdenador);
                puntosOrdenador += cartaOrdenador.getValor7yMedio();
                System.out.println("Puntos actuales del Ordenador: " + puntosOrdenador);

                if (puntosOrdenador > 7.5) {
                    System.out.println("El ordenador se ha pasado de 7.5. ¡Has ganado!");
                    return;
                }
                ordenadorContinua = puntosOrdenador < UMBRAL_ORDENADOR;
            }
        }

        System.out.println("Puntos finales del Jugador: " + puntosJugador);
        System.out.println("Puntos finales del Ordenador: " + puntosOrdenador);

        if (puntosJugador <= 7.5 && (puntosJugador > puntosOrdenador || puntosOrdenador > 7.5)) {
            System.out.println("¡Enhorabuena! Has ganado al ordenador.");
        } else {
            System.out.println("El ordenador gana.");
        }
    }
}
