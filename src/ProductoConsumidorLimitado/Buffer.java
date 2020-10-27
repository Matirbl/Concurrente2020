/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ProductoConsumidorLimitado;


import java.util.concurrent.Semaphore;
import Lineales.Dinamicas.Cola;
import utiles.Aleatorio;

/**
 *
 * @author Chino
 */
public class Buffer {

    private Semaphore buffer;
    private Semaphore productor;
    private Semaphore consumidor;

    public Buffer() {
        buffer = new Semaphore(1);
        productor = new Semaphore(10);
        consumidor = new Semaphore(0);

    }

    public void consumir() throws InterruptedException {
        consumidor.acquire();
        buffer.acquire();
        System.out.println("Quedan " + consumidor.availablePermits() + " productos");
        buffer.release();
        productor.release();
    }

    public void producir() throws InterruptedException {
        productor.acquire();
        buffer.acquire();
        System.out.println("Hay " + consumidor.availablePermits() + " productos");
        buffer.release();
        consumidor.release();
    }

}