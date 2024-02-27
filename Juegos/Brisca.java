package Juegos;

import Barajas.Baraja;
import Barajas.Carta;

public class Brisca extends Juego {

    private final int PUNTOS_POR_CARTA = 10;
    private final int PUNTOS_POR_RONDA = 100;
    private final int NUMERO_CARTAS_MANO = 3;

    private int puntosEquipo1;
    private int puntosEquipo2;
    private int rondaActual;
    private Carta brisca;

    public Brisca() {
        super();
        this.puntosEquipo1 = 0;
        this.puntosEquipo2 = 0;
        this.rondaActual = 1;
        this.brisca = baraja.sacarCarta();
    }

    @Override
    public void jugar() {
        while (!finJuego()) {
            jugarRonda();
            mostrarPuntuacion();
            rondaActual++;
        }
        mostrarGanador();
    }

    private void jugarRonda() {
        int puntosEquipo1Ronda = 0;
        int puntosEquipo2Ronda = 0;

        for (int i = 0; i < NUMERO_CARTAS_MANO; i++) {
            Carta cartaEquipo1 = baraja.sacarCarta();
            Carta cartaEquipo2 = baraja.sacarCarta();

            int ganadorMano = compararCartas(cartaEquipo1, cartaEquipo2, brisca);

            if (ganadorMano == 1) {
                puntosEquipo1Ronda += PUNTOS_POR_CARTA;
            } else if (ganadorMano == 2) {
                puntosEquipo2Ronda += PUNTOS_POR_CARTA;
            }
        }

        if (puntosEquipo1Ronda > puntosEquipo2Ronda) {
            puntosEquipo1 += PUNTOS_POR_RONDA;
        } else if (puntosEquipo1Ronda < puntosEquipo2Ronda) {
            puntosEquipo2 += PUNTOS_POR_RONDA;
        }
    }

    private int compararCartas(Carta carta1, Carta carta2, Carta brisca) {
        int valorCarta1 = carta1.getValor7yMedio();
        int valorCarta2 = carta2.getValor7yMedio();

        if (carta1.getPalo().equals(brisca.getPalo())) {
            valorCarta1 *= 2;
        }

        if (carta2.getPalo().equals(brisca.getPalo())) {
            valorCarta2 *= 2;
        }

        if (valorCarta1 > valorCarta2) {
            return 1;
        } else if (valorCarta1 < valorCarta2) {
            return 2;
        } else {
            return 0;
        }
    }

    private void mostrarPuntuacion() {
        System.out.println("Ronda: " + rondaActual);
        System.out.println("Equipo 1: " + puntosEquipo1);
        System.out.println("Equipo 2: " + puntosEquipo2);
    }

    private boolean finJuego() {
        return puntosEquipo1 >= 600 || puntosEquipo2 >= 600;
    }

    private void mostrarGanador() {
        if (puntosEquipo1 > puntosEquipo2) {
            System.out.println("¡El equipo 1 ha ganado!");
        } else {
            System.out.println("¡El equipo 2 ha ganado!");
        }
    }
}
