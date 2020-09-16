/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tp3.Punto2Corregido;

import Tp3.Punto2.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Chino
 */
public class Main {

    public static void main(String[] args) {

        Jugador j1 = new Jugador();
        Thread hiloOrco = new Thread(new Orco(j1));    //para implements Runnable
        Curandero hiloCurandero = new Curandero(j1);  //para extends Thread

        hiloOrco.start();
        hiloCurandero.start();

        try {
            hiloOrco.join();
            hiloCurandero.join();
        } catch (InterruptedException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
