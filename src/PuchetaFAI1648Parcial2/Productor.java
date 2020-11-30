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
public class Productor implements Runnable {

    private RecursoCompartido miRecurso;

    public Productor(RecursoCompartido unRecurso) {
        miRecurso = unRecurso;
    }

    public void run() {
        int elemento = 0;
        while (true) {
            try {
                miRecurso.poner(elemento);
                System.out.println("\u001B[32m" + "El productor trata de agregar un elemento");
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
                Logger.getLogger(Productor.class.getName()).log(Level.SEVERE, null, ex);
            }
            elemento++;
        }

    }
}
