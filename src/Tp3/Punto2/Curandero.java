/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tp3.Punto2;


public class Curandero extends Thread {
   Jugador j1;
   
   public Curandero(Jugador jugador1){
       j1= jugador1;
   }
   
   
   public void curar (){
       
       j1.setVida((j1.obtenerVida())+3); 
       
       System.out.println("Vida curada, VIDA: " + j1.obtenerVida());
   }
    
   public void run(){
       
      this.curar();
   }
    
}
