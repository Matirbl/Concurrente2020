/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tp3Punto4;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Chino
 */
public class Auto implements Runnable {

    public String patente;
    protected String modelo;
    protected String marca;
    protected int kmActual;
    protected Surtidor surtidor;

    public Auto(Surtidor s, String pat) {
        patente = pat;
        kmActual = 0;
        modelo = null;
        surtidor = s;

    }

    public void run() {

        while (kmActual <= 20) {
            try {
                kmActual += 2;
                System.out.println("El auto con patente: " + patente + " está andando");
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
                Logger.getLogger(Auto.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
        surtidor.cargarNafta(patente);

    }
}
