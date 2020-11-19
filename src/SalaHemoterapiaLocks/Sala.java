/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SalaHemoterapiaLocks;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 *
 * @author Chino
 */
public class Sala {

    private int sillas;
    private int revistas;
    private int camillas;
    private ReentrantLock entrada = new ReentrantLock(true);
    private ReentrantLock revista = new ReentrantLock(true);
    private Condition esperaCamilla = entrada.newCondition();
    private Condition esperaRevista = entrada.newCondition();

    public Sala() {
        sillas = 12;
        revistas = 9;
        camillas = 4;

    }

    public void entrarSala(String paciente) throws InterruptedException {
        entrada.lock();
        if (camillas > 0) {
            System.out.println("El paciente: " + paciente + " ocupo una camilla");
            camillas--;
            entrada.unlock();
        } else {
            esperar(paciente);
        }

    }

    public void esperar(String paciente) throws InterruptedException {

        if (sillas > 0) {
            sillas--;
            if (revistas > 0) {
                revistas--;
                System.out.println("El paciente: " + paciente + " Tomó una silla y una revista");
                esperaCamilla.await();
                sillas++;
                revistas++;
                esperaRevista.signal();
                camillas--;
            } else {
                System.out.println("El paciente: " + paciente + " Tomó una silla y mira tv");
                esperaRevista.await();
                revistas--;
                System.out.println("El paciente: " + paciente + " Tomó tomo una revista");
                esperaCamilla.await();
                sillas++;
                revistas++;
                esperaRevista.signal();
                camillas--;
            }
        } else if (revistas > 0) {
            revistas--;
            System.out.println("El paciente: " + paciente + " Está parado y lee una revista");
            esperaCamilla.await();
            revistas++;
            esperaRevista.signal();
            camillas--;
        } else {
            System.out.println("El paciente: " + paciente + " Está parado y mira tv");
            esperaRevista.await();
            revistas--;
            System.out.println("El paciente: " + paciente + " Tomó tomo una revista");
            esperaCamilla.await();
            revistas++;
            esperaRevista.signal();
            camillas--;
        }
        entrada.unlock();
    }

    public void donar(String paciente) throws InterruptedException {
        System.out.println("El paciente: " + paciente + " está donando sangre");
        Thread.sleep(4000);
    }

    public void salirSala(String paciente) {
        entrada.lock();
        System.out.println("El paciente: " + paciente + " se va");
        esperaCamilla.signal();
        camillas++;
        entrada.unlock();

    }
}
