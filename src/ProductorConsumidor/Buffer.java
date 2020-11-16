/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ProductorConsumidor;

import java.util.concurrent.Semaphore;
import Lineales.Dinamicas.Lista;
import utiles.Aleatorio;

/**
 *
 * @author Chino
 */
public class Buffer {

    private Semaphore mutex;
    private Lista buffer;
    // private Semaphore productor;
    private Semaphore consumidor;

    public Buffer() {
        buffer = new Lista();
        mutex = new Semaphore(1);
        // productor = new Semaphore(1);
        consumidor = new Semaphore(0);

    }

    public void consumir() throws InterruptedException {
        consumidor.acquire();
        mutex.acquire();
        buffer.eliminar(1);
        System.out.println("Quedan " + buffer.longitud() + " productos");
        mutex.release();
        // productor.release();

    }

    public void producir(int elemento) throws InterruptedException {
        // productor.acquire();
        mutex.acquire();
        buffer.insertar(elemento, buffer.longitud() + 1);
        System.out.println("Hay " + buffer.longitud() + " productos");
        mutex.release();
        consumidor.release();
        // productor.release();

    }

}
