/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PuchetaFAI1648Parcial2;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Chino
 */
public class Consumidor implements Runnable {

    private RecursoCompartido miRecurso;

    public Consumidor(RecursoCompartido unRecurso) {
        miRecurso = unRecurso;
    }

    public void run() {

        while (true) {
            try {
                System.out.println("\u001B[33m" + "El consumidor trata de consumir un elemento");
                Object elemento = miRecurso.extraer();
                System.out.println("\u001B[33m" + "El consumidor saca el elemento: " + elemento);
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
                Logger.getLogger(Consumidor.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
