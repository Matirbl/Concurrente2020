/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tp3Punto5;

public class main {

    public static void main(String[] args) {
        String[] abc = {"abc", "def", "ghi", "jkl", "mnñ", "opq"};
        Autopista a1 = new Autopista();
        Thread[] autos = new Thread[6];
        Thread cambiaSemaforo = new Thread(new CambiaSem(a1));

        for (int i = 0; i < autos.length; i++) {
            autos[i] = new Thread(new Auto(abc[i], a1, i % 2));
        }
        for (int i = 0; i < autos.length; i++) {
            autos[i].start();

        }
        cambiaSemaforo.start();
    }
}
