/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SalaHemoterapiaLocks;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Chino
 */
public class Paciente implements Runnable {
    
    private String nombre;
    private Sala sala;
    
    public Paciente(Sala s, String n) {
        nombre = n;
        sala = s;
    }
    
    public void run() {
        
        try {
            sala.entrarSala(nombre);
            sala.donar(nombre);
            sala.salirSala(nombre);
        } catch (InterruptedException ex) {
            Logger.getLogger(Paciente.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
}
