/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tp3Punto5;

import Tp3Punto4.Surtidor;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Auto implements Runnable {

    private String patente;
    private Autopista miAutopista;
    private int decide;

    public Auto(String pat, Autopista unaAutopista, int a) {

        patente = pat;
        miAutopista = unaAutopista;
        decide = a;

    }

    public void run() {

        int i = 0;
        while (i < 10) {

            if (decide == 0) {
                try {
                    if (miAutopista.puedoSeguirDerecho()) {
                        System.out.println("El auto con pat " + patente + " sigue Derecho");

                        Thread.sleep(1000);

                    } else {
                        System.out.println("El auto con pat " + patente + " espera para seguir");
                        Thread.sleep(2000);
                    }
                } catch (InterruptedException ex) {
                    Logger.getLogger(Auto.class.getName()).log(Level.SEVERE, null, ex);
                }

            } else {
                try {
                    if (miAutopista.puedoGirar()) {
                        System.out.println("El auto con pat " + patente + " gira a la izq");

                        Thread.sleep(1000);

                    } else {
                        System.out.println("El auto con pat " + patente + " espera para girar");
                        Thread.sleep(2000);
                    }
                } catch (InterruptedException ex) {
                    Logger.getLogger(Auto.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            i++;
        }
    }
}
