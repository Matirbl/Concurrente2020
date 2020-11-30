/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PuchetaFAI1648Parcial2;

class Nodo {
    //atributos

    private Object elemento;
    private Nodo enlace;

    //constructor
    public Nodo(Object elem, Nodo enlace) {
        this.elemento = elem;
        this.enlace = enlace;
    }

    public Nodo(Object elem) {
        this.elemento = elem;
        this.enlace = null;
    }
//observadoras


    public Object getElemento() {
        return this.elemento;
    }

    public Nodo getEnlace() {
        return this.enlace;
    }
//modificadoras

    public void setElemento(Object elemento) {
        this.elemento = elemento;
    }

    public void setEnlace(Nodo enlace) {
        this.enlace = enlace;
    }
}
