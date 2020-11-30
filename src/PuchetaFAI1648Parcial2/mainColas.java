/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PuchetaFAI1648Parcial2;

/**
 *
 * @author Chino
 */
public class mainColas {

    public static void main(String[] args) {

        RecursoCompartido nuevoRecurso = new RecursoCompartido();

        Thread productor = new Thread(new Productor(nuevoRecurso));
        productor.start();

        Thread consumidor = new Thread(new Consumidor(nuevoRecurso));
        consumidor.start();

    }
}
