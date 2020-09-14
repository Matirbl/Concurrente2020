/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tp3.Punto2;

/**
 *
 * @author Chino
 */
public class Orco implements Runnable {

    Jugador j1;

    public Orco(Jugador jugador1) {
        j1 = jugador1;
    }

    public void quitarVida() {

        j1.setVida((j1.obtenerVida()) - 3);
        System.out.println("vida restada, VIDA: " + j1.obtenerVida());

    }

    public void run() {

        this.quitarVida();

    }

}
