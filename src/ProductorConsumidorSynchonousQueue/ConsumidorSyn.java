/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ProductorConsumidorSynchonousQueue;

import ProductorConsumidor.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Chino
 */
public class ConsumidorSyn implements Runnable {

    private String nombre;
    private BufferSynchro recurso;

    public ConsumidorSyn(String n, BufferSynchro b) {
        nombre = n;
        recurso = b;
    }

    public void run() {

        while (true) {

            try {
                Object elemento = recurso.consumir();
                System.out.println("\u001B[32m " + nombre + " está consumiendo el producto " + elemento);
                Thread.sleep(2000);

            } catch (InterruptedException ex) {
                Logger.getLogger(ConsumidorSyn.class.getName()).log(Level.SEVERE, null, ex);
            }

        }

    }
}
