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
public class Empleado implements Runnable {

    private String nombre;
    private Confiteria confiteria;

    public Empleado(String n, Confiteria confi) {
        confiteria = confi;
        nombre = n;

    }

    public void run() {
        try {
            confiteria.sentarse(nombre);
            confiteria.comer();
            confiteria.irse(nombre);

        } catch (InterruptedException ex) {
            Logger.getLogger(Empleado.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
