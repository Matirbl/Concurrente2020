/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ProblemaSaludo;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Chino
 */
public class Personal implements Runnable {

    private String nombre;
    private Saludo saludo;
    private boolean esJefe;
    static int llegaron = 0;
    private int numEmp;

    Personal(Saludo s, String n) {
        esJefe = false;
        nombre = n;
        saludo = s;
    }

    Personal(Saludo s, String n, int x) {
        esJefe = true;
        nombre = n;
        saludo = s;
        numEmp = x;
    }

    public void run() {
        System.out.println("(" + nombre + " llega)");
        if (esJefe) {
            while (llegaron < numEmp) {
                System.out.println("Esperando...");
            }
            saludo.saludoJefe();

        } else {
            synchronized (this) {
                llegaron++;
            }
            saludo.esperarJefe(nombre);
        }
    }
}
