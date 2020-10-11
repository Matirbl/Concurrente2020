/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp4Punto14;

import tp4Punto13.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import utiles.Aleatorio;

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
            switch (utiles.Aleatorio.intAleatorio(1, 4)) {
                case 1:
                    System.out.println(nombre + " Intenta pedir bebida");
                    confiteria.sentarse(nombre);
                    confiteria.solicitarBebida(nombre);
                    confiteria.irse(nombre);
                    break;
                case 2:
                     System.out.println(nombre + " Intenta pedir comida");
                    confiteria.sentarse(nombre);
                    confiteria.solicitarComida(nombre);
                    confiteria.comer();
                    confiteria.irse(nombre);
                    break;
                case 3:
                     System.out.println(nombre + " Intenta pedir bebida y comida");
                    confiteria.sentarse(nombre);
                    confiteria.solicitarBebida(nombre);
                    confiteria.solicitarComida(nombre);
                    confiteria.comer();
                    confiteria.irse(nombre);
                    break;
            }
        } catch (InterruptedException ex) {
            Logger.getLogger(Empleado.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
