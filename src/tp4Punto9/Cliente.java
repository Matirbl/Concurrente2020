/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp4Punto9;

/**
 *
 * @author Chino
 */
import java.util.logging.Level;
import java.util.logging.Logger;

public class Cliente implements Runnable{
    Taxi taxi;

    private String nombre;

    public Cliente(String nom, Taxi desti) {
        taxi=desti;
        nombre = nom;
    }
   
    public void run(){
        try {
            taxi.tomarTaxi(nombre);
        } catch (InterruptedException ex) {
            Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
