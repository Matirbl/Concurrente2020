/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ParcialPunto1;

/**
 *
 * @author Chino
 */
public class main {

    public static void main(String[] args) {
        Comedor unComedor = new Comedor(18);

        Thread[] perros = new Thread[20];
        Thread[] gatos = new Thread[20];

        for (int i = 0; i < gatos.length; i++) {
            perros[i] = new Thread(new Perro("Perro " + i, unComedor));
        }

        for (int i = 0; i < gatos.length; i++) {
            gatos[i] = new Thread(new Perro("Gato " + i, unComedor));

        }

        for (int i = 0; i < gatos.length; i++) {
            perros[i].start();
        }

        for (int i = 0; i < gatos.length; i++) {
            gatos[i].start();
        }

    }
}
