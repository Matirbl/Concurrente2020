/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tp3.Punto3;

/**
 *
 * @author Chino
 */
public class HiloImprime implements Runnable {

    VariableCompartida var;

    public HiloImprime(VariableCompartida a) {
        var = a;
    }

    public void run() {
        int i = 0;
        while (i < 8) {
            var.imprimir();
            i++;
        }
    }
}
