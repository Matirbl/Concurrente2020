/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tp3Punto5;

import java.util.logging.Level;
import java.util.logging.Logger;

public class CambiaSem implements Runnable {

    Autopista miAutopista;

    public CambiaSem(Autopista a1) {
        miAutopista = a1;
    }

    public void run() {
        int i = 0;
        while (i < 5) {
            try {
                miAutopista.cambiaSemaforo();
                System.out.println("Cambia semaforos");
                Thread.sleep(2000);
            } catch (InterruptedException ex) {
                Logger.getLogger(CambiaSem.class.getName()).log(Level.SEVERE, null, ex);
            }
            i++;
        }
    }

}
