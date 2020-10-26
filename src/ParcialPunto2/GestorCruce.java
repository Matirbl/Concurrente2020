/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ParcialPunto2;

import java.util.concurrent.Semaphore;

/**
 *
 * @author Chino
 */
public class GestorCruce {

    Semaphore entradaOeste;
    Semaphore entradaNorte;
    Semaphore mutex;
    int cantNorte;
    int cantOeste;

    public GestorCruce() {
        mutex = new Semaphore(1);
        entradaNorte = new Semaphore(0);
        entradaOeste = new Semaphore(0);
        cantNorte = 0;
        cantOeste = 0;

    }

    public void llegaNorte(String nom) throws InterruptedException {
        mutex.acquire();
        cantNorte++;
        System.out.println(nom + " llega desde norte para cruzar");
        entradaNorte.acquire();
        mutex.release();

    }

    public void llegaOeste(String nom) throws InterruptedException {
        mutex.acquire();
        cantOeste++;
        System.out.println(nom + " llega desde norte para cruzar");
        entradaOeste.acquire();
        mutex.release();

    }

    public void cruzando(String nom) throws InterruptedException {
        System.out.println(nom + " está cruzando");
        Thread.sleep(3000);
    }

    public void llegaSur(String nom) throws InterruptedException {
        mutex.acquire();
        System.out.println(nom + " sale por el Sur");
        entradaNorte.release();
        cantNorte--;
        mutex.release();

    }

    public void llegaEste(String nom) throws InterruptedException {
        mutex.acquire();
        System.out.println(nom + " sale por el Este");
        entradaOeste.release();
        cantOeste--;
        mutex.release();
    }

    public void iniciaNorte() {
        entradaNorte.release();
    }

    public void iniciaOeste() {
        entradaNorte.release();
    }

    public void cambiarSemaforos() {
        System.out.println("El gestor cambia los semaforos");
        if (entradaNorte.tryAcquire()) {
            entradaOeste.release();
        } else if (entradaOeste.tryAcquire()) {
            entradaNorte.release();
        }
    }
}
