/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tp3.Punto3;

public class Main {

    public static void main(String[] args) {

        VariableCompartida var = new VariableCompartida();
        
       Thread h1 = new Thread( new HiloImprime(var));
       Thread h2 = new Thread( new HiloImprime(var));
       Thread h3 = new Thread( new HiloImprime(var));
        
        
        
        h1.start();
        h2.start();
        h3.start();
        
        
    }
}
