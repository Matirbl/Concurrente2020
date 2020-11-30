/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PuchetaFAI1648Parcial2;

import java.util.logging.Level;
import java.util.logging.Logger;

public class Auto implements Runnable {

    private Estacionamiento miEstacionamiento;

    public Auto(Estacionamiento unEstacionamiento) {
        miEstacionamiento = unEstacionamiento;
    }

    public void run() {

        try {
            miEstacionamiento.subeAuto();
            miEstacionamiento.bajaAuto();
        } catch (InterruptedException ex) {
            Logger.getLogger(Auto.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        
        
        
        
        
    }

}
