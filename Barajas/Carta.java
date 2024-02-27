package Barajas;

public class Carta {
 private int numero;
 private String palo;

 public Carta(int numero, String palo) {
     this.numero = numero;
     this.palo = palo;
 }

 public int getNumero() {
     return this.numero;
 }

 public String getPalo() {
     return this.palo;
 }

 public double getValor7yMedio() {
     if (this.numero >= 10) {
         return 0.5;
     } else {
         return this.numero;
     }
 }

 @Override
 public String toString() {
     return String.format("%d de %s", this.numero, this.palo);
 }
}
