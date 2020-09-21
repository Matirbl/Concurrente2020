/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tp3Punto5;

import java.util.logging.Level;
import java.util.logging.Logger;

public class Autopista {
//    public boolean giraIzq1;

    protected boolean giraIzq;
//    public boolean seguirDerecho1;
    protected boolean seguirDerecho;

    public Autopista() {
        giraIzq = true;
        seguirDerecho = false;
    }

    public synchronized boolean puedoGirar() {
        return giraIzq;
    }

    public synchronized boolean puedoSeguirDerecho() {
        return seguirDerecho;
    }

    public synchronized void cambiaSemaforo() {

        if (giraIzq) {
            giraIzq = false;    //equivale a que esté con luz roja
            seguirDerecho = true;//equivale a que esté con luz verde
        } else {
            seguirDerecho = false;
            giraIzq = true;
        }
    }

}
