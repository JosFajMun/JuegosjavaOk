package Juegos;

import java.util.Scanner;
import Barajas.Carta;

public class SieteYMedio2Players extends Juego {
    private Scanner scanner = new Scanner(System.in);

    public SieteYMedio2Players() {
        super();
    }

    @Override
    public void jugar() {
        System.out.println("Bienvenido al juego del Siete y Medio para dos jugadores.");
        double puntosJugador1 = 0, puntosJugador2 = 0;
        boolean jugador1Continua = true, jugador2Continua = true;

        while (jugador1Continua || jugador2Continua) {
            if (jugador1Continua) {
                System.out.println("Turno del Jugador 1");
                puntosJugador1 = turnoJugador(puntosJugador1, 1);
                if (puntosJugador1 > 7.5) {
                    System.out.println("Jugador 1 se ha pasado. Jugador 2 gana.");
                    return;
                }
                jugador1Continua = deseaContinuar(1);
            }

            if (jugador2Continua) {
                System.out.println("Turno del Jugador 2");
                puntosJugador2 = turnoJugador(puntosJugador2, 2);
                if (puntosJugador2 > 7.5) {
                    System.out.println("Jugador 2 se ha pasado. Jugador 1 gana.");
                    return;
                }
                jugador2Continua = deseaContinuar(2);
            }
        }

        // Determinar el ganador
        if (puntosJugador1 <= 7.5 && puntosJugador2 <= 7.5) {
            if (puntosJugador1 == puntosJugador2) {
                System.out.println("Empate.");
            } else if (puntosJugador1 > puntosJugador2) {
                System.out.println("Jugador 1 gana con " + puntosJugador1 + " puntos.");
            } else {
                System.out.println("Jugador 2 gana con " + puntosJugador2 + " puntos.");
            }
        }
    }

    private double turnoJugador(double puntos, int jugador) {
    	Carta carta = baraja.sacarCarta();
        System.out.println("Jugador " + jugador + " saca: " + carta);
        puntos += carta.getValor7yMedio();
        System.out.println("Puntos de Jugador " + jugador + ": " + puntos);
        return puntos;
    }

    private boolean deseaContinuar(int jugador) {
        System.out.println("Jugador " + jugador + ", ¿quieres sacar otra carta? (s/n)");
        String respuesta = scanner.nextLine();
        return "s".equalsIgnoreCase(respuesta);
    }
}
