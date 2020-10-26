/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ProductorConsumidor;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Chino
 */
public class Productor implements Runnable {

    private String nombre;
    private Buffer recurso;

    public Productor(String n, Buffer b) {
        nombre = n;
        recurso = b;
    }

    public void run() {

        while (true) {

            try {
                recurso.producir();
                System.out.println("\u001B[31m " + nombre + " está produciendo un producto");
                Thread.sleep(2000);

            } catch (InterruptedException ex) {
                Logger.getLogger(Consumidor.class.getName()).log(Level.SEVERE, null, ex);
            }

        }

    }
}
