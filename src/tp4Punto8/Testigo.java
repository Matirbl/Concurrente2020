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
import java.util.Random;
import java.util.concurrent.Semaphore;

/**
 *
 * @author Chino
 */
public class Testigo {

    private Semaphore testigo1;
    private Semaphore testigo2;
    private Semaphore testigo3;
    private Semaphore testigo4;


    public Testigo() {
        testigo1 = new Semaphore(1);
        testigo2 = new Semaphore(0);
        testigo3 = new Semaphore(0);
        testigo4 = new Semaphore(0);
    }

    public void correr(String nombreAtleta, int turno) throws InterruptedException {

        if (turno == 1) {
            Random random = new Random();
            int segundos = (random.nextInt(3) + 9) * 1000;

            testigo1.acquire();

            System.out.println(
                    "EL ATLETA CON NOMBRE: " + nombreAtleta + " COMIENZA A CORRER");
            Thread.sleep(segundos);

            System.out.println(
                    "EL ATLETA TARDO: " + segundos/1000+ " segundos EN CORRER , AHORA PASA EL TESTIGO");
            testigo2.release();
        }
        if (turno == 2) {
            Random random = new Random();
            int segundos = (random.nextInt(3) + 9) * 1000;
            testigo2.acquire();
            System.out.println("EL ATLETA CON NOMBRE: " + nombreAtleta + " COMIENZA A CORRER");
            Thread.sleep(segundos);
            System.out.println("EL ATLETA TARDO: " + segundos/1000 + " segundos  EN CORRER , AHORA PASA EL TESTIGO");
            testigo3.release();
        }
        if (turno == 3) {
            Random random = new Random();
            int segundos = (random.nextInt(3) + 9) * 1000;
            testigo3.acquire();
            System.out.println("EL ATLETA CON NOMBRE: " + nombreAtleta + " COMIENZA A CORRER");
            Thread.sleep(segundos);
            System.out.println("EL ATLETA TARDO: " + segundos/1000 + " segundos EN CORRER , AHORA PASA EL TESTIGO");
            testigo4.release();
        }
        if (turno == 4) {
            Random random = new Random();
            int segundos = (random.nextInt(3) + 9) * 1000;
            testigo4.acquire();
            System.out.println("EL ATLETA CON NOMBRE: " + nombreAtleta + " COMIENZA A CORRER");
            Thread.sleep(segundos);
            System.out.println("EL ATLETA TARDO: " + segundos/1000 + " segundos EN CORRER , LLEGO A LA META");

        }

    }
}
