/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp4Punto13;

import java.util.concurrent.Semaphore;

/**
 *
 * @author Chino
 */
public class Confiteria {

    private Semaphore SemEmpleado;
    private Semaphore SemMozo;
    private Semaphore SemCocinero;
    private Semaphore SemComida;

    public Confiteria() {
        SemEmpleado = new Semaphore(1);
        SemMozo = new Semaphore(0);
        SemCocinero = new Semaphore(0);
        SemComida = new Semaphore(0);

    }

    public void sentarse(String nom) throws InterruptedException {
        SemEmpleado.acquire();
        System.out.println("\u001B[32m El empleado:" + nom + " Se sienta el mesa");
        SemMozo.release();

    }

    public void comer() throws InterruptedException {
        SemComida.acquire();
        System.out.println("\u001B[32m Estoy comiendo");
        Thread.sleep(2000);

    }

    public void irse(String nom) {
        System.out.println("\u001B[32m" + nom + ": Terminé de comer, me voy ");
        SemEmpleado.release(2);
    }

    public void atender(String nom) throws InterruptedException {
        System.out.println("\u001B[31m El mozo: " + nom + " está esperando empleado, mientras inventa nuevas versiones de pollo");
        SemMozo.acquire();
        System.out.println("\u001B[31m El mozo: " + nom + "le lleva la lista al empleado y espera");
        Thread.sleep(4000);
        System.out.println("\u001B[31m El mozo: " + nom + "le lleva el pedido al cocinero y queda libre");
        SemCocinero.release();
    }

    public void cocinar(String nom) throws InterruptedException {
        SemCocinero.acquire();
        System.out.println("\u001B[33m "+ nom + ": está cocinando...");
        Thread.sleep(3000);
        System.out.println("\u001B[33m La comida está lista");
        SemComida.release();

    }

}
