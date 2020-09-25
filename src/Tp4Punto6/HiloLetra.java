/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tp4Punto6;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Chino
 */
public class HiloLetra implements Runnable {

    char letra;
    int repeticion;
    GestorDeTurnos gestor;

    public HiloLetra(char l, int n, GestorDeTurnos g) {
        letra = l;
        repeticion = n;
        gestor = g;
    }

    public void run() {
        try {
            int i = 0;
            while (i < 10) {
                gestor.imprimir(letra, repeticion);
                i++;
            }
        } catch (InterruptedException ex) {
            Logger.getLogger(HiloLetra.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
