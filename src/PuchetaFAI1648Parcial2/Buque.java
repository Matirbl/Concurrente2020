/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PuchetaFAI1648Parcial2;

import java.util.concurrent.Semaphore;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Chino
 */
public class Buque implements Runnable {

    Estacionamiento miEstacionamiento;

    public Buque(Estacionamiento unEstacionamiento) {
        miEstacionamiento = unEstacionamiento;
    }

    public void run() {

        while (true) {
            try {
                miEstacionamiento.arrancaBuque();
                miEstacionamiento.viajando();
                miEstacionamiento.llegaBuque();
                miEstacionamiento.viajando();
                miEstacionamiento.resetearViaje();
            } catch (InterruptedException ex) {
                Logger.getLogger(Buque.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

}
