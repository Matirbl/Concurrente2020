/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp4Punto9;

/**
 *
 * @author Chino
 */
public class Main {

    public static void main(String[] args) {
        Taxi unTaxi = new Taxi();
        Thread cliente3 = new Thread(new Cliente("Peluson", unTaxi));
        Thread cliente1 = new Thread(new Cliente("Matias Gustavo Pucheta", unTaxi));
        Thread cliente2 = new Thread(new Cliente("Carla", unTaxi));

        Thread cliente4 = new Thread(new Cliente("Stuart", unTaxi));
        Thread taxista1 = new Thread(new Taxista("ABC", unTaxi));
        taxista1.start();
        cliente3.start();
        cliente1.start();
        cliente2.start();
        cliente4.start();

    }
}
