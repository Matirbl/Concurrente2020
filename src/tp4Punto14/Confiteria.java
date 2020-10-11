/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp4Punto14;

import tp4Punto13.*;
import java.util.concurrent.Semaphore;

/**
 *
 * @author Chino
 */
public class Confiteria {

    private Semaphore semMesa;
    private Semaphore SemMozo;
    private Semaphore SemCocinero;
    private Semaphore SemComida;
    private Semaphore BebidaEntregada;

    public Confiteria() {
        semMesa = new Semaphore(2);
        SemMozo = new Semaphore(0);
        SemCocinero = new Semaphore(0);
        SemComida = new Semaphore(0);
        BebidaEntregada = new Semaphore(0);

    }

    public void sentarse(String nom) throws InterruptedException {
        semMesa.acquire();
        System.out.println("\u001B[32m El empleado:" + nom + " Se sienta el mesa");
    }

    public void solicitarBebida(String nom) throws InterruptedException {
        SemMozo.release();
        System.out.println(nom + " : Solicita bebida");
        BebidaEntregada.acquire();
    }

    public void solicitarComida(String nom) {
        SemCocinero.release();
        System.out.println(nom + " : Solicita comida");
    }

    public void comer() throws InterruptedException {
        SemComida.acquire();
        System.out.println("\u001B[32m Estoy comiendo");
        Thread.sleep(2000);

    }

    public void irse(String nom) {
        System.out.println("\u001B[32m" + nom + ": Terminé de comer, me voy ");
        semMesa.release();
    }

    public void atender(String nom) throws InterruptedException {
        System.out.println("\u001B[31m El mozo: " + nom + " está esperando empleado, mientras inventa nuevas versiones de pollo");
        SemMozo.acquire();
        System.out.println("\u001B[31m El mozo: " + nom + "le lleva la lista al empleado y espera");
        Thread.sleep(3000);
        BebidaEntregada.release();
        System.out.println("Bebida entregada");

    }

    public void cocinar(String nom) throws InterruptedException {
        System.out.println("\u001B[31m El cocinero: " + nom + " está esperando orden, mientras ordena su cocina");
        SemCocinero.acquire();
        System.out.println("\u001B[33m " + nom + ": está cocinando...");
        Thread.sleep(3000);
        System.out.println("\u001B[33m La comida está lista");
        SemComida.release();

    }

}
