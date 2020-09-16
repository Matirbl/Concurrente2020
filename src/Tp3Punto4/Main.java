/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tp3Punto4;

/**
 *
 * @author Chino
 */
public class Main {

    public static void main(String[] args) {

        Surtidor surti = new Surtidor(1);
        String[] abc = {"abc", "def", "ghi", "jkl", "mnñ"};

        Thread[] autos = new Thread[5];

        for (int i = 0; i < autos.length; i++) {
            autos[i] = new Thread(new Auto(surti, abc[i]));

        }

        for (int i = 0; i < autos.length; i++) {
            autos[i].start();

        }

    }

}
