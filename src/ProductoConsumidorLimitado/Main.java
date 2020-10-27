/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ProductoConsumidorLimitado;

/**
 *
 * @author Chino
 */
public class Main {

    public static void main(String[] args) {

        Buffer recurso = new Buffer();

        Thread[] consumidores = new Thread[8];
        Thread[] productores = new Thread[2];

        for (int i = 0; i < consumidores.length; i++) {
            consumidores[i] = new Thread(new Consumidor("Consumidor " + i, recurso));

        }
        for (int i = 0; i < productores.length; i++) {
            productores[i] = new Thread(new Productor("Productor " + i, recurso));

        }
        for (int i = 0; i < productores.length; i++) {
            productores[i].start();

        }
        for (int i = 0; i < consumidores.length; i++) {
            consumidores[i].start();

        }

    }

}
