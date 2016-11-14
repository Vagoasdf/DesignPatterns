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
 * methodic siempre deja un 5 despues de trabajar.  Si es que va antes de un breaktrought simplemente lo deja listo.
 * Trabaja si es que la tarea es menor a 5.
 * avanza medianamente, y de manera sguro, entre 4 a 6
 */
public class Methodic extends knowledgeSource {

    
    private Random azar=new Random();
    public Methodic(String nombre, Blackboard blckBoard){
        super(blckBoard);
        this.nombre=nombre;
    }   
    @Override
    public boolean vaContribuir(){
        if (this.pizarra.Tarea<5){
            return true;
        }else return false;
    }
    @Override
    public void  contribuir(){
        
            pizarra.Progreso+=azar.nextInt(3)+4; //eager no ayuda mucho, pero ayuda casi siempre
            pizarra.Tarea=5; //eager lo puede dejar en cualquier punto
        
        
    }
    
}
