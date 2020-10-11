/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp4Punto14;

import tp4Punto13.*;

/**
 *
 * @author Chino
 */
public class Main {

    public static void main(String[] args) {
        Confiteria pollosHermanos = new Confiteria();
        Thread[] empleados = new Thread[6];

        Thread mozo = new Thread(new Mozo("Juan", pollosHermanos));
        Thread cocinero1 = new Thread(new Cocinero("Hector", pollosHermanos));
        Thread cocinero2 = new Thread(new Cocinero("Julián", pollosHermanos));

        for (int i = 0; i < empleados.length; i++) {
            empleados[i] = new Thread(new Empleado("Empleado" + i, pollosHermanos));
        }
        for (int i = 0; i < empleados.length; i++) {
            empleados[i].start();
        }
        mozo.start();
        cocinero1.start();
        cocinero2.start();

    }

}
