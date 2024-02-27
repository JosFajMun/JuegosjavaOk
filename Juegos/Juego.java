package Juegos;

import Barajas.Baraja;

public abstract class Juego {
	
	//protected para que las clases extendidas de Juego (los juegos en sí), puedan acceder a Baraja.
 protected Baraja baraja;

 public Juego() {
     this.baraja = new Baraja();
     this.baraja.barajar();
 }

 // Al ser abstract, no tiene implementación como tal, lo que obliga a las clases extendidas de juego a implementarlo.
 public abstract void jugar();
}
