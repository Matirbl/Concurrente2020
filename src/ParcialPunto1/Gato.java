/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ParcialPunto1;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Chino
 */
public class Gato implements Runnable {

    private char especie;
    private String nombre;
    private Comedor miComedor;

    public Gato(String nom, Comedor c) {
        nombre = nom;
        miComedor = c;
        especie = 'g';

    }

    public void run() {
        boolean entre = false;
        //La espera es activa porque decía que todos debían comer, es decir, si no puede comer, vuelve en un rato.
        while (!entre) {
            try {
                entre = miComedor.entrar(especie,nombre);
                if (entre) {
                    miComedor.comiendo(nombre);
                    miComedor.irse(nombre);
                }

            } catch (InterruptedException ex) {
                Logger.getLogger(Gato.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }
}
