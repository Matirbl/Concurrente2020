/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp4Punto13;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Chino
 */
public class Mozo implements Runnable {

    private String nombre;
    private Confiteria confiteria;

    public Mozo(String n, Confiteria confi) {
        nombre = n;
        confiteria = confi;

    }

    public void run() {

        while (true) {
            try {
                confiteria.atender(nombre);
            } catch (InterruptedException ex) {
                Logger.getLogger(Mozo.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
