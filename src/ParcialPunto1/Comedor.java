/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ParcialPunto1;

import java.util.concurrent.Semaphore;

/**
 *
 * @author Chino
 */
public class Comedor {

    private char especie;         //Variable para ver que especie está comiendo
    private int cantMaxMismaEspecie;    //Cantidad máxima de una misma raza comiendo
    private int comieronMismaEspecie;  //Contador de una misma raza comiendo
    private int platosLibres;         //Cantidad que pueden comer simultaneamente 
    private int totalPlatos;
    private Semaphore mutex;

    public Comedor(int platos) {
        mutex = new Semaphore(1);
        totalPlatos = platos;
        platosLibres = totalPlatos;
        cantMaxMismaEspecie = 10;
        comieronMismaEspecie = 0;
        especie = 'x';

    }

    public boolean entrar(char especieEntra, String nom) throws InterruptedException {
        boolean entre = false;
        mutex.acquire();
        if ((especie == 'p' || especie == 'x') && especieEntra == 'p' && platosLibres > 0) {
            especie = 'p';
            System.out.println("\u001B[32m" + nom + " intenta comer");
            if (comieronMismaEspecie < cantMaxMismaEspecie) {
                entre = true;
                platosLibres--;
            } else {
                especie = 'g';
                comieronMismaEspecie = 0;
            }
        } else if ((especie == 'g' || especie == 'x') && especieEntra == 'g' && platosLibres > 0) {
            especie = 'g';
            System.out.println("\u001B[32m" + nom + " intenta comer");
            if (comieronMismaEspecie < cantMaxMismaEspecie && platosLibres > 0) {
                entre = true;
                platosLibres--;
            } else {
                especie = 'p';
                comieronMismaEspecie = 0;
            }
        }
        mutex.release();
        return entre;
    }

    public void comiendo(String nom) throws InterruptedException {
        System.out.println("\u001B[33m El animal: " + nom + " está comiendo");
        Thread.sleep(3000);
    }

    public void irse(String nom) throws InterruptedException {
        mutex.acquire();
        System.out.println("\u001B[31m El animal: " + nom + " se va");
        platosLibres++;
        if (platosLibres == totalPlatos) {
            especie = 'x';
        }
        comieronMismaEspecie++;
        mutex.release();
    }

}
