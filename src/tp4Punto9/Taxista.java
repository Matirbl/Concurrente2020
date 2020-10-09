/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp4Punto9;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Chino
 */
public class Taxista implements Runnable {

    private String patente;
    Taxi elTaxi;


    public Taxista(String pat,Taxi desti) {
        patente = pat;
       elTaxi=desti;
    }

    public void run() {
        while (true) {
            try {
                elTaxi.irDestino(patente);
            } catch (InterruptedException ex) {
                Logger.getLogger(Taxista.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
    }
}
