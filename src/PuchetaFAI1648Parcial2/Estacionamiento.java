/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PuchetaFAI1648Parcial2;

import java.util.concurrent.Semaphore;

/**
 *
 * @author Chino
 */
public class Estacionamiento {

    private int cantAutos, autosArriba;
    private Semaphore mutex, subenAutos, arrancaBuque, vuelveBuque, bajanAutos;

    public Estacionamiento() {
        cantAutos = 10;
        autosArriba = 0;
        mutex = new Semaphore(1);
        subenAutos = new Semaphore(cantAutos);
        bajanAutos = new Semaphore(0);
        arrancaBuque = new Semaphore(0);
        vuelveBuque = new Semaphore(0);
    }

    public void subeAuto() throws InterruptedException {
        subenAutos.acquire();
        mutex.acquire();
        autosArriba++;
        System.out.println("Autos arriba: " + autosArriba);
        if (autosArriba == cantAutos) {
            System.out.println("Sube el décimo auto ");
            arrancaBuque.release();;
        }
        mutex.release();
    }

    public void bajaAuto() throws InterruptedException {
        bajanAutos.acquire();
        mutex.acquire();
        autosArriba--;
        System.out.println("Autos arriba: " + autosArriba);
        mutex.release();
        if (autosArriba > 0) {
            bajanAutos.release();
        } else {
            vuelveBuque.release();
        }
    }

    public void arrancaBuque() throws InterruptedException {
        arrancaBuque.acquire();       //El buque espera a que el decimo auto le avise que arranque
        System.out.println("El buque arranca ");

    }

    public void viajando() throws InterruptedException {
        System.out.println("El buque está viajando......");
        Thread.sleep(3000);
        System.out.println("El buque llega a destino");
    }

    public void llegaBuque() throws InterruptedException {
        bajanAutos.release();
        vuelveBuque.acquire();
        System.out.println("El buque se prepara para volver");

    }

    public void resetearViaje() {
        System.out.println("El buque se prepara para un nuevo viaje ");
        subenAutos.release(10);
    }

}
