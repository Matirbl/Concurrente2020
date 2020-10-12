/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tp4Punto7;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 *
 * @author Chino
 */
public class CentroImpresion {

    private Lock impresoraA;
    private Lock impresoraB;
    private Lock cerrojo;
    private int numA, numB;

    public CentroImpresion() {
        impresoraA = new ReentrantLock();
        impresoraB = new ReentrantLock();
        cerrojo = new ReentrantLock();
        numA = 2;
        numB = 1;
    }

    public boolean solicitarImpresionA(String nom) {
        boolean entra = false;
        impresoraA.lock();
        if (numA > 0) {
            System.out.println("El cliente: " + nom + " solicita impresión A");
            numA--;
            entra = true;
        } else {
            System.out.println("No hay impresora de tipo A disp." + nom + " se va");
        }
        impresoraA.unlock();
        return entra;
    }

    public boolean solicitarImpresionB(String nom) {
        boolean entra = false;
        impresoraB.lock();
        if (numB > 0) {
            System.out.println("El cliente: " + nom + " solicita impresión B");
            numB--;
            entra = true;
        } else {
            System.out.println("No hay impresora de tipo B disp." + nom + " se va");
        }
        impresoraB.unlock();
        return entra;
    }

    public void irseA(String nom) {
        impresoraA.lock();
        System.out.println("El cliente: " + nom + " terminó de imprimir");
        numA++;
        impresoraA.unlock();
    }

    public void irseB(String nom) {
        impresoraB.lock();
        System.out.println("El cliente: " + nom + " terminó de imprimir");
        numB++;
        impresoraB.unlock();
    }

    public void imprimir(String nom) throws InterruptedException {
        System.out.println(nom + " está imprimiendo");
        Thread.sleep(3000);

    }
}
