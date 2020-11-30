/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PuchetaFAI1648Parcial2;

/**
 *
 * @author Chino
 */
public class Main {

    public static void main(String[] args) {
        Estacionamiento unEstacionamiento = new Estacionamiento();
        int cantidadAutos = 100;
        Thread[] autos = new Thread[cantidadAutos];

        Thread Buque = new Thread(new Buque(unEstacionamiento));

        for (int i = 0; i < autos.length; i++) {
            autos[i] = new Thread(new Auto(unEstacionamiento));

        }
        for (int i = 0; i < autos.length; i++) {
            autos[i].start();

        }
        Buque.start();

    }

}
