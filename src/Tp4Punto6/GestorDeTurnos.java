/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tp4Punto6;

import java.util.concurrent.Semaphore;

/**
 *
 * @author Chino
 */
public class GestorDeTurnos {

    Semaphore a;
    Semaphore b;
    Semaphore c;

    public GestorDeTurnos() {
        a = new Semaphore(1);
        b = new Semaphore(0);
        c = new Semaphore(0);
    }

    public void imprimir(char letra, int cantidad) throws InterruptedException {

        if (letra == 'A') {
            a.acquire();

            for (int i = 0; i < cantidad; i++) {
                System.out.print("A");
            }
            b.release();
        }
        if (letra == 'B') {
            b.acquire();
            for (int i = 0; i < cantidad; i++) {
                System.out.print("B");
            }
            c.release();
        }
        if (letra == 'C') {
            c.acquire();
            for (int i = 0; i < cantidad; i++) {
                System.out.print("C");
            }
            a.release();
        }

    }

}
