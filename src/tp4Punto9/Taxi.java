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
import java.util.concurrent.Semaphore;


public class Taxi {

    private Semaphore taxista;
    private Semaphore cliente;
    private Semaphore llegada;

    public Taxi() {
        cliente = new Semaphore(1);
        taxista = new Semaphore(0);
        llegada = new Semaphore(0);

    }

    public void irDestino(String pat) throws InterruptedException {
         taxista.acquire();
         System.out.println("El taxista con patente " + pat+  "  inicia viaje");
         Thread.sleep(2000);
         System.out.println("El taxista llega a destino");
         llegada.release();
         cliente.release();
          
    }

    public void tomarTaxi(String nom) throws InterruptedException {
        cliente.acquire();
        taxista.release();
        System.out.println("El cliente " + nom + " sube al taxi ");
        llegada.acquire();
//        System.out.println("El cliente "+ nom + " baja del taxi");

    } 
}
