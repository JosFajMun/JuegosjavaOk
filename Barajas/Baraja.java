package Barajas;

import java.util.ArrayList;
import java.util.Collections;

public class Baraja {
 private ArrayList<Carta> cartas = new ArrayList<>();

 public Baraja() {
     String[] palos = {"Oros", "Copas", "Espadas", "Bastos"};
     for (String palo : palos) {
         for (int i = 1; i <= 12; i++) {
             cartas.add(new Carta(i, palo));
         }
     }
 }

 public void barajar() {
     Collections.shuffle(this.cartas);
 }

 public Carta sacarCarta() {
     if (!this.cartas.isEmpty()) {
         return this.cartas.remove(0);
     }
     return null;
 }
}
