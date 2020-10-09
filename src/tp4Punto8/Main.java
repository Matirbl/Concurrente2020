/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp4Punto8;

/**
 *
 * @author Chino
 */
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Chino
 */
public class Main {

    public static void main(String[] args) {
        Testigo bandera = new Testigo();
        Thread atleta1 = new Thread(new Atleta("Carla", 2, bandera));
        Thread atleta2 = new Thread(new Atleta("Matias", 1, bandera));
        Thread atleta3 = new Thread(new Atleta("Peluson", 4, bandera));
        Thread atleta4 = new Thread(new Atleta("Stuart", 3, bandera));
        atleta1.start();
        atleta2.start();
        atleta3.start();
        atleta4.start();

        try {
            atleta1.join();
            atleta2.join();
            atleta3.join();
            atleta4.join();
        } catch (InterruptedException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
