/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ProductorConsumidorSynchonousQueue;

import java.util.concurrent.SynchronousQueue;

/**
 *
 * @author Chino
 */
public class BufferSynchro {

    private SynchronousQueue cola;

    public BufferSynchro(SynchronousQueue c) {
        cola = c;
    }

    public Object consumir() throws InterruptedException {
        Object salida;
        salida = cola.take();
        return salida;
    }

    public void producir(Object elemento) throws InterruptedException {
        cola.put(elemento);
    }

}
