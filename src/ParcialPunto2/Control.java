/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ParcialPunto2;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Chino
 */
public class Control implements Runnable {

    GestorCruce gestor;

    public Control(GestorCruce g) {
        gestor = g;
    }

    public void run() {

        try {
            if (gestor.cantNorte > 0) {
                gestor.iniciaNorte();
            } else {
                gestor.iniciaOeste();
            }
            while (true) {
                gestor.cambiarSemaforos();
                Thread.sleep(2000);

            }

        } catch (InterruptedException ex) {
            Logger.getLogger(Control.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
