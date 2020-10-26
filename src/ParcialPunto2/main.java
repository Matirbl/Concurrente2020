/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ParcialPunto2;

/**
 *
 * @author Chino
 */
public class main {

    public static void main(String[] args) {
        GestorCruce gestor = new GestorCruce();
        Thread cont = new Thread(new Control(gestor));
        Thread[] autos = new Thread[10];
        for (int i = 0; i < autos.length; i++) {
            autos[i] = new Thread(new Auto("Auto " + i, gestor));

        }
        cont.start();
        for (int i = 0; i < autos.length; i++) {
            autos[i].start();

        }
    }
}
