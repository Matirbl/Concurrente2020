/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tp3Punto4.newpackage;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Chino
 */
public class Surtidor {

    int numero;

    public Surtidor(int num) {
        numero = num;

    }
    
    public synchronized void cargarNafta(String pat){
        
        try {
            System.out.println("El auto con patente: "+ pat + " está cargando nafta");
            Thread.sleep(1000);
        } catch (InterruptedException ex) {
            Logger.getLogger(Surtidor.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }

}
