/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ProductorConsumidorSynchonousQueue;

import ProductorConsumidor.*;
import Lineales.Dinamicas.Lista;
import java.util.concurrent.SynchronousQueue;

/**
 *
 * @author Chino
 */
public class main {

    public static void main(String[] args) {

        SynchronousQueue cola = new SynchronousQueue();

        BufferSynchro recurso = new BufferSynchro(cola);

        Thread[] consumidores = new Thread[1];
        Thread[] productores = new Thread[20];

        for (int i = 0; i < consumidores.length; i++) {
            consumidores[i] = new Thread(new ConsumidorSyn("Consumidor " + i, recurso));

        }
        for (int i = 0; i < productores.length; i++) {
            productores[i] = new Thread(new ProductorSyn("Productor " + i, recurso));

        }
        for (int i = 0; i < productores.length; i++) {
            productores[i].start();

        }
        for (int i = 0; i < consumidores.length; i++) {
            consumidores[i].start();

        }

    }

}
