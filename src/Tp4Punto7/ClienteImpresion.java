/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tp4Punto7;

import java.util.logging.Level;
import java.util.logging.Logger;
import utiles.Aleatorio;

/**
 *
 * @author Chino
 */
public class ClienteImpresion implements Runnable {

    private String nombre;
    private CentroImpresion imagen;

    public ClienteImpresion(String n, CentroImpresion c) {

        nombre = n;
        imagen = c;

    }

    public void run() {
        try {
            switch (Aleatorio.intAleatorio(0, 3)) {
                case 0:
                    System.out.println(nombre + " :Intenta imprimir tipoA");
                    if (imagen.solicitarImpresionA(nombre)) {
                        imagen.imprimir(nombre);
                        imagen.irseA(nombre);
                    }

                    break;
                case 1:
                    System.out.println(nombre + " :Intenta imprimir tipoB");
                    if (imagen.solicitarImpresionB(nombre)) {
                        imagen.imprimir(nombre);
                        imagen.irseB(nombre);
                    }
                    break;
                case 2:
                    System.out.println(nombre + " :Intenta imprimir tipoA o tipoB");
                    boolean res = imagen.solicitarImpresionA(nombre);
                    if (res) {
                        imagen.imprimir(nombre);
                        imagen.irseA(nombre);
                    } else {
                        if (imagen.solicitarImpresionB(nombre)) {
                            imagen.imprimir(nombre);
                            imagen.irseB(nombre);
                        }

                    }

                    break;
            }
        } catch (InterruptedException ex) {
            Logger.getLogger(ClienteImpresion.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
