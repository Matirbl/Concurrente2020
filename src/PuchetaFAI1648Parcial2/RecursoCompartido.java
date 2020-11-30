/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PuchetaFAI1648Parcial2;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Chino
 */
public class RecursoCompartido {

    private String string1, string2;
    private Cola cola1, cola2;
    private ReentrantLock cerrojo;
    private final Condition esperar;

    public RecursoCompartido() {
        string1 = "Insertar";
        string2 = "Extraer";
        cola1 = new Cola(string1);   //Se modificó la clase cola para que pueda usar una etiqueta 
        cola2 = new Cola(string2);
        cerrojo = new ReentrantLock();
        esperar = cerrojo.newCondition();

    }

    public Object extraer() {
        Object elemento = null;
        cerrojo.lock();
        try {

            while (("Extraer".equals(cola1.getString()) && cola1.esVacia()) || ("Extraer".equals(cola2.getString()) && cola2.esVacia())) {
                //Si ambas colas están vacías se queda esperando a que un productor le avise.
                esperar.await();
            }
            //Cuando despierto verifico de cual cola tengo que extraer el elemento
            if ("Extraer".equals(cola1.getString())) {
                elemento = cola1.obtenerFrente();
                cola1.sacar();
                System.out.println("Se extrae un elemento de la cola1");
            } else {
                elemento = cola2.obtenerFrente();
                cola2.sacar();
                System.out.println("Se extrae un elemento de la cola2");
            }
            if (cola1.esVacia() || cola2.esVacia()) {
                oscilar();
            }
        } catch (InterruptedException ex) {
            Logger.getLogger(RecursoCompartido.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            cerrojo.unlock();
        }
        return elemento;
    }

    public void poner(Object elemento) {
        try {
            cerrojo.lock();
            if ("Insertar".equals(cola1.getString())) {
                cola1.poner(elemento);
                System.out.println("Se pone un elemento en la cola1");
                esperar.signalAll();
            } else {
                cola2.poner(elemento);
                System.out.println("Se pone un elemento en la cola2");
                esperar.signalAll();
            }
            //Esta oscilación fue a prueba y error, creo que es por como asigné las colas en el constructor.
            //No me funcionaba hasta que llame el método en esta parte

            if (cola1.esVacia() || cola2.esVacia()) {
                oscilar();
            }
        } catch (Exception e) {
        } finally {
            cerrojo.unlock();
        }
    }

    private void oscilar() {
        //Este método se encarga de cambiar las etiquetas
        String aux1 = cola1.getString();
        String aux2 = cola2.getString();
        System.out.println("Oscila, cola1 es :" + aux2 + " y cola2 es: " + aux1);
        cola1.setString(aux2);
        cola2.setString(aux1);

    }

}
