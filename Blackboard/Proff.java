/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package blackboardish;

import java.util.Random;

/**
 *
 * @author Bruno
 * Proff siempre deja un 2 como clase final, no es bueno dejarlo junto a eager
 * sin embargo, avanza una cantidad posiblemente alta (de 0 a 10)
 *  Contribuira siempre y cuando la tarea no sea un 3. Por alguna razon prefiere
 * dejarsela al ayudante (?)
 */
public class Proff extends knowledgeSource{
   
  
    private Random azar=new Random();
    public Proff(String nombre, Blackboard blckBoard){
        super(blckBoard);
        this.nombre=nombre;
    }   
    @Override
    public boolean vaContribuir(){
        if (this.pizarra.Tarea!=3){
            return true;
        }else return false;
    }
    @Override
    public void  contribuir(){
       
            pizarra.Progreso+=azar.nextInt(10); //eager no ayuda mucho, pero ayuda casi siempre
            pizarra.Tarea=2; //eager lo puede dejar en cualquier punto
        
        
    }
    
}
