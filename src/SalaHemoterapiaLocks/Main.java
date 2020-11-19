/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SalaHemoterapiaLocks;

/**
 *
 * @author Chino
 */
public class Main {

    public static void main(String[] args) {

        Sala unaSala = new Sala();

        Thread[] pacientes = new Thread[20];

        for (int i = 0; i < pacientes.length; i++) {
            pacientes[i] = new Thread(new Paciente(unaSala, " p " + i));

        }
        for (int i = 0; i < pacientes.length; i++) {
            pacientes[i].start();

        }

    }

}
