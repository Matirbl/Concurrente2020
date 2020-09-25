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
public class Main {

    public static void main(String[] args) {

        GestorDeTurnos g = new GestorDeTurnos();
        Thread a = new Thread(new HiloLetra('A', 1, g));
        Thread b = new Thread(new HiloLetra('B', 2, g));
        Thread c = new Thread(new HiloLetra('C', 3, g));

        a.start();
        b.start();
        c.start();

        try {
            a.join();
            b.join();
            c.join();
        } catch (InterruptedException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
