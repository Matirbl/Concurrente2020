/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ParcialPunto2;

import java.util.logging.Level;
import java.util.logging.Logger;
import utiles.Aleatorio;

/**
 *
 * @author Chino
 */
public class Auto implements Runnable {

    private String nom;
    private GestorCruce gestor;

    public Auto(String n, GestorCruce g) {
        nom = n;
        gestor = g;
    }

    public void run() {
        try {
            switch (Aleatorio.intAleatorio(0, 2)) {
                case 1:
                    gestor.llegaNorte(nom);
                    gestor.cruzando(nom);
                    gestor.llegaSur(nom);
                    break;
                case 2:
                    gestor.llegaOeste(nom);
                    gestor.cruzando(nom);
                    gestor.llegaEste(nom);
                break;    
            }
        } catch (InterruptedException ex) {
            Logger.getLogger(Auto.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}

